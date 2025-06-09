package com.szmtr.system.controller;

import com.szmtr.common.core.domain.R;
import com.szmtr.system.domain.PageResults;
import com.szmtr.system.domain.vo.RdsRoleGroupVo;
import com.szmtr.system.dto.RdsRoleGroupDto;
import com.szmtr.system.dto.query.RdsRoleGroupQuery;
import com.szmtr.system.service.IRdsRoleGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @ClassName RdsRoleGroupController
 * @Author Lss
 * @Date 2025/5/22
 * @Description: RDS权限组/角色组控制层
 */
@RestController
@RequestMapping("/rds-role")
@RequiredArgsConstructor
@Validated
public class RdsRoleGroupController {

    final IRdsRoleGroupService rdsRoleGroupService;

    /**
     * 新增或更新RDS权限组/角色组
     *
     * @param param dto
     * @return R
     */
    @PostMapping
    public R addOrUpdate(@RequestBody @Valid RdsRoleGroupDto param) {
        rdsRoleGroupService.addOrUpdate(param);
        return R.ok();
    }

    /**
     * 删除RDS权限组/角色组
     *
     * @param id id
     * @return R
     */
    @DeleteMapping
    public R delete(@RequestParam("id") @NotBlank String id) {
        rdsRoleGroupService.deleteById(id);
        return R.ok();
    }

    /**
     *  分页查询RDS权限组/角色组
     *
     * @param param param
     * @return PageResults
     */
    @PostMapping("/page")
    public R<PageResults<RdsRoleGroupVo>> page(@RequestBody @Valid RdsRoleGroupQuery param) {
        PageResults<RdsRoleGroupVo> result = rdsRoleGroupService.page(param);
        return R.ok(result);
    }

    /**
     * 根据id查询RDS权限组/角色组
     *
     * @param id id
     * @return R
     */
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") @NotBlank String id) {
        RdsRoleGroupVo vo = rdsRoleGroupService.getById(id);
        return R.ok(vo);
    }

}
