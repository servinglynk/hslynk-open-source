package com.servinglynk.hmis.warehouse.domain;

import java.io.Serializable;

public class ReportQueryParameter extends BaseObject implements Serializable
{
	private static final long serialVersionUID = 1943429923033311936L;
	
	public static final char NOT_REQUIRED_PARAMETER = 'N';
	public static final char REQUIRED_PARAMETER = 'Y';
	
	private Integer reportQueryParameterId;
	private ReportQuery reportQuery;
	private ReportParameter reportParameter;
	private String parameterName;
	private char required;
	private String substitutionKey;
	
	public ReportQueryParameter() {
		required = REQUIRED_PARAMETER;
	}

	public Integer getReportQueryParameterId() {
		return reportQueryParameterId;
	}

	public void setReportQueryParameterId(Integer reportQueryParameterId) {
		this.reportQueryParameterId = reportQueryParameterId;
	}

	public ReportParameter getReportParameter() {
		return reportParameter;
	}

	public void setReportParameter(ReportParameter reportParameter) {
		this.reportParameter = reportParameter;
	}

	public ReportQuery getReportQuery() {
		return reportQuery;
	}

	public void setReportQuery(ReportQuery reportQuery) {
		this.reportQuery = reportQuery;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	
	public char getRequired() {
		return required;
	}

	public void setRequired(char required) {
		this.required = required;
	}
	
	public String getSubstitutionKey() {
		return substitutionKey;
	}

	public void setSubstitutionKey(String substitutionKey) {
		this.substitutionKey = substitutionKey;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReportQueryParameter other = (ReportQueryParameter) obj;
		if (parameterName == null) {
			if (other.parameterName != null)
				return false;
		} else if (!parameterName.equals(other.parameterName))
			return false;
		if (reportQueryParameterId == null) {
			if (other.reportQueryParameterId != null)
				return false;
		} else if (!reportQueryParameterId.equals(other.reportQueryParameterId))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parameterName == null) ? 0 : parameterName.hashCode());
		result = prime * result + ((reportQueryParameterId == null) ? 0 : reportQueryParameterId.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "ReportQueryParameter [reportQueryParameterId=" + reportQueryParameterId + ", reportQuery="
				+ reportQuery + ", reportParameter=" + reportParameter + ", parameterName=" + parameterName
				+ ", required=" + required + "]";
	}
}
