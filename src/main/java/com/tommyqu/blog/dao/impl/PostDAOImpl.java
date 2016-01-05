package com.tommyqu.blog.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tommyqu.blog.dao.PostDAO;
import com.tommyqu.blog.entity.Post;
import com.tommyqu.blog.entity.PostCategory;
import com.tommyqu.blog.entity.PostInfo;
import com.tommyqu.blog.entity.PostSimpleInfo;
import com.tommyqu.blog.entity.User;
import com.tommyqu.blog.entity.UserPost;

@Repository("postDAO")
public class PostDAOImpl implements PostDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public Boolean addPost(Post post, UserPost userPost, List<PostCategory> postCategoryList) {
		try {
			this.sessionFactory.getCurrentSession().save(post);
			this.sessionFactory.getCurrentSession().save(userPost);
			for(int i=0;i<postCategoryList.size();i++) {
				this.sessionFactory.getCurrentSession().save(postCategoryList.get(i));
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<PostSimpleInfo> getAllPostsSimpleInfoByCategoryId(Integer categoryId, Integer pageNum) {
		List<PostSimpleInfo> postSimpleInfoList = new ArrayList<PostSimpleInfo>();
		Integer start = (pageNum-1)*10;
		Integer end = pageNum*10;
		try {
			String hql;
			if(categoryId == null) {
				hql = "FROM PostCategory pc "
						+ "GROUP BY pc.post.postId "
						+ "ORDER BY pc.post.postUpdateTime DESC";
			}
			else {
				hql = "FROM PostCategory pc WHERE pc.category.categoryId = "+categoryId+" "
						+ "ORDER BY pc.post.postUpdateTime DESC";
			}
			Query query = this.getSession().createQuery(hql);
			query.setFirstResult(start);
			query.setMaxResults(10);
			List<PostCategory> postCategoryList = query.list();
			for(int i = 0; i < postCategoryList.size(); i++) {
				PostSimpleInfo postSimpleInfo = new PostSimpleInfo();
				postSimpleInfo.setPostId(postCategoryList.get(i).getPost().getPostId());
				postSimpleInfo.setPostTitle(postCategoryList.get(i).getPost().getPostTitle());
				postSimpleInfo.setPostTime(postCategoryList.get(i).getPost().getPostTime().toString());
				postSimpleInfo.setPostUpdateTime(postCategoryList.get(i).getPost().getPostUpdateTime().toString());
				postSimpleInfo.setUserName("Tommy Qu");
				postSimpleInfoList.add(postSimpleInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return postSimpleInfoList;
	}

	@Override
	public PostInfo getPostInfoByPostId(Integer postId) {
		PostInfo postInfo = new PostInfo();
		try {
			String hql = "FROM UserPost up WHERE up.post.postId = "+postId+"";
			Query query = this.getSession().createQuery(hql);
			List<UserPost> userPostList = query.list();
			postInfo.setPostId(userPostList.get(0).getPost().getPostId());
			postInfo.setPostTitle(userPostList.get(0).getPost().getPostTitle());
			postInfo.setPostContent(userPostList.get(0).getPost().getPostContent());
			postInfo.setPostTime(userPostList.get(0).getPost().getPostTime().toString());
			postInfo.setPostUpdateTime(userPostList.get(0).getPost().getPostUpdateTime().toString());
			postInfo.setUserName(userPostList.get(0).getUser().getUserName());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return postInfo;
	}

	@Override
	public Integer getPostNumByCategoryId(Integer categoryId) {
		Integer postNum = 0;
		try {
			String hql;
			if(categoryId == null) {
				hql = "FROM UserPost up WHERE up.user.userId = 1";
			}
			else {
				hql = "FROM PostCategory pc WHERE pc.category.categoryId = "+categoryId+"";
			}
			Query query = this.getSession().createQuery(hql);
			postNum = query.list().size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return postNum;
	}

}
