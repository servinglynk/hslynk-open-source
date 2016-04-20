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
		tablesList.add("Affiliation_2014");
		tablesList.add("Bedinventory_2014");
		tablesList.add("Client_2014");
		tablesList.add("Commercialsexualexploitation_2014");
		tablesList.add("Connectionwithsoar_2014");
		tablesList.add("Dateofengagement_2014");
		tablesList.add("Disabilities_2014");
		tablesList.add("Domesticviolence_2014");
		tablesList.add("Employment_2014");
		tablesList.add("Enrollment_2014");
		tablesList.add("EnrollmentCoc_2014");
		tablesList.add("Exit_2014");
		tablesList.add("Exithousingassessment_2014");
		tablesList.add("Exitplansactions_2014");
		tablesList.add("Export_2014");
		tablesList.add("Familyreunification_2014");
		tablesList.add("Formerwardchildwelfare_2014");
		tablesList.add("Formerwardjuvenilejustice_2014");
		tablesList.add("Funder_2014");
		tablesList.add("Healthinsurance_2014");
		tablesList.add("HealthStatus_2014");
		tablesList.add("Housingassessmentdisposition_2014");
		tablesList.add("Incomeandsources_2014");
		tablesList.add("Inventory_2014");
		tablesList.add("Lastgradecompleted_2014");
		tablesList.add("Lastpermanentaddress_2014");
		tablesList.add("Medicalassistance_2014");
		tablesList.add("Noncashbenefits_2014");
		tablesList.add("Organization_2014");
		tablesList.add("Pathstatus_2014");
		tablesList.add("Percentami_2014");
		tablesList.add("Project_2014");
		tablesList.add("Projectcoc_2014");
		tablesList.add("Projectcompletionstatus_2014");
		tablesList.add("Referralsource_2014");
		tablesList.add("Residentialmoveindate_2014");
		tablesList.add("Rhybcpstatus_2014");
		tablesList.add("Schoolstatus_2014");
		tablesList.add("Services_2014");
		tablesList.add("Sexualorientation_2014");
		tablesList.add("Site_2014");
		tablesList.add("Source_2014");
		tablesList.add("VeteranInfo_2014");
		tablesList.add("Worsthousingsituation_2014");
		tablesList.add("Youthcriticalissues_2014");
		
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
//				System.out.println("Table already existing_2014");
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return table;
	}
}
