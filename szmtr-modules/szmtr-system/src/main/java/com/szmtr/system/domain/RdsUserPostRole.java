package com.szmtr.system.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName RdsUserPostRole
 * @Author Lss
 * @Date 2025/5/28
 * @Description: 用户岗位角色关联表
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RdsUserPostRole extends BaseEntity{

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
     * 角色(权限组名称)
     */
    private String roleName;

    /**
     * 角色id(权限组id)
     */
    private String roleId;

    /**
     * 主职(0是，1不是)
     */
    private Integer isPrimary;

    /**
     * 有效(0有效，1无效)
     */
    private Integer isValid;

    /**
     * 人员编号
     */
    private String userId;
}
