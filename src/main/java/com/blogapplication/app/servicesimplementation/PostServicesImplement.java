package com.blogapplication.app.servicesimplementation;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapplication.app.entities.Category;
import com.blogapplication.app.entities.Post;
import com.blogapplication.app.entities.User;
import com.blogapplication.app.exceptions.ResourceNotFound;
import com.blogapplication.app.payload.CategoryDto;
import com.blogapplication.app.payload.PostDto;
import com.blogapplication.app.payload.PostResponse;
import com.blogapplication.app.payload.UserDto;
import com.blogapplication.app.repositories.CategoryRepo;
import com.blogapplication.app.repositories.PostRepo;
import com.blogapplication.app.repositories.UserRepo;
import com.blogapplication.app.responses.ApiResponse;
import com.blogapplication.app.services.PostServices;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


@Service
public class PostServicesImplement implements PostServices {
	@Autowired
	PostRepo repoobj;
	@Autowired
	UserRepo userrepoobj;
	@Autowired
	CategoryRepo catrepoobj;
	@Autowired
	ModelMapper modelmapper;

	@Override
	public PostDto createpost(PostDto postdto,Integer userId,Integer categoryId) {
//		taking user and category obj bcz pta toh chle kisne aur konsi category mein post dala hain these are in payload so need to set them
		User user=this.userrepoobj.findById(userId).orElseThrow(()->new ResourceNotFound("User","id",userId));
		Category category=this.catrepoobj.findById(categoryId).orElseThrow(()->new ResourceNotFound("category","id",userId));;
		Post created=this.modelmapper.map(postdto, Post.class);
		created.setUser(user);
		created.setCategory(category);
		created.setAddedDate(new Date());
		this.repoobj.save(created);
		PostDto createdDto=this.modelmapper.map(created, PostDto.class);
		return createdDto;
	}

	@Override
	public PostDto updatePost(PostDto postdto, Integer postId) {
		Post post=repoobj.findById(postId).orElseThrow(()->new ResourceNotFound("Post","id",postId));
		post.setPostTitle(postdto.getPostTitle());
		post.setImageName(postdto.getImageName());
		post.setPostContent(post.getPostContent());
		post.setAddedDate(postdto.getAddedDate());
		User user=this.modelmapper.map(postdto.getUser(),User.class);
		Category category=this.modelmapper.map(postdto.getCategory(), Category.class);
		post.setUser(user);
		post.setCategory(category);
		return null;
	}

	@Override
	public void deletingpost(Integer PostId) {
		this.repoobj.deleteById(PostId);
		
		
	}



	@Override
	public PostDto getsinglePostByid(Integer postId) {
		Post post=repoobj.findById(postId).orElseThrow(()-> new ResourceNotFound("post","id",postId));
		return this.modelmapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		User user=userrepoobj.findById(userId).orElseThrow(()->new ResourceNotFound("user","id",userId));
		List<Post> posts=repoobj.findByuser(user);
		return posts.stream().map((post)->this.modelmapper.map(post, PostDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		 Category category=catrepoobj.findById(categoryId).orElseThrow(()->new ResourceNotFound("categoryr","id",categoryId));
		List<Post> posts=repoobj.findByCategory(category);
		return posts.stream().map((post)->this.modelmapper.map(post,PostDto.class)).collect(Collectors.toList());
	}

	@Override
	public PostResponse allposts(Integer pageNumber, Integer pageSize) {
		Pageable p=PageRequest.of(pageNumber,pageSize);
		Page<Post> pagepost=this.repoobj.findAll(p);
		List<Post> allposts=pagepost.getContent();
		List<PostDto> postdtos=allposts.stream().map((post)->this.modelmapper.map(post, PostDto.class)).collect(Collectors.toList());
		PostResponse postresponse=new PostResponse();
		postresponse.setContent(postdtos);
		postresponse.setPageNumber(pagepost.getNumber());
		postresponse.setPagesize(pagepost.getSize());
		postresponse.setTotalPges(pagepost.getTotalPages());
		postresponse.setTotalElement(pagepost.getTotalElements());
		postresponse.setLastPage(pagepost.isLast());
		return postresponse;
	}

}
