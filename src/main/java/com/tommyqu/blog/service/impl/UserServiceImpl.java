package com.tommyqu.blog.service.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tommyqu.blog.dao.UserDAO;
import com.tommyqu.blog.entity.User;
import com.tommyqu.blog.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public Session getSession() {
		return userDAO.getSession();
	}

	@Override
	public User userLogin(String userLoginName, String userPwd) {
		return userDAO.userLogin(userLoginName, userPwd);
	}

}
