package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class ConnectionwithsoarNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "connectionwithsoar not found"; 

   public ConnectionwithsoarNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public ConnectionwithsoarNotFoundException(String message) {
           super(message);
   }

   public ConnectionwithsoarNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public ConnectionwithsoarNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
