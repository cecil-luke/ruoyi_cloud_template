package com.szmtr.file.service;

import java.io.InputStream;

import com.szmtr.system.api.domain.SysFile;
import io.minio.GetObjectArgs;
import io.minio.RemoveObjectArgs;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.nacos.common.utils.IoUtils;
import com.szmtr.file.config.MinioConfig;
import com.szmtr.file.utils.FileUploadUtils;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;

/**
 * Minio 文件存储
 *
 * @author szmtr
 */
@Service
public class MinioSysFileServiceImpl implements ISysFileService {
    @Autowired
    private MinioConfig minioConfig;

    @Autowired
    private MinioClient client;

    /**
     * Minio文件上传接口
     *
     * @param file 上传的文件
     * @return 访问地址
     * @throws Exception
     */
    @Override
    public String uploadFile(MultipartFile file) throws Exception {
        InputStream inputStream = null;
        try {
            String fileName = FileUploadUtils.extractFilename(file);
            inputStream = file.getInputStream();
            PutObjectArgs args = PutObjectArgs.builder().bucket(minioConfig.getBucketName()).object(fileName).stream(inputStream, file.getSize(), -1).contentType(file.getContentType()).build();
            client.putObject(args);
            return minioConfig.getUrl() + "/" + minioConfig.getBucketName() + "/" + fileName;
        } catch (Exception e) {
            throw new RuntimeException("Minio Failed to upload file", e);
        } finally {
            IoUtils.closeQuietly(inputStream);
        }
    }

    /**
     * 下载文件
     */
    public byte[] downloadFile(SysFile sysFile) throws Exception {
        try (InputStream stream = client.getObject(GetObjectArgs.builder().bucket(sysFile.getBucket()).object(sysFile.getName()).build())) {
            return IOUtils.toByteArray(stream);
        }
    }

    /**
     * 删除文件
     */
    public void deleteFile(SysFile sysFile) throws Exception {
        client.removeObject(RemoveObjectArgs.builder().bucket(sysFile.getBucket()).object(sysFile.getName()).build());
    }
}
