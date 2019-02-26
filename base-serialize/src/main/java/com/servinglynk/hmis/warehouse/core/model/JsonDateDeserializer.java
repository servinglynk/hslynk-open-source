package com.servinglynk.hmis.warehouse.core.model;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class JsonDateDeserializer extends JsonDeserializer<LocalDateTime> {

	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm"); 
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
				try {
					System.out.println(jp.getText());
					Date date = dateFormat.parse(jp.getText());
					return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
				} catch (ParseException e) {
					e.printStackTrace();
				return null;
					
				}
	}
	
	
/*	public static void main(String args[]) {
		try {
			System.out.println(dateFormat.format(new Date()));
			System.out.println(dateFormat. parse("2018-09-15 08:48"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
}
