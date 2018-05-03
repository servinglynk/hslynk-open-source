package com.servinglynk.hmis.warehouse.fileupload.converter;

import com.servinglynk.hmis.warehouse.fileupload.entity.UploadHeaderEntity;
import com.servinglynk.hmis.warehouse.model.UploadHeader;

public class UploadHeaderConverter {
	
	public static UploadHeaderEntity modelToEntity(UploadHeader model,UploadHeaderEntity entity){
		if(entity==null) entity = new UploadHeaderEntity();
		
	       if(model.getNoOfFiles()!=null) entity.setNoOfFiles(model.getNoOfFiles());
	       if(model.getTotalSize()!=null) entity.setTotalSize(model.getTotalSize());
	       return entity;
	}
	

}
