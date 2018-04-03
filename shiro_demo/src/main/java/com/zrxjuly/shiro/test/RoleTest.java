package com.zrxjuly.shiro.test;

import java.util.Arrays;

import org.apache.shiro.subject.Subject;
import org.junit.Test;

import com.zrxjuly.shiro.util.ShiroUtil;

public class RoleTest {
	@Test
	public void test() {
		Subject sub = ShiroUtil.login("classpath:shiro_role.properties", "shiro02", "1234");
		boolean[] re = sub.hasRoles(Arrays.asList("role1","role2","role3"));
		System.out.println(sub.hasRole("role2")?"hasRole2":"noRole2");
		System.out.println(sub.hasRoles(Arrays.asList("role1","role2","role3")));
		System.out.println(re[0]);//true
		System.out.println(re[1]);//false
		System.out.println(re[2]);//false
	}
	
	@Test
	public void test2() {
		Subject sub = ShiroUtil.login("classpath:shiro_role.properties", "shiro02", "1234");
		System.out.println(sub.isPermitted("user:select"));
	}
}
