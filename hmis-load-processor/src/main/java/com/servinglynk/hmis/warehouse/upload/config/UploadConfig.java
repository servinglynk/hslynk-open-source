package com.servinglynk.hmis.warehouse.upload.config;

import org.springframework.beans.factory.annotation.Value;

public class UploadConfig {
	
  
	  @Value("${db.driverClassName}")
	  private String dbDriverClassName;
	  
	  @Value("${db.url}")
	  private String dbUrl;
	  
	  @Value("${db.userName}")
	  private String dbUserName;
	  
	  @Value("${db.password}")
	  private String dbPassword;

	  @Value("${hibernate.dialect}")
	  private String hibernateDialect;
	  
	  
	  @Value("${upload.loc}")
	  private String reportTempLocation;
	  
	  
	public String getDbDriverClassName() {
		return dbDriverClassName;
	}

	public void setDbDriverClassName(String dbDriverClassName) {
		this.dbDriverClassName = dbDriverClassName;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDbUserName() {
		return dbUserName;
	}

	public void setDbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public String getHibernateDialect() {
		return hibernateDialect;
	}

	public void setHibernateDialect(String hibernateDialect) {
		this.hibernateDialect = hibernateDialect;
	}

	public String getReportTempLocation() {
		return reportTempLocation;
	}

	public void setReportTempLocation(String reportTempLocation) {
		this.reportTempLocation = reportTempLocation;
	}
	  
	  
	  
	  

}
