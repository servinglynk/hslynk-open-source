package com.servinglynk.hmis.warehouse.common;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class JsonUtil {

	
	public static String coneveterObejctToString(Object object) throws Exception {
		
		return JsonUtil.getObjectMapper().writeValueAsString(object);
	}
	
	
	public static ObjectMapper getObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
	//	mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false);
	//	mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES,true);
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE);
		  SimpleModule simpleModule = new SimpleModule();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		  simpleModule.addSerializer(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
				@Override
				public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers)
						throws IOException {
					//	gen.writeNumber(value.toEpochSecond(ZoneOffset.UTC));
					String formattedDate = dateFormat.format(Date.from(value.atZone(ZoneId.systemDefault()).toInstant()));
					gen.writeString(formattedDate);
				}
		    });
		simpleModule.addDeserializer(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {

			@Override
			public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt)
					throws IOException, JsonProcessingException {
				return LocalDateTime.ofInstant(Instant.ofEpochMilli(p.getLongValue()),ZoneId.of("UTC"));
			}
			
		});
		
		  simpleModule.addSerializer(Date.class, new JsonSerializer<Date>() {
				@Override
				public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers)
						throws IOException {
					//gen.writeString(dateFormat.format(value));
						gen.writeNumber(value.getTime());
				}
		    });
		simpleModule.addDeserializer(Date.class, new JsonDeserializer<Date>() {

			@Override
			public Date deserialize(JsonParser p, DeserializationContext ctxt)
					throws IOException, JsonProcessingException {
				return new Date(p.getLongValue());
			}
			
		});
		  
		mapper.registerModule(simpleModule);
		
		return mapper;
	}
}
