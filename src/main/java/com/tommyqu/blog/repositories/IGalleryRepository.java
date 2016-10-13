package com.tommyqu.blog.repositories;

import java.util.List;

import com.tommyqu.blog.entities.Gallery;

public interface IGalleryRepository {
	
	public String newGallery(Gallery gallery);
	public List<Gallery> getAllGalleries();
}
