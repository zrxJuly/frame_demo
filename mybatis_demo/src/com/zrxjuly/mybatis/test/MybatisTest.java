package com.zrxjuly.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zrxjuly.mybatis.pojo.User;

public class MybatisTest {
	
	/**
	 * 根据用户id查询用户.
	 * @throws IOException
	 */
	@Test
	public void testSelect() throws IOException {
		
		// 加载核心配置文件.
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		// 创建SqlSessionFactory.
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		// 创建sqlSession.
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// 执行sql语句.
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
	}
	
	/**
	 * 根据用户名查询用户.
	 * @throws IOException
	 */
	@Test
	public void testSelectUserByUsername() throws IOException {
		
		// 加载核心配置文件.
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		// 创建SqlSessionFactory.
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		// 创建sqlSession.
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// 执行sql语句.
		List<User> user = sqlSession.selectList("test.findUserByUsername", "五");
		for (User user2 : user) {
			System.out.println(user2);
		}
	}
	
	/**
	 * 添加用户.
	 * @throws IOException
	 */
	@Test
	public void insertUser() throws IOException {
		
		// 加载核心配置文件.
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		// 创建SqlSessionFactory.
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		// 创建sqlSession.
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// 执行sql语句.
		User user = new User();
		user.setUsername("aaa");
		user.setSex("女");
		user.setBirthday(new Date());
		user.setAddress("shandong");
		sqlSession.insert("test.insertUser", user); // 返回时代表影响的行数.
		
		// 提交事务.
		sqlSession.commit();
		
		System.out.println(user.getId());
		
	}
	
	/**
	 * 修改用户.
	 * @throws IOException
	 */
	@Test
	public void updateUser() throws IOException {
		
		// 加载核心配置文件.
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		// 创建SqlSessionFactory.
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		// 创建sqlSession.
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// 执行sql语句.
		User user = new User();
		user.setId(33);
		user.setUsername("aaa");
		user.setSex("女");
		user.setBirthday(new Date());
		user.setAddress("aa");
		
		sqlSession.update("test.updateUser", user);
		sqlSession.commit();
	}
	
	@Test
	public void deleteUser() throws IOException {
		
		// 加载核心配置文件.
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		// 创建SqlSessionFactory.
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		// 创建sqlSession.
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// 执行sql语句.
		sqlSession.delete("test.deleteUserById", 34);
		sqlSession.commit();
	}
}
