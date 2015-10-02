package com.servinglynk.hmis.warehouse.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class ConnectTester {


    public static void main(String[] args) throws Exception {
        Configuration conf = HBaseConfiguration.create();
       // conf.clear();
       // conf.set("hbase.zookeeper.quorum", "ec2-52-27-63-94.us-west-2.compute.amazonaws.com");
        //conf.set("hbase.zookeeper.property.clientPort","2181");
       // conf.set("hbase.master", "ec2-52-27-63-94.us-west-2.compute.amazonaws.com:60010");
        HBaseAdmin admin = new HBaseAdmin(conf);
        admin.checkHBaseAvailable(conf);
        System.out.println("connected");
        HTableDescriptor[] tables = admin.listTables();
        System.out.printf("Found %d table(s)\n", tables.length);
        for (HTableDescriptor table : tables) {
            System.out.printf("%s\n", table.getNameAsString());
        }
    }
}
