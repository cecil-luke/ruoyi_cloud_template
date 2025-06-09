//package com.szmtr.business.service.impl;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.szmtr.business.domain.Rdssection;
//import com.szmtr.business.dto.RdssectionDto;
//import com.szmtr.business.dto.query.RdssectionQuery;
//import com.szmtr.business.mapper.RdssectionMapper;
//import com.szmtr.business.service.IRdssectionService;
//import com.szmtr.common.core.utils.StringUtils;
//import com.szmtr.common.core.web.domain.AjaxResult;
//import org.springframework.stereotype.Service;
//import com.szmtr.common.core.utils.bean.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//import com.szmtr.common.core.utils.bean.BeanUtils;
//
//import java.util.List;
//
//import com.szmtr.common.core.utils.uuid.UUID;
//import com.szmtr.system.dto.*;
//import com.szmtr.system.utils.ModelUtil;
//
//@Service
//@Transactional
//public class RdssectionServiceImpl extends ServiceImpl<RdssectionMapper, Rdssection> implements IRdssectionService {
//
//    @Autowired
//    RdssectionMapper rdssectionMapper;
//
//    @Override
//    public AjaxResult selectRdssectionPage(RdssectionQuery query) {
//        // 构建 MyBatis-Plus 分页对象
//        Page<Rdssection> page = new Page<>(query.getPageNum(), query.getPageSize());
//        // 动态查询条件
//        LambdaQueryWrapper<Rdssection> wrapper = buildQueryWrapper(query);
//        wrapper.orderByDesc(Rdssection::getCreateTime);
//        // 执行分页查询
//        Page<Rdssection> resultPage = rdssectionMapper.selectPage(page, wrapper);
//        // 转换为若依标准分页响应
//        return AjaxResult.success(resultPage);
//    }
//
//    @Override
//    public List<Rdssection> selectRdssectionList(RdssectionQuery query) {
//        LambdaQueryWrapper<Rdssection> wrapper = buildQueryWrapper(query);
//        return rdssectionMapper.selectList(wrapper);
//    }
//
//    private LambdaQueryWrapper<Rdssection> buildQueryWrapper(RdssectionQuery rdssectionquery) {
//        RdssectionDto query = rdssectionquery.getFilter();
//        LambdaQueryWrapper<Rdssection> wrapper = new LambdaQueryWrapper<>();
//        if (query.getCreateTime() != null) {
//            wrapper.eq(Rdssection::getCreateTime, query.getCreateTime());
//        }
//        if (query.getCreateBy() != null) {
//            wrapper.eq(Rdssection::getCreateBy, query.getCreateBy());
//        }
//        if (query.getRdsprefix() != null) {
//            wrapper.eq(Rdssection::getRdsprefix, query.getRdsprefix());
//        }
//        if (query.getRdssectioncode() != null) {
//            wrapper.eq(Rdssection::getRdssectioncode, query.getRdssectioncode());
//        }
//        if (StringUtils.isNotBlank(query.getRdssectionname())) {
//            wrapper.like(Rdssection::getRdssectionname, query.getRdssectionname());
//        }
//        if (query.getRdssectionlength() != null) {
//            wrapper.eq(Rdssection::getRdssectionlength, query.getRdssectionlength());
//        }
//        if (query.getRdsdatatype() != null) {
//            wrapper.eq(Rdssection::getRdsdatatype, query.getRdsdatatype());
//        }
//        if (query.getRdscodetype() != null) {
//            wrapper.eq(Rdssection::getRdscodetype, query.getRdscodetype());
//        }
//        if (query.getRdsvaluelist() != null) {
//            wrapper.eq(Rdssection::getRdsvaluelist, query.getRdsvaluelist());
//        }
//        if (query.getStatus() != null) {
//            wrapper.eq(Rdssection::getStatus, query.getStatus());
//        }
//        return wrapper;
//    }
//
//    public void save(RdssectionDto rdssectionDto) {
//        Rdssection rdssection = new Rdssection();
//        rdssectionDto.setId(UUID.randomUuid());
//        BeanUtils.copyBeanProp(rdssection, rdssectionDto);
//        ModelUtil.fillCreateFields(rdssection);
//        rdssectionMapper.insert(rdssection);
//    }
//
//    public void update(RdssectionDto rdssectionDto) {
//        Rdssection rdssection = new Rdssection();
//        BeanUtils.copyBeanProp(rdssection, rdssectionDto);
//        ModelUtil.fillUpdateFields(rdssection);
//        rdssectionMapper.updateById(rdssection);
//    }
//
//    @Override
//    public void saveOrUpdate(RdssectionDto rdssectionDto) {
//        if (StringUtils.isEmpty(rdssectionDto.getId())) {
//            save(rdssectionDto);
//        } else {
//            update(rdssectionDto);
//        }
//    }
//
//    @Override
//    public void deleteData(String ids) {
//        if (StringUtils.isNotBlank(ids)) {
//            String[] args = ids.split(",");
//            for (String id : args) {
//                rdssectionMapper.deleteById(id);
//            }
//        }
//    }
//
//    @Override
//    public void saveOrUpdateByList(List<RdssectionDto> codeSegmentDefinitionList) {
//        for (RdssectionDto rdssectionDto : codeSegmentDefinitionList) {
//            saveOrUpdateData(rdssectionDto);
//        }
//    }
//
//    private void saveOrUpdateData(RdssectionDto rdssectionDto) {
//        if (StringUtils.isEmpty(rdssectionDto.getId())) {
//            save(rdssectionDto);
//        } else {
//            rdssectionMapper.updateRdssection(rdssectionDto);
//        }
//    }
//}
