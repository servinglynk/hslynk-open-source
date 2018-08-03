package com.servinglynk.report.model;

import java.sql.Date;

public class Q22BeanModel extends BaseModel {

	private String dedupClientId;
	private String trackingMethod;
	private String projectType;
	private Date operatingStartDate;
	private Date exitdate;
	private Date entrydate;
	private Date moveInDate;
	private Date bedNightDate;
	private long numberOfDays=0;
	private boolean dataNotCollected ;
	
	
	public Q22BeanModel(String dedupClientId, String trackingMethod, String projectType, Date operatingStartDate,Date exitdate,Date entrydate,Date moveInDate,Date bedNightDate) {
		super();
		this.dedupClientId = dedupClientId;
		this.trackingMethod = trackingMethod;
		this.projectType = projectType;
		this.operatingStartDate = operatingStartDate;
		this.exitdate = exitdate;
		this.entrydate = entrydate;
		this.moveInDate = moveInDate;
		this.bedNightDate = bedNightDate;
	}
	/**
	 * @return the dedupClientId
	 */
	public String getDedupClientId() {
		return dedupClientId;
	}
	/**
	 * @param dedupClientId the dedupClientId to set
	 */
	public void setDedupClientId(String dedupClientId) {
		this.dedupClientId = dedupClientId;
	}
	/**
	 * @return the trackingMethod
	 */
	public String getTrackingMethod() {
		return trackingMethod;
	}
	/**
	 * @param trackingMethod the trackingMethod to set
	 */
	public void setTrackingMethod(String trackingMethod) {
		this.trackingMethod = trackingMethod;
	}
	/**
	 * @return the projectType
	 */
	public String getProjectType() {
		return projectType;
	}
	/**
	 * @param projectType the projectType to set
	 */
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	/**
	 * @return the operatingStartDate
	 */
	public Date getOperatingStartDate() {
		return operatingStartDate;
	}
	/**
	 * @param operatingStartDate the operatingStartDate to set
	 */
	public void setOperatingStartDate(Date operatingStartDate) {
		this.operatingStartDate = operatingStartDate;
	}
	/**
	 * @return the exitdate
	 */
	public Date getExitdate() {
		return exitdate;
	}
	/**
	 * @param exitdate the exitdate to set
	 */
	public void setExitdate(Date exitdate) {
		this.exitdate = exitdate;
	}
	/**
	 * @return the entrydate
	 */
	public Date getEntrydate() {
		return entrydate;
	}
	/**
	 * @param entrydate the entrydate to set
	 */
	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}
	/**
	 * @return the numberOfDays
	 */
	public long getNumberOfDays() {
		return numberOfDays;
	}
	/**
	 * @param numberOfDays the numberOfDays to set
	 */
	public void setNumberOfDays(long numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	/**
	 * @return the dataNotCollected
	 */
	public boolean isDataNotCollected() {
		return dataNotCollected;
	}
	/**
	 * @param dataNotCollected the dataNotCollected to set
	 */
	public void setDataNotCollected(boolean dataNotCollected) {
		this.dataNotCollected = dataNotCollected;
	}
	/**
	 * @return the moveInDate
	 */
	public Date getMoveInDate() {
		return moveInDate;
	}
	/**
	 * @param moveInDate the moveInDate to set
	 */
	public void setMoveInDate(Date moveInDate) {
		this.moveInDate = moveInDate;
	}
	/**
	 * @return the bedNightDate
	 */
	public Date getBedNightDate() {
		return bedNightDate;
	}
	/**
	 * @param bedNightDate the bedNightDate to set
	 */
	public void setBedNightDate(Date bedNightDate) {
		this.bedNightDate = bedNightDate;
	}
	
}
