package com.zrxjuly.ibatis.test;

import java.util.List;

import org.junit.Test;

import com.zrxjuly.ibatis.dao.UserDAO;
import com.zrxjuly.ibatis.dao.daoImpl.UserDAOImpl;
import com.zrxjuly.ibatis.pojo.User;

/**
 * 测试类：用户CRUD.
 * @author zrxJuly
 *
 */
public class UserTest {
	
	private UserDAO userDAO = new UserDAOImpl();
	
	/** 查询所有用户  **/
	@Test
	public void selectUserTest() {
		List<User> userList = userDAO.selectAllUser();
		
		System.out.println("查询所有用户:");
		for (User user : userList) {
			System.out.println(user.toString());
		}
	}
	
	/** 根据id查询用户  **/
	@Test
	public void selectUserByIdTest() {
		int id = 1;
		User user = userDAO.selectUserById(id);
		System.out.println("根据id查询用户:" + user.toString());
	}
	
	/** 根据id删除用户  **/
	@Test
	public void deleteUserById() {
		int id = 3;
		int delSuccess = userDAO.deleteUserById(id);
		System.out.println(delSuccess);
		if (delSuccess == 1) {
			System.out.println("删除成功！");
		} else {
			System.out.println("删除失败！");
		}
	}
	
	/** 添加用户  **/
	@Test
	public void addUserTest() {
		User user = new User();
		user.setId(3);
		user.setName("anna");
		user.setScore("88");
		
		userDAO.addUser(user);
	}
	
	/** 用户信息修改 **/
	@Test
	public void updateUserTest() {
		User user = new User();
		user.setId(1);
		user.setName("wahh");
		user.setScore("100");
		
		userDAO.updateUser(user);
	}
	
	/** 模糊查询 **/
	@Test
	public void selectUsers() {
		String aString = "an";
		List<User> userList = userDAO.selectUsers(aString);
		System.out.println("模糊查询结果：");
		for (User user : userList) {
			System.out.println(user.toString());
		}
	}
	
}
