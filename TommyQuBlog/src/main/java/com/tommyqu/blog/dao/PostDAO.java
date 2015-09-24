package com.tommyqu.blog.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import com.tommyqu.blog.entity.Post;
import com.tommyqu.blog.entity.PostCategory;
import com.tommyqu.blog.entity.PostInfo;
import com.tommyqu.blog.entity.PostSimpleInfo;
import com.tommyqu.blog.entity.User;
import com.tommyqu.blog.entity.UserPost;

public interface PostDAO extends BaseDAO {
	
	Boolean addPost(Post post, UserPost userPost, List<PostCategory> postCategoryList);
	List<PostSimpleInfo> getAllPostsSimpleInfoByCategoryId(Integer categoryId, Integer pageNum);
	PostInfo getPostInfoByPostId(Integer postId);
	Integer getPostNumByCategoryId(Integer categoryId);
}
