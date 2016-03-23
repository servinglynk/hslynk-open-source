package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class FormerWardChildWelfareNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "formerWardChildWelfare not found"; 

   public FormerWardChildWelfareNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public FormerWardChildWelfareNotFoundException(String message) {
           super(message);
   }

   public FormerWardChildWelfareNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public FormerWardChildWelfareNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
