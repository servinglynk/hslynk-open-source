package com.servinglynk.report.bean;

import java.math.BigInteger;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.servinglynk.report.model.ClientModel;
import com.servinglynk.report.model.ContactModel;
import com.servinglynk.report.model.DateOfEngagementModel;
import com.servinglynk.report.model.EnrollmentModel;
import com.servinglynk.report.model.ExitModel;
import com.servinglynk.report.model.IncomeAndSourceModel;
import com.servinglynk.report.model.ProjectModel;

public class ReportData {
	private String schema;
	private String projectId;
	private Date reportStartDate;
	private Date reportEndDate;
	private boolean sageReport;
	private boolean capterReport;
	private boolean aprReport;
	private List<ClientModel> clients = new ArrayList<ClientModel>();
	private List<ProjectModel> projects = new ArrayList<ProjectModel>();
	private List<EnrollmentModel> enrollments = new ArrayList<EnrollmentModel>();
	private List<ExitModel> exits = new ArrayList<ExitModel>();
	private List<ContactModel> contacts = new ArrayList<>();
	private List<DateOfEngagementModel> dateOfEngagements = new ArrayList<>();
	private List<IncomeAndSourceModel> incomeAndSources = new ArrayList<>();
	private ProjectModel project;
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
	List<String> enrollmentIds = new ArrayList<String>();
	List<String> projectsHHWithChildren = new ArrayList<String>();
	List<String> projectsHHWithOneAdultChild  =  new ArrayList<String>();
	List<String> projectsHHWithOutChildren  =  new ArrayList<String>();
	List<String> projectsUnknownHouseHold  =  new ArrayList<String>();
	
	
	private BigInteger totPersonsContacted = BigInteger.ZERO;
	private BigInteger tpcFirstContactedHumanHabitation= BigInteger.ZERO;
	private BigInteger tpcFirstContacteRSS = BigInteger.ZERO;
	private BigInteger tpcFirstContactedNRSS = BigInteger.ZERO;
	private BigInteger tpcFirstContactedPlaceMissing = BigInteger.ZERO;
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
	 * @return the reportStartDate
	 */
	public Date getReportStartDate() {
		return reportStartDate;
	}
	/**
	 * @param reportStartDate the reportStartDate to set
	 */
	public void setReportStartDate(Date reportStartDate) {
		this.reportStartDate = reportStartDate;
	}
	/**
	 * @return the reportEndDate
	 */
	public Date getReportEndDate() {
		return reportEndDate;
	}
	/**
	 * @param reportEndDate the reportEndDate to set
	 */
	public void setReportEndDate(Date reportEndDate) {
		this.reportEndDate = reportEndDate;
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
	 * @return the incomeAndSources
	 */
	public List<IncomeAndSourceModel> getIncomeAndSources() {
		return incomeAndSources;
	}
	/**
	 * @param incomeAndSources the incomeAndSources to set
	 */
	public void setIncomeAndSources(List<IncomeAndSourceModel> incomeAndSources) {
		this.incomeAndSources = incomeAndSources;
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
	/**
	 * @return the project
	 */
	public ProjectModel getProject() {
		return project;
	}
	/**
	 * @param project the project to set
	 */
	public void setProject(ProjectModel project) {
		this.project = project;
	}
	public List<ProjectModel> getProjects() {
		return projects;
	}
	public void setProjects(List<ProjectModel> projects) {
		this.projects = projects;
	}
	public List<String> getProjectsHHWithChildren() {
		return projectsHHWithChildren;
	}
	public void setProjectsHHWithChildren(List<String> projectsHHWithChildren) {
		this.projectsHHWithChildren = projectsHHWithChildren;
	}
	public List<String> getProjectsHHWithOneAdultChild() {
		return projectsHHWithOneAdultChild;
	}
	public void setProjectsHHWithOneAdultChild(
			List<String> projectsHHWithOneAdultChild) {
		this.projectsHHWithOneAdultChild = projectsHHWithOneAdultChild;
	}
	public List<String> getProjectsHHWithOutChildren() {
		return projectsHHWithOutChildren;
	}
	public void setProjectsHHWithOutChildren(List<String> projectsHHWithOutChildren) {
		this.projectsHHWithOutChildren = projectsHHWithOutChildren;
	}
	public List<String> getProjectsUnknownHouseHold() {
		return projectsUnknownHouseHold;
	}
	public void setProjectsUnknownHouseHold(List<String> projectsUnknownHouseHold) {
		this.projectsUnknownHouseHold = projectsUnknownHouseHold;
	}
	/**
	 * @return the enrollmentIds
	 */
	public List<String> getEnrollmentIds() {
		return enrollmentIds;
	}
	/**
	 * @param enrollmentIds the enrollmentIds to set
	 */
	public void setEnrollmentIds(List<String> enrollmentIds) {
		this.enrollmentIds = enrollmentIds;
	}
	/**
	 * @return the contacts
	 */
	public List<ContactModel> getContacts() {
		return contacts;
	}
	/**
	 * @param contacts the contacts to set
	 */
	public void setContacts(List<ContactModel> contacts) {
		this.contacts = contacts;
	}
	/**
	 * @return the dateOfEngagements
	 */
	public List<DateOfEngagementModel> getDateOfEngagements() {
		return dateOfEngagements;
	}
	/**
	 * @param dateOfEngagements the dateOfEngagements to set
	 */
	public void setDateOfEngagements(List<DateOfEngagementModel> dateOfEngagements) {
		this.dateOfEngagements = dateOfEngagements;
	}
	/**
	 * @return the totPersonsContacted
	 */
	public BigInteger getTotPersonsContacted() {
		return totPersonsContacted;
	}
	/**
	 * @param totPersonsContacted the totPersonsContacted to set
	 */
	public void setTotPersonsContacted(BigInteger totPersonsContacted) {
		this.totPersonsContacted = totPersonsContacted;
	}
	/**
	 * @return the tpcFirstContactedHumanHabitation
	 */
	public BigInteger getTpcFirstContactedHumanHabitation() {
		return tpcFirstContactedHumanHabitation;
	}
	/**
	 * @param tpcFirstContactedHumanHabitation the tpcFirstContactedHumanHabitation to set
	 */
	public void setTpcFirstContactedHumanHabitation(BigInteger tpcFirstContactedHumanHabitation) {
		this.tpcFirstContactedHumanHabitation = tpcFirstContactedHumanHabitation;
	}
	/**
	 * @return the tpcFirstContacteRSS
	 */
	public BigInteger getTpcFirstContacteRSS() {
		return tpcFirstContacteRSS;
	}
	/**
	 * @param tpcFirstContacteRSS the tpcFirstContacteRSS to set
	 */
	public void setTpcFirstContacteRSS(BigInteger tpcFirstContacteRSS) {
		this.tpcFirstContacteRSS = tpcFirstContacteRSS;
	}
	/**
	 * @return the tpcFirstContactedNRSS
	 */
	public BigInteger getTpcFirstContactedNRSS() {
		return tpcFirstContactedNRSS;
	}
	/**
	 * @param tpcFirstContactedNRSS the tpcFirstContactedNRSS to set
	 */
	public void setTpcFirstContactedNRSS(BigInteger tpcFirstContactedNRSS) {
		this.tpcFirstContactedNRSS = tpcFirstContactedNRSS;
	}
	/**
	 * @return the tpcFirstContactedPlaceMissing
	 */
	public BigInteger getTpcFirstContactedPlaceMissing() {
		return tpcFirstContactedPlaceMissing;
	}
	/**
	 * @param tpcFirstContactedPlaceMissing the tpcFirstContactedPlaceMissing to set
	 */
	public void setTpcFirstContactedPlaceMissing(BigInteger tpcFirstContactedPlaceMissing) {
		this.tpcFirstContactedPlaceMissing = tpcFirstContactedPlaceMissing;
	}
	/**
	 * @return the sageReport
	 */
	public boolean isSageReport() {
		return sageReport;
	}
	/**
	 * @param sageReport the sageReport to set
	 */
	public void setSageReport(boolean sageReport) {
		this.sageReport = sageReport;
	}
	/**
	 * @return the capterReport
	 */
	public boolean isCapterReport() {
		return capterReport;
	}
	/**
	 * @param capterReport the capterReport to set
	 */
	public void setCapterReport(boolean capterReport) {
		this.capterReport = capterReport;
	}
	/**
	 * @return the aprReport
	 */
	public boolean isAprReport() {
		return aprReport;
	}
	/**
	 * @param aprReport the aprReport to set
	 */
	public void setAprReport(boolean aprReport) {
		this.aprReport = aprReport;
	}
	
}
