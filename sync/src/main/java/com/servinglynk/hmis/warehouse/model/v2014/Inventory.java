package com.servinglynk.hmis.warehouse.model.v2014;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class Inventory extends BaseModel {

	@Column(name = "availabilty")
	public String availabilty;
	@Column(name = "bedinventory")
	public UUID bedinventory;
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
	@Column(name = "project_coc_id")
	public UUID project_coc_id;
	@Column(name = "unitinventory")
	public String unitinventory;

	@Column(name="bed_inventory")		
	public String bed_inventory;
	@Column(name="ch_bed_inventory")
	public String ch_bed_inventory;
	@Column(name="vet_bed_inventory")
	public String vet_bed_inventory;
	@Column(name="youth_age_group")
	public String youth_age_group;
	@Column(name="youth_bed_inventory")
	public String youth_bed_inventory;
	/**
	 * @return the bed_inventory
	 */
	public String getBed_inventory() {
		return bed_inventory;
	}
	/**
	 * @param bed_inventory the bed_inventory to set
	 */
	public void setBed_inventory(String bed_inventory) {
		this.bed_inventory = bed_inventory;
	}
	/**
	 * @return the ch_bed_inventory
	 */
	public String getCh_bed_inventory() {
		return ch_bed_inventory;
	}
	/**
	 * @param ch_bed_inventory the ch_bed_inventory to set
	 */
	public void setCh_bed_inventory(String ch_bed_inventory) {
		this.ch_bed_inventory = ch_bed_inventory;
	}
	/**
	 * @return the vet_bed_inventory
	 */
	public String getVet_bed_inventory() {
		return vet_bed_inventory;
	}
	/**
	 * @param vet_bed_inventory the vet_bed_inventory to set
	 */
	public void setVet_bed_inventory(String vet_bed_inventory) {
		this.vet_bed_inventory = vet_bed_inventory;
	}
	/**
	 * @return the youth_age_group
	 */
	public String getYouth_age_group() {
		return youth_age_group;
	}
	/**
	 * @param youth_age_group the youth_age_group to set
	 */
	public void setYouth_age_group(String youth_age_group) {
		this.youth_age_group = youth_age_group;
	}
	/**
	 * @return the youth_bed_inventory
	 */
	public String getYouth_bed_inventory() {
		return youth_bed_inventory;
	}
	/**
	 * @param youth_bed_inventory the youth_bed_inventory to set
	 */
	public void setYouth_bed_inventory(String youth_bed_inventory) {
		this.youth_bed_inventory = youth_bed_inventory;
	}
	/**
	 * @return the availabilty
	 */
	public String getAvailabilty() {
		return availabilty;
	}

	/**
	 * @param availabilty
	 *            the availabilty to set
	 */
	public void setAvailabilty(String availabilty) {
		this.availabilty = availabilty;
	}

	/**
	 * @return the bedinventory
	 */
	public UUID getBedinventory() {
		return bedinventory;
	}

	/**
	 * @param bedinventory
	 *            the bedinventory to set
	 */
	public void setBedinventory(UUID bedinventory) {
		this.bedinventory = bedinventory;
	}

	/**
	 * @return the bedtype
	 */
	public String getBedtype() {
		return bedtype;
	}

	/**
	 * @param bedtype
	 *            the bedtype to set
	 */
	public void setBedtype(String bedtype) {
		this.bedtype = bedtype;
	}

	/**
	 * @return the hmisparticipatingbeds
	 */
	public String getHmisparticipatingbeds() {
		return hmisparticipatingbeds;
	}

	/**
	 * @param hmisparticipatingbeds
	 *            the hmisparticipatingbeds to set
	 */
	public void setHmisparticipatingbeds(String hmisparticipatingbeds) {
		this.hmisparticipatingbeds = hmisparticipatingbeds;
	}

	/**
	 * @return the householdtype
	 */
	public String getHouseholdtype() {
		return householdtype;
	}

	/**
	 * @param householdtype
	 *            the householdtype to set
	 */
	public void setHouseholdtype(String householdtype) {
		this.householdtype = householdtype;
	}

	/**
	 * @return the inventoryenddate
	 */
	public Date getInventoryenddate() {
		return inventoryenddate;
	}

	/**
	 * @param inventoryenddate
	 *            the inventoryenddate to set
	 */
	public void setInventoryenddate(Date inventoryenddate) {
		this.inventoryenddate = inventoryenddate;
	}

	/**
	 * @return the inventorystartdate
	 */
	public Date getInventorystartdate() {
		return inventorystartdate;
	}

	/**
	 * @param inventorystartdate
	 *            the inventorystartdate to set
	 */
	public void setInventorystartdate(Date inventorystartdate) {
		this.inventorystartdate = inventorystartdate;
	}

	/**
	 * @return the project_coc_id
	 */
	public UUID getProject_coc_id() {
		return project_coc_id;
	}

	/**
	 * @param project_coc_id
	 *            the project_coc_id to set
	 */
	public void setProject_coc_id(UUID project_coc_id) {
		this.project_coc_id = project_coc_id;
	}

	/**
	 * @return the unitinventory
	 */
	public String getUnitinventory() {
		return unitinventory;
	}

	/**
	 * @param unitinventory
	 *            the unitinventory to set
	 */
	public void setUnitinventory(String unitinventory) {
		this.unitinventory = unitinventory;
	}

}
