package com.msa.manager.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import com.msa.manager.common.utils.FileUtil;
import com.msa.manager.dto.CvUserDTO;
import com.msa.manager.dto.Response.Response;
import com.msa.manager.service.CvUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@EnableAutoConfiguration
@RequestMapping("/api")
public class LoginController {
    private static final Logger logger = Logger.getLogger(LoginController.class.getName());


    @Autowired
    CvUserService cvUserService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Response loginCheck(@RequestBody CvUserDTO cvUserDTO) throws IOException {
        Response response = new Response();
        //1. 사용자 체크
        logger.log(Level.INFO,"fuck",cvUserDTO);
        CvUserDTO user = cvUserService.userLogin(cvUserDTO);
        if (user == null){
            response.setStatus("[ERROR]");
            response.setMessage("사용자 계정 또는 비밀번호가 맞지 않습니다.");
            return response;
        }

        if (cvUserDTO.getPassword().equals(user.getPassword())){
            response.setStatus("[SUCCESS]");
            response.setMessage("SUCCESS");
        }else{
            response.setStatus("[ERROR]");
            response.setMessage("사용자 비밀번호가 맞지 않습니다.");
        }



        return response;
    }

}
