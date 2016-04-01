package com.servinglynk.hmis.warehouse.core.model; 

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("servicefareferral")
public class Servicefareferral extends ClientModel{


      private UUID servicefareferralId;

      private LocalDateTime dateprovided;

      private Integer serviceCategory;

      private Integer funderList;

      private Integer typeProvided;

      private String otherTypeProvided;

      private Integer subTypeProvided;

      private BigDecimal faAmount;

      private Integer referralOutcome;



      public UUID getServicefareferralId(){
          return servicefareferralId;
      }
      public void setServicefareferralId(UUID servicefareferralId){
          this.servicefareferralId = servicefareferralId;
      }
      public LocalDateTime getDateprovided(){
          return dateprovided;
      }
      public void setDateprovided(LocalDateTime dateprovided){
          this.dateprovided = dateprovided;
      }
      public Integer getServiceCategory(){
          return serviceCategory;
      }
      public void setServiceCategory(Integer serviceCategory){
          this.serviceCategory = serviceCategory;
      }
      public Integer getFunderList(){
          return funderList;
      }
      public void setFunderList(Integer funderList){
          this.funderList = funderList;
      }
      public Integer getTypeProvided(){
          return typeProvided;
      }
      public void setTypeProvided(Integer typeProvided){
          this.typeProvided = typeProvided;
      }
      public String getOtherTypeProvided(){
          return otherTypeProvided;
      }
      public void setOtherTypeProvided(String otherTypeProvided){
          this.otherTypeProvided = otherTypeProvided;
      }
      public Integer getSubTypeProvided(){
          return subTypeProvided;
      }
      public void setSubTypeProvided(Integer subTypeProvided){
          this.subTypeProvided = subTypeProvided;
      }
      public BigDecimal getFaAmount(){
          return faAmount;
      }
      public void setFaAmount(BigDecimal faAmount){
          this.faAmount = faAmount;
      }
      public Integer getReferralOutcome(){
          return referralOutcome;
      }
      public void setReferralOutcome(Integer referralOutcome){
          this.referralOutcome = referralOutcome;
      }

 }
