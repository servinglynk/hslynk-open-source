package com.servinglynk.hmis.warehouse;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HBaseAdmin;

/**
 * Created by sandeep
 */
public class HbaseUtil {

    private static Configuration conf = null;

    public static HBaseAdmin getAdmin() throws Exception {
        conf = getConfiguration();
        HBaseAdmin admin = new HBaseAdmin(conf);
        return admin;
    }

    public static Configuration getConfiguration()
    {
        if(conf == null)
        {
            conf = HBaseConfiguration.create();
            conf.set("hbase.master", Properties.HBASE_MASTER);
            conf.set("hbase.zookeeper.quorum", Properties.HBASE_ZOOKEEPER_QUORUM);
            conf.set("hbase.zookeeper.property.clientPort", Properties.HBASE_ZOOKEEPER_PROPERTY_CLIENT_PORT);
        }
        return conf;
    }


}
