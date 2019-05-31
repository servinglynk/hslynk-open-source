package com.servinglynk.hmis.warehouse.service;

import java.io.File;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.servinglynk.hmis.warehouse.base.service.core.PropertyReaderServiceImpl;
import com.servinglynk.hmis.warehouse.client.config.CoreClientConfig;
import com.servinglynk.hmis.warehouse.fileupload.common.BaseRegistry;

@Service
public class AWSService extends BaseRegistry {

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
	
	private AWSCredentials credential(Properties properties) {
		String awsId = (String)properties.get("aws_access_key_id");
		String awsKey = (String)properties.get("aws_secret_access_key");
		return new BasicAWSCredentials(awsId, awsKey);
	}
}
