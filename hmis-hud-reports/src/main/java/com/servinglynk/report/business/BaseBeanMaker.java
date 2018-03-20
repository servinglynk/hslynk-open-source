package com.servinglynk.report.business;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class BaseBeanMaker {
	
	protected static Date chCutoffDate = new Date(2016, 10, 1);

	public static boolean isChild(Date dob) {
		try {
			LocalDate currentDate = LocalDate.now();
			if(dob !=null) {
				@SuppressWarnings("deprecation")
				LocalDate dateOfBirth = LocalDate.of(dob.getYear(), dob.getMonth(), dob.getDay());
				Period p = Period.between(dateOfBirth, currentDate);
				if(p.getYears() < 18 )
					return true;
				else 
					return false;
			}
			return false;
		}catch(Exception e) {
			return false;
		}
		
	}
	
	public static boolean isYouthUnder25(Date dob) {
		try {
			LocalDate currentDate = LocalDate.now();
			if(dob !=null) {
				@SuppressWarnings("deprecation")
				LocalDate dateOfBirth = LocalDate.of(dob.getYear(), dob.getMonth(), dob.getDay());
				Period p = Period.between(dateOfBirth, currentDate);
				if(p.getYears() < 25 )
					return true;
				else 
					return false;
			}
			return false;
		}catch(Exception e) {
			return false;
		}
		
	}
	public static boolean inProjectForMoreThan365Days(Date entryDate) {
		try {
			LocalDate currentDate = LocalDate.now();
			if(entryDate !=null) {
				@SuppressWarnings("deprecation")
				LocalDate entryLocalDate = LocalDate.of(entryDate.getYear(), entryDate.getMonth(), entryDate.getDay());
				
				Period p = Period.between(entryLocalDate, currentDate);
				if(p.getDays() > 365 )
					return true;
				else 
					return false;
			}
			return false;
		}catch(Exception e) {
			return false;
		}
		
	}
	
	
	public static boolean isAdult(Date dob) {
		try {
			LocalDate currentDate = LocalDate.now();
			if(dob !=null) {
				@SuppressWarnings("deprecation")
				LocalDate dateOfBirth = LocalDate.of(dob.getYear(), dob.getMonth(), dob.getDay());
				Period p = Period.between(dateOfBirth, currentDate);
				if(p.getYears() > 18 )
					return true;
				else 
					return false;
			}
			return false;
		}catch(Exception e) {
			return false;
		}
	
	}
	
	
}
