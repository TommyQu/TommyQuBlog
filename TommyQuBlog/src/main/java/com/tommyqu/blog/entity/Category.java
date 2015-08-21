package com.tommyqu.blog.entity;

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
	private Set<UserCategory> userCategories = new HashSet<UserCategory>(0);
	private Set<PostCategory> postCategories = new HashSet<PostCategory>(0);

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** minimal constructor */
	public Category(String categoryName) {
		this.categoryName = categoryName;
	}

	/** full constructor */
	public Category(String categoryName, Set<UserCategory> userCategories,
			Set<PostCategory> postCategories) {
		this.categoryName = categoryName;
		this.userCategories = userCategories;
		this.postCategories = postCategories;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
	public Set<UserCategory> getUserCategories() {
		return this.userCategories;
	}

	public void setUserCategories(Set<UserCategory> userCategories) {
		this.userCategories = userCategories;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
	public Set<PostCategory> getPostCategories() {
		return this.postCategories;
	}

	public void setPostCategories(Set<PostCategory> postCategories) {
		this.postCategories = postCategories;
	}

}