package com.tommyqu.blog.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tommyqu.blog.entities.User;
import com.tommyqu.blog.services.IUserService;

@CrossOrigin
@Controller
@RequestMapping(value="user")
public class UserController {

	@Autowired
	IUserService userService;
	
	@RequestMapping(value="login.do")
	public @ResponseBody String login(String email, String pwd, HttpServletRequest request) {
		User user = userService.login(email, pwd);
		if(user != null) {
			String userJSON = JSON.toJSONString(user);
			request.getSession().setAttribute("user", user);
			return userJSON;
		}
		return "fail";
	}

	@RequestMapping(value="signUp.do")
	public @ResponseBody String signUp(String userJson) {
		User user = new User();
		JSONObject userObj = JSON.parseObject(userJson);
		user.setEmail(userObj.getString("email"));
		user.setPwd(userObj.getString("pwd"));
		user.setFirstName(userObj.getString("firstName"));
		user.setLastName(userObj.getString("lastName"));
		user.setBio(userObj.getString("bio"));
		user.setAvatar("avatar");
		user.setStatus("A");
		return userService.signUp(user);
	}
	
	@RequestMapping(value="checkSession.do")
	public @ResponseBody String checkSession(String email, HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("user");
		if(user == null || user.getEmail().equalsIgnoreCase(email) == false)
			return "fail";
		return "success";
	}
	

}
