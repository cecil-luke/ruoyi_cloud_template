package com.szmtr.system.domain.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName RdsUserPostRoleVo
 * @Author Lss
 * @Date 2025/5/29
 * @Description: 用户岗位角色关联VO
 */
@Data
public class RdsUserPostRoleVo {

    /** 创建时间 */
    @JSONField(format = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /** 创建者 */
    private String createBy;

    /** 更新时间 */
    @JSONField(format = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    /** 更新者 */
    private String updateBy;

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
