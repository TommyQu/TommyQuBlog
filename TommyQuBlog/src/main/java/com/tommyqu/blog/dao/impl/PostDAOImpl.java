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
	public Boolean addPost(Post post, UserPost userPost) {
		try {
			this.sessionFactory.getCurrentSession().save(post);
			this.sessionFactory.getCurrentSession().save(userPost);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<PostSimpleInfo> getAllPostsSimpleInfoByUserId(Integer userId) {
		List<PostSimpleInfo> postSimpleInfoList = new ArrayList<PostSimpleInfo>();
		try {
			String hql = "from UserPost up where up.user.userId = "+userId+"";
//			StringBuffer sb = new StringBuffer("select p.postId, p.postTitle "
//					+ "from Post as p, UserPost as up "
//					+ "where up.upUserId")
			Query query = this.getSession().createQuery(hql);
			List<UserPost> userPostList = query.list();
			for(int i = 0; i < userPostList.size(); i++) {
				PostSimpleInfo postSimpleInfo = new PostSimpleInfo();
				postSimpleInfo.setPostId(userPostList.get(i).getPost().getPostId());
				postSimpleInfo.setPostTitle(userPostList.get(i).getPost().getPostTitle());
				postSimpleInfo.setPostTime(userPostList.get(i).getPost().getPostTime().toString());
				postSimpleInfo.setPostUpdateTime(userPostList.get(i).getPost().getPostUpdateTime().toString());
				postSimpleInfo.setUserName(userPostList.get(i).getUser().getUserName());
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
			String hql = "from UserPost up where up.post.postId = "+postId+"";
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

}
