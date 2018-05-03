package com.servinglynk.hmis.warehouse.fileupload.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.servinglynk.hmis.warehouse.fileupload.exception.FileUploadException;
import com.servinglynk.hmis.warehouse.model.Document;
import com.servinglynk.hmis.warehouse.model.Documents;
import com.servinglynk.hmis.warehouse.model.UploadHeader;

public interface FileUploadService {
	
	UploadHeader uploadDocument(MultipartFile file,UploadHeader content) throws IOException,FileUploadException ;
	
	Document downloadDocument(UUID documentId) throws FileNotFoundException,IOException;

	void deleteDocument(UUID documentId);
	
	Documents getDocuments(UUID headerId);
}
