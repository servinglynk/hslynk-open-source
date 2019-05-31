package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class WorstHousingSituationNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "worstHousingSituation not found"; 

   public WorstHousingSituationNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public WorstHousingSituationNotFoundException(String message) {
           super(message);
   }

   public WorstHousingSituationNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public WorstHousingSituationNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
