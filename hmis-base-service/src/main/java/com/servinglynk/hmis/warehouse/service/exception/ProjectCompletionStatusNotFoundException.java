package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class ProjectCompletionStatusNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 

public static final String DEFAULT_MESSAGE = "projectCompletionStatus not found"; 

   public ProjectCompletionStatusNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public ProjectCompletionStatusNotFoundException(String message) {
           super(message);
   }

   public ProjectCompletionStatusNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public ProjectCompletionStatusNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
