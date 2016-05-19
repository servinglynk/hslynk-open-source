package com.servinglynk.hmis.household.config;


import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfig {

	@Bean
	public Jackson2ObjectMapperBuilder jacksonBuilder() {
	    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
	    builder.indentOutput(true).dateFormat(new SimpleDateFormat("MM/dd/yyyy"));
	    return builder;
	}
}

