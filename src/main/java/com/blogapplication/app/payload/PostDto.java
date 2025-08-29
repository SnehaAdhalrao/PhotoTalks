package com.blogapplication.app.payload;

import java.util.Date;
import java.util.Set;

import com.blogapplication.app.entities.Comment;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDto {
	private Integer postId;
	private String postTitle;
	private String imageName;
	private String postContent;
	private Date addedDate=new Date();
	public CategoryDto category;
	public UserDto user;
	public Set<Comment> comments;
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		imageName = imageName;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	public CategoryDto getCategory() {
		return category;
	}
	public void setCategory(CategoryDto category) {
		this.category = category;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}

}
