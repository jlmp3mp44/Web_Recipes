package com.kpi.recipes.service;

import com.kpi.recipes.model.Menu;
import com.kpi.recipes.model.dao.MenuDAO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuService {
    private MenuDAO menuDAO;

    public MenuService(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }

    public List<Menu> getMenus(){
        return menuDAO.findAll();
    }
}
