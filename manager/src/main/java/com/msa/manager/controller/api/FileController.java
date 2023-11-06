package com.msa.manager.controller.api;

import ch.qos.logback.classic.Logger;
import com.msa.manager.common.utils.FileUtil;
import com.msa.manager.common.utils.SHA256Util;
import com.msa.manager.dto.ApiException;
import com.msa.manager.dto.UserDTO;
import com.msa.manager.dto.response.Response;
import com.msa.manager.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@EnableAutoConfiguration
@RequestMapping("/api")
public class FileController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(FileController.class);
    @Autowired
    UserService userService;

    /*@RequestMapping(value="/filedownload",method = { RequestMethod.POST})
    @ResponseBody
    public ResponseEntity file_download(@RequestParam("fileName") String fileName) throws IOException {
        String filePath = "C:/TEST/" + fileName;
        ResponseEntity result = FileUtil.fileDownload(filePath);
        return result;
    }*/
    @RequestMapping(value="/filedownload",method = { RequestMethod.GET})
    @ResponseBody
    public ResponseEntity file_download(@RequestParam("fileName") String fileName) throws IOException {
        String filePath = "C:/TEST/" + fileName;


        ResponseEntity result = FileUtil.fileDownload(filePath);
        return result;
    }



}
