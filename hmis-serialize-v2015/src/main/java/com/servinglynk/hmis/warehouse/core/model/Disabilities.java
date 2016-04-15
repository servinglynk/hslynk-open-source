package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("disabilities")
public class Disabilities extends ClientModel{


      private UUID disabilitiesId;

      @JsonSerialize(using=JsonDateSerializer.class)
      @JsonDeserialize(using=JsonDateDeserializer.class)
      private LocalDateTime informationDate;

      private Integer disabilitytype;

      private Integer disabilityresponse;

      private Integer indefiniteandimpairs;

      private Integer documentationonfile;

      private Integer receivingservices;

      private Integer pathhowconfirmed;

      private Integer pathsmiinformation;

      private Integer tcellcountavailable;

      private Integer tcellcount;

      private String tcellcountsource;

      private Integer viralLoadAvailable;

      private Integer viralLoad;

      private String viralLoadSource;



      public UUID getDisabilitiesId(){
          return disabilitiesId;
      }
      public void setDisabilitiesId(UUID disabilitiesId){
          this.disabilitiesId = disabilitiesId;
      }
      public LocalDateTime getInformationDate(){
          return informationDate;
      }
      public void setInformationDate(LocalDateTime informationDate){
          this.informationDate = informationDate;
      }
      public Integer getDisabilitytype(){
          return disabilitytype;
      }
      public void setDisabilitytype(Integer disabilitytype){
          this.disabilitytype = disabilitytype;
      }
      public Integer getDisabilityresponse(){
          return disabilityresponse;
      }
      public void setDisabilityresponse(Integer disabilityresponse){
          this.disabilityresponse = disabilityresponse;
      }
      public Integer getIndefiniteandimpairs(){
          return indefiniteandimpairs;
      }
      public void setIndefiniteandimpairs(Integer indefiniteandimpairs){
          this.indefiniteandimpairs = indefiniteandimpairs;
      }
      public Integer getDocumentationonfile(){
          return documentationonfile;
      }
      public void setDocumentationonfile(Integer documentationonfile){
          this.documentationonfile = documentationonfile;
      }
      public Integer getReceivingservices(){
          return receivingservices;
      }
      public void setReceivingservices(Integer receivingservices){
          this.receivingservices = receivingservices;
      }
      public Integer getPathhowconfirmed(){
          return pathhowconfirmed;
      }
      public void setPathhowconfirmed(Integer pathhowconfirmed){
          this.pathhowconfirmed = pathhowconfirmed;
      }
      public Integer getPathsmiinformation(){
          return pathsmiinformation;
      }
      public void setPathsmiinformation(Integer pathsmiinformation){
          this.pathsmiinformation = pathsmiinformation;
      }
      public Integer getTcellcountavailable(){
          return tcellcountavailable;
      }
      public void setTcellcountavailable(Integer tcellcountavailable){
          this.tcellcountavailable = tcellcountavailable;
      }
      public Integer getTcellcount(){
          return tcellcount;
      }
      public void setTcellcount(Integer tcellcount){
          this.tcellcount = tcellcount;
      }
      public String getTcellcountsource(){
          return tcellcountsource;
      }
      public void setTcellcountsource(String tcellcountsource){
          this.tcellcountsource = tcellcountsource;
      }
      public Integer getViralLoadAvailable(){
          return viralLoadAvailable;
      }
      public void setViralLoadAvailable(Integer viralLoadAvailable){
          this.viralLoadAvailable = viralLoadAvailable;
      }
      public Integer getViralLoad(){
          return viralLoad;
      }
      public void setViralLoad(Integer viralLoad){
          this.viralLoad = viralLoad;
      }
      public String getViralLoadSource(){
          return viralLoadSource;
      }
      public void setViralLoadSource(String viralLoadSource){
          this.viralLoadSource = viralLoadSource;
      }

 }
