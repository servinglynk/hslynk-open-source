package com.servinglynk.hmis.warehouse.base.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.ReportConfig;
import com.servinglynk.hmis.warehouse.core.model.ReportConfigs;

public interface ReportConfigService {
	ReportConfig createReportConfig(ReportConfig ReportConfig, String caller);
	ReportConfig updateReportConfig(UUID ReportConfigid ,ReportConfig ReportConfig, String caller);
	ReportConfig deleteReportConfig(UUID ReportConfigId);
	public ReportConfig getReportConfigById(UUID ReportConfigid);
	ReportConfigs getAllReportConfigs(Integer startIndex, Integer maxItems);
}
