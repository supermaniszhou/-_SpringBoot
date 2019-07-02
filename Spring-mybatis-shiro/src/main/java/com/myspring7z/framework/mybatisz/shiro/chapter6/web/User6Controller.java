package com.myspring7z.framework.mybatisz.shiro.chapter6.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myspring7z.framework.mybatisz.shiro.chapter6.entity.User6;
import com.myspring7z.framework.mybatisz.shiro.chapter6.service.Use6Service;

@Controller
@RequestMapping(value = "/user")
public class User6Controller {

	@Autowired
	private Use6Service user6Service;
	
	@ResponseBody
	@RequestMapping("/testAddUser")
	public User6 addUser(HttpServletRequest request, HttpServletResponse response, Model model) {
		User6 user=new User6();
		user.setUsername("lee");
		user.setPassword("pwd");
		user.setSalt("123");
		user.setLocked(false);
		return user6Service.createUser(user);
	}
	
	@RequestMapping("/testIndex")
	public String testIndex(){
		return "user6/index";
	}
	
	@ResponseBody
	@RequestMapping("/testAddUser2")
	public User6 addUser2(User6 user6,HttpServletRequest request, HttpServletResponse response, Model model) {
		return user6Service.createUser(user6);
	}
}
