package com.tommyqu.blog.repositories;

import java.util.List;

import com.tommyqu.blog.entities.Blog;
import com.tommyqu.blog.entities.Category;

public interface IBlogRepository {
	public String newBlog(Blog blog);
	public List<Blog> getBlogsByCategory(String category);
	public Blog getBlogById(String id);
	public String deleteBlog(String id);
	public String updateBlog(Blog blog);
}
