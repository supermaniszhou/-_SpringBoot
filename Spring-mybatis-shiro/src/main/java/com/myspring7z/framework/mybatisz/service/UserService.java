package com.myspring7z.framework.mybatisz.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;
import com.myspring7z.framework.mybatisz.entity.User;
import com.myspring7z.framework.mybatisz.repository.UserDao;

@Component
@Transactional
public class UserService {
	
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;

	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserDao userDao;

	// 根据用户名查找用户
	public User getUserByLoginName(String loginName) {
		Map<String, Object> parameters = Maps.newHashMap();
		parameters.put("loginName", loginName);
		return userDao.findUserByLoginName(parameters);
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
