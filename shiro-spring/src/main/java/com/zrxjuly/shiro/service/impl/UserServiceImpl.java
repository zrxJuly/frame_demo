package com.zrxjuly.shiro.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zrxjuly.shiro.dao.UserDao;
import com.zrxjuly.shiro.entity.User;
import com.zrxjuly.shiro.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource  
    private UserDao userDao;  
      
    public User getByUserName(String userName) {  
        return userDao.getByUserName(userName);  
    }  
  
    public Set<String> getRoles(String userName) {  
        return userDao.getRoles(userName);  
    }  
  
    public Set<String> getPermissions(String userName) {  
        return userDao.getPermissions(userName);  
    }
}
