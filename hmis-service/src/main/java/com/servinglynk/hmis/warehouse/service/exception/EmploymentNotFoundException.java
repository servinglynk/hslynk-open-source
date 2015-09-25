package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class EmploymentNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 

public static final String DEFAULT_MESSAGE = "employment not found"; 

   public EmploymentNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public EmploymentNotFoundException(String message) {
           super(message);
   }

   public EmploymentNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public EmploymentNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
