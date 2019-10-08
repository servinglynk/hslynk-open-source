package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class AssessmentQuestionsNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "Assessment Question not found"; 

   public AssessmentQuestionsNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public AssessmentQuestionsNotFoundException(String message) {
           super(message);
   }

   public AssessmentQuestionsNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public AssessmentQuestionsNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
