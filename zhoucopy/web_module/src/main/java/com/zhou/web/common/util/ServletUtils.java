package com.zhou.web.common.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 周刘成   2019/7/4
 */
public class ServletUtils {

    public static ServletRequestAttributes getRequestAttributes() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) attributes;
    }

    /**
     * 获取请求
     */
    public static HttpServletRequest getRequest() {
        return getRequestAttributes().getRequest();
    }

    /**
     * 获取响应头
     */
    public static HttpServletResponse getResponse() {
        return getRequestAttributes().getResponse();
    }

    /**
     * 获取session
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static String getParameterToStr(String string) {
        return getRequest().getParameter(string);
    }

    public static String getParameterToStr(String s, String defaultValue) {
        return Convert.toStr(getRequest().getParameter(s), defaultValue);
    }

    public static Integer getParameterToInt(String s, Integer defaultValue) {
        return Convert.toInt(getRequest().getParameter(s), defaultValue);
    }

    public static Integer getParameterToInt(String s) {
        return Convert.toInt(getRequest().getParameter(s));
    }

    public static Long getParameterToLong(String p, Long defaultValue) {
        return Convert.toLong(getRequest().getParameter(p), defaultValue);
    }

    public static Long getParameterToLong(String p) {
        return Convert.toLong(getRequest().getParameter(p));
    }

}
