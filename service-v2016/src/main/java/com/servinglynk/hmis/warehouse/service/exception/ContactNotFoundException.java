package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class ContactNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "contact not found"; 

   public ContactNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public ContactNotFoundException(String message) {
           super(message);
   }

   public ContactNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public ContactNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
