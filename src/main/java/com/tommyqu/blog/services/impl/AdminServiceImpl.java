package com.tommyqu.blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tommyqu.blog.entities.Category;
import com.tommyqu.blog.repositories.IAdminRepository;
import com.tommyqu.blog.services.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	IAdminRepository adminRepository;
	
	@Override
	public String newCategory(Category category) {
		return adminRepository.newCategory(category);
	}

	@Override
	public List<Category> getAllCategories() {
		return adminRepository.getAllCategories();
	}

	@Override
	public String deleteCategory(String id) {
		return adminRepository.deleteCategory(id);
	}

}
