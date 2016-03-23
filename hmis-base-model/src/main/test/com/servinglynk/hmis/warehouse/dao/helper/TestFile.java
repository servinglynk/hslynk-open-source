package com.servinglynk.hmis.warehouse.dao.helper;

import java.time.LocalDateTime;

public class TestFile {

	public static void main(String args[]) {
		System.out.println("sdo@dsadf.com".replaceAll("[^a-zA-Z0-9]+","-"));
		try {
			LocalDateTime dob = LocalDateTime.now();
			if(dob !=null) {
				LocalDateTime newDob = LocalDateTime.of(dob.getYear(), dob.getMonth(), 01, dob.getHour(), dob.getHour(),dob.getMinute(),dob.getSecond());
				System.out.println("DOB :::"+newDob.toString());
			}
		}catch(Exception e) {
			// Eat this exception.
		}
	}
}
