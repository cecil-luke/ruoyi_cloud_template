package com.szmtr.system.service;

import com.szmtr.system.domain.vo.RdsUserPostRoleVo;
import com.szmtr.system.dto.parameter.AuthUserParameter;
import com.szmtr.system.dto.parameter.RdsUserPostRoleParameter;

import java.util.List;

/**
 * @ClassName IRdsUserPostRoleService
 * @Author Lss
 * @Date 2025/5/28
 * @Description: RDS用户岗位角色关联服务层
 */
public interface IRdsUserPostRoleService {

    /**
     * 权限组授权多个用户
     *
     * @param param param
     */
    void authUser(AuthUserParameter param);

    /**
     * 用户授权多个权限组
     *
     * @param param list
     */
    void authRoleGroup(List<RdsUserPostRoleParameter> param);

    /**
     * 通过用户编号查询所有的权限信息
     *
     * @param userId 用户编号
     * @return listVo
     */
    List<RdsUserPostRoleVo> getByUserId(String userId);
}
