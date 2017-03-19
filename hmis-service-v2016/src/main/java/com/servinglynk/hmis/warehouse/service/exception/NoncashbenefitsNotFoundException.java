package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class NoncashbenefitsNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "noncashbenefits not found"; 

   public NoncashbenefitsNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public NoncashbenefitsNotFoundException(String message) {
           super(message);
   }

   public NoncashbenefitsNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public NoncashbenefitsNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
