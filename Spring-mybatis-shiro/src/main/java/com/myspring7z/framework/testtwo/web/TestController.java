package com.myspring7z.framework.testtwo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myspring7z.framework.mybatisz.entity.UltravioletLightForecast;
import com.myspring7z.framework.mybatisz.service.UltravioletLightForecastService;

@Controller
@RequestMapping(value="/test2")
public class TestController {
	
	@Autowired
	private UltravioletLightForecastService ultravioletLightForecastService;
	
	@ResponseBody
	@RequestMapping(value="test")
	public void test(){
		UltravioletLightForecast ultravioletLightForecast=ultravioletLightForecastService.get(1L);
		System.out.println(ultravioletLightForecast==null);
	}

}
