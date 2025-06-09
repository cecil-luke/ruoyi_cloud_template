package com.szmtr.file.controller;

import com.alibaba.nacos.common.http.param.MediaType;
import com.szmtr.common.core.domain.Result;
import com.szmtr.common.core.utils.StringUtils;
import com.szmtr.common.core.utils.uuid.UUID;
import com.szmtr.file.config.MinioConfig;
import com.szmtr.file.service.ISysFileService;
import com.szmtr.file.service.MinioSysFileServiceImpl;
import com.szmtr.file.utils.FileUploadUtils;
import com.szmtr.system.api.RemoteSysFileEntityService;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import io.minio.http.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.szmtr.common.core.domain.R;
import com.szmtr.common.core.utils.file.FileUtils;
import com.szmtr.system.api.domain.SysFile;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

/**
 * 文件请求处理
 *
 * @author szmtr
 */
@RestController

public class SysFileController {
    private static final Logger log = LoggerFactory.getLogger(SysFileController.class);

    @Resource
    private ISysFileService sysFileService;

    @Resource
    private RemoteSysFileEntityService remoteSysFileEntityService;

    @Resource
    private MinioConfig minioConfig;

    @Resource
    private MinioClient client;

    @Value("${minio.expirDate}")
    private int expirtDate;

    @Value("${minio.bucketName}")
    private String bucketName;

    @Resource
    private MinioSysFileServiceImpl minioSysFileService;

    /**
     * 文件上传请求
     */
    @PostMapping("upload")
    public Result<SysFile> upload(MultipartFile file) {
        try {
            // 上传并返回访问地址
            String url = sysFileService.uploadFile(file);
            SysFile sysFile = new SysFile();
            sysFile.setUrl(url);
            sysFile.setId(UUID.randomUuid());
            sysFile.setFileSize(file.getSize() + "");
            sysFile.setFileNameOld(file.getOriginalFilename());
            String fileName = FileUploadUtils.extractFilename(file);
            sysFile.setName(fileName);
            sysFile.setBucket(bucketName);
            Result result = remoteSysFileEntityService.save(sysFile);
            result.setData(sysFile);
            return result;
        } catch (Exception e) {
            log.error("上传文件失败", e);
            return Result.fail(e.getMessage());
        }
    }

    /**
     * 生成有效的文件地址
     */
    @GetMapping("/getFileUrl")
    public Result getFileUrl(@NotNull(message = "文件主键不能为空") String id) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        Result<SysFile> result = remoteSysFileEntityService.getInfo(id);
        SysFile sysFile = (SysFile) Result.ok().getData();
        String url = client.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder().method(Method.GET).bucket(sysFile.getBucket()).object(sysFile.getName()).expiry(expirtDate, TimeUnit.DAYS).build());
        return Result.ok(url);
    }

    /**
     * 文件下载
     */
    @GetMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam String id) {
        try {
            Result<SysFile> result = remoteSysFileEntityService.getInfo(id);
            SysFile sysFile = (SysFile) Result.ok().getData();
            byte[] bytes = minioSysFileService.downloadFile(sysFile);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment", sysFile.getName());
            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /**
     * 删除文件
     */
    @DeleteMapping("/delete")
    public Result<String> delete(@RequestParam String ids) {
        try {
            if (StringUtils.isEmpty(ids)) {
                return Result.fail("文件主键为空");
            }
            String[] args = ids.split(",");
            Result<SysFile> result = remoteSysFileEntityService.remove(args);
            return Result.ok("删除成功");
        } catch (Exception e) {
            return Result.fail("");
        }
    }
}