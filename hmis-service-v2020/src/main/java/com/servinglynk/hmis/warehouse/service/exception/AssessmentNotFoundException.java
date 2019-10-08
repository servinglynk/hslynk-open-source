package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class AssessmentNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "Assessment not found"; 

   public AssessmentNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public AssessmentNotFoundException(String message) {
           super(message);
   }

   public AssessmentNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public AssessmentNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
