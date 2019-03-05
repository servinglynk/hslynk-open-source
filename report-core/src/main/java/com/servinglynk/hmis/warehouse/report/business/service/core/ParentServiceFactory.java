package com.servinglynk.hmis.warehouse.report.business.service.core;

import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.report.service.IReportService;
import com.servinglynk.hmis.warehouse.report.service.IReportWorker;
import com.servinglynk.hmis.warehouse.report.service.IWorkerService;



public class ParentServiceFactory  implements IParentServiceFactory {

	@Autowired
	IReportService reportService;

	public IReportService getReportService() {
		return reportService;
	}
	
	
	@Autowired
	IWorkerService workerService;

	
	public IWorkerService getWorkerService() {
		return workerService;
	}

	
	@Autowired
	IReportWorker reportWorker;

	public IReportWorker getReportWorker() {
		return reportWorker;
	}

	
}

