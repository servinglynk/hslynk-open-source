package com.servinglynk.hmis.warehouse.core.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("fileExport")
public class FileExport extends ClientModel {

	private String name;
	private String status;
	private String username;
	private String projectGroupCode;
	private String exportType;
	private String exportLevel;
	private boolean emailSent;
	private Date startDate;
	private Date endDate;
	private Long id;
	private List<String> projectIds;
	private String createdBy;
	private String updatedBy;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the projectGroupCode
	 */
	public String getProjectGroupCode() {
		return projectGroupCode;
	}
	/**
	 * @param projectGroupCode the projectGroupCode to set
	 */
	public void setProjectGroupCode(String projectGroupCode) {
		this.projectGroupCode = projectGroupCode;
	}
	/**
	 * @return the exportType
	 */
	public String getExportType() {
		return exportType;
	}
	/**
	 * @param exportType the exportType to set
	 */
	public void setExportType(String exportType) {
		this.exportType = exportType;
	}
	/**
	 * @return the exportLevel
	 */
	public String getExportLevel() {
		return exportLevel;
	}
	/**
	 * @param exportLevel the exportLevel to set
	 */
	public void setExportLevel(String exportLevel) {
		this.exportLevel = exportLevel;
	}
	/**
	 * @return the emailSent
	 */
	public boolean isEmailSent() {
		return emailSent;
	}
	/**
	 * @param emailSent the emailSent to set
	 */
	public void setEmailSent(boolean emailSent) {
		this.emailSent = emailSent;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the projectIds
	 */
	public List<String> getProjectIds() {
		return projectIds;
	}
	/**
	 * @param projectIds the projectIds to set
	 */
	public void setProjectIds(List<String> projectIds) {
		this.projectIds = projectIds;
	}
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}
	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
