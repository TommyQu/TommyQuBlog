package com.tommyqu.blog.controllers;

import static org.hamcrest.CoreMatchers.nullValue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tommyqu.blog.entities.Gallery;
import com.tommyqu.blog.entities.User;
import com.tommyqu.blog.services.IGalleryService;
import com.tommyqu.blog.utils.TQBUtilities;

@CrossOrigin
@Controller
@RequestMapping(value="gallery")
public class GalleryController {
	
	@Autowired
	IGalleryService galleryService;
	
	@RequestMapping(value="newGallery.do")
	public @ResponseBody String newGallery(@RequestBody Gallery gallery, HttpServletRequest request) {
		gallery.setCreadtedOn(TQBUtilities.getCurrentTime());
		gallery.setLastUpdatedOn(TQBUtilities.getCurrentTime());
		
		User createdBy = (User) request.getSession().getAttribute("user");
		createdBy.setPwd(null);
		gallery.setCreatedBy(createdBy);

		return galleryService.newGallery(gallery);
	}

	@RequestMapping(value="uploadImages.do")
	public @ResponseBody String uploadImages(HttpServletRequest request) {
		System.out.println("aaa");

		return null;
	}
	
	@RequestMapping(value="getAllGalleries.do")
	public @ResponseBody List<Gallery> getAllGalleries() {
		return galleryService.getAllGalleries();
	}
}
