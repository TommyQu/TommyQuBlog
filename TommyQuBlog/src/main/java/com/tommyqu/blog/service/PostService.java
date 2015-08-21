package com.tommyqu.blog.service;

import com.tommyqu.blog.entity.Post;
import com.tommyqu.blog.entity.User;
import com.tommyqu.blog.entity.UserPost;

public interface PostService extends BaseService {
	
	Boolean addPost(Post post, UserPost userPost);
	void getAllPostsByUserId(User user);
}
