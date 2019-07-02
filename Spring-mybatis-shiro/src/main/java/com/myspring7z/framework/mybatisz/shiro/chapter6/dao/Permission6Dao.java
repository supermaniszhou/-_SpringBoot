package com.myspring7z.framework.mybatisz.shiro.chapter6.dao;

import com.myspring7z.framework.mybatisz.repository.MyBatisRepository;
import com.myspring7z.framework.mybatisz.shiro.chapter6.entity.Permission6;

@MyBatisRepository
public interface Permission6Dao {
	
	public void createPermission(Permission6 permission);

    public void deletePermission(Long permissionId);
    
    public void deleteAllPermission();
    
    public void deleteAllRolePermissions();
    
}
