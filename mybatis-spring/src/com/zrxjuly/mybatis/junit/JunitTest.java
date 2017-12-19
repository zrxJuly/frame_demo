package com.zrxjuly.mybatis.junit;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zrxjuly.mybatis.mapper.UserMapper;
import com.zrxjuly.mybatis.pojo.User;

/**
 * 
 * ������.
 * 
 */
public class JunitTest {
	
	// ʹ��Mapper��̬������applicationContext.xml�еķ�ʽ2.
	@SuppressWarnings("resource")
	@Test
	public void testMapper() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper userMapper = (UserMapper) ac.getBean("userMapper");
		User user = userMapper.selectUserById(1);
		System.out.println(user);
	}
	
	// ʹ��Mapper��̬������applicationContext.xml�еķ�ʽ3.
	@SuppressWarnings("resource")
	@Test
	public void testMappers() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper userMapper = (UserMapper) ac.getBean(UserMapper.class);
		User user = userMapper.selectUserById(1);
		System.out.println(user);
	}
}
