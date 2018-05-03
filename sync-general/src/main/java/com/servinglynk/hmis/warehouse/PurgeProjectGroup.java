package com.servinglynk.hmis.warehouse;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class PurgeProjectGroup extends Logging {
	 private Logger logger;
	 
	 public PurgeProjectGroup(Logger logger) throws Exception {
	        this.logger = logger;
	    }
	 /***
	  * purge 
	  * @param projectGroupCode
	 * @throws Exception 
	  */
	public void purge(String projectGroupCode) throws Exception {
		String schema = "";
		disableTriggers(schema);
		logger.info("Purging 2014 schema..."+projectGroupCode);
		List<String> tables2014 = get2014Tables();
		for(String tableName : tables2014) {
			   schema = "v2014";
				purgeTable(tableName, projectGroupCode, schema);
		}
		logger.info("2014 schema purged for ..."+projectGroupCode);
		logger.info("Purging 2015 schema..."+projectGroupCode);
		List<String> tables2015 = get2015Tables();
		for(String tableName : tables2015) {
				schema = "v2015";
				purgeTable(tableName, projectGroupCode, schema);
		}
		logger.info("2015 schema purged for ..."+projectGroupCode);
		logger.info("Purging 2016 schema..."+projectGroupCode);
		List<String> tables2016 = get2016Tables();
		for(String tableName : tables2016) {
				schema = "v2016";
				purgeTable(tableName, projectGroupCode, schema);
		}
		logger.info("2016 schema purged for ..."+projectGroupCode);
		logger.info("Purging base schema..."+projectGroupCode);
		List<String> baseTables = getBaseTables();
		for(String tableName : baseTables) {
				schema = "base";
				purgeTable(tableName, projectGroupCode, schema);
		}
		logger.info("2017 schema purged for ..."+projectGroupCode);
		logger.info("Purging base schema..."+projectGroupCode);
		List<String> tables2017 = get2017Tables();
		for(String tableName : tables2017) {
				schema = "v2017";
				purgeTable(tableName, projectGroupCode, schema);
		}
		logger.info("Base schema purged for ..."+projectGroupCode);
	}
	
	//;
	 private void disableTriggers(String schema) {
	        Connection connection = null;
	        Statement statement =  null;
	        try{
	        	connection = SyncPostgresProcessor.getConnection();
	        	statement = connection.createStatement();
	        	logger.info(" Disabling triggers...");
		        statement.execute("SET session_replication_role = replica");
	        }catch (Exception ex){
	            ex.printStackTrace();
	        }finally {
	        }
		}
	 private void purgeTable(String tableName, String projectGroupCode, String schema) {
		        Connection connection = null;
		        Statement statement =  null;
		        try{
		        	connection = SyncPostgresProcessor.getConnection();
		        	statement = connection.createStatement();
		        	logger.info(" Deleting table: "+tableName +" with in schema ::"+schema +" for projectGroup ::: "+projectGroupCode);
			        statement.execute("Delete FROM "+schema+"."+tableName +" WHERE project_group_code='"+projectGroupCode+"'");
			        logger.info(" Deleted table: "+tableName);
		        }catch (Exception ex){
		            ex.printStackTrace();
		        }finally {
		        }
			}


		/***
		 * Get all the tables from the 2014 schema to be purged.
		 * @return
		 */
		public List<String> get2014Tables(){
	        List<String> tables = new ArrayList<>();
	        tables.add("path_status");
	        tables.add("rhybcp_status");
	        tables.add("last_perm_address");
	        tables.add("percent_ami");
	        tables.add("lastgradecompleted");
	        tables.add("schoolstatus");
	        tables.add("employment");
	        tables.add("health_status");
	        tables.add("affiliation");
	        tables.add("site");
	        tables.add("inventory");
	        tables.add("funder");
	        tables.add("enrollment_coc");
	        tables.add("rhybcpstatus");
	        tables.add("sexualorientation");
	        tables.add("formerwardjuvenilejustice");
	        tables.add("lastpermanentaddress");
	        tables.add("percentami");
	        tables.add("medicalassistance");
	        tables.add("youthcriticalissues");
	        tables.add("formerwardchildwelfare");
	        tables.add("referralsource");
	        tables.add("commercialsexualexploitation");
	        tables.add("domesticviolence");
	        tables.add("residentialmoveindate");
	        tables.add("dateofengagement");
	        tables.add("services");
	        tables.add("incomeandsources");
	        tables.add("noncashbenefits");
	        tables.add("healthinsurance");
	        tables.add("exithousingassessment");
	        tables.add("exitplansactions");
	        tables.add("housingassessmentdisposition");
	        tables.add("familyreunification");
	        tables.add("connectionwithsoar");
	        tables.add("projectcompletionstatus");
	        tables.add("worsthousingsituation");
	        tables.add("exit");
	        tables.add("projectcoc");
	        tables.add("disabilities");
	        tables.add("enrollment");
	        tables.add("project");
	        tables.add("organization");
	        tables.add("sync");
	        tables.add("veteran_info");
	        tables.add("client");
	        tables.add("bulk_upload");
	        tables.add("export");
	        tables.add("source");
	        tables.add("bulk_upload_error");
	        
	        return tables;
	    }
		/***
		 * Get all the tables from the 2015 schema to be purged.
		 * @return
		 */
		public List<String> get2015Tables(){
	        List<String> tables = new ArrayList<>();
	        tables.add("path_status");
	        tables.add("rhybcp_status");
	        tables.add("employment");
			tables.add("health_status");
			tables.add("affiliation");
			tables.add("site");
			tables.add("inventory");
			tables.add("funder");	
			tables.add("enrollment_coc");
			tables.add("medicalassistance");
			tables.add("domesticviolence");
			tables.add("disabilities");
			tables.add("residentialmoveindate");
			tables.add("dateofengagement");
			tables.add("incomeandsources");
			tables.add("noncashbenefits");
			tables.add("healthinsurance");
			tables.add("exithousingassessment");
			tables.add("housingassessmentdisposition");
			tables.add("exit");
			tables.add("coc");
			tables.add("project"); 
			tables.add("enrollment");
			tables.add("organization"); 
			tables.add("sync");
			tables.add("client_veteran_info");
			tables.add("client");
			tables.add("bulk_upload");
			tables.add("bulk_upload_activity");
			tables.add("export"); 
			tables.add("source");
			tables.add("exitRHY");
			tables.add("exitPath");
	        return tables;
	    }
		/***
		 * Get all the tables from the 2015 schema to be purged.
		 * @return
		 */
		public List<String> get2016Tables(){
	        List<String> tables = new ArrayList<>();
	        tables.add("path_status");
	        tables.add("rhybcp_status");
	        tables.add("employment");
	        tables.add("health_status");
	        tables.add("affiliation");
	        tables.add("site");
	        tables.add("inventory");
	        tables.add("funder");	
	        tables.add("enrollment_coc");
	        tables.add("medicalassistance");
	        tables.add("domesticviolence");
	        tables.add("disabilities");
	        tables.add("residentialmoveindate");
	        tables.add("dateofengagement");
	        tables.add("incomeandsources");
	        tables.add("noncashbenefits");
	        tables.add("healthinsurance");
	        tables.add("exithousingassessment");
	        tables.add("housingassessmentdisposition");
	        tables.add("exit");
	        tables.add("coc");
	        tables.add("project"); 
	        tables.add("enrollment");
	        tables.add("organization"); 
	        tables.add("client_veteran_info");
	        tables.add("client");
	        tables.add("bulk_upload_activity");
	        tables.add("bulk_upload_error");
	        tables.add("export"); 
	        tables.add("source");
	        tables.add("exitRHY");
	        tables.add("exitPath");
	        return tables;
	    }
		/***
		 * Get all the tables from the 2017 schema to be purged.
		 * @return
		 */
		public List<String> get2017Tables(){
	        List<String> tables = new ArrayList<>();
	        tables.add("path_status");
	        tables.add("rhybcp_status");
	        tables.add("employment");
	        tables.add("health_status");
	        tables.add("affiliation");
	        tables.add("site");
	        tables.add("inventory");
	        tables.add("funder");	
	        tables.add("enrollment_coc");
	        tables.add("medicalassistance");
	        tables.add("domesticviolence");
	        tables.add("disabilities");
	        tables.add("residentialmoveindate");
	        tables.add("dateofengagement");
	        tables.add("incomeandsources");
	        tables.add("noncashbenefits");
	        tables.add("healthinsurance");
	        tables.add("exithousingassessment");
	        tables.add("housingassessmentdisposition");
	        tables.add("exit");
	        tables.add("coc");
	        tables.add("project"); 
	        tables.add("enrollment");
	        tables.add("organization"); 
	        tables.add("client_veteran_info");
	        tables.add("client");
	        tables.add("bulk_upload_activity");
	        tables.add("bulk_upload_error");
	        tables.add("export"); 
	        tables.add("source");
	        tables.add("exitRHY");
	        return tables;
	    }
		/***
		 * Get all the tables from the base schema to be purged.
		 * @return
		 */
		public List<String> getBaseTables() {
			List<String> tables = new ArrayList<>();
			tables.add("client");
			tables.add("hmis_global_project");
			tables.add("hmis_global_project_map");
			return tables;
		}
		
	public static void main(String args[]) throws Exception {
		Logger logger = Logger.getLogger(PurgeProjectGroup.class.getName());
		Properties props = new Properties();
		props.generatePropValues();
		
		PurgeProjectGroup view = new PurgeProjectGroup(logger);
	    view.purge("CP0004");
	}

}
