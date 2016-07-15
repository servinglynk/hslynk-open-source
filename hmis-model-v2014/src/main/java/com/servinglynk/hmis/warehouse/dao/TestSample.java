package com.servinglynk.hmis.warehouse.dao;

import org.apache.commons.lang.StringUtils;

public class TestSample {
	public static void main(String args[]) {
		String aLine =  "<hmis_0:Sources xmlns:hmis=\"http://www.hudhdx.info/Resources/Vendors/4_1_1/HUD_HMIS.xsd";
	    //aLine = StringUtils.substring(aLine, StringUtils.indexOf(aLine, ":Sources")+1);
	    		aLine =		StringUtils.remove(aLine, "hmis_0:");
	    System.out.println(aLine);
	}
	
	public static void increment(Data data) {
		for(int j=0;j<10;j++) {
			++data.i;
			System.out.println("::::Value of i::"+data.i);
		}
	}
}


