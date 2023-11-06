package com.msa.manager.controller.api;

import ch.qos.logback.classic.Logger;
import com.msa.manager.common.interceptor.CustomInterceptor;
import com.msa.manager.common.utils.SHA256Util;
import com.msa.manager.dto.ApiException;
import com.msa.manager.dto.UserDTO;
import com.msa.manager.dto.response.Response;
import com.msa.manager.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
@RequestMapping("/api")
public class LoginApiController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(LoginApiController.class);
    @Autowired
    UserService userService;

    @RequestMapping(value="/login",method = { RequestMethod.POST})
    @ResponseBody
    public Response login(HttpServletRequest request, @RequestBody UserDTO userDTO) {
        try{
            logger.debug("userDTO::::"+userDTO);
            String encPwd = SHA256Util.encSHA256(userDTO.getPassword());
            userDTO.setPassword(encPwd);
            int result = userService.userLogin(userDTO);
            logger.debug("userLogin match user num::::"+result);
            if (result != 1){
                HttpSession session = request.getSession();
                session.setAttribute("user",userDTO);
                return new Response(new ApiException(500,"사용자가 없음"));
            }
        }catch (Exception e){
            return new Response(e);
        }
        return new Response(new ApiException(200,"로그인 성공!!"));
    }
}
