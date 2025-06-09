package com.szmtr.system.dto.parameter;

import com.szmtr.system.dto.RdsUserPostDto;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @ClassName AuthUserParameter
 * @Author Lss
 * @Date 2025/5/28
 * @Description: 权限组授权多个用户参数
 */
@Data
@Valid
public class AuthUserParameter {

    /**
     * 权限组编号
     */
    @NotBlank(message = "权限组编号不能为空!")
    private String authGroupCode;

    /**
     * 权限组名称
     */
    @NotBlank(message = "权限组名称不能为空!")
    private String authGroupName;

    /**
     * RDS人员信息
     */
    private List<RdsUserPostDto> userList;
}