package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class ExitpathNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "exitpath not found"; 

   public ExitpathNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public ExitpathNotFoundException(String message) {
           super(message);
   }

   public ExitpathNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public ExitpathNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
