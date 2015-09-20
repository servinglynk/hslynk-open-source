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
	
}
