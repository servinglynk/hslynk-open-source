package com.servinglynk.hmis.warehouse.fileupload.exception;

public class FileUploadException extends RuntimeException{
	
private static final long serialVersionUID = 7992904489585942599L;
	
	public FileUploadException() {
		this("Unable to Process File Upload");
	}

	public FileUploadException(String message) {
		this(message, null);
	}

	public FileUploadException(String message, Throwable cause) {
		super(message, cause);
	}

}
