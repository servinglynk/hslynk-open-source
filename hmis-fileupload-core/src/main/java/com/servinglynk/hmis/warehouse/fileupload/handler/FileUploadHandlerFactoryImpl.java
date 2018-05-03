package com.servinglynk.hmis.warehouse.fileupload.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.servinglynk.hmis.warehouse.fileupload.common.FileUploadConstants;

@Service
public class FileUploadHandlerFactoryImpl {
	
	@Autowired @Qualifier("dbFileUploadHandler") FileUploadHandler dbFileUploadHandler;
	@Autowired @Qualifier("s3FileUploadHandler") FileUploadHandler s3FileUploadHandler;
	
	
	
	public FileUploadHandler getS3FileUploadHandler() {
		return s3FileUploadHandler;
	}



	public void setS3FileUploadHandler(FileUploadHandler s3FileUploadHandler) {
		this.s3FileUploadHandler = s3FileUploadHandler;
	}



	public FileUploadHandler getDbFileUploadHandler() {
		return dbFileUploadHandler;
	}



	public void setDbFileUploadHandler(FileUploadHandler dbFileUploadHandler) {
		this.dbFileUploadHandler = dbFileUploadHandler;
	}



	public FileUploadHandler getFileUploadHandler(String type){
		
		FileUploadConstants.FileUploadStorageType  storageType = FileUploadConstants.FileUploadStorageType.valueOf(type.toUpperCase());
		switch (storageType) {
			case DB: return dbFileUploadHandler; 
			case S3: return s3FileUploadHandler;
			default: return s3FileUploadHandler;
		}
		
	}
	
	

}
