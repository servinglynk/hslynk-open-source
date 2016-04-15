package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.BulkUploads;
import com.servinglynk.hmis.warehouse.core.model.Role;
import com.servinglynk.hmis.warehouse.model.base.HmisBulkUpload;
import com.servinglynk.hmis.warehouse.model.base.HmisUser;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.service.BulkUploadService;

@Service
public class BulkUploadServiceImpl extends ServiceBase implements BulkUploadService  {
	
	@Transactional
	public void createBulkUploadEntry(HmisBulkUpload uploadModel) throws Exception {
		try{
			
			HmisBulkUpload upload = new HmisBulkUpload();
			upload.setInputpath(uploadModel.getInputpath());
			upload.setStatus("INITIAL");
			upload.setDateCreated(LocalDateTime.now());
			upload.setDateUpdated(LocalDateTime.now());
			upload.setSync(false);
			upload.setSize(uploadModel.getSize());
			HmisUser user = daoFactory.getAccountDao().findByUsername(uploadModel.getUser().getUsername());
			ProjectGroupEntity projectGroupEntity = user.getProjectGroupEntity();
			upload.setUser(user);
			String projectGroupCode = projectGroupEntity.getProjectGroupCode();
			upload.setProjectGroupCode(projectGroupCode !=null ? projectGroupCode : uploadModel.getProjectGroupCode());
			daoFactory.getHmisBulkUploadDao().insert(upload);
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
			List<HmisBulkUpload> uploads = null; 
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
			for(HmisBulkUpload upload : uploads ){
				com.servinglynk.hmis.warehouse.core.model.BulkUpload bulkUpload = new com.servinglynk.hmis.warehouse.core.model.BulkUpload();
				bulkUpload.setFileSize(upload.getSize());
				bulkUpload.setInputPath(upload.getInputpath());
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
