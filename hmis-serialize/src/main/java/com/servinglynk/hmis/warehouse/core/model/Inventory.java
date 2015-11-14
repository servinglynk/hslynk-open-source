package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("inventory")
public class Inventory extends ClientModel{


      private UUID inventoryId;

      private String availabilty;

      private UUID bedinventory;

      private String bedtype;

      private Integer hmisparticipatingbeds;

      private String householdtype;

      private LocalDateTime inventoryenddate;

      private LocalDateTime inventorystartdate;

      private Integer unitinventory;



      public UUID getInventoryId(){
          return inventoryId;
      }
      public void setInventoryId(UUID inventoryId){
          this.inventoryId = inventoryId;
      }
      public String getAvailabilty(){
          return availabilty;
      }
      public void setAvailabilty(String availabilty){
          this.availabilty = availabilty;
      }
      public UUID getBedinventory(){
          return bedinventory;
      }
      public void setBedinventory(UUID bedinventory){
          this.bedinventory = bedinventory;
      }
      public String getBedtype(){
          return bedtype;
      }
      public void setBedtype(String bedtype){
          this.bedtype = bedtype;
      }
      public Integer getHmisparticipatingbeds(){
          return hmisparticipatingbeds;
      }
      public void setHmisparticipatingbeds(Integer hmisparticipatingbeds){
          this.hmisparticipatingbeds = hmisparticipatingbeds;
      }
      public String getHouseholdtype(){
          return householdtype;
      }
      public void setHouseholdtype(String householdtype){
          this.householdtype = householdtype;
      }
      public LocalDateTime getInventoryenddate(){
          return inventoryenddate;
      }
      public void setInventoryenddate(LocalDateTime inventoryenddate){
          this.inventoryenddate = inventoryenddate;
      }
      public LocalDateTime getInventorystartdate(){
          return inventorystartdate;
      }
      public void setInventorystartdate(LocalDateTime inventorystartdate){
          this.inventorystartdate = inventorystartdate;
      }
      public Integer getUnitinventory(){
          return unitinventory;
      }
      public void setUnitinventory(Integer unitinventory){
          this.unitinventory = unitinventory;
      }

 }
