package com.myspring7z.framework.mybatisz.shiro.chapter6.realm;

import javax.annotation.PostConstruct;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.myspring7z.framework.mybatisz.shiro.chapter6.entity.User6;
import com.myspring7z.framework.mybatisz.shiro.chapter6.service.Use6Service;

public class UserRealm extends AuthorizingRealm{
	
	public static final String HASH_ALGORITHM = "md5";
	public static final int HASH_INTERATIONS = 2;
	
	protected Use6Service use6Service;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(use6Service.findRoles(username));
        authorizationInfo.setStringPermissions(use6Service.findPermissions(username));

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String)token.getPrincipal();

        User6 user = use6Service.findByUsername(username);

        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }

        if(Boolean.TRUE.equals(user.getLocked())) {
            throw new LockedAccountException(); //帐号锁定
        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
        		new ShiroUser(user.getId(), user.getUsername()), //用户名
                user.getPassword(), //加密后的密码
                //密码123通过表单传进来
                ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }
    
    /**
	 * 设定Password校验的Hash算法与迭代次数.
	 */
	@PostConstruct
	//初始化bean之前进行操作
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(HASH_ALGORITHM);
		matcher.setHashIterations(HASH_INTERATIONS);

		setCredentialsMatcher(matcher);
	}

	public Use6Service getUse6Service() {
		return use6Service;
	}

	public void setUse6Service(Use6Service use6Service) {
		this.use6Service = use6Service;
	}
	
	
}
