package com.tommyqu.blog.controller;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.tommyqu.blog.entity.Category;
import com.tommyqu.blog.entity.Post;
import com.tommyqu.blog.entity.PostCategory;
import com.tommyqu.blog.entity.User;
import com.tommyqu.blog.entity.UserPost;
import com.tommyqu.blog.service.CategoryService;
import com.tommyqu.blog.service.PostService;

@Controller
@RequestMapping(value="post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="newPost.do")
	public @ResponseBody Boolean newPost(HttpServletRequest request, String postTitle, String postContent, String categoryString, ModelMap modelMap) {
		System.out.println(postContent);
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
		
		String[] categoryStringList = categoryString.split(",");
		List<Integer> categoryIdList = new ArrayList<Integer>();
		for(int i=0;i<categoryStringList.length;i++) {
			categoryIdList.add(Integer.parseInt(categoryStringList[i]));
		}
		
		List<PostCategory> postCategoryList = new ArrayList<PostCategory>();

		for(int i=0;i<categoryIdList.size();i++) {
			PostCategory postCategory = new PostCategory();
			postCategory.setPost(post);
			Category category = categoryService.getCategoryById(categoryIdList.get(i));
			postCategory.setCategory(category);
			postCategoryList.add(postCategory);
		}

		try {
			postService.addPost(post, userPost, postCategoryList);
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
