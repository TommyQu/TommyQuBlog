package com.tommyqu.blog.service;

import java.util.List;

import com.tommyqu.blog.entity.Post;
import com.tommyqu.blog.entity.PostInfo;
import com.tommyqu.blog.entity.PostSimpleInfo;
import com.tommyqu.blog.entity.User;
import com.tommyqu.blog.entity.UserPost;

public interface PostService extends BaseService {
	
	Boolean addPost(Post post, UserPost userPost);
	List<PostSimpleInfo> getAllPostsSimpleInfoByUserId(Integer userId);
	PostInfo getPostInfoByPostId(Integer postId);
}
