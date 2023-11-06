package com.msa.manager.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MenuDTO {
    private	String		menuId;
    private	String	systemCode;
    private int		depth;
    private int		seq;
    private String	parentMenuId;
    private String	menuName;
    private String	linkUrl;
    private String	createId;
    private String	createDate;
    private String	updateId;
    private String	updateDate;

    private List<MenuDTO> subMenus;

    public void addSubMenu(MenuDTO menu)
    {
        if(subMenus == null)
        {
            subMenus = new ArrayList<>();
        }

        subMenus.add(menu);
    }

}
