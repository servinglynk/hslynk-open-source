package com.servinglynk.hmis.warehouse.fileupload.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.fileupload.service.FileUploadService;
import com.servinglynk.hmis.warehouse.fileupload.service.FileUploadServiceFactory;

@Component
public class FileUploadServiceFactoryImpl implements FileUploadServiceFactory{
	
	@Autowired FileUploadService fileUploadService;

	public FileUploadService getFileUploadService() {
		return fileUploadService;
	}

	public void setFileUploadService(FileUploadService fileUploadService) {
		this.fileUploadService = fileUploadService;
	}
	
	

}
