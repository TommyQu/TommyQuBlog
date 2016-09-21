package com.tommyqu.blog.services;

import com.tommyqu.blog.entities.User;

public interface IUserService {
	public User login(String email, String pwd);
	public String signUp(User user);
}
