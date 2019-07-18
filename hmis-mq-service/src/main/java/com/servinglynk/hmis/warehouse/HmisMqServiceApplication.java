package com.servinglynk.hmis.warehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@Import(com.servinglynk.hmis.warehouse.config.AMQConfiguration.class)
@ComponentScan("com.servinglynk.hmis.warehouse")
//@PropertySource("classpath:application.properties")

@EnableJpaAuditing
@EnableJpaRepositories
@EnableTransactionManagement
@EnableSpringDataWebSupport
@EnableAsync
public class HmisMqServiceApplication {

/*	public static void main(String[] args) {
		SpringApplication.run(HmisMqServiceApplication.class, args);
	}*/

}
