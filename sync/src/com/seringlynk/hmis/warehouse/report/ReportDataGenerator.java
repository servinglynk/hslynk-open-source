package com.seringlynk.hmis.warehouse.report;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.hbase.util.Bytes;

public class ReportDataGenerator {
	
	public static void main(String args[]) {
		//Read Data from HBASE
		HTable table = null;
		try {
			Configuration conf = HBaseConfiguration.create();
			table = new HTable(conf, "hmis");
		 SingleColumnValueFilter filter = new SingleColumnValueFilter(
			      Bytes.toBytes("Project"),
			      Bytes.toBytes("projectname"),
			      CompareFilter.CompareOp.EQUAL,
			      new SubstringComparator("APR - Services Only"));
			    filter.setFilterIfMissing(true);

			    Scan scan = new Scan();
			    scan.setFilter(filter);
			    ResultScanner scanner = table.getScanner(scan);
			    for (Result result : scanner) {
			      for (KeyValue kv : result.raw()) {
			        System.out.println("KV: " + kv + ", Value: " +
			          Bytes.toString(kv.getValue()));
			        Get get = new Get(kv.getValue());
				    get.setFilter(filter);
				    Result resultWithKey = table.get(get);
				    get.addFamily("Project".getBytes());
				    Result rs = table.get(get);
				    for (KeyValue keyVal : rs.raw()) {
				    	String key = new String(keyVal.getKey());
				        String holdvalue = new String(keyVal.getValue());
				        System.out.println("Key is :"+key+" Value: "+holdvalue);
				        // populate the pojo for the report here..
				     // print a report
						// email the report
				    }
			      }
			    }
			    scanner.close();
			    
			  
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
