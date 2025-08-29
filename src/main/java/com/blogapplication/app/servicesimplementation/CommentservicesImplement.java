package com.blogapplication.app.servicesimplementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapplication.app.entities.Comment;
import com.blogapplication.app.entities.Post;
import com.blogapplication.app.exceptions.ResourceNotFound;
import com.blogapplication.app.payload.CommentDto;
import com.blogapplication.app.repositories.CommentRepo;
import com.blogapplication.app.repositories.PostRepo;
import com.blogapplication.app.services.Commentservices;
import com.blogapplication.app.services.PostServices;
@Service
public class CommentservicesImplement implements Commentservices {

	@Autowired
	CommentRepo commentrepoobj;
	@Autowired
	PostServices postserobj;
	@Autowired
	ModelMapper modelmapper;
	@Override
	public CommentDto creating(CommentDto commentdto,Integer postId) {
		Post post=this.modelmapper.map(this.postserobj.getsinglePostByid(postId), Post.class);
		Comment comment=this.modelmapper.map(commentdto, Comment.class);
		comment.setPost(post);
		this.commentrepoobj.save(comment);
		return this.modelmapper.map(comment, CommentDto.class) ;
	}

	@Override
	public void deleteing(Integer commentId) {
		this.commentrepoobj.deleteById(commentId);
		
	}

}
