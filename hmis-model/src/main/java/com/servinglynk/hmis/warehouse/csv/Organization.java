package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;

public class Organization {
	@MapToColumn(column=0)
	private String OrganizationID;
	@MapToColumn(column=1)
	private String OrganizationName;
	@MapToColumn(column=2)
	private String OrganizationCommonName;
	@MapToColumn(column=3)
	private String DateCreated;
	@MapToColumn(column=4)
	private String DateUpdated;
	@MapToColumn(column=5)
	private String UserID;
	@MapToColumn(column=6)
	private String DateDeleted;
	@MapToColumn(column=7)
	private String ExportID;
		
}
