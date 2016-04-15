package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("employment")
public class Employment extends ClientModel{


      private UUID employmentId;

      @JsonSerialize(using=JsonDateSerializer.class)
      @JsonDeserialize(using=JsonDateDeserializer.class)
      private LocalDateTime informationDate;

      private Integer employed;

      private Integer employmentType;

      private Integer notEmployedReason;



      public UUID getEmploymentId(){
          return employmentId;
      }
      public void setEmploymentId(UUID employmentId){
          this.employmentId = employmentId;
      }
      public LocalDateTime getInformationDate(){
          return informationDate;
      }
      public void setInformationDate(LocalDateTime informationDate){
          this.informationDate = informationDate;
      }
      public Integer getEmployed(){
          return employed;
      }
      public void setEmployed(Integer employed){
          this.employed = employed;
      }
      public Integer getEmploymentType(){
          return employmentType;
      }
      public void setEmploymentType(Integer employmentType){
          this.employmentType = employmentType;
      }
      public Integer getNotEmployedReason(){
          return notEmployedReason;
      }
      public void setNotEmployedReason(Integer notEmployedReason){
          this.notEmployedReason = notEmployedReason;
      }

 }
