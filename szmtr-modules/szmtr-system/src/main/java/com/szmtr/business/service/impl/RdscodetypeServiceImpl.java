//package com.szmtr.business.service.impl;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.szmtr.business.domain.Rdscodegroup;
//import com.szmtr.business.domain.Rdscodetype;
//import com.szmtr.business.domain.Rdssection;
//import com.szmtr.business.domain.convert.RdscodegroupModelConvert;
//import com.szmtr.business.domain.convert.RdscodetypeModelConvert;
//import com.szmtr.business.domain.convert.RdssectionModelConvert;
//import com.szmtr.business.dto.RdscodegroupDto;
//import com.szmtr.business.dto.RdscodetypeDto;
//import com.szmtr.business.dto.RdssectionDto;
//import com.szmtr.business.dto.query.RdscodetypeQuery;
//import com.szmtr.business.mapper.RdscodetypeMapper;
//import com.szmtr.business.service.IRdscodegroupService;
//import com.szmtr.business.service.IRdscodetypeService;
//import com.szmtr.business.service.IRdssectionService;
//import com.szmtr.common.core.utils.StringUtils;
//import com.szmtr.common.core.web.domain.AjaxResult;
//import org.springframework.stereotype.Service;
//import com.szmtr.common.core.utils.bean.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.szmtr.common.core.utils.uuid.UUID;
//import com.szmtr.system.dto.*;
//import com.szmtr.system.utils.ModelUtil;
//
//@Service
//@Transactional
//public class RdscodetypeServiceImpl extends ServiceImpl<RdscodetypeMapper, Rdscodetype> implements IRdscodetypeService {
//
//    @Autowired
//    RdscodetypeMapper rdscodetypeMapper;
//
//    @Autowired
//    public IRdssectionService rdssectionService;
//
//    @Autowired
//    public IRdscodegroupService rdscodegroupService;
//
//    @Override
//    public AjaxResult selectRdscodetypePage(RdscodetypeQuery query) {
//        // 构建 MyBatis-Plus 分页对象
//        Page<Rdscodetype> page = new Page<>(query.getPageNum(), query.getPageSize());
//        // 动态查询条件
//        LambdaQueryWrapper<Rdscodetype> wrapper = buildQueryWrapper(query);
//        // 执行分页查询
//        //排序
//        wrapper.orderByDesc(Rdscodetype::getCreateTime);
//        Page<Rdscodetype> resultPage = rdscodetypeMapper.selectPage(page, wrapper);
//        // 转换为若依标准分页响应
//        Page<RdscodetypeDto> newPage = new Page();
//        if (null != resultPage && null != resultPage.getRecords() && resultPage.getRecords().size() != 0) {
//            List<RdscodetypeDto> rdscodetypeDtoList = new ArrayList<>();
//            for (Rdscodetype rdscodetype : resultPage.getRecords()) {
//                //查询编码类型的编码段定义
//                RdscodetypeDto rdscodetypeDto = RdscodetypeModelConvert.INSTANCE.toDTO(rdscodetype);
//                List<Rdssection> codeSegmentDefinitionList = rdssectionService.list(new LambdaQueryWrapper<Rdssection>().eq(Rdssection::getRdscodetype, rdscodetypeDto.getRdscodetype()));
//                rdscodetypeDto.setCodeSegmentDefinitionList(RdssectionModelConvert.INSTANCE.toDTOList(codeSegmentDefinitionList));
//                //规则
//                List<Rdscodegroup> rdscodegroupList = rdscodegroupService.list(new LambdaQueryWrapper<Rdscodegroup>().eq(Rdscodegroup::getRdscodetype, rdscodetypeDto.getRdscodetype()));
//                rdscodetypeDto.setCodingRulesList(RdscodegroupModelConvert.INSTANCE.toDTOList(rdscodegroupList));
//                rdscodetypeDtoList.add(rdscodetypeDto);
//            }
//            newPage.setRecords(rdscodetypeDtoList);
//            newPage.setTotal(resultPage.getTotal());
//            return AjaxResult.success(newPage);
//        }
//        return AjaxResult.success(resultPage);
//    }
//
//    @Override
//    public List<Rdscodetype> selectRdscodetypeList(RdscodetypeQuery query) {
//        LambdaQueryWrapper<Rdscodetype> wrapper = buildQueryWrapper(query);
//        return rdscodetypeMapper.selectList(wrapper);
//    }
//
//    private LambdaQueryWrapper<Rdscodetype> buildQueryWrapper(RdscodetypeQuery rdscodetypequery) {
//        RdscodetypeDto query = rdscodetypequery.getFilter();
//        LambdaQueryWrapper<Rdscodetype> wrapper = new LambdaQueryWrapper<>();
//        if (query.getRdscodetype() != null) {
//            wrapper.like(Rdscodetype::getRdscodetype, query.getRdscodetype());
//        }
//        if (StringUtils.isNotBlank(query.getRdscodetypename())) {
//            wrapper.like(Rdscodetype::getRdscodetypename, query.getRdscodetypename());
//        }
//        if (query.getRdsversion() != null) {
//            wrapper.like(Rdscodetype::getRdsversion, query.getRdsversion());
//        }
//        if (query.getRdsremark() != null) {
//            wrapper.like(Rdscodetype::getRdsremark, query.getRdsremark());
//        }
//        return wrapper;
//    }
//
//    public void save(RdscodetypeDto rdscodetypeDto) {
//        Rdscodetype rdscodetype = new Rdscodetype();
//        BeanUtils.copyBeanProp(rdscodetype, rdscodetypeDto);
//        ModelUtil.fillCreateFields(rdscodetype);
//        rdscodetypeMapper.insert(rdscodetype);
//    }
//
//    public void update(RdscodetypeDto rdscodetypeDto) {
//        Rdscodetype rdscodetype = new Rdscodetype();
//        BeanUtils.copyBeanProp(rdscodetype, rdscodetypeDto);
//        ModelUtil.fillUpdateFields(rdscodetype);
//        rdscodetypeMapper.updateById(rdscodetype);
//    }
//
//    @Override
//    public void saveOrUpdate(RdscodetypeDto rdscodetypeDto) {
//        if (StringUtils.isEmpty(rdscodetypeDto.getId())) {
//            save(rdscodetypeDto);
//        } else {
//            update(rdscodetypeDto);
//        }
//    }
//
//    @Override
//    public void deleteData(String ids) {
//        if (StringUtils.isNotBlank(ids)) {
//            String[] args = ids.split(",");
//            for (String id : args) {
//                rdscodetypeMapper.deleteById(id);
//            }
//        }
//    }
//
//    @Override
//    public void saveOrUpdateByCode(RdscodetypeDto rdscodetypeDto) {
//        RdscodetypeDto dto = rdscodetypeMapper.isOrNotExists(rdscodetypeDto.getRdscodetype());
//        if (null == dto) {
//            save(rdscodetypeDto);
//        } else {
//            dto.setRdscodetype(rdscodetypeDto.getRdscodetype());
//            dto.setRdscodetypename(rdscodetypeDto.getRdscodetypename());
//            dto.setRdsremark(rdscodetypeDto.getRdsremark());
//            dto.setRdsversion(rdscodetypeDto.getRdsversion());
//            update(dto);
//        }
//    }
//
//    @Override
//    public void saveOrUpdateById(RdscodetypeDto rdscodetypeDto) {
//        if (StringUtils.isEmpty(rdscodetypeDto.getId())) {
//            save(rdscodetypeDto);
//        } else {
//            Rdscodetype rdscodetype = getById(rdscodetypeDto.getId());
//            if (null == rdscodetype) {
//                save(rdscodetypeDto);
//            } else {
//                update(rdscodetypeDto);
//            }
//        }
//        //先删除
//        rdssectionService.remove(new LambdaQueryWrapper<Rdssection>().eq(Rdssection::getRdscodetype, rdscodetypeDto.getRdscodetype()));
//        rdssectionService.saveOrUpdateByList(rdscodetypeDto.getCodeSegmentDefinitionList());
//    }
//}
