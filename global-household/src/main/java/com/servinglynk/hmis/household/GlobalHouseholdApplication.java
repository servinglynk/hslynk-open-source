package com.servinglynk.hmis.household;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.servinglynk.hmis.household.repository.BaseRepositoryFactoryBean;
import com.servinglynk.hmis.warehouse.client.config.SpringConfig;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass=BaseRepositoryFactoryBean.class)
@EnableTransactionManagement
public class GlobalHouseholdApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GlobalHouseholdApplication.class,SpringConfig.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(GlobalHouseholdApplication.class, args);
	}
}
