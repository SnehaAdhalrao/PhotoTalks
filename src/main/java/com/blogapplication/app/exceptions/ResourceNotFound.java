package com.blogapplication.app.exceptions;

public class ResourceNotFound extends RuntimeException{
	String resourcefield;
	String fieldname;
	long fieldvalue;
	public ResourceNotFound(String resourcefield, String fieldname, long fieldvalue) {
		super(String.format("%s not found with %s=%s",resourcefield,fieldname,fieldvalue));
		this.resourcefield = resourcefield;
		this.fieldname = fieldname;
		this.fieldvalue = fieldvalue;
	}

}
