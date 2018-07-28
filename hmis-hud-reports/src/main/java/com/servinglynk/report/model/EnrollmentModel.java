package com.servinglynk.report.model;

import java.sql.Date;

public class EnrollmentModel extends BaseModel {
	public EnrollmentModel() {}
	public EnrollmentModel(String projectEntryID,
			String continuouslyhomelessoneyear, String disablingcondition,
			Date entrydate, String householdid, String housingstatus,
			String housingstatus_desc, String monthshomelesspastthreeyears,
			String monthshomelesspastthreeyears_desc,
			String monthshomelessthistime, String otherresidenceprior,
			String projectID, String relationshiptohoh,
			String relationshiptohoh_desc, String residenceprior,
			String residenceprior_desc, String residencepriorlengthofstay,
			String residencepriorlengthofstay_desc, String statusdocumented,
			String timeshomelesspastthreeyears,
			String timeshomelesspastthreeyears_desc, String yearshomeless,
			String personalID, int ageatentry, boolean chronichomeless,
			String enrollment_source_system_id,Date dateCreatedFromSource, String livingSituation,Date datetostreetessh,
			String dedupClientId) {
		super();
		this.projectEntryID = projectEntryID;
		this.continuouslyhomelessoneyear = continuouslyhomelessoneyear;
		this.disablingcondition = disablingcondition;
		this.entrydate = entrydate;
		this.dateCreatedFromSource = dateCreatedFromSource;
		this.householdid = householdid;
		this.housingstatus = housingstatus;
		this.housingstatus_desc = housingstatus_desc;
		this.monthshomelesspastthreeyears = monthshomelesspastthreeyears;
		this.monthshomelesspastthreeyears_desc = monthshomelesspastthreeyears_desc;
		this.monthshomelessthistime = monthshomelessthistime;
		this.otherresidenceprior = otherresidenceprior;
		this.projectID = projectID;
		this.relationshiptohoh = relationshiptohoh;
		this.relationshiptohoh_desc = relationshiptohoh_desc;
		this.residenceprior = residenceprior;
		this.residenceprior_desc = residenceprior_desc;
		this.residencepriorlengthofstay = residencepriorlengthofstay;
		this.residencepriorlengthofstay_desc = residencepriorlengthofstay_desc;
		this.statusdocumented = statusdocumented;
		this.timeshomelesspastthreeyears = timeshomelesspastthreeyears;
		this.timeshomelesspastthreeyears_desc = timeshomelesspastthreeyears_desc;
		this.yearshomeless = yearshomeless;
		this.personalID = personalID;
		this.ageatentry = ageatentry;
		this.chronichomeless = chronichomeless;
		this.enrollment_source_system_id = enrollment_source_system_id;
		this.livingSituation = livingSituation;
		this.datetostreetessh = datetostreetessh;
		this.dedupClientId = dedupClientId;
	}
	private String projectEntryID;
	private String continuouslyhomelessoneyear;
	private String disablingcondition;  
	private Date entrydate;
	private Date dateCreatedFromSource;
	private String householdid;
	private String housingstatus;
	private String housingstatus_desc;
	private String monthshomelesspastthreeyears;
	private String monthshomelesspastthreeyears_desc;
	private String monthshomelessthistime;
	private String otherresidenceprior; 
	private String projectID;
	private String relationshiptohoh;
	private String relationshiptohoh_desc;
	private String residenceprior;
	private String residenceprior_desc;
	private String residencepriorlengthofstay;
	private String residencepriorlengthofstay_desc;
	private String statusdocumented;
	private String timeshomelesspastthreeyears;
	private String timeshomelesspastthreeyears_desc;
	private String yearshomeless;
	private String personalID;
	private int ageatentry;
	private boolean chronichomeless;
	private String enrollment_source_system_id;
	private String livingSituation;
	private Date datetostreetessh;
	private String dedupClientId;
	/**
	 * @return the projectEntryID
	 */
	public String getProjectEntryID() {
		return projectEntryID;
	}
	/**
	 * @param projectEntryID the projectEntryID to set
	 */
	public void setProjectEntryID(String projectEntryID) {
		this.projectEntryID = projectEntryID;
	}
	/**
	 * @return the continuouslyhomelessoneyear
	 */
	public String getContinuouslyhomelessoneyear() {
		return continuouslyhomelessoneyear;
	}
	/**
	 * @param continuouslyhomelessoneyear the continuouslyhomelessoneyear to set
	 */
	public void setContinuouslyhomelessoneyear(String continuouslyhomelessoneyear) {
		this.continuouslyhomelessoneyear = continuouslyhomelessoneyear;
	}
	/**
	 * @return the disablingcondition
	 */
	public String getDisablingcondition() {
		return disablingcondition;
	}
	/**
	 * @param disablingcondition the disablingcondition to set
	 */
	public void setDisablingcondition(String disablingcondition) {
		this.disablingcondition = disablingcondition;
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
	public Date getDateCreatedFromSource() {
		return dateCreatedFromSource;
	}
	public void setDateCreatedFromSource(Date dateCreatedFromSource) {
		this.dateCreatedFromSource = dateCreatedFromSource;
	}
	/**
	 * @return the householdid
	 */
	public String getHouseholdid() {
		return householdid;
	}
	/**
	 * @param householdid the householdid to set
	 */
	public void setHouseholdid(String householdid) {
		this.householdid = householdid;
	}
	/**
	 * @return the housingstatus
	 */
	public String getHousingstatus() {
		return housingstatus;
	}
	/**
	 * @param housingstatus the housingstatus to set
	 */
	public void setHousingstatus(String housingstatus) {
		this.housingstatus = housingstatus;
	}
	/**
	 * @return the housingstatus_desc
	 */
	public String getHousingstatus_desc() {
		return housingstatus_desc;
	}
	/**
	 * @param housingstatus_desc the housingstatus_desc to set
	 */
	public void setHousingstatus_desc(String housingstatus_desc) {
		this.housingstatus_desc = housingstatus_desc;
	}
	/**
	 * @return the monthshomelesspastthreeyears
	 */
	public String getMonthshomelesspastthreeyears() {
		return monthshomelesspastthreeyears;
	}
	/**
	 * @param monthshomelesspastthreeyears the monthshomelesspastthreeyears to set
	 */
	public void setMonthshomelesspastthreeyears(String monthshomelesspastthreeyears) {
		this.monthshomelesspastthreeyears = monthshomelesspastthreeyears;
	}
	/**
	 * @return the monthshomelesspastthreeyears_desc
	 */
	public String getMonthshomelesspastthreeyears_desc() {
		return monthshomelesspastthreeyears_desc;
	}
	/**
	 * @param monthshomelesspastthreeyears_desc the monthshomelesspastthreeyears_desc to set
	 */
	public void setMonthshomelesspastthreeyears_desc(
			String monthshomelesspastthreeyears_desc) {
		this.monthshomelesspastthreeyears_desc = monthshomelesspastthreeyears_desc;
	}
	/**
	 * @return the monthshomelessthistime
	 */
	public String getMonthshomelessthistime() {
		return monthshomelessthistime;
	}
	/**
	 * @param monthshomelessthistime the monthshomelessthistime to set
	 */
	public void setMonthshomelessthistime(String monthshomelessthistime) {
		this.monthshomelessthistime = monthshomelessthistime;
	}
	/**
	 * @return the otherresidenceprior
	 */
	public String getOtherresidenceprior() {
		return otherresidenceprior;
	}
	/**
	 * @param otherresidenceprior the otherresidenceprior to set
	 */
	public void setOtherresidenceprior(String otherresidenceprior) {
		this.otherresidenceprior = otherresidenceprior;
	}
	/**
	 * @return the projectID
	 */
	public String getProjectID() {
		return projectID;
	}
	/**
	 * @param projectID the projectID to set
	 */
	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
	/**
	 * @return the relationshiptohoh
	 */
	public String getRelationshiptohoh() {
		return relationshiptohoh;
	}
	/**
	 * @param relationshiptohoh the relationshiptohoh to set
	 */
	public void setRelationshiptohoh(String relationshiptohoh) {
		this.relationshiptohoh = relationshiptohoh;
	}
	/**
	 * @return the relationshiptohoh_desc
	 */
	public String getRelationshiptohoh_desc() {
		return relationshiptohoh_desc;
	}
	/**
	 * @param relationshiptohoh_desc the relationshiptohoh_desc to set
	 */
	public void setRelationshiptohoh_desc(String relationshiptohoh_desc) {
		this.relationshiptohoh_desc = relationshiptohoh_desc;
	}
	/**
	 * @return the residenceprior
	 */
	public String getResidenceprior() {
		return residenceprior;
	}
	/**
	 * @param residenceprior the residenceprior to set
	 */
	public void setResidenceprior(String residenceprior) {
		this.residenceprior = residenceprior;
	}
	/**
	 * @return the residenceprior_desc
	 */
	public String getResidenceprior_desc() {
		return residenceprior_desc;
	}
	/**
	 * @param residenceprior_desc the residenceprior_desc to set
	 */
	public void setResidenceprior_desc(String residenceprior_desc) {
		this.residenceprior_desc = residenceprior_desc;
	}
	/**
	 * @return the residencepriorlengthofstay
	 */
	public String getResidencepriorlengthofstay() {
		return residencepriorlengthofstay;
	}
	/**
	 * @param residencepriorlengthofstay the residencepriorlengthofstay to set
	 */
	public void setResidencepriorlengthofstay(String residencepriorlengthofstay) {
		this.residencepriorlengthofstay = residencepriorlengthofstay;
	}
	/**
	 * @return the residencepriorlengthofstay_desc
	 */
	public String getResidencepriorlengthofstay_desc() {
		return residencepriorlengthofstay_desc;
	}
	/**
	 * @param residencepriorlengthofstay_desc the residencepriorlengthofstay_desc to set
	 */
	public void setResidencepriorlengthofstay_desc(
			String residencepriorlengthofstay_desc) {
		this.residencepriorlengthofstay_desc = residencepriorlengthofstay_desc;
	}
	/**
	 * @return the statusdocumented
	 */
	public String getStatusdocumented() {
		return statusdocumented;
	}
	/**
	 * @param statusdocumented the statusdocumented to set
	 */
	public void setStatusdocumented(String statusdocumented) {
		this.statusdocumented = statusdocumented;
	}
	/**
	 * @return the timeshomelesspastthreeyears
	 */
	public String getTimeshomelesspastthreeyears() {
		return timeshomelesspastthreeyears;
	}
	/**
	 * @param timeshomelesspastthreeyears the timeshomelesspastthreeyears to set
	 */
	public void setTimeshomelesspastthreeyears(String timeshomelesspastthreeyears) {
		this.timeshomelesspastthreeyears = timeshomelesspastthreeyears;
	}
	/**
	 * @return the timeshomelesspastthreeyears_desc
	 */
	public String getTimeshomelesspastthreeyears_desc() {
		return timeshomelesspastthreeyears_desc;
	}
	/**
	 * @param timeshomelesspastthreeyears_desc the timeshomelesspastthreeyears_desc to set
	 */
	public void setTimeshomelesspastthreeyears_desc(
			String timeshomelesspastthreeyears_desc) {
		this.timeshomelesspastthreeyears_desc = timeshomelesspastthreeyears_desc;
	}
	/**
	 * @return the yearshomeless
	 */
	public String getYearshomeless() {
		return yearshomeless;
	}
	/**
	 * @param yearshomeless the yearshomeless to set
	 */
	public void setYearshomeless(String yearshomeless) {
		this.yearshomeless = yearshomeless;
	}
	/**
	 * @return the personalID
	 */
	public String getPersonalID() {
		return personalID;
	}
	/**
	 * @param personalID the personalID to set
	 */
	public void setPersonalID(String personalID) {
		this.personalID = personalID;
	}
	/**
	 * @return the ageatentry
	 */
	public int getAgeatentry() {
		return ageatentry;
	}
	/**
	 * @param ageatentry the ageatentry to set
	 */
	public void setAgeatentry(int ageatentry) {
		this.ageatentry = ageatentry;
	}
	/**
	 * @return the chronichomeless
	 */
	public boolean isChronichomeless() {
		return chronichomeless;
	}
	/**
	 * @param chronichomeless the chronichomeless to set
	 */
	public void setChronichomeless(boolean chronichomeless) {
		this.chronichomeless = chronichomeless;
	}
	/**
	 * @return the enrollment_source_system_id
	 */
	public String getEnrollment_source_system_id() {
		return enrollment_source_system_id;
	}
	/**
	 * @param enrollment_source_system_id the enrollment_source_system_id to set
	 */
	public void setEnrollment_source_system_id(String enrollment_source_system_id) {
		this.enrollment_source_system_id = enrollment_source_system_id;
	}
	public String getLivingSituation() {
		return livingSituation;
	}
	public void setLivingSituation(String livingSituation) {
		this.livingSituation = livingSituation;
	}
	public Date getDatetostreetessh() {
		return datetostreetessh;
	}
	public void setDatetostreetessh(Date datetostreetessh) {
		this.datetostreetessh = datetostreetessh;
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
	
}
