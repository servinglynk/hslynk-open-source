package com.servinglynk.hmis.warehouse;

import org.apache.log4j.Logger;

public class SyncLive {
    public static void main(String args[]) throws Exception {
        Logger logger = Logger.getLogger(SyncLive.class.getName());
        Properties props = new Properties();
        props.generatePropValues();
        props.printProps();
        
    	for(VERSION version : VERSION.values()) {
			logger.info("Processing live sync for  version ...."+version.name());
			new SyncSchema(version, logger, Status.LIVE, false).sync();
		}
    }
}
