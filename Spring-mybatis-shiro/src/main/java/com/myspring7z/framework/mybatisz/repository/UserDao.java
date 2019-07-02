package com.myspring7z.framework.mybatisz.repository;

import java.util.Map;

import com.myspring7z.framework.mybatisz.entity.User;

@MyBatisRepository
public interface UserDao {
	
	User get(Long id);
	
	User findUserByLoginName(Map<String, Object> parameters);
}
