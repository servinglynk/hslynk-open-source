package com.servinglynk.hmis.warehouse.core.model;


import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JSONHttpMessageConverter extends MappingJackson2HttpMessageConverter{

		@Override
		public void setObjectMapper(ObjectMapper objectMapper) {
			objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE,true);
			objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE,true);
	
			
		}
		

	}

