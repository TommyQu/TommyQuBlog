package com.tommyqu.blog.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tommyqu.blog.dao.UserDAO;
import com.tommyqu.blog.entity.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public Boolean userLogin(String userLoginName, String userPwd) {
		try {
			String hql = "from User where userLoginName = '"+userLoginName+"' and userPwd = '"+userPwd+"' ";
			Query query = this.getSession().createQuery(hql);
			List<User> userList = query.list();
			if(userList.size() != 0)
				return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
