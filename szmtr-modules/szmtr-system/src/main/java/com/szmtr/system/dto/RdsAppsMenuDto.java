package com.szmtr.system.dto;

import lombok.Data;

/**
 * @ClassName RdsAppsMenuDto
 * @Author Lss
 * @Date 2025/5/26
 * @Description: RDS应用定义功能按钮DTO
 */
@Data
public class RdsAppsMenuDto {

    /**
     * 功能按钮名称
     */
    private String buttonName;

    /**
     * 功能按钮标识
     */
    private String buttonCode;

    /**
     * 状态(0-启用，1-未启用)
     */
    private Integer status;

    /**
     * rds应用定义ID
     */
    private String rdsappsId;
}
