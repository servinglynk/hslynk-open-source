package com.servinglynk.hmis.warehouse.model.v2014;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

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
