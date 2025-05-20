package cn.atxm.controller;

import cn.atxm.pojo.Result;
import cn.atxm.utils.AliyunOSSOperator;
import com.aliyuncs.exceptions.ClientException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/7
 */
@Slf4j
@RestController
public class UploadController {

    @Autowired
    AliyunOSSOperator aliyunOSSOperator;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException, ClientException {
        String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        return Result.success(url);
    }
}
