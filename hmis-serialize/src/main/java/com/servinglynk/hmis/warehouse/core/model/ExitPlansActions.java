package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("exitPlansActions")
public class ExitPlansActions extends ClientModel{


      private UUID exitPlansActionsId;

      private Integer assistancemainstreambenefits;

      private Integer exitcounseling;

      private Integer furtherfollowupservices;

      private Integer otheraftercareplanoraction;

      private Integer permanenthousingplacement;

      private Integer resourcepackage;

      private Integer scheduledfollowupcontacts;

      private Integer temporaryshelterplacement;

      private Integer writtenaftercareplan;



      public UUID getExitPlansActionsId(){
          return exitPlansActionsId;
      }
      public void setExitPlansActionsId(UUID exitPlansActionsId){
          this.exitPlansActionsId = exitPlansActionsId;
      }
      public Integer getAssistancemainstreambenefits(){
          return assistancemainstreambenefits;
      }
      public void setAssistancemainstreambenefits(Integer assistancemainstreambenefits){
          this.assistancemainstreambenefits = assistancemainstreambenefits;
      }
      public Integer getExitcounseling(){
          return exitcounseling;
      }
      public void setExitcounseling(Integer exitcounseling){
          this.exitcounseling = exitcounseling;
      }
      public Integer getFurtherfollowupservices(){
          return furtherfollowupservices;
      }
      public void setFurtherfollowupservices(Integer furtherfollowupservices){
          this.furtherfollowupservices = furtherfollowupservices;
      }
      public Integer getOtheraftercareplanoraction(){
          return otheraftercareplanoraction;
      }
      public void setOtheraftercareplanoraction(Integer otheraftercareplanoraction){
          this.otheraftercareplanoraction = otheraftercareplanoraction;
      }
      public Integer getPermanenthousingplacement(){
          return permanenthousingplacement;
      }
      public void setPermanenthousingplacement(Integer permanenthousingplacement){
          this.permanenthousingplacement = permanenthousingplacement;
      }
      public Integer getResourcepackage(){
          return resourcepackage;
      }
      public void setResourcepackage(Integer resourcepackage){
          this.resourcepackage = resourcepackage;
      }
      public Integer getScheduledfollowupcontacts(){
          return scheduledfollowupcontacts;
      }
      public void setScheduledfollowupcontacts(Integer scheduledfollowupcontacts){
          this.scheduledfollowupcontacts = scheduledfollowupcontacts;
      }
      public Integer getTemporaryshelterplacement(){
          return temporaryshelterplacement;
      }
      public void setTemporaryshelterplacement(Integer temporaryshelterplacement){
          this.temporaryshelterplacement = temporaryshelterplacement;
      }
      public Integer getWrittenaftercareplan(){
          return writtenaftercareplan;
      }
      public void setWrittenaftercareplan(Integer writtenaftercareplan){
          this.writtenaftercareplan = writtenaftercareplan;
      }

 }
