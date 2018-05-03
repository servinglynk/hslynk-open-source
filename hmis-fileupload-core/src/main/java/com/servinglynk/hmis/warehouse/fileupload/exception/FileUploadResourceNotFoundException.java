package com.servinglynk.hmis.warehouse.fileupload.exception;

public class FileUploadResourceNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 7992904489585842099L;
	
	public FileUploadResourceNotFoundException() {
		this("Resource not found!");
	}

	public FileUploadResourceNotFoundException(String message) {
		this(message, null);
	}

	public FileUploadResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
