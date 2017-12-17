package com.zrxjuly.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.zrxjuly.mybatis.dao.UserDAO;
import com.zrxjuly.mybatis.dao.UserDAOImpl;
import com.zrxjuly.mybatis.pojo.User;

public class DAOTest {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void before() throws IOException {
		// 加载核心配置文件.
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		// 创建SqlSessionFactory.
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
	}
	
	@Test
	public void testTest() {
		UserDAO userDAO = new UserDAOImpl(sqlSessionFactory);
		User user = userDAO.selectUser(1);
		System.out.println(user);
	}
}
