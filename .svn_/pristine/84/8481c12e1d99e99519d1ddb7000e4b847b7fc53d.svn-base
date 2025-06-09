//package com.szmtr.business.service.impl;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.szmtr.business.domain.Rdsappsoption;
//import com.szmtr.business.service.IRdsappsoptionService;
//import com.szmtr.common.core.utils.StringUtils;
//import com.szmtr.business.domain.Rdsapps;
//import com.szmtr.business.dto.query.RdsappsQuery;
//import com.szmtr.business.mapper.RdsappsMapper;
//import com.szmtr.business.service.IRdsappsService;
//import com.szmtr.common.core.utils.bean.BeanUtils;
//import com.szmtr.common.core.web.domain.AjaxResult;
//import org.springframework.stereotype.Service;
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
//public class RdsappsServiceImpl extends ServiceImpl<RdsappsMapper, Rdsapps> implements IRdsappsService {
//
//    @Autowired
//    RdsappsMapper rdsappsMapper;
//
//    @Autowired
//    IRdsappsoptionService rdsappsoptionService;
//
//    @Override
//    public AjaxResult selectRdsappsPage(RdsappsQuery query) {
//        // 构建 MyBatis-Plus 分页对象
//        Page<Rdsapps> page = new Page<>(query.getPageNum(), query.getPageSize());
//        // 动态查询条件
//        LambdaQueryWrapper<Rdsapps> wrapper = buildQueryWrapper(query);
//        wrapper.orderByDesc(Rdsapps::getCreateTime);
//        // 执行分页查询
//        Page<Rdsapps> resultPage = rdsappsMapper.selectPage(page, wrapper);
//        // 转换为若依标准分页响应
//        return AjaxResult.success(resultPage);
//    }
//
//    @Override
//    public List<Rdsapps> selectRdsappsList(RdsappsQuery query) {
//        LambdaQueryWrapper<Rdsapps> wrapper = buildQueryWrapper(query);
//        return rdsappsMapper.selectList(wrapper);
//    }
//
//    private LambdaQueryWrapper<Rdsapps> buildQueryWrapper(RdsappsQuery rdsappsquery) {
//        RdsappsDto query = rdsappsquery.getFilter();
//        LambdaQueryWrapper<Rdsapps> wrapper = new LambdaQueryWrapper<>();
//        if (query.getCreateTime() != null) {
//            wrapper.eq(Rdsapps::getCreateTime, query.getCreateTime());
//        }
//        if (query.getCreateBy() != null) {
//            wrapper.eq(Rdsapps::getCreateBy, query.getCreateBy());
//        }
//        if (query.getUpdateTime() != null) {
//            wrapper.eq(Rdsapps::getUpdateTime, query.getUpdateTime());
//        }
//        if (query.getUpdateBy() != null) {
//            wrapper.eq(Rdsapps::getUpdateBy, query.getUpdateBy());
//        }
//        if (StringUtils.isNotBlank(query.getRdsapp())) {
//            wrapper.like(Rdsapps::getRdsapp, query.getRdsapp());
//        }
//        if (StringUtils.isNotBlank(query.getRdsappname())) {
//            wrapper.like(Rdsapps::getRdsappname, query.getRdsappname());
//        }
//        if (null != query.getRdsseqnum()) {
//            wrapper.like(Rdsapps::getRdsseqnum, query.getRdsseqnum());
//        }
//        if (StringUtils.isNotBlank(query.getRdsmodule())) {
//            wrapper.like(Rdsapps::getRdsmodule, query.getRdsmodule());
//        }
//        return wrapper;
//    }
//
//    public void save(RdsappsDto rdsappsDto) {
//        Rdsapps rdsapps = new Rdsapps();
//        rdsappsDto.setId(UUID.randomUuid());
//        BeanUtils.copyBeanProp(rdsapps, rdsappsDto);
//        ModelUtil.fillCreateFields(rdsapps);
//        rdsappsMapper.insert(rdsapps);
//    }
//
//    public void update(RdsappsDto rdsappsDto) {
//        Rdsapps rdsapps = new Rdsapps();
//        BeanUtils.copyBeanProp(rdsapps, rdsappsDto);
//        ModelUtil.fillUpdateFields(rdsapps);
//        rdsappsMapper.updateById(rdsapps);
//    }
//
//    @Override
//    public void saveOrUpdate(RdsappsDto rdsappsDto) {
//        if (StringUtils.isEmpty(rdsappsDto.getId())) {
//            save(rdsappsDto);
//        } else {
//            Rdsapps rdsapps = getById(rdsappsDto.getId());
//            if (null == rdsapps) {
//                save(rdsappsDto);
//            } else {
//                update(rdsappsDto);
//            }
//        }
//        rdsappsoptionService.remove(new LambdaQueryWrapper<Rdsappsoption>().eq(Rdsappsoption::getRdsapp, rdsappsDto.getRdsapp()));
//        rdsappsoptionService.saveList(rdsappsDto.getList(), rdsappsDto.getRdsapp());
//    }
//
//    @Override
//    public void deleteData(String ids) {
//        if (StringUtils.isNotBlank(ids)) {
//            String[] args = ids.split(",");
//            for (String id : args) {
//                rdsappsMapper.deleteById(id);
//            }
//        }
//    }
//}
