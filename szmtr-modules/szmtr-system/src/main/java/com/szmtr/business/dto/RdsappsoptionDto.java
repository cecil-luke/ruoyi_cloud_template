package com.szmtr.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
public class RdsappsoptionDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 是否删除(0-未删除,1-已删除)
     */
    private Integer delFlag;

    /**
     * 更新人
     */
    private String updateBy;

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
