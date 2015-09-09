package com.servinglynk.hmis.warehouse.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * ReportRequestEntry entity.
 * 
 */
public class ReportRequestEntry extends BaseObject implements Serializable
{
	private static final long serialVersionUID = 1943429923033311936L;
	public static final String NOT_COMPLETED_PARAMETER = "N";
	public static final String COMPLETED_PARAMETER = "Y";
	
	private Integer reportRequestId;
	private Report report;
	private User userRequested;
	private Date dateRequested;
	private Date dateCompleted;
	private String completed;
	private String reportHandle;
	
	public Integer getReportRequestId() {
		return reportRequestId;
	}

	public void setReportRequestId(Integer reportRequestId) {
		this.reportRequestId = reportRequestId;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public User getUserRequested() {
		return userRequested;
	}

	public void setUserRequested(User userRequested) {
		this.userRequested = userRequested;
	}

	public Date getDateRequested() {
		return dateRequested;
	}

	public void setDateRequested(Date dateRequested) {
		this.dateRequested = dateRequested;
	}
	
	public Date getDateCompleted() {
		return dateCompleted;
	}

	public void setDateCompleted(Date dateCompleted) {
		this.dateCompleted = dateCompleted;
	}

	public String getCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}

	public String getReportHandle() {
		return reportHandle;
	}

	public void setReportHandle(String reportHandle) {
		this.reportHandle = reportHandle;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReportRequestEntry other = (ReportRequestEntry) obj;
		if (dateRequested == null) {
			if (other.dateRequested != null)
				return false;
		} else if (!dateRequested.equals(other.dateRequested))
			return false;
		if (reportRequestId == null) {
			if (other.reportRequestId != null)
				return false;
		} else if (!reportRequestId.equals(other.reportRequestId))
			return false;
		if (userRequested == null) {
			if (other.userRequested != null)
				return false;
		} else if (!userRequested.equals(other.userRequested))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateRequested == null) ? 0 : dateRequested.hashCode());
		result = prime * result + ((reportRequestId == null) ? 0 : reportRequestId.hashCode());
		result = prime * result + ((userRequested == null) ? 0 : userRequested.hashCode());
		return result;
	}


	@Override
	public String toString() {
		return "ReportRequestEntry [reportRequestId=" + reportRequestId + ", report=" + report + ", userRequested="
				+ userRequested + ", dateRequested=" + dateRequested + ", completed=" + completed + ", reportHandle="
				+ reportHandle + "]";
	}
}
