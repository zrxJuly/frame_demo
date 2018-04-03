package com.zrxjuly.shiro.util;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;

public class CryptographyUtil {
	
	// 使用Base64加密
	public static String encBase64(String str) {
		return Base64.encodeToString(str.getBytes());
	}

	// 使用Base64解密
	public static String decBase64(String str) {
		return Base64.decodeToString(str);
	}

	// 使用MD5加密
	public static String md5(String str, String salt) {
		return new Md5Hash(str, salt).toString();
	}

	public static void main(String[] args) {
		String username = "zrx";
		String password = "666";
		System.out.println(CryptographyUtil.encBase64(password));
		System.out.println(CryptographyUtil.decBase64("MTIzNA=="));
		System.out.println(CryptographyUtil.md5(password, username + "java"));
	}
}
