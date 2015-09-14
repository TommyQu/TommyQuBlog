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
import com.tommyqu.blog.entity.Post;
import com.tommyqu.blog.entity.PostInfo;
import com.tommyqu.blog.entity.PostSimpleInfo;
import com.tommyqu.blog.entity.User;
import com.tommyqu.blog.service.PostService;

@Controller
@RequestMapping(value="page")
public class PageController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value="showIndexPage.do")
	public String showIndexPage(ModelMap modelMap) {
		return "/index";
	}
	
	@RequestMapping(value="showBlogPage.do")
	public String showBlogPage(ModelMap modelMap) {
		List<PostSimpleInfo> postSimpleInfoList = postService.getAllPostsSimpleInfoByUserId(1);
		String postSimpleInfoListJson = JSON.toJSONString(postSimpleInfoList);
		modelMap.addAttribute("postSimpleInfoListJson", postSimpleInfoListJson);
		return "/blog";
	}
	
	@RequestMapping(value="showNewPostPage.do")
	public String showNewPostPage(ModelMap modelMap) {
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
}
