package com.szmtr.system.domain;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.IOException;

/**
 * @ClassName Rdsapps
 * @Author Lss
 * @Date 2025/5/20
 * @Description: RDS应用定义表-rdsapps
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Rdsapps extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 菜单名称 */
    private String rdsAppName;

    /** 菜单编码 */
    private String rdsApp;

    /** 是否启用（0正常 1停用） */
    @JsonDeserialize(using = SafeIntegerDeserializer.class)
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
    @JsonDeserialize(using = SafeIntegerDeserializer.class)
    private Integer rdsSeqNum;

    /** 上级菜单 */
    private Long parentId;

    /** 菜单图标 */
    private String icon;

    /** 是否显示（0显示 1隐藏） */
    private String visible;

    // 自定义反序列化器
    public class SafeIntegerDeserializer extends JsonDeserializer<Integer> {
        @Override
        public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            String value = p.getText();
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                return null; // 或返回默认值
            }
        }
    }
}
