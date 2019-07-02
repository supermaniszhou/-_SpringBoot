package com.myspring7z.framework.testtwo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.myspring7z.framework.mybatisz.entity.IdEntity;

@Entity
@Table(name = "test_person")
public class Person extends IdEntity{

	private static final long serialVersionUID = 1L;
	
	private String name;

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
