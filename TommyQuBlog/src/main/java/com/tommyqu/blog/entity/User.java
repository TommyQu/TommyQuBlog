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
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "tommyqublog", uniqueConstraints = {
		@UniqueConstraint(columnNames = "user_login_name"),
		@UniqueConstraint(columnNames = "user_name") })
public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userLoginName;
	private String userPwd;
	private String userName;
	private Set<UserPost> userPosts = new HashSet<UserPost>(0);
	private Set<UserCategory> userCategories = new HashSet<UserCategory>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userLoginName, String userPwd, String userName) {
		this.userLoginName = userLoginName;
		this.userPwd = userPwd;
		this.userName = userName;
	}

	/** full constructor */
	public User(String userLoginName, String userPwd, String userName,
			Set<UserPost> userPosts, Set<UserCategory> userCategories) {
		this.userLoginName = userLoginName;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userPosts = userPosts;
		this.userCategories = userCategories;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "user_login_name", unique = true, nullable = false, length = 45)
	public String getUserLoginName() {
		return this.userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	@Column(name = "user_pwd", nullable = false, length = 45)
	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Column(name = "user_name", unique = true, nullable = false, length = 45)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserPost> getUserPosts() {
		return this.userPosts;
	}

	public void setUserPosts(Set<UserPost> userPosts) {
		this.userPosts = userPosts;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserCategory> getUserCategories() {
		return this.userCategories;
	}

	public void setUserCategories(Set<UserCategory> userCategories) {
		this.userCategories = userCategories;
	}

}