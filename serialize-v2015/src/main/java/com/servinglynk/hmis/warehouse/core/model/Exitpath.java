package com.servinglynk.hmis.warehouse.core.model; 

import java.util.Date;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("exitpath")
public class Exitpath extends ClientModel{


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

 }
