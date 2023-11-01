package com.msa.manager.controller.api;

import com.msa.manager.common.utils.FileUtil;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@EnableAutoConfiguration
public class TestApiController {

    @RequestMapping("/hello")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }

    @RequestMapping("/fileupload")
    @ResponseBody
    public String file_upload(MultipartFile file) {
        int test = 1;
        String result = FileUtil.fileUpload(file,"test");
        return result;
    }
}
