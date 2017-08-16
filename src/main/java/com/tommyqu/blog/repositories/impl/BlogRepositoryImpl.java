package com.tommyqu.blog.repositories.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.tommyqu.blog.entities.Blog;
import com.tommyqu.blog.entities.Category;
import com.tommyqu.blog.entities.Comment;
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
	public List<Blog> getBlogsByCategory(String category) {
		try {
			Query query = new Query();
			if(category.equalsIgnoreCase("all") == false)
				query.addCriteria(Criteria.where("categories").in(category));
			query.with(new Sort(Sort.Direction.DESC, "lastUpdatedAt"));
			return mongoTemplate.find(query, Blog.class, "blog");
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
			Query commentQuery = new Query();
			commentQuery.addCriteria(Criteria.where("parentId").is(id));
			mongoTemplate.remove(commentQuery, Comment.class, "comment");
			return "success";
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return "fail";
		}
	}

	@Override
	public String updateBlog(Blog blog) {
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("id").is(blog.getId()));
			Update update = new Update();
			update.set("title", blog.getTitle());
			update.set("content", blog.getContent());
			update.set("categories", blog.getCategories());
			update.set("lastUpdatedAt", blog.getLastUpdatedAt());
			mongoTemplate.findAndModify(query, update, Blog.class);
			return "success";
		} catch (Exception e) {
			return "fail";
		}
	}

	@Override
	public List<Blog> getBlogsBySearchText(String searchText) {
		try {
			Query query = new Query();
			if(searchText != null && searchText != "")
				query.addCriteria(Criteria.where("title").regex(searchText, "i")).addCriteria(Criteria.where("content").regex(searchText, "i"));
			query.with(new Sort(Sort.Direction.DESC, "lastUpdatedAt"));
			return mongoTemplate.find(query, Blog.class, "blog");
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return null;
		}
	}
	
	
}
