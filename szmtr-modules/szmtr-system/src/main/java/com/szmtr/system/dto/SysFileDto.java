package com.szmtr.system.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SysFileDto {
    private String id;//主键
    /**
     * 文件地址
     */
    private String url;


    /**
     * 业务主见
     *
     * @return
     */
    private String businessKey;


    /**
     * 文件类型
     *
     * @return
     */
    private String fileType;


    /**
     * 桶位
     *
     * @return
     */
    private String bucket;

    /**
     * 文件大小
     *
     * @return
     */
    private Long fileSize;

    /**
     * 文件名称
     *
     * @return
     */
    private String name;

    /**
     * 文件原名称
     *
     * @return
     */
    private String fileNameOld;

    private Integer delFlag;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 附件
     */
    private List<SysFileDto> list;
}
