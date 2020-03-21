package com.servinglynk.hmis.warehouse.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.servinglynk.hmis.warehouse.base.service.core.PropertyReaderServiceImpl;
import com.servinglynk.hmis.warehouse.client.config.CoreClientConfig;
import com.servinglynk.hmis.warehouse.fileupload.common.BaseRegistry;

@Service
public class AWSService extends BaseRegistry {
	final static Logger logger = Logger.getLogger(AWSService.class);
	@Autowired
	CoreClientConfig coreClientConfig;
	
	@Autowired 
	PropertyReaderServiceImpl propertyReaderService;
	
	/*
	 * upload file to folder and set it to public
	 */ 
	public void uploadFile(String uploadFile, String filename,String bucketName) {
		String fileNameInS3 = filename;
		s3client().putObject(
				new PutObjectRequest(bucketName, 
						fileNameInS3, new File(uploadFile)));
	}
	
	private AmazonS3 s3client() {
		 Properties properties = propertyReaderService.getApplicationProperties();
		 AmazonS3Client amazonS3Client = new AmazonS3Client(credential(properties)); 
		 Region region = Region.getRegion(Regions.fromName(properties.getProperty("aws_bucket_region","us-west-1")));
		 amazonS3Client.setRegion(region);
		 return amazonS3Client;
	}
	
	 /**
     * Download a file (keyName) from a bucket (bucketName)
     * @param bucketName
     * @param keyName
     * @return
     */
    public InputStream downloadFile(String bucketName, String keyName, String tmpPath) throws IOException
    {
        S3Object object = getS3Client().getObject(
                new GetObjectRequest(bucketName, keyName));
        InputStream objectData = object.getObjectContent();
        return objectData;
    }
    
    public String downloadFile1(String bucketName, String keyName, String tmpPath) throws IOException {
    	 S3Object object = getS3Client().getObject(
                 new GetObjectRequest(bucketName, keyName));
         InputStream objectData = object.getObjectContent();
         String name = keyName.contains("/") ? keyName.substring(keyName.lastIndexOf('/') + 1) : keyName;
         String path = saveFile(objectData, name);
         objectData.close();
         return path;
    }
	 
	 private String saveFile(InputStream input, String name)
	            throws IOException {
	        File file = new File(name);
	        OutputStream outputStream = new FileOutputStream(file);
	        IOUtils.copy(input, outputStream);
	        outputStream.close();
	        return file.getAbsolutePath();
	    }
	 
   
	private AWSCredentials credential(Properties properties) {
		String awsId = (String)properties.get("aws_access_key_id");
		String awsKey = (String)properties.get("aws_secret_access_key");
		return new BasicAWSCredentials(awsId, awsKey);
	}
}
