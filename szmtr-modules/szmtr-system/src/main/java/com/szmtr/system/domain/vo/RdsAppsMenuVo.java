package com.szmtr.system.domain.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @ClassName RdsAppsMenuVo
 * @Author Lss
 * @Date 2025/5/26
 * @Description: RDS应用定义功能按钮VO
 */
@Data
public class RdsAppsMenuVo {

    /** 主键ID */
    private String id;

    /** 创建时间 */
    @JSONField(format = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /** 创建者 */
    private String createBy;

    /** 更新时间 */
    @JSONField(format = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    /** 更新者 */
    private String updateBy;

    /**
     * 功能按钮名称
     */
    private String buttonName;

    /**
     * 功能按钮标识
     */
    private String buttonCode;

    /**
     * 状态(0-启用，1-未启用)
     */
    private Integer status;

    /**
     * rds应用定义ID
     */
    private String rdsappsId;
}
