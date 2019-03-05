package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class InventoryNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "inventory not found"; 

   public InventoryNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public InventoryNotFoundException(String message) {
           super(message);
   }

   public InventoryNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public InventoryNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
