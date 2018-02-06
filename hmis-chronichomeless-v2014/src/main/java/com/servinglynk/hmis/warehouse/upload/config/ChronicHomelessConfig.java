package com.servinglynk.hmis.warehouse.upload.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.servinglynk.hmis.warehouse.config.DatabaseConfig;
import com.servinglynk.hmis.warehouse.config.StandAloneDBPoolConfig;
import com.servinglynk.hmis.warehouse.upload.service.ChronicHomelessnesCalculator;

@Configuration
@EnableScheduling
@EnableTransactionManagement
@Import({DatabaseConfig.class,StandAloneDBPoolConfig.class})
@ComponentScan(value={"com.servinglynk.hmis.warehouse.upload.service"})
public class ChronicHomelessConfig {
	@Bean 
	public ChronicHomelessnesCalculator chronicHomelessnesCalculator() {
		return new ChronicHomelessnesCalculator();
	}
}
