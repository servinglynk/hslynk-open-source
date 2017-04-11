package com.servinglynk.report.bean;

import java.util.ArrayList;
import java.util.List;

public class ReportData {
	private String schema;
	private String projectId;
	private List<ClientModel> clients = new ArrayList<ClientModel>();
	private List<EnrollmentModel> enrollments = new ArrayList<EnrollmentModel>();
	private List<ExitModel> exits = new ArrayList<ExitModel>();
	
	private int totNumOfPersonServed;
	private int numOfAdults;
	private int numOfChildren;
	private int numOfPersonsWithUnknownAge;
	private int totNoOfAdultStayers;
	private int totNoOfAdultLeavers;
	private int noOfVeterans;
	private int noOfChronicallyHomelessPersons;
	private int noOfAdultHeadsOfHousehold;
	private int noOfChildHeadsOfHousehold;
	private int numOfParentingYouthUnderAge25WithChildren;
	private int numOfAdultandHeadOfHHLeavers;
	private int numOfYouthUnderAge25;
	private int numOfHeadsOfHHandAdults365Days;
	
	
	
	
	public int getTotNumOfPersonServed() {
		return totNumOfPersonServed;
	}
	public void setTotNumOfPersonServed(int totNumOfPersonServed) {
		this.totNumOfPersonServed = totNumOfPersonServed;
	}
	public int getNumOfAdults() {
		return numOfAdults;
	}
	public void setNumOfAdults(int numOfAdults) {
		this.numOfAdults = numOfAdults;
	}
	public int getNumOfChildren() {
		return numOfChildren;
	}
	public void setNumOfChildren(int numOfChildren) {
		this.numOfChildren = numOfChildren;
	}
	public int getNumOfPersonsWithUnknownAge() {
		return numOfPersonsWithUnknownAge;
	}
	public void setNumOfPersonsWithUnknownAge(int numOfPersonsWithUnknownAge) {
		this.numOfPersonsWithUnknownAge = numOfPersonsWithUnknownAge;
	}
	public int getTotNoOfAdultStayers() {
		return totNoOfAdultStayers;
	}
	public void setTotNoOfAdultStayers(int totNoOfAdultStayers) {
		this.totNoOfAdultStayers = totNoOfAdultStayers;
	}
	public int getTotNoOfAdultLeavers() {
		return totNoOfAdultLeavers;
	}
	public void setTotNoOfAdultLeavers(int totNoOfAdultLeavers) {
		this.totNoOfAdultLeavers = totNoOfAdultLeavers;
	}
	public int getNoOfVeterans() {
		return noOfVeterans;
	}
	public void setNoOfVeterans(int noOfVeterans) {
		this.noOfVeterans = noOfVeterans;
	}
	public int getNoOfChronicallyHomelessPersons() {
		return noOfChronicallyHomelessPersons;
	}
	public void setNoOfChronicallyHomelessPersons(int noOfChronicallyHomelessPersons) {
		this.noOfChronicallyHomelessPersons = noOfChronicallyHomelessPersons;
	}
	public int getNoOfAdultHeadsOfHousehold() {
		return noOfAdultHeadsOfHousehold;
	}
	public void setNoOfAdultHeadsOfHousehold(int noOfAdultHeadsOfHousehold) {
		this.noOfAdultHeadsOfHousehold = noOfAdultHeadsOfHousehold;
	}
	public int getNoOfChildHeadsOfHousehold() {
		return noOfChildHeadsOfHousehold;
	}
	public void setNoOfChildHeadsOfHousehold(int noOfChildHeadsOfHousehold) {
		this.noOfChildHeadsOfHousehold = noOfChildHeadsOfHousehold;
	}
	public int getNumOfParentingYouthUnderAge25WithChildren() {
		return numOfParentingYouthUnderAge25WithChildren;
	}
	public void setNumOfParentingYouthUnderAge25WithChildren(
			int numOfParentingYouthUnderAge25WithChildren) {
		this.numOfParentingYouthUnderAge25WithChildren = numOfParentingYouthUnderAge25WithChildren;
	}
	public int getNumOfAdultandHeadOfHHLeavers() {
		return numOfAdultandHeadOfHHLeavers;
	}
	public void setNumOfAdultandHeadOfHHLeavers(int numOfAdultandHeadOfHHLeavers) {
		this.numOfAdultandHeadOfHHLeavers = numOfAdultandHeadOfHHLeavers;
	}
	public int getNumOfYouthUnderAge25() {
		return numOfYouthUnderAge25;
	}
	public void setNumOfYouthUnderAge25(int numOfYouthUnderAge25) {
		this.numOfYouthUnderAge25 = numOfYouthUnderAge25;
	}
	public int getNumOfHeadsOfHHandAdults365Days() {
		return numOfHeadsOfHHandAdults365Days;
	}
	public void setNumOfHeadsOfHHandAdults365Days(int numOfHeadsOfHHandAdults365Days) {
		this.numOfHeadsOfHHandAdults365Days = numOfHeadsOfHHandAdults365Days;
	}
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
	
}
