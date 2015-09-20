package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;
										

public class Funder {
	@MapToColumn(column=0)
	private String FunderID;
	@MapToColumn(column=1)
	private String ProjectID;
	@MapToColumn(column=2)
	private String Funder;
	@MapToColumn(column=3)
	private String GrantID;
	@MapToColumn(column=4)
	private String StartDate;
	@MapToColumn(column=5)
	private String EndDate;
	@MapToColumn(column=6)
	private String DateCreated;
	@MapToColumn(column=7)
	private String DateUpdated;
	@MapToColumn(column=8)
	private String UserID;
	@MapToColumn(column=9)
	private String DateDeleted;
	@MapToColumn(column=10)
	private String ExportID;
}
