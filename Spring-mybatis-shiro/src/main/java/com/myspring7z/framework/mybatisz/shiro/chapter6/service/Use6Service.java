package com.myspring7z.framework.mybatisz.shiro.chapter6.service;

import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.myspring7z.framework.mybatisz.shiro.chapter6.dao.User6Dao;
import com.myspring7z.framework.mybatisz.shiro.chapter6.entity.User6;
import com.myspring7z.framework.mybatisz.shiro.chapter6.utils.PasswordHelper;

@Component
public class Use6Service {
	
	private PasswordHelper passwordHelper = new PasswordHelper();
	
	@Autowired
	private User6Dao user6Dao;
	
	public User6 createUser(User6 user){
		
		passwordHelper.encryptPassword(user);
		
		user6Dao.createUser(user);
		
		return user;
		
	}
	
	public void changePassword(Long userId, String newPassword) {
        User6 user =user6Dao.findOne(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        user6Dao.updateUser(user);
    }
	
	/*public void updateUser(User6 user) {
		user6Dao.updateUser(user);
    }*/
	
	public void deleteUser(Long userId) {
		user6Dao.deleteUser(userId);
    }
	
	public void correlationRoles(Long userId, Long roleId){
		user6Dao.correlationRoles(userId, roleId);
	}
    
    public void uncorrelationRoles(Long userId, Long roleId){
    	user6Dao.uncorrelationRoles(userId, roleId);
    }
    
    public boolean exists(Long userId, Long roleId){
    	return user6Dao.exists(userId, roleId);
    }
    
    public User6 findOne(Long userId){
    	return user6Dao.findOne(userId);
    }
    
    public User6 findByUsername(String username){
    	return user6Dao.findByUsername(username);
    }

    public Set<String> findRoles(String username){
    	return user6Dao.findRoles(username);
    }

    public Set<String> findPermissions(String username){
    	return user6Dao.findPermissions(username);
    }
    
    public void deleteAllUsers(){
    	user6Dao.deleteAllUsers();
    }

	public User6Dao getUser6Dao() {
		return user6Dao;
	}

	public void setUser6Dao(User6Dao user6Dao) {
		this.user6Dao = user6Dao;
	}
	
	
}
