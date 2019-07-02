package com.myspring7z.framework.mybatisz.shiro.chapter6.dao;

import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.myspring7z.framework.mybatisz.repository.MyBatisRepository;
import com.myspring7z.framework.mybatisz.shiro.chapter6.entity.User6;

@MyBatisRepository
public interface User6Dao {
	
	public void createUser(User6 user);
    public void updateUser(User6 user);
    public void deleteUser(Long userId);

    //public void correlationRoles(Long userId, Long... roleIds);
    //public void uncorrelationRoles(Long userId, Long... roleIds);
    
    //添加用户-角色关系
    public void correlationRoles(@Param("userId") Long userId, @Param("roleId") Long roleId);
    
    //移除用户-角色关系
    public void uncorrelationRoles(@Param("userId") Long userId, @Param("roleId") Long roleId);
    
    public boolean exists(@Param("userId") Long userId, @Param("roleId") Long roleId);

    public User6 findOne(Long userId);

    public User6 findByUsername(String username);

    public Set<String> findRoles(String username);

    public Set<String> findPermissions(String username);
    
    public void deleteAllUsers();
    
}
