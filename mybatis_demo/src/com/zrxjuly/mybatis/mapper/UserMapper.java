package com.zrxjuly.mybatis.mapper;

import java.util.List;

import com.zrxjuly.mybatis.pojo.User;

/**
 * 使用Mapper动态代理
 * @author zhangrongxiang
 *
 */
public interface UserMapper {
	/**
	 * 一、使用Mapper动态代理需要遵循四个原则：
	 * 1.接口方法名 == UserMapper.xml中的id名.
	 * 2.返回值类型要与UserMapper.xml文件中返回类型一致. 
	 * 3.方法的入参类型要与UserMapper.xml文件中的入参类型一致.
	 * 4.UserMapper.xml中命名空间绑定此接口.
	 * 
	 * 二、selectOne和selectList
	 * 动态代理对象调用sqlSession.selectOne()和sqlSession.selectList()是根据mapper接口方法的返回值决定，
	 * 如果返回list则调用selectList方法，如果返回单个对象则调用selectOne方法。
	 * 
	 * mybatis官方推荐使用mapper代理方法开发mapper接口，程序员不用编写mapper接口实现类，使用mapper代理方法时，输入参数可以使用pojo包装对象或map对象，保证dao的通用性。
	 */
	// 返回单个对象调用selectOne方法
	public User findUserById(Integer id);
	// 返回list,调用selectList方法
	public List<User> findUserByUsername(String username);
}
