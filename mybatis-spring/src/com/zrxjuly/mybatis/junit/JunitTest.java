package com.zrxjuly.mybatis.junit;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zrxjuly.mybatis.mapper.UserMapper;
import com.zrxjuly.mybatis.pojo.User;

/**
 * 
 * 测试类.
 * 
 */
public class JunitTest {
	
	// 使用Mapper动态代理开发applicationContext.xml中的方式2.
	@SuppressWarnings("resource")
	@Test
	public void testMapper() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper userMapper = (UserMapper) ac.getBean("userMapper");
		User user = userMapper.selectUserById(1);
		System.out.println(user);
	}
	
	// 使用Mapper动态代理开发applicationContext.xml中的方式3.
	@SuppressWarnings("resource")
	@Test
	public void testMappers() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper userMapper = (UserMapper) ac.getBean(UserMapper.class);
		User user = userMapper.selectUserById(1);
		System.out.println(user);
	}
}
