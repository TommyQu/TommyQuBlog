package com.tommyqu.blog.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Post entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "post", catalog = "tommyqublog")
public class Post implements java.io.Serializable {

	// Fields

	private Integer postId;
	private String postTitle;
	private String postContent;
	private Timestamp postTime;
	private Timestamp postUpdateTime;
	private Set<UserPost> userPosts = new HashSet<UserPost>(0);

	// Constructors

	/** default constructor */
	public Post() {
	}

	/** minimal constructor */
	public Post(String postTitle, String postContent, Timestamp postTime,
			Timestamp postUpdateTime) {
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postTime = postTime;
		this.postUpdateTime = postUpdateTime;
	}

	/** full constructor */
	public Post(String postTitle, String postContent, Timestamp postTime,
			Timestamp postUpdateTime, Set<UserPost> userPosts) {
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postTime = postTime;
		this.postUpdateTime = postUpdateTime;
		this.userPosts = userPosts;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "post_id", unique = true, nullable = false)
	public Integer getPostId() {
		return this.postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	@Column(name = "post_title", nullable = false, length = 45)
	public String getPostTitle() {
		return this.postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	@Column(name = "post_content", nullable = false, length = 16777215)
	public String getPostContent() {
		return this.postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	@Column(name = "post_time", nullable = false, length = 19)
	public Timestamp getPostTime() {
		return this.postTime;
	}

	public void setPostTime(Timestamp postTime) {
		this.postTime = postTime;
	}

	@Column(name = "post_update_time", nullable = false, length = 19)
	public Timestamp getPostUpdateTime() {
		return this.postUpdateTime;
	}

	public void setPostUpdateTime(Timestamp postUpdateTime) {
		this.postUpdateTime = postUpdateTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "post")
	public Set<UserPost> getUserPosts() {
		return this.userPosts;
	}

	public void setUserPosts(Set<UserPost> userPosts) {
		this.userPosts = userPosts;
	}

}