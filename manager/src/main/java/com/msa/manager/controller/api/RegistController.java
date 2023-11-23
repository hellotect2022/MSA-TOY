package com.msa.manager.controller.api;

import com.msa.manager.common.utils.ErrorCode;
import com.msa.manager.common.utils.RequestStatus;
import com.msa.manager.dto.CvUserDTO;
import com.msa.manager.dto.Response.Response;
import com.msa.manager.service.CvUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Log4j2
@EnableAutoConfiguration
@Controller
@RequestMapping("/api")
public class RegistController {
    //private static final Logger logger = Logger.getLogger(RegistController.class.getName());

    @Autowired
    CvUserService cvUserService;

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    @ResponseBody
    public Response loginCheck(@RequestBody CvUserDTO cvUserDTO) throws IOException {
        Response response = new Response();
        //1. 사용자 체크
        log.debug("test",cvUserDTO);
        CvUserDTO user = cvUserService.userLogin(cvUserDTO);

        if (user == null){
            response.setHeader(RequestStatus.ERROR, ErrorCode.E1004.getErrorCode(),ErrorCode.E1004.getErrorMessage());
            return response;
        }

        if (cvUserDTO.getPassword().equals(user.getPassword())){
            response.setHeader(RequestStatus.ERROR, ErrorCode.E1004.getErrorCode(),ErrorCode.E1004.getErrorMessage());
        }else{
            response.setHeader(RequestStatus.ERROR, ErrorCode.E1004.getErrorCode(),ErrorCode.E1004.getErrorMessage());
        }



        return response;
    }

}
