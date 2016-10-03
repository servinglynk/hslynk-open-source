package com.servinglynk.hmis.household;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import com.servinglynk.hmis.warehouse.client.config.CoreClientConfig;
import com.servinglynk.hmis.warehouse.client.config.SpringConfig;

@SpringBootApplication
public class GlobalHouseholdApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GlobalHouseholdApplication.class,SpringConfig.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(GlobalHouseholdApplication.class, args);
	}
}
