package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class CocNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "projectcoc not found"; 

   public CocNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public CocNotFoundException(String message) {
           super(message);
   }

   public CocNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public CocNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
