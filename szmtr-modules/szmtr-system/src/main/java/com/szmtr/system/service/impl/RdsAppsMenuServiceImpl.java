package com.szmtr.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.szmtr.common.redis.service.RedisService;
import com.szmtr.system.domain.PageResults;
import com.szmtr.system.domain.RdsAppsMenu;
import com.szmtr.system.domain.vo.RdsAppsGroupMenuAccessVo;
import com.szmtr.system.domain.vo.RdsAppsMenuVo;
import com.szmtr.system.dto.RdsAppsMenuDto;
import com.szmtr.system.dto.query.RdsAppsGroupMenuAccessQuery;
import com.szmtr.system.dto.query.RdsAppsMenuPageQuery;
import com.szmtr.system.dto.query.RdsAppsMenuUpdateQuery;
import com.szmtr.system.service.IRdsAppsGroupMenuService;
import com.szmtr.system.service.IRdsAppsMenuService;
import com.szmtr.system.utils.ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName RdsAppsMenuServiceImpl
 * @Author Lss
 * @Date 2025/5/26
 * @Description: RDS应用定义功能按钮服务层实现
 */
@Service
public class RdsAppsMenuServiceImpl implements IRdsAppsMenuService {

    private static final String RDSAPPS_MENU_PREFIX = "rdsappsmenu:";
    private static final String INDEX_RDSAPPS_ID = "index:rdsappsId:";

    @Autowired
    private RedisService redisService;

    @Autowired
    private IRdsAppsGroupMenuService rdsAppsGroupMenuService;

    @Override
    public void addByBatch(List<RdsAppsMenuDto> paramList) {
        paramList.forEach(dto -> {
            // 构建实体对象
            RdsAppsMenu entity = new RdsAppsMenu();
            BeanUtil.copyProperties(dto, entity);
            ModelUtil.fillCreateFields(entity);

            String hashKey = RDSAPPS_MENU_PREFIX + entity.getId();

            // 存储主数据
            Map<String, String> safeMap = BeanUtil.beanToMap(entity)
                    .entrySet().stream()
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            e -> String.valueOf(e.getValue())
                    ));
            redisService.setCacheMap(hashKey, safeMap);

            // 维护索引
            redisService.addCacheSet(INDEX_RDSAPPS_ID + dto.getRdsappsId(), hashKey);
        });
    }

    @Override
    public void deleteByRdsappsId(String rdsappsId) {
        String indexKey = INDEX_RDSAPPS_ID + rdsappsId;
        Set<String> menuKeys = redisService.getCacheSet(indexKey);

        // 管道批量删除
        redisService.executePipeline(connection -> {
            menuKeys.forEach(key -> {
                connection.del(key.getBytes()); // 删除主数据
                connection.sRem(indexKey.getBytes(), key.getBytes()); // 删除索引
            });
            return null;
        });
    }

    @Override
    public PageResults<RdsAppsMenuVo> pageByRdsappsId(RdsAppsMenuPageQuery param) {
        String indexKey = INDEX_RDSAPPS_ID + param.getRdsappsId();
        Set<String> allKeys = redisService.getCacheSet(indexKey);
        List<String> keyList = new ArrayList<>(allKeys);

        // 分页计算
        int total = keyList.size();
        int start = (param.getPage() - 1) * param.getPageSize();
        int end = Math.min(start + param.getPageSize(), total);

        List<RdsAppsMenuVo> data = new ArrayList<>();
        for (String key : keyList.subList(start, end)) {
            // 获取原始数据（优化字符集处理）
            Map<String, String> dataMap = redisService.getCacheMap(key);
            if (MapUtil.isEmpty(dataMap)) continue;

            // 数据清洗（参考安全转换逻辑）
            dataMap.replaceAll((k, v) ->
                    "null".equalsIgnoreCase(v) ? null : v);
            dataMap.values().removeIf(StrUtil::isBlank);

            // 对象转换（使用BeanUtil保证类型安全）
            RdsAppsMenuVo vo = BeanUtil.mapToBean(
                    dataMap,
                    RdsAppsMenuVo.class,
                    false,
                    CopyOptions.create()
                            .ignoreNullValue()
                            .setFieldValueEditor((k, v) ->
                                    "null".equals(v) ? null : v)
            );

            // 时间字段处理
            if(dataMap.containsKey("createTime")) {
                vo.setCreateTime(LocalDateTime.parse(dataMap.get("createTime")));
            }
            if(dataMap.containsKey("updateTime")) {
                vo.setUpdateTime(LocalDateTime.parse(dataMap.get("updateTime")));
            }

            data.add(vo);
        }

        // 分页元数据
        int totalPages = (int) Math.ceil((double) total / param.getPageSize());
        return new PageResults<>(data, total, param.getPage(), param.getPageSize(), totalPages);
    }

    @Override
    public void updateByBatch(List<RdsAppsMenuUpdateQuery> param) {
        rdsAppsGroupMenuService.addByBatch(param);
    }

    @Override
    public List<RdsAppsGroupMenuAccessVo> queryAccess(RdsAppsGroupMenuAccessQuery param) {
        return rdsAppsGroupMenuService.queryAccess(param);
    }
}
