package com.zrxjuly.shiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.zrxjuly.shiro.entity.User;

public class UserDao {

	public Set<String> getRoles(Connection conn, String username) throws SQLException {
		Set<String> roles = new HashSet<String>();
		String sql = "select * from t_user u,t_role r where u.roleId=r.id and u.username=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, username);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			roles.add(rs.getString("roleName"));
		}
		return roles;
	}

	public User getByUsername(Connection conn, String username) throws SQLException {
		User resultUser = null;
		String sql = "select * from t_user where username = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, username);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			resultUser = new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUsername(rs.getString("username"));
			resultUser.setPassword(rs.getString("password"));
		}
		
		return resultUser;
	}

}
