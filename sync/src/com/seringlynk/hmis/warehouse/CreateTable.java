package com.seringlynk.hmis.warehouse;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;

public class CreateTable {
	public static void main(String args[]) {
		CreateTable table = new CreateTable();
		System.out.println("Creating table "+args[0]);
		table.createTable(args[0]);
	}

	public HTable createTable(String tableName) {
		
		List<String> tablesList =new ArrayList<String>();
		tablesList.add("Affiliation");
		tablesList.add("Bedinventory");
		tablesList.add("Client");
		tablesList.add("Commercialsexualexploitation");
		tablesList.add("Connectionwithsoar");
		tablesList.add("Dateofengagement");
		tablesList.add("Disabilities");
		tablesList.add("Domesticviolence");
		tablesList.add("Employment");
		tablesList.add("Enrollment");
		tablesList.add("EnrollmentCoc");
		tablesList.add("Exit");
		tablesList.add("Exithousingassessment");
		tablesList.add("Exitplansactions");
		tablesList.add("Export");
		tablesList.add("Familyreunification");
		tablesList.add("Formerwardchildwelfare");
		tablesList.add("Formerwardjuvenilejustice");
		tablesList.add("Funder");
		tablesList.add("Healthinsurance");
		tablesList.add("HealthStatus");
		tablesList.add("Housingassessmentdisposition");
		tablesList.add("Incomeandsources");
		tablesList.add("Inventory");
		tablesList.add("Lastgradecompleted");
		tablesList.add("Lastpermanentaddress");
		tablesList.add("Medicalassistance");
		tablesList.add("Noncashbenefits");
		tablesList.add("Organization");
		tablesList.add("Pathstatus");
		tablesList.add("Percentami");
		tablesList.add("Project");
		tablesList.add("Projectcoc");
		tablesList.add("Projectcompletionstatus");
		tablesList.add("Referralsource");
		tablesList.add("Residentialmoveindate");
		tablesList.add("Rhybcpstatus");
		tablesList.add("Schoolstatus");
		tablesList.add("Services");
		tablesList.add("Sexualorientation");
		tablesList.add("Site");
		tablesList.add("Source");
		tablesList.add("VeteranInfo");
		tablesList.add("Worsthousingsituation");
		tablesList.add("Youthcriticalissues");
		HTable table = null;
		try {
			Configuration conf = HBaseConfiguration.create();
			/*.clear();
			   conf.set("hbase.zookeeper.quorum"); host);
			   conf.set("hbase.zookeeper.property.clientPort");"2181"); */
			HBaseAdmin admin = new HBaseAdmin(conf); 
			//if (!admin.isTableAvailable(tableName)) {
				HTableDescriptor tableDescriptor = new HTableDescriptor(
						tableName);
				
				for(String familyname : tablesList) {
					tableDescriptor.addFamily(new HColumnDescriptor(familyname));
				}
				admin.createTable(tableDescriptor);
				System.out.println("Table ::"+tableName +"created.");
//			} else {
//				System.out.println("Table already existing");
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return table;
	}
}
