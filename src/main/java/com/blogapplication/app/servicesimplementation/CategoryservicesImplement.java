package com.blogapplication.app.servicesimplementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapplication.app.entities.Category;
import com.blogapplication.app.exceptions.ResourceNotFound;
import com.blogapplication.app.payload.CategoryDto;
import com.blogapplication.app.repositories.CategoryRepo;
import com.blogapplication.app.services.Categoryservices;

@Service
public class CategoryservicesImplement implements Categoryservices {
	@Autowired
	ModelMapper modelmapper;
	@Autowired
	CategoryRepo obj;

	@Override
	public CategoryDto CreateCategory(CategoryDto categorydto) {
		Category category=this.modelmapper.map(categorydto, Category.class);
		this.obj.save(category);
		return this.modelmapper.map(category, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categorydto, Integer category_id) {
		Category category=this.obj.findById(category_id).orElseThrow(()->new ResourceNotFound("Category","id",category_id));
		category.setCategory_Title(categorydto.getCategory_Title());
		category.setCategory_Description(categorydto.getCategory_Description());
		this.obj.save(category);
		return this.modelmapper.map(category, CategoryDto.class);
	}

	@Override
	public void deletecategory(Integer category_Id) {
//		Category category=this.obj.findById(category_Id).orElseThrow(()->new ResourceNotFound("Category","id",category_Id));
		this.obj.deleteById(category_Id);
	}

	@Override
	public List<CategoryDto> getallcategories() {
	List<Category> categories=this.obj.findAll();
	
		return categories.stream().map((cat)->this.modelmapper.map(cat,CategoryDto.class)).collect(Collectors.toList()) ;
	}

	@Override
	public CategoryDto getsinglecategory(Integer category_id) {
		Category category=this.obj.findById(category_id).orElseThrow(()->new ResourceNotFound("Category","id",category_id));
		return this.modelmapper.map(category, CategoryDto.class);
	}

}
