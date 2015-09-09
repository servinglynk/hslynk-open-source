package com.servinglynk.hmis.warehouse.report.service;

import org.springframework.stereotype.Service;

import com.servinglynk.hmis.warehouse.core.model.ReportRequest;
import com.servinglynk.hmis.warehouse.core.model.WorkerLine;
import com.servinglynk.hmis.warehouse.report.business.exception.ReportCreationException;
import com.servinglynk.hmis.warehouse.report.business.exception.WorkerNotFoundException;
import com.servinglynk.hmis.warehouse.report.business.service.core.ParentService;
import com.servinglynk.hmis.warehouse.report.business.util.Workers;


@Service
public class ReportService extends ParentService implements IReportService {

	public void createReportRequest(ReportRequest reportRequest) throws WorkerNotFoundException, ReportCreationException{
		try{
			
				WorkerLine wl = new WorkerLine();
				wl.setWorkerHeaderId(Workers.REPORT_WORKER.toString());
				wl.setInput(reportRequest.toString());
				serviceFactory.getWorkerService().createWorkerLine(wl);
				
		}catch(WorkerNotFoundException e){
				throw new WorkerNotFoundException("Worker Not Found"+ e.getMessage());
		}catch(ReportCreationException e){
			throw new ReportCreationException("Error in creating Report"+ e.getMessage());
		}
	}



}
