package com.servinglynk.hmis.warehouse;

import org.apache.log4j.Logger;


public class SyncStaging {

	public static void main(String args[]) throws Exception {
		Logger logger = Logger.getLogger(SyncStaging.class.getName());
		Properties props = new Properties();
		props.generatePropValues();
		props.printProps();
		for(VERSION version : VERSION.values()) {
			logger.info("Processing staging sync for  version ...."+version.name());
			new SyncSchema(version, logger, Status.STAGING, false).sync();
		}
	}
}
