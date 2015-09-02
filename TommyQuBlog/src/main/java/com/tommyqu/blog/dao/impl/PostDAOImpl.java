package com.tommyqu.blog.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tommyqu.blog.dao.PostDAO;
import com.tommyqu.blog.entity.Post;
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
	public List<Post> getAllPostsByUserId(Integer userId) {
		List<Post> postList = new ArrayList<Post>();
		try {
			String hql = "from UserPost up where up.user.userId = "+userId+"";
//			StringBuffer sb = new StringBuffer("select p.postId, p.postTitle "
//					+ "from Post as p, UserPost as up "
//					+ "where up.upUserId")
			Query query = this.getSession().createQuery(hql);
			List<UserPost> userPostList = query.list();
			for(int i = 0; i < userPostList.size(); i++) {
				postList.add(userPostList.get(i).getPost());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return postList;
	}

}
