package com.tommyqu.blog.services;

import java.util.List;

import com.tommyqu.blog.entities.Comment;

public interface ICommentService {
	
	public String newComment(Comment comment);
	public List<Comment> getCommentsByBlogId(String blogId);
	
}
