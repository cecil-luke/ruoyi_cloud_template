package com.szmtr.system.domain.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName RdsUserVo
 * @Author Lss
 * @Date 2025/5/28
 * @Description: RDS人员VO
 */
@Data
public class RdsUserVo {

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
     * 人员编号
     */
    private String userId;

    /**
     * 用户姓名
     */
    private String nickName;

    /**
     * 登录名称
     */
    private String userName;

    /**
     * 专业
     */
    private String major;

    /**
     * 0活动，1停用，2不活动
     */
    private Integer status;

    /**
     * 0男，1女
     */
    private Integer sex;

    /**
     * 联系电话
     */
    private String phoneNumber;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 用户的岗位对应权限组列表
     */
    private List<RdsUserPostRoleVo> userPostRoleVoList;
}
