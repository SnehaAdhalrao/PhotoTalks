package com.blogapplication.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
 
import com.blogapplication.app.entities.User;
import com.blogapplication.app.security.CustomUserDetailsService;

@Configuration
public class AppConfig {
	
	@Autowired
	CustomUserDetailsService customuserdetailservice;
	@Bean
    public UserDetailsService userDetailsService() {
//        UserDetails userDetails = User.builder().
//                username("Sneha")
//                .password(passwordEncoder().encode("Sneha")).roles("ADMIN").
//                build();
//        return new InMemoryUserDetailsManager(userDetails);
    return customuserdetailservice;
	}

    @SuppressWarnings("deprecation")
	@Bean
    public PasswordEncoder passwordEncoder() {
         return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }

}
