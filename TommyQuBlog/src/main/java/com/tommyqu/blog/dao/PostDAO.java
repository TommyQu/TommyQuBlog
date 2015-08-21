package com.tommyqu.blog.dao;

import com.tommyqu.blog.entity.Post;
import com.tommyqu.blog.entity.User;
import com.tommyqu.blog.entity.UserPost;

public interface PostDAO extends BaseDAO {
	
	Boolean addPost(Post post, UserPost userPost);
	void getAllPostsByUserId(User user);
}
