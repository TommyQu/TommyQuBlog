package com.tommyqu.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UserPost entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_post", catalog = "tommyqublog")
public class UserPost implements java.io.Serializable {

	// Fields

	private Integer upId;
	private Post post;
	private User user;

	// Constructors

	/** default constructor */
	public UserPost() {
	}

	/** full constructor */
	public UserPost(Post post, User user) {
		this.post = post;
		this.user = user;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "up_id", unique = true, nullable = false)
	public Integer getUpId() {
		return this.upId;
	}

	public void setUpId(Integer upId) {
		this.upId = upId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "up_post_id", nullable = false)
	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "up_user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}