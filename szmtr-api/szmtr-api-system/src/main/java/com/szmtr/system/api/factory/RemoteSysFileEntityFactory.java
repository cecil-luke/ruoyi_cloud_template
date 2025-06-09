package com.szmtr.system.api.factory;

import com.szmtr.common.core.domain.R;
import com.szmtr.common.core.domain.Result;
import com.szmtr.system.api.RemoteFileService;
import com.szmtr.system.api.RemoteSysFileEntityService;
import com.szmtr.system.api.domain.SysFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


/**
 * 保存文件实体的降级处理
 *
 * @author szmtr
 */
@Component
public class RemoteSysFileEntityFactory implements FallbackFactory<RemoteSysFileEntityService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteFileFallbackFactory.class);

    @Override
    public RemoteSysFileEntityService create(Throwable throwable) {
        log.error("文件服务调用失败:{}", throwable.getMessage());
        return new RemoteSysFileEntityService() {
            @Override
            public Result save(SysFile SysFile) {
                return Result.fail("保存文件失败:" + throwable.getMessage());
            }

            @Override
            public Result getInfo(String id) {
                return Result.fail("获取文件失败:" + throwable.getMessage());
            }

            @Override
            public Result<SysFile> remove(String[] ids) {
                return Result.fail("删除失败文件失败:" + throwable.getMessage());
            }

            @Override
            public Result getListByBusinessKey(String businessKey) {
                return Result.fail("获取文件列表失败:" + throwable.getMessage());
            }
        };
    }
}