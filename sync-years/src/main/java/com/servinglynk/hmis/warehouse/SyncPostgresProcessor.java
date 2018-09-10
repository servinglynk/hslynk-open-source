package com.servinglynk.hmis.warehouse;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class SyncPostgresProcessor extends Logging{

    public static int batchSize = 1000;
    private static Connection connection = null;
    static final Logger logger = Logger.getLogger(SyncPostgresProcessor.class);
    static Connection getConnection() throws SQLException {
        if (connection == null) {
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
    
    public static Map<String,String> getColumnsForTable(String tableName, String schema) {
    	Map<String,String> columns = new HashMap<>();
         ResultSet resultSet = null;
         PreparedStatement statement = null;
         Connection connection = null;
         try{
         	  logger.info("Host name"+Properties.POSTGRESQL_DB_HOST);
               logger.info("POSTGRESQL_DB_PORT"+Properties.POSTGRESQL_DB_PORT);
               logger.info("POSTGRESQL_DB_DATABASE"+Properties.POSTGRESQL_DB_DATABASE);
               logger.info("POSTGRESQL_DB_USERNAME"+Properties.POSTGRESQL_DB_USERNAME);
               logger.info("POSTGRESQL_DB_PASSWORD"+Properties.POSTGRESQL_DB_PASSWORD);
             connection = getConnection();
             statement = connection.prepareStatement("select column_name,data_type from information_schema.columns where table_schema=? and table_name=?");
             statement.setString(1, schema);
             statement.setString(2, tableName);
             resultSet = statement.executeQuery();
             while (resultSet.next()){
            	 columns.put(resultSet.getString("column_name"),resultSet.getString("data_type"));
             }
         }catch (Exception ex){
             logger.error(" Error getting metadata for table "+tableName + "schema :"+schema);
         }
         return columns;
	}

    public static List<String> getAllTablesFromPostgres(String schemaName) throws Exception{
        List<String> tables = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try{
        	  logger.info("Host name"+Properties.POSTGRESQL_DB_HOST);
              logger.info("POSTGRESQL_DB_PORT"+Properties.POSTGRESQL_DB_PORT);
              logger.info("POSTGRESQL_DB_DATABASE"+Properties.POSTGRESQL_DB_DATABASE);
              logger.info("POSTGRESQL_DB_USERNAME"+Properties.POSTGRESQL_DB_USERNAME);
              logger.info("POSTGRESQL_DB_PASSWORD"+Properties.POSTGRESQL_DB_PASSWORD);
            connection = getConnection();
            statement = connection.prepareStatement("SELECT table_name FROM information_schema.tables WHERE table_schema='"+schemaName+"'");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
            	String tableName = resultSet.getString("table_name");
            	if(StringUtils.equalsIgnoreCase(tableName, "question") || StringUtils.equalsIgnoreCase(tableName, "hmis_type")) {
            		 tables.add(tableName);
            	}
            }

        }catch (Exception ex){
            throw ex;
        }
        return tables;
    }

    public static List<String> getAllProjectGroupCodes(Logger logger) {
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        List<String> projectGroupCodes = new ArrayList<String>();
        try {
            connection = getConnection();
            statement = connection.prepareStatement("SELECT distinct(project_group_code) FROM base.hmis_project_group where active=true");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	projectGroupCodes.add(resultSet.getString(1));
            }

            return projectGroupCodes;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            logger.error(e);
        } finally {
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
        return null;
    }
    public static List<BulkUpload> getExportIDFromBulkUpload(int schemaYear, Logger logger) {
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        List<BulkUpload> uploads = new ArrayList<BulkUpload>();
        try {
            connection = getConnection();
            statement = connection.prepareStatement("SELECT export_id,project_group_code,id,year,status FROM base.bulk_upload WHERE year='"+ schemaYear +"'");
            resultSet = statement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count++;
                if (!validateBulkUploadId(resultSet)) {
                    continue;
                }
                Status status = Status.getEnum(resultSet.getString(5));
                if (status == null) {
                    continue;
                }
                BulkUpload upload = new BulkUpload();
                upload.setExportId(UUID.fromString(resultSet.getString(1)));
                upload.setProjectGroupCode(resultSet.getString(2));
                upload.setId(resultSet.getLong(3));
                upload.setYear(resultSet.getLong(4));
                upload.setStatus(status);
                uploads.add(upload);
            }

            System.out.println(count);
            return uploads;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            logger.error(e);
        } finally {
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
        return null;
    }

    private static boolean validateBulkUploadId(ResultSet resultSet) throws SQLException {
        boolean valid = true;
        for (int i = 1; i < 6; i++) {
            if (resultSet.getString(1) == null) {
                valid = false;
                break;
            }
        }
        // TODO: if 'valid' is false set detailed error description
        return valid;
    }

    public static void updateCreateFlag(String groupCode, VERSION version, Logger logger) {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            switch (version) {
            	case V2017:
            		statement = connection.prepareStatement("UPDATE base.hmis_project_group SET tables_v2016_in_hbase=TRUE where project_group_code=?");
            		statement.setString(1, groupCode);
            		break;
                case V2016:
                    statement = connection.prepareStatement("UPDATE base.hmis_project_group SET tables_v2016_in_hbase=TRUE where project_group_code=?");
                    statement.setString(1, groupCode);
                    break;
                case V2015:
                    statement = connection.prepareStatement("UPDATE base.hmis_project_group SET tables_v2015_in_hbase=TRUE where project_group_code=?");
                    statement.setString(1, groupCode);
                    break;
                case V2014:
                    statement = connection.prepareStatement("UPDATE base.hmis_project_group SET tables_v2014_in_hbase=TRUE where project_group_code=?");
                    statement.setString(1, groupCode);
                    break;
            }
            if(version != VERSION.V2017) {
            	int status = statement.executeUpdate();
            }
            	
        } catch (SQLException ex) {
            logger.error(ex);

        } finally {
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

    public static void updateSyncFlag(String tableName, UUID id, String schema, Logger logger) {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement("UPDATE " + schema + "." + tableName + " SET date_updated=?, sync=?,active=? where export_id=?");
            Timestamp currentTimestamp = getCUrrentTimestamp();
            statement.setTimestamp(1, currentTimestamp);
            statement.setBoolean(2, true);
            statement.setBoolean(3, true);
            statement.setObject(4, id);
            int status = statement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            logger.error(e);
        } finally {
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

    private static Timestamp getCUrrentTimestamp() {
        Calendar calendar = Calendar.getInstance();
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
        return currentTimestamp;

    }

    public static void updateBulkUploadStatusToLive(Long id, Logger logger) {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement("UPDATE base.bulk_upload SET date_updated=?, status=? where id =?");
            Timestamp currentTimestamp = getCUrrentTimestamp();
            statement.setTimestamp(1, currentTimestamp);
            statement.setString(2, "LIVE");
            statement.setLong(3, id);
            int status = statement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            logger.error(e);
        } finally {
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
    
    public static void hydrateSyncTable(String schemaName,String tableName,String status,String message,String projectGroupCode){
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement("insert into "+schemaName+".sync (sync_table,status,description,project_group_code,date_created,date_updated)  values (?,?,?,?,?,?)");
            statement.setString(1, tableName);
            statement.setString(2,status);
            statement.setString(3,message);
            statement.setString(4,projectGroupCode);
            statement.setTimestamp(5, getCUrrentTimestamp());
            statement.setTimestamp(6, getCUrrentTimestamp());
            statement.executeUpdate();
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

    public static void markRowsForDeletion(String fullTableName, String exportId, Logger logger) {
        PreparedStatement statement = null;
        Connection connection;
        try {
            connection = getConnection();
            statement = connection.prepareStatement("UPDATE " + fullTableName + " SET deleted=TRUE where export_id =?");
            statement.setObject(1, UUID.fromString(exportId));
            int status = statement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            logger.error(e);
        } finally {
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
