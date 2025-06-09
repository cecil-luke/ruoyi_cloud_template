package com.szmtr.system.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName RdsRoleGroup
 * @Author Lss
 * @Date 2025/5/22
 * @Description: RDS权限组/角色组表-rdsrolegroup
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RdsRoleGroup extends BaseEntity{

    /**
     * 角色组，需保证唯一性
     */
    private String rdsRoleGroup;

    /**
     * 角色名称
     */
    private String rdsRoleName;

    /**
     * 所有地点（项目）权限
     */
    private String rdsIsAllSite;

    /**
     * 状态
     */
    private String rdsStatus;

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
