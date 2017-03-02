package com.tommyqu.blog.repositories;

import java.util.List;

import com.tommyqu.blog.entities.Comment;

public interface ICommentRepository {
	
	public String newComment(Comment comment);
	public List<Comment> getCommentsByBlogId(String blogId);
}
