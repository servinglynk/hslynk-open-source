package com.servinglynk.hmis.warehouse.base.service.converter;

import org.apache.commons.io.FileUtils;

import com.servinglynk.hmis.warehouse.core.model.BulkUpload;

public class BulkUploadConverter {
	
	public static BulkUpload entityToModel(com.servinglynk.hmis.warehouse.model.base.BulkUpload entity,BulkUpload model){
		if(model == null) model = new BulkUpload();	
		model.setProjectGroupCode(entity.getProjectGroupCode());
		model.setYear(entity.getYear());
		model.setStatus(entity.getStatus());
		model.setId(entity.getId());
		model.setDescription(entity.getDescription());
		model.setDateCreated(entity.getDateCreated());
		model.setDateUpdated(entity.getDateUpdated());
		model.setHudVersion(entity.getHudVersion());
		model.setFileName(entity.getInputpath());
		if(entity.getSize() !=null)
			model.setFileSize(FileUtils.byteCountToDisplaySize(entity.getSize()));
		return model;
	}

	public static com.servinglynk.hmis.warehouse.model.base.BulkUpload modelToEntity(BulkUpload model,com.servinglynk.hmis.warehouse.model.base.BulkUpload entity){
		if(entity == null) entity = new com.servinglynk.hmis.warehouse.model.base.BulkUpload();		
		entity.setProjectGroupCode(model.getProjectGroupCode());
		entity.setYear(model.getYear());
		entity.setStatus(model.getStatus());
		entity.setId(model.getId());
		entity.setDescription(model.getDescription());
		entity.setDateCreated(model.getDateCreated());
		entity.setDateUpdated(model.getDateUpdated());
		entity.setHudVersion(model.getHudVersion());
		if(model.getFileSize() !=null)
			entity.setSize(Long.parseLong(model.getFileSize()));
		entity.setInputpath(model.getFileName());
		return entity;
	}
	

}
