package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class ServicesNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "services not found"; 

   public ServicesNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public ServicesNotFoundException(String message) {
           super(message);
   }

   public ServicesNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public ServicesNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
