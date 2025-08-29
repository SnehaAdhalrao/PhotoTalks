package com.blogapplication.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapplication.app.entities.User;
import com.blogapplication.app.exceptions.ResourceNotFound;
import com.blogapplication.app.payload.UserDto;
import com.blogapplication.app.repositories.UserRepo;
import com.blogapplication.app.services.UserServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class userControllers {
	@Autowired
	UserServices obj;
	
//	post-cresteuser
	@PostMapping("/")
	public ResponseEntity<UserDto> createuser(@Valid @RequestBody UserDto userdto){
		UserDto createduser=this.obj.createUser(userdto);
		return new ResponseEntity<>(createduser,HttpStatus.CREATED);
	}
	
//	 put- update user
	@PutMapping("/{user_id}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userdto, @PathVariable Integer user_id){
//		
		this.obj.updateUser(userdto, user_id);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
//	delete -delete user
	@DeleteMapping("/{user_id}")
	public ResponseEntity<?> deletingUser(@Valid @PathVariable Integer user_id){
		this.obj.deleteUser(user_id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
//	get- get all users
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(this.obj.getAll());
		
		
	}
	
	@GetMapping("/{user_id}")
	public ResponseEntity<UserDto> getsingleUsers(@Valid @PathVariable Integer user_id){
		
		return new ResponseEntity<>((this.obj.getById(user_id)),HttpStatus.OK)	;	
		
		
	}

}
