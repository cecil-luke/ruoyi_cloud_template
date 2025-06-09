package com.szmtr.system.controller;

import com.szmtr.common.core.domain.Result;
import com.szmtr.system.domain.PageResults;
import com.szmtr.system.domain.vo.RdsAppsGroupMenuAccessVo;
import com.szmtr.system.domain.vo.RdsAppsMenuVo;
import com.szmtr.system.dto.query.RdsAppsGroupMenuAccessQuery;
import com.szmtr.system.dto.query.RdsAppsMenuPageQuery;
import com.szmtr.system.dto.query.RdsAppsMenuUpdateQuery;
import com.szmtr.system.service.IRdsAppsMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName RdsAppsMenuController
 * @Author Lss
 * @Date 2025/5/26
 * @Description: RDS应用定义功能按钮控制层
 */
@RestController
@RequestMapping("/rds-apps-menu")
@RequiredArgsConstructor
@Validated
public class RdsAppsMenuController {

    final IRdsAppsMenuService rdsAppsMenuService;

    /**
     * 根据RDS应用定义ID分页查询功能按钮
     *
     * @param param param
     * @return Page
     */
    @PostMapping("/page")
    public Result<PageResults<RdsAppsMenuVo>> pageByRdsappsId(@RequestBody @Valid RdsAppsMenuPageQuery param) {
        PageResults<RdsAppsMenuVo> voPage = rdsAppsMenuService.pageByRdsappsId(param);
        return Result.ok(voPage);
    }

    /**
     * 批量更新功能按钮访问权限
     *
     * @param param  param
     * @return Result
     */
    @PostMapping("/update")
    public Result updateByBatch(@RequestBody List<RdsAppsMenuUpdateQuery> param) {
        rdsAppsMenuService.updateByBatch(param);
        return Result.ok();
    }

    /**
     * 根据权限组id和应用定义id查询按钮访问权限
     *
     * @param param id
     * @return listVo
     */
    @PostMapping("/query-access")
    public Result<List<RdsAppsGroupMenuAccessVo>> queryAccess(@RequestBody RdsAppsGroupMenuAccessQuery param) {
        List<RdsAppsGroupMenuAccessVo> vos = rdsAppsMenuService.queryAccess(param);
        return Result.ok(vos);
    }
}
