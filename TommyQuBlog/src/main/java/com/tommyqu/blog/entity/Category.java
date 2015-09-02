package com.tommyqu.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "category", catalog = "tommyqublog", uniqueConstraints = @UniqueConstraint(columnNames = "category_name"))
public class Category implements java.io.Serializable {

	// Fields

	private Integer categoryId;
	private String categoryName;

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** full constructor */
	public Category(String categoryName) {
		this.categoryName = categoryName;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "category_id", unique = true, nullable = false)
	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "category_name", unique = true, nullable = false, length = 45)
	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}