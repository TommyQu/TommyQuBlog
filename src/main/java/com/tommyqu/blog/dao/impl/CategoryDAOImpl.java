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
import com.tommyqu.blog.entity.CategoryInfo;
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
	public List<CategoryInfo> getAllCategoryInfoByUserId(Integer userId) {
		List<CategoryInfo> categoryInfoList = new ArrayList<CategoryInfo>();
		try {
			String hql = "FROM UserCategory uc WHERE uc.user.userId = 1";
			Query query = this.getSession().createQuery(hql);
			List<UserCategory> userCategoryList = query.list();
			for(int i = 0; i < userCategoryList.size(); i++) {
				CategoryInfo categoryInfo = new CategoryInfo();
				categoryInfo.setCategoryId(userCategoryList.get(i).getCategory().getCategoryId());
				categoryInfo.setCategoryName(userCategoryList.get(i).getCategory().getCategoryName());
				categoryInfoList.add(categoryInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryInfoList;
	}

	@Override
	public Category getCategoryById(Integer categoryId) {
		Category category = new Category();
		try {
			String hql = "FROM Category c WHERE c.categoryId = "+categoryId+"";
			Query query = this.getSession().createQuery(hql);
			List<Category> categoryList = query.list();
			category = categoryList.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}

}
