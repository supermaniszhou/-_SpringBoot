package com.myspring7z.framework.mybatisz.shiro.chapter6.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myspring7z.framework.mybatisz.shiro.chapter6.dao.Role6Dao;
import com.myspring7z.framework.mybatisz.shiro.chapter6.entity.Role6;

@Component
public class Role6Service {

	@Autowired
	Role6Dao role6Dao;
	
	public Role6 createRole(Role6 role){
		role6Dao.createRole(role);
		return role;
	}
    public void deleteRole(Long roleId){
    	role6Dao.deleteRole(roleId);
    }

    //public void correlationPermissions(Long roleId, Long... permissionIds);
    //public void uncorrelationPermissions(Long roleId, Long... permissionIds);
    
    //添加角色-权限之间关系  
    public void correlationPermissions(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId){
    	role6Dao.correlationPermissions(roleId,permissionId);
    }
    //移除角色-权限之间关系  
    public void uncorrelationPermissions(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId){
    	role6Dao.uncorrelationPermissions(roleId, permissionId);
    }
    
    public boolean exists(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId){
    	return role6Dao.exists(roleId, permissionId);
    }
    
    public void deleteAllRoles(){
    	role6Dao.deleteAllRoles();
    }
    
    public void deleteAllUserRoles(){
    	role6Dao.deleteAllUserRoles();
    }
}
