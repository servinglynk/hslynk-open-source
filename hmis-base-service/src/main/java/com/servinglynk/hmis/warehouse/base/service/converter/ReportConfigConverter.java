package com.servinglynk.hmis.warehouse.base.service.converter;

import com.servinglynk.hmis.warehouse.core.model.ReportConfig;
import com.servinglynk.hmis.warehouse.model.base.ReportConfigEntity;

public class ReportConfigConverter {

	public static ReportConfig entityToModel(ReportConfigEntity reportConfigEntity){
		ReportConfig reportConfig = new ReportConfig();
		return reportConfig;
	}

	
	public static ReportConfigEntity modelToEntity(ReportConfigEntity reportConfigEntity,ReportConfig reportConfig){
		if(reportConfigEntity==null){
			reportConfigEntity = new ReportConfigEntity();
		}
		return reportConfigEntity;
	}
}
