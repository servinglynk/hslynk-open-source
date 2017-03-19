package com.servinglynk.hmis.warehouse.upload.endpoint;

import java.sql.Timestamp;


public class ReportMasterDTO {
	public int id;
	public Timestamp created_at;
	public String email;
	public boolean emailsent;
	public String project_id;
	public String report;
	public int year;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isEmailsent() {
		return emailsent;
	}
	public void setEmailsent(boolean emailsent) {
		this.emailsent = emailsent;
	}
	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
}
