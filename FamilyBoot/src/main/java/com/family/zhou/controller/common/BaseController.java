package com.family.zhou.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 周刘成   2019/7/8
 */
public class BaseController {
    /**
     * 是否是Ajax异步请求
     *
     * @param request
     * @return
     */
    public boolean isAjaxRequest(HttpServletRequest request) {
        String xRequestedWith = request.getHeader("X-Requested-With");
        boolean isAjax = false;
        if (null != xRequestedWith) {
            isAjax = "XMLHttpRequest".equals(xRequestedWith) ? true : false;
        }
        return isAjax;
    }

    public String renderString(HttpServletResponse response, String msg) {
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
