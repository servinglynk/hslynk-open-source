package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class EnrollmentCocNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "enrollmentCoc not found"; 

   public EnrollmentCocNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public EnrollmentCocNotFoundException(String message) {
           super(message);
   }

   public EnrollmentCocNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public EnrollmentCocNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
