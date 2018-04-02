package com.servinglynk.hmis.warehouse.base.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.base.service.BulkUploadService;
import com.servinglynk.hmis.warehouse.base.service.converter.BulkUploadConverter;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.BulkUploads;
import com.servinglynk.hmis.warehouse.core.model.Role;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.model.base.BulkUpload;
import com.servinglynk.hmis.warehouse.model.base.HmisUser;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.service.exception.ResourceNotFoundException;

@Service
public class BulkUploadServiceImpl extends ServiceBase implements BulkUploadService  {
	private static final Logger logger = LoggerFactory
			.getLogger(BulkUploadServiceImpl.class);
	@Transactional
	public com.servinglynk.hmis.warehouse.core.model.BulkUpload createBulkUploadEntry(com.servinglynk.hmis.warehouse.core.model.BulkUpload model, Account account) throws Exception {
		try{
			BulkUpload entity = BulkUploadConverter.modelToEntity(model, null);
			HmisUser user = daoFactory.getAccountDao().findByUsername(account.getUsername());
			ProjectGroupEntity projectGroupEntity = user.getProjectGroupEntity();
			entity.setUser(user);
			String projectGroupCode = projectGroupEntity.getProjectGroupCode();
			entity.setProjectGroupCode(projectGroupCode !=null ? projectGroupCode : model.getProjectGroupCode());
			entity.setDateCreated(LocalDateTime.now());
			daoFactory.getBulkUploaderWorkerDao().insert(entity);
			return BulkUploadConverter.entityToModel(entity, model);
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
		Role role = account.getRoles()!=null ? account.getRoles().get(0):null;
		List<BulkUpload> uploads = null; 
		if(role != null) {
			try {
				if(StringUtils.equalsIgnoreCase("CUSTADMIN",role.getRoleName()))
					uploads = daoFactory.getBulkUploaderWorkerDao().findBulkUploadForCustAdmin(status,projectGroupCode);
				else if(StringUtils.equalsIgnoreCase("SUPERADMIN",role.getRoleName())) {
					uploads = daoFactory.getBulkUploaderWorkerDao().findBulkUploadFoSuperAdmin(status);
				}else{
					uploads = daoFactory.getBulkUploaderWorkerDao().findBulkUploadForDevelopers(status, user.getId(), projectGroupCode);
				}
					
			}catch (Exception e) {
				logger.error("Some issues trying to get project groups"+e.getMessage());
				}
			BulkUploads bulkUploads = new BulkUploads();
			if(uploads != null) {
				for(BulkUpload upload : uploads ){
					com.servinglynk.hmis.warehouse.core.model.BulkUpload model = new com.servinglynk.hmis.warehouse.core.model.BulkUpload();
					bulkUploads.addBulkUpload(BulkUploadConverter.entityToModel(upload, model));
				}
			        SortedPagination pagination = new SortedPagination();
			        pagination.setFrom(startIndex);
			        int count = bulkUploads.getBulkUploads() != null ? bulkUploads.getBulkUploads().size() : 0;
			        pagination.setReturned(count);
			        pagination.setTotal(count);
			        bulkUploads.setPagination(pagination);
			        return bulkUploads;
			}
		}
			return null;
	}
	
	@Transactional
	public BulkUploads getRecentUploads(Account account, Integer startIndex, Integer maxItems) {
		HmisUser user = daoFactory.getAccountDao().findByUsername(account.getUsername());
		ProjectGroupEntity projectGroupEntity = user.getProjectGroupEntity();
		String projectGroupCode = projectGroupEntity.getProjectGroupCode();
		List<BulkUpload> uploads = null; 
		try {
				uploads = daoFactory.getBulkUploaderWorkerDao().getRecentUploads(projectGroupCode,user.getId(),startIndex,maxItems);
			}
		  catch(Exception e)  {
			  // Eating exception here, need to do something about it
			}
			BulkUploads bulkUploads = new BulkUploads();
			for(BulkUpload upload : uploads ){
				bulkUploads.addBulkUpload(BulkUploadConverter.entityToModel(upload,null));
			}
		        SortedPagination pagination = new SortedPagination();
		        pagination.setFrom(startIndex);
		        int count = bulkUploads.getBulkUploads() != null ? bulkUploads.getBulkUploads().size() : 0;
		        pagination.setReturned(count);
		        pagination.setTotal(count);
		        bulkUploads.setPagination(pagination);
		        return bulkUploads;
	}
	
	@Transactional
	public com.servinglynk.hmis.warehouse.core.model.BulkUpload updateBulkUpload(com.servinglynk.hmis.warehouse.core.model.BulkUpload upload,String username) {
		BulkUpload entity = daoFactory.getBulkUploaderWorkerDao().getBulkUploadId(upload.getId());
		if(entity == null) throw new ResourceNotFoundException("Bulk Upload not found "+upload.getId());
		BulkUploadConverter.modelToEntity(upload, entity);
		entity.setUser(daoFactory.getHmisUserDao().findByUsername(username));
		entity.setDateUpdated(LocalDateTime.now());
		daoFactory.getBulkUploaderWorkerDao().updateBulkUpload(entity);
		entity.setId(entity.getId());
		return upload;
	}

	@Transactional
	public void deleteBulkUpload(Long bulkUploadId,String username) {
		BulkUpload entity = daoFactory.getBulkUploaderWorkerDao().getBulkUploadId(bulkUploadId);
		if(entity == null) throw new ResourceNotFoundException(" Bulk Upload not found  "+bulkUploadId);
		entity.setUser(daoFactory.getHmisUserDao().findByUsername(username));
		entity.setDateUpdated(LocalDateTime.now());
		entity.setDeleted(true);
		daoFactory.getBulkUploaderWorkerDao().delete(entity);
	}

	@Transactional
	public com.servinglynk.hmis.warehouse.core.model.BulkUpload getBulkUploadId(Long bulkUploadId) {
		BulkUpload entity = daoFactory.getBulkUploaderWorkerDao().getBulkUploadId(bulkUploadId);
		if(entity == null) throw new ResourceNotFoundException(" Bulk Upload not found "+bulkUploadId);
		return BulkUploadConverter.entityToModel(entity,null);
	}

}
