package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class ExitrhyNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "exitrhy not found"; 

   public ExitrhyNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public ExitrhyNotFoundException(String message) {
           super(message);
   }

   public ExitrhyNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public ExitrhyNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
