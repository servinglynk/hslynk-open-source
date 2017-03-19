package com.servinglynk.hmis.warehouse.core.model; 

import java.util.Date;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("exitrhy")
public class Exitrhy extends ClientModel{


      private UUID exitrhyId;

      private Integer projectCompletionStatus;

      private Integer earlyExitReason;

      private Integer familyReunificationAchieved;

      private Integer writtenAfterCarePlan;

      private Integer assistanceMainStreamBenefits;

      private Integer permenantHousingPlacement;

      private Integer tempShelterPlacement;

      private Integer exitCounseling;

      private Integer furtherFollowupServices;

      private Integer scheduledFollowupContacts;

      private Integer resourcePackage;

      private Integer otherAftercarePlanOrAction;



      public UUID getExitrhyId(){
          return exitrhyId;
      }
      public void setExitrhyId(UUID exitrhyId){
          this.exitrhyId = exitrhyId;
      }
      public Integer getProjectCompletionStatus(){
          return projectCompletionStatus;
      }
      public void setProjectCompletionStatus(Integer projectCompletionStatus){
          this.projectCompletionStatus = projectCompletionStatus;
      }
      public Integer getEarlyExitReason(){
          return earlyExitReason;
      }
      public void setEarlyExitReason(Integer earlyExitReason){
          this.earlyExitReason = earlyExitReason;
      }
      public Integer getFamilyReunificationAchieved(){
          return familyReunificationAchieved;
      }
      public void setFamilyReunificationAchieved(Integer familyReunificationAchieved){
          this.familyReunificationAchieved = familyReunificationAchieved;
      }
      public Integer getWrittenAfterCarePlan(){
          return writtenAfterCarePlan;
      }
      public void setWrittenAfterCarePlan(Integer writtenAfterCarePlan){
          this.writtenAfterCarePlan = writtenAfterCarePlan;
      }
      public Integer getAssistanceMainStreamBenefits(){
          return assistanceMainStreamBenefits;
      }
      public void setAssistanceMainStreamBenefits(Integer assistanceMainStreamBenefits){
          this.assistanceMainStreamBenefits = assistanceMainStreamBenefits;
      }
      public Integer getPermenantHousingPlacement(){
          return permenantHousingPlacement;
      }
      public void setPermenantHousingPlacement(Integer permenantHousingPlacement){
          this.permenantHousingPlacement = permenantHousingPlacement;
      }
      public Integer getTempShelterPlacement(){
          return tempShelterPlacement;
      }
      public void setTempShelterPlacement(Integer tempShelterPlacement){
          this.tempShelterPlacement = tempShelterPlacement;
      }
      public Integer getExitCounseling(){
          return exitCounseling;
      }
      public void setExitCounseling(Integer exitCounseling){
          this.exitCounseling = exitCounseling;
      }
      public Integer getFurtherFollowupServices(){
          return furtherFollowupServices;
      }
      public void setFurtherFollowupServices(Integer furtherFollowupServices){
          this.furtherFollowupServices = furtherFollowupServices;
      }
      public Integer getScheduledFollowupContacts(){
          return scheduledFollowupContacts;
      }
      public void setScheduledFollowupContacts(Integer scheduledFollowupContacts){
          this.scheduledFollowupContacts = scheduledFollowupContacts;
      }
      public Integer getResourcePackage(){
          return resourcePackage;
      }
      public void setResourcePackage(Integer resourcePackage){
          this.resourcePackage = resourcePackage;
      }
      public Integer getOtherAftercarePlanOrAction(){
          return otherAftercarePlanOrAction;
      }
      public void setOtherAftercarePlanOrAction(Integer otherAftercarePlanOrAction){
          this.otherAftercarePlanOrAction = otherAftercarePlanOrAction;
      }

 }
