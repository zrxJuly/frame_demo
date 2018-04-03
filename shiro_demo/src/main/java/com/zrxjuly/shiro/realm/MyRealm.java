package com.zrxjuly.shiro.realm;

import java.sql.Connection;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.zrxjuly.shiro.dao.UserDao;
import com.zrxjuly.shiro.entity.User;
import com.zrxjuly.shiro.util.DBUtil;

public class MyRealm extends AuthorizingRealm {
	private UserDao userDao = new UserDao();
	private DBUtil dbUtil = new DBUtil();
	/**
	 * 为当前用户授予角色权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		Connection conn = null;
		try {
			conn = dbUtil.getCon();
			authorizationInfo.setRoles(userDao.getRoles(conn, username));
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		return authorizationInfo;
	}

	/**
	 * 获取认证信息，验证当前登录的用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		Connection conn = null;
		try {
			conn = dbUtil.getCon();
			User user = userDao.getByUsername(conn, username);
			if (user != null) {
				AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), "xx");
				return authcInfo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
