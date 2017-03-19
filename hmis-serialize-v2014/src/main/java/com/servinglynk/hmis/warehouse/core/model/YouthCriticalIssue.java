package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("youthCriticalIssue")
public class YouthCriticalIssue extends ClientModel{


      private UUID youthCriticalIssuesId;

      private Integer abuseandneglectfam;

      private Integer abuseandneglectyouth;

      private Integer activemilitaryparent;

      private Integer alcoholdrugabusefam;

      private Integer alcoholdrugabuseyouth;

      private Integer healthissuesfam;

      private Integer healthissuesyouth;

      private Integer householddynamics;

      private Integer housingissuesfam;

      private Integer housingissuesyouth;

      private Integer incarceratedparent;

      private Integer incarceratedparentstatus;

      private Integer insufficientincome;

      private Integer mentaldisabilityfam;

      private Integer mentaldisabilityyouth;

      private Integer mentalhealthissuesfam;

      private Integer mentalhealthissuesyouth;

      private Integer physicaldisabilityfam;

      private Integer physicaldisabilityyouth;

      private Integer schooleducationalissuesfam;

      private Integer schooleducationalissuesyouth;

      private Integer sexualorientationgenderidfam;

      private Integer sexualorientationgenderidyouth;

      private Integer unemploymentfam;

      private Integer unemploymentyouth;

      private LocalDateTime informationDate;
      private Integer dataCollectionStage;


	public Integer getDataCollectionStage() {
		return dataCollectionStage;
	}
	public void setDataCollectionStage(Integer dataCollectionStage) {
		this.dataCollectionStage = dataCollectionStage;
}

         public LocalDateTime getInformationDate() {
    		return informationDate;
    	}
    	public void setInformationDate(LocalDateTime informationDate) {
    		this.informationDate = informationDate;
}

