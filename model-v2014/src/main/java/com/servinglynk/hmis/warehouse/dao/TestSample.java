package com.servinglynk.hmis.warehouse.dao;

import org.apache.commons.lang.StringUtils;

public class TestSample {
	public static void main(String args[]) {
		String aLine =  "/usr/share/tomcat7/tmpFiles/HUD_4_0_4012_65.xml";
	    //aLine = StringUtils.substring(aLine, StringUtils.indexOf(aLine, ":Sources")+1);
	    		aLine =		StringUtils.substringAfterLast(aLine, "/");
	    System.out.println(aLine);
	}
	
	public static void increment(Data data) {
		for(int j=0;j<10;j++) {
			
			System.out.println("::::Value of i::"+data.i);
		}
	}
}


