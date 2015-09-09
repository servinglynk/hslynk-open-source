package com.servinglynk.hmis.warehouse.report.service;

import com.servinglynk.hmis.warehouse.core.model.WorkerLine;
import com.servinglynk.hmis.warehouse.report.business.exception.WorkerNotFoundException;
import com.servinglynk.hmis.warehouse.report.business.service.core.IParentService;

public interface IWorkerService extends IParentService{
	
	public void createWorkerLine(WorkerLine workerLine) throws WorkerNotFoundException;
	public void processWorkerLine() throws WorkerNotFoundException;

}