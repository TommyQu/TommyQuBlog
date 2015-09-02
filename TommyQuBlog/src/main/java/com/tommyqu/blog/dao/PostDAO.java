package com.tommyqu.blog.dao;

import java.util.List;

import com.tommyqu.blog.entity.Post;
import com.tommyqu.blog.entity.User;
import com.tommyqu.blog.entity.UserPost;

public interface PostDAO extends BaseDAO {
	
	Boolean addPost(Post post, UserPost userPost);
	List<Post> getAllPostsByUserId(Integer userId);
}
