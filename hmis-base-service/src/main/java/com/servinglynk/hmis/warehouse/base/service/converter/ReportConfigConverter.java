package com.servinglynk.hmis.warehouse.base.service.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hmis.warehouse.core.model.ReportConfig;
import com.servinglynk.hmis.warehouse.enums.ReportLevelEnum;
import com.servinglynk.hmis.warehouse.enums.ReportTypeEnum;
import com.servinglynk.hmis.warehouse.model.base.ReportConfigEntity;
import com.servinglynk.hmis.warehouse.model.base.ReportConfigParamEntity;

public class ReportConfigConverter {

	public static ReportConfig entityToModel(ReportConfigEntity reportConfigEntity){
		ReportConfig reportConfig = new ReportConfig();
		if(reportConfigEntity.getCocId()!= null)
			reportConfig.setCocId(String.valueOf(reportConfigEntity.getCocId()));
		reportConfig.setDateCreated(reportConfigEntity.getDateCreated());
		reportConfig.setDateUpdated(reportConfigEntity.getDateUpdated());
		reportConfig.setStartDate(reportConfigEntity.getStartDate());
		reportConfig.setEmailSent(reportConfigEntity.isEmailSent());
		reportConfig.setEndDate(reportConfigEntity.getEndDate());
		reportConfig.setId(reportConfigEntity.getId());
		reportConfig.setName(reportConfigEntity.getName());
		reportConfig.setProjectGroupCode(reportConfigEntity.getProjectGroupCode());
		reportConfig.setReportLevel(reportConfigEntity.getReportLevel().getValue());
		reportConfig.setReportType(reportConfigEntity.getReportType().getValue());
		reportConfig.setStatus(reportConfigEntity.getStatus());
		List<ReportConfigParamEntity> reportConfigParams = reportConfigEntity.getReportConfigParams();
		List<String> projectIds = new ArrayList<>();
		if(CollectionUtils.isNotEmpty(reportConfigParams)) {
			for(ReportConfigParamEntity  param : reportConfigParams) {
				if(StringUtils.equals("PROJECT_ID",param.getKey())) {
					projectIds.add(param.getValue());
				}
			}
		reportConfig.setProjectIds(projectIds);
		}
		return reportConfig;
	}

	
	public static ReportConfigEntity modelToEntity(ReportConfigEntity reportConfigEntity,ReportConfig reportConfig){
		if(reportConfigEntity==null){
			reportConfigEntity = new ReportConfigEntity();
		}
		if(StringUtils.isNotEmpty(reportConfig.getCocId())) {
			reportConfigEntity.setCocId(UUID.fromString(reportConfig.getCocId()));
		}
		if(reportConfig.getDateCreated() != null)
			reportConfigEntity.setDateCreated(reportConfig.getDateCreated());
		reportConfigEntity.setEmailSent(reportConfig.isEmailSent());
		reportConfigEntity.setEndDate(reportConfig.getEndDate());
		reportConfigEntity.setId(reportConfig.getId());
		reportConfigEntity.setName(reportConfig.getName());
		reportConfigEntity.setProjectGroupCode(reportConfig.getProjectGroupCode());
		if(StringUtils.isNotBlank(reportConfig.getReportLevel()))
			reportConfigEntity.setReportLevel(ReportLevelEnum.lookupEnum(reportConfig.getReportLevel()));
		if(StringUtils.isNotBlank(reportConfig.getReportType())) 
			reportConfigEntity.setReportType(ReportTypeEnum.lookupEnum(reportConfig.getReportType()));
		reportConfigEntity.setStartDate(reportConfig.getStartDate());
		reportConfigEntity.setStatus(reportConfig.getStatus());
		return reportConfigEntity;
	}
}
