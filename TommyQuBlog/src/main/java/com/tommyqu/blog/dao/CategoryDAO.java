package com.tommyqu.blog.dao;

import java.util.List;

import com.tommyqu.blog.entity.Category;

public interface CategoryDAO extends BaseDAO {
	
	List<String> getAllCategoriesByUserId(Integer userId);
}
