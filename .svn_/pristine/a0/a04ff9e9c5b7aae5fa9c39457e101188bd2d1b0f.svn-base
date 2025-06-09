//package com.szmtr.business.service.impl;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.szmtr.common.core.utils.StringUtils;
//import com.szmtr.business.domain.Rdscodegroup;
//import com.szmtr.business.dto.query.RdscodegroupQuery;
//import com.szmtr.business.mapper.RdscodegroupMapper;
//import com.szmtr.business.service.IRdscodegroupService;
//import com.szmtr.common.core.web.domain.AjaxResult;
//import org.springframework.stereotype.Service;
//import com.szmtr.common.core.utils.bean.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//import com.szmtr.common.core.utils.bean.BeanUtils;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import com.szmtr.common.core.utils.uuid.UUID;
//import com.szmtr.business.dto.*;
//import com.szmtr.system.utils.ModelUtil;
//
//@Service
//@Transactional
//public class RdscodegroupServiceImpl extends ServiceImpl<RdscodegroupMapper, Rdscodegroup> implements IRdscodegroupService {
//
//    @Autowired
//        RdscodegroupMapper rdscodegroupMapper;
//
//    @Override
//    public AjaxResult selectRdscodegroupPage(RdscodegroupQuery query) {
//        // 构建 MyBatis-Plus 分页对象
//        Page<Rdscodegroup> page = new Page<>(query.getPageNum(), query.getPageSize());
//        // 动态查询条件
//        LambdaQueryWrapper<Rdscodegroup> wrapper = buildQueryWrapper(query);
//        wrapper.orderByDesc(Rdscodegroup::getCreateTime);
//        // 执行分页查询
//        Page<Rdscodegroup> resultPage = rdscodegroupMapper.selectPage(page, wrapper);
//        // 转换为若依标准分页响应
//        return AjaxResult.success(resultPage);
//    }
//
//    @Override
//    public List<Rdscodegroup> selectRdscodegroupList(RdscodegroupQuery query) {
//        LambdaQueryWrapper<Rdscodegroup> wrapper = buildQueryWrapper(query);
//        return rdscodegroupMapper.selectList(wrapper);
//    }
//
//        private LambdaQueryWrapper<Rdscodegroup> buildQueryWrapper(RdscodegroupQuery rdscodegroupquery) {
//            RdscodegroupDto query = rdscodegroupquery.getFilter();
//        LambdaQueryWrapper<Rdscodegroup> wrapper = new LambdaQueryWrapper<>();
//                    if (query.getCreateTime() != null) {
//                        wrapper.eq(Rdscodegroup::getCreateTime, query.getCreateTime());
//                    }
//                    if (query.getCreateBy() != null) {
//                        wrapper.eq(Rdscodegroup::getCreateBy, query.getCreateBy());
//                    }
//                    if (query.getUpdateTime() != null) {
//                        wrapper.eq(Rdscodegroup::getUpdateTime, query.getUpdateTime());
//                    }
//                    if (query.getUpdateBy() != null) {
//                        wrapper.eq(Rdscodegroup::getUpdateBy, query.getUpdateBy());
//                    }
//                    if (query.getRdsgrouprulenum() != null) {
//                        wrapper.eq(Rdscodegroup::getRdsgrouprulenum, query.getRdsgrouprulenum());
//                    }
//                    if (StringUtils.isNotBlank(query.getRdsgrouprulename())) {
//                        wrapper.like(Rdscodegroup::getRdsgrouprulename, query.getRdsgrouprulename());
//                    }
//                    if (query.getRdsprefix() != null) {
//                        wrapper.eq(Rdscodegroup::getRdsprefix, query.getRdsprefix());
//                    }
//                    if (query.getRdsversion() != null) {
//                        wrapper.eq(Rdscodegroup::getRdsversion, query.getRdsversion());
//                    }
//                    if (query.getRdsgroupstatus() != null) {
//                        wrapper.eq(Rdscodegroup::getRdsgroupstatus, query.getRdsgroupstatus());
//                    }
//                    if (query.getRdsspecnum() != null) {
//                        wrapper.eq(Rdscodegroup::getRdsspecnum, query.getRdsspecnum());
//                    }
//                    if (query.getRdscodetype() != null) {
//                        wrapper.eq(Rdscodegroup::getRdscodetype, query.getRdscodetype());
//                    }
//                    if (query.getDelFlag() != null) {
//                        wrapper.eq(Rdscodegroup::getDelFlag, query.getDelFlag());
//                    }
//                    if (query.getRdssectionnum() != null) {
//                        wrapper.eq(Rdscodegroup::getRdssectionnum, query.getRdssectionnum());
//                    }
//                    if (query.getRdscodedetail() != null) {
//                        wrapper.eq(Rdscodegroup::getRdscodedetail, query.getRdscodedetail());
//                    }
//                    if (query.getRdscreatedate() != null) {
//                        wrapper.eq(Rdscodegroup::getRdscreatedate, query.getRdscreatedate());
//                    }
//        return wrapper;
//    }
//
//    public void save(RdscodegroupDto rdscodegroupDto) {
//        Rdscodegroup rdscodegroup =new Rdscodegroup();
//            rdscodegroupDto.setId(UUID.randomUuid());
//        rdscodegroupDto.setRdscreatedate(LocalDateTime.now());
//        BeanUtils.copyBeanProp(rdscodegroup, rdscodegroupDto);
//        ModelUtil.fillCreateFields(rdscodegroup);
//            rdscodegroupMapper.insert(rdscodegroup);
//    }
//
//    public void update(RdscodegroupDto rdscodegroupDto) {
//        Rdscodegroup rdscodegroup =new Rdscodegroup();
//        BeanUtils.copyBeanProp(rdscodegroup, rdscodegroupDto);
//        ModelUtil.fillUpdateFields(rdscodegroup);
//            rdscodegroupMapper.updateById(rdscodegroup);
//    }
//
//    @Override
//    public void saveOrUpdate(RdscodegroupDto rdscodegroupDto) {
//        if (StringUtils.isEmpty(rdscodegroupDto.getId())) {
//            save(rdscodegroupDto);
//        } else {
//            update(rdscodegroupDto);
//        }
//    }
//
//    @Override
//    public void deleteData(String ids) {
//        if (StringUtils.isNotBlank(ids)) {
//            String[] args = ids.split(",");
//            for (String id : args) {
//                    rdscodegroupMapper.deleteById(id);
//            }
//        }
//    }
//}
