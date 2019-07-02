package com.myspring7z.framework.mybatisz.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myspring7z.framework.mybatisz.entity.UltravioletLightForecast;
import com.myspring7z.framework.mybatisz.service.UltravioletLightForecastService;

@Controller
@RequestMapping("/uvl")
public class UltravioletLightForecastController {
	
	@Autowired
	private UltravioletLightForecastService ultravioletLightForecastService;
	
	@RequestMapping("/index")
	public String index(){
		return "uvl/index";
	}
	
	/**
	 * 根据时次查找是否有UltravioletLightForecast记录
	 * @author muzili90
	 * @date 2018-01-02
	 */
	@ResponseBody
	@RequestMapping("getUVLForecastsByDateTime")
	public List<UltravioletLightForecast> getUVLForecastsByDateTime(UltravioletLightForecast ultravioletLightForecast, HttpServletRequest request, HttpServletResponse response, Model model) {
		
		System.out.println("getDateTime:"+ultravioletLightForecast.getDateTime());
		
		List<UltravioletLightForecast> list=ultravioletLightForecastService.getUVLForecastsByDateTime(ultravioletLightForecast);
		
		return list;
	}

	public UltravioletLightForecastService getUltravioletLightForecastService() {
		return ultravioletLightForecastService;
	}

	public void setUltravioletLightForecastService(UltravioletLightForecastService ultravioletLightForecastService) {
		this.ultravioletLightForecastService = ultravioletLightForecastService;
	}

	
}
