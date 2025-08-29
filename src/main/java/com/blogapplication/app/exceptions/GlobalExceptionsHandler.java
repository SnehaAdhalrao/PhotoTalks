package com.blogapplication.app.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blogapplication.app.responses.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionsHandler {
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ApiResponse> ResourceNhi(ResourceNotFound ex){
		String msg= ex.getMessage();
		ApiResponse apiresponse= new ApiResponse(msg,false);
		return new ResponseEntity<ApiResponse>(apiresponse,HttpStatus.NOT_FOUND);
	}

//	++++++++++++++++++++++++++++++++++++++++the inbuilt MethodArgumentNotValiException
	public ResponseEntity<Map<String,String>> handlemethodargsnotfound(MethodArgumentNotValidException ex){
		Map<String,String> map=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error->{
			String fieldname=((FieldError) error).getField();
			String msg=error.getDefaultMessage();
			map.put(fieldname, msg);
		});
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
	}
	
}
