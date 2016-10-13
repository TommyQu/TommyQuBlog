package com.tommyqu.blog.services;

import java.util.List;

import com.tommyqu.blog.entities.Gallery;

public interface IGalleryService {
	
	public String newGallery(Gallery gallery);
	public List<Gallery> getAllGalleries();
}
