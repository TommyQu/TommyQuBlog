package com.tommyqu.blog.dao.impl;

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
	public void getAllPostsByUserId(User user) {
		try {
			String hql = "from UserPost up where up.user = '"+user+"'";
//			StringBuffer sb = new StringBuffer("select p.postId, p.postTitle "
//					+ "from Post as p, UserPost as up "
//					+ "where up.upUserId")
			Query query = this.getSession().createQuery(hql);
			
//			List<User> postList = query.list();
			System.out.println(query.list().size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
