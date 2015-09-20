package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;

public class Export {
	@MapToColumn(column=0)
	private String ExportID;
	@MapToColumn(column=1)
	private String SourceID;
	@MapToColumn(column=2)
	private String SourceName;
	@MapToColumn(column=3)
	private String SourceContactFirst;
	@MapToColumn(column=4)
	private String SourceContactLast;
	@MapToColumn(column=5)
	private String SourceContactPhone;
	@MapToColumn(column=6)
	private String SourceContactExtension;
	@MapToColumn(column=7)
	private String SourceContactEmail;
	@MapToColumn(column=8)
	private String ExportDate;
	@MapToColumn(column=9)
	private String ExportStartDate;
	@MapToColumn(column=10)
	private String ExportEndDate;
	@MapToColumn(column=11)
	private String SoftwareName;
	@MapToColumn(column=12)
	private String SoftwareVersion;
		
	@MapToColumn(column=13)
	private String ExportPeriodType;
	@MapToColumn(column=14)
	private String ExportDirective;
	@MapToColumn(column=15)
	private String HashStatus;
	
		
}
