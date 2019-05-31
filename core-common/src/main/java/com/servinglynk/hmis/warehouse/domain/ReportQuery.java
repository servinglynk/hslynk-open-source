package com.servinglynk.hmis.warehouse.domain;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * ReportQuery entity.
 * 
 */
public class ReportQuery extends BaseObject implements Serializable
{
	private static final long serialVersionUID = 1943429923033311936L;
	
	private Integer reportQueryId;
	private Report report;
	private String name;
	private String query;
	private Set<ReportQueryParameter> reportQueryParameters  = new HashSet<ReportQueryParameter>();
	
	public Integer getReportQueryId() {
		return reportQueryId;
	}

	public void setReportQueryId(Integer reportQueryId) {
		this.reportQueryId = reportQueryId;
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

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public Set<ReportQueryParameter> getReportQueryParameters() {
		return reportQueryParameters;
	}

	public void setReportQueryParameters(Set<ReportQueryParameter> reportQueryParameters) {
		this.reportQueryParameters = reportQueryParameters;
	}

	public void addReportQueryParameter(ReportQueryParameter reportQueryParameter) {
		reportQueryParameters.add(reportQueryParameter);
	}
	
	public void removeReportQueryParameter(ReportParameter reportParameter) {
		reportQueryParameters.remove(reportParameter);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReportQuery other = (ReportQuery) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (reportQueryId == null) {
			if (other.reportQueryId != null)
				return false;
		} else if (!reportQueryId.equals(other.reportQueryId))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((reportQueryId == null) ? 0 : reportQueryId.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "ReportQuery [reportQueryId=" + reportQueryId + ", report=" + report + ", name=" + name + ", query="
				+ query + ", reportQueryParameters=" + reportQueryParameters + "]";
	}
}
