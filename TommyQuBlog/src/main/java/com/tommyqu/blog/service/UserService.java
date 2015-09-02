package com.tommyqu.blog.service;

import org.hibernate.Session;

import com.tommyqu.blog.entity.User;

public interface UserService extends BaseService{
	
	User userLogin(String userLoginName, String userPwd);
}
