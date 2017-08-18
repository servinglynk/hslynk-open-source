package com.servinglynk.hmis.warehouse.upload.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.servinglynk.hmis.warehouse.base.dao.BulkUploaderWorkerDaoImpl;
import com.servinglynk.hmis.warehouse.config.DatabaseConfig;
import com.servinglynk.hmis.warehouse.config.StandAloneDBPoolConfig;
import com.servinglynk.hmis.warehouse.upload.service.BaseWorker;
import com.servinglynk.hmis.warehouse.upload.service.BulkUploadWorker;
import com.servinglynk.hmis.warehouse.upload.service.ClientWorkerChildren;
import com.servinglynk.hmis.warehouse.upload.service.DisabilitiesWorker;
import com.servinglynk.hmis.warehouse.upload.service.EnrollmentWorker;
import com.servinglynk.hmis.warehouse.upload.service.EnrollmentWorkerChildren;
import com.servinglynk.hmis.warehouse.upload.service.ExitWorker;
import com.servinglynk.hmis.warehouse.upload.service.ExitWorkerChildren;

@Configuration
@EnableScheduling
@EnableTransactionManagement
@Import({DatabaseConfig.class,StandAloneDBPoolConfig.class})
@ComponentScan(value={"com.servinglynk.hmis.warehouse.upload.service"})

public class LoadProcessorSpringConfigV2014 {
	
	@Bean
	public BulkUploadWorker bulkUploadWorker(){
		return new BulkUploadWorker();
	}
	
	@Bean
	public BaseWorker baseWorker(){
		return new BaseWorker();
	}
	@Bean
	public DisabilitiesWorker disabilitiesWorker(){
		return new DisabilitiesWorker();
	}
	@Bean
	public EnrollmentWorker enrollmentWorker(){
		return new EnrollmentWorker();
	}
	@Bean
	public ExitWorkerChildren exitWorkerChildrenr(){
		return new ExitWorkerChildren();
	}
	@Bean
	public EnrollmentWorkerChildren enrollmentWorkerChildren(){
		return new EnrollmentWorkerChildren();
	}
	@Bean
	public ClientWorkerChildren clientWorkerChildren(){
		return new ClientWorkerChildren();
	}
	@Bean
	public ExitWorker exitWorker(){
		return new ExitWorker();
	}
	
	@Bean
	public BulkUploaderWorkerDaoImpl getBulkUploaderWorkerDao(){
		return new BulkUploaderWorkerDaoImpl();
	}
	
}
