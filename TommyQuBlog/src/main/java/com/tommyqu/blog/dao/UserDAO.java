package com.tommyqu.blog.dao;

public interface UserDAO extends BaseDAO {
	
	Boolean userLogin(String userLoginName, String userPwd);
	
}
