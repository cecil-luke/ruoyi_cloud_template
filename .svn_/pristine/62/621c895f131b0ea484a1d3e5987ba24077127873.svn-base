//package com.szmtr.system.controller;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.szmtr.common.core.utils.bean.BeanUtils;
//import com.szmtr.common.core.web.controller.BaseController;
//import com.szmtr.common.core.web.domain.AjaxResult;
//import com.szmtr.common.log.annotation.Log;
//import com.szmtr.common.log.enums.BusinessType;
//import com.szmtr.common.rabbitmq.service.MessageProducer;
//import com.szmtr.system.domain.SysFileEntity;
//import com.szmtr.system.domain.Test;
//import com.szmtr.system.domain.convert.SysFileModelConvert;
//import com.szmtr.system.dto.query.TestQuery;
//import com.szmtr.system.mapper.SysFileMapper;
//import com.szmtr.system.service.ITestService;
//import com.szmtr.system.dto.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping("/test")
//public class TestController extends BaseController {
//
//    @Autowired
//    public ITestService testService;
//    @Autowired
//    private SysFileMapper sysFileMapper;
//
//    @Autowired
//    private MessageProducer messageProducer;
//
//    @PostMapping("/list")
//    public AjaxResult page(@RequestBody TestQuery query) {
//        return testService.selectTestPage(query);
//    }
//
//
//    @GetMapping("/get/{id}")
//    public AjaxResult get(@PathVariable String id) {
//        Test test = testService.getById(id);
//        TestDto testDto = new TestDto();
//        BeanUtils.copyBeanProp(testDto, test);
//        List<SysFileEntity> list = sysFileMapper.selectList(new LambdaQueryWrapper<SysFileEntity>().eq(SysFileEntity::getBusinessKey, testDto.getId()));
//        List<SysFileDto> dtoList = SysFileModelConvert.INSTANCE.toDTOList(list);
////        for (SysFileEntity sysFile : list) {
////            SysFileDto dto = new SysFileDto();
////            BeanUtils.copyBeanProp(dto, sysFile);
////            dtoList.add(dto);
////        }
//        testDto.setList(dtoList);
//        return AjaxResult.success(testDto);
//    }
//
//    @Log(title = "【请填写功能名称】新增", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    public AjaxResult add(@RequestBody TestDto testDto) {
//        testService.saveOrUpdate(testDto);
//        messageProducer.sendMessage(testDto.getName());
//        return AjaxResult.success();
//    }
//
//    /**
//     * 删除
//     */
//    @DeleteMapping("/delete/{ids}")
//    public AjaxResult deleteByIds(@PathVariable String ids) {
//        testService.deleteData(ids);
//        return AjaxResult.success();
//    }
//}
