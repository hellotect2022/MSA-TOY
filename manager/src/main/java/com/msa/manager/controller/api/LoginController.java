package com.msa.manager.controller.api;
import com.msa.manager.common.utils.ErrorCode;
import com.msa.manager.common.utils.RequestStatus;
import com.msa.manager.dto.CvUserDTO;
import com.msa.manager.dto.Response.Response;
import com.msa.manager.service.CvUserService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Log4j2
@EnableAutoConfiguration
@Controller
@RequestMapping("/api")
public class LoginController {

    @Autowired
    CvUserService cvUserService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Response loginCheck(@RequestBody CvUserDTO cvUserDTO) throws IOException {
        Response response = new Response();
        // 사용자 요청
        log.debug("login",cvUserDTO);
        // 사용자체크

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

    private void checkUserValidation(){
        // E1101(1001,"없는 사용자 입니다.")
        // E1102(1002,"탈퇴 한 사용자 입니다."),
        // E1103(1003,"제한된 사용자 입니다. (pw 횟수초과)"),
        // E1104(1004,"비밀번호가 맞지 않습니다.");
    }


}
