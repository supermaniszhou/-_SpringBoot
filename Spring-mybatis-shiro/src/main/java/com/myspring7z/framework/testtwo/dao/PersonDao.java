package com.myspring7z.framework.testtwo.dao;

import com.myspring7z.framework.mybatisz.repository.MyBatisRepository;
import com.myspring7z.framework.testtwo.entity.Person;

@MyBatisRepository
public interface PersonDao {
	
	public Person get(Long id);
	
	public Person save (Person person);
}
