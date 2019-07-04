package com.zhou.web.common;

import com.zhou.web.common.util.ServletUtils;
import com.zhou.web.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 周刘成   2019/7/4
 */
public class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(BaseController.class);

    public HttpServletRequest getRequest() {
        return ServletUtils.getRequest();
    }

    public HttpServletResponse getResponse() {
        return ServletUtils.getResponse();
    }

    public HttpSession getSession() {
        return ServletUtils.getSession();
    }

    /**
     * 将字符串渲染到客户端
     *
     * @param response
     * @param p
     * @return
     */
    public String renderString(HttpServletResponse response, String p) {
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(p);
        } catch (IOException io) {
            io.printStackTrace();
        }
        return null;
    }

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


}
