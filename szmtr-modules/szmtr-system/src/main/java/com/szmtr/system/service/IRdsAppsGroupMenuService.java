package com.szmtr.system.service;

import com.szmtr.system.domain.vo.RdsAppsGroupMenuAccessVo;
import com.szmtr.system.dto.query.RdsAppsGroupMenuAccessQuery;
import com.szmtr.system.dto.query.RdsAppsMenuUpdateQuery;

import java.util.List;

/**
 * @ClassName IRdsAppsGroupMenuService
 * @Author Lss
 * @Date 2025/5/26
 * @Description: RDS权限组-功能按钮关联服务层接口
 */
public interface IRdsAppsGroupMenuService {

    /**
     * 批量新增按钮访问权限
     *
     * @param paramList paramList
     */
    void addByBatch(List<RdsAppsMenuUpdateQuery> paramList);

    /**
     * 根据权限组id和应用定义id查询按钮访问权限
     *
     * @param param id
     * @return listVo
     */
    List<RdsAppsGroupMenuAccessVo> queryAccess(RdsAppsGroupMenuAccessQuery param);
}
