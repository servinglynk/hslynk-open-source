package com.servinglynk.hmis.warehouse.report.business.service.core;

import com.servinglynk.hmis.warehouse.report.service.IReportService;
import com.servinglynk.hmis.warehouse.report.service.IWorkerService;

public interface IParentServiceFactory {
	IReportService getReportService();
	IWorkerService getWorkerService();
}
