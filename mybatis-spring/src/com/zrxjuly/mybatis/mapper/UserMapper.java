package com.zrxjuly.mybatis.mapper;

import com.zrxjuly.mybatis.pojo.User;

public interface UserMapper {
	
	public User selectUserById(Integer id);
	
}
