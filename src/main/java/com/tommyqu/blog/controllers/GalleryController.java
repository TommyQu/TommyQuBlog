package com.tommyqu.blog.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tommyqu.blog.entities.Blog;
import com.tommyqu.blog.entities.Gallery;
import com.tommyqu.blog.entities.User;
import com.tommyqu.blog.services.IGalleryService;

@CrossOrigin
@Controller
@RequestMapping(value="gallery")
public class GalleryController {
	
	@Autowired
	IGalleryService galleryService;
	
	@RequestMapping(value="newGallery.do")
	public @ResponseBody String newGallery(String galleryJson, HttpServletRequest request) {
		JSONObject galleryObj = JSON.parseObject(galleryJson);
		Gallery gallery = new Gallery();
		gallery.setTitle(galleryObj.getString("title"));
		gallery.setDescription(galleryObj.getString("description"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		gallery.setCreadtedOn(sdf.format(date));
		gallery.setLastUpdatedOn(sdf.format(date));
		
		User createdBy = (User) request.getSession().getAttribute("user");
		gallery.setCreatedBy(createdBy);

		return galleryService.newGallery(gallery);
	}

	@RequestMapping(value="uploadImages.do")
	public @ResponseBody String uploadImages(HttpServletRequest request) {
		System.out.println("aaa");

		return null;
	}
	
	@RequestMapping(value="getAllGalleries.do")
	public @ResponseBody String getAllGalleries() {
		String allGalleriesJson = JSON.toJSONString(galleryService.getAllGalleries());
		return allGalleriesJson;
	}
}
