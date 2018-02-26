package com.servinglynk.hmis.warehouse;

import org.apache.log4j.Logger;


public class SyncStaging2016 {

	public static void main(String args[]) throws Exception {
		Logger logger = Logger.getLogger(SyncStaging2016.class.getName());
		Properties props = new Properties();
		props.generatePropValues("application.conf");
		props.printProps();

		while(true){
			new SyncSchema(VERSION.V2016, logger, Status.STAGING, false).sync();
		}
	}
}
