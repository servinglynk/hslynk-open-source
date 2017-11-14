package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class ExitNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 

public static final String DEFAULT_MESSAGE = "exit not found"; 

   public ExitNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public ExitNotFoundException(String message) {
           super(message);
   }

   public ExitNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public ExitNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
