package com.seringlynk.hmis.warehouse;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hbase.thrift2.generated.TColumnValue;
import org.apache.hadoop.hbase.thrift2.generated.THBaseService;
import org.apache.hadoop.hbase.thrift2.generated.TIOError;
import org.apache.hadoop.hbase.thrift2.generated.TPut;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class DemoClient {
 public static void main(String[] args) throws TIOError, TException {
   System.out.println("Thrift2 Demo");
   System.out.println("This demo assumes you have a table called \"example\" with a column family called \"family1\"");
   
   String host = "ec2-54-149-174-17.us-west-2.compute.amazonaws.com";
   int port = 9095;
   int timeout = 10000;
   boolean framed = false;
   System.out.println("Hbase Demo Application ");

   // CONFIGURATION

       // ENSURE RUNNING
  /* try {
	   Configuration conf =  HBaseConfiguration.create();
	//   conf.set("fs.default.name", "hdfs://ec2-54-149-174-17.us-west-2.compute.amazonaws.com:8020");
	   conf.set("hbase.master", "ec2-54-149-174-17.us-west-2.compute.amazonaws.com:60000");
	   conf.set("hbase.zookeeper.quorum", "ec2-54-149-174-17.us-west-2.compute.amazonaws.com");
	   conf.set("hbase.zookeeper.property.clientPort", "2181");
	   */
     /*  HBaseConfiguration config = new HBaseConfiguration();
       config.clear();
       config.set("hbase.zookeeper.quorum", host);
       config.set("hbase.zookeeper.property.clientPort","2181");
     //  config.set("hbase.master", "192.168.15.20:60000"); */
       //HBaseConfiguration config = HBaseConfiguration.create();
//config.set("hbase.zookeeper.quorum", "localhost");  // Here we are running zookeeper locally
   /*    HBaseAdmin.checkHBaseAvailable(conf);


       System.out.println("HBase is running!");
   //  createTable(config);    
       //creating a new table
       HTable table = new HTable(conf, "emp");
       System.out.println("Table mytable obtained ");  
      // addData(table);
   } catch (MasterNotRunningException e) {
       System.out.println("HBase is not running!");
       e.printStackTrace();
       System.exit(1);
   }catch (Exception ce){ ce.printStackTrace();} 
   */
  
   TTransport transport = new TSocket(host, port, timeout);
   if (framed) {
     transport = new TFramedTransport(transport);
   }
   TProtocol protocol = new TBinaryProtocol(transport);
   // This is our thrift client.
   THBaseService.Iface client = new THBaseService.Client(protocol);

   // open the transport
   transport.open();
   
   ByteBuffer table = ByteBuffer.wrap("Sandeep_Test".getBytes());

   TPut put = new TPut();
   put.setRow("123".getBytes());

   TColumnValue columnValue = new TColumnValue();
   columnValue.setFamily("cf1".getBytes());
   columnValue.setQualifier("name".getBytes());
   columnValue.setValue("value11".getBytes());
   columnValue.setTimestamp(System.currentTimeMillis());
   List<TColumnValue> columnValues = new ArrayList<TColumnValue>();
   columnValues.add(columnValue);
   put.setColumnValues(columnValues);

   client.put(table, put) ; 

 /*  TGet get = new TGet();
   get.setRow("456".getBytes());
   get.setMaxVersions(5); 
   TResult result = client.get(table, get);

   System.out.print("row = " + new String(result.getRow()));
   for (TColumnValue resultColumnValue : result.getColumnValues()) {
     System.out.print("family = " + new String(resultColumnValue.getFamily()));
     System.out.print("qualifier = " + new String(resultColumnValue.getQualifier()));
     System.out.print("value = " + new String(resultColumnValue.getValue()));
     System.out.print("timestamp = " + resultColumnValue.getTimestamp());
   }

   transport.close(); 
 //} */
   transport.close(); 
 }
}

