package com.tommyqu.blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tommyqu.blog.entities.Gallery;
import com.tommyqu.blog.repositories.IGalleryRepository;
import com.tommyqu.blog.services.IGalleryService;

@Service
public class GalleryServiceImpl implements IGalleryService{

	@Autowired
	IGalleryRepository galleryRepository;
	
	@Override
	public String newGallery(Gallery gallery) {
		return galleryRepository.newGallery(gallery);
	}

	@Override
	public List<Gallery> getAllGalleries() {
		return galleryRepository.getAllGalleries();
	}

}
