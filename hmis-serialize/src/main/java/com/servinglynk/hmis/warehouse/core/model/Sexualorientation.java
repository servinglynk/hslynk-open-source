package com.servinglynk.hmis.warehouse.core.model; 

import java.util.Date;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("sexualorientation")
public class Sexualorientation extends ClientModel{


      private UUID sexualorientationId;

      private String sexualorientation;



      public UUID getSexualorientationId(){
          return sexualorientationId;
      }
      public void setSexualorientationId(UUID sexualorientationId){
          this.sexualorientationId = sexualorientationId;
      }
      public String getSexualorientation(){
          return sexualorientation;
      }
      public void setSexualorientation(String sexualorientation){
          this.sexualorientation = sexualorientation;
      }

 }
