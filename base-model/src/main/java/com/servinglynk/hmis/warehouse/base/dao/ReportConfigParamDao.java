package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.model.base.ReportConfigParamEntity;

public interface ReportConfigParamDao {

	ReportConfigParamEntity createReportConfigParam(ReportConfigParamEntity reportConfigParamEntity);

	ReportConfigParamEntity updateReportConfigParam(ReportConfigParamEntity reportConfigParamEntity);

	void deleteReportConfigParam(ReportConfigParamEntity reportConfigParamEntity);

	ReportConfigParamEntity getReportConfigParamByid(Long id);
	
	List<ReportConfigParamEntity> getReportConfigParams(Long reportConfigId);
}
