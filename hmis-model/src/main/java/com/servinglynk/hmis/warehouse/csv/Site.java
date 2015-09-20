package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;

public class Site {
	@MapToColumn(column=0)
	private String SiteID;
	@MapToColumn(column=1)
	private String ProjectID;
	@MapToColumn(column=2)
	private String CoCCode;
	@MapToColumn(column=3)
	private String PrincipalSite;
	@MapToColumn(column=4)
	private String Geocode;
	@MapToColumn(column=5)
	private String Address;
	@MapToColumn(column=6)
	private String City;
	@MapToColumn(column=7)
	private String State;
	@MapToColumn(column=8)
	private String ZIP;
	@MapToColumn(column=9)
	private String DateCreated;
	@MapToColumn(column=10)
	private String DateUpdated;
	@MapToColumn(column=11)
	private String UserID;
	@MapToColumn(column=12)
	private String DateDeleted;
	@MapToColumn(column=13)
	private String ExportID;;
}
