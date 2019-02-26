package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class ServicefareferralNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "servicefareferral not found"; 

   public ServicefareferralNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public ServicefareferralNotFoundException(String message) {
           super(message);
   }

   public ServicefareferralNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public ServicefareferralNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
