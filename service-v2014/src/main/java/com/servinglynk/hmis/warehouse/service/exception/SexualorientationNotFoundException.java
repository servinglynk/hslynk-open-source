package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class SexualorientationNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "sexualorientation not found"; 

   public SexualorientationNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public SexualorientationNotFoundException(String message) {
           super(message);
   }

   public SexualorientationNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public SexualorientationNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
