package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.servinglynk.hmis.warehouse.PaginatedModel;

public class ReportConfigs  extends PaginatedModel {
	@JsonProperty("reportConfigs")
	private List<ReportConfig> reportConfigs = new ArrayList<ReportConfig>();

	public List<ReportConfig> getReportConfigs() {
		return reportConfigs;
	}

	public void setReportConfigs(List<ReportConfig> reportConfigs) {
		this.reportConfigs = reportConfigs;
	}
	
	public void addReportConfig(ReportConfig reportConfig) {
		this.reportConfigs.add(reportConfig);
	}
}
