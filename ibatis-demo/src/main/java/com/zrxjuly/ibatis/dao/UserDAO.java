package com.zrxjuly.ibatis.dao;

import java.util.List;

import com.zrxjuly.ibatis.pojo.User;

public interface UserDAO {
	
	/** 查询所有用户 **/
	public List<User> selectAllUser();
	
	/** 根据id查询某个用户 **/
	public User selectUserById(int id);
	
	/** 根据id删除用户  **/
	public int deleteUserById(int id);
	
	/** 添加新用户 **/
	public void addUser(User user);
	
	/** 用户信息修改 **/
	public void updateUser(User user);
	
	/** 模糊查询用户信息 **/
	public List<User> selectUsers(String aString);
}
