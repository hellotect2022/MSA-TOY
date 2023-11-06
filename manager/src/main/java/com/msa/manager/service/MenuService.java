package com.msa.manager.service;

import ch.qos.logback.classic.Logger;
import com.msa.manager.controller.api.LoginApiController;
import com.msa.manager.dto.MenuDTO;
import jakarta.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(MenuService.class);
    @Resource(name="sqlSessionTemplateDB1")
    SqlSession session;
    public List<MenuDTO> getMenus(){
        List<MenuDTO> dbMenus = session.selectList("db.xml.menu.getMenus");
        List<MenuDTO> menus = new ArrayList<>();
        for (MenuDTO menuItem : dbMenus){
            if (menuItem.getDepth()==1){
                menus.add(menuItem);
            }else {

                for (int i=0; i<menus.size();i++){
                    if (menus.get(i).getMenuId().equals(menuItem.getParentMenuId())){
                        menus.get(i).addSubMenu(menuItem);
                        logger.debug("menus:::->"+i,menus.get(i).getMenuName());
                    }
                }

            }
        }
        logger.debug("menus:::->",menus);
        return menus;
    }
}
