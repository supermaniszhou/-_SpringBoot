package com.family.zhou.controller.sys;

import com.family.zhou.controller.common.BaseController;
import com.family.zhou.pojo.SysMenu;
import com.family.zhou.service.SysMenuService;
import com.family.zhou.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 周刘成   2019/7/9
 */
@Controller
public class IndexController extends BaseController {

    @Autowired
    private SysUserService userService;
    @Autowired
    private SysMenuService menuService;

    @GetMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        List<SysMenu> menus = menuService.selectAllMenu();
        model.put("menus", menus);
        return "index";
    }
}
