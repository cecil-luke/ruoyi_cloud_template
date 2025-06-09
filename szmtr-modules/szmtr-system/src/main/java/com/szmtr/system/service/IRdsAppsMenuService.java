package com.szmtr.system.service;

import com.szmtr.system.domain.PageResults;
import com.szmtr.system.domain.vo.RdsAppsGroupMenuAccessVo;
import com.szmtr.system.domain.vo.RdsAppsMenuVo;
import com.szmtr.system.dto.RdsAppsMenuDto;
import com.szmtr.system.dto.query.RdsAppsGroupMenuAccessQuery;
import com.szmtr.system.dto.query.RdsAppsMenuPageQuery;
import com.szmtr.system.dto.query.RdsAppsMenuUpdateQuery;

import java.util.List;

/**
 * @ClassName IRdsAppsMenuService
 * @Author Lss
 * @Date 2025/5/26
 * @Description: RDS应用定义功能按钮服务层接口
 */
public interface IRdsAppsMenuService {

    /**
     * 批量添加功能按钮
     *
     * @param paramList List
     */
    void addByBatch(List<RdsAppsMenuDto> paramList);

    /**
     * 根据RDS应用定义ID删除所有功能按钮
     *
     * @param rdsappsId id
     */
    void deleteByRdsappsId(String rdsappsId);

    /**
     * 根据RDS应用定义ID分页查询功能按钮
     *
     * @param param param
     * @return page
     */
    PageResults<RdsAppsMenuVo> pageByRdsappsId(RdsAppsMenuPageQuery param);

    /**
     * 批量更新功能按钮访问权限
     *
     * @param param param
     */
    void updateByBatch(List<RdsAppsMenuUpdateQuery> param);

    /**
     * 根据权限组id和应用定义id查询按钮访问权限
     *
     * @param param id
     * @return listVo
     */
    List<RdsAppsGroupMenuAccessVo> queryAccess(RdsAppsGroupMenuAccessQuery param);
}
