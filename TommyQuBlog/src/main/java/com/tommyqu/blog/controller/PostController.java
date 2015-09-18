package com.tommyqu.blog.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tommyqu.blog.entity.Post;
import com.tommyqu.blog.entity.User;
import com.tommyqu.blog.entity.UserPost;
import com.tommyqu.blog.service.PostService;

@Controller
@RequestMapping(value="post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value="newPost.do")
	public @ResponseBody Boolean newPost(HttpServletRequest request, String postTitle, String postContent, String categorySelect, ModelMap modelMap) {
		Date date=new Date();
		Timestamp postTime = new Timestamp(date.getTime());
		
		Post post = new Post();
		post.setPostTitle(postTitle);
		post.setPostContent(postContent);
		post.setPostTime(postTime);
		post.setPostUpdateTime(postTime);
		
		User user = (User)request.getSession().getAttribute("user");
		
		UserPost userPost = new UserPost();
		userPost.setUser(user);
		userPost.setPost(post);
		
		try {
			postService.addPost(post, userPost);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
//	@RequestMapping(value="showAllPosts.do")
//	public String showAllPosts(HttpServletRequest request, String userId, ModelMap modelMap) {
//		User user = (User)request.getSession().getAttribute("user");
//		List<Post> postList = postService.getAllPostsByUserId(user.getUserId());
//		System.out.println(postList.size());
//		return "/index";
//	}
}
