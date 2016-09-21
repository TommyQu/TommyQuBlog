package com.tommyqu.blog.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.BeanEntry;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.tommyqu.blog.entities.User;
import com.tommyqu.blog.repositories.IUserRepository;

@Repository
public class UserRepositoryImpl implements IUserRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public User login(String email, String pwd) {
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("email").is(email).and("pwd").is(pwd));
			User user = mongoTemplate.findOne(query, User.class);
			if(user != null) {
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public String signUp(User user) {
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("email").is(user.getEmail()));
//			Email has been registered!
			if(mongoTemplate.findOne(query, User.class) != null)
				return "fail";
			else {
				mongoTemplate.insert(user, "user");
				return "success";
			}
		} catch (Exception e) {
			return e.getMessage().toString();
		}
	}


}
