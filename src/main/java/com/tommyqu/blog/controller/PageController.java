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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.tommyqu.blog.entity.Category;
import com.tommyqu.blog.entity.CategoryInfo;
import com.tommyqu.blog.entity.Post;
import com.tommyqu.blog.entity.PostInfo;
import com.tommyqu.blog.entity.PostSimpleInfo;
import com.tommyqu.blog.entity.User;
import com.tommyqu.blog.service.CategoryService;
import com.tommyqu.blog.service.PostService;

@Controller
@RequestMapping(value="page")
public class PageController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="showIndexPage.do")
	public String showIndexPage(ModelMap modelMap) {
		return "/index";
	}
	
	@RequestMapping(value="showBlogPage.do")
	public String showBlogPage(Integer pageNum, Integer categoryId, ModelMap modelMap) {
		if(pageNum == null)
			pageNum = 1;
		List<PostSimpleInfo> postSimpleInfoList = postService.getAllPostsSimpleInfoByCategoryId(categoryId, pageNum);
		String postSimpleInfoListJson = JSON.toJSONString(postSimpleInfoList);
		
		List<CategoryInfo> categoryInfoList = categoryService.getAllCategoryInfoByUserId(1);
		String categoryInfoListJson = JSON.toJSONString(categoryInfoList);
		
		Integer totalPageNum = postService.getPostNumByCategoryId(categoryId)/10+1;
		modelMap.addAttribute("totalPageNum", totalPageNum);
		modelMap.addAttribute("currentPageNum", pageNum);
		modelMap.addAttribute("postSimpleInfoListJson", postSimpleInfoListJson);
		modelMap.addAttribute("categoryInfoListJson", categoryInfoListJson);
		return "/blog";
	}
	
	@RequestMapping(value="showNewPostPage.do")
	public String showNewPostPage(HttpServletRequest request, ModelMap modelMap) {
		User user = (User)request.getSession().getAttribute("user");
		List<CategoryInfo> categoryInfoList = categoryService.getAllCategoryInfoByUserId(user.getUserId());
		String categoryInfoListJson = JSON.toJSONString(categoryInfoList);
		modelMap.addAttribute("categoryInfoListJson", categoryInfoListJson);
		return "/newPost";
	}
	
	@RequestMapping(value="showSinglePostPage.do")
	public String showSinglePostPage(Integer postId, ModelMap modelMap) {
		PostInfo postInfo = postService.getPostInfoByPostId(postId);
		modelMap.addAttribute("postInfo", postInfo);
		return "/singlePost";
	}
	
	@RequestMapping(value="showAboutMe.do")
	public String showAboutMe(ModelMap modelMap) {
		return "/aboutMe";
	}
	
	@RequestMapping(value="showCategorizedPage.do")
	public String showCategorizedPage(Integer categoryId, ModelMap modelMap) {
		return "/aboutMe";
	}
}
