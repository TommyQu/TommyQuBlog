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
		
		return blogService.newBlog(blog);
	}
	
	@RequestMapping(value="getAllBlogs.do")
	public @ResponseBody String getBlogs(HttpServletRequest request) {
		String allBlogsJson = JSON.toJSONString(blogService.getAllBlogs());
		return allBlogsJson;
	}

	@RequestMapping(value="getOneBlog.do")
	public @ResponseBody String getOneBlog(String id) {
		String blogJson = JSON.toJSONString(blogService.getBlogById(id));
		return blogJson;
	}
	
}