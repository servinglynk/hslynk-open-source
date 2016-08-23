package com.servinglynk.hmis.warehouse.base.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.base.service.BulkUploadService;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.BulkUploads;
import com.servinglynk.hmis.warehouse.core.model.Role;
import com.servinglynk.hmis.warehouse.model.base.BulkUpload;
import com.servinglynk.hmis.warehouse.model.base.HmisUser;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;

@Service
public class BulkUploadServiceImpl extends ServiceBase implements BulkUploadService  {
	private static final Logger logger = LoggerFactory
			.getLogger(BulkUploadServiceImpl.class);
	@Transactional
	public void createBulkUploadEntry(BulkUpload uploadModel, Account account) throws Exception {
		try{
			BulkUpload upload = new BulkUpload();
			upload.setInputpath(uploadModel.getInputpath());
			upload.setStatus("INITIAL");
			upload.setDateCreated(LocalDateTime.now());
			upload.setDateUpdated(LocalDateTime.now());
			upload.setSync(false);
			upload.setSize(uploadModel.getSize());
			upload.setYear(uploadModel.getYear());
			HmisUser user = daoFactory.getAccountDao().findByUsername(account.getUsername());
			ProjectGroupEntity projectGroupEntity = user.getProjectGroupEntity();
			upload.setUser(user);
			String projectGroupCode = projectGroupEntity.getProjectGroupCode();
			upload.setProjectGroupCode(projectGroupCode !=null ? projectGroupCode : uploadModel.getProjectGroupCode());
			daoFactory.getHmisBulkUploadDao().insert(upload);
		}catch(Exception e){
				logger.error("Upload Error {}",e.getMessage());
				throw new Exception("Bulk Upload Error"+ e.getMessage());
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
				bulkUpload.setFileSize(FileUtils.byteCountToDisplaySize(upload.getSize()));
				if(upload.getInputpath() != null){
					bulkUpload.setInputPath(StringUtils.substringAfterLast(upload.getInputpath(), "/"));
				}
				bulkUpload.setInputPath(upload.getInputpath());
				bulkUpload.setProjectGroupCode(upload.getProjectGroupCode());
				bulkUpload.setYear(upload.getYear());
			//	bulkUpload.setUsername(upload.getUser().getUsername());
				bulkUpload.setStatus(upload.getStatus());
				bulkUpload.setId(upload.getId());
				bulkUpload.setDescription(upload.getDescription());
				bulkUpload.setDateCreated(upload.getDateCreated());
				bulkUploads.addBulkUpload(bulkUpload);
			}
		        SortedPagination pagination = new SortedPagination();
		        pagination.setFrom(startIndex);
		        pagination.setReturned(bulkUploads.getBulkUploads().size());
		        //pagination.setTotal((int)count);
		        bulkUploads.setPagination(pagination);
		        return bulkUploads;
	}
	
	@Transactional
	public BulkUploads getRecentUploads(Account account, Integer startIndex, Integer maxItems) {
		HmisUser user = daoFactory.getAccountDao().findByUsername(account.getUsername());
		ProjectGroupEntity projectGroupEntity = user.getProjectGroupEntity();
		String projectGroupCode = projectGroupEntity.getProjectGroupCode();
		List<BulkUpload> uploads = null; 
		try {
				uploads = daoFactory.getBulkUploaderWorkerDao().getRecentUploads(projectGroupCode, user.getId(),startIndex,maxItems);
			}
		  catch(Exception e)  {
			  // Eating exception here, need to do something about it
			}
			BulkUploads bulkUploads = new BulkUploads();
			for(BulkUpload upload : uploads ){
				com.servinglynk.hmis.warehouse.core.model.BulkUpload bulkUpload = new com.servinglynk.hmis.warehouse.core.model.BulkUpload();
				bulkUpload.setFileSize(FileUtils.byteCountToDisplaySize(upload.getSize()));
				if(upload.getInputpath() !=null) {
					bulkUpload.setInputPath(StringUtils.substringAfterLast(upload.getInputpath(), "/"));
				}
				bulkUpload.setProjectGroupCode(upload.getProjectGroupCode());
				bulkUpload.setYear(upload.getYear());
				bulkUpload.setUsername(upload.getUser()!=null ? upload.getUser().getUsername() :"");
				bulkUpload.setStatus(upload.getStatus());
				bulkUpload.setId(upload.getId());
				bulkUpload.setDescription(upload.getDescription());
				bulkUpload.setDateCreated(upload.getDateCreated());
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
