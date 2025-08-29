package com.blogapplication.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapplication.app.entities.Category;
import com.blogapplication.app.entities.Post;
import com.blogapplication.app.entities.User;
import com.blogapplication.app.payload.CategoryDto;
import com.blogapplication.app.payload.PostDto;
import com.blogapplication.app.payload.UserDto;

public interface PostRepo extends JpaRepository<Post,Integer> {
//	these are the custom(usermade) methods which is not i the jparepo so we declared here;
//	*****************spring jpa automatically creates the fnuctionoimplementation by name convention and always return only an entity
	List<Post> findByCategory(Category category);
	List<Post> findByuser(User user);

}
