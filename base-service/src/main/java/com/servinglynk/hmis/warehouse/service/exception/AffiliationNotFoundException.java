package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class AffiliationNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "affiliation not found"; 

   public AffiliationNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public AffiliationNotFoundException(String message) {
           super(message);
   }

   public AffiliationNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public AffiliationNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
