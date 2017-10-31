package com.tommyqu.blog.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public @ResponseBody String newBlog(@RequestBody Blog blog, HttpServletRequest request, HttpServletResponse response) {
		
		User createdBy = (User) request.getSession().getAttribute("user");
		if(createdBy == null) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return NO_SESSION_MSG;
		}
		else {
			createdBy.setPwd(null);
			blog.setCreatedAt(TQBUtilities.getCurrentTime());
			blog.setLastUpdatedAt(TQBUtilities.getCurrentTime());
			blog.setCreatedBy(createdBy);
			return blogService.newBlog(blog);
		}

	}
	
	@RequestMapping(value="getBlogsByCategory.do")
	public @ResponseBody List<Blog> getBlogsByCategory(String category) {
		return blogService.getBlogsByCategory(category);
	}

	@RequestMapping(value="getOneBlog.do")
	public @ResponseBody Blog getOneBlog(String id) {
		return blogService.getBlogById(id);
	}
	
	@RequestMapping(value="deleteBlog.do")
	public @ResponseBody String deleteBlog(String id) {
		return blogService.deleteBlog(id);
	}
	
	@RequestMapping(value="updateBlog.do", method=RequestMethod.POST)
	public @ResponseBody String updateBlog(@RequestBody Blog blog, HttpServletRequest request, HttpServletResponse response) {
		User createdBy = (User) request.getSession().getAttribute("user");
		if(createdBy == null) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return NO_SESSION_MSG;
		}
		else {
			blog.setLastUpdatedAt(TQBUtilities.getCurrentTime());
			return blogService.updateBlog(blog);
		}
		
	}
	
	@RequestMapping(value="getBlogsBySearchText.do")
	public @ResponseBody List<Blog> getBlogsBySearchText(String searchText) {
		return blogService.getBlogsBySearchText(searchText);
	}
}
