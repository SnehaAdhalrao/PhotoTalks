package com.blogapplication.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String content;
	@ManyToOne
	 Post post;
	
	 public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setContent(String content) {
		this.content = content;
	}

}
