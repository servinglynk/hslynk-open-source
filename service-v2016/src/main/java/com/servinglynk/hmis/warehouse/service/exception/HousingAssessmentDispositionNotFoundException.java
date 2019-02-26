package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class HousingAssessmentDispositionNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 

public static final String DEFAULT_MESSAGE = "housingAssessmentDisposition not found"; 

   public HousingAssessmentDispositionNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public HousingAssessmentDispositionNotFoundException(String message) {
           super(message);
   }

   public HousingAssessmentDispositionNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public HousingAssessmentDispositionNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
