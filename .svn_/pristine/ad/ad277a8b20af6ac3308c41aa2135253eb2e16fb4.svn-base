package com.szmtr.system.dto.query;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @ClassName RdsAppsMenuUpdateQuery
 * @Author Lss
 * @Date 2025/5/26
 * @Description: 批量更新功能按钮参数
 */
@Data
@Valid
public class RdsAppsMenuUpdateQuery {

    /**
     * RDS权限组id
     */
    @NotBlank(message = "RDS权限组id不能为空!")
    private String rdsrolegroupId;

    /**
     * RDS应用定义id
     */
    @NotBlank(message = "RDS应用定义id不能为空!")
    private String rdsappsId;

    /**
     * RDS应用定义功能按钮id
     */
    @NotBlank(message = "RDS应用定义功能按钮id不能为空!")
    private String rdsAppsMenuId;


    /**
     * 授予访问权限（0无权限，1有权限）
     */
    @NotBlank(message = "授予访问权限不能为空!")
    private Integer hasAccess;

}
