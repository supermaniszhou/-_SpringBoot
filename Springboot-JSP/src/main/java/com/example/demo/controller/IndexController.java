package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 周刘成   2019/5/6
 */
@RestController
public class IndexController {

    @RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }
    @RequestMapping("/hello")
    public ModelAndView hello(){
        return new ModelAndView("test/hello");
    }
}
