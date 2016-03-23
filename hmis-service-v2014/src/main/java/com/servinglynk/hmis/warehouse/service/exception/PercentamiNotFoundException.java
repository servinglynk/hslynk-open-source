package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class PercentamiNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "percentami not found"; 

   public PercentamiNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public PercentamiNotFoundException(String message) {
           super(message);
   }

   public PercentamiNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public PercentamiNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
