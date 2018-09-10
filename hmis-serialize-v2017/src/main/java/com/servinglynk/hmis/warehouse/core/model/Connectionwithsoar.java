package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("connectionWithSoar")
public class Connectionwithsoar extends ClientModel{


      private UUID connectionwithsoarId;
      @JsonProperty("connectionWithSoar")
      private Integer connectionwithsoar;



      public UUID getConnectionwithsoarId(){
          return connectionwithsoarId;
      }
      public void setConnectionwithsoarId(UUID connectionwithsoarId){
          this.connectionwithsoarId = connectionwithsoarId;
      }
      public Integer getConnectionwithsoar(){
          return connectionwithsoar;
      }
      public void setConnectionwithsoar(Integer connectionwithsoar){
          this.connectionwithsoar = connectionwithsoar;
      }

 }
