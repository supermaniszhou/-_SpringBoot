package com.myspring7z.framework.mybatisz.shiro.chapter6.dao;

import org.apache.ibatis.annotations.Param;

import com.myspring7z.framework.mybatisz.repository.MyBatisRepository;
import com.myspring7z.framework.mybatisz.shiro.chapter6.entity.Role6;

@MyBatisRepository
public interface Role6Dao {

	public void createRole(Role6 role);
    public void deleteRole(Long roleId);

    //public void correlationPermissions(Long roleId, Long... permissionIds);
    //public void uncorrelationPermissions(Long roleId, Long... permissionIds);
    
    //添加角色-权限之间关系  
    public void correlationPermissions(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);
    //移除角色-权限之间关系  
    public void uncorrelationPermissions(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);
    
    public boolean exists(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);
    
    public void deleteAllRoles();
    
    public void deleteAllUserRoles();
}
