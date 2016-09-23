package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class EntryssvfNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "entryssvf not found"; 

   public EntryssvfNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public EntryssvfNotFoundException(String message) {
           super(message);
   }

   public EntryssvfNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public EntryssvfNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
