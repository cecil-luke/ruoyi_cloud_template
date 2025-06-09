package com.szmtr.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.szmtr.common.redis.service.RedisService;
import com.szmtr.system.domain.RdsAppsGroupMenu;
import com.szmtr.system.domain.vo.RdsAppsGroupMenuAccessVo;
import com.szmtr.system.dto.query.RdsAppsGroupMenuAccessQuery;
import com.szmtr.system.dto.query.RdsAppsMenuUpdateQuery;
import com.szmtr.system.service.IRdsAppsGroupMenuService;
import com.szmtr.system.utils.ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassName RdsAppsGroupMenuImpl
 * @Author Lss
 * @Date 2025/5/26
 * @Description: RDS权限组-功能按钮关联服务层实现
 */
@Service
public class RdsAppsGroupMenuImpl implements IRdsAppsGroupMenuService {
    // 格式：rdsrolegroupId:rdsappsId:rdsAppsMenuId
    private static final String RDS_GROUP_MENU_KEY = "rdsgroupmenu:%s:%s:%s";
    // 权限组-应用索引
    private static final String INDEX_GROUP_APP = "index:rdsrolegroup:%s:rdsapps:%s";

    @Autowired
    private RedisService redisService;

    @Autowired
    public RedisTemplate redisTemplate;

    @Override
    public void addByBatch(List<RdsAppsMenuUpdateQuery> paramList) {
        // 使用管道批量操作
        redisService.executePipeline(connection -> {
            paramList.forEach(param -> {
                // 前置处理：清理旧数据
                deleteExistingData(connection, param);

                // 哈希键
                String hashKey = buildHashKey(param);
                // 索引键
                String indexKey = buildIndexKey(param);

                // 转换实体
                RdsAppsGroupMenu entity = new RdsAppsGroupMenu();
                BeanUtil.copyProperties(param, entity);
                ModelUtil.fillCreateFields(entity);

                // Hash存储
                Map<String, String> safeMap = BeanUtil.beanToMap(entity)
                        .entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                e -> String.valueOf(e.getValue())
                        ));
                redisService.setCacheMap(hashKey, safeMap);

                redisService.addCacheSet(indexKey, hashKey);
            });
            return null;
        });
    }

    @Override
    public List<RdsAppsGroupMenuAccessVo> queryAccess(RdsAppsGroupMenuAccessQuery param) {
        // 获取索引集合
        String indexKey = String.format(INDEX_GROUP_APP,
                param.getRdsrolegroupId(),
                param.getRdsappsId()
        );
        Set<String> menuKeys = redisService.getCacheSet(indexKey);

        // 管道批量获取
        List<Object> results = redisService.executePipeline(connection -> {
            menuKeys.forEach(key -> connection.hGetAll(key.getBytes()));
            return null;
        });

        // 数据转换
        String jsonStr = JSON.toJSONString(results.stream()
                .filter(obj -> obj instanceof Map && !((Map<?,?>)obj).isEmpty())
                .collect(Collectors.toList()));

        return JSON.parseObject(jsonStr,
                new TypeReference<List<RdsAppsGroupMenuAccessVo>>(){});
    }

    /**
     * 清理已存在的旧数据
     */
    private void deleteExistingData(RedisConnection connection, RdsAppsMenuUpdateQuery param) {
        try {
            String hashKey = buildHashKey(param);
            String indexKey = buildIndexKey(param);

            // 序列化键
            byte[] serializedHashKey = redisTemplate.getKeySerializer().serialize(hashKey);
            byte[] serializedIndexKey = redisTemplate.getKeySerializer().serialize(indexKey);

            // 原子操作删除数据
            connection.del(serializedHashKey);
            connection.sRem(serializedIndexKey, serializedHashKey);

        } catch (Exception e) {
            throw new RuntimeException("数据预处理失败", e);
        }
    }


    /**
     * 构建哈希键
     */
    private String buildHashKey(RdsAppsMenuUpdateQuery param) {
        return String.format(RDS_GROUP_MENU_KEY,
                param.getRdsrolegroupId(),
                param.getRdsappsId(),
                param.getRdsAppsMenuId()
        );
    }

    /**
     * 构建索引键
     */
    private String buildIndexKey(RdsAppsMenuUpdateQuery param) {
        return String.format(INDEX_GROUP_APP,
                param.getRdsrolegroupId(),
                param.getRdsappsId()
        );
    }
}
