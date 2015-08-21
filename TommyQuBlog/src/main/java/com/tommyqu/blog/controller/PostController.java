package com.tommyqu.blog.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String newPost(String postTitle, String postContent, ModelMap modelMap) {
		
		Date date=new Date();
		Timestamp postTime = new Timestamp(date.getTime());
		
		Post post = new Post();
		post.setPostTitle(postTitle);
		post.setPostContent(postContent);
		post.setPostTime(postTime);
		post.setPostUpdateTime(postTime);
		
		User user = new User();
		user.setUserId(1);
		user.setUserLoginName("tommyqu1992@gmail.com");
		user.setUserName("Tommy Qu");
		
		UserPost userPost = new UserPost();
		userPost.setUser(user);
		userPost.setPost(post);
		
//		postService.addPost(post, userPost);
		postService.getAllPostsByUserId(user);

		return "/index";
	}

}
