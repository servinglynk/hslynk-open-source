package com.servinglynk.hmis.warehouse;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.WebApplicationInitializer;

public class ServletInitializer extends org.springframework.boot.web.support.SpringBootServletInitializer { //implements WebApplicationInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HmisMqServiceApplication.class);
	}

}
