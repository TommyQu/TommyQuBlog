package com.tommyqu.blog.dao;

import java.util.List;

import com.tommyqu.blog.entity.Category;
import com.tommyqu.blog.entity.CategoryInfo;

public interface CategoryDAO extends BaseDAO {
	
	List<CategoryInfo> getAllCategoryInfoByUserId(Integer userId);
	Category getCategoryById(Integer categoryId);
}
