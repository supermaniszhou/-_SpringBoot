package com.family.zhou.controller.sys;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.family.zhou.controller.common.AjaxResult;
import com.family.zhou.controller.common.BaseController;
import com.family.zhou.pojo.SysUser;
import com.family.zhou.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 周刘成   2019/7/8
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping(value = "/login")
    public String loginPage(HttpServletRequest request, HttpServletResponse response) {
        if (isAjaxRequest(request)) {
            return renderString(response, "{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }
        return "login";
    }

    @PostMapping("/doLogin")
    @ResponseBody
    public AjaxResult doLogin(String loginName, String password) {

        SysUser sysUser = new SysUser();
        sysUser.setLoginName(loginName);
        sysUser.setPassword(password);
        SysUser user = sysUserService.selectSysUserByName(sysUser);
        if (user != null) {
            return success();
        }
        return error();
    }
}
