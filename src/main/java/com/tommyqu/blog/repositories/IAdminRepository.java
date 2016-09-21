package com.tommyqu.blog.repositories;

import java.util.List;

import com.tommyqu.blog.entities.Category;

public interface IAdminRepository {
	public String newCategory(Category category);
	public List<Category> getAllCategories();
}
