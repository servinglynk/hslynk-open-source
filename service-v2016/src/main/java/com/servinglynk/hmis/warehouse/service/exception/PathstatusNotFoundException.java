package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class PathstatusNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "pathstatus not found"; 

   public PathstatusNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public PathstatusNotFoundException(String message) {
           super(message);
   }

   public PathstatusNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public PathstatusNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
