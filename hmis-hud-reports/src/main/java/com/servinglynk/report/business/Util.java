package com.servinglynk.report.business;

import java.sql.Date;
import java.time.LocalDate;

public class Util {

	public static LocalDate getLocalDateFromUtilDate(Date input) {
		return input.toLocalDate();
	}

}
