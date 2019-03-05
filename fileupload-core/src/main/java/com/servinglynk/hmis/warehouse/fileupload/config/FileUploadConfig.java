package com.servinglynk.hmis.warehouse.fileupload.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.servinglynk.hmis.warehouse.fileupload.handler.DbFileUploadHandler;
import com.servinglynk.hmis.warehouse.fileupload.handler.FileUploadHandlerFactoryImpl;
import com.servinglynk.hmis.warehouse.fileupload.handler.S3FileUploadHandler;
import com.servinglynk.hmis.warehouse.fileupload.impl.FileUploadDaoFactoryImpl;
import com.servinglynk.hmis.warehouse.fileupload.impl.FileUploadServiceFactoryImpl;
import com.servinglynk.hmis.warehouse.fileupload.impl.FileUploadServiceImpl;
import com.servinglynk.hmis.warehouse.fileupload.repository.UploadHeaderDaoImpl;
import com.servinglynk.hmis.warehouse.fileupload.repository.UploadLineDaoImpl;
import com.servinglynk.hmis.warehouse.fileupload.repository.UploadMimeTypeDaoImpl;
import com.servinglynk.hmis.warehouse.fileupload.repository.UploadTypeDaoImpl;

@Configuration
@EnableTransactionManagement
public class FileUploadConfig {

	@Bean
	public FileUploadServiceImpl fileUploadService() {
		return new FileUploadServiceImpl();
	}
	
	@Bean
	public FileUploadServiceFactoryImpl fileUploadServiceFactory() {
		return new FileUploadServiceFactoryImpl();
	}
	
	@Bean
	public UploadHeaderDaoImpl uploadHeaderDao() {
		return new UploadHeaderDaoImpl();
	}
	
	@Bean
	public UploadLineDaoImpl uploadLineDao() {
		return new UploadLineDaoImpl();
	}
	
	@Bean
	public UploadMimeTypeDaoImpl uploadMimeTypeDao() {
		return new UploadMimeTypeDaoImpl();
	}
	
	@Bean
	public UploadTypeDaoImpl uploadTypeDaoI() {
		return new UploadTypeDaoImpl();
	}
	
	@Bean
	public FileUploadDaoFactoryImpl fileUploadDaoFactory() {
		return new FileUploadDaoFactoryImpl();
	}
	
	@Bean
	public FileUploadHandlerFactoryImpl fileUploadHandler() {
		return new FileUploadHandlerFactoryImpl();
	}
	
	@Bean
	public S3FileUploadHandler s3FileUploadHandler() {
		return new S3FileUploadHandler();
	}
	
	@Bean
	public DbFileUploadHandler dbFileUploadHandler() {
		return new DbFileUploadHandler();
	}
	
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver  resolver() {
    	CommonsMultipartResolver resolver = new CommonsMultipartResolver();
    //	resolver.setMaxUploadSize(10000000);
        return resolver;
    }
	
}