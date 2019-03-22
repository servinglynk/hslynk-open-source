package com.servinglynk.hmis.warehouse.service.exception;

public class ResourceNotFound extends RuntimeException { 

	private static final long serialVersionUID = 1L;

	public static final String DEFAULT_MESSAGE = "Request resource not found"; 

	   public ResourceNotFound() {
	       super(DEFAULT_MESSAGE);
	   }
	 
	   public ResourceNotFound(String message) {
	           super(message);
	   }

	   public ResourceNotFound(Throwable cause) {
	           super(DEFAULT_MESSAGE, cause);
	   }

	   public ResourceNotFound(String message, Throwable cause) {
	           super(message, cause);
	   }
}