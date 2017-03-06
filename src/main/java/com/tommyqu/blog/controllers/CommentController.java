package com.tommyqu.blog.controllers;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tommyqu.blog.entities.Comment;
import com.tommyqu.blog.entities.User;
import com.tommyqu.blog.services.ICommentService;
import com.tommyqu.blog.utils.TQBUtilities;

@CrossOrigin
@Controller
@RequestMapping(value="comment")
public class CommentController {

	private static final String NO_SESSION_MSG = "no_session";
	
	@Autowired
	ICommentService commentService;
	
	@RequestMapping(value="newComment.do", method=RequestMethod.POST)
	public @ResponseBody String newComment(@RequestBody Comment comment, HttpServletRequest request) {
		
		User createdBy = (User) request.getSession().getAttribute("user");
		if(createdBy == null)
			return NO_SESSION_MSG;
		else {
			createdBy.setPwd(null);
			comment.setCreatedAt(TQBUtilities.getCurrentTime());
			comment.setCreatedBy(createdBy);
			return commentService.newComment(comment);
		}
	}
	
	@RequestMapping(value="getCommentsByBlogId.do", method=RequestMethod.GET)
	public @ResponseBody List<Comment> getCommentsByBlogId(String blogId, HttpServletRequest request) {
		return commentService.getCommentsByBlogId(blogId);
	}
}
