//package com.szmtr.business.service.impl;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.szmtr.business.domain.Rdsapps;
//import com.szmtr.common.core.utils.StringUtils;
//import com.szmtr.business.domain.Rdsappsoption;
//import com.szmtr.business.dto.query.RdsappsoptionQuery;
//import com.szmtr.business.mapper.RdsappsoptionMapper;
//import com.szmtr.business.service.IRdsappsoptionService;
//import com.szmtr.common.core.web.domain.AjaxResult;
//import org.springframework.stereotype.Service;
//import com.szmtr.common.core.utils.bean.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//import com.szmtr.common.core.utils.uuid.UUID;
//import com.szmtr.business.dto.*;
//import com.szmtr.system.utils.ModelUtil;
//
//@Service
//@Transactional
//public class RdsappsoptionServiceImpl extends ServiceImpl<RdsappsoptionMapper, Rdsappsoption> implements IRdsappsoptionService {
//
//    @Autowired
//    RdsappsoptionMapper rdsappsoptionMapper;
//
//    @Override
//    public AjaxResult selectRdsappsoptionPage(RdsappsoptionQuery query) {
//        // 构建 MyBatis-Plus 分页对象
//        Page<Rdsappsoption> page = new Page<>(query.getPageNum(), query.getPageSize());
//        // 动态查询条件
//        LambdaQueryWrapper<Rdsappsoption> wrapper = buildQueryWrapper(query);
//        wrapper.orderByDesc(Rdsappsoption::getCreateTime);
//        // 执行分页查询
//        Page<Rdsappsoption> resultPage = rdsappsoptionMapper.selectPage(page, wrapper);
//        // 转换为若依标准分页响应
//        return AjaxResult.success(resultPage);
//    }
//
//    @Override
//    public List<Rdsappsoption> selectRdsappsoptionList(RdsappsoptionQuery query) {
//        LambdaQueryWrapper<Rdsappsoption> wrapper = buildQueryWrapper(query);
//        return rdsappsoptionMapper.selectList(wrapper);
//    }
//
//    private LambdaQueryWrapper<Rdsappsoption> buildQueryWrapper(RdsappsoptionQuery rdsappsoptionquery) {
//        RdsappsoptionDto query = rdsappsoptionquery.getFilter();
//        LambdaQueryWrapper<Rdsappsoption> wrapper = new LambdaQueryWrapper<>();
//        if (query.getCreateTime() != null) {
//            wrapper.eq(Rdsappsoption::getCreateTime, query.getCreateTime());
//        }
//        if (query.getCreateBy() != null) {
//            wrapper.eq(Rdsappsoption::getCreateBy, query.getCreateBy());
//        }
//        if (query.getUpdateTime() != null) {
//            wrapper.eq(Rdsappsoption::getUpdateTime, query.getUpdateTime());
//        }
//        if (query.getDelFlag() != null) {
//            wrapper.eq(Rdsappsoption::getDelFlag, query.getDelFlag());
//        }
//        if (query.getUpdateBy() != null) {
//            wrapper.eq(Rdsappsoption::getUpdateBy, query.getUpdateBy());
//        }
//        if (query.getRdsapp() != null) {
//            wrapper.eq(Rdsappsoption::getRdsapp, query.getRdsapp());
//        }
//        if (query.getRdsoption() != null) {
//            wrapper.like(Rdsappsoption::getRdsoption, query.getRdsoption());
//        }
//        if (StringUtils.isNotBlank(query.getRdsoptionname())) {
//            wrapper.like(Rdsappsoption::getRdsoptionname, query.getRdsoptionname());
//        }
//        if (query.getRdsseqnum() != null) {
//            wrapper.like(Rdsappsoption::getRdsseqnum, query.getRdsseqnum());
//        }
//        return wrapper;
//    }
//
//    public void save(RdsappsoptionDto rdsappsoptionDto) {
//        Rdsappsoption rdsappsoption = new Rdsappsoption();
//        rdsappsoptionDto.setId(UUID.randomUuid());
//        BeanUtils.copyBeanProp(rdsappsoption, rdsappsoptionDto);
//        ModelUtil.fillCreateFields(rdsappsoption);
//        rdsappsoptionMapper.insert(rdsappsoption);
//    }
//
//    public void update(RdsappsoptionDto rdsappsoptionDto) {
//        Rdsappsoption rdsappsoption = new Rdsappsoption();
//        BeanUtils.copyBeanProp(rdsappsoption, rdsappsoptionDto);
//        ModelUtil.fillUpdateFields(rdsappsoption);
//        rdsappsoptionMapper.updateByData(rdsappsoption);
//    }
//
//    @Override
//    public void saveOrUpdate(RdsappsoptionDto rdsappsoptionDto) {
//        if (StringUtils.isEmpty(rdsappsoptionDto.getId())) {
//            save(rdsappsoptionDto);
//        } else {
//            Rdsappsoption rdsappsoption = rdsappsoptionMapper.selectEntity(rdsappsoptionDto.getId());
//            if (null == rdsappsoption) {
//                save(rdsappsoptionDto);
//            } else {
//                rdsappsoptionDto.setDelFlag(0);
//                update(rdsappsoptionDto);
//            }
//        }
//    }
//
//    @Override
//    public void deleteData(String ids) {
//        if (StringUtils.isNotBlank(ids)) {
//            String[] args = ids.split(",");
//            for (String id : args) {
//                rdsappsoptionMapper.deleteById(id);
//            }
//        }
//    }
//
//    @Override
//    public void saveList(List<RdsappsoptionDto> list, String rdsapp) {
//        for (RdsappsoptionDto rdsappsoptionDto : list) {
//            rdsappsoptionDto.setRdsapp(rdsapp);
//            saveOrUpdate(rdsappsoptionDto);
//        }
//    }
//}
