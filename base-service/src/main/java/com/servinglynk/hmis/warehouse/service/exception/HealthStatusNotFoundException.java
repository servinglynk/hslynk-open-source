package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class HealthStatusNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "HealthStatus not found"; 

   public HealthStatusNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public HealthStatusNotFoundException(String message) {
           super(message);
   }

   public HealthStatusNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public HealthStatusNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
