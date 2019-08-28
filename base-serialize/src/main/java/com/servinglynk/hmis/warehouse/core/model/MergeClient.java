package com.servinglynk.hmis.warehouse.core.model;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("client")
public class MergeClient {

	private UUID clientId;	
	private UUID dedupClientId;
	private UUID oldDedupClientId;
	private String firstName;
	private String lastName;
	private Date dob;
	private String ssn;
	/**
	 * @return the clientId
	 */
	public UUID getClientId() {
		return clientId;
	}
	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(UUID clientId) {
		this.clientId = clientId;
	}
	/**
	 * @return the dedupClientId
	 */
	public UUID getDedupClientId() {
		return dedupClientId;
	}
	/**
	 * @param dedupClientId the dedupClientId to set
	 */
	public void setDedupClientId(UUID dedupClientId) {
		this.dedupClientId = dedupClientId;
	}
	/**
	 * @return the oldDedupClientId
	 */
	public UUID getOldDedupClientId() {
		return oldDedupClientId;
	}
	/**
	 * @param oldDedupClientId the oldDedupClientId to set
	 */
	public void setOldDedupClientId(UUID oldDedupClientId) {
		this.oldDedupClientId = oldDedupClientId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
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
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	/**
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}
	/**
	 * @param ssn the ssn to set
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
}

