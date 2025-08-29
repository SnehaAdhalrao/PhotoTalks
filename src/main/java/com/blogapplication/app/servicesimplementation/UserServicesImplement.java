package com.blogapplication.app.servicesimplementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blogapplication.app.entities.User;
import com.blogapplication.app.exceptions.ResourceNotFound;
import com.blogapplication.app.payload.UserDto;
import com.blogapplication.app.repositories.UserRepo;
import com.blogapplication.app.services.UserServices;
@Service
public class UserServicesImplement implements UserServices {

	@Autowired
	UserRepo usr;
	  
	 PasswordEncoder passwordEncoder;
	@Autowired
	ModelMapper modelmapper;
	
	@Override
	public UserDto createUser(UserDto userdto) {
//		User creation
		User createduser=this.dtoToUser(userdto);
		createduser.setPassword(passwordEncoder.encode(userdto.getPassword()));
		this.usr.save(createduser);
		return this.userToDto(createduser);
	}
	
	@Override
	public UserDto updateUser(UserDto userdto, Integer user_id) {
		// TODO Auto-generated method stub
		
		User u=this.usr.findById(user_id).orElseThrow(() -> new ResourceNotFound("user","id",user_id));
		u.setAbout(userdto.getAbout());
		u.setEmail(userdto.getEmail());
		u.setName(userdto.getName());
		u.setPassword(userdto.getPassword());
		usr.save(u);
		return this.userToDto(u);
	}
	@Override
	public UserDto getById(Integer user_id) {
		// TODO Auto-generated method stub
		User u=this.usr.findById(user_id).orElseThrow(() -> new ResourceNotFound("user","id",user_id));
		
		return this.userToDto(u);
	}
	@Override
	public List<UserDto> getAll() {
		List<User>users=usr.findAll();
		List<UserDto> userdtos=users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		// TODO Auto-generated method stub
		return userdtos;
	}
	@Override
	public void deleteUser(Integer user_id) {
		
		this.usr.deleteById(user_id);
		// TODO Auto-generated method stub
		
	}
	public User dtoToUser(UserDto userdto) {
//		User u=new User();
//		u.setId(userdto.getId()); 
//		u.setName(userdto.getName());
//		u.setEmail(userdto.getEmail());
//		u.setPassword(userdto.getPassword());
//		u.setAbout(userdto.getAbout());
		User user=this.modelmapper.map(userdto, User.class);
		return user;
		
	}
	public UserDto userToDto(User user) {
		UserDto userdto=this.modelmapper.map(user, UserDto.class);
		return userdto;
		
	}

	

}
