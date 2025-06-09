package com.szmtr.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.shaded.com.google.common.collect.Sets;
import com.szmtr.common.redis.service.RedisService;
import com.szmtr.system.domain.PageResults;
import com.szmtr.system.domain.RdsUser;
import com.szmtr.system.domain.vo.RdsUserPostRoleVo;
import com.szmtr.system.domain.vo.RdsUserVo;
import com.szmtr.system.dto.RdsUserDto;
import com.szmtr.system.dto.query.RdsUserQuery;
import com.szmtr.system.service.IRdsUserPostRoleService;
import com.szmtr.system.service.IRdsUserService;
import com.szmtr.system.utils.ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName RdsUserServiceImpl
 * @Author Lss
 * @Date 2025/5/28
 * @Description: RDS人员管理实现层
 */
@Service
public class RdsUserServiceImpl implements IRdsUserService {

    private static final String USER_KEY_PREFIX = "rdsuser:";
    private static final String INDEX_COMPANY = "index:company:";
    private static final String INDEX_STATUS = "index:status:";

    @Autowired
    private RedisService redisService;

    @Autowired
    private IRdsUserPostRoleService rdsUserPostRoleService;

    @Override
    public void addOrUpdate(RdsUserDto param) {
        if (StrUtil.isNotBlank(param.getId())) {
            update(param);
            return;
        }

        RdsUser rdsUser = new RdsUser();
        BeanUtil.copyProperties(param, rdsUser);
        ModelUtil.fillCreateFields(rdsUser);

        String userKey = USER_KEY_PREFIX + param.getUserId();
        // 存储主数据到Hash
        Map<String, String> safeMap = BeanUtil.beanToMap(rdsUser)
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> String.valueOf(e.getValue())
                ));

        // 存储主数据
        redisService.setCacheMap(userKey, safeMap);
    }

    private void update(RdsUserDto param) {
        String hashKey = USER_KEY_PREFIX + param.getUserId();
        Map<String, String> oldData = redisService.getCacheMap(hashKey);

        // 更新主数据
        RdsUser rdsUser = com.alibaba.fastjson.JSON.parseObject(JSON.toJSONString(oldData), RdsUser.class);

        BeanUtil.copyProperties(param, rdsUser, CopyOptions.create().ignoreNullValue());
        ModelUtil.fillUpdateFields(rdsUser);
        Map<String, String> safeMap = BeanUtil.beanToMap(rdsUser)
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> String.valueOf(e.getValue())
                ));
        redisService.setCacheMap(hashKey, safeMap);
    }

    @Override
    public void delete(String userId) {
        String userKey = USER_KEY_PREFIX + userId;

        // 删除主数据
        redisService.deleteObject(userKey);
    }

    @Override
    public PageResults<RdsUserVo> page(RdsUserQuery param) {
        Set<String> keys = new LinkedHashSet<>();

        // 动态构建查询索引
        if (StrUtil.isNotBlank(param.getCompanyId()) && param.getStatus() != null) {
            Set<String> companyKeys = redisService.getCacheSet(INDEX_COMPANY + param.getCompanyId());
            Set<String> statusKeys = redisService.getCacheSet(INDEX_STATUS + param.getStatus());
            keys.addAll(Sets.intersection(companyKeys, statusKeys));
        } else if (StrUtil.isNotBlank(param.getCompanyId())) {
            keys = redisService.getCacheSet(INDEX_COMPANY + param.getCompanyId());
        } else if (param.getStatus() != null) {
            keys = redisService.getCacheSet(INDEX_STATUS + param.getStatus());
        } else {
            keys = (Set)redisService.keys(USER_KEY_PREFIX + "*");
        }

        // 分页处理
        List<String> keyList = new ArrayList<>(keys);
        int total = keyList.size();
        int page = param.getPage();
        int pageSize = param.getPageSize();
        int fromIndex = (page - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, total);

        // 逐条获取数据
        List<RdsUserVo> data = keyList.subList(fromIndex, toIndex).stream()
                .map(key -> {
                    Map<String, String> map = redisService.getCacheMap(key);
                    return BeanUtil.mapToBean(map, RdsUserVo.class, false,
                            CopyOptions.create().setIgnoreNullValue(true));
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        for (RdsUserVo vo : data) {
            List<RdsUserPostRoleVo> userPostRoleVoList = rdsUserPostRoleService.getByUserId(vo.getUserId());
            vo.setUserPostRoleVoList(userPostRoleVoList);
        }

        return new PageResults<>(
                data,
                total,
                page,
                pageSize,
                (int) Math.ceil((double) total / pageSize)
        );
    }

    @Override
    public RdsUserVo getByUserId(String userId) {
        Map<String, String> dataMap = redisService.getCacheMap(USER_KEY_PREFIX + userId);
        if (CollectionUtils.isEmpty(dataMap)) return null;

        // 转换时处理空值
        return BeanUtil.mapToBean(dataMap, RdsUserVo.class, false,
                CopyOptions.create()
                        .setIgnoreNullValue(true)
                        .setFieldValueEditor((fieldName, fieldValue) ->
                                "null".equals(fieldValue) ? null : fieldValue));
    }
}
