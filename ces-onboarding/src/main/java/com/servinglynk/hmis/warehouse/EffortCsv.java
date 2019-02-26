package com.servinglynk.hmis.warehouse;

import com.googlecode.jcsv.annotations.MapToColumn;

public class EffortCsv {

	@MapToColumn(column=0)
	private String sourceSystemId;
	@MapToColumn(column=1)
	private String firstName;
	@MapToColumn(column=2)
	private String lastName;
	@MapToColumn(column=3)
	private String ssn;
	@MapToColumn(column=4)
	private String effortName;
	@MapToColumn(column=5)
	private String effortValue;
	@MapToColumn(column=6)
	private String staffingAgent;
	@MapToColumn(column=7)
	private String dateContacted;
	@MapToColumn(column=8)
	private String time;
	@MapToColumn(column=9)
	private String internalExternal;
	/**
	 * @return the sourceSystemId
	 */
	public String getSourceSystemId() {
		return sourceSystemId;
	}
	/**
	 * @param sourceSystemId the sourceSystemId to set
	 */
	public void setSourceSystemId(String sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		this.firstName = firstName != null ? firstName.trim().toLowerCase() : firstName;
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		this.lastName = lastName != null ? lastName.trim().toLowerCase() : lastName;
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn != null ? ssn.trim().toLowerCase() : ssn;
	}
	/**
	 * @param ssn the ssn to set
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	/**
	 * @return the effortName
	 */
	public String getEffortName() {
		this.effortName= effortName != null ? effortName.trim(): effortName;
		return effortName;
	}
	/**
	 * @param effortName the effortName to set
	 */
	public void setEffortName(String effortName) {
		this.effortName = effortName;
	}
	/**
	 * @return the effortValue
	 */
	public String getEffortValue() {
		this.effortValue = effortValue != null ? effortValue.trim().substring(0, 3).replace(" ", "") : effortValue;
		return effortValue;
	}
	/**
	 * @param effortValue the effortValue to set
	 */
	public void setEffortValue(String effortValue) {
		this.effortValue = effortValue;
	}
	/**
	 * @return the staffingAgent
	 */
	public String getStaffingAgent() {
		this.staffingAgent= staffingAgent != null ? staffingAgent.replaceAll("\"", "").trim().toLowerCase() : staffingAgent;
		return staffingAgent;
	}
	/**
	 * @param staffingAgent the staffingAgent to set
	 */
	public void setStaffingAgent(String staffingAgent) {
		this.staffingAgent = staffingAgent;
	}
	/**
	 * @return the dateContacted
	 */
	public String getDateContacted() {
		return dateContacted;
	}
	/**
	 * @param dateContacted the dateContacted to set
	 */
	public void setDateContacted(String dateContacted) {
		this.dateContacted = dateContacted;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		this.time= time != null ? time.trim(): time;
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the internalExternal
	 */
	public String getInternalExternal() {
		this.internalExternal = internalExternal != null ? internalExternal.trim(): internalExternal;
		return internalExternal;
	}
	/**
	 * @param internalExternal the internalExternal to set
	 */
	public void setInternalExternal(String internalExternal) {
		this.internalExternal = internalExternal;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EffortCsv [sourceSystemId=" + sourceSystemId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", ssn=" + ssn + ", effortName=" + effortName + ", effortValue=" + effortValue + ", staffingAgent="
				+ staffingAgent + ", dateContacted=" + dateContacted + ", time=" + time + ", internalExternal="
				+ internalExternal + "]";
	}
	
}
