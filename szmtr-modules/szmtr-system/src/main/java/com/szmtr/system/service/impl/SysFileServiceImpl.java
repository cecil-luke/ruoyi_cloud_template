//package com.szmtr.system.service.impl;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.szmtr.common.core.utils.bean.BeanUtils;
//import com.szmtr.common.core.web.domain.AjaxResult;
//import com.szmtr.common.core.web.page.TableDataInfo;
//import com.szmtr.system.api.domain.SysFile;
//import com.szmtr.system.domain.SysFileEntity;
//import com.szmtr.system.dto.query.SysFileQuery;
//import com.szmtr.system.mapper.SysFileMapper;
//import com.szmtr.system.service.ISysFileService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//@Transactional
//public class SysFileServiceImpl extends ServiceImpl<SysFileMapper, SysFileEntity> implements ISysFileService {
//
//    @Autowired
//    SysFileMapper sysFileMapper;
//
//    @Override
//    public AjaxResult selectSysFileEntityPage(SysFileQuery query) {
//        // 构建 MyBatis-Plus 分页对象
//        Page<SysFileEntity> page = new Page<>(query.getPageNum(), query.getPageSize());
//        // 动态查询条件
//        LambdaQueryWrapper<SysFileEntity> wrapper = buildQueryWrapper(query);
//        // 执行分页查询
//        Page<SysFileEntity> resultPage = sysFileMapper.selectPage(page, wrapper);
//        // 转换为若依标准分页响应
//        return AjaxResult.success(resultPage);
//    }
//
//    @Override
//    public List<SysFileEntity> selectSysFileEntityList(SysFileQuery query) {
//        LambdaQueryWrapper<SysFileEntity> wrapper = buildQueryWrapper(query);
//        return sysFileMapper.selectList(wrapper);
//    }
//
//    @Override
//    public SysFileEntity getSysFileById(String fid) {
//        return sysFileMapper.getSysFileById(fid);
//    }
//
//    @Override
//    public void updateSysFileById(SysFileEntity sysFile) {
//        sysFileMapper.updateSysFileById(sysFile);
//    }
//
//    private LambdaQueryWrapper<SysFileEntity> buildQueryWrapper(SysFileQuery query) {
//        LambdaQueryWrapper<SysFileEntity> wrapper = new LambdaQueryWrapper<>();
//        SysFileEntity sysFile = new SysFileEntity();
//        return wrapper;
//    }
//
//
//}
