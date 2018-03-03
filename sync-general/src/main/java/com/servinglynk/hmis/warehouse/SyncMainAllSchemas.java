package com.servinglynk.hmis.warehouse;

import org.apache.log4j.Logger;


public class SyncMainAllSchemas {
	public static void main(String args[]) throws Exception {
		Logger logger = Logger.getLogger(SyncMainAllSchemas.class.getName());
		Properties props = new Properties();
		props.generatePropValues();
		props.printProps();
		new SyncSchema(logger).syncBase(true);
	    new SyncSchema(logger).sync(true);
	}
}
