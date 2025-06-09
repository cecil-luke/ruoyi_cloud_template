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
public class RdssectionDto implements Serializable {
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
    private LocalDateTime upperTime;

    /**
     * 更新人
     */
    private String upperBy;

    /**
     * 规则前缀（用于快速识别）
     */
    private String rdsprefix;

    /**
     * 段编号（H2H3）/分级序号
     */
    private String rdssectioncode;

    /**
     * 段名称（如：全厂码H2H3）//分级标题
     */
    private String rdssectionname;

    /**
     * 长度
     */
    private Long rdssectionlength;

    /**
     * 数据类型（字母、数字、字母数字、大写字母、小写字母等）
     */
    private String rdsdatatype;

    /**
     * 编码类型（RDS）/编码字符类型
     */
    private String rdscodetype;

    /**
     * 列表范围/关联域
     */
    private String rdsvaluelist;

    /**
     * 状态: 0:新建，1：有效，2：无效
     */
    private String status;

    /**
     * 段格式
     */
    private String rdssectionformat;

    /**
     * 编码详情，json
     */
    private String rdscodedetail;

    /**
     * 分割数量
     */
    private Integer rdssectionnum;

}
