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

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="page")
public class PageController {
	
	@RequestMapping(value="showIndexPage.do")
	public String showIndexPage(ModelMap model) {
		return "/index";
	}
	
	@RequestMapping(value="showBlogPage.do")
	public String showBlogPage(ModelMap model) {
		return "/blog";
	}
	
	@RequestMapping(value="showNewPostPage.do")
	public String showNewPostPage(ModelMap model) {
		return "/newPost";
	}
}
