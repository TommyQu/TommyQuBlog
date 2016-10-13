package com.tommyqu.blog.repositories.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.tommyqu.blog.entities.Blog;
import com.tommyqu.blog.entities.Gallery;
import com.tommyqu.blog.repositories.IGalleryRepository;

@Repository
public class GalleryRepositoryImpl implements IGalleryRepository{

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public String newGallery(Gallery gallery) {
		try {
			mongoTemplate.insert(gallery, "gallery");
			return "success";
		} catch (Exception e) {
			return e.getMessage().toString();
		}
	}

	@Override
	public List<Gallery> getAllGalleries() {
		try {
			return mongoTemplate.findAll(Gallery.class, "gallery");
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return null;
		}
	}

}
