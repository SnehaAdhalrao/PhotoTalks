package com.blogapplication.app.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
	
	private String message;
	private boolean status;
	public ApiResponse(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}

}
