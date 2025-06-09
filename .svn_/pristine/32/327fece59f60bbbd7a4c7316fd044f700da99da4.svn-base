package com.szmtr.system.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName RdsUserDto
 * @Author Lss
 * @Date 2025/5/28
 * @Description: RDS人员管理
 */
@Data
@Valid
public class RdsUserDto {

    /** 主键ID */
    private String id;

    /**
     * 人员编号
     */
    @NotBlank(message = "人员编号不能为空!")
    private String userId;

    /**
     * 用户姓名
     */
    @NotBlank(message = "用户姓名不能为空!")
    private String nickName;

    /**
     * 登录名称
     */
    @NotBlank(message = "登录名称不能为空!")
    private String userName;

    /**
     * 专业
     */
    @NotBlank(message = "专业不能为空!")
    private String major;

    /**
     * 0活动，1停用，2不活动
     */
    @NotNull(message = "状态不能为空!")
    private Integer status;

    /**
     * 0男，1女
     */
    @NotNull(message = "性别不能为空!")
    private Integer sex;

    /**
     * 联系电话
     */
    private String phoneNumber;

    /**
     * 联系地址
     */
    private String address;
}
