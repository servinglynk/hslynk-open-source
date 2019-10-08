package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class CurrentLivingSituationNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "Current Living Situation not found"; 

   public CurrentLivingSituationNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public CurrentLivingSituationNotFoundException(String message) {
           super(message);
   }

   public CurrentLivingSituationNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public CurrentLivingSituationNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
