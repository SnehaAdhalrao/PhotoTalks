package com.blogapplication.app.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.blogapplication.app.payload.CommentDto;
import com.blogapplication.app.repositories.CommentRepo;

public interface Commentservices {
	

//	create
	public CommentDto creating(CommentDto commentdto,Integer postId);
	
//	delete
	public void deleteing(Integer commentId);
	

}
