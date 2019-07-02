package com.myspring7z.framework.testtwo.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.myspring7z.framework.testtwo.dao.PersonDao;
import com.myspring7z.framework.testtwo.entity.Person;

@Component
@Transactional
public class PersonService {

	private static Logger logger = LoggerFactory.getLogger(PersonService.class);
	
	@Autowired
	private PersonDao personDao;

	// 根据用户名查找用户
	public Person get(long id) {
		return personDao.get(id);
	}
	
	public void save(Person person){
		personDao.save(person);
	}

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
	
	
}
