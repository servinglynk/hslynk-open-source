package com.servinglynk.hmis.warehouse.report.business.util;

public enum ReportType {
	AHAR_REPORT("AHAR_REPORT");
 
	private String reportType;
 
	private ReportType(String s) {
		reportType = s;
	}
 
	public String getReportType() {
		return reportType;
	}
}
