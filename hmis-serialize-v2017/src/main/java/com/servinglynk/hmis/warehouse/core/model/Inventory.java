package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("inventory")
public class Inventory extends ClientModel{


      private UUID inventoryId;

      private Integer availabilty;

      private Integer bedinventory;

      private Integer bedtype;

      private Integer hmisparticipatingbeds;

      private Integer householdtype;
      
      private Integer chbedinventory;
      
      private Integer vetbedinventory;
      private Integer youthbedinventory;
      
      public Integer getChbedinventory() {
		return chbedinventory;
	}
	public void setchbedinventory(Integer chbedinventory) {
		this.chbedinventory = chbedinventory;
	}
	public Integer getVetbedinventory() {
		return vetbedinventory;
	}
	public void setVetbedinventory(Integer vetbedinventory) {
		this.vetbedinventory = vetbedinventory;
	}
	public Integer getYouthbedinventory() {
		return youthbedinventory;
	}
	public void setYouthbedinventory(Integer youthbedinventory) {
		this.youthbedinventory = youthbedinventory;
	}
	

      @JsonSerialize(using=JsonDateSerializer.class)
      @JsonDeserialize(using=JsonDateDeserializer.class)
      private LocalDateTime inventoryenddate;

      @JsonSerialize(using=JsonDateSerializer.class)
      @JsonDeserialize(using=JsonDateDeserializer.class)
      private LocalDateTime inventorystartdate;

      private Integer unitinventory;



      public UUID getInventoryId(){
          return inventoryId;
      }
      public void setInventoryId(UUID inventoryId){
          this.inventoryId = inventoryId;
      }
      public Integer getAvailabilty(){
          return availabilty;
      }
      public void setAvailabilty(Integer availabilty){
          this.availabilty = availabilty;
      }
      public Integer getBedinventory(){
          return bedinventory;
      }
      public void setBedinventory(Integer bedinventory){
          this.bedinventory = bedinventory;
      }
      public Integer getBedtype(){
          return bedtype;
      }
      public void setBedtype(Integer bedtype){
          this.bedtype = bedtype;
      }
      public Integer getHmisparticipatingbeds(){
          return hmisparticipatingbeds;
      }
      public void setHmisparticipatingbeds(Integer hmisparticipatingbeds){
          this.hmisparticipatingbeds = hmisparticipatingbeds;
      }
      public Integer getHouseholdtype(){
          return householdtype;
      }
      public void setHouseholdtype(Integer householdtype){
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
