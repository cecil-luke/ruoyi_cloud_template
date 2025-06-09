//package com.szmtr.business.controller;
//
//import com.szmtr.common.core.utils.uuid.UUID;
//import com.szmtr.common.core.web.controller.BaseController;
//import com.szmtr.common.core.web.domain.AjaxResult;
//import com.szmtr.common.core.web.page.TableDataInfo;
//import com.szmtr.common.log.annotation.Log;
//import com.szmtr.common.log.enums.BusinessType;
//import com.szmtr.common.security.annotation.RequiresPermissions;
//import com.szmtr.business.domain.Rdsappsoption;
//import com.szmtr.business.dto.query.RdsappsoptionQuery;
//import com.szmtr.business.service.IRdsappsoptionService;
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
//@RequestMapping("/rdsappsoption")
//public class RdsappsoptionController extends BaseController {
//
//    @Autowired
//    public IRdsappsoptionService rdsappsoptionService;
//
//    @PostMapping("/list")
//    public AjaxResult page(@RequestBody RdsappsoptionQuery query) {
//        return rdsappsoptionService.selectRdsappsoptionPage(query);
//    }
//
//
//    @GetMapping("/get/{id}")
//    public AjaxResult get(@PathVariable String id) {
//        return AjaxResult.success(rdsappsoptionService.getById(id));
//    }
//
//    @Log(title = "RDS应用操作新增", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    public AjaxResult add(@RequestBody RdsappsoptionDto rdsappsoptionDto) {
//        rdsappsoptionService.saveOrUpdate(rdsappsoptionDto);
//        return AjaxResult.success();
//    }
//
//
//    /**
//     * 删除
//     */
//    @DeleteMapping("/delete/{ids}")
//    public AjaxResult deleteByIds(@PathVariable String ids) {
//        rdsappsoptionService.deleteData(ids);
//        return AjaxResult.success();
//    }
//
//    /**
//     * 得到数据的主键
//     */
//    @GetMapping("/getDataId")
//    public AjaxResult getDataId() {
//        String uuid = UUID.randomUuid();
//        return AjaxResult.success("请求成功",uuid);
//    }
//}
