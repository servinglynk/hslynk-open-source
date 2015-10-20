package com.servinglynk.hmis.warehouse.report.config;

import org.springframework.beans.factory.annotation.Value;

public class ReportConfig {
	
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
	  
//	  @Value("${wafer.level.macro.name}")
	  private String macroName;
	  
	  public String getMacroName() {
		return macroName;
	}

	public void setMacroName(String macroName) {
		this.macroName = macroName;
	}
	  
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

}
