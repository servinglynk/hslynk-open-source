package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("formerWardChildWelfare")
public class FormerWardChildWelfare extends ClientModel{


      private UUID formerWardChildWelfareId;

      private Integer childwelfaremonths;

      private Integer childwelfareyears;

      private Integer formerwardchildwelfare;



      public UUID getFormerWardChildWelfareId(){
          return formerWardChildWelfareId;
      }
      public void setFormerWardChildWelfareId(UUID formerWardChildWelfareId){
          this.formerWardChildWelfareId = formerWardChildWelfareId;
      }
      public Integer getChildwelfaremonths(){
          return childwelfaremonths;
      }
      public void setChildwelfaremonths(Integer childwelfaremonths){
          this.childwelfaremonths = childwelfaremonths;
      }
      public Integer getChildwelfareyears(){
          return childwelfareyears;
      }
      public void setChildwelfareyears(Integer childwelfareyears){
          this.childwelfareyears = childwelfareyears;
      }
      public Integer getFormerwardchildwelfare(){
          return formerwardchildwelfare;
      }
      public void setFormerwardchildwelfare(Integer formerwardchildwelfare){
          this.formerwardchildwelfare = formerwardchildwelfare;
      }

 }
