package com.blogapplication.app.services;

import java.util.List;


import com.blogapplication.app.payload.PostDto;
import com.blogapplication.app.payload.PostResponse;

public interface PostServices {
	
//	create
public PostDto createpost(PostDto postdto,Integer userId,Integer categoryId);
//	update
public PostDto updatePost(PostDto postdto,Integer postId);
//	delete
public void deletingpost(Integer PostId);

//	getAll
public PostResponse allposts(Integer pageNumber, Integer pageSize);
//	getsinglebypostid
public PostDto getsinglePostByid(Integer postId);
//	getallpostby UserId
public List<PostDto>  getPostByUser(Integer userId);

//	getallpostbycustomerId

public List<PostDto> getPostByCategory(Integer categoryId);
//	searchposByKEyword

}
