package com.blogapplication.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.blogapplication.app.payload.UserDto;

public interface UserServices {
	UserDto createUser(UserDto userdto);
	UserDto updateUser(UserDto userdto,Integer user_id);
	UserDto getById(Integer user_id);
	List<UserDto> getAll();
	void deleteUser(Integer user_id);
	
	

}
