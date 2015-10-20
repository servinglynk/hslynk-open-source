package com.servinglynk.hmis.warehouse.report.service;

import com.servinglynk.hmis.warehouse.report.business.service.core.IParentService;


public interface IReportWorker  extends IParentService  {
	
	
	
	public void processReportWorkerLine() throws Exception;
	//public void processMacroWorkerLine() throws Exception;
	

}
