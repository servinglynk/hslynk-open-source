package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class FamilyReunificationNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 

public static final String DEFAULT_MESSAGE = "familyReunification not found"; 

   public FamilyReunificationNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public FamilyReunificationNotFoundException(String message) {
           super(message);
   }

   public FamilyReunificationNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public FamilyReunificationNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
