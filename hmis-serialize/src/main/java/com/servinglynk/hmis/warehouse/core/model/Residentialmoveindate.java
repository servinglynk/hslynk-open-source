package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("residentialmoveindate")
public class Residentialmoveindate extends ClientModel{


      private UUID residentialmoveindateId;

      private Integer inpermanenthousing;



      public UUID getResidentialmoveindateId(){
          return residentialmoveindateId;
      }
      public void setResidentialmoveindateId(UUID residentialmoveindateId){
          this.residentialmoveindateId = residentialmoveindateId;
      }
      public Integer getInpermanenthousing(){
          return inpermanenthousing;
      }
      public void setInpermanenthousing(Integer inpermanenthousing){
          this.inpermanenthousing = inpermanenthousing;
      }

 }
