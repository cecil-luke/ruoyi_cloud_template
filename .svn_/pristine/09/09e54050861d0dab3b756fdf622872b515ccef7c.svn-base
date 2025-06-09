package com.szmtr.system.utils;

import cn.hutool.core.util.StrUtil;
import com.szmtr.common.core.utils.JwtUtils;
import com.szmtr.common.core.utils.ServletUtils;
import com.szmtr.common.core.utils.uuid.IdUtils;
import com.szmtr.common.core.web.domain.CommonEntity;
import com.szmtr.common.security.utils.SecurityUtils;
import com.szmtr.system.api.model.LoginUser;
import com.szmtr.system.domain.BaseEntity;

import java.time.LocalDateTime;

/**
 * 通用工具，设置通用属性
 */
public class ModelUtil{
    /**
     * 填充创建人、创建时间
     */
    public static <T extends BaseEntity> void fillCreateFields(T entity) {
        // 数据的id
        String id = IdUtils.fastSimpleUUID();
        String currentUserId = getCurrentUserIdByToken();
        entity.setId(id);
        entity.setCreateBy(currentUserId);
        entity.setCreateTime(LocalDateTime.now().withNano(0));
        // 创建时 update_by 通常等于 create_by
        entity.setUpdateBy(currentUserId);
        entity.setUpdateTime(LocalDateTime.now().withNano(0));
    }

    /**
     * 填充更新人、更新时间
     */
    public static <T extends BaseEntity> void fillUpdateFields(T entity) {
        String currentUserId = getCurrentUserIdByToken();
        entity.setUpdateBy(currentUserId);
        entity.setUpdateTime(LocalDateTime.now().withNano(0));
    }

    /**
     * 获取当前登录用户ID（安全封装）
     */
    public static String getCurrentUserId() {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if (loginUser == null) {
            throw new RuntimeException("未获取到当前登录用户！");
        }
        return loginUser.getSysUser().getUserId() + "";
    }

    /**
     * 获取当前登录用户ID
     */
    public static String getCurrentUserIdByToken() {
        String token = SecurityUtils.getToken(ServletUtils.getRequest());
        String id = JwtUtils.getUserId(token);
        if (StrUtil.isBlank(id)) {
            throw new RuntimeException("未获取到当前登录用户！");
        }
        return id;
    }
}
