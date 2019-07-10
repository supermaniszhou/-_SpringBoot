package com.family.zhou.controller.sys;

import com.family.zhou.controller.common.BaseController;
import com.family.zhou.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 周刘成   2019/7/9
 */
@Controller
public class IndexController extends BaseController {

    @Resource
    private SysUserService userService;

    @GetMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        return "index";
    }
}
