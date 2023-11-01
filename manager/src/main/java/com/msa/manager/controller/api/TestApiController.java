package com.msa.manager.controller.api;

import com.msa.manager.common.utils.FileUtil;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
        String result = FileUtil.fileUpload(file,"test");
        return result;
    }

    @RequestMapping("/filedownload")
    @ResponseBody
    public ResponseEntity file_download(@RequestParam("fileName") String fileName) throws IOException {
        String filePath = "C:/TEST/" + fileName;
        ResponseEntity result = FileUtil.fileDownload(filePath);
        return result;
    }
}
