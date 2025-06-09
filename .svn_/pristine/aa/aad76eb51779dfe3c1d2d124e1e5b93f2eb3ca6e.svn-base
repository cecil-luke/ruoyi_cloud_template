//package com.szmtr.system.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.io.IOException;
//import javax.servlet.http.HttpServletResponse;
//import javax.validation.constraints.NotNull;
//
//import com.szmtr.common.core.domain.R;
//import com.szmtr.common.core.domain.Result;
//import com.szmtr.common.core.utils.bean.BeanUtils;
//import com.szmtr.system.domain.SysFileEntity;
//import com.szmtr.system.dto.SysFileDto;
//import com.szmtr.system.api.domain.SysFile;
//import com.szmtr.system.utils.ModelUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.szmtr.common.log.annotation.Log;
//import com.szmtr.common.log.enums.BusinessType;
//import com.szmtr.common.security.annotation.RequiresPermissions;
//import com.szmtr.system.service.ISysFileService;
//import com.szmtr.common.core.web.controller.BaseController;
//import com.szmtr.common.core.utils.poi.ExcelUtil;
//import com.szmtr.common.core.web.page.TableDataInfo;
//
///**
// * 文件上传Controller
// *
// * @author 严欢
// * @date 2025-04-07
// */
//@RestController
//@RequestMapping("/sysFile")
//public class SysFileController extends BaseController {
//    @Autowired
//    private ISysFileService sysFileService;
//
//
//    @PostMapping("/save")
//    public Result<Integer> save(@RequestBody SysFile sysFile) {
//        SysFileEntity sysFile1 = new SysFileEntity();
//        BeanUtils.copyBeanProp(sysFile1, sysFile);
//        ModelUtil.fillCreateFields(sysFile1);
//        if (sysFileService.save(sysFile1)) {
//            return Result.ok(1);
//        }
//        return Result.fail();
//    }
//
//}
