package com.blogapplication.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapplication.app.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment,Integer> {
	

}
