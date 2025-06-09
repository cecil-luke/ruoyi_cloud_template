package com.szmtr.system.service;

import com.szmtr.system.domain.PageResults;
import com.szmtr.system.domain.vo.RdsRoleGroupVo;
import com.szmtr.system.dto.RdsRoleGroupDto;
import com.szmtr.system.dto.query.RdsRoleGroupQuery;

/**
 * @ClassName IRdsRoleGroupService
 * @Author Lss
 * @Date 2025/5/22
 * @Description: RDS权限组/角色组服务层
 */
public interface IRdsRoleGroupService {

    /**
     * 新增或更新RDS权限组/角色组
     * @param param param
     */
    void addOrUpdate(RdsRoleGroupDto param);

    /**
     * 删除RDS权限组/角色组
     * @param id id
     */
    void deleteById(String id);

    /**
     * 分页查询RDS权限组/角色组
     * @param param param
     * @return page
     */
    PageResults<RdsRoleGroupVo> page(RdsRoleGroupQuery param);

    /**
     * 根据id查询RDS权限组/角色组
     * @param id id
     * @return RdsRoleGroupVo
     */
    RdsRoleGroupVo getById(String id);
}
