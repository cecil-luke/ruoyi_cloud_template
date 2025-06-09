package com.szmtr.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import com.szmtr.common.core.web.domain.BaseEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
public class RdscodetypeDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 创建人
     */
    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 编码类型
     */
    private String rdscodetype;

    /**
     * 编码类型名称
     */
    private String rdscodetypename;

    /**
     * 版本
     */
    private Long rdsversion;

    /**
     * 备注
     */
    private String rdsremark;

    /**
     * 0:未删除，1：已删除
     */
    private Long delFlag;


    /**
     * 通过接口同步过来的参数
     */
    private String jsonStr;


    /**
     * 编码段定义
     */
    private List<RdssectionDto> codeSegmentDefinitionList;

    /**
     * 编码规则
     */
    private List<RdscodegroupDto> codingRulesList;

}
