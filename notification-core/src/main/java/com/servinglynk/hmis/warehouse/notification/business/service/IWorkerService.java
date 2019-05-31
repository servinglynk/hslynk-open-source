package com.servinglynk.hmis.warehouse.notification.business.service;

import com.servinglynk.hmis.warehouse.core.model.WorkerLine;
import com.servinglynk.hmis.warehouse.notification.business.exception.WorkerNotFoundException;
import com.servinglynk.hmis.warehouse.notification.business.service.core.IParentService;

public interface IWorkerService extends IParentService{
	
	public void createWorkerLine(WorkerLine workerLine) throws WorkerNotFoundException;
	public void processWorkerLine() throws WorkerNotFoundException;

}