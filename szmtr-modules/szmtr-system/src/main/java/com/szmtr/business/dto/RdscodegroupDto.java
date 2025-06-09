package com.szmtr.business.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.*;

import org.springframework.format.annotation.DateTimeFormat;
import com.szmtr.common.core.web.domain.BaseEntity;

import java.io.Serializable;
import java.util.Date;


@Data
public class RdscodegroupDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 编码规则
     */
    private String rdsgrouprulenum;

    /**
     * 编码名称(如：通用功能面规则、通用位置面规则)
     */
    private String rdsgrouprulename;

    /**
     * 规则前缀（用于快速识别）
     */
    private String rdsprefix;

    /**
     * 组合版本
     */
    private Long rdsversion;

    /**
     * 编码组合状态
     */
    private String rdsgroupstatus;

    /**
     * 专业
     */
    private String rdsspecnum;

    /**
     * 编码类型
     */
    private String rdscodetype;

    /**
     * 0:未删除，1：删除
     */
    private Long delFlag;

    /**
     * 段分割数量
     */
    private Long rdssectionnum;

    /**
     * 编码详情（JSON）
     */
    private String rdscodedetail;

    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime rdscreatedate;

    /**
     * 格式展示
     */
    private String rdssectionformat;

}
