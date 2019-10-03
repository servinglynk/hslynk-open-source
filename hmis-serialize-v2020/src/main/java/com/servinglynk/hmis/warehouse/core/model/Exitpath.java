package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("exitPath")
public class Exitpath extends ClientModel{

	@JsonProperty("exitPathId")
      private UUID exitpathId;

      private Integer connectionWithSoar;



      public UUID getExitpathId(){
          return exitpathId;
      }
      public void setExitpathId(UUID exitpathId){
          this.exitpathId = exitpathId;
      }
      public Integer getConnectionWithSoar(){
          return connectionWithSoar;
      }
      public void setConnectionWithSoar(Integer connectionWithSoar){
          this.connectionWithSoar = connectionWithSoar;
      }
      @JsonSerialize(using=JsonDateSerializer.class)
      @JsonDeserialize(using=JsonDateDeserializer.class)
  	 LocalDateTime submissionDate;

       public LocalDateTime getSubmissionDate() {
 		return submissionDate;
 	}
 	public void setSubmissionDate(LocalDateTime submissionDate) {
 		this.submissionDate = submissionDate;
 	}
 	
 }
