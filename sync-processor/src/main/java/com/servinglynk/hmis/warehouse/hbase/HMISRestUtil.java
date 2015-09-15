package com.servinglynk.hmis.warehouse.hbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.rest.client.Client;
import org.apache.hadoop.hbase.rest.client.Cluster;
import org.apache.hadoop.hbase.rest.client.RemoteHTable;
import org.apache.hadoop.hbase.util.Bytes;

public class HMISRestUtil {
	 public static void main(String[] args) {

		 HMISRestUtil util = new HMISRestUtil();
		// util.insertHmisUser("personal","row1", "hmisuser");
	        Cluster cluster = new Cluster();
	        cluster.add("ec2-54-149-8-196.us-west-2.compute.amazonaws.com", 8085); // co RestExample-1-Cluster Set up a cluster list adding all known REST server hosts.
	        Client client = new Client(cluster); // co RestExample-2-Client Create the client handling the HTTP communication.
	        RemoteHTable table = new RemoteHTable(client, "hmisuser"); // co RestExample-3-Table Create a remote table instance, wrapping the REST access into a familiar interface.
	        
//	        SingleColumnValueFilter filter=new SingleColumnValueFilter(Bytes.toBytes("f1"),Bytes.toBytes("c5"),CompareFilt.CompareOp.EQUAL,new SubstringComparator("2_c5"));
	        List<Filter> filters = new ArrayList<Filter>();  
	        Filter filter1 = new SingleColumnValueFilter(Bytes  
                    .toBytes("name"), null, CompareOp.EQUAL, Bytes  
                    .toBytes("sandeepeasdfasdf"));  
            filters.add(filter1);  
            FilterList filterList1 = new FilterList(filters);  
	        Scan scan = new Scan();
	        scan.setFilter(filterList1);  
	      //  scan.setStartRow(Bytes.toBytes("row1"));
	     //   scan.setStopRow(Bytes.toBytes("row1"));
	       // scan.addColumn(Bytes.toBytes("personal data"), Bytes.toBytes("name"));
	        ResultScanner scanner = null; // co RestExample-5-Scan Scan the table, again, the same approach as if using the native Java API.
	        try {
	            scanner = table.getScanner(scan);
	        } catch (IOException e) {
	            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
	        }

	        for (Result result2 : scanner) {
	        	System.out.println("Result :"+new String(result2.getValue(Bytes.toBytes("personaldata"), Bytes.toBytes("name"))));
	            System.out.println("Scan row[" + Bytes.toString(result2.getRow()) +
	                    "]: " + result2);
	        }
 
	   }
	 
	 private RemoteHTable getTable(String tableName)
	 {
		 Cluster cluster = new Cluster();
	        cluster.add("ec2-54-149-8-196.us-west-2.compute.amazonaws.com", 8085); // co RestExample-1-Cluster Set up a cluster list adding all known REST server hosts.
	        Client client = new Client(cluster); // co RestExample-2-Client Create the client handling the HTTP communication.
	        return new RemoteHTable(client, tableName); // co RestExample-3-Table Create a remote table instanc
	 }
//	 
//	 private void insertHmisUser(String columnFamily,String rowKey,String tableName)
//	 {
//		  
//		 HmisUser personal = new HmisUser();
//		 personal.setDob(new Date());
//		 personal.setFirstName("Sandeep");
//		 personal.setLastName("abc");
//		 personal.setMiddleName("asdf");
//		 personal.setNameSuffix("Mr");
//		 personal.setSsn("1234667890");
//		 
//		  RemoteHTable table = getTable(tableName);
//		  byte[] row=Bytes.toBytes(rowKey);
//		  try {
//			//table.delete(new Delete(row));
//			 Put put=new Put(row);
////			  byte[] family=Bytes.toBytes("personal");
////			  put.add(family,Bytes.toBytes("firstName"),Bytes.toBytes(personal.getFirstName()));
////			  put.add(family,Bytes.toBytes("lastName"),Bytes.toBytes(personal.getLastName()));
////			  put.add(family,Bytes.toBytes("middleName"),Bytes.toBytes(personal.getMiddleName()));
////			  put.add(family,Bytes.toBytes("namesuffix"),Bytes.toBytes(personal.getNameSuffix()));
////			  put.add(family,Bytes.toBytes("ssn"),Bytes.toBytes(personal.getSsn()));
//			 put.add(Bytes.toBytes("personal"), Bytes.toBytes("firstname"),
//			     Bytes.toBytes("abcd"));
//			  table.put(put);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 
//		  
//	 }
}
