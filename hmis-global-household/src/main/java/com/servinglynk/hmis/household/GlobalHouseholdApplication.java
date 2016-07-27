package com.servinglynk.hmis.household;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class GlobalHouseholdApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GlobalHouseholdApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(GlobalHouseholdApplication.class, args);
	}
}
