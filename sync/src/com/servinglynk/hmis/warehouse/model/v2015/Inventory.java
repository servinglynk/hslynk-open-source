package com.servinglynk.hmis.warehouse.model.v2015;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Inventory extends BaseModel {

	@Column(name = "availabilty")
	public String availabilty;
	@Column(name = "bedinventory")
	public String bedinventory;
	@Column(name = "bedtype")
	public String bedtype;
	@Column(name = "hmisparticipatingbeds")
	public String hmisparticipatingbeds;
	@Column(name = "householdtype")
	public String householdtype;
	@Column(name = "inventoryenddate")
	public Date inventoryenddate;
	@Column(name = "inventorystartdate")
	public Date inventorystartdate;
	@Column(name = "coc_id")
	public UUID coc_id;
	@Column(name = "id")
	public UUID id;
	@Column(name = "unitinventory")
	public String unitinventory;
	@Column(name="ch_bed_inventory")
	public String ch_bed_inventory;
	@Column(name="vet_bed_inventory")
	public String vet_bed_inventory;
	@Column(name="youth_age_group")
	public String youth_age_group;
	@Column(name="youth_bed_inventory")
	public String youth_bed_inventory;
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getAvailabilty() {
		return availabilty;
	}
	public void setAvailabilty(String availabilty) {
		this.availabilty = availabilty;
	}
	public String getBedinventory() {
		return bedinventory;
	}
	public void setBedinventory(String bedinventory) {
		this.bedinventory = bedinventory;
	}
	public String getBedtype() {
		return bedtype;
	}
	public void setBedtype(String bedtype) {
		this.bedtype = bedtype;
	}
	public String getHmisparticipatingbeds() {
		return hmisparticipatingbeds;
	}
	public void setHmisparticipatingbeds(String hmisparticipatingbeds) {
		this.hmisparticipatingbeds = hmisparticipatingbeds;
	}
	public String getHouseholdtype() {
		return householdtype;
	}
	public void setHouseholdtype(String householdtype) {
		this.householdtype = householdtype;
	}
	public Date getInventoryenddate() {
		return inventoryenddate;
	}
	public void setInventoryenddate(Date inventoryenddate) {
		this.inventoryenddate = inventoryenddate;
	}
	public Date getInventorystartdate() {
		return inventorystartdate;
	}
	public void setInventorystartdate(Date inventorystartdate) {
		this.inventorystartdate = inventorystartdate;
	}
	public UUID getCoc_id() {
		return coc_id;
	}
	public void setCoc_id(UUID coc_id) {
		this.coc_id = coc_id;
	}
	public String getUnitinventory() {
		return unitinventory;
	}
	public void setUnitinventory(String unitinventory) {
		this.unitinventory = unitinventory;
	}
	public String getCh_bed_inventory() {
		return ch_bed_inventory;
	}
	public void setCh_bed_inventory(String ch_bed_inventory) {
		this.ch_bed_inventory = ch_bed_inventory;
	}
	public String getVet_bed_inventory() {
		return vet_bed_inventory;
	}
	public void setVet_bed_inventory(String vet_bed_inventory) {
		this.vet_bed_inventory = vet_bed_inventory;
	}
	public String getYouth_age_group() {
		return youth_age_group;
	}
	public void setYouth_age_group(String youth_age_group) {
		this.youth_age_group = youth_age_group;
	}
	public String getYouth_bed_inventory() {
		return youth_bed_inventory;
	}
	public void setYouth_bed_inventory(String youth_bed_inventory) {
		this.youth_bed_inventory = youth_bed_inventory;
	}

	

}
