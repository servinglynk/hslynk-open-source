package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class FunderNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "funder not found"; 

   public FunderNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public FunderNotFoundException(String message) {
           super(message);
   }

   public FunderNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public FunderNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
