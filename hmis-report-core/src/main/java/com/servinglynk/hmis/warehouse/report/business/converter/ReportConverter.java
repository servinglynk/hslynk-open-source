package com.servinglynk.hmis.warehouse.report.business.converter;

import com.servinglynk.hmis.warehouse.core.model.ReportHeader;
import com.servinglynk.hmis.warehouse.core.model.ReportLine;
import com.servinglynk.hmis.warehouse.report.persistence.entity.ReportHeaderEntity;
import com.servinglynk.hmis.warehouse.report.persistence.entity.ReportLineEntity;

public class ReportConverter {

	
	public static ReportHeader convertEntityToModel(ReportHeaderEntity reportHeaderEntity) {
		ReportHeader reportHeader = new ReportHeader();
		reportHeader.setReportNamePrefix(reportHeaderEntity.getReportNamePrefix());
		reportHeader.setReportTemplate(reportHeaderEntity.getReportTemplate());
		reportHeader.setReportLocation(reportHeaderEntity.getReportLocation());
		reportHeader.setFriendlyName(reportHeaderEntity.getFriendlyName());
		reportHeader.setName(reportHeaderEntity.getName());
		reportHeader.setVersion(reportHeaderEntity.getVersion());
		reportHeader.setTempLocation(reportHeaderEntity.getTempLocation());
		reportHeader.setOutputType(reportHeaderEntity.getOutputType());
		reportHeader.setExternalId(reportHeaderEntity.getExternalId());
		return reportHeader;
	}
	
	public static ReportLine convertEntityToModel(ReportLineEntity reportLineEntity) {
		ReportLine nl = new ReportLine();
		return nl;
	}
	
	
	public static ReportLineEntity convertModelToEntity(ReportLine companyModel,ReportLineEntity nlEntity) {
	return nlEntity;
	}
	
	
}