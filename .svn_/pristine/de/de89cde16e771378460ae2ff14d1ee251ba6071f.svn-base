package com.szmtr.system.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @ClassName RdsUserPostDto
 * @Author Lss
 * @Date 2025/5/29
 * @Description: 人员岗位DTO
 */
@Data
@Valid
public class RdsUserPostDto {

    /**
     * 人员编号
     */
    @NotBlank(message = "人员编号不能为空!")
    private String userId;

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
