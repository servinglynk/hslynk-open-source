package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;
										
																

public class HealthAndDV {
	@MapToColumn(column=0)
	private String HealthAndDVID;
	@MapToColumn(column=1)
	private String ProjectEntryID;
	@MapToColumn(column=2)
	private String PersonalID;
	@MapToColumn(column=3)
	private String InformationDate;
	@MapToColumn(column=4)
	private String DomesticViolenceVictim;
	@MapToColumn(column=5)
	private String WhenOccurred;
	@MapToColumn(column=6)
	private String CurrentlyFleeing;
	@MapToColumn(column=7)
	private String GeneralHealthStatus;
	@MapToColumn(column=8)
	private String DentalHealthStatus;
	@MapToColumn(column=9)
	private String MentalHealthStatus;
	@MapToColumn(column=10)
	private String PregnancyStatus;
	@MapToColumn(column=11)
	private String DueDate;
	@MapToColumn(column=12)
	private String DataCollectionStage;
	@MapToColumn(column=13)
	private String DateCreated;
	@MapToColumn(column=14)
	private String DateUpdated;
	@MapToColumn(column=15)
	private String UserID;
	@MapToColumn(column=16)
	private String DateDeleted;
	@MapToColumn(column=17)
	private String ExportID;
	
}
