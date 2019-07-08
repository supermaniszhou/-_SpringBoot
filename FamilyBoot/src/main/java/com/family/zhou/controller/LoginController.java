package com.family.zhou.controller;

import com.family.zhou.controller.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 周刘成   2019/7/8
 */
@Controller
public class LoginController extends BaseController {

    @GetMapping(value = "/login")
    public String loginPage(HttpServletRequest request, HttpServletResponse response) {
        if(isAjaxRequest(request)){
            return renderString(response, "{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }
        return "login";
    }
}
