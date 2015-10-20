package com.servinglynk.hmis.warehouse.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ReportMaster {

	@Column(name="id")			
	public int id;
	@Column(name="created_at")
	public Timestamp created_at;
	@Column(name="created_by")
	public String created_by;
	@Column(name="modified_by")
	public String modified_by;
	@Column(name="modified_at")
	public Timestamp modified_at;
	@Column(name="email")
	public String email;
	@Column(name="emailsent")
	public boolean emailsent;
	@Column(name="project_id")
	public UUID project_id;
	@Column(name="report")
	public String report;
	@Column(name="year")
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
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public String getModified_by() {
		return modified_by;
	}
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	public Timestamp getModified_at() {
		return modified_at;
	}
	public void setModified_at(Timestamp modified_at) {
		this.modified_at = modified_at;
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
	public UUID getProject_id() {
		return project_id;
	}
	public void setProject_id(UUID project_id) {
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
