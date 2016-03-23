package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class LastPermanentAddressNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "lastPermanentAddress not found"; 

   public LastPermanentAddressNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public LastPermanentAddressNotFoundException(String message) {
           super(message);
   }

   public LastPermanentAddressNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public LastPermanentAddressNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
