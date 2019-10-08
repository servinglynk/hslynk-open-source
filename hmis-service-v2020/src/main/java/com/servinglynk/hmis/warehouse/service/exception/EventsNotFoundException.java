package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class EventsNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "Event not found"; 

   public EventsNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public EventsNotFoundException(String message) {
           super(message);
   }

   public EventsNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public EventsNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
