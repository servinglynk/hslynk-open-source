package com.servinglynk.hmis.warehouse.notification.model;

import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

public class JSONHttpMessageConverter extends MappingJacksonHttpMessageConverter{

	

		private ObjectMapper objectMapper;

		@Override
		public void setObjectMapper(ObjectMapper objectMapper) {
			super.setObjectMapper(objectMapper);
			this.objectMapper = objectMapper;

		}
		@Override
		protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
			JavaType valueType = TypeFactory.mapType(Map.class, String.class, clazz);
			Map map = (Map) objectMapper.readValue(inputMessage.getBody(), valueType);
			return map.values().iterator().next();
		}

	}

