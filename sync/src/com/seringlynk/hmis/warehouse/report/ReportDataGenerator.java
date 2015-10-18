package com.seringlynk.hmis.warehouse.report;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;

import com.servinglynk.hmis.warehouse.model.Project;

public class ReportDataGenerator<T> {
	
	public T getResult(String rowKey,String tableName,String familyName, T t) {
		HTable table = null;
		try {
			Configuration conf = HBaseConfiguration.create();
			table = new HTable(conf, tableName);
			 Get get = new Get(rowKey.getBytes());
			    Result resultWithKey = table.get(get);
			    get.addFamily(familyName.getBytes());
			    Result rs = table.get(get);
			  //  T t = new T();
		    	Field[] fields = Project.class.getFields();
		    	for(Field field : fields) {
			 		System.out.println("Field is hydrated :"+field.getName()+" type"+field.getType());
			 		byte[] value = rs.getValue("Project".getBytes(), field.getName().getBytes());
			 		if(value !=null) {
			 			if(field.getType().isAssignableFrom(java.util.UUID.class)) {
			 				field.set(t,getGuidFromByteArray(value));
				 		}else{
				 			if(field.getType().isAssignableFrom(java.sql.Timestamp.class)) {
				 				//field.set(project,getValue(value.toString()));
				 				
				 			} else{
				 				field.set(t,new String(value));
				 			}
				 			
				 		}
			 		}
		    	}
			 	System.out.println("Project is hydrated :"+t.toString());
			 	return t;
			 	/*
			    for (KeyValue keyVal : rs.raw()) {
			    	String key = new String(keyVal.getQualifier());
			        String holdvalue = new String(keyVal.getValue());
			        System.out.println("Key is :"+key+" Value: "+holdvalue);
			        // populate the pojo for the report here..
			     // print a report
					// email the report
			    }
			    */
		/* SingleColumnValueFilter filter = new SingleColumnValueFilter(
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
			       
			      }
			    }
			    scanner.close();
			    */
		}catch(Exception e) {
			e.printStackTrace();
		}
		return t;
		
	}
	
	public static void main(String args[]) {
		//Read Data from HBASE
		HTable table = null;
		try {
			Configuration conf = HBaseConfiguration.create();
			table = new HTable(conf, "hmis");
			 Get get = new Get("cd2733e2-7fc1-4e33-a61e-8eb97718cbb0".getBytes());
			    Result resultWithKey = table.get(get);
			    get.addFamily("Project".getBytes());
			    Result rs = table.get(get);
			    Project project = new Project();
		    	Field[] fields = Project.class.getFields();
		    	
			 	for(Field field : fields) {
			 		System.out.println("Field is hydrated :"+field.getName()+" type"+field.getType());
			 		byte[] value = rs.getValue("Project".getBytes(), field.getName().getBytes());
			 		if(value !=null) {
			 			if(field.getType().isAssignableFrom(java.util.UUID.class)) {
			 				field.set(project,getGuidFromByteArray(value));
				 		}else{
				 			if(field.getType().isAssignableFrom(java.sql.Timestamp.class)) {
				 				//field.set(project,getValue(value.toString()));
				 				
				 			} else{
				 				field.set(project,new String(value));
				 			}
				 			
				 		}
			 		}
			 		
		    	}
			 	System.out.println("Project is hydrated :"+project.getProjectname());
			 	/*
			    for (KeyValue keyVal : rs.raw()) {
			    	String key = new String(keyVal.getQualifier());
			        String holdvalue = new String(keyVal.getValue());
			        System.out.println("Key is :"+key+" Value: "+holdvalue);
			        // populate the pojo for the report here..
			     // print a report
					// email the report
			    }
			    */
		/* SingleColumnValueFilter filter = new SingleColumnValueFilter(
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
			       
			      }
			    }
			    scanner.close();
			    */
			  
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static UUID getGuidFromByteArray(byte[] bytes)
    {
        return UUID.nameUUIDFromBytes(bytes);
    }
	
	public static Timestamp getValue(String str_date) {
		DateFormat formatter;
	      formatter = new SimpleDateFormat("yyyy-MM-dd");
	      Date date = new Date();
		try {
			date = (Date) formatter.parse(str_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());

	      return timeStampDate;
	}

}
