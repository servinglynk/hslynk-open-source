package com.servinglynk.hmis.warehouse.service.exception;

public class VashExitReasoNotFoundException extends RuntimeException { 
	 
	 /* 
	 * Default exception message 
	 */ 
	   public static final String DEFAULT_MESSAGE = "exitrhy not found"; 

	   public VashExitReasoNotFoundException() {
	       super(DEFAULT_MESSAGE);
	   }
	 
	   public VashExitReasoNotFoundException(String message) {
	           super(message);
	   }

	   public VashExitReasoNotFoundException(Throwable cause) {
	           super(DEFAULT_MESSAGE, cause);
	   }

	   public VashExitReasoNotFoundException(String message, Throwable cause) {
	           super(message, cause);
	   }
}
