package com.servinglynk.hmis.warehouse.core.model; 

import java.util.Date;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("formerWardChildWelfare")
public class FormerWardChildWelfare extends ClientModel{


      private UUID formerWardChildWelfareId;

      private Integer childwelfaremonths;

      private String childwelfareyears;

      private String formerwardchildwelfare;



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
      public String getChildwelfareyears(){
          return childwelfareyears;
      }
      public void setChildwelfareyears(String childwelfareyears){
          this.childwelfareyears = childwelfareyears;
      }
      public String getFormerwardchildwelfare(){
          return formerwardchildwelfare;
      }
      public void setFormerwardchildwelfare(String formerwardchildwelfare){
          this.formerwardchildwelfare = formerwardchildwelfare;
      }

 }
