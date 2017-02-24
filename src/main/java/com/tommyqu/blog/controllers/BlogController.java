package com.tommyqu.blog.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tommyqu.blog.entities.Blog;
import com.tommyqu.blog.entities.Category;
import com.tommyqu.blog.entities.User;
import com.tommyqu.blog.services.IBlogService;

@CrossOrigin
@Controller
@RequestMapping(value="blog")
public class BlogController {

	@Autowired
	IBlogService blogService;
	
	@RequestMapping(value="newBlog.do", method=RequestMethod.POST)
	public @ResponseBody String newBlog(@RequestBody Blog blog, HttpServletRequest request) {
		System.out.println(JSON.toJSONString(blog));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		blog.setCreatedAt(sdf.format(date));
		blog.setLastUpdatedAt(sdf.format(date));
		
		User createdBy = (User) request.getSession().getAttribute("user");
		blog.setCreatedBy(createdBy);

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
	
	@RequestMapping(value="updateBlog.do", method=RequestMethod.POST)
	public @ResponseBody String updateBlog(@RequestBody Blog blog, HttpServletRequest request) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();

		blog.setLastUpdatedAt(sdf.format(date));
		
//		blog.setCategories(blogObj.getString("categories"));
		return blogService.updateBlog(blog);
	}
}
