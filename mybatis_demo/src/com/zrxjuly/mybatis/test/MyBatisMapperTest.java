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
 * ����ʹ�ö�̬����.
 * @author zhangrongxiang
 * UserMapper.java
 */
public class MyBatisMapperTest {
	
	@Test
	public void testFindUserById() throws IOException {
		
		// ���غ��������ļ�.
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		// ����SqlSessionFactory.
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		// ����sqlSession.
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// sqlSession���ӿ�����ʵ����,����ֱ�Ӵ���DAO�ӿڣ������Լ�����DAO��ʵ����.
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(1);
		System.out.println(user);
		
	}
	
	@Test
	public void testFindUserByUsername() throws IOException {
		
		// ���غ��������ļ�.
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		// ����SqlSessionFactory.
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		// ����sqlSession.
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// sqlSession���ӿ�����ʵ����,����ֱ�Ӵ���DAO�ӿڣ������Լ�����DAO��ʵ����.
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> user = userMapper.findUserByUsername("����");
		System.out.println(user);
		
	}
}
