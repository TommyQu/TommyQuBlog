package com.tommyqu.blog.dao;

import com.tommyqu.blog.entity.User;

public interface UserDAO extends BaseDAO {
	
	User userLogin(String userLoginName, String userPwd);
	
}
