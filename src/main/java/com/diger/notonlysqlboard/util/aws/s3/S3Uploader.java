package com.diger.notonlysqlboard.util.aws.s3;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class S3Uploader {

    // Fake
    public String[] execute(MultipartFile[] multipartFiles) {
        return new String[]{"https://k-diger.github.io", "https://github.com/k-diger"};
    }
}
