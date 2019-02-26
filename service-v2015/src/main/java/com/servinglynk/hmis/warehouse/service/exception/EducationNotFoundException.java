package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class EducationNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "education not found"; 

   public EducationNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public EducationNotFoundException(String message) {
           super(message);
   }

   public EducationNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public EducationNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
