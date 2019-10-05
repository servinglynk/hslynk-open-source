package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class ResidentialmoveindateNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "residentialmoveindate not found"; 

   public ResidentialmoveindateNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public ResidentialmoveindateNotFoundException(String message) {
           super(message);
   }

   public ResidentialmoveindateNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public ResidentialmoveindateNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
