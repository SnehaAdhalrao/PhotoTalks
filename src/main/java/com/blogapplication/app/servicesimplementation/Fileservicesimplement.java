package com.blogapplication.app.servicesimplementation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blogapplication.app.services.FileServices;

@Service
public class Fileservicesimplement implements FileServices {

	@Override
	public String uploadImg(String path, MultipartFile file) throws IOException {
		//create original name file
		
		String name=file.getOriginalFilename();
		
		String randomId =UUID.randomUUID().toString();
		String filename=randomId.concat(name.substring(name.lastIndexOf(".")));
		
		
		
		String filepath=path + File.separator +filename;
		
		//if folder exist
		File f=new File(path);
		if(!f.exists()) {
			f.mkdir();
		}
		
		//filecopy
		Files.copy(file.getInputStream(), Paths.get(filepath));
		return filename;
	}

}
