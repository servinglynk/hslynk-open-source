package com.servinglynk.hmis.warehouse.report.core;

import com.servinglynk.hmis.warehouse.core.model.ReportResult;

public interface IReportGeneratorHandler {

	
	public ReportResult reportPrint(ReportResult reportResult);
}
