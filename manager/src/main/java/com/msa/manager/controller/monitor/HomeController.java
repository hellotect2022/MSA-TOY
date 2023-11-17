package com.msa.manager.controller.monitor;

import com.msa.manager.dto.TestDTO;
import com.msa.manager.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@EnableAutoConfiguration
@RequestMapping("/home")
public class HomeController {

//    @GetMapping("/home/login.do")
//    //@ResponseBody
//    public ModelAndView home() {
//        ModelAndView mav = new ModelAndView("home/login");
//        return mav;
//    }

    @GetMapping("/login.do")
    public String home() {
        return "covision/login";
    }

    @Autowired
    TestService testService;
    @GetMapping("/hello.do")
    public String monitor_hello(Model model){
        int one =0;
        List<TestDTO> testUsers = testService.getTestUser();
        TestDTO first = testUsers.get(0);
        model.addAttribute("user",first);
        return "home/hello";
    }
    @GetMapping("/file.do")
    public String monitor_file(Model model){
        int one =0;
//        List<TestDTO> testUsers = testService.getTestUser();
//        TestDTO first = testUsers.get(0);
//        model.addAttribute("user",first);
        return "home/file";
    }
}
