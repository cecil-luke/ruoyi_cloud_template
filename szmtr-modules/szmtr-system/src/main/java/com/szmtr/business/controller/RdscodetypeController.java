//package com.szmtr.business.controller;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.szmtr.business.domain.Rdscodetype;
//import com.szmtr.business.dto.RdscodetypeDto;
//import com.szmtr.business.dto.query.RdscodetypeQuery;
//import com.szmtr.business.service.IRdscodetypeService;
//import com.szmtr.business.service.IRdssectionService;
//import com.szmtr.business.util.AcceptClassColumnUtil;
//import com.szmtr.business.util.ConvertToRdscodetypeUtil;
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
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@Validated
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/rdscodetype")
//public class RdscodetypeController extends BaseController {
//
//    @Autowired
//    public IRdscodetypeService rdscodetypeService;
//
//    @Autowired
//    public IRdssectionService rdssectionService;
//
//    @PostMapping("/list")
//    public AjaxResult page(@RequestBody RdscodetypeQuery query) {
//        return rdscodetypeService.selectRdscodetypePage(query);
//    }
//
//
//    @GetMapping("/get/{id}")
//    public AjaxResult get(@PathVariable String id) {
//        return AjaxResult.success(rdscodetypeService.getById(id));
//    }
//
//    @Log(title = "编码类型新增", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    public AjaxResult add(@RequestBody RdscodetypeDto rdscodetypeDto) {
//        rdscodetypeService.saveOrUpdateById(rdscodetypeDto);
//        return AjaxResult.success();
//    }
//
//
//    /**
//     * 删除
//     */
//    @DeleteMapping("/delete/{ids}")
//    public AjaxResult deleteByIds(@PathVariable String ids) {
//        //查询编码段和编码规则如果存在的话就不可以删除
//        rdscodetypeService.deleteData(ids);
//        return AjaxResult.success();
//    }
//
//    /**
//     * 编码类型的保存接口
//     */
//    @PostMapping("/saveOrUpdate")
//    public AjaxResult saveOrUpdate(@RequestBody RdscodetypeDto rdscodetypeDto) throws IOException {
//        String jsonStr = rdscodetypeDto.getJsonStr();
//        List<AcceptClassColumnUtil> list = ConvertToRdscodetypeUtil.parseJsonArray(jsonStr);
//        RdscodetypeDto rdscodetypeDto1 = ConvertToRdscodetypeUtil.mapToRdscodetype(list);
//        rdscodetypeService.saveOrUpdateByCode(rdscodetypeDto1);
//        return AjaxResult.success();
//    }
//
//
//    /**
//     * 校验编码类型是否存在
//     */
//    @PostMapping("/validRdscodetype")
//    public AjaxResult validRdscodetype(@RequestBody RdscodetypeDto rdscodetypeDto) throws IOException {
//        Rdscodetype rdscodetype = rdscodetypeService.getById(rdscodetypeDto.getId());
//        if (null == rdscodetype) {
//            int count = rdscodetypeService.count(new LambdaQueryWrapper<Rdscodetype>().eq(Rdscodetype::getRdscodetype, rdscodetypeDto.getRdscodetype()));
//            if (count != 0) {
//                return AjaxResult.error(rdscodetypeDto.getRdscodetype() + ",该编码已经存在，请重新输入");
//            }
//        } else {
//            int count = rdscodetypeService.count(new LambdaQueryWrapper<Rdscodetype>().eq(Rdscodetype::getRdscodetype, rdscodetypeDto.getRdscodetype()).ne(Rdscodetype::getId, rdscodetypeDto.getId()));
//            if (count != 0) {
//                return AjaxResult.error(rdscodetypeDto.getRdscodetype() + ",该编码已经存在，请重新输入");
//            }
//        }
//        return AjaxResult.success();
//    }
//}
