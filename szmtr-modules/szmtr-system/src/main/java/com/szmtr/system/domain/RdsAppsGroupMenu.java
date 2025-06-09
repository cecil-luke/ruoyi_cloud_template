package com.szmtr.system.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName RdsAppsGroupMenu
 * @Author Lss
 * @Date 2025/5/26
 * @Description: RDS权限组-功能按钮关联表
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RdsAppsGroupMenu extends BaseEntity{

    /**
     * RDS权限组id
     */
    private String rdsrolegroupId;

    /**
     * RDS应用定义id
     */
    private String rdsappsId;

    /**
     * RDS应用定义功能按钮id
     */
    private String rdsAppsMenuId;

    /**
     * 授予访问权限（0无权限，1有权限）
     */
    private Integer hasAccess;
}
