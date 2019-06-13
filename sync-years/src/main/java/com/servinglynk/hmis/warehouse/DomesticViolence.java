package com.servinglynk.hmis.warehouse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class DomesticViolence {
	public static int batchSize = 1000;
    private static Connection connection = null;
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
    
	
	private static void updateCocCode(String sourceSystemId,UUID enrollmentId) {
	        PreparedStatement statement = null;
	        Connection connection = null;
	        try {
	            connection = getConnection();
	            statement = connection.prepareStatement("UPDATE v2017.noncashbenefits SET date_updated=?, enrollmentid=? where source_system_id=? and project");
	            Timestamp currentTimestamp = getCUrrentTimestamp();
	            statement.setTimestamp(1, currentTimestamp);
	            statement.setObject(2, enrollmentId);
	            statement.setString(3, sourceSystemId);
	            int status = statement.executeUpdate();
	            System.out.println("Updated projectcocoid::"+sourceSystemId);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	        	e.printStackTrace();
	        } finally {
	            if (statement != null) {
	                try {
	                    statement.close();
	                    //connection.close();
	                } catch (SQLException e) {
	                    // TODO Auto-generated catch block
	                }
	            }
	        }
	    }
	   
	 private static Timestamp getCUrrentTimestamp() {
	        Calendar calendar = Calendar.getInstance();
	        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
	        return currentTimestamp;

	    }
	public static void main(String args[]) throws Exception {
		int count =0;
		  Logger logger = Logger.getLogger(Stats.class.getName());
	        Properties props = new Properties();
	        props.generatePropValues("application.conf");
	        props.printProps();
	        BufferedReader br = null;
			FileReader fr = null;

			   PreparedStatement statement = null;
		        Connection connection = null;
			
			try {
				 connection = getConnection();

				//br = new BufferedReader(new FileReader(FILENAME));
				fr = new FileReader("/Users/sdolia/Downloads/domestic.csv");
				br = new BufferedReader(fr);

				String sCurrentLine;
			
				while ((sCurrentLine = br.readLine()) != null) {
					String[] split = sCurrentLine.split(",");
					try {
						if(StringUtils.isNotBlank(split[1])) {
							StringBuilder builder = new StringBuilder("	UPDATE v2017.incomeandsources  "+
									" SET enrollmentid = s.id "+
									" FROM v2017.enrollment AS s "+
									" WHERE  s.deleted=false "+
									" and v2017.incomeandsources.project_group_code ='SR0012'"+
									" and v2017.incomeandsources.enrollmentid is null ");
									
							//System.out.println(sCurrentLine);
							
							
							builder.append(" and v2017.incomeandsources.source_system_id = '"+split[0].trim()+"'"+
							"	and s.source_system_id = '"+split[1]+"' ;");
							System.out.println(builder.toString());
							statement = connection.prepareStatement(builder.toString());
							statement.executeUpdate();
				            
					}
					} catch (ArrayIndexOutOfBoundsException e) {

						//e.printStackTrace();

					}
				}
			
			} catch (IOException e) {

				e.printStackTrace();

			} finally {

				try {

					if (br != null)
						br.close();

					if (fr != null)
						fr.close();
					
			            if (statement != null) {
			                try {
			                    statement.close();
			                    //connection.close();
			                } catch (SQLException e) {
			                    // TODO Auto-generated catch block
			                }
			            }

				} catch (IOException ex) {

					ex.printStackTrace();

				}

			}

	        
	}

}