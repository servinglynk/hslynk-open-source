package com.servinglynk.hmis.warehouse.report;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.hbase.util.Bytes;

import com.servinglynk.hmis.warehouse.model.v2014.Client;

public class ReportDataGenerator<T> {
	
	public void getAllResults(String tableName) {
		HTable table = null;
		try {
			Configuration conf = HBaseConfiguration.create();
			table = new HTable(conf, tableName);
		  Scan s = new Scan();
          ResultScanner ss = table.getScanner(s);
          for(Result r:ss){
              for(KeyValue kv : r.raw()){
                 System.out.print(new String(kv.getRow()) + " ");
                 System.out.print(new String(kv.getFamily()) + ":");
                 System.out.print(new String(kv.getQualifier()) + " ");
                 System.out.print(kv.getTimestamp() + " ");
                 System.out.println(new String(kv.getValue()));
              }
          }
		}catch(Exception ex) {
			
		}
	}
	
	public List<T> getResult(String rowKey,String tableName,String familyName, Class<T> tClass) {
		HTable table = null;
		List<T> tList = new ArrayList<T>();
		try {
			Configuration conf = HBaseConfiguration.create();
			table = new HTable(conf, tableName);
			 Get get = new Get(rowKey.getBytes());
			    Result resultWithKey = table.get(get);
			    get.addFamily(familyName.getBytes());
			    Result rs = table.get(get);
			    String previousKey = "";
			    T t = tClass.newInstance();
			    boolean isFirstRecord = true;
		    	 for (KeyValue kv : rs.list()) {
		    		 byte[] row = kv.getRow();
		    		 //System.out.println("ROW Key::"+new String(row));	
		    		 String currentKey = new String(row);
		    	       //System.out.println("Key is " + ". kv: " +currentKey +" Value ::"+kv.getValue().toString());
		    	       
		    	       if(!currentKey.equals(previousKey) && !isFirstRecord) {
		    	    	   System.out.println("New instance created...."+previousKey+" Current key"+kv.toString());
		    	    	   tList.add(t);
		    	    	   t = tClass.newInstance();
		    	       }
		    	       Field[] fields = tClass.getFields();
				    	for(Field field : fields) {
					 	//	System.out.println("Field is hydrated :"+field.getName()+" type"+field.getType());
					 		byte[] resultValue = rs.getValue(familyName.getBytes(), field.getName().getBytes());
					 		if(resultValue !=null) {
					 			if(field.getType().isAssignableFrom(java.util.UUID.class)) {
					 				field.set(t,getGuidFromByteArray(resultValue));
						 		}else{
						 			if(field.getType().isAssignableFrom(java.sql.Timestamp.class)) {
						 				//field.set(project,getValue(value.toString()));
						 			} else{
						 				field.set(t,new String(resultValue));
						 			}
						 			
						 		}
					 		}
		    	      }
				    	previousKey = currentKey;
				    	isFirstRecord = false;
		      }
		    	 tList.add(t);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return tList;
	}
	
	public List<T> findScannedResult(String tableName,String columnFamily,String qualifier,String value,CompareOp compareOp, Class<T> tClass) {
		HTable table = null;
		List<T> tList = new ArrayList<T>();
		try {
			Configuration conf = HBaseConfiguration.create();
			table = new HTable(conf, tableName);
			SingleColumnValueFilter filter = new SingleColumnValueFilter(
			      Bytes.toBytes(columnFamily),
			      Bytes.toBytes(qualifier),
			      compareOp,
			      new SubstringComparator(value));
					filter.setFilterIfMissing(true);

			    Scan scan = new Scan();
			    scan.setFilter(filter);
			    scan.addFamily(Bytes.toBytes(columnFamily));
			    ResultScanner scanner = table.getScanner(scan);
			    System.out.println("Starting the scan.....");
			    String previousKey = "";
			    T t = null;
			    boolean isFirstRecord = true;
			    for (Result result : scanner) {
			    	 for (      KeyValue kv : result.list()) {
			    		 if(isFirstRecord) {
			    			 t = tClass.newInstance();
			    		 }
			    		 byte[] row = kv.getRow();
			    		 String currentKey = new String(row);
			    	       if(!currentKey.equals(previousKey) && !isFirstRecord) {
			    	    	   System.out.println("New instance created...."+previousKey+" Current key"+kv.toString());
			    	    	   tList.add(t);
			    	    	   t = tClass.newInstance();
			    	       }
			    	       Field[] fields = tClass.getFields();
					    	for(Field field : fields) {
						 	//	System.out.println("Field is hydrated :"+field.getName()+" type"+field.getType());
						 		byte[] resultValue = result.getValue(columnFamily.getBytes(), field.getName().getBytes());
						 		if(resultValue !=null) {
						 			if(field.getType().isAssignableFrom(java.util.UUID.class)) {
						 				field.set(t,getGuidFromByteArray(resultValue));
							 		}else{
							 			if(field.getType().isAssignableFrom(java.sql.Timestamp.class)) {
							 				//field.set(project,getValue(value.toString()));
							 			} else{
							 				field.set(t,new String(resultValue));
							 			}
							 			
							 		}
						 		}
			    	      }
					    	previousKey = currentKey;
					    	isFirstRecord = false;
			      }
			    		 tList.add(t);
			    	 
			    }
			    scanner.close();
			    table.close();
	}catch(Exception e){
		e.printStackTrace();
	}
		return tList;
	}
	public static void main(String args[]) {
		ReportDataGenerator<Client> clientGenerator = new ReportDataGenerator<Client>();
		//clientGenerator.getResult("ce116a3de-36a5-4c3a-a6c3-4e0abb9562cc", "Client", "CF", client);
		List<Client> clients = clientGenerator.findScannedResult("Client", "CF", "dob_data_quality", "9",CompareFilter.CompareOp.EQUAL,Client.class);
		System.out.println("Size::"+clients.size());
		for(Client client : clients) {
			System.out.println("Name DAta Quality"+client.getDob_data_quality());
			System.out.println("Name ID "+client.getId());
		}
		
		List<Client> clientsZero = clientGenerator.findScannedResult("Client", "CF", "name_data_quality", "232",CompareFilter.CompareOp.EQUAL,Client.class);
		System.out.println("Size::"+clientsZero.size());
		if(clientsZero !=null) {
			for(Client client : clientsZero) {
				System.out.println("Name DAta Quality"+client.getName_data_quality());
				System.out.println("Name SSN "+client.getSsn());
			}
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
