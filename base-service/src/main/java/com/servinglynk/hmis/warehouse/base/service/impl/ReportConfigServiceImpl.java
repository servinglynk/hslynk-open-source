package com.servinglynk.hmis.warehouse.base.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.service.ReportConfigService;
import com.servinglynk.hmis.warehouse.base.service.converter.ReportConfigConverter;
import com.servinglynk.hmis.warehouse.core.model.ReportConfig;
import com.servinglynk.hmis.warehouse.core.model.ReportConfigs;
import com.servinglynk.hmis.warehouse.core.model.ReportProject;
import com.servinglynk.hmis.warehouse.model.base.HmisUser;
import com.servinglynk.hmis.warehouse.model.base.ReportConfigEntity;
import com.servinglynk.hmis.warehouse.model.base.ReportConfigParamEntity;

public class ReportConfigServiceImpl  extends ServiceBase implements ReportConfigService {

	@Override
	@Transactional
	public ReportConfig createReportConfig(ReportConfig reportConfig, String caller) {
		ReportConfigEntity reportConfigEntity = new ReportConfigEntity();
		reportConfig.setCreatedBy(caller);
		reportConfig.setUpdatedBy(caller);
		reportConfig.setStatus("INITIAL");
		HmisUser user = daoFactory.getAccountDao().findByUsername(caller);
		reportConfig.setProjectGroupCode(user.getProjectGroupCode());
		ReportConfigEntity modelToEntity = ReportConfigConverter.modelToEntity(reportConfigEntity, reportConfig);
		ReportConfigEntity createReportConfig = daoFactory.getReportConfigDao().createReportConfig(modelToEntity);
		List<ReportProject> reportProjects = reportConfig.getProjectIds();
		if(CollectionUtils.isNotEmpty(reportProjects)) {
			 for(ReportProject reportProject : reportProjects) {
				 ReportConfigParamEntity reportConfigParamEntity = new ReportConfigParamEntity();
				 reportConfigParamEntity.setCreatedBy(caller);
				 reportConfigParamEntity.setUpdatedBy(caller);
				 reportConfigParamEntity.setKey("PROJECT_ID");
				 reportConfigParamEntity.setValue(reportProject.getProjectId());
				 reportConfigParamEntity.setReportConfig(createReportConfig);
				 reportConfigParamEntity.setStatus("ACTIVE");
				 daoFactory.getReportConfigParamDao().createReportConfigParam(reportConfigParamEntity);
			 }
		 }
		return ReportConfigConverter.entityToModel(createReportConfig);
	}

	@Override
	@Transactional
	public ReportConfig updateReportConfig(Long reportConfigId, ReportConfig reportConfig, String caller) {
		ReportConfigEntity reportConfigByid = daoFactory.getReportConfigDao().getReportConfigByid(reportConfigId);
		ReportConfigEntity modelToEntity = ReportConfigConverter.modelToEntity(reportConfigByid, reportConfig);
		ReportConfigEntity updatedReportConfig = daoFactory.getReportConfigDao().updateReportConfig(modelToEntity);
		return ReportConfigConverter.entityToModel(updatedReportConfig);
	}

	@Override
	@Transactional
	public ReportConfig deleteReportConfig(Long reportConfigId) {
		ReportConfigEntity reportConfigByid = daoFactory.getReportConfigDao().getReportConfigByid(reportConfigId);
		if(reportConfigByid != null) {
			daoFactory.getReportConfigDao().deleteReportConfig(reportConfigByid);
		}
		return ReportConfigConverter.entityToModel(reportConfigByid);
	}

	@Override
	@Transactional
	public ReportConfig getReportConfigById(Long reportConfigid) {
		ReportConfigEntity reportConfigByid = daoFactory.getReportConfigDao().getReportConfigByid(reportConfigid);
		return ReportConfigConverter.entityToModel(reportConfigByid);
	}

	@Override
	@Transactional
	public ReportConfigs getReportConfigsByUser(Integer startIndex, Integer maxItems,String caller) {
		List<ReportConfigEntity> reportConfigsEntity = daoFactory.getReportConfigDao().getReportConfigByUsername(caller);
		ReportConfigs reportConfigs = new ReportConfigs();
		List<ReportConfig> reportConfigList = new ArrayList<>();
		if(CollectionUtils.isNotEmpty(reportConfigsEntity)) {
			for(ReportConfigEntity reportConfigEntity : reportConfigsEntity) {
				reportConfigList.add(ReportConfigConverter.entityToModel(reportConfigEntity));
			}
		}
		reportConfigs.setReportConfigs(reportConfigList);
		return reportConfigs;
	}
	@Override
	@Transactional
	public ReportConfigs getAllReportConfigs(Integer startIndex, Integer maxItems) {
		return null;
	}

}
