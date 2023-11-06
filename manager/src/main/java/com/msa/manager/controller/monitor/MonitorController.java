package com.msa.manager.controller.monitor;

import com.msa.manager.dto.TestDTO;
import com.msa.manager.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@EnableAutoConfiguration
@RequestMapping(value="/monitor")
public class MonitorController {
    @Autowired
    TestService testService;
    @GetMapping("/login.do")
    public String monitor_login(Model model){
        return "monitor/login";
    }

    @GetMapping("/dashboard.do")
    public String monitor_dashboard(Model model){
        return "monitor/dashboard";
    }

}
