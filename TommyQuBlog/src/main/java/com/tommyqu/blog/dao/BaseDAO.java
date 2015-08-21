package com.tommyqu.blog.dao;

import org.hibernate.Session;

public interface BaseDAO {
	
	Session getSession();
	
}
