package com.tommyqu.blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tommyqu.blog.entities.Comment;
import com.tommyqu.blog.repositories.ICommentRepository;
import com.tommyqu.blog.services.ICommentService;

@Service
public class CommentServiceImpl implements ICommentService {

	@Autowired
	ICommentRepository commentRepository;
	
	@Override
	public String newComment(Comment comment) {
		return commentRepository.newComment(comment);
	}

	@Override
	public List<Comment> getCommentsByBlogId(String blogId) {
		return commentRepository.getCommentsByBlogId(blogId);
	}

}
