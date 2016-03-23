package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class VeteranInfoNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "veteranInfo not found"; 

   public VeteranInfoNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public VeteranInfoNotFoundException(String message) {
           super(message);
   }

   public VeteranInfoNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public VeteranInfoNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
