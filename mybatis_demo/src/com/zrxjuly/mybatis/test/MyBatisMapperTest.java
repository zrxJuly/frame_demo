package com.zrxjuly.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zrxjuly.mybatis.mapper.UserMapper;
import com.zrxjuly.mybatis.pojo.User;

/**
 * 测试使用动态代理.
 * @author zhangrongxiang
 * UserMapper.java
 */
public class MyBatisMapperTest {
	
	@Test
	public void testFindUserById() throws IOException {
		
		// 加载核心配置文件.
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		// 创建SqlSessionFactory.
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		// 创建sqlSession.
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// sqlSession给接口生成实现类,这样直接创建DAO接口，不用自己创建DAO的实现类.
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(1);
		System.out.println(user);
		
	}
	
	@Test
	public void testFindUserByUsername() throws IOException {
		
		// 加载核心配置文件.
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		// 创建SqlSessionFactory.
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		// 创建sqlSession.
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// sqlSession给接口生成实现类,这样直接创建DAO接口，不用自己创建DAO的实现类.
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> user = userMapper.findUserByUsername("王五");
		System.out.println(user);
		
	}
}
