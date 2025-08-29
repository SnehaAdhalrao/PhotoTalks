package com.blogapplication.app.payload;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {
	

	private int category_Id;
	@NotEmpty
	private String category_Title;
	@NotEmpty
	private String category_Description;
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
	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
