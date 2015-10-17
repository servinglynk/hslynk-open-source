package com.servinglynk.hmis.warehouse.upload.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.servinglynk.hmis.warehouse.model.live.BulkUpload;
import com.servinglynk.hmis.warehouse.model.live.Sync;
import com.servinglynk.hmis.warehouse.upload.business.exception.ReportCreationException;
import com.servinglynk.hmis.warehouse.upload.business.exception.WorkerNotFoundException;
import com.servinglynk.hmis.warehouse.upload.business.service.core.ParentService;


@Service
public class BulkUploadService extends ParentService implements IBulkUploadService {

	public void createBulkUploadEntry(String filPath) throws WorkerNotFoundException, ReportCreationException{
		try{
			
			BulkUpload upload = new BulkUpload();
			upload.setInputPath(filPath);
			upload.setStatus("INITIAL");
			upload.setInsertAt(new Date());
			upload.setUpdateAt(new Date());
			upload.setInsertBy("ADMIN");
			upload.setUpdateBy("ADMIN");
			daoFactory.getBulkUploaderWorkerDao().insert(upload);
		}catch(WorkerNotFoundException e){
				throw new WorkerNotFoundException("Worker Not Found"+ e.getMessage());
		}catch(ReportCreationException e){
			throw new ReportCreationException("Error in creating Report"+ e.getMessage());
		}
	}


	public List<BulkUpload> getBulkUploads(String status) throws Exception {
		try{
			return daoFactory.getBulkUploaderWorkerDao().findBulkUploadByStatus(status);
		}catch(WorkerNotFoundException e){
				throw new WorkerNotFoundException("Worker Not Found"+ e.getMessage());
		}catch(ReportCreationException e){
			throw new ReportCreationException("Error in creating Report"+ e.getMessage());
		}
	}
	
	public List<Sync> getSyncs() {
		return daoFactory.getBulkUploaderWorkerDao().getSyncs();
	}

}
