package com.servinglynk.hmis.warehouse.service.exception;
@SuppressWarnings("serial")
public class VashExitReasonNotFoundException extends RuntimeException { 
	 
	 /* 
	 * Default exception message 
	 */ 
	   public static final String DEFAULT_MESSAGE = "exitrhy not found"; 

	   public VashExitReasonNotFoundException() {
	       super(DEFAULT_MESSAGE);
	   }
	 
	   public VashExitReasonNotFoundException(String message) {
	           super(message);
	   }

	   public VashExitReasonNotFoundException(Throwable cause) {
	           super(DEFAULT_MESSAGE, cause);
	   }

	   public VashExitReasonNotFoundException(String message, Throwable cause) {
	           super(message, cause);
	   }
}
