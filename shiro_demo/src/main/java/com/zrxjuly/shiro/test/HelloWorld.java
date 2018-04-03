package com.zrxjuly.shiro.test;

import org.apache.shiro.SecurityUtils;  
import org.apache.shiro.authc.UsernamePasswordToken;  
import org.apache.shiro.config.IniSecurityManagerFactory;  
import org.apache.shiro.mgt.SecurityManager;  
import org.apache.shiro.subject.Subject;  
import org.apache.shiro.util.Factory;

public class HelloWorld {
	
	/**
	 * shiro学习：
	 * Subject:主体，可以是任何能够与应用交互的用户
	 * SecurityManager:相当于SpringMVC中的DispatcherServlet或Struts2中的FilterDispatcher，是Shiro的心脏。
	 * 		所有具体的交互都通过SecurityManager进行控制，它管理所有Subject，且负责进行认证和授权、及会话、缓存的管理。
	 * 身份验证：用户需要提供principals（身份）和credentials（证明）给shiro
	 * 		principals：身份，主体的标识属性，可以是任何东西，eg：用户名、邮箱等，需要唯一。一个主体可以有多个principals，但只有一个Primary principals。
	 * 		credentials：证明/凭证，即只有主体知道的安全值，如密码/数字证书等。
	 * 
	 */
	public static void main(String[] args) {
		// 读取配置文件，初始化SecurityManager工厂
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.properties");
		// 获取SecurityManager实例
		SecurityManager securityManager = factory.getInstance();
		// 把securityManager 实例绑定到SecurityUtils
		SecurityUtils.setSecurityManager(securityManager);
		// 得到当前用户
		Subject currentUser = SecurityUtils.getSubject();
		// 创建token令牌，用户名/密码
		UsernamePasswordToken token = new UsernamePasswordToken("shiro01", "1234");

		try {
			// 登陆
			currentUser.login(token);
			System.out.println("success");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail");
		}
		// 推出
		currentUser.logout();
	}
}
