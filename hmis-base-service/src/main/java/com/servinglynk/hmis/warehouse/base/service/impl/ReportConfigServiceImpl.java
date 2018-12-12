package com.servinglynk.hmis.warehouse.base.service.impl;

import com.servinglynk.hmis.warehouse.base.service.ReportConfigService;
import com.servinglynk.hmis.warehouse.base.service.converter.ReportConfigConverter;
import com.servinglynk.hmis.warehouse.core.model.ReportConfig;
import com.servinglynk.hmis.warehouse.core.model.ReportConfigs;
import com.servinglynk.hmis.warehouse.model.base.ReportConfigEntity;

public class ReportConfigServiceImpl  extends ServiceBase implements ReportConfigService {

	@Override
	public ReportConfig createReportConfig(ReportConfig reportConfig, String caller) {
		ReportConfigEntity reportConfigEntity = new ReportConfigEntity();
		ReportConfigEntity modelToEntity = ReportConfigConverter.modelToEntity(reportConfigEntity, reportConfig);
		ReportConfigEntity createReportConfig = daoFactory.getReportConfigDao().createReportConfig(modelToEntity);
		return ReportConfigConverter.entityToModel(createReportConfig);
	}

	@Override
	public ReportConfig updateReportConfig(Long reportConfigId, ReportConfig reportConfig, String caller) {
		ReportConfigEntity reportConfigByid = daoFactory.getReportConfigDao().getReportConfigByid(reportConfigId);
		ReportConfigEntity modelToEntity = ReportConfigConverter.modelToEntity(reportConfigByid, reportConfig);
		ReportConfigEntity updatedReportConfig = daoFactory.getReportConfigDao().updateReportConfig(modelToEntity);
		return ReportConfigConverter.entityToModel(updatedReportConfig);
	}

	@Override
	public ReportConfig deleteReportConfig(Long reportConfigId) {
		ReportConfigEntity reportConfigByid = daoFactory.getReportConfigDao().getReportConfigByid(reportConfigId);
		if(reportConfigByid != null) {
			daoFactory.getReportConfigDao().deleteReportConfig(reportConfigByid);
		}
		return ReportConfigConverter.entityToModel(reportConfigByid);
	}

	@Override
	public ReportConfig getReportConfigById(Long reportConfigid) {
		ReportConfigEntity reportConfigByid = daoFactory.getReportConfigDao().getReportConfigByid(reportConfigid);
		return ReportConfigConverter.entityToModel(reportConfigByid);
	}

	@Override
	public ReportConfigs getAllReportConfigs(Integer startIndex, Integer maxItems) {
		return null;
	}

}
