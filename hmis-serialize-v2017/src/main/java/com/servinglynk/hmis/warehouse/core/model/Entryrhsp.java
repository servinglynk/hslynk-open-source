package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("entryRhsp")
public class Entryrhsp extends ClientModel{


      private UUID entryrhspId;

      private Integer worstHousingSituation;



      public UUID getEntryrhspId(){
          return entryrhspId;
      }
      public void setEntryrhspId(UUID entryrhspId){
          this.entryrhspId = entryrhspId;
      }
      public Integer getWorstHousingSituation(){
          return worstHousingSituation;
      }
      public void setWorstHousingSituation(Integer worstHousingSituation){
          this.worstHousingSituation = worstHousingSituation;
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
