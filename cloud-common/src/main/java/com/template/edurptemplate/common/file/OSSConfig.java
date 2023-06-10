package com.template.edurptemplate.common.file;

import com.aliyun.oss.OSSClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: springboot-plugins
 * @Package: com.my.config
 * @ClassName: OSSConfig
 * @Author: 作者名字
 * @Description:
 * @Version: 1.0
 */
@Data
@Configuration
public class OSSConfig {
    @Value("${aliyun.file.endpoint}")
    private String endpoint;

    @Value("${aliyun.file.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyun.file.accessKeySecret}")
    private String accessKeySecret;
    @Value("${aliyun.file.bucketName}")
    private String bucketName;

    @Value("${aliyun.file.webUrl}")
    private String webUrl;


    @Bean
    public OSSClient getOSSClient() {
        return new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }


}
