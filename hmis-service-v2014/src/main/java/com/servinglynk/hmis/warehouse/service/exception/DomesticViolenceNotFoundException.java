package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class DomesticViolenceNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "domesticViolence not found"; 

   public DomesticViolenceNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public DomesticViolenceNotFoundException(String message) {
           super(message);
   }

   public DomesticViolenceNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public DomesticViolenceNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
