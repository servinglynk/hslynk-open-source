package com.servinglynk.hmis.warehouse.client.config;

import org.springframework.beans.factory.annotation.Value;

public class CoreClientConfig {
	
  
	  @Value("${notification.service.url}")
	  private String notificationServiceUrl;

	public String getNotificationServiceUrl() {
		return notificationServiceUrl;
	}

	public void setNotificationServiceUrl(String notificationServiceUrl) {
		this.notificationServiceUrl = notificationServiceUrl;
	}
	  
	 
	  	  @Value("${report.service.url}")
	  private String reportServiceUrl;

	public String getReportServiceUrl() {
		return reportServiceUrl;
	}

	public void setReportServiceUrl(String reportServiceUrl) {
		this.reportServiceUrl = reportServiceUrl;
	}
	
	  @Value("${authorization.service.url}")
	  private String authorizationServiceUrl;

	public String getAuthorizationServiceUrl() {
		return authorizationServiceUrl;
	}

	public void setAuthorizationServiceUrl(String authorizationServiceUrl) {
		this.authorizationServiceUrl = authorizationServiceUrl;
	}
}
