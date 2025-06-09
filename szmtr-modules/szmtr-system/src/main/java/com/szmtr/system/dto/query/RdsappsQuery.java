package com.szmtr.system.dto.query;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @ClassName RdsappsQuery
 * @Author Lss
 * @Date 2025/5/21
 * @Description: RDS应用定义数据分页查询
 */
@Data
public class RdsappsQuery {

    /** 菜单名称 */
    private String rdsAppName;

    /** 菜单类型（M目录 C页面 F按钮） */
    private String menuType;

    /** RDS模块-所属模块-父级菜单id */
    private String rdsModule;

    /** 当前页码 */
    @NotNull(message = "当前页码不能为空!")
    private Integer page;

    /** 页大小 */
    @NotNull(message = "页大小不能为空!")
    private Integer pageSize;


}
