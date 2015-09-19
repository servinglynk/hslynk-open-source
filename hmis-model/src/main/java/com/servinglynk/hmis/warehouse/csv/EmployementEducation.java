package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;
														

public class EmployementEducation {
	@MapToColumn(column=0)
	private String EmploymentEducationID;
	@MapToColumn(column=1)
	private String ProjectEntryID;
	@MapToColumn(column=2)
	private String PersonalID;
	@MapToColumn(column=3)
	private String InformationDate;
	@MapToColumn(column=4)
	private String LastGradeCompleted;
	@MapToColumn(column=5)
	private String SchoolStatus;
	@MapToColumn(column=6)
	private String Employed;
	@MapToColumn(column=7)
	private String EmploymentType;
	@MapToColumn(column=8)
	private String NotEmployedReason;
	@MapToColumn(column=9)
	private String DataCollectionStage;
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
