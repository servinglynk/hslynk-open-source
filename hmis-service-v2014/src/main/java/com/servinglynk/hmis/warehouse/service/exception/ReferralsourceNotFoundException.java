package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class ReferralsourceNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "referralsource not found"; 

   public ReferralsourceNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public ReferralsourceNotFoundException(String message) {
           super(message);
   }

   public ReferralsourceNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public ReferralsourceNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
