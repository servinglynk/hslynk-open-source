package com.servinglynk.report.business;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Util {

	public static LocalDate getLocalDateFromUtilDate(Date input) {
		return input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
}
