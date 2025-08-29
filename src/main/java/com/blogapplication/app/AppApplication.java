package com.blogapplication.app;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.blogapplication.app", "com.blogapplication.app"})
public class AppApplication {
	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
		
	}

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
		
		
	}
	

}
