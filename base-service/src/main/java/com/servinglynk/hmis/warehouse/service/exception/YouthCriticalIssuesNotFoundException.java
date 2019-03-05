package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class YouthCriticalIssuesNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "youthCriticalIssues not found"; 

   public YouthCriticalIssuesNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public YouthCriticalIssuesNotFoundException(String message) {
           super(message);
   }

   public YouthCriticalIssuesNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public YouthCriticalIssuesNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
