package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class HealthinsuranceNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "healthinsurance not found"; 

   public HealthinsuranceNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public HealthinsuranceNotFoundException(String message) {
           super(message);
   }

   public HealthinsuranceNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public HealthinsuranceNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
