package com.tommyqu.blog.repositories;

import com.tommyqu.blog.entities.User;

public interface IUserRepository {
	public User login(String email, String pwd);
	public String signUp(User user);
}
