package com.szmtr.system.controller;

import com.szmtr.common.core.domain.Result;
import com.szmtr.system.dto.parameter.AuthUserParameter;
import com.szmtr.system.dto.parameter.RdsUserPostRoleParameter;
import com.szmtr.system.service.IRdsUserPostRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName RdsUserPostRoleController
 * @Author Lss
 * @Date 2025/5/28
 * @Description: 用户岗位角色关联控制层
 */
@RestController
@RequestMapping("/rds-user-role")
@RequiredArgsConstructor
@Validated
public class RdsUserPostRoleController {

    final IRdsUserPostRoleService rdsUserPostRoleService;

    /**
     * 权限组授权多个用户
     *
     * @param param param
     * @return Result
     */
    @PostMapping("/auth-user")
    public Result authUser(@RequestBody AuthUserParameter param) {
        rdsUserPostRoleService.authUser(param);
        return Result.ok();
    }

    /**
     * 用户授权多个权限组
     *
     * @param param list
     * @return Result
     */
    @PostMapping("/auth-role-group")
    public Result authRoleGroup(@RequestBody List<RdsUserPostRoleParameter> param) {
        rdsUserPostRoleService.authRoleGroup(param);
        return Result.ok();
    }
}
