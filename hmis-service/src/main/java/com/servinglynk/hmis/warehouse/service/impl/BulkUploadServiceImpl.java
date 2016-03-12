package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.BulkUploads;
import com.servinglynk.hmis.warehouse.core.model.Connectionwithsoars;
import com.servinglynk.hmis.warehouse.core.model.Role;
import com.servinglynk.hmis.warehouse.model.live.BulkUpload;
import com.servinglynk.hmis.warehouse.model.live.HmisUser;
import com.servinglynk.hmis.warehouse.model.live.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.service.BulkUploadService;
import com.servinglynk.hmis.warehouse.service.converter.ConnectionwithsoarConverter;

@Service
public class BulkUploadServiceImpl extends ServiceBase implements BulkUploadService  {
	
	@Transactional
	public void createBulkUploadEntry(com.servinglynk.hmis.warehouse.core.model.BulkUpload uploadModel) throws Exception {
		try{
			
			BulkUpload upload = new BulkUpload();
			upload.setInputPath(uploadModel.getInputPath());
			upload.setStatus("INITIAL");
			upload.setDateCreated(LocalDateTime.now());
			upload.setDateUpdated(LocalDateTime.now());
			upload.setSync(false);
			upload.setSize(uploadModel.getFileSize());
			HmisUser user = daoFactory.getAccountDao().findByUsername(uploadModel.getUsername());
			ProjectGroupEntity projectGroupEntity = user.getProjectGroupEntity();
		//	upload.setUser(user);
			String projectGroupCode = projectGroupEntity.getProjectGroupCode();
			upload.setProjectGroupCode(projectGroupCode !=null ? projectGroupCode : uploadModel.getProjectGroupCode());
			daoFactory.getBulkUploaderWorkerDao().insert(upload);
		}catch(Exception e){
				throw new Exception("Worker Not Found"+ e.getMessage());
		}
	}
	@Transactional
	public BulkUploads getBulkUploadsByStatus(String status, Account account, Integer startIndex, Integer maxItems) {
		HmisUser user = daoFactory.getAccountDao().findByUsername(account.getUsername());
		ProjectGroupEntity projectGroupEntity = user.getProjectGroupEntity();
		String projectGroupCode = projectGroupEntity.getProjectGroupCode();
		 Role role = account.getRoles()!=null ? account.getRoles().getRoles().get(0):null;
			List<BulkUpload> uploads = null; 
			try {
		if(role != null) {
			 if("CUSTADMIN".equals(role.getRoleName())) 
				 uploads = daoFactory.getBulkUploaderWorkerDao().findBulkUploadForCustAdmin(status, user.getId(), projectGroupCode);
			 else if ("SUPERADMIN".equals(role.getRoleName()))
				 uploads = daoFactory.getBulkUploaderWorkerDao().findBulkUploadFoSuperAdmin(status);
		}else
			 uploads = daoFactory.getBulkUploaderWorkerDao().findBulkUploadForDevelopers(status, user.getId(), projectGroupCode);
			}catch(Exception e) {
				logger.error("Some issues trying to get project groups"+e.getMessage());
			}
			BulkUploads bulkUploads = new BulkUploads();
			for(BulkUpload upload : uploads ){
				com.servinglynk.hmis.warehouse.core.model.BulkUpload bulkUpload = new com.servinglynk.hmis.warehouse.core.model.BulkUpload();
				bulkUpload.setFileSize(upload.getSize());
				bulkUpload.setInputPath(upload.getInputPath());
				bulkUpload.setProjectGroupCode(upload.getProjectGroupCode());
			//	bulkUpload.setUsername(upload.getUser().getUsername());
				bulkUpload.setStatus(upload.getStatus());
				bulkUpload.setDescription(upload.getDescription());
				bulkUploads.addBulkUpload(bulkUpload);
			}
		        SortedPagination pagination = new SortedPagination();
		        pagination.setFrom(startIndex);
		        pagination.setReturned(bulkUploads.getBulkUploads().size());
		        //pagination.setTotal((int)count);
		        bulkUploads.setPagination(pagination);
		        return bulkUploads;
	}
}
