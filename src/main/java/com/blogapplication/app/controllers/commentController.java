package com.blogapplication.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapplication.app.entities.Post;
import com.blogapplication.app.payload.CommentDto;
import com.blogapplication.app.repositories.PostRepo;
import com.blogapplication.app.responses.ApiResponse;
import com.blogapplication.app.services.Commentservices;




@RestController
@RequestMapping("/api/")
public class commentController {
	@Autowired 
	Commentservices commentserobj;
	
	
	@PostMapping("/posts/{postId}/comment/create")
	public ResponseEntity<CommentDto>crete(@RequestBody CommentDto commentdto, @PathVariable Integer postId){
		
		CommentDto createdcomment= this.commentserobj.creating(commentdto,postId);
		return new ResponseEntity<>(createdcomment,HttpStatus.OK);
		 
	}
	
	@DeleteMapping("/delete/{commentId}")
	public ResponseEntity<ApiResponse> delete(@PathVariable Integer commentId){
		this.commentserobj.deleteing(commentId);
		return new ResponseEntity<>(new ApiResponse("deleted successfully",true),HttpStatus.OK);
	}

}
