package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class EntryrhyNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "entryrhy not found"; 

   public EntryrhyNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public EntryrhyNotFoundException(String message) {
           super(message);
   }

   public EntryrhyNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public EntryrhyNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
