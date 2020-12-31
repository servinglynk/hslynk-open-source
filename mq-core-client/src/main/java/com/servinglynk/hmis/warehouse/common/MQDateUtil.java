package com.servinglynk.hmis.warehouse.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MQDateUtil {

    private static final String DATE_FORMATTER= "yyyy-MM-dd HH:mm:ss";

    
	public static String dateTimeToString(LocalDateTime dateTime) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
	      if(dateTime!=null)  return dateTime.format(formatter);
	      return null;
	}
	
	public static LocalDateTime stringToDateTime(String dateTimeString) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
	       if(dateTimeString!=null) return LocalDateTime.parse(dateTimeString, formatter);
	       return null;
	}
	
	public static String dateToString(LocalDate dateTime) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
	      if(dateTime!=null)  return dateTime.format(formatter);
	      return null;
	}
}