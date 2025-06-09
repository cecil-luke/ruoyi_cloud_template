package com.szmtr.system.api;


import com.szmtr.common.core.constant.ServiceNameConstants;
import com.szmtr.common.core.domain.R;
import com.szmtr.common.core.domain.Result;
import com.szmtr.system.api.domain.SysFile;
import com.szmtr.system.api.factory.RemoteFileFallbackFactory;
import com.szmtr.system.api.factory.RemoteSysFileEntityFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * 调用系统模块的文件服务，保存文件
 *
 * @author szmtr
 */
@FeignClient(contextId = "remoteSysFileEntityService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteSysFileEntityFactory.class)
public interface RemoteSysFileEntityService {

    /**
     * 上传文件
     *
     * @param file 文件信息
     * @return 结果
     */
    @PostMapping(value = "/sysFile/save")
    public Result save(SysFile file);

    /**
     * 上传文件
     *
     * @return 结果
     * @para
     */
    @GetMapping(value = "/sysFile/get", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result<SysFile> getInfo(String id);

    /**
     * 删除文件
     *
     * @param ids 文件的主键
     * @return
     */
    @DeleteMapping(value = "/sysFile/remove", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result<SysFile> remove(String[] ids);


    /**
     * 查询附件
     *
     * @param businessKey 文件的主键
     * @return
     */
    @DeleteMapping(value = "/sysFile/getListByBusinessKey", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result getListByBusinessKey(String businessKey);
}
