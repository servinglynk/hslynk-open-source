package com.servinglynk.hmis.warehouse.upload.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.servinglynk.hmis.warehouse.base.dao.BulkUploaderWorkerDaoImpl;
import com.servinglynk.hmis.warehouse.config.DatabaseConfig;
import com.servinglynk.hmis.warehouse.config.StandAloneDBPoolConfig;
import com.servinglynk.hmis.warehouse.upload.service.BulkUploadWorker;
import com.servinglynk.hmis.warehouse.upload.service.DisabilitiesProcessor;
import com.servinglynk.hmis.warehouse.upload.service.EnrollmentChild1Processor;
import com.servinglynk.hmis.warehouse.upload.service.EnrollmentChild2Processor;
import com.servinglynk.hmis.warehouse.upload.service.EnrollmentChild3Processor;
import com.servinglynk.hmis.warehouse.upload.service.ExitChild1Processor;
import com.servinglynk.hmis.warehouse.upload.service.ProjectChildrenProcessor;

@Configuration
@EnableScheduling
@EnableTransactionManagement
@Import({DatabaseConfig.class,StandAloneDBPoolConfig.class})
@ComponentScan(value={"com.servinglynk.hmis.warehouse.upload.service"})

public class LoadProcessorSpringConfigV2015 {

	@Bean
	public BulkUploadWorker bulkUploadWorker(){
		return new BulkUploadWorker();
	}
	
	@Bean
	public BulkUploaderWorkerDaoImpl getBulkUploaderWorkerDao(){
		return new BulkUploaderWorkerDaoImpl();
	}
	
	@Bean
	public EnrollmentChild1Processor EnrollmentChild1Processor() {
		return new EnrollmentChild1Processor();
	}
	@Bean
	public EnrollmentChild2Processor EnrollmentChild2Processor() {
		return new EnrollmentChild2Processor();
	}
	@Bean
	public EnrollmentChild3Processor EnrollmentChild3Processor() {
		return new EnrollmentChild3Processor();
	}
	@Bean
	public ProjectChildrenProcessor ProjectChildrenProcessor() {
		return new ProjectChildrenProcessor();
	}
	
	@Bean
	public ExitChild1Processor ExitChild1Processor() {
		return new ExitChild1Processor();
	}
	
	@Bean
	public DisabilitiesProcessor DisabilitiesProcessor() {
		return new DisabilitiesProcessor();
	}
}
