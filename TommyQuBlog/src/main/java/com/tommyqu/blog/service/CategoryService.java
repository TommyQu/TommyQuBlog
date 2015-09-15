package com.tommyqu.blog.service;

import java.util.List;

public interface CategoryService extends BaseService{
	
	List<String> getAllCategoriesByUserId(Integer userId);
	
}
