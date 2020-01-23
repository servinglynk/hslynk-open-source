package com.servinglynk.report.business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.servinglynk.hive.connection.ImpalaConnection;
import com.servinglynk.hmis.warehouse.Properties;

public class DescribeSchema {


    /**
     * Use FileWriter when number of write operations are less
     * @param data
     * @throws IOException 
     */
    private static void writeUsingFileWriter(String data) throws IOException {
    	 BufferedWriter writer = new BufferedWriter(
                 new FileWriter("/Users/sdolia/hmis_metadata.csv", true)  //Set true for append mode
             );  
		writer.newLine();   //Add new line
		writer.write(data);
		writer.close();
    }
    
	public static void populateMetadata(String schema,String tableName) throws SQLException, IOException {
		Connection connection = null;
			connection = ImpalaConnection.getConnection();
		    Statement statement = connection.createStatement();
		    ResultSet resultSet = statement.executeQuery("SELECT * FROM "+schema+"."+tableName +" limit 1");
		    ResultSetMetaData metaData = resultSet.getMetaData();
		    System.out.println("Number of columns: "+metaData.getColumnCount());
		    System.out.println("Table description...!");
		    for(int i=1;i< metaData.getColumnCount();i++)
		    {
		    	String data = tableName+","+metaData.getColumnName(i)+","+metaData.getColumnTypeName(i);
		      writeUsingFileWriter(data);
		    }
		  }
	public static void main(String args[]) throws Exception {
		List<String> lists = new ArrayList<>();
		/*
		lists.add("client");
		 lists.add(" client_veteran_info");
		 lists.add("contact");
		 lists.add(" dateofengagement");
		 lists.add("disabilities");
		 lists.add("domesticviolence");
		 lists.add("education");
		 lists.add("employment");
		 lists.add("enrollment");
		 lists.add("enrollment_coc");
		 lists.add("entryrhsp");
		 lists.add("entryrhy");
		 lists.add("exit");
		 lists.add("exitpath");
		 lists.add("exithousingassessment");
		 lists.add("exitplansactions");
		 lists.add("exitrhy");
		 lists.add("funder");
		 lists.add("health_status");
		 lists.add("healthinsurance");
		 lists.add("housingassessmentdisposition");
		 lists.add("incomeandsources");
		 lists.add("inventory");
		 lists.add("medicalassistance");
		 lists.add("noncashbenefits");
		 lists.add("organization");
		 lists.add("path_status");
		 lists.add("project");
		 lists.add("coc");
		 lists.add("residentialmoveindate");
		 lists.add("rhybcp_status");
		 lists.add("service_fa_referral");
		 lists.add("site");
		 lists.add("affiliation");
		lists.add("commercialsexualexploitation");
		lists.add("connectionwithsoar");
		lists.add("familyreunification");
		lists.add("formerwardchildwelfare");
		lists.add("formerwardjuvenilejustice");
		lists.add("lastgradecompleted");
		lists.add("lastpermanentaddress");
		lists.add("percent_ami");
		lists.add("projectcompletionstatus");
		lists.add("referralsource");
		 lists.add("schoolstatus");
		lists.add("services");
		lists.add("sexualorientation");
		lists.add("veteran_info");
		 lists.add("worsthousingsituation");
		 lists.add("youthcriticalissues");
		lists.add("bedinventory");
		lists.add("bulk_upload_mapping");
		lists.add("entryssvf");
		lists.add("export");
		lists.add("geography");
		lists.add("hmis_notification");
		lists.add("hmis_type_v2014");
		lists.add("hmis_type_v2015");
		lists.add("hmis_type_v2016");
		lists.add("hmis_type_v2017");
		lists.add("hmis_user");
		lists.add("last_perm_address");
		lists.add("moveindate");
		lists.add("percentami");
		lists.add("projectcoc");
		lists.add("question_v2014");
		lists.add("question_v2015");
		lists.add("question_v2016");
		lists.add("question_v2017");
		lists.add("rhyaftercare");
		lists.add("rhybcpstatus");
		lists.add("source");
		lists.add("vashexitreason");
		lists.add("project_coc");
		lists.add("client_survey_submission");
		lists.add("picklist_group");
		lists.add("picklist_value");
		lists.add("question");
		lists.add("question_group");
		lists.add("response");
		lists.add("section_question_mapping");
		lists.add("section_score");
		lists.add("survey");
		lists.add("survey_section");
		lists.add("active_list");
		lists.add("response");
		lists.add("batch_process");
		lists.add("eligible_clients");
		*/
		lists.add("global_household");
		lists.add("household_membership");
		lists.add("housing_inventory");
		lists.add("housing_unit");
		lists.add("housing_unit_address");
		lists.add("housing_unit_assignment");
		lists.add("housing_unit_eligibility");
		lists.add("match_process_log");
		lists.add("match_reservations");
		lists.add("match_status");
		lists.add("match_status_levels");
		lists.add("match_status_remarks");
		lists.add("status_note");
		
		Properties props = new Properties();
		props.generatePropValues();
		for(String tableName : lists) {
			try {
				populateMetadata("mo0010", tableName);
			}catch(Exception e) {
				//eat the exception
			}
			
		}
	}
}
