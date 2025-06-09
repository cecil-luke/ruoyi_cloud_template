package com.szmtr.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.StrUtil;
import com.szmtr.common.redis.service.RedisService;
import com.szmtr.system.domain.RdsUserPostRole;
import com.szmtr.system.domain.vo.RdsUserPostRoleVo;
import com.szmtr.system.dto.parameter.AuthUserParameter;
import com.szmtr.system.dto.parameter.RdsUserPostRoleParameter;
import com.szmtr.system.service.IRdsUserPostRoleService;
import com.szmtr.system.utils.ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName RdsUserPostRoleServiceImpl
 * @Author Lss
 * @Date 2025/5/28
 * @Description: RDS用户岗位角色关联服务实现层
 */
@Service
public class RdsUserPostRoleServiceImpl implements IRdsUserPostRoleService {

    private static final String PREFIX = "rdsuserpostrole:";
    private static final String INDEX_GROUP = "index:authGroup:";
    private static final String INDEX_USER = "index:user:";

    @Autowired
    private RedisService redisService;

    @Override
    public void authUser(AuthUserParameter param) {
        String groupKey = INDEX_GROUP + param.getAuthGroupCode();
        // 删除现有授权
        Set<String> existed = redisService.getCacheSet(groupKey);
        if (!CollectionUtils.isEmpty(existed)) {
            // 删除关联数据
            existed.forEach(id -> redisService.deleteObject(PREFIX + id));
            // 删除索引
            redisService.deleteObject(groupKey);
        }
        // 保存新授权
        if (!CollectionUtils.isEmpty(param.getUserList())) {
            param.getUserList().forEach(userPostDto -> {
                // 赋值
                RdsUserPostRole entity = new RdsUserPostRole();
                BeanUtil.copyProperties(userPostDto, entity);
                ModelUtil.fillCreateFields(entity);
                entity.setRoleId(param.getAuthGroupCode());
                entity.setRoleName(param.getAuthGroupName());
                // 转Map并保存
                Map<String, String> map = BeanUtil.beanToMap(entity).entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                e -> String.valueOf(e.getValue())
                        ));
                redisService.setCacheMap(PREFIX + entity.getId(), map);
                // 更新索引
                redisService.setCacheSet(groupKey, Collections.singleton(entity.getId()));
                redisService.setCacheSet(INDEX_USER + userPostDto.getUserId(), Collections.singleton(entity.getId()));
            });
        }
    }

    @Override
    public void authRoleGroup(List<RdsUserPostRoleParameter> param) {
        if (CollectionUtils.isEmpty(param)) {
            return;
        }
        // 找到所有涉及的用户
        Set<String> userIds = param.stream()
                .map(RdsUserPostRoleParameter::getUserId)
                .filter(StrUtil::isNotBlank)
                .collect(Collectors.toSet());
        // 删除现有授权
        userIds.forEach(userId -> {
            String userKey = INDEX_USER + userId;
            Set<String> existed = redisService.getCacheSet(userKey);
            if (!CollectionUtils.isEmpty(existed)) {
                existed.forEach(id -> redisService.deleteObject(PREFIX + id));
                redisService.deleteObject(userKey);
            }
        });

        // 保存新授权
        param.forEach(p -> {
            RdsUserPostRole entity = new RdsUserPostRole();
            BeanUtil.copyProperties(p, entity);
            ModelUtil.fillCreateFields(entity);

            Map<String, String> map = BeanUtil.beanToMap(entity).entrySet().stream()
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            e -> String.valueOf(e.getValue())
                    ));
            redisService.setCacheMap(PREFIX + entity.getId(), map);
            redisService.setCacheSet(INDEX_GROUP + p.getAuthGroupCode(), Collections.singleton(entity.getId()));
            redisService.setCacheSet(INDEX_USER + p.getUserId(), Collections.singleton(entity.getId()));
        });
    }

    @Override
    public List<RdsUserPostRoleVo> getByUserId(String userId) {
        String userKey = INDEX_USER + userId;
        Set<String> ids = redisService.getCacheSet(userKey);
        if (CollectionUtils.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return ids.stream()
                .map(id -> {
                    Map<String, String> map = redisService.getCacheMap(PREFIX + id);
                    return BeanUtil.mapToBean(map, RdsUserPostRoleVo.class, false,
                            CopyOptions.create().setIgnoreNullValue(true));
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}

