package com.servinglynk.hmis.warehouse.notification.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class NotificationConfig {
	
	  @Value("${app.jndi.name}")
	   private String jndiName;
	
	  @Value("${mail.host}")
	   private String mailHost;
	  
	  @Value("${db.driverClassName}")
	  private String dbDriverClassName;
	  
	  @Value("${db.url}")
	  private String dbUrl;
	  
	  @Value("${db.userName}")
	  private String dbUserName;
	  
	  @Value("${db.password}")
	  private String dbPassword;
	  
	  @Value("${notification.template.location}")
	  private String vmLocation;
	  
	  
	  @Value("${hibernate.dialect}")
	  private String hibernateDialect;
	  
	  @Value("${mail.port}")
	  private String mailPort;
	  
	  @Value("${mail.username}")
	  private String mailUsername;
	  
	  @Value("${mail.password}")
	  private String mailPassword;
	  
	  @Value("${mail.sender}")
	  private String mailSender;
	  
	  @Value("${mail.templateId}")	  
	  private String mailTemplateId;
	  
	  @Value("${mail.templateUrl}")
	  private String mailTemplateUrl;
	  
	  

	public String getMailHost() {
		return mailHost;
	}

	public void setMailHost(String mailHost) {
		this.mailHost = mailHost;
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

	public String getMailPort() {
		return mailPort;
	}

	public void setMailPort(String mailPort) {
		this.mailPort = mailPort;
	}

	public String getMailUsername() {
		return mailUsername;
	}

	public void setMailUsername(String mailUsername) {
		this.mailUsername = mailUsername;
	}

	public String getMailPassword() {
		return mailPassword;
	}

	public void setMailPassword(String mailPassword) {
		this.mailPassword = mailPassword;
	}

	public String getMailSender() {
		return mailSender;
	}

	public void setMailSender(String mailSender) {
		this.mailSender = mailSender;
	}

	public String getMailTemplateId() {
		return mailTemplateId;
	}

	public void setMailTemplateId(String mailTemplateId) {
		this.mailTemplateId = mailTemplateId;
	}

	public String getMailTemplateUrl() {
		return mailTemplateUrl;
	}

	public void setMailTemplateUrl(String mailTemplateUrl) {
		this.mailTemplateUrl = mailTemplateUrl;
	}

	public String getJndiName() {
		return jndiName;
	}

	public void setJndiName(String jndiName) {
		this.jndiName = jndiName;
	}

	public String getVmLocation() {
		return vmLocation;
	}

	public void setVmLocation(String vmLocation) {
		this.vmLocation = vmLocation;
	}

}
