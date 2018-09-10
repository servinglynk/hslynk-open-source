package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("disabilities")
public class Disabilities extends ClientModel{


      private UUID disabilitiesId;

      @JsonSerialize(using=JsonDateSerializer.class)
      @JsonDeserialize(using=JsonDateDeserializer.class)
      private LocalDateTime informationDate;
      @JsonProperty("disabilityType")
      private Integer disabilitytype;

      @JsonProperty("disabilityResponse")
      private Integer disabilityresponse;

      @JsonProperty("indefiniteandImpairs")
      private Integer indefiniteandimpairs;
      @JsonProperty("tCellCountAvailable")
      private Integer tcellcountavailable;
      @JsonProperty("tCellCount")
      private Integer tcellcount;
      @JsonProperty("tCellCountSource")
      private String tcellcountsource;
      @JsonProperty("viralLoadAvailable")
      private Integer viralLoadAvailable;

      private Integer viralLoad;
      
      private Integer dataCollectionStage;

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
	public Integer getDataCollectionStage() {
		return dataCollectionStage;
	}
	public void setDataCollectionStage(Integer dataCollectionStage) {
		this.dataCollectionStage = dataCollectionStage;
	}
 }
