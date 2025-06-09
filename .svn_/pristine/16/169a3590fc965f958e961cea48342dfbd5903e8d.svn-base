//package com.szmtr.business.controller;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
//import com.szmtr.business.domain.Rdsappsoption;
//import com.szmtr.business.domain.convert.RdsappsModelConvert;
//import com.szmtr.business.domain.convert.RdsappsoptionModelConvert;
//import com.szmtr.business.service.IRdsappsoptionService;
//import com.szmtr.common.core.utils.StringUtils;
//import com.szmtr.common.core.web.controller.BaseController;
//import com.szmtr.common.core.web.domain.AjaxResult;
//import com.szmtr.common.core.web.page.TableDataInfo;
//import com.szmtr.common.log.annotation.Log;
//import com.szmtr.common.log.enums.BusinessType;
//import com.szmtr.common.security.annotation.RequiresPermissions;
//import com.szmtr.business.domain.Rdsapps;
//import com.szmtr.business.dto.query.RdsappsQuery;
//import com.szmtr.business.service.IRdsappsService;
//import com.szmtr.business.dto.*;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletResponse;
//import java.util.List;
//
//
//@RestController
//@RequestMapping("/rdsapps")
//public class RdsappsController extends BaseController {
//
//    @Autowired
//    public IRdsappsService rdsappsService;
//
//
//    @Autowired
//    public IRdsappsoptionService rdsappsoptionService;
//
//    @PostMapping("/list")
//    public AjaxResult page(@RequestBody RdsappsQuery query) {
//
//        return rdsappsService.selectRdsappsPage(query);
//    }
//
//
//    @GetMapping("/get/{id}")
//    public AjaxResult get(@PathVariable String id) {
//        Rdsapps rdsapps = rdsappsService.getById(id);
//        if (null == rdsapps) {
//            return AjaxResult.success();
//        }
//        RdsappsDto rdsappsDto = RdsappsModelConvert.INSTANCE.fromModel(rdsapps);
//        //查询操作
//        List<Rdsappsoption> rdsappsoptionsList = rdsappsoptionService.list(new LambdaQueryWrapper<Rdsappsoption>().eq(Rdsappsoption::getRdsapp, rdsapps.getRdsapp()));
//        rdsappsDto.setList(RdsappsoptionModelConvert.INSTANCE.toDTOList(rdsappsoptionsList));
//        return AjaxResult.success(rdsappsDto);
//    }
//
//    @Log(title = "RDS应用定义新增", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    public AjaxResult add(@RequestBody RdsappsDto rdsappsDto) {
//        int count = 0;
//        if (StringUtils.isEmpty(rdsappsDto.getId())) {
//            count = rdsappsService.count(new LambdaQueryWrapper<Rdsapps>().eq(Rdsapps::getRdsapp, rdsappsDto.getRdsapp()));
//        } else {
//            count = rdsappsService.count(new LambdaQueryWrapper<Rdsapps>().eq(Rdsapps::getRdsapp, rdsappsDto.getRdsapp()).ne(Rdsapps::getId, rdsappsDto.getId()));
//        }
//        if (0 != count) {
//            return AjaxResult.warn("该应用已经存在");
//        }
//        rdsappsService.saveOrUpdate(rdsappsDto);
//        return AjaxResult.success();
//    }
//
//
//    /**
//     * 删除
//     */
//    @DeleteMapping("/delete/{ids}")
//    public AjaxResult deleteByIds(@PathVariable String ids) {
//        if (StringUtils.isNotEmpty(ids)) {
//            String[] args = ids.split(",");
//            for (String id : args) {
//                Rdsapps rdsapps = rdsappsService.getById(id);
//                if (null == rdsapps) {
//                    return AjaxResult.warn("当前数据未保存,请先点击保存按钮");
//                }
//                //查看应用操作，如果有没有删除的就不能删除
//                int count = rdsappsoptionService.count(new LambdaQueryWrapper<Rdsappsoption>().eq(Rdsappsoption::getRdsapp, rdsapps.getRdsapp()));
//                if (0 != count) {
//                    return AjaxResult.warn("应用程序定义：" + rdsapps.getRdsappname() + "(" + rdsapps.getRdsapp() + ")下的操作没有删除");
//                }
//            }
//        }
//        rdsappsService.deleteData(ids);
//        return AjaxResult.success();
//    }
//}
