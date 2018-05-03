package com.servinglynk.hmis.warehouse.fileupload.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.servinglynk.hmis.warehouse.fileupload.entity.UploadLineEntity;
import com.servinglynk.hmis.warehouse.fileupload.exception.FileUploadException;
import com.servinglynk.hmis.warehouse.model.Parameters;
import com.servinglynk.hmis.warehouse.model.UploadHeader;
import com.servinglynk.hmis.warehouse.model.UploadLine;

public class UploadLineConverter {
	
	static ObjectMapper mapper = new ObjectMapper();

	public static UploadLineEntity modelToEntity(UploadHeader model,UploadLineEntity entity){
		if(entity ==null) entity=new UploadLineEntity();
			if(model.getDocumentName()!=null) entity.setFileOriginalName(model.getDocumentName());

			if(model.getDocumentInfo()!=null) entity.setFileName(model.getDocumentInfo());
			try {
				entity.setAdditionalInfo(mapper.writeValueAsString(model.getParameters()));
			} catch (Exception e) {
				throw new FileUploadException();
			}
		return entity;
	}
	
	public static UploadLine entityToModel(UploadLineEntity entity){
		UploadLine model=new UploadLine();
		
		if(entity.getContentType()!=null) model.setContentType(entity.getContentType());
		if(entity.getFileOriginalName()!=null) model.setDocumentName( entity.getFileOriginalName());
		if(entity.getFileName()!=null) model.setDocumentInfo(entity.getFileName());
		if(entity.getFileSize()!=null) model.setFileSize(entity.getFileSize());
		if(entity.getFileName()!=null) model.setFileName(entity.getFileName());
		
		try {
			model.setAdditionalInfo(mapper.readValue(entity.getAdditionalInfo(), new TypeReference<Parameters>() {}));
		} catch (Exception e) {
			throw new FileUploadException("An exception occured while retrieving additional info parameters: "+e.getMessage());
		}
		
		return model;
	}
	

}
