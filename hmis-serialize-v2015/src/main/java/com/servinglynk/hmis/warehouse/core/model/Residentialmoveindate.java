package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("residentialmoveindate")
public class Residentialmoveindate extends ClientModel{


      private UUID residentialmoveindateId;

      private Integer inpermanenthousing;

      private LocalDateTime residentialmoveindate;



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
      public LocalDateTime getResidentialmoveindate(){
          return residentialmoveindate;
      }
      public void setResidentialmoveindate(LocalDateTime residentialmoveindate){
          this.residentialmoveindate = residentialmoveindate;
      }

 }
