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

import org.apache.log4j.Logger;

public class ServiceFaFix {
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
    
	
	private static void updateCocCode(String sourceSystemId) {
	        PreparedStatement statement = null;
	        Connection connection = null;
	        try {
	            connection = getConnection();
	            statement = connection.prepareStatement("UPDATE v2015.service_fa_referral SET date_updated=?, record_type=? where source_system_id=?");
	            Timestamp currentTimestamp = getCUrrentTimestamp();
	            statement.setTimestamp(1, currentTimestamp);
	            statement.setString(2, "142");
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

			try {

				//br = new BufferedReader(new FileReader(FILENAME));
				fr = new FileReader("/Users/sdolia/Desktop/s_142.txt");
				br = new BufferedReader(fr);

				String sCurrentLine;
				StringBuilder builder = new StringBuilder("update v2015.service_fa_referral set record_type='12',date_updated=CURRENT_TIMESTAMP where project_group_code='MO0010' and source_system_id in (");
				while ((sCurrentLine = br.readLine()) != null) {
					//System.out.println(sCurrentLine);
					builder.append("'"+sCurrentLine.trim()+"',");
				}
				builder.append(")");
				System.out.println(builder.toString());
			} catch (IOException e) {

				e.printStackTrace();

			} finally {

				try {

					if (br != null)
						br.close();

					if (fr != null)
						fr.close();

				} catch (IOException ex) {

					ex.printStackTrace();

				}

			}

	        
	}

}