package com.szmtr.system.controller;

import com.szmtr.common.core.domain.Result;
import com.szmtr.system.domain.PageResults;
import com.szmtr.system.domain.vo.RdsUserVo;
import com.szmtr.system.dto.RdsUserDto;
import com.szmtr.system.dto.query.RdsUserQuery;
import com.szmtr.system.service.IRdsUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName RdsUserController
 * @Author Lss
 * @Date 2025/5/28
 * @Description: RDS人员控制层
 */
@RestController
@RequestMapping("/res-user")
@RequiredArgsConstructor
@Validated
public class RdsUserController {

    final IRdsUserService rdsUserService;

    /**
     * 新增或更新人员信息
     *
     * @param param dto
     * @return Result
     */
    @PostMapping
    public Result addOrUpdate(@RequestBody RdsUserDto param) {
        rdsUserService.addOrUpdate(param);
        return Result.ok();
    }

    /**
     * 根据人员编号删除人员信息
     *
     * @param userId 人员编号
     * @return Result
     */
    @DeleteMapping
    public Result delete(@RequestParam @NotBlank String userId) {
        rdsUserService.delete(userId);
        return Result.ok();
    }

    /**
     * 分页查询人员信息
     *
     * @param param param
     * @return page
     */
    @PostMapping("/page")
    public Result<PageResults<RdsUserVo>> page(@RequestBody RdsUserQuery param) {
        PageResults<RdsUserVo> pageResults = rdsUserService.page(param);
        return Result.ok(pageResults);
    }

    /**
     * 通过人员编号获取人员信息
     *
     * @param userId 人员编号
     * @return vo
     */
    @GetMapping("/{userId}")
    public Result<RdsUserVo> getByUserId(@PathVariable("userId") @NotBlank String userId) {
        RdsUserVo vo = rdsUserService.getByUserId(userId);
        return Result.ok(vo);
    }
}
