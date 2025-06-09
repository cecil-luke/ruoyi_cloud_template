package com.szmtr.system.dto.query;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @ClassName RdsAppsGroupMenuAccessQuery
 * @Author Lss
 * @Date 2025/5/26
 * @Description: 按钮访问权限查询参数
 */
@Data
@Valid
public class RdsAppsGroupMenuAccessQuery {

    /**
     * RDS权限组id
     */
    @NotBlank(message = "RDS权限组id不能为空!")
    private String rdsrolegroupId;

    /**
     * RDS应用定义id
     */
    @NotBlank(message = "RDS应用定义id不能为空!")
    private String rdsappsId;
}
