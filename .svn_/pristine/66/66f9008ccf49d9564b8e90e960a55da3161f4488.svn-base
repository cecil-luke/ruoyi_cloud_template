package com.szmtr.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Data
public class RdsappsDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 应用号
     */
    private String rdsapp;
    /**
     * 应用名称
     */
    private String rdsappname;
    /**
     * 顺序号
     */
    private Long rdsseqnum;
    /**
     * RDS模块
     */
    private String rdsmodule;



    private Integer delFlag;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 备注
     */
    private String remark;


    List<RdsappsoptionDto> list;

}
