package com.blogapplication.app.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileServices {
	String uploadImg(String path,MultipartFile file) throws IOException;
	

}
