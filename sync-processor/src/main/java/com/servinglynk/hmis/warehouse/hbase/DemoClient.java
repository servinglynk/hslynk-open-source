/**
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.servinglynk.hmis.warehouse.hbase;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.thrift2.generated.TIOError;
import org.apache.thrift.TException;

public class DemoClient {
  public static void main(String[] args) throws TIOError, TException {
    System.out.println("Thrift2 Demo");
    System.out.println("This demo assumes you have a table called \"example\" with a column family called \"family1\"");
    
    String host = "ec2-52-27-63-94.us-west-2.compute.amazonaws.com";
    int port = 9095;
    int timeout = 10000;
    boolean framed = false;
    System.out.println("Hbase Demo Application ");

    // CONFIGURATION

        // ENSURE RUNNING
    try {
        HBaseConfiguration config = new HBaseConfiguration();
        config.clear();
        config.set("hbase.zookeeper.quorum", host);
        config.set("hbase.zookeeper.property.clientPort","2181");
      //  config.set("hbase.master", "192.168.15.20:60000");
        //HBaseConfiguration config = HBaseConfiguration.create();
//config.set("hbase.zookeeper.quorum", "localhost");  // Here we are running zookeeper locally
        HBaseAdmin.checkHBaseAvailable(config);


        System.out.println("HBase is running!");
    //  createTable(config);    
        //creating a new table
        HTable table = new HTable(config, "emp");
        System.out.println("Table mytable obtained ");  
       // addData(table);
    } catch (MasterNotRunningException e) {
        System.out.println("HBase is not running!");
        System.exit(1);
    }catch (Exception ce){ ce.printStackTrace();} 
  /*  TTransport transport = new TSocket(host, port, timeout);
    if (framed) {
      transport = new TFramedTransport(transport);
    }
    TProtocol protocol = new TBinaryProtocol(transport);
    // This is our thrift client.
    THBaseService.Iface client = new THBaseService.Client(protocol);

    // open the transport
    transport.open();
    
    ByteBuffer table = ByteBuffer.wrap("Sandeep_Test".getBytes());
/*
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

    client.put(table, put) ; */

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
    */
  /*  transport.close(); 
  } */
  }
}
