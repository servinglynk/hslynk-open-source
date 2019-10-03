package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class HealthstatusNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "healthstatus not found"; 

   public HealthstatusNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public HealthstatusNotFoundException(String message) {
           super(message);
   }

   public HealthstatusNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public HealthstatusNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
