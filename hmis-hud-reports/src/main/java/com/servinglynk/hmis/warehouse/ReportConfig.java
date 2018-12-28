package com.servinglynk.hmis.warehouse;

import java.sql.Date;
import java.util.List;

public class ReportConfig {
	private Long id;
	private String projectGroupCode;
	private List<String> projectds;
	private Date startDate;
	private Date endDate;
	
	private boolean isSageReport;
	public ReportConfig() {
	}
	public ReportConfig(Long id, String projectGroupCode, List<String> projectds, Date startDate, Date endDate,
			boolean isSageReport) {
		super();
		this.id = id;
		this.projectGroupCode = projectGroupCode;
		this.projectds = projectds;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isSageReport = isSageReport;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProjectGroupCode() {
		return projectGroupCode;
	}
	public void setProjectGroupCode(String projectGroupCode) {
		this.projectGroupCode = projectGroupCode;
	}
	public List<String> getProjectds() {
		return projectds;
	}
	public void setProjectds(List<String> projectds) {
		this.projectds = projectds;
	}
	public boolean isSageReport() {
		return isSageReport;
	}
	public void setSageReport(boolean isSageReport) {
		this.isSageReport = isSageReport;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
