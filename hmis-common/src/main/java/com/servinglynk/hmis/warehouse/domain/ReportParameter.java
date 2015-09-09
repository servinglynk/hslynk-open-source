package com.servinglynk.hmis.warehouse.domain;

import java.io.Serializable;

/**
 * ReportQuery entity.
 * 
 */
public class ReportParameter extends BaseObject implements Serializable
{
	private static final long serialVersionUID = 1943429923033311936L;
	
	public static final int DATE_DATATYPE = 0;
	public static final int STRING_DATATYPE = 1;
	public static final int NUMERIC_DATATYPE = 2;
	
	private Integer reportParameterId;
	private Report report;
	private String name;
	private String nameDisplayed;
	private String description;
	private int parameterDatatype;
	
	public Integer getReportParameterId() {
		return reportParameterId;
	}

	public void setReportParameterId(Integer reportParameterId) {
		this.reportParameterId = reportParameterId;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameDisplayed() {
		return nameDisplayed;
	}

	public void setNameDisplayed(String nameDisplayed) {
		this.nameDisplayed = nameDisplayed;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getParameterDatatype() {
		return parameterDatatype;
	}

	public void setParameterDatatype(int parameterDatatype) {
		this.parameterDatatype = parameterDatatype;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReportParameter other = (ReportParameter) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (reportParameterId == null) {
			if (other.reportParameterId != null)
				return false;
		} else if (!reportParameterId.equals(other.reportParameterId))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((reportParameterId == null) ? 0 : reportParameterId.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "ReportParameter [reportParameterId=" + reportParameterId + ", report=" + report + ", name=" + name
				+ ", nameDisplayed=" + nameDisplayed + ", description=" + description + ", parameterDatatype="
				+ parameterDatatype + "]";
	}
}
