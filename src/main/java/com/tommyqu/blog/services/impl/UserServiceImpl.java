package com.tommyqu.blog.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tommyqu.blog.entities.User;
import com.tommyqu.blog.repositories.IUserRepository;
import com.tommyqu.blog.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository userRepository;
	
	@Override
	public User login(String email, String pwd) {
		return userRepository.login(email, pwd);
	}

	@Override
	public String signUp(User user) {
		return userRepository.signUp(user);
	}

}
