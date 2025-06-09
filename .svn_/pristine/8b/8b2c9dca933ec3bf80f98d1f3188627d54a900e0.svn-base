package com.szmtr.system.dto.query;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName RdsAppsMenuQuery
 * @Author Lss
 * @Date 2025/5/26
 * @Description: RDS应用定义功能按钮查询参数
 */
@Data
public class RdsAppsMenuQuery {

    /**
     * 功能按钮名称
     */
    @NotBlank(message = "功能按钮名称不能为空!")
    private String buttonName;

    /**
     * 功能按钮标识
     */
    @NotBlank(message = "功能按钮标识不能为空!")
    private String buttonCode;

    /**
     * 状态(0-启用，1-未启用)
     */
    @NotNull(message = "状态不能为空!")
    private Integer status;
}
