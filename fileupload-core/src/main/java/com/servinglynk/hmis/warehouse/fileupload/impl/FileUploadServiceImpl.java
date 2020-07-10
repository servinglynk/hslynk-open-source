package com.servinglynk.hmis.warehouse.fileupload.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.servinglynk.hmis.warehouse.fileupload.common.BaseRegistry;
import com.servinglynk.hmis.warehouse.fileupload.converter.UploadHeaderConverter;
import com.servinglynk.hmis.warehouse.fileupload.converter.UploadLineConverter;
import com.servinglynk.hmis.warehouse.fileupload.entity.UploadHeaderEntity;
import com.servinglynk.hmis.warehouse.fileupload.entity.UploadLineEntity;
import com.servinglynk.hmis.warehouse.fileupload.entity.UploadMimeTypeEntity;
import com.servinglynk.hmis.warehouse.fileupload.entity.UploadTypeEntity;
import com.servinglynk.hmis.warehouse.fileupload.exception.FileUploadResourceNotFoundException;
import com.servinglynk.hmis.warehouse.fileupload.handler.FileUploadHandlerFactoryImpl;
import com.servinglynk.hmis.warehouse.fileupload.service.FileUploadService;
import com.servinglynk.hmis.warehouse.model.Document;
import com.servinglynk.hmis.warehouse.model.Documents;
import com.servinglynk.hmis.warehouse.model.UploadHeader;
import com.servinglynk.hmis.warehouse.model.UploadLine;

@Service
public class FileUploadServiceImpl extends BaseRegistry implements FileUploadService {

	@Autowired
	FileUploadHandlerFactoryImpl fileUploadHandlerFactory;
	
	static ObjectMapper mapper = new ObjectMapper();

