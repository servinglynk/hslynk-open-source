package com.servinglynk.hmis.warehouse.upload.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.servinglynk.hmis.warehouse.model.v2014.BulkUpload;
import com.servinglynk.hmis.warehouse.model.v2014.Sync;
import com.servinglynk.hmis.warehouse.upload.business.exception.ReportCreationException;
import com.servinglynk.hmis.warehouse.upload.business.exception.WorkerNotFoundException;
import com.servinglynk.hmis.warehouse.upload.business.service.core.ParentService;


@Service
public class BulkUploadService extends ParentService implements IBulkUploadService {

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
		return null;
	}

}
