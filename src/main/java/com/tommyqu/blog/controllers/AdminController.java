package com.tommyqu.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tommyqu.blog.entities.Category;
import com.tommyqu.blog.entities.User;
import com.tommyqu.blog.services.IAdminService;

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
	public @ResponseBody String getAllCategories() {
		String allCategoriesJson = JSON.toJSONString(adminService.getAllCategories());
		return allCategoriesJson;
	}
}
