package com.tommyqu.blog.repositories.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.tommyqu.blog.entities.Category;
import com.tommyqu.blog.entities.User;
import com.tommyqu.blog.repositories.IAdminRepository;

@Repository
public class AdminRepositoryImpl implements IAdminRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public String newCategory(Category category) {
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("content").is(category.getContent()));
//			Category has been registered!
			if(mongoTemplate.findOne(query, Category.class) != null)
				return "fail";
			else {
				mongoTemplate.insert(category, "category");
				return "success";
			}
		} catch (Exception e) {
			return e.getMessage().toString();
		}
	}

	@Override
	public List<Category> getAllCategories() {
		try {
			return mongoTemplate.findAll(Category.class, "category");
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return null;
		}
	}

}
