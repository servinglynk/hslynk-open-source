package com.servinglynk.report.csv;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CsvReportGenerator {

	public static String getStringValue(BigDecimal value) {
		if(value != null) {
			return String.valueOf(value);
		}
		return "0";
	}
	
	public static String getStringValue(BigInteger value) {
		if(value != null) {
			return String.valueOf(value);
		}
		return "0";
	}
}
