package com.tommyqu.blog.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tommyqu.blog.dao.CategoryDAO;
import com.tommyqu.blog.entity.Category;
import com.tommyqu.blog.entity.UserCategory;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<String> getAllCategoriesByUserId(Integer userId) {
		List<String> categoryNameList = new ArrayList<String>();
		try {
			String hql = "FROM UserCategory uc WHERE uc.user.userId = 1";
			Query query = this.getSession().createQuery(hql);
			List<UserCategory> userCategoryList = query.list();
			for(int i = 0; i < userCategoryList.size(); i++) {
				categoryNameList.add(userCategoryList.get(i).getCategory().getCategoryName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryNameList;
	}

}
