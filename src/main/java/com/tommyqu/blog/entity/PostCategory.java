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
 * PostCategory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "post_category", catalog = "tommyqublog")
public class PostCategory implements java.io.Serializable {

	// Fields

	private Integer pcId;
	private Category category;
	private Post post;

	// Constructors

	/** default constructor */
	public PostCategory() {
	}

	/** full constructor */
	public PostCategory(Category category, Post post) {
		this.category = category;
		this.post = post;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "pc_id", unique = true, nullable = false)
	public Integer getPcId() {
		return this.pcId;
	}

	public void setPcId(Integer pcId) {
		this.pcId = pcId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pc_category_id", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pc_post_id", nullable = false)
	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}