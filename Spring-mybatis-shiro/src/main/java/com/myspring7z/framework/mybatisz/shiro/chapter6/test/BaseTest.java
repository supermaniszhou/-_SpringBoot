package com.myspring7z.framework.mybatisz.shiro.chapter6.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Before;

import com.myspring7z.framework.mybatisz.shiro.chapter6.entity.Permission6;
import com.myspring7z.framework.mybatisz.shiro.chapter6.entity.Role6;
import com.myspring7z.framework.mybatisz.shiro.chapter6.entity.User6;
import com.myspring7z.framework.mybatisz.shiro.chapter6.service.Permission6Service;
import com.myspring7z.framework.mybatisz.shiro.chapter6.service.Role6Service;
import com.myspring7z.framework.mybatisz.shiro.chapter6.service.Use6Service;

public class BaseTest {
	
	protected Permission6Service permissionService = new Permission6Service();
    protected Role6Service roleService = new Role6Service();
    protected Use6Service userService = new Use6Service();

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

    @Before
    public void setUp() {
        /*JdbcTemplateUtils.jdbcTemplate().update("delete from sys_users");
        JdbcTemplateUtils.jdbcTemplate().update("delete from sys_roles");
        JdbcTemplateUtils.jdbcTemplate().update("delete from sys_permissions");
        JdbcTemplateUtils.jdbcTemplate().update("delete from sys_users_roles");
        JdbcTemplateUtils.jdbcTemplate().update("delete from sys_roles_permissions");*/

    	System.out.println((userService.findByUsername("lee"))==null);
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




    @After
    public void tearDown() throws Exception {
        ThreadContext.unbindSubject();//退出时请解除绑定Subject到线程 否则对下次测试造成影响
    }

    protected void login(String configFile, String username, String password) {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<org.apache.shiro.mgt.SecurityManager> factory =
                new IniSecurityManagerFactory(configFile);

        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        subject.login(token);
    }

    public Subject subject() {
        return SecurityUtils.getSubject();
    }
}
