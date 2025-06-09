package com.szmtr.system.service;

import com.szmtr.system.domain.PageResults;
import com.szmtr.system.domain.vo.RdsUserVo;
import com.szmtr.system.dto.RdsUserDto;
import com.szmtr.system.dto.query.RdsUserQuery;

/**
 * @ClassName IRdsUserService
 * @Author Lss
 * @Date 2025/5/28
 * @Description: RDS人员管理接口
 */
public interface IRdsUserService {

    /**
     * 新增或更新人员信息
     *
     * @param param dto
     */
    void addOrUpdate(RdsUserDto param);

    /**
     * 根据人员编号删除人员信息
     *
     * @param userId 人员编号
     */
    void delete(String userId);

    /**
     * 分页查询人员信息
     *
     * @param param param
     * @return page
     */
    PageResults<RdsUserVo> page(RdsUserQuery param);

    /**
     * 通过人员编号获取人员信息
     *
     * @param userId 人员编号
     * @return vo
     */
    RdsUserVo getByUserId(String userId);
}
