package com.tommyqu.blog.services;

import java.util.List;

import com.tommyqu.blog.entities.Category;
import com.tommyqu.blog.entities.User;

public interface IAdminService {
	public String newCategory(Category category);
	public List<Category> getAllCategories();
	public String deleteCategory(String id);
	public List<User> getAllUsers();
}
