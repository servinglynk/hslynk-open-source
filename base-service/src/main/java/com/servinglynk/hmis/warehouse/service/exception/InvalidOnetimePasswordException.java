package com.servinglynk.hmis.warehouse.service.exception;

@SuppressWarnings("serial")
public class InvalidOnetimePasswordException extends RuntimeException {

	 /* 
	 * Default exception message 
	 */ 
	   public static final String DEFAULT_MESSAGE = "Invalid One Time Password"; 

	   public InvalidOnetimePasswordException() {
	       super(DEFAULT_MESSAGE);
	   }
	 
	   public InvalidOnetimePasswordException(String message) {
	           super(message);
	   }

	   public InvalidOnetimePasswordException(Throwable cause) {
	           super(DEFAULT_MESSAGE, cause);
	   }

	   public InvalidOnetimePasswordException(String message, Throwable cause) {
	           super(message, cause);
	   }
}