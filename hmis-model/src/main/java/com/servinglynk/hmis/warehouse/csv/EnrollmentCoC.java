package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;
														
									

public class EnrollmentCoC {
	@MapToColumn(column=0)
	private String EmploymentEducationID;
	@MapToColumn(column=1)
	private String ProjectEntryID;
	@MapToColumn(column=2)
	private String ProjectID;
	@MapToColumn(column=3)
	private String PersonalID;
	@MapToColumn(column=4)
	private String LastGradeCompleted;
	@MapToColumn(column=5)
	private String CoCCode;
	@MapToColumn(column=6)
	private String DataCollectionStage;
	@MapToColumn(column=7)
	private String DateCreated;
	@MapToColumn(column=8)
	private String DateUpdated;
	@MapToColumn(column=9)
	private String UserID;
	@MapToColumn(column=10)
	private String DateDeleted;
	@MapToColumn(column=11)
	private String ExportID;
	
}
