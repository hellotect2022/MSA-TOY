package com.msa.manager.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.manager.common.utils.FileUtil;
import com.msa.manager.dto.CvUserDTO;
import com.msa.manager.service.CvUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@EnableAutoConfiguration
@Controller
@RequestMapping("/test")
public class TestApiController {

    @Autowired
    CvUserService cvUserService;

    @RequestMapping("/check")
    @ResponseBody
    public String home() {
        return "Hello Nice to meet you";
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

//    @RequestMapping("/getUsers")
//    @ResponseBody
//    public String getAllUsers() throws IOException {
//        List<CvUserDTO> result = cvUserService.getCvUser();
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.writeValueAsString(result);
//
//        return objectMapper.writeValueAsString(result);
//    }
}
