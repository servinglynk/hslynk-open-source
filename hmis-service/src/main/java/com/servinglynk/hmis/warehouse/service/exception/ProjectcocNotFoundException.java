package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class ProjectcocNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "projectcoc not found"; 

   public ProjectcocNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public ProjectcocNotFoundException(String message) {
           super(message);
   }

   public ProjectcocNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public ProjectcocNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
