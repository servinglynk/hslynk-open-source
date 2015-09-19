package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;

public class Disabilities {
	@MapToColumn(column=0)
	private String DisabilitiesID;
	@MapToColumn(column=1)
	private String ProjectEntryID;
	@MapToColumn(column=2)
	private String PersonalID;
	@MapToColumn(column=3)
	private String InformationDate;
	@MapToColumn(column=4)
	private String DisabilityType;
	@MapToColumn(column=5)
	private String DisabilityResponse;
	@MapToColumn(column=6)
	private String IndefiniteAndImpairs;
	@MapToColumn(column=7)
	private String DocumentationOnFile;
	@MapToColumn(column=8)
	private String ReceivingServices;
	@MapToColumn(column=9)
	private String PATHHowConfirmed;
	@MapToColumn(column=10)
	private String PATHSMIInformation;
	@MapToColumn(column=11)
	private String TCellCountAvailable;
	@MapToColumn(column=12)
	private String TCellCount;
	@MapToColumn(column=13)
	private String TCellSource;
	@MapToColumn(column=14)
	private String ViralLoadAvailable;
	@MapToColumn(column=15)
	private String ViralLoad;
	@MapToColumn(column=16)
	private String ViralLoadSource;
	@MapToColumn(column=17)
	private String DataCollectionStage;
	@MapToColumn(column=18)
	private String DateCreated;
	@MapToColumn(column=19)
	private String DateUpdated;
	@MapToColumn(column=20)
	private String UserID;
	@MapToColumn(column=21)
	private String DateDeleted;
	@MapToColumn(column=22)
	private String ExportID;

}
