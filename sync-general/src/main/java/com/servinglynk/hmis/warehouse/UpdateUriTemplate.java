package com.servinglynk.hmis.warehouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class UpdateUriTemplate {
	Logger logger = Logger.getLogger(UpdateUriTemplate.class.getName());
	public static void main(String args[]) throws Exception {
		
		UpdateUriTemplate template = new UpdateUriTemplate();
        Properties props = new Properties();
        props.generatePropValues();
        props.printProps();
        String schemaName = "v2017";
        Map<String, String> tables = new HashMap<>();
        tables.put("client","/clients/{clientid}");
        tables.put("enrollment","/clients/{clientid}/enrollments/{enrollmentid}");
        tables.put("enrollment_coc","/clients/{clientid}/enrollments/{enrollmentid}/enrollmentcocs/{enrollmentcocid}");
        tables.put("education","/clients/{clientid}/enrollments/{enrollmentid}/educations/{educationid}");
        tables.put("contact_location","/clients/{clientid}/enrollments/{enrollmentid}/contacts/{contactid}");
        tables.put("dateofengagement","/clients/{clientid}/enrollments/{enrollmentid}/dateofengagements/{dateofengagementid}");
        tables.put("disabilities","/clients/{clientid}/enrollments/{enrollmentid}/disabilities/{disabilityid}");
        tables.put("domesticviolence","/clients/{clientid}/enrollments/{enrollmentid}/domesticviolences/{domesticviolenceid}");
        tables.put("employment","/clients/{clientid}/enrollments/{enrollmentid}/employments/{employmentid}");
        tables.put("exit","/clients/{clientid}/enrollments/{enrollmentid}/exits/{exitid}");
        tables.put("exithousingassessment","/clients/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/exithousingassessments/{exithousingassessmentid}");
        tables.put("housingassessmentdisposition","/clients/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/housingassessmentdispositions/{housingassessmentdispositionid}");
        tables.put("exitrhy","/clients/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/exitrhys/{exitrhyid}");
        tables.put("healthinsurance","/clients/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthinsuranceid}");
        tables.put("health_status","/clients/{clientid}/enrollments/{enrollmentid}/healthstatuses/{healthstatusid}");
        tables.put("inventory","/projects/{projectid}/inventories/{inventoryid}");
        tables.put("incomeandsources","/clients/{clientid}/enrollments/{enrollmentid}/incomeandsources/{incomeandsourceid}");
        tables.put("medicalassistance","/clients/{clientid}/enrollments/{enrollmentid}/medicalassistances/{medicalassistanceid}");
        tables.put("noncashbenefits","/clients/{clientid}/enrollments/{enrollmentid}/noncashbenefits/{noncashbenefitid}");
        tables.put("moveindate","/clients/{clientid}/enrollments/{enrollmentid}/residentialmoveindates/{residentialmoveindateid}");
        tables.put("path_status","/clients/{clientid}/enrollments/{enrollmentid}/pathstatuses/{pathstatusid}");
        tables.put("entryrhsp","/clients/{clientid}/enrollments/{enrollmentid}/entryrhsps/{entryrhspid}");
        tables.put("entryrhy","/clients/{clientid}/enrollments/{enrollmentid}/entryrhys/{entryrhyid}");
        tables.put("entryssvf","/clients/{clientid}/enrollments/{enrollmentid}/entryssvfs/{entryssvfid}");
        tables.put("service_fa_referral","/clients/{clientid}/enrollments/{enrollmentid}/servicefareferrals/{servicefareferralid}");
        tables.put("client_veteran_info","/clients/{clientid}/veteraninfos/{veteraninfoid}");
        tables.put("rhyaftercare","/exits/{exitid}/rhyaftercares/{rhyaftercareid}");
        
        tables.put("project","/projects/{projectid}");
        tables.put("coc","/projects/{projectid}/projectcocs/{projectcocid}");
        tables.put("site","/projects/{projectid}/sites/{siteid}");
        tables.put("funder","/projects/{projectid}/funders/{funderid}");
        tables.put("affiliation","/projects/{projectid}/affiliations/{affiliationid}");
        tables.put("organization","/organizations/{organizationid}");

        tables.put("geography","/{projectid}/projectcocs/{projectcocid}/geographies/{geographyid}");
        tables.put("rhybcp_status","/{clientid}/enrollments/{enrollmentid}/rhybcpstatuses/{rhybcpstatusid}");

        List<String> columns = template.getQuestionByName(schemaName);
        for(String column : columns) {
        	 String table = template.getTableFromColumn(column);
        	 String updateUrlTemplate = tables.get(table);
        	 if(StringUtils.isNotBlank(updateUrlTemplate)) {
        		 System.out.println(" Updating template Uri for column:"+column + " url:"+updateUrlTemplate);
        		 template.updateQuestion(schemaName, updateUrlTemplate, column.toLowerCase());
        	 }else {
        		 System.out.println(" Table not found for column:"+column);
        	 }
        }
        
        
	}
	
	
	public  void updateQuestion(String schemaName,String updateUrlTemplate,String pickListGroupName){
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = SyncPostgresProcessor.getConnection();
            statement = connection.prepareStatement("update "+schemaName+".question set update_url_template =? where lower(picklist_group_name) = ?  ");
            statement.setString(1,updateUrlTemplate);
            statement.setString(2,pickListGroupName);
            int rowsInserted =  statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
        }catch (SQLException ex) {
            logger.error(" Exception inserting sync table: "+ex.getMessage(), ex);

        } finally {

            try {
                if (statement != null) {
                	statement.close();
                }
            } catch (SQLException ex) {
            	logger.error(" Exception inserting sync table: "+ex.getMessage(), ex);
            }
        }
    }
	


    public String getTableFromColumn(String column) throws Exception{
        ResultSet resultSet = null;
        PreparedStatement statement = null;		
        Connection connection = null;
        String returnString= "";
        try{
            connection = SyncPostgresProcessor.getConnection();
            statement = connection.prepareStatement("select table_name from information_schema.columns where lower(column_name) = ? and  table_schema='v2017'");
            statement.setString(1, column.toLowerCase());
            resultSet = statement.executeQuery();
            
            while (resultSet.next()){
            	returnString = resultSet.getString(1);
            	break;
            }
        }catch (Exception ex){
            throw ex;
        }
        return returnString;
    }

	public  List<String> getQuestionByName(String schemaName ) throws Exception{
        ResultSet resultSet = null;
        List<String> columns = new ArrayList<>();
        PreparedStatement statement = null;		
        Connection connection = null;
        try{
            connection = SyncPostgresProcessor.getConnection();
            statement = connection.prepareStatement("select picklist_group_name from "+schemaName+".question where update_url_template is null ");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
            	columns.add(resultSet.getString(1));
            }
        }catch (Exception ex){
            throw ex;
        }
        return columns;
    }
}
