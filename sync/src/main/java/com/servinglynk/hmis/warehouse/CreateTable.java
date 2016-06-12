package com.servinglynk.hmis.warehouse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableExistsException;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;

public class CreateTable {
//	 HBaseAdmin admin = null;
//	 Configuration conf = null;
//	    String host = "ec2-52-34-38-188.us-west-2.compute.amazonaws.com";
//	 public CreateTable() {
//	  conf = HBaseConfiguration.create();
//	  conf.set("hbase.master", host);
//	  conf.set("hbase.zookeeper.quorum", host);
//	  conf.set("hbase.zookeeper.property.clientPort","2181");
//	 }
	public static void main(String args[]) {
		//createTables();
	}

	public static HTable createTables(BulkUpload upload) {
		String projectGroup = upload.getProjectGroupCode();
		List<String> tablesList =new ArrayList<String>();
		populateTablesList(tablesList,projectGroup,upload);
			  HTable table = null;
			  try {
			   HBaseAdmin admin = HbaseUtil.getAdmin();
			   //if (!admin.isTableAvailable(tableName)) {
				for(String tableName : tablesList) {
					try {
						HTableDescriptor tableDescriptor = new HTableDescriptor(
								tableName);
						tableDescriptor.addFamily(new HColumnDescriptor("CF"));
						admin.disableTable(tableName);
						admin.deleteTable(tableName);
						admin.createTable(tableDescriptor);
						System.out.println("Table ::" + tableName + " created.");
					} catch (TableExistsException ex) {
						System.out.println("Table :: " + tableName + " already exists.");
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return table;
	}
	
	public static void populateTablesList(List<String> tablesList,String projectGroup,BulkUpload upload) {
		String schema = BaseProcessor.getSchemaFromYear(upload);
		final Map<String, Class<? extends BaseModel>> alltablesV2014 = StringUtils.equals(schema, "v2014") ? BaseProcessor.getAlltablesV2014() : BaseProcessor.getAlltablesV2015();
		Collection<Class<? extends BaseModel>> values = alltablesV2014.values();
		for(Class<? extends BaseModel> model : values) {
			tablesList.add(model.getSimpleName()+"_"+projectGroup);
		}
	}
}
