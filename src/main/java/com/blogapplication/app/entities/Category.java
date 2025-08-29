package com.blogapplication.app.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity


public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int category_Id;
	private String category_Title;
	private String category_Description;
	
	@OneToMany(mappedBy="category")
	public List<Post> posts;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCategory_Id() {
		return category_Id;
	}
	public void setCategory_Id(int category_Id) {
		this.category_Id = category_Id;
	}
	public String getCategory_Title() {
		return category_Title;
	}
	public void setCategory_Title(String category_Title) {
		this.category_Title = category_Title;
	}
	public String getCategory_Description() {
		return category_Description;
	}
	public void setCategory_Description(String category_Description) {
		this.category_Description = category_Description;
	}
	

}
