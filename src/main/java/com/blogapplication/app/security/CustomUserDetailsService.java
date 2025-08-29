package com.blogapplication.app.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.blogapplication.app.entities.User;
import com.blogapplication.app.repositories.UserRepo;


@Service
@Component
public class CustomUserDetailsService implements UserDetailsService {

	
	@Autowired
	UserRepo userrepoobj;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=this.userrepoobj.findByEmail(username).orElseThrow();
		return user;
	}

}
