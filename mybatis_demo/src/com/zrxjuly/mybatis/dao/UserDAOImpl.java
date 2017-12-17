package com.zrxjuly.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.zrxjuly.mybatis.pojo.User;

public class UserDAOImpl implements UserDAO {

	private SqlSessionFactory sqlSessionFactory;
	
	public UserDAOImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User selectUser(Integer id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("test.findUserById", id);
	}
	
}
