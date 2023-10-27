package com.msa.manager.controller.monitor;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@EnableAutoConfiguration
public class HomeController {

    @GetMapping("/home/login.do")
    //@ResponseBody
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("home/login");
        return mav;
    }
}
