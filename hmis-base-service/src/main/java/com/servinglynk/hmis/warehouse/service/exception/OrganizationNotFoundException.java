package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class OrganizationNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 

public static final String DEFAULT_MESSAGE = "organization not found"; 

   public OrganizationNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public OrganizationNotFoundException(String message) {
           super(message);
   }

   public OrganizationNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public OrganizationNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
