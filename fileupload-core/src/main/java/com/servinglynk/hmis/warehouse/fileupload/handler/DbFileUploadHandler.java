package com.servinglynk.hmis.warehouse.fileupload.handler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.servinglynk.hmis.warehouse.fileupload.common.BaseRegistry;
import com.servinglynk.hmis.warehouse.fileupload.entity.UploadLineEntity;

@Service("dbFileUploadHandler")
public class DbFileUploadHandler extends BaseRegistry implements FileUploadHandler{

	@Override
	public void uploadDocument(UploadLineEntity entity, MultipartFile file) throws IOException {
			//entity.setDocument(file.getBytes());
			daoFactory.getUploadLineDao().save(entity);
	}

	@Override
	public File downloadDocument(UploadLineEntity uploadLine) throws FileNotFoundException, IOException {
		
		File file = new File(uploadLine.getFileName());
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
		//	fos.write(uploadLine.getDocument());
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("File Not Found for the specified document id : " + uploadLine.getId());
		} finally{
			fos.close();
		}
		return file;

	}
	
	@Override
	public void deleteDocument(UploadLineEntity uploadLine){
		daoFactory.getUploadLineDao().deleteUploadLine(uploadLine);
	}

	@Override
	public InputStream downloadFile(UploadLineEntity entity) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
