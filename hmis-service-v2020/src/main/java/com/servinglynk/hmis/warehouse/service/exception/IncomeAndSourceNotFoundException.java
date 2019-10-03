package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class IncomeAndSourceNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "incomeAndSource not found"; 

   public IncomeAndSourceNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public IncomeAndSourceNotFoundException(String message) {
           super(message);
   }

   public IncomeAndSourceNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public IncomeAndSourceNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
