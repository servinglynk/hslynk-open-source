package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("disabilities")
public class Disabilities extends ClientModel{


      private UUID disabilitiesId;

      private Integer disabilityresponse;

      private String disabilitytype;

      private String documentationonfile;

      private String indefiniteandimpairs;

      private String pathhowconfirmed;

      private String receivingservices;

      private String pathsmiinformation;



      public UUID getDisabilitiesId(){
          return disabilitiesId;
      }
      public void setDisabilitiesId(UUID disabilitiesId){
          this.disabilitiesId = disabilitiesId;
      }
      public Integer getDisabilityresponse(){
          return disabilityresponse;
      }
      public void setDisabilityresponse(Integer disabilityresponse){
          this.disabilityresponse = disabilityresponse;
      }
      public String getDisabilitytype(){
          return disabilitytype;
      }
      public void setDisabilitytype(String disabilitytype){
          this.disabilitytype = disabilitytype;
      }
      public String getDocumentationonfile(){
          return documentationonfile;
      }
      public void setDocumentationonfile(String documentationonfile){
          this.documentationonfile = documentationonfile;
      }
      public String getIndefiniteandimpairs(){
          return indefiniteandimpairs;
      }
      public void setIndefiniteandimpairs(String indefiniteandimpairs){
          this.indefiniteandimpairs = indefiniteandimpairs;
      }
      public String getPathhowconfirmed(){
          return pathhowconfirmed;
      }
      public void setPathhowconfirmed(String pathhowconfirmed){
          this.pathhowconfirmed = pathhowconfirmed;
      }
      public String getReceivingservices(){
          return receivingservices;
      }
      public void setReceivingservices(String receivingservices){
          this.receivingservices = receivingservices;
      }
      public String getPathsmiinformation(){
          return pathsmiinformation;
      }
      public void setPathsmiinformation(String pathsmiinformation){
          this.pathsmiinformation = pathsmiinformation;
      }

 }
