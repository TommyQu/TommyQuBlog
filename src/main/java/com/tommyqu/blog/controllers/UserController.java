package com.tommyqu.blog.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tommyqu.blog.entities.User;
import com.tommyqu.blog.services.IUserService;
import com.tommyqu.blog.utils.Constants;

@CrossOrigin
@Controller
@RequestMapping(value="user")
public class UserController {

	@Autowired
	IUserService userService;
	
	@RequestMapping(value="login.do")
	public @ResponseBody User login(String email, String pwd, HttpServletRequest request, HttpServletResponse response) {
		User user = userService.login(email, pwd);
		if(user != null) {
			request.getSession().setAttribute("user", user);
			return user;
		}
		response.setStatus(Constants.SC_UNPROCESSABLE_ENTITY);
		return null;
	}

	@RequestMapping(value="signUp.do")
	public @ResponseBody String signUp(@RequestBody User user, HttpServletResponse response) {
		user.setAvatar("avatar");
		user.setStatus("A");
		String result = userService.signUp(user);
		if(result.equalsIgnoreCase("exist")) {
			response.setStatus(HttpServletResponse.SC_CONFLICT);
		} else if(result.equalsIgnoreCase("success")) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			response.setStatus(Constants.SC_UNPROCESSABLE_ENTITY);
		}
		return result;
	}
	
	@RequestMapping(value="checkSession.do")
	public @ResponseBody String checkSession(String email, HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("user");
		if(user == null || user.getEmail().equalsIgnoreCase(email) == false)
			return "fail";
		return "success";
	}
	
	@RequestMapping(value="signOut.do")
	public @ResponseBody String signOut(HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("user");
		if(null != user)
			request.getSession().removeAttribute("user");
		return "success";
	}
}
