package com.servinglynk.hmis.warehouse.service.exception;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException {

	 /* 
	 * Default exception message 
	 */ 
	   public static final String DEFAULT_MESSAGE = "Requested resource not found"; 

	   public ResourceNotFoundException() {
	       super(DEFAULT_MESSAGE);
	   }
	 
	   public ResourceNotFoundException(String message) {
	           super(message);
	   }

	   public ResourceNotFoundException(Throwable cause) {
	           super(DEFAULT_MESSAGE, cause);
	   }

	   public ResourceNotFoundException(String message, Throwable cause) {
	           super(message, cause);
	   }
}