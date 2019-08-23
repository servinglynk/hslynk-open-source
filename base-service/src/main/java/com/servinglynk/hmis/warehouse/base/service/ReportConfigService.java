package com.servinglynk.hmis.warehouse.base.service;

import com.servinglynk.hmis.warehouse.core.model.ReportConfig;
import com.servinglynk.hmis.warehouse.core.model.ReportConfigs;

public interface ReportConfigService {
	ReportConfig createReportConfig(ReportConfig ReportConfig, String caller);
	ReportConfig updateReportConfig(Long ReportConfigid ,ReportConfig ReportConfig, String caller);
	ReportConfig deleteReportConfig(Long ReportConfigId);
	public ReportConfig getReportConfigById(Long ReportConfigid);
	ReportConfigs getAllReportConfigs(Integer startIndex, Integer maxItems);
	public ReportConfigs getReportConfigsByUser(Integer startIndex, Integer maxItems,String caller);
	ReportConfigs getReportConfigByStatusEmailSent(String status, boolean emailSent);
}
