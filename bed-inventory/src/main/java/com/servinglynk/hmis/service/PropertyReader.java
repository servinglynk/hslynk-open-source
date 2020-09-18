package com.servinglynk.hmis.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Order(Ordered.LOWEST_PRECEDENCE)
@Service
public class PropertyReader {
	
	private final static Logger logger = Logger.getLogger(PropertyReader.class);

	private Properties properties = new Properties();
	
	@Autowired
    private DataSource dataSource;
	
	private String table="base.hmis_property";
	private String nameColumn="";
	private String keyColumn="KEY_NAME";
	private String valueColumn="VALUE";
	private String name="";

	public Properties getProperties(String serviceName) {
		load("common".toUpperCase());
		load("bed-management-api");
		System.out.println(properties.size()+" properties loaded");
		return properties;
	}
		
	private void load(String serviceName) {
		StringBuilder query = new StringBuilder("SELECT SERVICE, KEY_NAME, VALUE FROM ");
		query.append(table);
			query.append(" WHERE ");
			query.append(" SERVICE =?"); 

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("properties query "+query.toString());
		try {
			conn = dataSource.getConnection();

			// bind the parameters
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1,serviceName);
			rs = pstmt.executeQuery();

			//
			while (rs.next()) {
				String key = rs.getString(keyColumn);
				String value = rs.getString(valueColumn);
				if (value!=null){
					properties.put(key, value);
				}else{
					properties.put(key,"");
				}
			}
		} catch (SQLException exc) {
			logger.error("Failed to initialize property cache for table[" + table + "] service [" + serviceName + "] ", exc);
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception exc) {
				logger.error("Failed to close rs, pstmt, conn!", exc);
			}
		}
		
		logger.info("Initializing property cache for table[" + table + "] service [" + serviceName + "] .........................END");
	}


	public void refresh(String serviceName) {
		load("common");
		load("core-service");
		load(serviceName);

	}

	public String getProperty(String name) {
		return properties.getProperty(name);
	}

}
