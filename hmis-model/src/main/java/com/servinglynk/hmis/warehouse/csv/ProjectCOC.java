package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;

public class ProjectCOC {
	@MapToColumn(column=0)
	private String ProjectCocID;
	@MapToColumn(column=1)
	private String ProjectID;
	@MapToColumn(column=2)
	private String CoCCode;
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
