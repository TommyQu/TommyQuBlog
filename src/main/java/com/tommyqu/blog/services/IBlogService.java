package com.tommyqu.blog.services;

import java.util.List;

import com.tommyqu.blog.entities.Blog;

public interface IBlogService {
	public String newBlog(Blog blog);
	public List<Blog> getBlogsByCategory(String category);
	public Blog getBlogById(String id);
	public String deleteBlog(String id);
	public String updateBlog(Blog blog);
	public List<Blog> getBlogsBySearchText(String searchText);
}
