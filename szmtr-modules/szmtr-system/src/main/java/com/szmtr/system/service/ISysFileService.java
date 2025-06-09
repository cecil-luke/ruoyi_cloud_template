//package com.szmtr.system.service;
//
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.baomidou.mybatisplus.extension.service.IService;
//import com.szmtr.common.core.web.domain.AjaxResult;
//import com.szmtr.common.core.web.page.TableDataInfo;
//import com.szmtr.system.domain.SysFileEntity;
//import com.szmtr.system.dto.query.SysFileQuery;
//
//import java.util.List;
//
//public interface ISysFileService extends IService<SysFileEntity> {
//
//    AjaxResult selectSysFileEntityPage(SysFileQuery query);
//
//    List<SysFileEntity> selectSysFileEntityList(SysFileQuery query);
//
//    SysFileEntity getSysFileById(String fid);
//
//    void updateSysFileById(SysFileEntity sysFile);
//}
