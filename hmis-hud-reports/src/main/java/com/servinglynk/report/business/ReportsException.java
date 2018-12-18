package com.servinglynk.report.business;

public class ReportsException extends Exception {

		 /* 
		 * Default exception message 
		 */ 
		   public static final String DEFAULT_MESSAGE = "Requested resource not found"; 

		   public ReportsException() {
		       super(DEFAULT_MESSAGE);
		   }
		 
		   public ReportsException(String message) {
		           super(message);
		   }

		   public ReportsException(Throwable cause) {
		           super(DEFAULT_MESSAGE, cause);
		   }

		   public ReportsException(String message, Throwable cause) {
		           super(message, cause);
		   }
}
