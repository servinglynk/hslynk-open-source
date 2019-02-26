package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class RhybcpstatusNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "rhybcpstatus not found"; 

   public RhybcpstatusNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public RhybcpstatusNotFoundException(String message) {
           super(message);
   }

   public RhybcpstatusNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public RhybcpstatusNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
