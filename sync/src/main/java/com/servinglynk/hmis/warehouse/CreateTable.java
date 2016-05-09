package com.servinglynk.hmis.warehouse;

import java.util.ArrayList;
import java.util.List;

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
	//	createTables();
	}

	public static HTable createTables(String projectGroup) {
		
		List<String> tablesList =new ArrayList<String>();
		tablesList.add("Affiliation_"+projectGroup);
		tablesList.add("Bedinventory_"+projectGroup);
		tablesList.add("Client_"+projectGroup);
		tablesList.add("Commercialsexualexploitation_"+projectGroup);
		tablesList.add("Connectionwithsoar_"+projectGroup);
		tablesList.add("Dateofengagement_"+projectGroup);
		tablesList.add("Disabilities_"+projectGroup);
		tablesList.add("Domesticviolence_"+projectGroup);
		tablesList.add("Employment_"+projectGroup);
		tablesList.add("Enrollment_"+projectGroup);
		tablesList.add("EnrollmentCoc_"+projectGroup);
		tablesList.add("Exit_"+projectGroup);
		tablesList.add("Exithousingassessment_"+projectGroup);
		tablesList.add("Exitplansactions_"+projectGroup);
		tablesList.add("Export_"+projectGroup);
		tablesList.add("Familyreunification_"+projectGroup);
		tablesList.add("Formerwardchildwelfare_"+projectGroup);
		tablesList.add("Formerwardjuvenilejustice_"+projectGroup);
		tablesList.add("Funder_"+projectGroup);
		tablesList.add("Healthinsurance_"+projectGroup);
		tablesList.add("HealthStatus_"+projectGroup);
		tablesList.add("Housingassessmentdisposition_"+projectGroup);
		tablesList.add("Incomeandsources_"+projectGroup);
		tablesList.add("Inventory_"+projectGroup);
		tablesList.add("Lastgradecompleted_"+projectGroup);
		tablesList.add("Lastpermanentaddress_"+projectGroup);
		tablesList.add("Medicalassistance_"+projectGroup);
		tablesList.add("Noncashbenefits_"+projectGroup);
		tablesList.add("Organization_"+projectGroup);
		tablesList.add("Pathstatus_"+projectGroup);
		tablesList.add("Percentami_"+projectGroup);
		tablesList.add("Project_"+projectGroup);
		tablesList.add("Projectcoc_"+projectGroup);
		tablesList.add("Projectcompletionstatus_"+projectGroup);
		tablesList.add("Referralsource_"+projectGroup);
		tablesList.add("Residentialmoveindate_"+projectGroup);
		tablesList.add("Rhybcpstatus_"+projectGroup);
		tablesList.add("Schoolstatus_"+projectGroup);
		tablesList.add("Services_"+projectGroup);
		tablesList.add("Sexualorientation_"+projectGroup);
		tablesList.add("Site_"+projectGroup);
		tablesList.add("Source_"+projectGroup);
		tablesList.add("VeteranInfo_"+projectGroup);
		tablesList.add("Worsthousingsituation_"+projectGroup);
		tablesList.add("Youthcriticalissues_"+projectGroup);
		
			  HTable table = null;
			  try {
			   HBaseAdmin admin = HbaseUtil.getAdmin();
			   //if (!admin.isTableAvailable(tableName)) {
				for(String tableName : tablesList) {
					try {
						HTableDescriptor tableDescriptor = new HTableDescriptor(
								tableName);
						tableDescriptor.addFamily(new HColumnDescriptor("CF"));
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
}
