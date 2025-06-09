package com.szmtr.business.domain;

import com.szmtr.common.core.web.domain.CommonEntity;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class Rdsappsoption extends CommonEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private Integer delFlag;
    /**
     * 应用号
     */
    private String rdsapp;
    /**
     * 操作编号
     */
    private String rdsoption;
    /**
     * 操作名称
     */
    private String rdsoptionname;
    /**
     * RDS模块
     */
    private Long rdsseqnum;
}