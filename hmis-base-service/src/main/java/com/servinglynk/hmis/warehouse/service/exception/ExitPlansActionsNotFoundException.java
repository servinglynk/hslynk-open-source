package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class ExitPlansActionsNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "exitPlansActions not found"; 

   public ExitPlansActionsNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public ExitPlansActionsNotFoundException(String message) {
           super(message);
   }

   public ExitPlansActionsNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public ExitPlansActionsNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
