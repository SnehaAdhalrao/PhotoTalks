package com.blogapplication.app.services;

import java.util.List;

import com.blogapplication.app.payload.CategoryDto;
import com.blogapplication.app.repositories.CategoryRepo;

public interface Categoryservices {
//create
  CategoryDto CreateCategory(CategoryDto categorydto) ;
//update
 CategoryDto updateCategory(CategoryDto categorydto, Integer category_id);
//delete
 void deletecategory(Integer category_Id);
//get all
List<CategoryDto> getallcategories();
//get single category
CategoryDto getsinglecategory(Integer category_id);
}
