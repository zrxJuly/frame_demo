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
	 * �����û�id��ѯ�û�.
	 * @throws IOException
	 */
	@Test
	public void testSelect() throws IOException {
		
		// ���غ��������ļ�.
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		// ����SqlSessionFactory.
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		// ����sqlSession.
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// ִ��sql���.
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
	}
	
	/**
	 * �����û�����ѯ�û�.
	 * @throws IOException
	 */
	@Test
	public void testSelectUserByUsername() throws IOException {
		
		// ���غ��������ļ�.
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		// ����SqlSessionFactory.
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		// ����sqlSession.
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// ִ��sql���.
		List<User> user = sqlSession.selectList("test.findUserByUsername", "��");
		for (User user2 : user) {
			System.out.println(user2);
		}
	}
	
	/**
	 * ����û�.
	 * @throws IOException
	 */
	@Test
	public void insertUser() throws IOException {
		
		// ���غ��������ļ�.
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		// ����SqlSessionFactory.
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		// ����sqlSession.
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// ִ��sql���.
		User user = new User();
		user.setUsername("aaa");
		user.setSex("Ů");
		user.setBirthday(new Date());
		user.setAddress("shandong");
		sqlSession.insert("test.insertUser", user); // ����ʱ����Ӱ�������.
		
		// �ύ����.
		sqlSession.commit();
		
		System.out.println(user.getId());
		
	}
	
	/**
	 * �޸��û�.
	 * @throws IOException
	 */
	@Test
	public void updateUser() throws IOException {
		
		// ���غ��������ļ�.
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		// ����SqlSessionFactory.
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		// ����sqlSession.
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// ִ��sql���.
		User user = new User();
		user.setId(33);
		user.setUsername("aaa");
		user.setSex("Ů");
		user.setBirthday(new Date());
		user.setAddress("aa");
		
		sqlSession.update("test.updateUser", user);
		sqlSession.commit();
	}
	
	@Test
	public void deleteUser() throws IOException {
		
		// ���غ��������ļ�.
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		// ����SqlSessionFactory.
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		// ����sqlSession.
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// ִ��sql���.
		sqlSession.delete("test.deleteUserById", 34);
		sqlSession.commit();
	}
}
