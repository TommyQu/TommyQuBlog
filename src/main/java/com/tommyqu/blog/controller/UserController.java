package com.tommyqu.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tommyqu.blog.entity.User;
import com.tommyqu.blog.service.UserService;

@Controller
@RequestMapping(value="user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="login.do")
	public @ResponseBody Boolean userLogin(String userLoginName, String userPwd, HttpServletRequest request, ModelMap modelMap) {
		User user = userService.userLogin(userLoginName, userPwd);
		Boolean flag = false;
		if(user != null) {
			request.getSession().setAttribute("user", user);
			flag = true;
		}
		return flag;
	}
	
	@RequestMapping(value="signOut.do")
	public String userSignOut(HttpServletRequest request, ModelMap modelMap) {
		request.getSession().removeAttribute("user");
		request.getSession().invalidate();
//		System.out.println(request.getRequestURI());
		return "redirect:/page/showIndexPage.do";
	}
}
