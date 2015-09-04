package com.tommyqu.blog.entity;

import java.sql.Timestamp;

public class PostSimpleInfo {
	
	private Integer postId;
	private String postTitle;
	private String postTime;
	private String postUpdateTime;
	private String userName;
	
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
	public String getPostUpdateTime() {
		return postUpdateTime;
	}
	public void setPostUpdateTime(String postUpdateTime) {
		this.postUpdateTime = postUpdateTime;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
