package com.msa.manager.controller.monitor;

import ch.qos.logback.classic.Logger;
import com.msa.manager.controller.api.LoginApiController;
import com.msa.manager.dto.MenuDTO;
import com.msa.manager.dto.TestDTO;
import com.msa.manager.service.MenuService;
import com.msa.manager.service.TestService;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = (Logger) LoggerFactory.getLogger(MonitorController.class);
    @Autowired
    TestService testService;

    @Autowired
    MenuService menuService;

    @GetMapping("/login.do")
    public String monitor_login(Model model){
        return "monitor/login";
    }

    @GetMapping("/dashboard.do")
    public String monitor_dashboard(Model model){

        List<MenuDTO> menus = menuService.getMenus();
        logger.debug("menus->",menus);

        model.addAttribute("menus",menus);
        return "monitor/dashboard";
    }

}
