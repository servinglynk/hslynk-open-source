package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class ExithousingassessmentNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "exithousingassessment not found"; 

   public ExithousingassessmentNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public ExithousingassessmentNotFoundException(String message) {
           super(message);
   }

   public ExithousingassessmentNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public ExithousingassessmentNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
