package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class SiteNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "site not found"; 

   public SiteNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public SiteNotFoundException(String message) {
           super(message);
   }

   public SiteNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public SiteNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
