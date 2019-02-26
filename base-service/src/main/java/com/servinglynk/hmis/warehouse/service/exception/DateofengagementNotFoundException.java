package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class DateofengagementNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "dateofengagement not found"; 

   public DateofengagementNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public DateofengagementNotFoundException(String message) {
           super(message);
   }

   public DateofengagementNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public DateofengagementNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
