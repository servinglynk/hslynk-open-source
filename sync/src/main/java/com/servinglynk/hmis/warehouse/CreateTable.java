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
		tablesList.add("Affiliation_"+projectGroup+"_2014");
		tablesList.add("Bedinventory_"+projectGroup+"_2014");
		tablesList.add("Client_"+projectGroup+"_2014");
		tablesList.add("Commercialsexualexploitation_"+projectGroup+"_2014");
		tablesList.add("Connectionwithsoar_"+projectGroup+"_2014");
		tablesList.add("Dateofengagement_"+projectGroup+"_2014");
		tablesList.add("Disabilities_"+projectGroup+"_2014");
		tablesList.add("Domesticviolence_"+projectGroup+"_2014");
		tablesList.add("Employment_"+projectGroup+"_2014");
		tablesList.add("Enrollment_"+projectGroup+"_2014");
		tablesList.add("EnrollmentCoc_"+projectGroup+"_2014");
		tablesList.add("Exit_"+projectGroup+"_2014");
		tablesList.add("Exithousingassessment_"+projectGroup+"_2014");
		tablesList.add("Exitplansactions_"+projectGroup+"_2014");
		tablesList.add("Export_"+projectGroup+"_2014");
		tablesList.add("Familyreunification_"+projectGroup+"_2014");
		tablesList.add("Formerwardchildwelfare_"+projectGroup+"_2014");
		tablesList.add("Formerwardjuvenilejustice_"+projectGroup+"_2014");
		tablesList.add("Funder_"+projectGroup+"_2014");
		tablesList.add("Healthinsurance_"+projectGroup+"_2014");
		tablesList.add("HealthStatus_"+projectGroup+"_2014");
		tablesList.add("Housingassessmentdisposition_"+projectGroup+"_2014");
		tablesList.add("Incomeandsources_"+projectGroup+"_2014");
		tablesList.add("Inventory_"+projectGroup+"_2014");
		tablesList.add("Lastgradecompleted_"+projectGroup+"_2014");
		tablesList.add("Lastpermanentaddress_"+projectGroup+"_2014");
		tablesList.add("Medicalassistance_"+projectGroup+"_2014");
		tablesList.add("Noncashbenefits_"+projectGroup+"_2014");
		tablesList.add("Organization_"+projectGroup+"_2014");
		tablesList.add("Pathstatus_"+projectGroup+"_2014");
		tablesList.add("Percentami_"+projectGroup+"_2014");
		tablesList.add("Project_"+projectGroup+"_2014");
		tablesList.add("Projectcoc_"+projectGroup+"_2014");
		tablesList.add("Projectcompletionstatus_"+projectGroup+"_2014");
		tablesList.add("Referralsource_"+projectGroup+"_2014");
		tablesList.add("Residentialmoveindate_"+projectGroup+"_2014");
		tablesList.add("Rhybcpstatus_"+projectGroup+"_2014");
		tablesList.add("Schoolstatus_"+projectGroup+"_2014");
		tablesList.add("Services_"+projectGroup+"_2014");
		tablesList.add("Sexualorientation_"+projectGroup+"_2014");
		tablesList.add("Site_"+projectGroup+"_2014");
		tablesList.add("Source_"+projectGroup+"_2014");
		tablesList.add("VeteranInfo_"+projectGroup+"_2014");
		tablesList.add("Worsthousingsituation_"+projectGroup+"_2014");
		tablesList.add("Youthcriticalissues_"+projectGroup+"_2014");
		
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
