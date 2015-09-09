package com.servinglynk.hmis.warehouse.report.request.handler;

import com.servinglynk.hmis.warehouse.core.model.ReportHeader;
import com.servinglynk.hmis.warehouse.core.model.ReportRequest;
import com.servinglynk.hmis.warehouse.core.model.ReportResult;
import com.servinglynk.hmis.warehouse.report.business.service.core.IParentService;

public interface IReportRequestHandler extends IParentService{
	
	 public ReportResult createReport(ReportRequest reportRequest, ReportHeader reportHeader) throws Exception;
	
}
