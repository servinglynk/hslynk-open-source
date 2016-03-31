package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("enrollmentCoc")
public class EnrollmentCoc extends ClientModel{


      private UUID enrollmentCocId;

      private LocalDateTime informationDate;

      private String clientCode;



      public UUID getEnrollmentCocId(){
          return enrollmentCocId;
      }
      public void setEnrollmentCocId(UUID enrollmentCocId){
          this.enrollmentCocId = enrollmentCocId;
      }
      public LocalDateTime getInformationDate(){
          return informationDate;
      }
      public void setInformationDate(LocalDateTime informationDate){
          this.informationDate = informationDate;
      }
      public String getClientCode(){
          return clientCode;
      }
      public void setClientCode(String clientCode){
          this.clientCode = clientCode;
      }

 }
