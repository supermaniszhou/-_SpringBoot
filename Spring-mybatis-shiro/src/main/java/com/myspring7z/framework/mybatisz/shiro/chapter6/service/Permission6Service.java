package com.myspring7z.framework.mybatisz.shiro.chapter6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myspring7z.framework.mybatisz.shiro.chapter6.dao.Permission6Dao;
import com.myspring7z.framework.mybatisz.shiro.chapter6.entity.Permission6;

@Component
public class Permission6Service {
	
	@Autowired
	private Permission6Dao permission6Dao;
	
	public Permission6 createPermission(Permission6 permission){
		permission6Dao.createPermission(permission);
		return permission;
	}

    public void deletePermission(Long permissionId){
    	permission6Dao.deletePermission(permissionId);
    }
    
    public void deleteAllPermission(){
    	permission6Dao.deleteAllPermission();
    }
    
    public void deleteAllRolePermissions(){
    	permission6Dao.deleteAllRolePermissions();
    }

}
