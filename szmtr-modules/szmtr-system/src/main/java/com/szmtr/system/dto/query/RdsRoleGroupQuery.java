package com.szmtr.system.dto.query;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @ClassName RdsRoleGroupQuery
 * @Author Lss
 * @Date 2025/5/22
 * @Description: RDS权限组/角色组查询
 */
@Data
public class RdsRoleGroupQuery {

    /**
     * 权限组编号
     */
    private String authGroupCode;

    /**
     * 权限组名称
     */
    private String authGroupName;

    /**
     * 是否独立于他组，0-不独立 1-独立
     */
    private Integer isIndependent;

    /** 当前页码 */
    @NotNull(message = "当前页码不能为空!")
    private Integer page;

    /** 页大小 */
    @NotNull(message = "页大小不能为空!")
    private Integer pageSize;
}
