package com.myspring7z.framework.testtwo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myspring7z.framework.mybatisz.entity.UltravioletLightForecast;
import com.myspring7z.framework.mybatisz.service.UltravioletLightForecastService;
import com.myspring7z.framework.testtwo.entity.Person;
import com.myspring7z.framework.testtwo.service.PersonService;

@Controller
@RequestMapping(value="/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@ResponseBody
	@RequestMapping(value="test")
	public void test(){
		Person Person=personService.get(1L);
		System.out.println(Person==null);
	}

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	

}
