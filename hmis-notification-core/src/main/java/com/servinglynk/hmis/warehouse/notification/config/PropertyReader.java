package com.servinglynk.hmis.warehouse.notification.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class PropertyReader {
	
	private final static Logger logger = Logger.getLogger(PropertyReader.class);

	private Properties properties = new Properties();
	
	@Autowired
    private DataSource dataSource;
	
	private String table="hmis_property";
	private String nameColumn="";
	private String keyColumn="KEY_NAME";
	private String valueColumn="KEY_VALUE";
	private String name="";

	public Properties getProperties() {
		load();
		return properties;
	}
		
	private void load() {
		StringBuilder query = new StringBuilder("SELECT SERVICE, KEY_NAME, KEY_VALUE FROM ");
		query.append(table);
		if (!StringUtils.isEmpty(nameColumn)) {
			query.append(" WHERE ");
			query.append(nameColumn + "=?");
		}

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();

			// bind the parameters
			pstmt = conn.prepareStatement(query.toString());
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
			logger.error("Failed to initialize property cache for table[" + table + "] name[" + name + "] ", exc);
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception exc) {
				logger.error("Failed to close rs, pstmt, conn!", exc);
			}
		}
		
		logger.info("Initializing property cache for table[" + table + "] name[" + name + "] .........................END");
	}


	public void refresh() {
		load();
	}

	public String getProperty(String name) {
		return properties.getProperty(name);
	}

}
