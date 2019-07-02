package com.myspring7z.framework.mybatisz.shiro.chapter6.web;

import java.util.Set;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myspring7z.framework.mybatisz.shiro.chapter6.entity.Permission6;
import com.myspring7z.framework.mybatisz.shiro.chapter6.entity.Role6;
import com.myspring7z.framework.mybatisz.shiro.chapter6.entity.User6;
import com.myspring7z.framework.mybatisz.shiro.chapter6.service.Permission6Service;
import com.myspring7z.framework.mybatisz.shiro.chapter6.service.Role6Service;
import com.myspring7z.framework.mybatisz.shiro.chapter6.service.Use6Service;

@Controller
@RequestMapping("testBase6")
public class Base6TestController {
	
	@Autowired
	protected Permission6Service permissionService;
	@Autowired
    protected Role6Service roleService;
	@Autowired
    protected Use6Service userService;
	
	protected String password = "123";

    protected Permission6 p1;
    protected Permission6 p2;
    protected Permission6 p3;
    protected Role6 r1;
    protected Role6 r2;
    protected User6 u1;
    protected User6 u2;
    protected User6 u3;
    protected User6 u4;
	
	@ResponseBody
	@RequestMapping("/clean")
	public void clean(){
		userService.deleteAllUsers();
		roleService.deleteAllRoles();
		roleService.deleteAllUserRoles();
		permissionService.deleteAllPermission();
		permissionService.deleteAllRolePermissions();
	}

	@ResponseBody
	@RequestMapping("/befor")
	public void befor(){
		//1、新增权限
        p1 = new Permission6("user:create", "用户模块新增", Boolean.TRUE);
        p2 = new Permission6("user:update", "用户模块修改", Boolean.TRUE);
        p3 = new Permission6("menu:create", "菜单模块新增", Boolean.TRUE);
        permissionService.createPermission(p1);
        permissionService.createPermission(p2);
        permissionService.createPermission(p3);
        //2、新增角色
        r1 = new Role6("admin", "管理员", Boolean.TRUE);
        r2 = new Role6("user", "用户管理员", Boolean.TRUE);
        roleService.createRole(r1);
        roleService.createRole(r2);
        //3、关联角色-权限
        roleService.correlationPermissions(r1.getId(), p1.getId());
        roleService.correlationPermissions(r1.getId(), p2.getId());
        roleService.correlationPermissions(r1.getId(), p3.getId());

        roleService.correlationPermissions(r2.getId(), p1.getId());
        roleService.correlationPermissions(r2.getId(), p2.getId());

        //4、新增用户
        u1 = new User6("zhang", password);
        u2 = new User6("li", password);
        u3 = new User6("wu", password);
        u4 = new User6("wang", password);
        u4.setLocked(Boolean.TRUE);
        userService.createUser(u1);
        userService.createUser(u2);
        userService.createUser(u3);
        userService.createUser(u4);
        //5、关联用户-角色
        userService.correlationRoles(u1.getId(), r1.getId());
	}
	
	@ResponseBody
	@RequestMapping("/test")
	public void test(){
		clean();
		befor();
		//zhang
        Set<String> roles = userService.findRoles(u1.getUsername());
        System.out.println("roles:"+roles);
        //Assert.assertEquals(1, roles.size());
        System.out.println("1 roles.size():"+roles.size());
        //Assert.assertTrue(roles.contains(r1.getRole()));
        System.out.println("roles.contains(r1.getRole():"+roles.contains(r1.getRole()));
        System.out.println();
        
        Set<String> permissions = userService.findPermissions(u1.getUsername());
        System.out.println("permissions:"+permissions);
        //Assert.assertEquals(3, permissions.size());
        System.out.println("3 permissions.size():"+permissions.size());
        //Assert.assertTrue(permissions.contains(p3.getPermission()));
        System.out.println("permissions.contains(p3.getPermission():"+permissions.contains(p3.getPermission()));
        System.out.println();
        
        //li
        roles = userService.findRoles(u2.getUsername());
        //Assert.assertEquals(0, roles.size());
        System.out.println("0 roles.size():"+roles.size());
        permissions = userService.findPermissions(u2.getUsername());
        //Assert.assertEquals(0, permissions.size());
        System.out.println("0 permissions.size():"+permissions.size());
        System.out.println();
        
        //解除 admin-menu:update关联
        roleService.uncorrelationPermissions(r1.getId(), p3.getId());
        permissions = userService.findPermissions(u1.getUsername());
        //Assert.assertEquals(2, permissions.size());
        System.out.println("2 permissions.size():"+permissions.size());
        //Assert.assertFalse(permissions.contains(p3.getPermission()));
        System.out.println("false permissions.contains(p3.getPermission():"+permissions.contains(p3.getPermission()));
        System.out.println();

        //删除一个permission
        permissionService.deletePermission(p2.getId());
        permissions = userService.findPermissions(u1.getUsername());
        //Assert.assertEquals(1, permissions.size());
        System.out.println("1 ppermissions.size():"+permissions.size());
        System.out.println();
        
        //解除 zhang-admin关联
        userService.uncorrelationRoles(u1.getId(), r1.getId());
        roles = userService.findRoles(u1.getUsername());
        //Assert.assertEquals(0, roles.size());
        System.out.println("0 roles.size():"+roles.size());
	}
}
