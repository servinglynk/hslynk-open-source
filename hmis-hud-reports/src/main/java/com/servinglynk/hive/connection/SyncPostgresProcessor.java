package com.servinglynk.hive.connection;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.servinglynk.hmis.warehouse.Logging;
import com.servinglynk.hmis.warehouse.Properties;
import com.servinglynk.hmis.warehouse.ReportConfig;

public class SyncPostgresProcessor extends Logging{

    public static int batchSize = 1000;
    private static Connection connection = null;
    static final Logger logger = Logger.getLogger(SyncPostgresProcessor.class);
    static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection == null || connection.isClosed() ) {
        	Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://" + Properties.POSTGRESQL_DB_HOST + ":" + Properties.POSTGRESQL_DB_PORT + "/" + Properties.POSTGRESQL_DB_DATABASE,
                    Properties.POSTGRESQL_DB_USERNAME,
                    Properties.POSTGRESQL_DB_PASSWORD);
        }
        if (connection.isClosed()) {
            throw new SQLException("connection could not initiated");
        }
        return connection;
    }
    
    public static void insertLsaReport(ReportConfig reportConfig) throws Exception{
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = SyncPostgresProcessor.getConnection();
            statement = connection.prepareStatement("insert into lsa.lsa_report (\n" + 
            		"ReportID" + 
            		", ReportStart" + 
            		", ReportEnd" + 
            		", ReportCoC" + 
            		", SoftwareVendor" + 
            		", SoftwareName" + 
            		", VendorContact" + 
            		", VendorEmail" + 
            		", LSAScope" + 
            		", project_group_code" + 
            		", ReportDate" + 
            		"			)" + 
            		"		values (?,?,?,?,?,?,?,?,?,?,?) ");
            statement.setInt(1,reportConfig.getId().intValue());
            statement.setDate(2,reportConfig.getStartDate());
            statement.setDate(3,reportConfig.getEndDate());
            statement.setString(4,reportConfig.getCocCode());
            statement.setString(5,"HsLynk Inc.");
            statement.setString(6,"LSA Online");
            statement.setString(7,"HsLynk");
            statement.setString(8,"info@hsLynk.com");
            statement.setInt(9,1);
            statement.setString(10,reportConfig.getProjectGroupCode());
            statement.setTimestamp(11, new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
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
 
   //  statement = connection.prepareStatement("select value as projectid,report_config_id, report_config_id as reportconfig from base.report_config_param where key='PROJECT_ID' and report_config_id in ( select id from base.report_config where status='INITIAL' limit 1 )");
    public static ReportConfig getProjects(int id) throws Exception{
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        ReportConfig reportConfig = null; 
        try{
            connection = getConnection();
            statement = connection.prepareStatement("select id,project_group_code,start_date,end_date,coc_id from base.report_config where id ="+id);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
            	Long reportConfigId = resultSet.getLong("id"); 
            	String projectGroupCode = resultSet.getString("project_group_code");
            	Date startDate = resultSet.getDate("start_date");
            	Date endDate = resultSet.getDate("end_date");
            	String cocId = resultSet.getString("coc_id");
            	reportConfig = new ReportConfig(reportConfigId, projectGroupCode, null	, startDate, endDate, true,cocId);
            	populateProject(reportConfig);
            }
        }catch (Exception ex){
            throw ex;
        }
        finally {
            if (statement != null) {
                try {
                    statement.close();
                    //connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    logger.error(e);
                }
            }
        }
        return reportConfig;
    }
    
//  statement = connection.prepareStatement("select value as projectid,report_config_id, report_config_id as reportconfig from base.report_config_param where key='PROJECT_ID' and report_config_id in ( select id from base.report_config where status='INITIAL' limit 1 )");
    public static ReportConfig getReportConfigByStatus(String status) throws Exception{
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        ReportConfig reportConfig = null; 
        try{
            connection = getConnection();
            statement = connection.prepareStatement("select id,project_group_code,start_date,end_date,coc_id from base.report_config where status = ?");
            statement.setString(1, status);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
            	Long reportConfigId = resultSet.getLong("id"); 
            	String projectGroupCode = resultSet.getString("project_group_code");
            	Date startDate = resultSet.getDate("start_date");
            	Date endDate = resultSet.getDate("end_date");
            	String cocId = resultSet.getString("coc_id");
            	reportConfig = new ReportConfig(reportConfigId, projectGroupCode, null	, startDate, endDate, true,cocId);
            	populateProject(reportConfig);
            }
        }catch (Exception ex){
            throw ex;
        }
        finally {
            if (statement != null) {
                try {
                    statement.close();
                    //connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    logger.error(e);
                }
            }
        }
        return reportConfig;
    }
    public static ReportConfig getReportConfigByStatusReportType(String status,String reportType) throws Exception{
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        ReportConfig reportConfig = null; 
        try{
            connection = getConnection();
            statement = connection.prepareStatement("select id,project_group_code,start_date,end_date,coc_id from base.report_config where status = ? and report_type='"+reportType+"'");
            statement.setString(1, status);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
            	Long reportConfigId = resultSet.getLong("id"); 
            	String projectGroupCode = resultSet.getString("project_group_code");
            	Date startDate = resultSet.getDate("start_date");
            	Date endDate = resultSet.getDate("end_date");
            	String cocId = resultSet.getString("coc_id");
            	reportConfig = new ReportConfig(reportConfigId, projectGroupCode, null	, startDate, endDate, true,cocId);
            	populateProject(reportConfig);
            	populateCoc(reportConfig);
            }
        }catch (Exception ex){
            throw ex;
        }
        finally {
            if (statement != null) {
                try {
                    statement.close();
                    //connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    logger.error(e);
                }
            }
        }
        return reportConfig;
    }
    public static void updateReportConfig(String status,Long id) throws Exception{
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement("update base.report_config set status =? where id= ? ");
            statement.setString(1,status);
            statement.setLong(2,id);
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
	
    public static String getBucketName(String projectGroupCode) throws Exception {
    	 ResultSet resultSet = null;
         PreparedStatement statement = null;
         Connection connection = null;
         String bucketName="";
         try{
             connection = getConnection();
             statement = connection.prepareStatement("select bucket_name from base.hmis_project_group where project_group_code= ? ");
             statement.setString(1, projectGroupCode);
             resultSet = statement.executeQuery();
             while (resultSet.next()){
            	 bucketName = resultSet.getString("bucket_name");
             }
         }catch (Exception ex){
             throw ex;
         }
         return bucketName;
     }
    
    public static void populateProject(ReportConfig reportConfig) throws Exception{
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        List<String> projects = new ArrayList<>();
        try{
            connection = getConnection();
            statement = connection.prepareStatement("select value from base.report_config_param where  report_config_id= ? and key='PROJECT_ID' ");
            statement.setLong(1, reportConfig.getId());
            resultSet = statement.executeQuery();
            while (resultSet.next()){
            	String projectId = resultSet.getString("value");
            	projects.add(projectId);
            }
        }catch (Exception ex){
            throw ex;
        }
        finally {
            if (statement != null) {
                try {
                    statement.close();
                    //connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    logger.error(e);
                }
            }
        }
        reportConfig.setProjectds(projects);
    }
    
    public static void populateCoc(ReportConfig reportConfig) throws Exception{
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement("select value from base.report_config_param where  report_config_id= ? and key='COC_CODE' ");
            statement.setLong(1, reportConfig.getId());
            resultSet = statement.executeQuery();
            while (resultSet.next()){
            	String coc = resultSet.getString("value");
            	reportConfig.setCocCode(coc);
            }
        }catch (Exception ex){
            throw ex;
        }
        finally {
            if (statement != null) {
                try {
                    statement.close();
                    //connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    logger.error(e);
                }
            }
        }
    }

   
}
