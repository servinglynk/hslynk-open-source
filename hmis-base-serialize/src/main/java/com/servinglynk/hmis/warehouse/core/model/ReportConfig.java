package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("reportConfig")
public class ReportConfig extends ClientModel{
	
		private String name;
		private String status;
		private String username;
		private String projectGroupCode;
		private String reportType;
		private String reportLevel;
		private boolean emailSent;
		private Date startDate;
		private Date endDate;
		private Long id;
		private String cocId;
		private String createdBy;
		private String updatedBy;
		private List<ReportProject> projectIds = new ArrayList<>();
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getProjectGroupCode() {
			return projectGroupCode;
		}
		public void setProjectGroupCode(String projectGroupCode) {
			this.projectGroupCode = projectGroupCode;
		}
		public String getReportType() {
			return reportType;
		}
		public void setReportType(String reportType) {
			this.reportType = reportType;
		}
		public String getReportLevel() {
			return reportLevel;
		}
		public void setReportLevel(String reportLevel) {
			this.reportLevel = reportLevel;
		}
		public boolean isEmailSent() {
			return emailSent;
		}
		public void setEmailSent(boolean emailSent) {
			this.emailSent = emailSent;
		}
		public Date getStartDate() {
			return startDate;
		}
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getCocId() {
			return cocId;
		}
		public void setCocId(String cocId) {
			this.cocId = cocId;
		}
		public List<ReportProject> getProjectIds() {
			return projectIds;
		}
		public void setProjectIds(List<ReportProject> projectIds) {
			this.projectIds = projectIds;
		}
		public String getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}
		public String getUpdatedBy() {
			return updatedBy;
		}
		public void setUpdatedBy(String updatedBy) {
			this.updatedBy = updatedBy;
		}

}
