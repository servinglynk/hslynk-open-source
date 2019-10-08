package com.servinglynk.hmis.warehouse.service.exception; 
 
@SuppressWarnings("serial")
public class AssessmentResultsNotFoundException extends RuntimeException { 
 
 /* 
 * Default exception message 
 */ 
   public static final String DEFAULT_MESSAGE = "Assessment Result not found"; 

   public AssessmentResultsNotFoundException() {
       super(DEFAULT_MESSAGE);
   }
 
   public AssessmentResultsNotFoundException(String message) {
           super(message);
   }

   public AssessmentResultsNotFoundException(Throwable cause) {
           super(DEFAULT_MESSAGE, cause);
   }

   public AssessmentResultsNotFoundException(String message, Throwable cause) {
           super(message, cause);
   }

}
