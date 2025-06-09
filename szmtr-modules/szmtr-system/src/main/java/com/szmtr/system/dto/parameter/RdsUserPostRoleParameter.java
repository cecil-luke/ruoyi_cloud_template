package com.szmtr.system.dto.parameter;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @ClassName RdsUserPostRoleQuery
 * @Author Lss
 * @Date 2025/5/28
 * @Description: 角色组授权用户参数
 */
@Data
@Valid
public class RdsUserPostRoleParameter {

    /**
     * 人员编号
     */
    @NotBlank(message = "人员编号不能为空!")
    private String userId;

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
     * 所属公司
     */
    private String companyName;

    /**
     * 所属公司id
     */
    private String companyId;

    /**
     * 所属部门
     */
    private String departmentName;

    /**
     * 所属部门id
     */
    private String departmentId;

    /**
     * 岗位
     */
    private String postName;

    /**
     * 岗位id
     */
    private String postId;

    /**
     * 专业
     */
    private String major;

    /**
     * 主职(0是，1不是)
     */
    private Integer isPrimary;

    /**
     * 有效(0有效，1无效)
     */
    private Integer isValid;
}
