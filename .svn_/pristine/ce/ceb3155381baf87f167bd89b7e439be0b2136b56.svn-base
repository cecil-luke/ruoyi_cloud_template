//package com.szmtr.business.controller;
//
//import com.szmtr.common.core.web.controller.BaseController;
//import com.szmtr.common.core.web.domain.AjaxResult;
//import com.szmtr.common.core.web.page.TableDataInfo;
//import com.szmtr.common.log.annotation.Log;
//import com.szmtr.common.log.enums.BusinessType;
//import com.szmtr.common.security.annotation.RequiresPermissions;
//import com.szmtr.business.domain.Rdscodegroup;
//import com.szmtr.business.dto.query.RdscodegroupQuery;
//import com.szmtr.business.service.IRdscodegroupService;
//import com.szmtr.business.dto.*;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletResponse;
//import java.util.List;
//
//@Validated
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/rdscodegroup")
//public class RdscodegroupController extends BaseController {
//
//    @Autowired
//    public IRdscodegroupService rdscodegroupService;
//
//    @PostMapping("/list")
//    public AjaxResult page(@RequestBody RdscodegroupQuery query) {
//        return rdscodegroupService.selectRdscodegroupPage(query);
//    }
//
//
//    @GetMapping("/get/{id}")
//    public AjaxResult get(@PathVariable String id) {
//        return AjaxResult.success(rdscodegroupService.getById(id));
//    }
//
//    @Log(title = "编码组合新增", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    public AjaxResult add(@RequestBody RdscodegroupDto rdscodegroupDto) {
//        rdscodegroupService.saveOrUpdate(rdscodegroupDto);
//        return AjaxResult.success();
//    }
//
//
//    /**
//     * 删除
//     */
//    @DeleteMapping("/delete/{ids}")
//    public AjaxResult deleteByIds(@PathVariable String ids) {
//        rdscodegroupService.deleteData(ids);
//        return AjaxResult.success();
//    }
//}
