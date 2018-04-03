package com.zrxjuly.shiro.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5Utils {
	// 干扰数据， 盐 防破解
	private static final String SALT = "java";
	// 散列算法类型为MD5
	private static final String ALGORITH_NAME = "md5";
	// hash的次数
	private static final int HASH_INTEGERATIONS = 2;
	
	public static String encrypt(String username, String pwd) {
		String newPassword = new SimpleHash(ALGORITH_NAME, pwd, ByteSource.Util.bytes(username + SALT), HASH_INTEGERATIONS).toHex();
		return newPassword;
	}
}
