package com.szmtr.system.service;

import com.szmtr.system.domain.PageResults;
import com.szmtr.system.domain.Rdsapps;
import com.szmtr.system.domain.vo.RdsappsVo;
import com.szmtr.system.dto.RdsappsDto;
import com.szmtr.system.dto.query.RdsappsQuery;

import java.util.List;

/**
 * @ClassName IRdsappsService
 * @Author Lss
 * @Date 2025/5/20
 * @Description: RDS应用定义服务层
 */
public interface IRdsappsService {

    /**
     * 新增RDS应用定义
     *
     * @param param dto
     */
    void addOrUpdate(RdsappsDto param);

    /**
     * 删除RDS应用定义
     *
     * @param id id
     */
    void deleteById(String id);

    /**
     * 查询RDS应用定义
     *
     * @param query query
     * @return PageResults
     */
    PageResults<Rdsapps> page(RdsappsQuery query);

    /**
     * 根据id查询RDS应用定义
     *
     * @param id id
     * @return Rdsapps
     */
    Rdsapps getById(String id);

    /**
     * 根据菜单类型查询RDS应用定义
     *
     * @param menutype 菜单类型
     * @return List<RdsappsVo>
     */
    List<RdsappsVo> getByMenuType(String menutype);
}
