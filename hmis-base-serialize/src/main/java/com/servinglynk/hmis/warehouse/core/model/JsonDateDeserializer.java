package com.servinglynk.hmis.warehouse.core.model;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class JsonDateDeserializer extends JsonDeserializer<LocalDateTime> {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	
	@Override
	public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
				
		return null;
	}

}
