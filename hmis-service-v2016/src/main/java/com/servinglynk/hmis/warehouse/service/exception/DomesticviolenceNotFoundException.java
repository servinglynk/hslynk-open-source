package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class DomesticviolenceNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "domesticviolence not found"; 

   public DomesticviolenceNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public DomesticviolenceNotFoundException(String message) {
           super(message);
   }

   public DomesticviolenceNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public DomesticviolenceNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
