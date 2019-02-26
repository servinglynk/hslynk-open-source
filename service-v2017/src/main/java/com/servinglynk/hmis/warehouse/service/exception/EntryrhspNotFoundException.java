package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class EntryrhspNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "entryrhsp not found"; 

   public EntryrhspNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public EntryrhspNotFoundException(String message) {
           super(message);
   }

   public EntryrhspNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public EntryrhspNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
