package com.tommyqu.blog.repositories.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.tommyqu.blog.entities.Blog;
import com.tommyqu.blog.entities.Category;
import com.tommyqu.blog.repositories.IBlogRepository;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public String newBlog(Blog blog) {
		try {
			mongoTemplate.insert(blog, "blog");
			return "success";
		} catch (Exception e) {
			return e.getMessage().toString();
		}
	}

	@Override
	public List<Blog> getAllBlogs() {
		try {
			return mongoTemplate.findAll(Blog.class, "blog");
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return null;
		}
	}

	@Override
	public Blog getBlogById(String id) {
		try {
			return mongoTemplate.findById(id, Blog.class, "blog");
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return null;
		}
	}

	@Override
	public String deleteBlog(String id) {
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("id").is(id));
			mongoTemplate.remove(query, Blog.class, "blog");
			return "success";
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return "fail";
		}
	}
	
	
}
