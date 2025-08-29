package com.blogapplication.app.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blogapplication.app.entities.Post;
import com.blogapplication.app.payload.PostDto;
import com.blogapplication.app.payload.PostResponse;
import com.blogapplication.app.payload.UserDto;
import com.blogapplication.app.services.FileServices;
import com.blogapplication.app.services.PostServices;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	PostServices postserobj;
	
//post-Create
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> creatingpost(@RequestBody PostDto postdto,@PathVariable Integer userId,@PathVariable Integer categoryId) {
		PostDto created=this.postserobj.createpost(postdto, userId, categoryId);
		return new ResponseEntity<>(created,HttpStatus.OK);
	}
//	put--update
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatingpost(@RequestBody PostDto postdto, @PathVariable Integer postId) {
		PostDto updatedpost=this.postserobj.updatePost(postdto, postId);
		return new ResponseEntity<>(updatedpost,HttpStatus.OK);
	}
//	delete--delete
	@DeleteMapping("/posts/{postId}")
	public void deletingpost(@PathVariable Integer postId) {
		this.postserobj.deletingpost(postId);
	}
//	get-All
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPosts(@RequestParam Integer pageNumber,@RequestParam Integer pageSize){
		PostResponse postdtosresponse=this.postserobj.allposts(pageNumber,pageSize);
		return new ResponseEntity<PostResponse>(postdtosresponse,HttpStatus.OK);
		
	}
//	getsinglebypotstid
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getSinglePost(@PathVariable Integer postId){
		PostDto postdto=this.postserobj.getsinglePostByid(postId);
		return new ResponseEntity<>(postdto,HttpStatus.OK);
	}
//	getbyuserId
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId){
		List<PostDto> postdtos=this.postserobj.getPostByUser(userId);
		return new ResponseEntity<>(postdtos,HttpStatus.OK);
		
	}
//	getbycategoryId
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){
		List<PostDto> postdtos=this.postserobj.getPostByCategory(categoryId);
		return new ResponseEntity<>(postdtos,HttpStatus.OK);
		
	}
	@Value("${project_image}")
	String path;
	
	@Autowired
	FileServices fileservice;
	@PostMapping("/posts/image/upload/{postId}")
	public ResponseEntity<PostDto> uploadingImg(@RequestParam("image") MultipartFile image, @PathVariable Integer postId) throws IOException{
		PostDto postdto=this.postserobj.getsinglePostByid(postId);
		String filename=this.fileservice.uploadImg(path, image);
		postdto.setImageName(filename);
		PostDto updatedpost=postserobj.updatePost(postdto, postId);
		return new ResponseEntity<>(updatedpost,HttpStatus.OK);
				
	}
	
}
