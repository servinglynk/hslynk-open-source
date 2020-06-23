package com.servinglynk.hmis.warehouse.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

//@Component
public class LocalDateTimeConverter implements Converter<Long, LocalDateTime>{

	@Override
	public LocalDateTime convert(Long arg0) {
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(arg0),ZoneId.of("UTC"));
	}

}
