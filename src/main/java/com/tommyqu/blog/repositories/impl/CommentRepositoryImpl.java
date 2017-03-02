package com.tommyqu.blog.repositories.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.tommyqu.blog.entities.Blog;
import com.tommyqu.blog.entities.Comment;
import com.tommyqu.blog.repositories.ICommentRepository;

@Repository
public class CommentRepositoryImpl implements ICommentRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public String newComment(Comment comment) {
		try {
			mongoTemplate.insert(comment, "comment");
			return "success";
		} catch (Exception e) {
			return e.getMessage().toString();
		}
	}

	@Override
	public List<Comment> getCommentsByBlogId(String blogId) {
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("parentId").is(blogId));
			query.with(new Sort(Sort.Direction.DESC, "createdAt"));
			return mongoTemplate.find(query, Comment.class, "comment");
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return null;
		}
	}

}
