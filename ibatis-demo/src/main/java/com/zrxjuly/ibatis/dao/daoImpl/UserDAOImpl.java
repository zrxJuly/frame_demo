package com.zrxjuly.ibatis.dao.daoImpl;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.zrxjuly.ibatis.dao.UserDAO;
import com.zrxjuly.ibatis.pojo.User;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
public class UserDAOImpl implements UserDAO {
	private static SqlMapClient sqlMapClient = null;
	
	static {
		try {
			Reader reader = Resources.getResourceAsReader("sqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader); 
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<User> selectAllUser() {
		try {
			
			/** 在UserMapper.xml中定义了namespace，在此就要将namespace的值加上(User.) ，否则找不到 **/
			return sqlMapClient.queryForList("User.selectAllUser");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User selectUserById(int id) {
		try {
			return (User) sqlMapClient.queryForObject("User.selectUserById", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int deleteUserById(int id) {
		try {
			sqlMapClient.delete("User.deleteUserById", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void addUser(User user) {
		try {
			sqlMapClient.insert("User.addUser", user);
			System.out.println("添加成功！");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(User user) {
		try {
			sqlMapClient.update("User.updateUser", user);
			System.out.println("信息修改成功！");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> selectUsers(String aString) {
		try {
			return sqlMapClient.queryForList("User.selectUsers", aString);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
