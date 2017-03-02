package com.tommyqu.blog.repositories;

import java.util.List;import javax.jws.soap.SOAPBinding.Use;

import com.tommyqu.blog.entities.Category;
import com.tommyqu.blog.entities.User;

public interface IAdminRepository {
	public String newCategory(Category category);
	public List<Category> getAllCategories();
	public String deleteCategory(String id);
	public List<User> getAllUsers();
}
