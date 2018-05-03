package com.servinglynk.hmis.warehouse.fileupload.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.servinglynk.hmis.warehouse.fileupload.service.FileUploadDaoFactory;
import com.servinglynk.hmis.warehouse.fileupload.service.FileUploadServiceFactory;


public abstract class BaseRegistry  {
	

//	@Autowired
    protected AmazonS3Client s3Client;
	
	@Autowired
	protected FileUploadDaoFactory daoFactory;
	
	@Autowired
	protected Environment environment;
	
	@Autowired
	protected FileUploadServiceFactory serviceRegistry;
	

	public AmazonS3Client getS3Client() {
		s3Client = new AmazonS3Client(new BasicAWSCredentials(environment.getProperty("aws_access_key_id"),environment.getProperty("aws_secret_access_key")));
	//	s3Client = new AmazonS3Client(credentials);
		return s3Client;
	}

	public void setS3Client(AmazonS3Client s3Client) {
		this.s3Client = s3Client;
	}

	public FileUploadServiceFactory getServiceRegistry() {
		return serviceRegistry;
	}

	public void setServiceRegistry(FileUploadServiceFactory serviceRegistry) {
		this.serviceRegistry = serviceRegistry;
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public FileUploadDaoFactory getDaoFactory() {
		return daoFactory;
	}

	public void setDaoFactory(FileUploadDaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
}