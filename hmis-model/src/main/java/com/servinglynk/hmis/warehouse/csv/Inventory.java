package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;

public class Inventory {
	@MapToColumn(column=0)
	private String InventoryID;
	@MapToColumn(column=1)
	private String ProjectID;
	@MapToColumn(column=2)
	private String CoCCode;
	@MapToColumn(column=3)
	private String InformationDate;
	@MapToColumn(column=4)
	private String HouseholdType;
	@MapToColumn(column=5)
	private String BedType;
	@MapToColumn(column=6)
	private String Availability;
	@MapToColumn(column=7)
	private String UnitInventory;
	@MapToColumn(column=8)
	private String BedInventory;
	@MapToColumn(column=9)
	private String CHBedInventory;
	@MapToColumn(column=10)
	private String VetBedInventory;
	@MapToColumn(column=11)
	private String YouthBedInventory;
	@MapToColumn(column=12)
	private String YouthAgeGroup;
	@MapToColumn(column=13)
	private String HMISParticipatingBeds;
	@MapToColumn(column=14)
	private String DateCreated;
	@MapToColumn(column=15)
	private String DateUpdated;
	@MapToColumn(column=16)
	private String UserID;
	@MapToColumn(column=17)
	private String DateDeleted;
	@MapToColumn(column=18)
	private String ExportID;
	public String getInventoryID() {
		return InventoryID;
	}
	public void setInventoryID(String inventoryID) {
		InventoryID = inventoryID;
	}
	public String getProjectID() {
		return ProjectID;
	}
	public void setProjectID(String projectID) {
		ProjectID = projectID;
	}
	public String getCoCCode() {
		return CoCCode;
	}
	public void setCoCCode(String coCCode) {
		CoCCode = coCCode;
	}
	public String getInformationDate() {
		return InformationDate;
	}
	public void setInformationDate(String informationDate) {
		InformationDate = informationDate;
	}
	public String getHouseholdType() {
		return HouseholdType;
	}
	public void setHouseholdType(String householdType) {
		HouseholdType = householdType;
	}
	public String getBedType() {
		return BedType;
	}
	public void setBedType(String bedType) {
		BedType = bedType;
	}
	public String getAvailability() {
		return Availability;
	}
	public void setAvailability(String availability) {
		Availability = availability;
	}
	public String getUnitInventory() {
		return UnitInventory;
	}
	public void setUnitInventory(String unitInventory) {
		UnitInventory = unitInventory;
	}
	public String getBedInventory() {
		return BedInventory;
	}
	public void setBedInventory(String bedInventory) {
		BedInventory = bedInventory;
	}
	public String getCHBedInventory() {
		return CHBedInventory;
	}
	public void setCHBedInventory(String cHBedInventory) {
		CHBedInventory = cHBedInventory;
	}
	public String getVetBedInventory() {
		return VetBedInventory;
	}
	public void setVetBedInventory(String vetBedInventory) {
		VetBedInventory = vetBedInventory;
	}
	public String getYouthBedInventory() {
		return YouthBedInventory;
	}
	public void setYouthBedInventory(String youthBedInventory) {
		YouthBedInventory = youthBedInventory;
	}
	public String getYouthAgeGroup() {
		return YouthAgeGroup;
	}
	public void setYouthAgeGroup(String youthAgeGroup) {
		YouthAgeGroup = youthAgeGroup;
	}
	public String getHMISParticipatingBeds() {
		return HMISParticipatingBeds;
	}
	public void setHMISParticipatingBeds(String hMISParticipatingBeds) {
		HMISParticipatingBeds = hMISParticipatingBeds;
	}
	public String getDateCreated() {
		return DateCreated;
	}
	public void setDateCreated(String dateCreated) {
		DateCreated = dateCreated;
	}
	public String getDateUpdated() {
		return DateUpdated;
	}
	public void setDateUpdated(String dateUpdated) {
		DateUpdated = dateUpdated;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getDateDeleted() {
		return DateDeleted;
	}
	public void setDateDeleted(String dateDeleted) {
		DateDeleted = dateDeleted;
	}
	public String getExportID() {
		return ExportID;
	}
	public void setExportID(String exportID) {
		ExportID = exportID;
	}
	
}
