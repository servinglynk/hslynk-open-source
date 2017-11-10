package com.servinglynk.hmis.warehouse.service;

import java.io.File;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

@Service
public class AWSService{

	@Value("${aws_bucket}")
	private String awsBucket;

	@Value("${aws_bucket_region}")
	private String awsBucketRegion;
	
	@Value("${aws_access_key_id}")
	private String awsId;

	@Value("${aws_secret_access_key}")
	private String awsKey;

	/*
	 * upload file to folder and set it to public
	 */ 
	public void uploadFile(String uploadFile, String filename) {
		
		String fileNameInS3 = filename;
		
		PutObjectResult putObject = s3client().putObject(
				new PutObjectRequest(awsBucket, 
						fileNameInS3, new File(uploadFile)));
	}
	
	public URL getFile(String fileKey) {
		URL presignedUrl = s3client().generatePresignedUrl(new GeneratePresignedUrlRequest(awsBucket, fileKey));		
		return presignedUrl;
	}
	
	private AmazonS3 s3client() {
		 AmazonS3Client amazonS3Client = new AmazonS3Client(credential()); 
		 Region region = Region.getRegion(Regions.fromName(awsBucketRegion));
		 amazonS3Client.setRegion(region);
		 return amazonS3Client;
	}
	
	private AWSCredentials credential() {
		return new BasicAWSCredentials(awsId, awsKey);
	}
}
