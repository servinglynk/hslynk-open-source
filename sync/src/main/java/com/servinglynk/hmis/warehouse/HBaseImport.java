package com.servinglynk.hmis.warehouse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;
import org.datanucleus.store.connection.*;

public class HBaseImport extends Logging{
	private HBaseAdmin admin = null;
	private int batchSize = 100000;
	public HBaseImport() throws Exception{
		admin = HbaseUtil.getAdmin();
	}
	public HTable createTable(String tableName, String familyname) {
		HTable table = null;
		try {
			//if (!admin.isTableAvailable(tableName)) {
				HTableDescriptor tableDescriptor = new HTableDescriptor(
						tableName);
				tableDescriptor.addFamily(new HColumnDescriptor(familyname));
				admin.createTable(tableDescriptor);
//			} else {
//				System.out.println("Table already existing");
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return table;
	}

	public void closeAdmin() throws Exception{
		admin.close();
	}

	public HTable insert(String tableName, String familyname, String rowkey,
			List<String> columns, List<String> data) {
		HTable table = null;
		try {

			table = new HTable(HbaseUtil.getConfiguration(), tableName);

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


	public HTable insert(HTable table, String familyname, String rowkey,
			String[] columns, Map<String, Object> data) {
		try {

			Put p = new Put(Bytes.toBytes(rowkey));

			for(String key :data.keySet()) {
				String value = (String)data.get(key);
				if(StringUtils.isNotEmpty(key) && StringUtils.isNotEmpty(value)) {
					p.addColumn(Bytes.toBytes(familyname),
							Bytes.toBytes(key),
							Bytes.toBytes(value));
				  }
				}
		/*	for (int i = 0; i < columns.length; i++) {
				if(data.get(columns[i]) !=null) {
					p.addColumn(Bytes.toBytes(familyname),
							Bytes.toBytes(columns[i]),
							Bytes.toBytes(data.get(columns[i]).toString()));
					
				}
			} */
			table.put(p);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return table;
	}

	public HTable insertDataInBatch(HTable table, String familyname, Map<String, Map<String, Object>> dataList) {
		try {
			List<Put> puts = new ArrayList<>();
			int count = 0;
			long startGenerating = System.nanoTime();
			for (String rowKey : dataList.keySet()) {
				Map<String, Object> data = dataList.get(rowKey);

				Put p = new Put(Bytes.toBytes(rowKey));

				for (String key : data.keySet()) {
					String value = (String) data.get(key);
					if (StringUtils.isNotEmpty(key) && StringUtils.isNotEmpty(value)) {
						p.addColumn(Bytes.toBytes(familyname),
								Bytes.toBytes(key),
								Bytes.toBytes(value));
					}
				}
				puts.add(p);
				count++;
				if (count > batchSize) {
					//log.info("[" + table.getName().getNameAsString() + "]Time taken to generate " + count + " records in miliseconds: " +
					//		TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startGenerating));
					//long startWriting = System.nanoTime();
					table.put(puts);
					//log.info("[" + table.getName().getNameAsString() + "]Time taken to insert " + count + " records in miliseconds: " +
					//		TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startWriting));
					puts.clear();
					//startGenerating = System.nanoTime();
					count = 0;
				}
			}
//			log.info("[" + table.getName().getNameAsString() + "]Time taken to generate " + count + " records in miliseconds: " +
//					TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startGenerating));

			if (puts.size() > 0) {
				//long startWriting = System.nanoTime();
				table.put(puts);
//				log.info("[" + table.getName().getNameAsString() + "]Time taken to insert " + count + " records in miliseconds: " +
//						TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startWriting));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return table;
	}
	 	
	public void updateData(HTable table ,String rowKey, Map<String, Object> data) {
		try {
		      //accepts a row name
		      Put p = new Put(Bytes.toBytes(rowKey));
		      // Updating a cell value
		  //    p.add(Bytes.toBytes("CF"),
		   //  Bytes.toBytes("date_updated"),Bytes.toBytes();
		      String deleted =(String) data.get("deleted");
		      p.add(Bytes.toBytes("CF"),
		 		     Bytes.toBytes("deleted"),Bytes.toBytes(deleted !=null? deleted:"false"));
		      // Saving the put Instance to the HTable.
		      table.put(p);

		      // closing HTable
		      //table.close();
//			}
	      // closing the HTable object
																																																																																																																																																																																																																																																																																																																																																																																																									
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteDataInBatch(HTable table, List<String> dataIds){
		List<Delete> deletes = new ArrayList<>();
		for(String id : dataIds){
			deletes.add(new Delete(Bytes.toBytes(id)));
		}
		try {
			table.delete(deletes);
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}


	public void updateDataInBatch(HTable table, Map<String, Map<String, Object>> dataList) {
		try {
			List<Put> puts = new ArrayList<>();
			int count = 0;
			for (String rowKey : dataList.keySet()) {
				Map<String, Object> data = dataList.get(rowKey);
				//accepts a row name
				Put p = new Put(Bytes.toBytes(rowKey));
				// Updating a cell value
				//    p.add(Bytes.toBytes("CF"),
				//  Bytes.toBytes("date_updated"),Bytes.toBytes();
				String deleted = (String) data.get("deleted");
				p.add(Bytes.toBytes("CF"),
						Bytes.toBytes("deleted"), Bytes.toBytes(deleted != null ? deleted : "false"));
				puts.add(p);
				count++;
				if (count > batchSize) {
					table.put(puts);
					puts.clear();
					count = 0;
				}
			}
			if (puts.size() > 0) {
				table.put(puts);
			}

			// closing HTable
			//table.close();
//			}
			// closing the HTable object

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkIfRunning() throws MasterNotRunningException,
			ZooKeeperConnectionException {
		// Create the required configuration.
		// Check if Hbase is running
		try {
			System.out.println("Start checkIfRunning");
			HBaseAdmin.checkHBaseAvailable(HbaseUtil.getConfiguration());
			System.out.println("End checkIfRunning");
		} catch (Exception e) {
			System.out.println("Error checkIfRunning");
			System.err.println("Exception at " + e);
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void isTableAvailable(String tablename) throws Exception {
		boolean result = HbaseUtil.getAdmin().isTableAvailable(tablename);
		System.out.println("Table " + tablename + " available ?" + result);
	}

	/**
	 * Scan (or list) a table
	 */
	public List<String> getAllKeyRecords (HTable table) {
		List<String> keys = new ArrayList<>();
		try {
			Scan s = new Scan();
			ResultScanner ss = table.getScanner(s);
			for (Result r : ss) {
				keys.add(new String(r.raw()[0].getRow()));
				//log.info(new String(r.raw()[0].getRow()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return keys;
	}


	public boolean isDataExist(HTable table, String rowKey) {
		try {

			// Instantiating Get class
			Get g = new Get(Bytes.toBytes(rowKey));
			g.setCheckExistenceOnly(true);
			// Reading the data
			Result result = table.get(g);
			if (result != null && !result.isEmpty()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void tableExists(String tablename) throws Exception {
		boolean result = HbaseUtil.getAdmin().tableExists(tablename);
		System.out.println("Table " + tablename + " exists ?" + result);
	}

	public static void main(String[] args) throws Exception {

		// Prints out the given arguments
		for (int i = 0; i < args.length; i++) {
			System.out.println("Argument" + i + ":" + args[i]);
		}

		HBaseImport admin = new HBaseImport();
		//HBaseImport.checkIfRunning();
		String tableName = "Test_table";
		String familyName = "CF1";

//		List<String> columns = new ArrayList<String>(10);
//		columns.add("name");
//		columns.add("age");
//		columns.add("dob");
//		columns.add("gender");
//
//		List<List<String>> list = getTestDataForCF1(columns);
//
//		admin.createTable(tableName, familyName);
//		System.out.println("***********************");
//		admin.isTableAvailable(familyName);
//		System.out.println("***********************");
//		String rowKey = RandomStringUtils.randomAlphanumeric(10);
//		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
//			List<String> data = (List<String>) iterator.next();
//			admin.insert(tableName, familyName, rowKey, columns, data);
//		}
//
//		familyName = "CF2";
//
//		columns = new ArrayList<String>(10);
//		columns.add("name1");
//		columns.add("age1");
//		columns.add("dob1");
//		columns.add("gender1");
//		list = getTestDataForCF2(columns);
//
//		rowKey = RandomStringUtils.randomAlphanumeric(10);
//
//		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
//			List<String> data = (List<String>) iterator.next();
//			admin.insert(tableName, familyName, rowKey, columns, data);
//		}
		//admin.updateData("Affiliation", "3791a0ca-6eef-4419-a7a7-352ddeca7e79");
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
