package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("residentialmoveindate")
public class Residentialmoveindate extends ClientModel{


      private UUID residentialmoveindateId;

      private String inpermanenthousing;



      public UUID getResidentialmoveindateId(){
          return residentialmoveindateId;
      }
      public void setResidentialmoveindateId(UUID residentialmoveindateId){
          this.residentialmoveindateId = residentialmoveindateId;
      }
      public String getInpermanenthousing(){
          return inpermanenthousing;
      }
      public void setInpermanenthousing(String inpermanenthousing){
          this.inpermanenthousing = inpermanenthousing;
      }

 }
