package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;

public class Project {
	@MapToColumn(column=0)
	private String ProjectID;
	@MapToColumn(column=1)
	private String OrganizationID;
	@MapToColumn(column=2)
	private String ProjectName;
	@MapToColumn(column=3)
	private String ProjectCommonName;
	@MapToColumn(column=4)
	private String ContinuumProject;
	@MapToColumn(column=5)
	private String ProjectType;
	@MapToColumn(column=6)
	private String ResidentialAffiliation;
	@MapToColumn(column=7)
	private String TrackingMethod;
	@MapToColumn(column=8)
	private String TargetPopulation;
	@MapToColumn(column=9)
	private String PITCount;
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
