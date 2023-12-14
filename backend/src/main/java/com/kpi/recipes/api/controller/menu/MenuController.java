package com.kpi.recipes.api.controller.menu;
import com.kpi.recipes.model.Menu;
import com.kpi.recipes.service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {
    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public List<Menu> getcategories(){
        return menuService.getMenus();
    }
}

