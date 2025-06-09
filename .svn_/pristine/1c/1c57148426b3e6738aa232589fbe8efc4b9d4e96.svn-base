package com.szmtr.business.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.szmtr.common.core.web.domain.CommonEntity;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
public class Rdssection extends CommonEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 规则前缀（用于快速识别）
     */
    private String rdsprefix;


    /**
     * 段编号（H2H3）
     */
    private String rdssectioncode;


    /**
     * 段名称（如：全厂码H2H3）/编码字符名称
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