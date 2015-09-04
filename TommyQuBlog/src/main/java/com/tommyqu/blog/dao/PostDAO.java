package com.tommyqu.blog.dao;

import java.util.List;

import com.tommyqu.blog.entity.Post;
import com.tommyqu.blog.entity.PostInfo;
import com.tommyqu.blog.entity.PostSimpleInfo;
import com.tommyqu.blog.entity.User;
import com.tommyqu.blog.entity.UserPost;

public interface PostDAO extends BaseDAO {
	
	Boolean addPost(Post post, UserPost userPost);
	List<PostSimpleInfo> getAllPostsSimpleInfoByUserId(Integer userId);
	PostInfo getPostInfoByPostId(Integer postId);
}
