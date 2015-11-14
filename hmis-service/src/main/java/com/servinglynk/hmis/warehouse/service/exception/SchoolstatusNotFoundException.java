package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class SchoolstatusNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "schoolstatus not found"; 

   public SchoolstatusNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public SchoolstatusNotFoundException(String message) {
           super(message);
   }

   public SchoolstatusNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public SchoolstatusNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
