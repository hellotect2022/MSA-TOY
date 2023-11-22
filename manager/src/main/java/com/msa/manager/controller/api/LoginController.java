package com.msa.manager.controller.api;
import com.msa.manager.common.utils.ErrorCode;
import com.msa.manager.common.utils.RequestStatus;
import com.msa.manager.dto.CvUserDTO;
import com.msa.manager.dto.Response.Response;
import com.msa.manager.service.CvUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
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
