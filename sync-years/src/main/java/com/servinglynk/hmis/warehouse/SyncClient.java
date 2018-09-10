package com.servinglynk.hmis.warehouse;

import org.apache.log4j.Logger;

public class SyncClient {
    public static void main(String args[]) throws Exception {
        Logger logger = Logger.getLogger(SyncLiveDelta.class.getName());
        Properties props = new Properties();
        props.generatePropValues("client.conf");
        props.printProps();
        new SyncDeltaHbase(VERSION.V2017, logger, Status.LIVE, true).sync(true);
        new SyncDeltaHbase(VERSION.V2016, logger, Status.LIVE, true).sync(true);
        new SyncDeltaHbase(VERSION.V2015, logger, Status.LIVE, true).sync(true);
        new SyncDeltaHbase(VERSION.V2014, logger, Status.LIVE, true).sync(true);
    }
}
