package com.szmtr.system.dto.query;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @ClassName RdsUserQuery
 * @Author Lss
 * @Date 2025/5/28
 * @Description: RDS人员分页查询参数
 */
@Data
@Valid
public class RdsUserQuery {

    /**
     * 所属公司id
     */
    private String companyId;

    /**
     * 0活动，1停用，2不活动
     */
    private Integer status;

    /**
     * 用户姓名
     */
    private String nickName;

    /** 当前页码 */
    @NotNull(message = "当前页码不能为空!")
    private Integer page;

    /** 页大小 */
    @NotNull(message = "页大小不能为空!")
    private Integer pageSize;
}
