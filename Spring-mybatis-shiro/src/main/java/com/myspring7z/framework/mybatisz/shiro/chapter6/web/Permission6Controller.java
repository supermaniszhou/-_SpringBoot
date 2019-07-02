package com.myspring7z.framework.mybatisz.shiro.chapter6.web;

import javax.xml.ws.RespectBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myspring7z.framework.mybatisz.shiro.chapter6.entity.Permission6;
import com.myspring7z.framework.mybatisz.shiro.chapter6.service.Permission6Service;

@Controller
@RequestMapping(value = "/permission6")
public class Permission6Controller {
	
	@Autowired
	Permission6Service permission6Service;
	
	@ResponseBody
	@RequestMapping("/test")
	public Permission6 test(){
		Permission6 p=new Permission6();
		p.setPermission("test");
		p.setDescription("test");
		p.setAvailable(true);
		permission6Service.createPermission(p);
		return p;
	}

}
