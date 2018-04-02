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

import org.apache.log4j.Logger;

public class ProjectCocFix {
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
    
	
	private static void updateCoc(UUID id, UUID projectId) {
	        PreparedStatement statement = null;
	        Connection connection = null;
	        try {
	            connection = getConnection();
	            statement = connection.prepareStatement("UPDATE v2017.coc SET projectid =? where id=?");
	            statement.setObject(1, projectId);
	            statement.setObject(2, id);
	            int status = statement.executeUpdate();
	            System.out.println("Updated projectcocoid::"+id);
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
				fr = new FileReader("/Users/sdolia/Desktop/test.csv");
				br = new BufferedReader(fr);

				String sCurrentLine;
				while ((sCurrentLine = br.readLine()) != null) {
					String[] split = sCurrentLine.split(",");
					System.out.println("UPDATE v2017.coc SET projectid ='"+split[1].trim() +"' where id='"+split[0].trim()+"';");
					
//					UUID projectId = UUID.fromString(split[1].trim());
//					UUID id = UUID.fromString(split[0].trim());
//					
					
					//updateCoc(id,projectId);
				}
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