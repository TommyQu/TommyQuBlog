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
 * UserCategory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_category", catalog = "tommyqublog")
public class UserCategory implements java.io.Serializable {

	// Fields

	private Integer ucId;
	private User user;
	private Category category;

	// Constructors

	/** default constructor */
	public UserCategory() {
	}

	/** full constructor */
	public UserCategory(User user, Category category) {
		this.user = user;
		this.category = category;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "uc_id", unique = true, nullable = false)
	public Integer getUcId() {
		return this.ucId;
	}

	public void setUcId(Integer ucId) {
		this.ucId = ucId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uc_user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uc_category_id", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}