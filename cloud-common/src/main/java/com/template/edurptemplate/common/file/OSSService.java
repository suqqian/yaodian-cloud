package com.template.edurptemplate.common.file;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @ProjectName: springboot-plugins
 * @Package: com.my.service
 * @ClassName: OSSService
 * @Author: 作者名字
 * @Description:
 * @Version: 1.0
 */
@Service
public class OSSService {
    @Autowired
    private OSSClient ossClient;
    @Autowired
    private OSSConfig ossConfig;

    public void update() throws Throwable {
        String filePath = "/Users/作者名字/java_pro/my-springboot-plugins/springboot-plugins/springboot-file-opt/img/test.png";
        ossClient.putObject(ossConfig.getBucketName(),"test.png",new File(filePath));
    }

}
