package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("sexualorientation")
public class Sexualorientation extends ClientModel{


      private UUID sexualorientationId;

      private Integer sexualorientation;



      public UUID getSexualorientationId(){
          return sexualorientationId;
      }
      public void setSexualorientationId(UUID sexualorientationId){
          this.sexualorientationId = sexualorientationId;
      }
      public Integer getSexualorientation(){
          return sexualorientation;
      }
      public void setSexualorientation(Integer sexualorientation){
          this.sexualorientation = sexualorientation;
      }

 }
