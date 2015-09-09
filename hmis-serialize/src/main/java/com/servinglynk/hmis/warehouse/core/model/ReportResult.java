package com.servinglynk.hmis.warehouse.core.model;

import java.util.List;

public class ReportResult {
	
	 List<?>  reportData;
	 String  reportName;
	 String  reportTemplate;
	 String  reportLocation;
	 String  tempLocation;
	 
	 
	public List<?> getReportData() {
		return reportData;
	}
	public void setReportData(List<?> reportData) {
		this.reportData = reportData;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getReportTemplate() {
		return reportTemplate;
	}
	public void setReportTemplate(String reportTemplate) {
		this.reportTemplate = reportTemplate;
	}
	public String getReportLocation() {
		return reportLocation;
	}
	public void setReportLocation(String reportLocation) {
		this.reportLocation = reportLocation;
	}
	public String getTempLocation() {
		return tempLocation;
	}
	public void setTempLocation(String tempLocation) {
		this.tempLocation = tempLocation;
	}
	 
	 
	
	 
	 
}
