package com.servinglynk.hmis.warehouse.common;

import java.util.UUID;

public class GeneralUtil {

	public static String getNewGuid() {		return UUID.randomUUID().toString().toUpperCase();	}		public static String getAlphaNumericGuid() {		String str =  getNewGuid();		return str.replaceAll("-","");	}
	public static String getUniqueToken(int length) {
		StringBuffer buffer = new StringBuffer();
		while(buffer.length() < length) {
			buffer.append(getNewGuid().replace("-", ""));
		}
		return buffer.substring(0, length);
	}		public static String convertBooleanToString(Integer booleanValue){		if(booleanValue!=null) 		return (booleanValue==1)?"true":"false";			return null;	}
}
