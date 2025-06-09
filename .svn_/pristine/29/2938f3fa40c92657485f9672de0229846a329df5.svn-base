package com.szmtr.system.domain.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.szmtr.system.domain.Rdsapps;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @ClassName RdsappsVo
 * @Author Lss
 * @Date 2025/5/27
 * @Description: RDS应用定义VO
 */
@Data
public class RdsappsVo {

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

    /** 菜单名称 */
    private String rdsAppName;

    /** 菜单编码 */
    private String rdsApp;

    /** 是否启用（0正常 1停用） */
    @JsonDeserialize(using = Rdsapps.SafeIntegerDeserializer.class)
    private Integer status;

    /** 权限标识码 */
    private String perms;

    /** RDS模块-所属模块 */
    private String rdsModule;

    /** 备注 */
    private String remark;

    /** 菜单类型（M目录 C页面 F按钮） */
    private String menuType;

    /** 菜单路径 */
    private String path;

    /** 显示顺序 */
    @JsonDeserialize(using = Rdsapps.SafeIntegerDeserializer.class)
    private Integer rdsSeqNum;

    /** 上级菜单 */
    private Long parentId;

    /** 菜单图标 */
    private String icon;

    /** 是否显示（0显示 1隐藏） */
    private String visible;
}
