package com.myspring7z.framework.mybatisz.shiro.chapter3;

import org.junit.Test;

import junit.framework.Assert;

public class PermissionTest extends BaseTest{
	
	@Test
	public void testIsPermitted(){
		login("classpath:shiro-permission.ini","zhang","123");
		Assert.assertTrue(subject().isPermitted("user:create"));
		Assert.assertTrue(subject().isPermittedAll("user:create","user:delete"));
		Assert.assertFalse(subject().isPermittedAll("user:view"));
	}
}
