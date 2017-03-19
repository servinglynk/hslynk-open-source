package com.servinglynk.hmis.warehouse;

import org.apache.log4j.Logger;

public class SyncLive2014 {
    public static void main(String args[]) throws Exception {
        Logger logger = Logger.getLogger(SyncLive2014.class.getName());
        Properties props = new Properties();
        props.generatePropValues();
        props.printProps();

        while(true){
            new SyncSchema(VERSION.V2014, logger, Status.LIVE, true).sync();
        }
    }
}
