package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("exitPlansActions")
public class ExitPlansActions extends ClientModel{


      private UUID exitPlansActionsId;

      private String assistancemainstreambenefits;

      private String exitcounseling;

      private String furtherfollowupservices;

      private String otheraftercareplanoraction;

      private String permanenthousingplacement;

      private String resourcepackage;

      private String scheduledfollowupcontacts;

      private String temporaryshelterplacement;

      private String writtenaftercareplan;



      public UUID getExitPlansActionsId(){
          return exitPlansActionsId;
      }
      public void setExitPlansActionsId(UUID exitPlansActionsId){
          this.exitPlansActionsId = exitPlansActionsId;
      }
      public String getAssistancemainstreambenefits(){
          return assistancemainstreambenefits;
      }
      public void setAssistancemainstreambenefits(String assistancemainstreambenefits){
          this.assistancemainstreambenefits = assistancemainstreambenefits;
      }
      public String getExitcounseling(){
          return exitcounseling;
      }
      public void setExitcounseling(String exitcounseling){
          this.exitcounseling = exitcounseling;
      }
      public String getFurtherfollowupservices(){
          return furtherfollowupservices;
      }
      public void setFurtherfollowupservices(String furtherfollowupservices){
          this.furtherfollowupservices = furtherfollowupservices;
      }
      public String getOtheraftercareplanoraction(){
          return otheraftercareplanoraction;
      }
      public void setOtheraftercareplanoraction(String otheraftercareplanoraction){
          this.otheraftercareplanoraction = otheraftercareplanoraction;
      }
      public String getPermanenthousingplacement(){
          return permanenthousingplacement;
      }
      public void setPermanenthousingplacement(String permanenthousingplacement){
          this.permanenthousingplacement = permanenthousingplacement;
      }
      public String getResourcepackage(){
          return resourcepackage;
      }
      public void setResourcepackage(String resourcepackage){
          this.resourcepackage = resourcepackage;
      }
      public String getScheduledfollowupcontacts(){
          return scheduledfollowupcontacts;
      }
      public void setScheduledfollowupcontacts(String scheduledfollowupcontacts){
          this.scheduledfollowupcontacts = scheduledfollowupcontacts;
      }
      public String getTemporaryshelterplacement(){
          return temporaryshelterplacement;
      }
      public void setTemporaryshelterplacement(String temporaryshelterplacement){
          this.temporaryshelterplacement = temporaryshelterplacement;
      }
      public String getWrittenaftercareplan(){
          return writtenaftercareplan;
      }
      public void setWrittenaftercareplan(String writtenaftercareplan){
          this.writtenaftercareplan = writtenaftercareplan;
      }

 }
