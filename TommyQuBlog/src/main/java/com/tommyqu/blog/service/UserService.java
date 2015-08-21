package com.tommyqu.blog.service;

import org.hibernate.Session;

public interface UserService extends BaseService{
	
	Boolean userLogin(String userLoginName, String userPwd);
}
