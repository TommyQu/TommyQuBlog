/**
 * Project: Tommy Qu's Blog
 * Comments: Page Redirect Controller
 * JDK Version Used: JDK 1.7
 * Author: Tommy Qu
 * Created Date: 08/13/2015
 * Modified By:
 * Modified Date:
 * Why is modified:
 */

package com.tommyqu.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.tommyqu.blog.entity.Post;
import com.tommyqu.blog.entity.User;
import com.tommyqu.blog.service.PostService;

@Controller
@RequestMapping(value="page")
public class PageController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value="showIndexPage.do")
	public String showIndexPage(ModelMap model) {
		return "/index";
	}
	
	@RequestMapping(value="showBlogPage.do")
	public String showBlogPage(ModelMap modelMap) {
		List<Post> postList = postService.getAllPostsByUserId(1);
		String postListJson = JSON.toJSONString(postList);
//		modelMap.addAttribute("postListJson", postListJson);
		System.out.println(postListJson);
		return "/blog";
	}
	
	@RequestMapping(value="showNewPostPage.do")
	public String showNewPostPage(ModelMap model) {
		return "/newPost";
	}
}
