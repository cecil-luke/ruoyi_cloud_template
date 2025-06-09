package com.szmtr.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.szmtr.common.redis.service.RedisService;
import com.szmtr.system.domain.PageResults;
import com.szmtr.system.domain.Rdsapps;
import com.szmtr.system.domain.vo.RdsAppsGroupMenuAccessVo;
import com.szmtr.system.domain.vo.RdsappsVo;
import com.szmtr.system.dto.RdsAppsMenuDto;
import com.szmtr.system.dto.RdsappsDto;
import com.szmtr.system.dto.query.RdsAppsMenuQuery;
import com.szmtr.system.dto.query.RdsappsQuery;
import com.szmtr.system.service.IRdsAppsMenuService;
import com.szmtr.system.service.IRdsappsService;
import com.szmtr.system.utils.ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName IRdsappsServiceImpl
 * @Author Lss
 * @Date 2025/5/20
 * @Description: RDS应用定义服务层实现
 */
@Service
public class RdsappsServiceImpl implements IRdsappsService {

    private static final String RDSAPPS = "rdsapps:";

    @Autowired
    private RedisService redisService;

    @Autowired
    public RedisTemplate redisTemplate;

    @Autowired
    private IRdsAppsMenuService rdsAppsMenuService;

    @Override
    public void addOrUpdate(RdsappsDto param) {
        if (StrUtil.isNotBlank(param.getId())) {
            update(param);
            return;
        }

        Rdsapps rdsapps = new Rdsapps();
        BeanUtil.copyProperties(param, rdsapps);
        ModelUtil.fillCreateFields(rdsapps);

        String hashKey = RDSAPPS + rdsapps.getId();

        // 存储主数据到Hash（解决ClassCastException问题）
        Map<String, String> safeMap = BeanUtil.beanToMap(rdsapps)
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> String.valueOf(e.getValue())
                ));
        redisService.setCacheMap(hashKey, safeMap);

        // 维护Set索引
        redisService.setCacheSet("index:menuType:" + rdsapps.getMenuType(), Set.of(hashKey));
        redisService.setCacheSet("index:rdsModule:" + rdsapps.getRdsModule(), Set.of(hashKey));

        // 维护ZSet索引（需扩展RedisService）
        redisService.addZSet("index:rdsSeqNum", hashKey, rdsapps.getRdsSeqNum());
        redisService.addZSet("index:menuName", rdsapps.getRdsAppName(), 0);

        // 保存功能按钮
        List<RdsAppsMenuQuery> menuList = param.getMenuList();
        List<RdsAppsMenuDto> dtoList = new ArrayList<>();
        menuList.stream().forEach(query -> {
            RdsAppsMenuDto dto = new RdsAppsMenuDto();
            BeanUtil.copyProperties(query, dto);
            dto.setRdsappsId(rdsapps.getId());
            dtoList.add(dto);
        });
        rdsAppsMenuService.addByBatch(dtoList);
    }

    @Override
    public void deleteById(String id) {
        String hashKey = RDSAPPS + id;

        // 获取旧数据
        Map<String, String> oldData = redisService.getCacheMap(hashKey);

        // 删除主数据
        redisService.deleteObject(hashKey);

        // 删除索引
        redisService.getCacheSet("index:menuType:" + oldData.get("menuType")).remove(hashKey);
        redisService.getCacheSet("index:rdsModule:" + oldData.get("rdsModule")).remove(hashKey);
        redisService.removeZSet("index:rdsSeqNum", hashKey);
        redisService.removeZSet("index:menuName", oldData.get("rdsAppName"));
    }

    public void update(RdsappsDto param) {
        String hashKey = RDSAPPS + param.getId();
        Map<String, String> oldData = redisService.getCacheMap(hashKey);

        // 删除旧索引
        redisService.getCacheSet("index:menuType:" + oldData.get("menuType")).remove(hashKey);
        redisService.getCacheSet("index:rdsModule:" + oldData.get("rdsModule")).remove(hashKey);
        redisService.removeZSet("index:rdsSeqNum", hashKey);
        redisService.removeZSet("index:menuName", oldData.get("rdsAppName"));

        // 更新主数据
        Rdsapps rdsapps = com.alibaba.fastjson.JSON.parseObject(JSON.toJSONString(oldData), Rdsapps.class);

        BeanUtil.copyProperties(param, rdsapps, CopyOptions.create().ignoreNullValue());
        ModelUtil.fillUpdateFields(rdsapps);
        Map<String, String> safeMap = BeanUtil.beanToMap(rdsapps)
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> String.valueOf(e.getValue())
                ));
        redisService.setCacheMap(hashKey, safeMap);

        // 添加新索引
        redisService.setCacheSet("index:menuType:" + rdsapps.getMenuType(), Set.of(hashKey));
        redisService.setCacheSet("index:rdsModule:" + rdsapps.getRdsModule(), Set.of(hashKey));
        redisService.addZSet("index:rdsSeqNum", hashKey, rdsapps.getRdsSeqNum());
        redisService.addZSet("index:menuName", rdsapps.getRdsAppName(), 0);

        // 更新功能按钮
        rdsAppsMenuService.deleteByRdsappsId(param.getId());
        List<RdsAppsMenuQuery> menuList = param.getMenuList();
        List<RdsAppsMenuDto> dtoList = new ArrayList<>();
        menuList.stream().forEach(query -> {
            RdsAppsMenuDto dto = new RdsAppsMenuDto();
            BeanUtil.copyProperties(query, dto);
            dto.setRdsappsId(param.getId());
            dtoList.add(dto);
        });
        rdsAppsMenuService.addByBatch(dtoList);
    }

    @Override
    public PageResults<Rdsapps> page(RdsappsQuery query) {
        int page = query.getPage();
        int pageSize = query.getPageSize();

        // 获取所有数据键（模式匹配方式）
        Set<String> allKeys = new HashSet<>(redisService.keys(RDSAPPS + "*"));
        List<String> keyList = new ArrayList<>(allKeys);

        // 简单分页计算（不依赖任何排序）
        int total = keyList.size();
        int start = Math.max(0, (page - 1) * pageSize);
        int end = Math.min(start + pageSize, total);
        List<String> pageKeys = keyList.subList(start, end);

        // 管道批量获取数据（优化网络开销）
        List<Rdsapps> data = new ArrayList<>();
        for (String key : pageKeys) {
            String id = key.replace(RDSAPPS, "");
            Rdsapps rdsapps = getById(id);
            if (rdsapps != null) {
                data.add(rdsapps);
            }
        }

        // 分页元数据
        int totalPages = (int) Math.ceil((double)total / pageSize);
        return new PageResults<>(data, total, page, pageSize, totalPages);
    }

    @Override
    public Rdsapps getById(String id) {
        String hashKey = RDSAPPS + id;
        Map<String, String> dataMap = redisService.getCacheMap(hashKey);
        if (dataMap == null || dataMap.isEmpty()) {
            return null;
        }

        // 清理无效字段值
        dataMap.replaceAll((k, v) -> "null".equalsIgnoreCase(v) ? null : v);
        dataMap.values().removeIf(StrUtil::isBlank);

        // 安全转换（配置忽略空值）
        return BeanUtil.mapToBean(
                dataMap,
                Rdsapps.class,
                false,
                CopyOptions.create()
                        .ignoreNullValue()
                        .setFieldValueEditor((fieldKey, fieldValue) -> {
                            // 处理字符串"null"的显式转换
                            return "null".equals(fieldValue) ? null : fieldValue;
                        })
        );
    }

    @Override
    public List<RdsappsVo> getByMenuType(String menutype) {
        // 从索引集合获取所有关联的Redis键
        String indexKey = "index:menuType:" + menutype;
        Set<String> menuKeys = redisService.getCacheSet(indexKey);
        if (CollectionUtils.isEmpty(menuKeys)) {
            return Collections.emptyList();
        }

        // 管道批量获取Hash数据
        List<Object> results = redisService.executePipeline(connection -> {
            RedisSerializer<String> keySerializer = redisTemplate.getKeySerializer();
            menuKeys.forEach(key -> {
                byte[] serializedKey = keySerializer.serialize(key);
                connection.hGetAll(serializedKey);
            });
            return null;
        });

        // 数据转换
        String jsonStr = JSON.toJSONString(results.stream()
                .filter(obj -> obj instanceof Map && !((Map<?,?>)obj).isEmpty())
                .collect(Collectors.toList()));

        return JSON.parseObject(jsonStr,
                new TypeReference<List<RdsappsVo>>(){});
    }
}
