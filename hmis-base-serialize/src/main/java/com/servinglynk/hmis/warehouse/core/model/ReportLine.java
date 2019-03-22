package com.servinglynk.hmis.warehouse.core.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "NotificationLine")
@XmlRootElement(name = "notificationLine")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportLine extends ClientModel {

	@XmlElement(name = "reportLineId")
	private String externalId;
	
	@XmlElement(name = "requestTime")
	private Date requestTime;
	
	@XmlElement(name = "completeTime")
	private Date completeTime;

	@XmlElement(name = "reportLocation")
	private String reportLocation;

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public Date getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	public String getReportLocation() {
		return reportLocation;
	}

	public void setReportLocation(String reportLocation) {
		this.reportLocation = reportLocation;
	}
	


}