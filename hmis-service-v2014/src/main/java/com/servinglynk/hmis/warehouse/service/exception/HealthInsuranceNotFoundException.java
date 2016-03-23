package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class HealthInsuranceNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "healthInsurance not found"; 

   public HealthInsuranceNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public HealthInsuranceNotFoundException(String message) {
           super(message);
   }

   public HealthInsuranceNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public HealthInsuranceNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
