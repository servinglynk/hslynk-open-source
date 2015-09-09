package com.servinglynk.hmis.warehouse.notification.business.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.core.model.ReportRequest;
import com.servinglynk.hmis.warehouse.report.business.service.core.ParentServiceFactory;


public class ReportCreationUtil implements IReportCreationUtil {
	
	public ParentServiceFactory getServiceFactory() {
		return serviceFactory;
	}

	public void setServiceFactory(ParentServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}

	@Autowired
	 ParentServiceFactory serviceFactory;


	public void createReportRequest(ReportRequest reportRequest) {
		createWorkerLine(reportRequest);
	}
	
	
	protected  void createWorkerLine(ReportRequest reportRequest){
	
	}

	
}