      public UUID getYouthCriticalIssuesId(){
          return youthCriticalIssuesId;
      }
      public void setYouthCriticalIssuesId(UUID youthCriticalIssuesId){
          this.youthCriticalIssuesId = youthCriticalIssuesId;
      }
      public Integer getAbuseandneglectfam(){
          return abuseandneglectfam;
      }
      public void setAbuseandneglectfam(Integer abuseandneglectfam){
          this.abuseandneglectfam = abuseandneglectfam;
      }
      public Integer getAbuseandneglectyouth(){
          return abuseandneglectyouth;
      }
      public void setAbuseandneglectyouth(Integer abuseandneglectyouth){
          this.abuseandneglectyouth = abuseandneglectyouth;
      }
      public Integer getActivemilitaryparent(){
          return activemilitaryparent;
      }
      public void setActivemilitaryparent(Integer activemilitaryparent){
          this.activemilitaryparent = activemilitaryparent;
      }
      public Integer getAlcoholdrugabusefam(){
          return alcoholdrugabusefam;
      }
      public void setAlcoholdrugabusefam(Integer alcoholdrugabusefam){
          this.alcoholdrugabusefam = alcoholdrugabusefam;
      }
      public Integer getAlcoholdrugabuseyouth(){
          return alcoholdrugabuseyouth;
      }
      public void setAlcoholdrugabuseyouth(Integer alcoholdrugabuseyouth){
          this.alcoholdrugabuseyouth = alcoholdrugabuseyouth;
      }
      public Integer getHealthissuesfam(){
          return healthissuesfam;
      }
      public void setHealthissuesfam(Integer healthissuesfam){
          this.healthissuesfam = healthissuesfam;
      }
      public Integer getHealthissuesyouth(){
          return healthissuesyouth;
      }
      public void setHealthissuesyouth(Integer healthissuesyouth){
          this.healthissuesyouth = healthissuesyouth;
      }
      public Integer getHouseholddynamics(){
          return householddynamics;
      }
      public void setHouseholddynamics(Integer householddynamics){
          this.householddynamics = householddynamics;
      }
      public Integer getHousingissuesfam(){
          return housingissuesfam;
      }
      public void setHousingissuesfam(Integer housingissuesfam){
          this.housingissuesfam = housingissuesfam;
      }
      public Integer getHousingissuesyouth(){
          return housingissuesyouth;
      }
      public void setHousingissuesyouth(Integer housingissuesyouth){
          this.housingissuesyouth = housingissuesyouth;
      }
      public Integer getIncarceratedparent(){
          return incarceratedparent;
      }
      public void setIncarceratedparent(Integer incarceratedparent){
          this.incarceratedparent = incarceratedparent;
      }
      public Integer getIncarceratedparentstatus(){
          return incarceratedparentstatus;
      }
      public void setIncarceratedparentstatus(Integer incarceratedparentstatus){
          this.incarceratedparentstatus = incarceratedparentstatus;
      }
      public Integer getInsufficientincome(){
          return insufficientincome;
      }
      public void setInsufficientincome(Integer insufficientincome){
          this.insufficientincome = insufficientincome;
      }
      public Integer getMentaldisabilityfam(){
          return mentaldisabilityfam;
      }
      public void setMentaldisabilityfam(Integer mentaldisabilityfam){
          this.mentaldisabilityfam = mentaldisabilityfam;
      }
      public Integer getMentaldisabilityyouth(){
          return mentaldisabilityyouth;
      }
      public void setMentaldisabilityyouth(Integer mentaldisabilityyouth){
          this.mentaldisabilityyouth = mentaldisabilityyouth;
      }
      public Integer getMentalhealthissuesfam(){
          return mentalhealthissuesfam;
      }
      public void setMentalhealthissuesfam(Integer mentalhealthissuesfam){
          this.mentalhealthissuesfam = mentalhealthissuesfam;
      }
      public Integer getMentalhealthissuesyouth(){
          return mentalhealthissuesyouth;
      }
      public void setMentalhealthissuesyouth(Integer mentalhealthissuesyouth){
          this.mentalhealthissuesyouth = mentalhealthissuesyouth;
      }
      public Integer getPhysicaldisabilityfam(){
          return physicaldisabilityfam;
      }
      public void setPhysicaldisabilityfam(Integer physicaldisabilityfam){
          this.physicaldisabilityfam = physicaldisabilityfam;
      }
      public Integer getPhysicaldisabilityyouth(){
          return physicaldisabilityyouth;
      }
      public void setPhysicaldisabilityyouth(Integer physicaldisabilityyouth){
          this.physicaldisabilityyouth = physicaldisabilityyouth;
      }
      public Integer getSchooleducationalissuesfam(){
          return schooleducationalissuesfam;
      }
      public void setSchooleducationalissuesfam(Integer schooleducationalissuesfam){
          this.schooleducationalissuesfam = schooleducationalissuesfam;
      }
      public Integer getSchooleducationalissuesyouth(){
          return schooleducationalissuesyouth;
      }
      public void setSchooleducationalissuesyouth(Integer schooleducationalissuesyouth){
          this.schooleducationalissuesyouth = schooleducationalissuesyouth;
      }
      public Integer getSexualorientationgenderidfam(){
          return sexualorientationgenderidfam;
      }
      public void setSexualorientationgenderidfam(Integer sexualorientationgenderidfam){
          this.sexualorientationgenderidfam = sexualorientationgenderidfam;
      }
      public Integer getSexualorientationgenderidyouth(){
          return sexualorientationgenderidyouth;
      }
      public void setSexualorientationgenderidyouth(Integer sexualorientationgenderidyouth){
          this.sexualorientationgenderidyouth = sexualorientationgenderidyouth;
      }
      public Integer getUnemploymentfam(){
          return unemploymentfam;
      }
      public void setUnemploymentfam(Integer unemploymentfam){
          this.unemploymentfam = unemploymentfam;
      }
      public Integer getUnemploymentyouth(){
          return unemploymentyouth;
      }
      public void setUnemploymentyouth(Integer unemploymentyouth){
          this.unemploymentyouth = unemploymentyouth;
      }

 }
