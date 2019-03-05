package com.servinglynk.hmis.warehouse.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Report entity.
 * 
 */
public class Report extends BaseObject implements Serializable
{
	private static final long serialVersionUID = 1943429923033311936L;
	
	private Integer reportId;
	private String name;
	private String nameDisplayed;
	private String description;
	private String templateName;
	private String dataGenerator;
	private Set<ReportQuery> reportQueries = new HashSet<ReportQuery>();
	private Set<ReportParameter> reportParameters = new HashSet<ReportParameter>();
	
	public Report() {
	}
	
	public Integer getReportId() {
		return reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
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

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getDataGenerator() {
		return dataGenerator;
	}

	public void setDataGenerator(String dataGenerator) {
		this.dataGenerator = dataGenerator;
	}

	public Set<ReportQuery> getReportQueries() {
		return reportQueries;
	}

	public void setReportQueries(Set<ReportQuery> reportQueries) {
		this.reportQueries = reportQueries;
	}

	public Set<ReportParameter> getReportParameters() {
		return reportParameters;
	}

	public void setReportParameters(Set<ReportParameter> reportParameters) {
		this.reportParameters = reportParameters;
	}

	public void addReportParameter(ReportParameter reportParameter) {
		reportParameters.add(reportParameter);
	}
	
	public boolean isRequiredParameter(String name) {
		ReportParameter param = getReportParameterByName(name);
		if (param == null) {
			return false;
		}
		boolean required = false;
		for (ReportQuery query : getReportQueries()) {
			if (query.getReportQueryParameters().size() == 0) {
				continue;
			}
			for (ReportQueryParameter queryParam : query.getReportQueryParameters()) {
				ReportParameter queryParameter = queryParam.getReportParameter(); 
				if (queryParameter.getName().equalsIgnoreCase(name) && Character.toUpperCase(queryParam.getRequired()) == 'Y') {
					//log.debug("In report " + getName() + " parameter " + name + " is a required parameter for query " + query.getName());
					required = true;
				}
			}
		}
		return required;
	}
	
	public ReportParameter getReportParameterByName(String name) {
		for (ReportParameter param : reportParameters) {
			if (param.getName().equalsIgnoreCase(name)) {
				return param;
			}
		}
		return null;
	}

	public void removeReportParameter(ReportParameter reportParameter) {
		boolean removed = reportParameters.remove(reportParameter);
		//log.debug("Removing parameter from report returned: " + removed);
	}
	
	public void addReportQuery(ReportQuery reportQuery) {
		reportQueries.add(reportQuery);
	}
	
	public ReportQuery getReportQueryByName(String name) {
		for (ReportQuery query : reportQueries) {
			if (query.getName().equalsIgnoreCase(name)) {
				return query;
			}
		}
		return null;
	}
	
	public void removeReportQuery(ReportQuery reportQuery) {
		reportQueries.remove(reportQuery);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Report other = (Report) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (reportId == null) {
			if (other.reportId != null)
				return false;
		} else if (!reportId.equals(other.reportId))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((reportId == null) ? 0 : reportId.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Report [reportId=" + reportId + ", name=" + name + ", nameDisplayed=" + nameDisplayed
				+ ", description=" + description + "]";
	}
}
