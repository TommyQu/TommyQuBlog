package com.tommyqu.blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tommyqu.blog.entities.Blog;
import com.tommyqu.blog.repositories.IBlogRepository;
import com.tommyqu.blog.services.IBlogService;

@Service
public class BlogServiceImpl implements IBlogService {

	@Autowired
	IBlogRepository blogRepository;
	
	@Override
	public String newBlog(Blog blog) {
		return blogRepository.newBlog(blog);
	}

	@Override
	public List<Blog> getAllBlogs() {
		return blogRepository.getAllBlogs();
	}

	@Override
	public Blog getBlogById(String id) {
		return blogRepository.getBlogById(id);
	}

}
