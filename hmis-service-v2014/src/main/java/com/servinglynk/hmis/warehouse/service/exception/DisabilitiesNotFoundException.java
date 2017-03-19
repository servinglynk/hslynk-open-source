package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class DisabilitiesNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "disabilities not found"; 

   public DisabilitiesNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public DisabilitiesNotFoundException(String message) {
           super(message);
   }

   public DisabilitiesNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public DisabilitiesNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
