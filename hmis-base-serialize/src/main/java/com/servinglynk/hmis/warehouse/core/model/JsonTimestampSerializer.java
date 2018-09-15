package com.servinglynk.hmis.warehouse.core.model;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonTimestampSerializer  extends JsonSerializer<LocalDateTime> {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm");
	@Override
	public void serialize(LocalDateTime date, JsonGenerator gen, SerializerProvider provider)
	throws IOException, JsonProcessingException {
	String formattedDate = dateFormat.format(Date.from(date.atZone(ZoneId.systemDefault()).toInstant()));
	gen.writeString(formattedDate);
	}
}