package com.tommyqu.blog.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.jboss.logging.annotations.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tommyqu.blog.dao.PostDAO;
import com.tommyqu.blog.entity.Post;
import com.tommyqu.blog.entity.PostInfo;
import com.tommyqu.blog.entity.PostSimpleInfo;
import com.tommyqu.blog.entity.User;
import com.tommyqu.blog.entity.UserPost;
import com.tommyqu.blog.service.PostService;

@Service("postService")
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostDAO postDAO;
	
	@Override
	public Session getSession() {
		return postDAO.getSession();
	}

	@Override
	public Boolean addPost(Post post, UserPost userPost) {
		return postDAO.addPost(post, userPost);
	}

	@Override
	public List<PostSimpleInfo> getAllPostsSimpleInfoByUserId(Integer userId, Integer pageNum) {
		return postDAO.getAllPostsSimpleInfoByUserId(userId, pageNum);
	}

	@Override
	public PostInfo getPostInfoByPostId(Integer postId) {
		return postDAO.getPostInfoByPostId(postId);
	}

	@Override
	public Integer getPostNumByUserId(Integer userId) {
		return postDAO.getPostNumByUserId(userId);
	}

}
