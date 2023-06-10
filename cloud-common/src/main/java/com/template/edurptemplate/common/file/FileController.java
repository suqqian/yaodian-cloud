package com.template.edurptemplate.common.file;

import com.aliyun.oss.OSSClient;
import com.template.edurptemplate.common.entity.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @ProjectName: edurp-template
 * @Package: com.template.edurptemplate.common.file
 * @ClassName: FileController
 * @Author: 作者名字
 * @Description:
 * @Version: 1.0
 */
@RequestMapping("file")
@Controller
public class FileController {
    @Autowired
    private OSSClient ossClient;
    @Autowired
    private OSSConfig ossConfig;

    @ResponseBody
    @PostMapping("upload")
    public ResponseData fileUpload(MultipartFile file) {
        ResponseData responseData = new ResponseData();
        String fileName = UUID.randomUUID().toString() + file.getOriginalFilename();
        try {
            ossClient.putObject(ossConfig.getBucketName(), fileName, file.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        responseData.setCode(200);
        responseData.setUrl(ossConfig.getWebUrl() + fileName);

        return responseData;

    }

    @ResponseBody
    @PostMapping("uploadWang")
    public WangResult fileUpload2(MultipartFile myFile) throws IOException {
        System.out.println(myFile.getOriginalFilename());
        WangData wangData = new WangData();
        ResponseData responseData = new ResponseData();
        String fileName = UUID.randomUUID().toString() + myFile.getOriginalFilename();
        try {
            ossClient.putObject(ossConfig.getBucketName(), fileName, myFile.getInputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }
        wangData.setAlt(ossConfig.getWebUrl() + fileName);
        wangData.setHref(ossConfig.getWebUrl() + fileName);
        wangData.setUrl(ossConfig.getWebUrl() + fileName);
        List list = new ArrayList();
        list.add(wangData);
        WangResult wangResult = new WangResult();
        wangResult.setErrno(0);
        wangResult.setData(list);
        return wangResult;
    }
}
