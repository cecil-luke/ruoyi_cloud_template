package com.szmtr.system.service.impl;

import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szmtr.common.core.constant.CacheConstants;
import com.szmtr.common.redis.service.RedisService;
import com.szmtr.system.service.ISysConfigService;

/**
 * 参数配置 服务层实现
 *
 * @author szmtr
 */
@Service
public class SysConfigServiceImpl implements ISysConfigService {


    @Autowired
    private RedisService redisService;

    /**
     * 项目启动时，初始化参数到缓存
     */
    @PostConstruct
    public void init() {

    }


    /**
     * 清空参数缓存数据
     */
    @Override
    public void clearConfigCache() {
        Collection<String> keys = redisService.keys(CacheConstants.SYS_CONFIG_KEY + "*");
        redisService.deleteObject(keys);
    }

    /**
     * 重置参数缓存数据
     */
    @Override
    public void resetConfigCache() {
        clearConfigCache();
//        loadingConfigCache();
    }


    /**
     * 设置cache key
     *
     * @param configKey 参数键
     * @return 缓存键key
     */
    private String getCacheKey(String configKey) {
        return CacheConstants.SYS_CONFIG_KEY + configKey;
    }
}
