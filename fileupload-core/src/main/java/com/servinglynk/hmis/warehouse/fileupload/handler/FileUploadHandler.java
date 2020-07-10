package com.servinglynk.hmis.warehouse.fileupload.handler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

import com.servinglynk.hmis.warehouse.fileupload.entity.UploadLineEntity;

public interface FileUploadHandler {
	
	void uploadDocument(UploadLineEntity entity,MultipartFile file) throws IOException;
	
	File downloadDocument(UploadLineEntity entity) throws FileNotFoundException, IOException;
	
	public void deleteDocument(UploadLineEntity uploadLine);
	
	InputStream downloadFile(UploadLineEntity entity) throws FileNotFoundException, IOException;
	
}
