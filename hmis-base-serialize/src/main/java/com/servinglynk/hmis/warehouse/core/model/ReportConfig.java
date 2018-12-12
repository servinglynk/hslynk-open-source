package com.servinglynk.hmis.warehouse.core.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
		private LocalDateTime startDate;
		private LocalDateTime endDate;
		private Long id;
		private String cocId;
		private List<String> projectIds = new ArrayList<>();
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
		public LocalDateTime getStartDate() {
			return startDate;
		}
		public void setStartDate(LocalDateTime startDate) {
			this.startDate = startDate;
		}
		public LocalDateTime getEndDate() {
			return endDate;
		}
		public void setEndDate(LocalDateTime endDate) {
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
		public List<String> getProjectIds() {
			return projectIds;
		}
		public void setProjectIds(List<String> projectIds) {
			this.projectIds = projectIds;
		}

}
