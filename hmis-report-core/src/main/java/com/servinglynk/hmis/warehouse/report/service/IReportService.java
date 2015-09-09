package com.servinglynk.hmis.warehouse.report.service;

import com.servinglynk.hmis.warehouse.core.model.ReportRequest;
import com.servinglynk.hmis.warehouse.report.business.service.core.IParentService;


public interface IReportService extends IParentService {

	public void createReportRequest(ReportRequest reportRequest);
}
