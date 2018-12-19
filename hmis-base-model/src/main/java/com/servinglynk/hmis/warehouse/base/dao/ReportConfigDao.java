package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.model.base.ReportConfigEntity;

public interface ReportConfigDao {

	ReportConfigEntity createReportConfig(ReportConfigEntity reportConfigEntity);

	ReportConfigEntity updateReportConfig(ReportConfigEntity reportConfigEntity);

	void deleteReportConfig(ReportConfigEntity reportConfigEntity);

	ReportConfigEntity getReportConfigByid(Long id);

	List<ReportConfigEntity> getReportConfigs(String projectGroupCode);

	List<ReportConfigEntity> getReportConfigByUsername(String username);
}
