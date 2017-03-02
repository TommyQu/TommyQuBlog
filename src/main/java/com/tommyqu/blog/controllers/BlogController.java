package com.tommyqu.blog.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tommyqu.blog.entities.Blog;
import com.tommyqu.blog.entities.User;
import com.tommyqu.blog.services.IBlogService;
import com.tommyqu.blog.utils.TQBUtilities;

@CrossOrigin
@Controller
@RequestMapping(value="blog")
public class BlogController {

	private static final String NO_SESSION_MSG = "no_session";
	
	@Autowired
	IBlogService blogService;
	
	@RequestMapping(value="newBlog.do", method=RequestMethod.POST)
	public @ResponseBody String newBlog(@RequestBody Blog blog, HttpServletRequest request) {
		
		User createdBy = (User) request.getSession().getAttribute("user");
		if(createdBy == null)
			return NO_SESSION_MSG;
		else {
			blog.setCreatedAt(TQBUtilities.getCurrentTime());
			blog.setLastUpdatedAt(TQBUtilities.getCurrentTime());
			blog.setCreatedBy(createdBy);
			return blogService.newBlog(blog);
		}

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
		User createdBy = (User) request.getSession().getAttribute("user");
		if(createdBy == null)
			return NO_SESSION_MSG;
		else {
			blog.setLastUpdatedAt(TQBUtilities.getCurrentTime());
			return blogService.updateBlog(blog);
		}
		
	}
}
