package com.tommyqu.blog.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tommyqu.blog.entities.Blog;
import com.tommyqu.blog.entities.Category;
import com.tommyqu.blog.entities.User;
import com.tommyqu.blog.services.IBlogService;

@Controller
@RequestMapping(value="blog")
public class BlogController {

	@Autowired
	IBlogService blogService;
	
	@RequestMapping(value="newBlog.do")
	public @ResponseBody String newBlog(String blogJson, HttpServletRequest request) {
		JSONObject blogObj = JSON.parseObject(blogJson);
		Blog blog = new Blog();
		blog.setTitle(blogObj.getString("title"));
		blog.setContent(blogObj.getString("content"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		blog.setCreatedAt(sdf.format(date));
		blog.setLastUpdatedAt(sdf.format(date));
		
		User createdBy = (User) request.getSession().getAttribute("user");
		blog.setCreatedBy(createdBy);
		blog.setCategories(blogObj.getString("categories"));
		return blogService.newBlog(blog);
	}
	
	@RequestMapping(value="getBlogsByCategory.do")
	public @ResponseBody String getBlogsByCategory(String category) {
		String allBlogsJson = JSON.toJSONString(blogService.getBlogsByCategory(category));
		return allBlogsJson;
	}

	@RequestMapping(value="getOneBlog.do")
	public @ResponseBody String getOneBlog(String id) {
		String blogJson = JSON.toJSONString(blogService.getBlogById(id));
		return blogJson;
	}
	
	@RequestMapping(value="deleteBlog.do")
	public @ResponseBody String deleteBlog(String id) {
		return blogService.deleteBlog(id);
	}
	
	@RequestMapping(value="updateBlog.do")
	public @ResponseBody String updateBlog(String blogJson, HttpServletRequest request) {
		JSONObject blogObj = JSON.parseObject(blogJson);
		Blog blog = new Blog();
		blog.setId(blogObj.getString("id"));
		blog.setTitle(blogObj.getString("title"));
		blog.setContent(blogObj.getString("content"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();

		blog.setLastUpdatedAt(sdf.format(date));
		
//		blog.setCategories(blogObj.getString("categories"));
		return blogService.updateBlog(blog);
	}
}
