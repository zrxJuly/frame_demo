package com.zrxjuly.shiro.util;

import org.apache.shiro.SecurityUtils;  
import org.apache.shiro.authc.UsernamePasswordToken;  
import org.apache.shiro.config.IniSecurityManagerFactory;  
import org.apache.shiro.mgt.SecurityManager;  
import org.apache.shiro.subject.Subject;  
import org.apache.shiro.util.Factory; 

public class ShiroUtil {
	public static Subject login(String filepath, String userName, String pwd) {
		// 读取配置文件，初始化SecurityManager工厂
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(filepath);
		// 获取SecurityManager实例
		SecurityManager securityManager = factory.getInstance();
		// 把securityManager 实例绑定到SecurityUtils
		SecurityUtils.setSecurityManager(securityManager);
		// 得到当前用户
		Subject currentUser = SecurityUtils.getSubject();
		// 创建token令牌，用户名/密码
		UsernamePasswordToken token = new UsernamePasswordToken(userName, pwd);

		try {
			// 登陆
			currentUser.login(token);
			System.out.println("success");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail");
		}
		return currentUser;
	}
}
