package com.tommyqu.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tommyqu.blog.service.UserService;

@Controller
@RequestMapping(value="user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="login.do")
	public @ResponseBody Boolean userLogin(String userLoginName, String userPwd, ModelMap model) {
		Boolean flag = userService.userLogin(userLoginName, userPwd);
		return flag;
	}
}
