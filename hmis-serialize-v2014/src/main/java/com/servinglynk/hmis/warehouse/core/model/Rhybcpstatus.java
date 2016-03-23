package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("rhybcpstatus")
public class Rhybcpstatus extends ClientModel{


      private UUID rhybcpstatusId;

  	  @JsonSerialize(using = LocalDateTimeSerializer.class)
  	  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      private LocalDateTime statusDate;



      public UUID getRhybcpstatusId(){
          return rhybcpstatusId;
      }
      public void setRhybcpstatusId(UUID rhybcpstatusId){
          this.rhybcpstatusId = rhybcpstatusId;
      }
      public LocalDateTime getStatusDate(){
          return statusDate;
      }
      public void setStatusDate(LocalDateTime statusDate){
          this.statusDate = statusDate;
      }

 }
