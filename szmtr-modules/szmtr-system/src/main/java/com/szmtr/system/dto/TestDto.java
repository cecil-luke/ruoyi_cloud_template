package com.szmtr.system.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class TestDto implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 备注
     */
    private String remark;

    private String id;

    /**
     * 文件名称
     */
    private String name;

    /**
     * 原文件名
     */
    private String description;

    /**
     * 删除标记（0：正常；1：已删除）
     */
    private Integer delFlag;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 附件
     */
    private List<SysFileDto> list;

    private String fileIds;

}
