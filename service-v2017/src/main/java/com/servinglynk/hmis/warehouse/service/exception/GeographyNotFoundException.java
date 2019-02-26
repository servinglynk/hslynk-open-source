package com.servinglynk.hmis.warehouse.service.exception;
@SuppressWarnings("serial")
public class GeographyNotFoundException extends RuntimeException { 
	 
	 /* 
	 * Default exception message 
	 */ 
	   public static final String DEFAULT_MESSAGE = "exitrhy not found"; 

	   public GeographyNotFoundException() {
	       super(DEFAULT_MESSAGE);
	   }
	 
	   public GeographyNotFoundException(String message) {
	           super(message);
	   }

	   public GeographyNotFoundException(Throwable cause) {
	           super(DEFAULT_MESSAGE, cause);
	   }

	   public GeographyNotFoundException(String message, Throwable cause) {
	           super(message, cause);
	   }
}
