package com.zhou.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 周刘成   2019/7/4
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Value("${shiro.user.loginUrl}")
    private String loginUrl;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:" + loginUrl);
    }
}
