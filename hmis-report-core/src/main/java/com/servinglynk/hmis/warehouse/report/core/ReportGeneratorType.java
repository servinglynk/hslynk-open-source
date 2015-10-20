package com.servinglynk.hmis.warehouse.report.core;

public enum ReportGeneratorType {

	PDF ("PDF"),
	XL ("XL");
	 
	private String reportType;
 
	private ReportGeneratorType(String s) {
		reportType = s;
	}
 
	public static ReportGeneratorType getReportType(String s) {
		return ReportGeneratorType.valueOf(s);
	}
	
}
