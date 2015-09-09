package com.servinglynk.hmis.warehouse.core.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "NotificationHeader")
@XmlRootElement(name = "notificationHeader")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportHeader extends ClientModel {

	@XmlElement(name = "reportHeaderId")
	private String externalId;
	
	@XmlElement(name = "reportTemplate")
	private String reportTemplate;
	
	@XmlElement(name = "reportLocation")
	private String reportLocation;
	
	@XmlElement(name = "reportNamePrefix")
	private String reportNamePrefix;
	
	
	@XmlElement(name = "friendlyName")
	private String friendlyName;
	
	@XmlElement(name = "name")
	private String name;
	
	@XmlElement(name = "version")
	private Integer version;

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}


	public String getFriendlyName() {
		return friendlyName;
	}

	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getReportTemplate() {
		return reportTemplate;
	}

	public void setReportTemplate(String reportTemplate) {
		this.reportTemplate = reportTemplate;
	}

	public String getReportLocation() {
		return reportLocation;
	}

	public void setReportLocation(String reportLocation) {
		this.reportLocation = reportLocation;
	}

	public String getReportNamePrefix() {
		return reportNamePrefix;
	}

	public void setReportNamePrefix(String reportNamePrefix) {
		this.reportNamePrefix = reportNamePrefix;
	}


	
}