	@Override
	@Transactional
	public UploadHeader uploadDocument(MultipartFile file, UploadHeader content) throws IOException {
		UploadTypeEntity uploadType = daoFactory.getUploadTypeDao().findByCode(content.getUploadType());
		if (uploadType == null)
			throw new FileUploadResourceNotFoundException("Upload Group not found " + content.getUploadType());

		UploadHeaderEntity entity = daoFactory.getUploadHeaderDao().findById(content.getUploadFileId());
		if(entity==null) {
			entity = new UploadHeaderEntity();
			entity.setUploadType(uploadType);
			entity.setNoOfFiles(0L);
			entity.setTotalSize(0L);
			daoFactory.getUploadHeaderDao().save(entity);
		}

		String fileType = file.getContentType();

		List<UploadMimeTypeEntity> list = daoFactory.getUploadMimeTypeDao().findByUploadType(uploadType);
		Map<String, UploadMimeTypeEntity> map = new HashMap<>();
		if (list.size() == 0)
			throw new FileUploadResourceNotFoundException(
					"No MIME_TYPES found for specified Upload Group:  " + content.getUploadType());

		for (UploadMimeTypeEntity uploadMimeTypeEntity : list) {
			map.put(uploadMimeTypeEntity.getMimeType().toLowerCase(), uploadMimeTypeEntity);
		}
		
		if (!map.containsKey(fileType.toLowerCase())) {
			StringBuffer sb = new StringBuffer();
			sb.append("Valid file types are: ");

			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i).getDisplayName());
				if (i != list.size() - 1)
					sb.append(" or ");
			}
			String message = sb.toString();
			throw new IllegalArgumentException(message);

		}
		
		
		UploadMimeTypeEntity uploadEntity = map.get(fileType.toLowerCase());
		if (uploadEntity!=null && uploadEntity.getMaxSizeInKb()!=null && (file.getSize()/1024) > uploadEntity.getMaxSizeInKb())
			throw new IllegalArgumentException("Actual size of the file is greater than the Maximum allowed size (" + uploadEntity.getMaxSizeInKb() + "KB )");
	

			entity.setNoOfFiles(entity.getNoOfFiles() + 1L);
			entity.setTotalSize(entity.getTotalSize() + file.getSize());
			entity.setUploadType(uploadType);
			daoFactory.getUploadHeaderDao().updateUploadHeader(entity);
			
			UploadLineEntity uploadLineEntity = UploadLineConverter.modelToEntity(content, null);
			uploadLineEntity.setUploadLocation(uploadType.getStorageType());
			uploadLineEntity.setUploadHeader(entity);
			uploadLineEntity.setFileOriginalName(file.getOriginalFilename());
			uploadLineEntity.setFileSize(file.getSize());
			uploadLineEntity.setContentType(fileType);
			uploadLineEntity.setBucketName(content.getBucketName());
			if(content.getUploadFolder()!=null) {
				uploadLineEntity.setFileName(content.getUploadFolder()+"/"+ this.getRemoteFileName(file.getOriginalFilename()));
			}else {
				uploadLineEntity.setFileName(this.getRemoteFileName(file.getOriginalFilename()));
			}
			fileUploadHandlerFactory.getFileUploadHandler(uploadType.getStorageType()).uploadDocument(uploadLineEntity,
					file);
			content.setUploadFileId(entity.getId());
			
			return content;

	}
	
	public String getRemoteFileName(String uploadedFileName) {
		String fileExtension = uploadedFileName.substring(uploadedFileName.lastIndexOf(".")+1);
		String fileName =uploadedFileName.substring(0,uploadedFileName.lastIndexOf("."));
//		System.out.println("File Name "+fileName + " File Extension "+fileExtension);
		return fileName+"_"+System.currentTimeMillis()+"."+fileExtension;
	}

	@Override
	@Transactional
	public Document downloadDocument(UUID documentId) throws FileNotFoundException, IOException {
		UploadLineEntity uploadLine = daoFactory.getUploadLineDao().findById(documentId);

		InputStream stream= fileUploadHandlerFactory.getFileUploadHandler(uploadLine.getUploadLocation())
				.downloadFile(uploadLine);
		
		Document document = new Document();
		document.setFileName(uploadLine.getFileName());
		document.setMimeType(uploadLine.getContentType());
		document.setSize(uploadLine.getFileSize());
		document.setDocumentId(uploadLine.getId());
	//	document.setFile(file);
		document.setFileStream(stream);	
		return document;
	}
	
	@Override
	@Transactional
	public void deleteDocument(UUID documentId) {
		UploadLineEntity uploadLine = daoFactory.getUploadLineDao().findById(documentId);
		if(uploadLine == null) throw new FileUploadResourceNotFoundException("Upload Document not found for specified id:  " + documentId);
		
		UploadHeaderEntity headerEntity= daoFactory.getUploadHeaderDao().findById(uploadLine.getUploadHeader().getId());
		if(headerEntity.getNoOfFiles()!=null) headerEntity.setNoOfFiles(headerEntity.getNoOfFiles()-1);
		if(headerEntity.getTotalSize()!=null) headerEntity.setTotalSize(headerEntity.getTotalSize()-uploadLine.getFileSize());
		
		fileUploadHandlerFactory.getFileUploadHandler(uploadLine.getUploadLocation()).deleteDocument(uploadLine);
		
		List<UploadLineEntity> entities=daoFactory.getUploadLineDao().findByUploadHeader(headerEntity);
		if(entities.size()==0) {
			daoFactory.getUploadHeaderDao().deleteHeaderEntity(headerEntity);
		}else{
			daoFactory.getUploadHeaderDao().updateUploadHeader(headerEntity);
		}
	}
	
	public Documents getDocuments(UUID headerId) {
		Documents documents = new Documents();
		
		UploadHeaderEntity entity  = daoFactory.getUploadHeaderDao().findById(headerId);
		if(entity == null) throw new FileUploadResourceNotFoundException("No documents found");
		
		List<UploadLineEntity> entities = daoFactory.getUploadLineDao().findByUploadHeader(entity);
		for(UploadLineEntity lineEntity : entities) {
			Document document = new Document();
			document.setFileName(lineEntity.getFileOriginalName());
			document.setMimeType(lineEntity.getContentType());
			document.setSize(lineEntity.getFileSize());
			document.setDocumentId(lineEntity.getId());
			documents.addDocument(document);
		}
		return documents;
		
	}

}
