package com.servinglynk.hmis.warehouse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.log4j.Logger;

public class CreateTable extends Logging{
//	 HBaseAdmin admin = null;
//	 Configuration conf = null;
//	    String host = "ec2-52-25-176-93.us-west-2.compute.amazonaws.com";
//	 public CreateTable() {
//	  conf = HBaseConfiguration.create();
//	  conf.set("hbase.master", host);
//	  conf.set("hbase.zookeeper.quorum", host);
//	  conf.set("hbase.zookeeper.property.clientPort","2181");
//	 }
	public static void main(String args[]) {
		//createTables();
	}

	public HTable createTables(BulkUpload upload, Logger logger) throws Exception {
		String projectGroup = upload.getProjectGroupCode();
		List<String> tablesList = new ArrayList<String>();
		populateTablesList(tablesList, projectGroup, upload);
		HTable table = null;
		try {
			HBaseAdmin admin = HbaseUtil.getAdmin();
			//if (!admin.isTableAvailable(tableName)) {
			for (String tableName : tablesList) {
				try {
					HTableDescriptor tableDescriptor = new HTableDescriptor(
							tableName);
					tableDescriptor.addFamily(new HColumnDescriptor("CF"));
					admin.createTable(tableDescriptor);
					logger.info("Table ::" + tableName + " created.");
				} catch (TableExistsException ex) {
					logger.warn("Table :: " + tableName + " already exists.");
				}
			}
		} catch (Exception e) {
			logger.error(e);
			throw e;
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
