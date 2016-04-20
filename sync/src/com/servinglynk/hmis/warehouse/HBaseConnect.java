package com.servinglynk.hmis.warehouse;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HBaseConnect {

 HBaseAdmin admin = null;
 Configuration conf = null;
    String host = "ec2-52-34-38-188.us-west-2.compute.amazonaws.com";
 public HBaseConnect() {
  conf = HBaseConfiguration.create();
  conf.set("hbase.master", host);
  conf.set("hbase.zookeeper.quorum", host);
  conf.set("hbase.zookeeper.property.clientPort","2181");
 }

 public HTable createTable(String tableName, String familyname) {
  HTable table = null;
  try {
   HBaseAdmin admin = new HBaseAdmin(conf);
   //if (!admin.isTableAvailable(tableName)) {
    HTableDescriptor tableDescriptor = new HTableDescriptor(
      tableName);
    tableDescriptor.addFamily(new HColumnDescriptor(familyname));
    admin.createTable(tableDescriptor);
//   } else {
//    System.out.println("Table already existing");
//   }
  } catch (Exception e) {
   e.printStackTrace();
  }
  return table;
 }

 public HTable insert(String tableName, String familyname, String rowkey,
   List<String> columns, List<String> data) {
  HTable table = null;
  try {

   table = new HTable(conf, tableName);

   Put p = new Put(Bytes.toBytes(rowkey));

   for (int i = 0; i < columns.size(); i++) {

    p.addColumn(Bytes.toBytes(familyname),
      Bytes.toBytes(columns.get(i)),
      Bytes.toBytes(data.get(i)));

   }
   table.put(p);
  } catch (Exception e) {
   e.printStackTrace();
  } 
  return table;
 }


 public HTable insert(String tableName, String familyname, String rowkey,
   String[] columns, Map<String, Object> data) {
  HTable table = null;
  try {

   table = new HTable(conf, tableName);

   Put p = new Put(Bytes.toBytes(rowkey));

   for (int i = 0; i < columns.length; i++) {
    if(data.get(columns[i]) !=null) {
     p.addColumn(Bytes.toBytes(familyname),
       Bytes.toBytes(columns[i]),
       Bytes.toBytes(data.get(columns[i]).toString()));
     
    }

   }
   table.put(p);
  } catch (Exception e) {
   e.printStackTrace();
  }
  return table;
 }

 public void checkIfRunning() throws MasterNotRunningException,
   ZooKeeperConnectionException {
  // Create the required configuration.
  // Check if Hbase is running
  try {
   System.out.println("Start checkIfRunning");
   HBaseAdmin.checkHBaseAvailable(conf);
   System.out.println("End checkIfRunning");
  } catch (Exception e) {
   System.out.println("Error checkIfRunning");
   System.err.println("Exception at " + e);
   e.printStackTrace();
   System.exit(1);
  }
 }

 public void isTableAvailable(String tablename) throws IOException {
  HBaseAdmin admin = new HBaseAdmin(conf);
  boolean result = admin.isTableAvailable(tablename);
  System.out.println("Table " + tablename + " available ?" + result);
 }

 public void tableExists(String tablename) throws IOException {
  HBaseAdmin admin = new HBaseAdmin(conf);
  boolean result = admin.tableExists(tablename);
  System.out.println("Table " + tablename + " exists ?" + result);
 }

 public static void main(String[] args) throws IOException {

  // Prints out the given arguments
  for (int i = 0; i < args.length; i++) {
   System.out.println("Argument" + i + ":" + args[i]);
  }

  HBaseImport admin = new HBaseImport();
  admin.checkIfRunning();
  String tableName = "Test_table";
  String familyName = "CF1";

  List<String> columns = new ArrayList<String>(10);
  columns.add("name");
  columns.add("age");
  columns.add("dob");
  columns.add("gender");

  List<List<String>> list = getTestDataForCF1(columns);

  admin.createTable(tableName, familyName);
  System.out.println("***********************");
  admin.isTableAvailable(familyName);
  System.out.println("***********************");
  String rowKey = RandomStringUtils.randomAlphanumeric(10);
  for (Iterator iterator = list.iterator(); iterator.hasNext();) {
   List<String> data = (List<String>) iterator.next();
   admin.insert(tableName, familyName, rowKey, columns, data);
  }

  familyName = "CF2";

  columns = new ArrayList<String>(10);
  columns.add("name1");
  columns.add("age1");
  columns.add("dob1");
  columns.add("gender1");
  list = getTestDataForCF2(columns);

  rowKey = RandomStringUtils.randomAlphanumeric(10);

  for (Iterator iterator = list.iterator(); iterator.hasNext();) {
   List<String> data = (List<String>) iterator.next();
   admin.insert(tableName, familyName, rowKey, columns, data);
  }

  System.out.println("***********************");
 }

 private static List<List<String>> getTestDataForCF1(List<String> columns) {
  List<String> data1 = new ArrayList<String>(10);
  data1.add("Ram");
  data1.add("35");
  data1.add("01/01/1978");
  data1.add("M");

  List<String> data2 = new ArrayList<String>(10);
  data2.add("Ram");
  data2.add("35");
  data2.add("01/01/1978");
  data2.add("M");

  List<String> data3 = new ArrayList<String>(10);
  data3.add("Ram");
  data3.add("35");
  data3.add("01/01/1978");
  data3.add("M");

  List<List<String>> list = new ArrayList<List<String>>();
  list.add(data1);
  list.add(data2);
  list.add(data3);
  return list;
 }

 private static List<List<String>> getTestDataForCF2(List<String> columns) {
  List<String> data1 = new ArrayList<String>(10);
  data1.add("HBase1");
  data1.add("4");
  data1.add("01/01/2003");
  data1.add("M");

  List<String> data2 = new ArrayList<String>(10);
  data2.add("HBase2");
  data2.add("5");
  data2.add("01/01/2002");
  data2.add("M");

  List<String> data3 = new ArrayList<String>(10);
  data3.add("HBase3");
  data3.add("6");
  data3.add("01/01/2001");
  data3.add("M");

  List<List<String>> list = new ArrayList<List<String>>();
  list.add(data1);
  list.add(data2);
  list.add(data3);
  return list;
 }
}