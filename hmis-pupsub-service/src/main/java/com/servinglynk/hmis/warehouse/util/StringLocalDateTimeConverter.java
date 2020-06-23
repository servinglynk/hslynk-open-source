package com.servinglynk.hmis.warehouse.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

//@Component
public class StringLocalDateTimeConverter implements Converter<LocalDateTime, Long> {

	@Override
	public Long convert(LocalDateTime arg0) {
		
		return arg0.toEpochSecond(ZoneOffset.UTC);
	}

}
