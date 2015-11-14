package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("youthCriticalIssue")
public class YouthCriticalIssue extends ClientModel{


      private UUID youthCriticalIssuesId;

      private String abuseandneglectfam;

      private String abuseandneglectyouth;

      private String activemilitaryparent;

      private String alcoholdrugabusefam;

      private String alcoholdrugabuseyouth;

      private String healthissuesfam;

      private String healthissuesyouth;

      private String householddynamics;

      private String housingissuesfam;

      private String housingissuesyouth;

      private String incarceratedparent;

      private String incarceratedparentstatus;

      private String insufficientincome;

      private String mentaldisabilityfam;

      private String mentaldisabilityyouth;

      private String mentalhealthissuesfam;

      private String mentalhealthissuesyouth;

      private String physicaldisabilityfam;

      private String physicaldisabilityyouth;

      private String schooleducationalissuesfam;

      private String schooleducationalissuesyouth;

      private String sexualorientationgenderidfam;

      private String sexualorientationgenderidyouth;

      private String unemploymentfam;

      private String unemploymentyouth;



      public UUID getYouthCriticalIssuesId(){
          return youthCriticalIssuesId;
      }
      public void setYouthCriticalIssuesId(UUID youthCriticalIssuesId){
          this.youthCriticalIssuesId = youthCriticalIssuesId;
      }
      public String getAbuseandneglectfam(){
          return abuseandneglectfam;
      }
      public void setAbuseandneglectfam(String abuseandneglectfam){
          this.abuseandneglectfam = abuseandneglectfam;
      }
      public String getAbuseandneglectyouth(){
          return abuseandneglectyouth;
      }
      public void setAbuseandneglectyouth(String abuseandneglectyouth){
          this.abuseandneglectyouth = abuseandneglectyouth;
      }
      public String getActivemilitaryparent(){
          return activemilitaryparent;
      }
      public void setActivemilitaryparent(String activemilitaryparent){
          this.activemilitaryparent = activemilitaryparent;
      }
      public String getAlcoholdrugabusefam(){
          return alcoholdrugabusefam;
      }
      public void setAlcoholdrugabusefam(String alcoholdrugabusefam){
          this.alcoholdrugabusefam = alcoholdrugabusefam;
      }
      public String getAlcoholdrugabuseyouth(){
          return alcoholdrugabuseyouth;
      }
      public void setAlcoholdrugabuseyouth(String alcoholdrugabuseyouth){
          this.alcoholdrugabuseyouth = alcoholdrugabuseyouth;
      }
      public String getHealthissuesfam(){
          return healthissuesfam;
      }
      public void setHealthissuesfam(String healthissuesfam){
          this.healthissuesfam = healthissuesfam;
      }
      public String getHealthissuesyouth(){
          return healthissuesyouth;
      }
      public void setHealthissuesyouth(String healthissuesyouth){
          this.healthissuesyouth = healthissuesyouth;
      }
      public String getHouseholddynamics(){
          return householddynamics;
      }
      public void setHouseholddynamics(String householddynamics){
          this.householddynamics = householddynamics;
      }
      public String getHousingissuesfam(){
          return housingissuesfam;
      }
      public void setHousingissuesfam(String housingissuesfam){
          this.housingissuesfam = housingissuesfam;
      }
      public String getHousingissuesyouth(){
          return housingissuesyouth;
      }
      public void setHousingissuesyouth(String housingissuesyouth){
          this.housingissuesyouth = housingissuesyouth;
      }
      public String getIncarceratedparent(){
          return incarceratedparent;
      }
      public void setIncarceratedparent(String incarceratedparent){
          this.incarceratedparent = incarceratedparent;
      }
      public String getIncarceratedparentstatus(){
          return incarceratedparentstatus;
      }
      public void setIncarceratedparentstatus(String incarceratedparentstatus){
          this.incarceratedparentstatus = incarceratedparentstatus;
      }
      public String getInsufficientincome(){
          return insufficientincome;
      }
      public void setInsufficientincome(String insufficientincome){
          this.insufficientincome = insufficientincome;
      }
      public String getMentaldisabilityfam(){
          return mentaldisabilityfam;
      }
      public void setMentaldisabilityfam(String mentaldisabilityfam){
          this.mentaldisabilityfam = mentaldisabilityfam;
      }
      public String getMentaldisabilityyouth(){
          return mentaldisabilityyouth;
      }
      public void setMentaldisabilityyouth(String mentaldisabilityyouth){
          this.mentaldisabilityyouth = mentaldisabilityyouth;
      }
      public String getMentalhealthissuesfam(){
          return mentalhealthissuesfam;
      }
      public void setMentalhealthissuesfam(String mentalhealthissuesfam){
          this.mentalhealthissuesfam = mentalhealthissuesfam;
      }
      public String getMentalhealthissuesyouth(){
          return mentalhealthissuesyouth;
      }
      public void setMentalhealthissuesyouth(String mentalhealthissuesyouth){
          this.mentalhealthissuesyouth = mentalhealthissuesyouth;
      }
      public String getPhysicaldisabilityfam(){
          return physicaldisabilityfam;
      }
      public void setPhysicaldisabilityfam(String physicaldisabilityfam){
          this.physicaldisabilityfam = physicaldisabilityfam;
      }
      public String getPhysicaldisabilityyouth(){
          return physicaldisabilityyouth;
      }
      public void setPhysicaldisabilityyouth(String physicaldisabilityyouth){
          this.physicaldisabilityyouth = physicaldisabilityyouth;
      }
      public String getSchooleducationalissuesfam(){
          return schooleducationalissuesfam;
      }
      public void setSchooleducationalissuesfam(String schooleducationalissuesfam){
          this.schooleducationalissuesfam = schooleducationalissuesfam;
      }
      public String getSchooleducationalissuesyouth(){
          return schooleducationalissuesyouth;
      }
      public void setSchooleducationalissuesyouth(String schooleducationalissuesyouth){
          this.schooleducationalissuesyouth = schooleducationalissuesyouth;
      }
      public String getSexualorientationgenderidfam(){
          return sexualorientationgenderidfam;
      }
      public void setSexualorientationgenderidfam(String sexualorientationgenderidfam){
          this.sexualorientationgenderidfam = sexualorientationgenderidfam;
      }
      public String getSexualorientationgenderidyouth(){
          return sexualorientationgenderidyouth;
      }
      public void setSexualorientationgenderidyouth(String sexualorientationgenderidyouth){
          this.sexualorientationgenderidyouth = sexualorientationgenderidyouth;
      }
      public String getUnemploymentfam(){
          return unemploymentfam;
      }
      public void setUnemploymentfam(String unemploymentfam){
          this.unemploymentfam = unemploymentfam;
      }
      public String getUnemploymentyouth(){
          return unemploymentyouth;
      }
      public void setUnemploymentyouth(String unemploymentyouth){
          this.unemploymentyouth = unemploymentyouth;
      }

 }
