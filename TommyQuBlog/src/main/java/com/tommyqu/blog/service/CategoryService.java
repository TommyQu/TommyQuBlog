package com.tommyqu.blog.service;

import java.util.List;

import com.tommyqu.blog.entity.Category;
import com.tommyqu.blog.entity.CategoryInfo;

public interface CategoryService extends BaseService{
	
	List<CategoryInfo> getAllCategoryInfoByUserId(Integer userId);
	Category getCategoryById(Integer categoryId);
}
