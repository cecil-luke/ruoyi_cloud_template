//package com.szmtr.business.controller;
//
//import com.szmtr.business.dto.RdssectionDto;
//import com.szmtr.business.dto.query.RdssectionQuery;
//import com.szmtr.business.service.IRdssectionService;
//import com.szmtr.common.core.web.controller.BaseController;
//import com.szmtr.common.core.web.domain.AjaxResult;
//import com.szmtr.common.core.web.page.TableDataInfo;
//import com.szmtr.common.log.annotation.Log;
//import com.szmtr.common.log.enums.BusinessType;
//import com.szmtr.common.security.annotation.RequiresPermissions;
//import com.szmtr.system.dto.*;
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
//@RequestMapping("/rdssection")
//public class RdssectionController extends BaseController {
//
//    @Autowired
//    public IRdssectionService rdssectionService;
//
//    @PostMapping("/list")
//    public AjaxResult page(@RequestBody RdssectionQuery query) {
//        return rdssectionService.selectRdssectionPage(query);
//    }
//
//
//    @GetMapping("/get/{id}")
//    public AjaxResult get(@PathVariable String id) {
//        return AjaxResult.success(rdssectionService.getById(id));
//    }
//
//    @Log(title = "编码段行新增", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    public AjaxResult add(@RequestBody RdssectionDto rdssectionDto) {
//        rdssectionService.saveOrUpdate(rdssectionDto);
//        return AjaxResult.success();
//    }
//
//
//    /**
//     * 删除
//     */
//    @DeleteMapping("/delete/{ids}")
//    public AjaxResult deleteByIds(@PathVariable String ids) {
//        rdssectionService.deleteData(ids);
//        return AjaxResult.success();
//    }
//}
