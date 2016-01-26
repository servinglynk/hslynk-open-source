package com.servinglynk.hmis.warehouse.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.model.live.BulkUpload;
import com.servinglynk.hmis.warehouse.service.BulkUploadService;

@Service
public class BulkUploadServiceImpl extends ServiceBase implements BulkUploadService  {
	
	@Transactional
	public void createBulkUploadEntry(String filPath) throws Exception {
		try{
			
			BulkUpload upload = new BulkUpload();
			upload.setInputPath(filPath);
			upload.setStatus("INITIAL");
			upload.setInsertAt(new Date());
			upload.setUpdateAt(new Date());
			upload.setInsertBy("ADMIN");
			upload.setUpdateBy("ADMIN");
			daoFactory.getBulkUploaderWorkerDao().insert(upload);
		}catch(Exception e){
				throw new Exception("Worker Not Found"+ e.getMessage());
		}
	}
}
