package com.servinglynk.hmis.warehouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class EligibleClientsAudit extends Logging {
	Logger logger = Logger.getLogger(EligibleClientsAudit.class.getName());
	public  List<String> getDedupClientIds(String schemaName ) throws Exception{
        ResultSet resultSet = null;
        List<String> columns = new ArrayList<>();
        PreparedStatement statement = null;		
        Connection connection = null;
        try{
            connection = SyncPostgresProcessor.getConnection();
            statement = connection.prepareStatement("select client_dedup_id from housing_inventory.eligible_clients where client_dedup_id not in (select distinct client_dedup_id from housing_inventory.eligible_clients_audit ) ");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
            	columns.add(resultSet.getString(1));
            }
        }catch (Exception ex){
            throw ex;
        }
        return columns;
    }
	public  EligibleClient getEligibleClient(String dedupClientId ) throws Exception{
        ResultSet resultSet = null;
        PreparedStatement statement = null;		
        Connection connection = null;
        EligibleClient client = null;
        try{
            connection = SyncPostgresProcessor.getConnection();
            statement = connection.prepareStatement("select * from housing_inventory.eligible_clients where client_dedup_id = ? order by date_updated desc limit 1 ");
            statement.setObject(1, UUID.fromString(dedupClientId));
            resultSet = statement.executeQuery();
            while (resultSet.next()){
            	String clientId = resultSet.getString("client_id");
            	String survey_type = resultSet.getString("survey_type");
            	int survey_score = resultSet.getInt("survey_score");
            	String program_type = resultSet.getString("program_type");
            	Boolean matched = resultSet.getBoolean("matched");
            	Timestamp survey_date = resultSet.getTimestamp("survey_date");
            	String user_id= resultSet.getString("user_id");
            	String client_dedup_id=  resultSet.getString("client_dedup_id");
            	String status = resultSet.getString("status");
            	client = new EligibleClient(clientId,survey_type , survey_score, program_type, matched,survey_date , resultSet.getString("spdat_label"), resultSet.getString("zip_code"), resultSet.getString("project_group_code"), resultSet.getInt("coc_score"), resultSet.getString("client_link"), resultSet.getTimestamp("date_created"), resultSet.getTimestamp("date_updated"), user_id, resultSet.getBoolean("deleted"), resultSet.getBoolean("ignore_match_process"), resultSet.getString("remarks"), status, client_dedup_id , resultSet.getTimestamp("survey_submission_date"), resultSet.getInt("bonus_score"), resultSet.getInt("total_score"), resultSet.getString("readded_reason"));
            }
        }catch (Exception ex){
            throw ex;
        }
        return client;
    }
	
	public static void insertEligibleClientAudit(EligibleClient client){
        PreparedStatement statement = null;
        Connection connection = null;
        System.out.println("insering dedup client id:"+ client.getClient_dedup_id());
        try{
            connection = SyncPostgresProcessor.getConnection();
            statement = connection.prepareStatement("insert into housing_inventory.eligible_clients_audit (id,client_id,survey_type,survey_score,program_type,matched,survey_date,spdat_label,zip_code,project_group_code,coc_score,client_link,date_created,date_updated,user_id,deleted,ignore_match_process,remarks,status,client_dedup_id,survey_submission_date,bonus_score,total_score,readded_reason)  values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ) ");
            statement.setObject(1, UUID.randomUUID());
            statement.setObject(2,UUID.fromString(client.getClient_id()));
            statement.setString(3,client.getSurvey_type());
            statement.setInt(4,client.getSurvey_score());
            statement.setString(5,client.getProgram_type());
            statement.setBoolean(6,client.isMatched());  
            statement.setTimestamp(7,client.getSurvey_date());
            statement.setString(8,client.getSpdat_label());
            statement.setString(9,client.getZip_code());
            statement.setString(10,client.getProject_group_code());
            statement.setInt(11,client.getCoc_score());
            statement.setString(12,client.getClient_link());
            statement.setTimestamp(13, client.getDate_created());
            statement.setTimestamp(14, SyncPostgresProcessor.getCUrrentTimestamp());
            statement.setObject(15,UUID.fromString(client.getUser_id()));
            statement.setBoolean(16,client.isDeleted()); 
            statement.setBoolean(17,client.isIgnore_match_process()); 
            statement.setString(18,client.getRemarks());
            statement.setObject(19,StringUtils.isNotBlank(client.getStatus()) ? Long.parseLong(client.getStatus()) : null);
            statement.setObject(20,UUID.fromString(client.getClient_dedup_id()));
            statement.setTimestamp(21, client.getSurvey_submission_date());
            statement.setInt(22, client.getBonus_score());
            statement.setInt(23, client.getTotal_score());
            statement.setString(24, "Migrated historical audit data");
           
            statement.executeUpdate();
        }catch (SQLException ex) {
        	ex.printStackTrace();
//            logger.error(" Exception inserting sync table: "+ex.getMessage(), ex);

        } finally {

            try {
                if (statement != null) {
                	statement.close();
                }
            } catch (SQLException ex) {
            	ex.printStackTrace();
//            	logger.error(" Exception inserting sync table: "+ex.getMessage(), ex);
            }
        }
    }

	
	public static void main(String args[]) throws Exception {
		Logger logger = Logger.getLogger(EligibleClientsAudit.class.getName());
		Properties props = new Properties();
		props.generatePropValues();
		EligibleClientsAudit audit = new EligibleClientsAudit();
		List<String> dedupClientIds = audit.getDedupClientIds("");
		if(CollectionUtils.isNotEmpty(dedupClientIds)) {
			for(String dedupClientId : dedupClientIds) {
				EligibleClient eligibleClient = audit.getEligibleClient(dedupClientId);
				insertEligibleClientAudit(eligibleClient);
			}
		}
	}
}
