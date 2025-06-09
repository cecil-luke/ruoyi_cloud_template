//package com.szmtr.system.service.impl;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.szmtr.common.core.utils.StringUtils;
//import com.szmtr.system.api.domain.SysFile;
//import com.szmtr.system.domain.SysFileEntity;
//import com.szmtr.system.domain.Test;
//import com.szmtr.system.dto.query.TestQuery;
//import com.szmtr.system.mapper.SysFileMapper;
//import com.szmtr.system.mapper.TestMapper;
//import com.szmtr.system.service.ISysFileService;
//import com.szmtr.system.service.ITestService;
//import com.szmtr.common.core.web.domain.AjaxResult;
//import org.springframework.stereotype.Service;
//import com.szmtr.common.core.utils.bean.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.time.LocalDateTime;
//import java.util.Date;
//import java.util.List;
//
//import com.szmtr.common.core.utils.uuid.UUID;
//import com.szmtr.system.dto.*;
//import com.szmtr.system.utils.ModelUtil;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@Transactional
//public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {
//
//    @Autowired
//    TestMapper testMapper;
//
//    @Autowired
//    ISysFileService sysFileService;
//
//    @Autowired
//    SysFileMapper sysFileMapper;
//
//    @Override
//    public AjaxResult selectTestPage(TestQuery query) {
//        // 构建 MyBatis-Plus 分页对象
//        Page<Test> page = new Page<>(query.getPageNum(), query.getPageSize());
//        // 动态查询条件
//        LambdaQueryWrapper<Test> wrapper = buildQueryWrapper(query);
//        // 执行分页查询
//        Page<Test> resultPage = testMapper.selectPage(page, wrapper);
//        // 转换为若依标准分页响应
//        return AjaxResult.success(resultPage);
//    }
//
//    @Override
//    public List<Test> selectTestList(TestQuery query) {
//        LambdaQueryWrapper<Test> wrapper = buildQueryWrapper(query);
//        return testMapper.selectList(wrapper);
//    }
//
//    private LambdaQueryWrapper<Test> buildQueryWrapper(TestQuery testquery) {
//        TestDto query = testquery.getFilter();
//        LambdaQueryWrapper<Test> wrapper = new LambdaQueryWrapper<>();
//        if (StringUtils.isNotBlank(query.getName())) {
//            wrapper.like(Test::getName, query.getName());
//        }
//        if (query.getDescription() != null) {
//            wrapper.eq(Test::getDescription, query.getDescription());
//        }
//        return wrapper;
//    }
//
//    public void save(TestDto testDto) {
//        Test test = new Test();
//        testDto.setId(UUID.randomUuid());
//        BeanUtils.copyBeanProp(test, testDto);
//        ModelUtil.fillCreateFields(test);
//        //保存附件
//        if (StringUtils.isNotBlank(testDto.getFileIds())) {
//            String[] args = testDto.getFileIds().split(",");
//            for (String fid : args) {
//                SysFileEntity sysFile = sysFileService.getById(fid);
//                sysFile.setBusinessKey(testDto.getId());
//                sysFileService.updateById(sysFile);
//            }
//        }
//        testMapper.insert(test);
//    }
//
//    public void update(TestDto testDto) {
//        Test test = new Test();
//        BeanUtils.copyBeanProp(test, testDto);
//        ModelUtil.fillUpdateFields(test);
//        testMapper.updateById(test);
//        sysFileMapper.delete(new LambdaQueryWrapper<SysFileEntity>().eq(SysFileEntity::getBusinessKey, testDto.getId()));
//        //保存附件
//        if (StringUtils.isNotBlank(testDto.getFileIds())) {
//            String[] args = testDto.getFileIds().split(",");
//            for (String fid : args) {
//                SysFileEntity sysFile = sysFileService.getSysFileById(fid);
//                sysFile.setBusinessKey(testDto.getId());
//                sysFile.setUpdateTime(LocalDateTime.now());
//                sysFileService.updateSysFileById(sysFile);
//            }
//        }
//    }
//
//    @Override
//    public void saveOrUpdate(TestDto testDto) {
//        if (StringUtils.isEmpty(testDto.getId())) {
//            save(testDto);
//        } else {
//            update(testDto);
//        }
//    }
//
//    @Override
//    public void deleteData(String ids) {
//        if (StringUtils.isNotBlank(ids)) {
//            String[] args = ids.split(",");
//            for (String id : args) {
//                testMapper.deleteById(id);
//            }
//        }
//    }
//}
