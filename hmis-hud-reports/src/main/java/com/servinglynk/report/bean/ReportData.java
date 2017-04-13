package com.servinglynk.report.bean;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ReportData {
	private String schema;
	private String projectId;
	private List<ClientModel> clients = new ArrayList<ClientModel>();
	private List<EnrollmentModel> enrollments = new ArrayList<EnrollmentModel>();
	private List<ExitModel> exits = new ArrayList<ExitModel>();
	
	private BigInteger totNumOfPersonServed;
	private BigInteger numOfAdults;
	private BigInteger numOfChildren;
	private BigInteger numOfPersonsWithUnknownAge;
	private BigInteger totNoOfAdultStayers;
	private BigInteger totNoOfAdultLeavers;
	private BigInteger noOfVeterans;
	private BigInteger noOfChronicallyHomelessPersons;
	private BigInteger noOfAdultHeadsOfHousehold;
	private BigInteger noOfChildHeadsOfHousehold;
	private BigInteger numOfParentingYouthUnderAge25WithChildren;
	private BigInteger numOfAdultandHeadOfHHLeavers;
	private BigInteger numOfYouthUnderAge25;
	private BigInteger numOfHeadsOfHHandAdults365Days;
	
	
	/**
	 * @return the schema
	 */
	public String getSchema() {
		return schema;
	}
	/**
	 * @param schema the schema to set
	 */
	public void setSchema(String schema) {
		this.schema = schema;
	}
	/**
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * @return the clients
	 */
	public List<ClientModel> getClients() {
		return clients;
	}
	/**
	 * @param clients the clients to set
	 */
	public void setClients(List<ClientModel> clients) {
		this.clients = clients;
	}
	/**
	 * @return the enrollments
	 */
	public List<EnrollmentModel> getEnrollments() {
		return enrollments;
	}
	/**
	 * @param enrollments the enrollments to set
	 */
	public void setEnrollments(List<EnrollmentModel> enrollments) {
		this.enrollments = enrollments;
	}
	/**
	 * @return the exits
	 */
	public List<ExitModel> getExits() {
		return exits;
	}
	/**
	 * @param exits the exits to set
	 */
	public void setExits(List<ExitModel> exits) {
		this.exits = exits;
	}
	/**
	 * @return the totNumOfPersonServed
	 */
	public BigInteger getTotNumOfPersonServed() {
		return totNumOfPersonServed;
	}
	/**
	 * @param totNumOfPersonServed the totNumOfPersonServed to set
	 */
	public void setTotNumOfPersonServed(BigInteger totNumOfPersonServed) {
		this.totNumOfPersonServed = totNumOfPersonServed;
	}
	/**
	 * @return the numOfAdults
	 */
	public BigInteger getNumOfAdults() {
		return numOfAdults;
	}
	/**
	 * @param numOfAdults the numOfAdults to set
	 */
	public void setNumOfAdults(BigInteger numOfAdults) {
		this.numOfAdults = numOfAdults;
	}
	/**
	 * @return the numOfChildren
	 */
	public BigInteger getNumOfChildren() {
		return numOfChildren;
	}
	/**
	 * @param numOfChildren the numOfChildren to set
	 */
	public void setNumOfChildren(BigInteger numOfChildren) {
		this.numOfChildren = numOfChildren;
	}
	/**
	 * @return the numOfPersonsWithUnknownAge
	 */
	public BigInteger getNumOfPersonsWithUnknownAge() {
		return numOfPersonsWithUnknownAge;
	}
	/**
	 * @param numOfPersonsWithUnknownAge the numOfPersonsWithUnknownAge to set
	 */
	public void setNumOfPersonsWithUnknownAge(BigInteger numOfPersonsWithUnknownAge) {
		this.numOfPersonsWithUnknownAge = numOfPersonsWithUnknownAge;
	}
	/**
	 * @return the totNoOfAdultStayers
	 */
	public BigInteger getTotNoOfAdultStayers() {
		return totNoOfAdultStayers;
	}
	/**
	 * @param totNoOfAdultStayers the totNoOfAdultStayers to set
	 */
	public void setTotNoOfAdultStayers(BigInteger totNoOfAdultStayers) {
		this.totNoOfAdultStayers = totNoOfAdultStayers;
	}
	/**
	 * @return the totNoOfAdultLeavers
	 */
	public BigInteger getTotNoOfAdultLeavers() {
		return totNoOfAdultLeavers;
	}
	/**
	 * @param totNoOfAdultLeavers the totNoOfAdultLeavers to set
	 */
	public void setTotNoOfAdultLeavers(BigInteger totNoOfAdultLeavers) {
		this.totNoOfAdultLeavers = totNoOfAdultLeavers;
	}
	/**
	 * @return the noOfVeterans
	 */
	public BigInteger getNoOfVeterans() {
		return noOfVeterans;
	}
	/**
	 * @param noOfVeterans the noOfVeterans to set
	 */
	public void setNoOfVeterans(BigInteger noOfVeterans) {
		this.noOfVeterans = noOfVeterans;
	}
	/**
	 * @return the noOfChronicallyHomelessPersons
	 */
	public BigInteger getNoOfChronicallyHomelessPersons() {
		return noOfChronicallyHomelessPersons;
	}
	/**
	 * @param noOfChronicallyHomelessPersons the noOfChronicallyHomelessPersons to set
	 */
	public void setNoOfChronicallyHomelessPersons(BigInteger noOfChronicallyHomelessPersons) {
		this.noOfChronicallyHomelessPersons = noOfChronicallyHomelessPersons;
	}
	/**
	 * @return the noOfAdultHeadsOfHousehold
	 */
	public BigInteger getNoOfAdultHeadsOfHousehold() {
		return noOfAdultHeadsOfHousehold;
	}
	/**
	 * @param noOfAdultHeadsOfHousehold the noOfAdultHeadsOfHousehold to set
	 */
	public void setNoOfAdultHeadsOfHousehold(BigInteger noOfAdultHeadsOfHousehold) {
		this.noOfAdultHeadsOfHousehold = noOfAdultHeadsOfHousehold;
	}
	/**
	 * @return the noOfChildHeadsOfHousehold
	 */
	public BigInteger getNoOfChildHeadsOfHousehold() {
		return noOfChildHeadsOfHousehold;
	}
	/**
	 * @param noOfChildHeadsOfHousehold the noOfChildHeadsOfHousehold to set
	 */
	public void setNoOfChildHeadsOfHousehold(BigInteger noOfChildHeadsOfHousehold) {
		this.noOfChildHeadsOfHousehold = noOfChildHeadsOfHousehold;
	}
	/**
	 * @return the numOfParentingYouthUnderAge25WithChildren
	 */
	public BigInteger getNumOfParentingYouthUnderAge25WithChildren() {
		return numOfParentingYouthUnderAge25WithChildren;
	}
	/**
	 * @param numOfParentingYouthUnderAge25WithChildren the numOfParentingYouthUnderAge25WithChildren to set
	 */
	public void setNumOfParentingYouthUnderAge25WithChildren(BigInteger numOfParentingYouthUnderAge25WithChildren) {
		this.numOfParentingYouthUnderAge25WithChildren = numOfParentingYouthUnderAge25WithChildren;
	}
	/**
	 * @return the numOfAdultandHeadOfHHLeavers
	 */
	public BigInteger getNumOfAdultandHeadOfHHLeavers() {
		return numOfAdultandHeadOfHHLeavers;
	}
	/**
	 * @param numOfAdultandHeadOfHHLeavers the numOfAdultandHeadOfHHLeavers to set
	 */
	public void setNumOfAdultandHeadOfHHLeavers(BigInteger numOfAdultandHeadOfHHLeavers) {
		this.numOfAdultandHeadOfHHLeavers = numOfAdultandHeadOfHHLeavers;
	}
	/**
	 * @return the numOfYouthUnderAge25
	 */
	public BigInteger getNumOfYouthUnderAge25() {
		return numOfYouthUnderAge25;
	}
	/**
	 * @param numOfYouthUnderAge25 the numOfYouthUnderAge25 to set
	 */
	public void setNumOfYouthUnderAge25(BigInteger numOfYouthUnderAge25) {
		this.numOfYouthUnderAge25 = numOfYouthUnderAge25;
	}
	/**
	 * @return the numOfHeadsOfHHandAdults365Days
	 */
	public BigInteger getNumOfHeadsOfHHandAdults365Days() {
		return numOfHeadsOfHHandAdults365Days;
	}
	/**
	 * @param numOfHeadsOfHHandAdults365Days the numOfHeadsOfHHandAdults365Days to set
	 */
	public void setNumOfHeadsOfHHandAdults365Days(BigInteger numOfHeadsOfHHandAdults365Days) {
		this.numOfHeadsOfHHandAdults365Days = numOfHeadsOfHHandAdults365Days;
	}
	
}
