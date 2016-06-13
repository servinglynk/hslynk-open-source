package com.servinglynk.hmis.warehouse;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HBaseAdmin;

/**
 * Created by sandeep
 */
public class HbaseUtil {

    //private static HBaseAdmin admin = null;
    private static Configuration conf = null;
    private static String host = "ec2-52-25-176-93.us-west-2.compute.amazonaws.com";

    public static HBaseAdmin getAdmin() throws Exception {
//        if(admin == null) {
//                conf = getConfiguration();
//                conf.set("hbase.master", host);
//                conf.set("hbase.zookeeper.quorum", host);
//                conf.set("hbase.zookeeper.property.clientPort", "2181");
//                admin = new HBaseAdmin(conf);
//        }
        conf = getConfiguration();
        conf.set("hbase.master", host);
        conf.set("hbase.zookeeper.quorum", host);
        conf.set("hbase.zookeeper.property.clientPort", "2181");
        HBaseAdmin admin = new HBaseAdmin(conf);
        return admin;
    }

    public static Configuration getConfiguration()
    {
        if(conf == null)
        {
            conf = HBaseConfiguration.create();
            conf.set("hbase.master", host);
            conf.set("hbase.zookeeper.quorum", host);
            conf.set("hbase.zookeeper.property.clientPort", "2181");
        }
        return conf;
    }
}
