package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class MedicalassistanceNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "medicalassistance not found"; 

   public MedicalassistanceNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public MedicalassistanceNotFoundException(String message) {
           super(message);
   }

   public MedicalassistanceNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public MedicalassistanceNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
