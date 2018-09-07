package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("projectcoc")
public class Projectcoc extends ClientModel{


      private UUID projectcocId;
      @JsonProperty("cocCode")
      private String coccode;
      
      private String sourceSystemId;



      public UUID getProjectcocId(){
          return projectcocId;
      }
      public void setProjectcocId(UUID projectcocId){
          this.projectcocId = projectcocId;
      }
      public String getCoccode(){
          return coccode;
      }
      public void setCoccode(String coccode){
          this.coccode = coccode;
      }
	public String getSourceSystemId() {
		return sourceSystemId;
	}
	public void setSourceSystemId(String sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
	}
      

 }
