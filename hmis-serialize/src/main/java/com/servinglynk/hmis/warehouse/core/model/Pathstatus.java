package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("pathstatus")
public class Pathstatus extends ClientModel{


      private UUID pathstatusId;

      private Long clientenrolledinpath;



      public UUID getPathstatusId(){
          return pathstatusId;
      }
      public void setPathstatusId(UUID pathstatusId){
          this.pathstatusId = pathstatusId;
      }
      public Long getClientenrolledinpath(){
          return clientenrolledinpath;
      }
      public void setClientenrolledinpath(Long clientenrolledinpath){
          this.clientenrolledinpath = clientenrolledinpath;
      }

 }
