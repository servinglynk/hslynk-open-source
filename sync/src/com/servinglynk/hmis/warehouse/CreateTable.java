package com.servinglynk.hmis.warehouse;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;

public class CreateTable {
	 HBaseAdmin admin = null;
	 Configuration conf = null;
	    String host = "ec2-52-34-38-188.us-west-2.compute.amazonaws.com";
	 public CreateTable() {
	  conf = HBaseConfiguration.create();
	  conf.set("hbase.master", host);
	  conf.set("hbase.zookeeper.quorum", host);
	  conf.set("hbase.zookeeper.property.clientPort","2181");
	 }
	public static void main(String args[]) {
		CreateTable table = new CreateTable();
		table.createTable("good");
	}

	public HTable createTable(String tableName) {
		
		List<String> tablesList =new ArrayList<String>();
		tablesList.add("Affiliation_CP0004_2014");
		tablesList.add("Bedinventory_CP0004_2014");
		tablesList.add("Client_CP0004_2014");
		tablesList.add("Commercialsexualexploitation_CP0004_2014");
		tablesList.add("Connectionwithsoar_CP0004_2014");
		tablesList.add("Dateofengagement_CP0004_2014");
		tablesList.add("Disabilities_CP0004_2014");
		tablesList.add("Domesticviolence_CP0004_2014");
		tablesList.add("Employment_CP0004_2014");
		tablesList.add("Enrollment_CP0004_2014");
		tablesList.add("EnrollmentCoc_CP0004_2014");
		tablesList.add("Exit_CP0004_2014");
		tablesList.add("Exithousingassessment_CP0004_2014");
		tablesList.add("Exitplansactions_CP0004_2014");
		tablesList.add("Export_CP0004_2014");
		tablesList.add("Familyreunification_CP0004_2014");
		tablesList.add("Formerwardchildwelfare_CP0004_2014");
		tablesList.add("Formerwardjuvenilejustice_CP0004_2014");
		tablesList.add("Funder_CP0004_2014");
		tablesList.add("Healthinsurance_CP0004_2014");
		tablesList.add("HealthStatus_CP0004_2014");
		tablesList.add("Housingassessmentdisposition_CP0004_2014");
		tablesList.add("Incomeandsources_CP0004_2014");
		tablesList.add("Inventory_CP0004_2014");
		tablesList.add("Lastgradecompleted_CP0004_2014");
		tablesList.add("Lastpermanentaddress_CP0004_2014");
		tablesList.add("Medicalassistance_CP0004_2014");
		tablesList.add("Noncashbenefits_CP0004_2014");
		tablesList.add("Organization_CP0004_2014");
		tablesList.add("Pathstatus_CP0004_2014");
		tablesList.add("Percentami_CP0004_2014");
		tablesList.add("Project_CP0004_2014");
		tablesList.add("Projectcoc_CP0004_2014");
		tablesList.add("Projectcompletionstatus_CP0004_2014");
		tablesList.add("Referralsource_CP0004_2014");
		tablesList.add("Residentialmoveindate_CP0004_2014");
		tablesList.add("Rhybcpstatus_CP0004_2014");
		tablesList.add("Schoolstatus_CP0004_2014");
		tablesList.add("Services_CP0004_2014");
		tablesList.add("Sexualorientation_CP0004_2014");
		tablesList.add("Site_CP0004_2014");
		tablesList.add("Source_CP0004_2014");
		tablesList.add("VeteranInfo_CP0004_2014");
		tablesList.add("Worsthousingsituation_CP0004_2014");
		tablesList.add("Youthcriticalissues_CP0004_2014");
		
			  HTable table = null;
			  try {
			   HBaseAdmin admin = new HBaseAdmin(conf);
			   //if (!admin.isTableAvailable(tableName)) {
				for(String familyname : tablesList) {
					HTableDescriptor tableDescriptor = new HTableDescriptor(
							familyname);
					tableDescriptor.addFamily(new HColumnDescriptor("CF"));
					admin.createTable(tableDescriptor);
					System.out.println("Table ::"+familyname +"created.");
				}
				
				
//			} else {
//				System.out.println("Table already existing_CP0004_2014");
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return table;
	}
}
