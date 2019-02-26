package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class NonCashBenefitNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "nonCashBenefit not found"; 

   public NonCashBenefitNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public NonCashBenefitNotFoundException(String message) {
           super(message);
   }

   public NonCashBenefitNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public NonCashBenefitNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
