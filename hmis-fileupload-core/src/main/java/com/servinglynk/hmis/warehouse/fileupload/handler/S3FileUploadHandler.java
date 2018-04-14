package com.servinglynk.hmis.warehouse.fileupload.handler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.servinglynk.hmis.warehouse.fileupload.common.BaseRegistry;
import com.servinglynk.hmis.warehouse.fileupload.entity.UploadLineEntity;

@Service("s3FileUploadHandler")
public class S3FileUploadHandler extends BaseRegistry implements FileUploadHandler{


	public void uploadDocument(UploadLineEntity entity, MultipartFile multipart) throws IOException {
		String key =this.getRemoteFileName(multipart.getOriginalFilename());
		File file=new File(key);
		multipart.transferTo(file);
        getS3Client().putObject(new PutObjectRequest(entity.getBucketName(), key, file));
        entity.setFileName(key);
        daoFactory.getUploadLineDao().save(entity);
	}

	@Override
	public File downloadDocument(UploadLineEntity entity) throws FileNotFoundException, IOException {
		
		File file=new File(entity.getFileName());
		getS3Client().getObject(new GetObjectRequest(entity.getBucketName(), entity.getFileName()),file);
		
		return file;
	}

	@Override
	public void deleteDocument(UploadLineEntity uploadLine) {
	    getS3Client().deleteObject(new DeleteObjectRequest(uploadLine.getBucketName(), uploadLine.getFileName())); 
	    daoFactory.getUploadLineDao().deleteUploadLine(uploadLine);
	}
	
	public String getRemoteFileName(String uploadedFileName) {
		String fileExtension = uploadedFileName.substring(uploadedFileName.lastIndexOf(".")+1);
		String fileName =uploadedFileName.substring(0,uploadedFileName.lastIndexOf("."));
//		System.out.println("File Name "+fileName + " File Extension "+fileExtension);
		return fileName+"_"+System.currentTimeMillis()+"."+fileExtension;
	}
}