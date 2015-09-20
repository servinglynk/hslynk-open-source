package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;

public class Services {
	@MapToColumn(column=0)
	private String ServicesID;
	@MapToColumn(column=1)
	private String ProjectEntryID;
	@MapToColumn(column=2)
	private String PersonalID;
	@MapToColumn(column=3)
	private String DateProvided;
	@MapToColumn(column=4)
	private String RecordType;
	@MapToColumn(column=5)
	private String TypeProvided;
	@MapToColumn(column=6)
	private String OtherTypeProvided;
	@MapToColumn(column=7)
	private String SubTypeProvided;
	@MapToColumn(column=8)
	private String FAAmount;
	@MapToColumn(column=9)
	private String ReferralOutcome;
	@MapToColumn(column=10)
	private String DateCreated;
	@MapToColumn(column=11)
	private String DateUpdated;
	@MapToColumn(column=12)
	private String UserID;
	@MapToColumn(column=13)
	private String DateDeleted;
	@MapToColumn(column=14)
	private String ExportID;
}
