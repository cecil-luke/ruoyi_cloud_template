package com.szmtr.system.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName RdsRoleGroupDto
 * @Author Lss
 * @Date 2025/5/22
 * @Description: RDS权限组/角色组
 */
@Data
public class RdsRoleGroupDto {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 权限组编号
     */
    @NotBlank(message = "权限组编号不能为空!")
    private String authGroupCode;

    /**
     * 权限组名称
     */
    @NotBlank(message = "权限组名称不能为空!")
    private String authGroupName;

    /**
     * 首页模板
     */
    @NotBlank(message = "首页模板不能为空!")
    private String homeTemplate;

    /**
     * 是否独立于他组，0-不独立 1-独立
     */
    private Integer isIndependent;

    /**
     * 是否为所有编码授权该组，0-不授权 1-授权
     */
    private Integer hasAllCodeAccess;

    /**
     * 是否为所有项目授权该组，0-不授权 1-授权
     */
    private Integer hasAllProjectAccess;

    /**
     * 是否为所有人员授权该组，0-不授权 1-授权
     */
    private Integer hasAllUserAccess;
}
