package com.blogapplication.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapplication.app.payload.CategoryDto;

import com.blogapplication.app.services.Categoryservices;

@RestController
@RequestMapping("api/categories")
public class categoryController {

	@Autowired
	Categoryservices serviceobj;

//	post--create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> creatingcategory(@RequestBody CategoryDto categorydto){
		CategoryDto createdone=this.serviceobj.CreateCategory(categorydto);
		return new ResponseEntity<>(createdone,HttpStatus.OK);
	}
//	put---update
	@PutMapping("/{category_Id}")
	public ResponseEntity<CategoryDto> updatingcategory(@RequestBody CategoryDto categorydto, @PathVariable Integer category_Id){
		CategoryDto updatedcategorydto=this.serviceobj.updateCategory(categorydto, category_Id);
		return new ResponseEntity<CategoryDto>(updatedcategorydto,HttpStatus.OK); 
		
	}
//	delete--delete
	@DeleteMapping("/{category_Id}")
	public void deletingcategory( @PathVariable Integer category_Id) {
	this.serviceobj.deletecategory(category_Id);	
	}
	
//	get--getsingle
	@GetMapping("/{category_id}")
	public ResponseEntity<CategoryDto> getsinglecat( @PathVariable Integer category_id ){
		CategoryDto getcat=this.serviceobj.getsinglecategory(category_id);
		return new ResponseEntity<CategoryDto>(getcat,HttpStatus.OK);
	}
//	get--getall
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllcat(){
		return new ResponseEntity<>(this.serviceobj.getallcategories(),HttpStatus.OK);
	}
}
