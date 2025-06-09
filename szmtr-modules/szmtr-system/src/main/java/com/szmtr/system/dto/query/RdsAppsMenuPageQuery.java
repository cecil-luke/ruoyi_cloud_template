package com.szmtr.system.dto.query;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName RdsAppsMenuPageQuery
 * @Author Lss
 * @Date 2025/5/26
 * @Description: RDS应用定义功能按钮分页查询参数
 */
@Data
public class RdsAppsMenuPageQuery {

    /**
     * rds应用定义ID
     */
    @NotBlank(message = "rds应用定义ID不能为空!")
    private String rdsappsId;

    /** 当前页码 */
    @NotNull(message = "当前页码不能为空!")
    private Integer page;

    /** 页大小 */
    @NotNull(message = "页大小不能为空!")
    private Integer pageSize;
}
