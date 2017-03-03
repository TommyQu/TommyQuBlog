package com.tommyqu.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tommyqu.blog.entities.Category;
import com.tommyqu.blog.services.IAdminService;

@CrossOrigin
@Controller
@RequestMapping(value="admin")
public class AdminController {

	@Autowired
	IAdminService adminService;
	
	@RequestMapping(value="newCategory.do")
	public @ResponseBody String newCategory(String categoryJson) {
		JSONObject categoryObj = JSON.parseObject(categoryJson);
		Category category = new Category();
		category.setContent(categoryObj.getString("content"));
		return adminService.newCategory(category);
	}
	
	@RequestMapping(value="getAllCategories.do")
	public @ResponseBody List<Category> getAllCategories() {
		return adminService.getAllCategories();
	}
	
	@RequestMapping(value="deleteCategory.do")
	public @ResponseBody String deleteCategory(String id) {
		return adminService.deleteCategory(id);
	}
	
	@RequestMapping(value="getAllUsers.do")
	public @ResponseBody String getAllUsers() {
		String usersJson = JSON.toJSONString(adminService.getAllUsers());
		return usersJson;
	}
}
