package com.szmtr.system.domain.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName RdsAppsGroupMenuAccessVo
 * @Author Lss
 * @Date 2025/5/26
 * @Description: 按钮访问权限VO
 */
@Data
public class RdsAppsGroupMenuAccessVo {

    /**
     * RDS应用定义功能按钮id
     */
    @NotBlank(message = "RDS应用定义功能按钮id不能为空!")
    private String id;


    /**
     * 授予访问权限（0无权限，1有权限）
     */
    @NotBlank(message = "授予访问权限不能为空!")
    private Integer hasAccess;
}
