package com.tommyqu.blog.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tommyqu.blog.dao.CategoryDAO;
import com.tommyqu.blog.entity.Category;
import com.tommyqu.blog.entity.CategoryInfo;
import com.tommyqu.blog.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Override
	public Session getSession() {
		return categoryDAO.getSession();
	}

	@Override
	public List<CategoryInfo> getAllCategoryInfoByUserId(Integer userId) {
		return categoryDAO.getAllCategoryInfoByUserId(userId);
	}

	@Override
	public Category getCategoryById(Integer categoryId) {
		return categoryDAO.getCategoryById(categoryId);
	}


}
