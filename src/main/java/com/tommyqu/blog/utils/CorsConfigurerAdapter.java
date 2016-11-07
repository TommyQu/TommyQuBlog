package com.tommyqu.blog.utils;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class CorsConfigurerAdapter extends WebMvcConfigurerAdapter {

	@Override 
	public void addCorsMappings(CorsRegistry registry) { 
		registry.addMapping("/api/*").allowedOrigins("*"); 
	}
}
