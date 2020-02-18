package com.servinglynk.report.bean;

import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.servinglynk.report.model.ClientModel;
import com.servinglynk.report.model.ContactModel;
import com.servinglynk.report.model.DateOfEngagementModel;
import com.servinglynk.report.model.EnrollmentModel;
import com.servinglynk.report.model.ExitModel;
import com.servinglynk.report.model.IncomeAndSourceModel;
import com.servinglynk.report.model.ProjectModel;
import com.servinglynk.report.model.Q22BeanModel;

public class ReportData {
	private String schema;
	private String projectId;
	private Date reportStartDate;
	private Date reportEndDate;
	private boolean sageReport;
	private boolean capterReport;
	private boolean aprReport;
	private boolean liveMode;
	private String configPath;
	private List<String> projectIds;
	private List<ClientModel> clients = new ArrayList<ClientModel>();
	private List<ProjectModel> projects = new ArrayList<ProjectModel>();
	private List<EnrollmentModel> enrollments = new ArrayList<EnrollmentModel>();
	private List<ExitModel> exits = new ArrayList<ExitModel>();
	private List<EnrollmentModel> adultStayers = new ArrayList<>();
	private List<EnrollmentModel> stayers = new ArrayList<>();
	private List<EnrollmentModel> adultLeavers = new ArrayList<>();
	private List<EnrollmentModel> leavers = new ArrayList<>();
	private List<EnrollmentModel> activeClients = new ArrayList<>();
	private List<ClientModel> veterans = new ArrayList<>();
	private List<EnrollmentModel> chronicHomeLess = new ArrayList<>();
	private List<ContactModel> contacts = new ArrayList<>();
	private List<DateOfEngagementModel> dateOfEngagements = new ArrayList<>();
	private List<IncomeAndSourceModel> incomeAndSourcesAtEntry = new ArrayList<>();
	private List<IncomeAndSourceModel> incomeAndSourcesAtExit = new ArrayList<>();
	private List<IncomeAndSourceModel> incomeAndSourcesAtAnnualAssesment = new ArrayList<>();
	private List<EnrollmentModel> requireAA = new ArrayList<>();
	private List<EnrollmentModel> notrequireAA = new ArrayList<>();
	private  List<Q22BeanModel> stayersLengthofStay = new ArrayList<>();
	private  List<Q22BeanModel> leaversLengthofStay = new ArrayList<>();
	private List<Q22BeanModel> allDataLenghtofStay = new ArrayList<>();
	private List<EnrollmentModel> adultHoh = new ArrayList<>();
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
	private BigInteger numOfAdultStayersNotRequiredAnnualAssesment=BigInteger.valueOf(0);
	private BigInteger numOfAdultStayersWithoutRequiredAnnualAssesment=BigInteger.valueOf(0);
	private String queryDataCollectionStage;
	private String queryDedupClientId;
	private Set<String> veteranAtExit = new HashSet<>();
	private List<EnrollmentModel> adultStayersHoh365Days = new ArrayList<>();
	List<String> enrollmentIds = new ArrayList<String>();
	List<String> projectsHHWithChildren = new ArrayList<String>();
	List<String> projectsHHWithOneAdultChild  =  new ArrayList<String>();
	List<String> projectsHHWithOutChildren  =  new ArrayList<String>();
	List<String> projectsUnknownHouseHold  =  new ArrayList<String>();
	private List<EnrollmentModel> adultWithChildren;
	private List<EnrollmentModel> adultsWithOneAdultChild;
	private List<EnrollmentModel> adultsWithOutChildren;
	private List<EnrollmentModel> adultsUnknownHHType;
	
	private List<String> pshRrhTotal = null;
	private List<EnrollmentModel> pshRrhWithOutChildren = null;
	private List<EnrollmentModel> pshRrhWithChildAndAdults = null;
	private List<EnrollmentModel> pshRrhWithOnlychildren = null;
	private List<EnrollmentModel> pshRrhUnknownHousehold = null;
	
	private BigInteger totPersonsContacted = BigInteger.ZERO;
	private BigInteger tpcFirstContactedHumanHabitation= BigInteger.ZERO;
	private BigInteger tpcFirstContacteRSS = BigInteger.ZERO;
	private BigInteger tpcFirstContactedNRSS = BigInteger.ZERO;
	private BigInteger tpcFirstContactedPlaceMissing = BigInteger.ZERO;
	
	private BigInteger overAllTotHouseHolds=BigInteger.valueOf(0);
	private BigInteger totHhWithoutChild=BigInteger.valueOf(0);
	private BigInteger totHhWithChildAndAdults=BigInteger.valueOf(0);
	private BigInteger totHhWothOnlyChild=BigInteger.valueOf(0);
	private BigInteger totHhUnknownHhType=BigInteger.valueOf(0);
	private List<String> youthList = new ArrayList<String>();
	
	/**
	 * @return the queryDataCollectionStage
	 */
	public String getQueryDataCollectionStage() {
		return queryDataCollectionStage;
	}
	/**
	 * @param queryDataCollectionStage the queryDataCollectionStage to set
	 */
	public void setQueryDataCollectionStage(String queryDataCollectionStage) {
		this.queryDataCollectionStage = queryDataCollectionStage;
	}
	
	/**
	 * @return the queryDedupClientId
	 */
	public String getQueryDedupClientId() {
		return queryDedupClientId;
	}
	/**
	 * @param queryDedupClientId the queryDedupClientId to set
	 */
	public void setQueryDedupClientId(String queryDedupClientId) {
		this.queryDedupClientId = queryDedupClientId;
	}
	public BigInteger getOverAllTotHouseHolds() {
		return overAllTotHouseHolds;
	}
	public void setOverAllTotHouseHolds(BigInteger overAllTotHouseHolds) {
		this.overAllTotHouseHolds = overAllTotHouseHolds;
	}
	public BigInteger getTotHhWithoutChild() {
		return totHhWithoutChild;
	}
	public void setTotHhWithoutChild(BigInteger totHhWithoutChild) {
		this.totHhWithoutChild = totHhWithoutChild;
	}
	public BigInteger getTotHhWithChildAndAdults() {
		return totHhWithChildAndAdults;
	}
	public void setTotHhWithChildAndAdults(BigInteger totHhWithChildAndAdults) {
		this.totHhWithChildAndAdults = totHhWithChildAndAdults;
	}
	public BigInteger getTotHhWothOnlyChild() {
		return totHhWothOnlyChild;
	}
	public void setTotHhWothOnlyChild(BigInteger totHhWothOnlyChild) {
		this.totHhWothOnlyChild = totHhWothOnlyChild;
	}
	public BigInteger getTotHhUnknownHhType() {
		return totHhUnknownHhType;
	}
	public void setTotHhUnknownHhType(BigInteger totHhUnknownHhType) {
		this.totHhUnknownHhType = totHhUnknownHhType;
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
	 * @return the configPath
	 */
	public String getConfigPath() {
		return configPath;
	}
	/**
	 * @param configPath the configPath to set
	 */
	public void setConfigPath(String configPath) {
		this.configPath = configPath;
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
	/**
	 * @return the liveMode
	 */
	public boolean isLiveMode() {
		return liveMode;
	}
	/**
	 * @param liveMode the liveMode to set
	 */
	public void setLiveMode(boolean liveMode) {
		this.liveMode = liveMode;
	}
	
	/**
	 * @return the stayers
	 */
	public List<EnrollmentModel> getStayers() {
		return stayers;
	}
	/**
	 * @param stayers the stayers to set
	 */
	public void setStayers(List<EnrollmentModel> stayers) {
		this.stayers = stayers;
	}
	/**
	 * @return the adultStayers
	 */
	public List<EnrollmentModel> getAdultStayers() {
		return adultStayers;
	}
	/**
	 * @param adultStayers the adultStayers to set
	 */
	public void setAdultStayers(List<EnrollmentModel> adultStayers) {
		this.adultStayers = adultStayers;
	}
	/**
	 * @return the adultLeavers
	 */
	public List<EnrollmentModel> getAdultLeavers() {
		return adultLeavers;
	}
	/**
	 * @param adultLeavers the adultLeavers to set
	 */
	public void setAdultLeavers(List<EnrollmentModel> adultLeavers) {
		this.adultLeavers = adultLeavers;
	}
	
	/**
	 * @return the leavers
	 */
	public List<EnrollmentModel> getLeavers() {
		return leavers;
	}
	/**
	 * @param leavers the leavers to set
	 */
	public void setLeavers(List<EnrollmentModel> leavers) {
		this.leavers = leavers;
	}
	/**
	 * @return the activeClients
	 */
	public List<EnrollmentModel> getActiveClients() {
		return activeClients;
	}
	/**
	 * @param activeClients the activeClients to set
	 */
	public void setActiveClients(List<EnrollmentModel> activeClients) {
		this.activeClients = activeClients;
	}
	/**
	 * @return the numOfAdultStayersNotRequiredAnnualAssesment
	 */
	public BigInteger getNumOfAdultStayersNotRequiredAnnualAssesment() {
		return numOfAdultStayersNotRequiredAnnualAssesment;
	}
	/**
	 * @param numOfAdultStayersNotRequiredAnnualAssesment the numOfAdultStayersNotRequiredAnnualAssesment to set
	 */
	public void setNumOfAdultStayersNotRequiredAnnualAssesment(BigInteger numOfAdultStayersNotRequiredAnnualAssesment) {
		this.numOfAdultStayersNotRequiredAnnualAssesment = numOfAdultStayersNotRequiredAnnualAssesment;
	}
	/**
	 * @return the numOfAdultStayersWithoutRequiredAnnualAssesment
	 */
	public BigInteger getNumOfAdultStayersWithoutRequiredAnnualAssesment() {
		return numOfAdultStayersWithoutRequiredAnnualAssesment;
	}
	/**
	 * @param numOfAdultStayersWithoutRequiredAnnualAssesment the numOfAdultStayersWithoutRequiredAnnualAssesment to set
	 */
	public void setNumOfAdultStayersWithoutRequiredAnnualAssesment(
			BigInteger numOfAdultStayersWithoutRequiredAnnualAssesment) {
		this.numOfAdultStayersWithoutRequiredAnnualAssesment = numOfAdultStayersWithoutRequiredAnnualAssesment;
	}
	/**
	 * @return the stayersLengthofStay
	 */
	public List<Q22BeanModel> getStayersLengthofStay() {
		return stayersLengthofStay;
	}
	/**
	 * @param stayersLengthofStay the stayersLengthofStay to set
	 */
	public void setStayersLengthofStay(List<Q22BeanModel> stayersLengthofStay) {
		this.stayersLengthofStay = stayersLengthofStay;
	}
	/**
	 * @return the leaversLengthofStay
	 */
	public List<Q22BeanModel> getLeaversLengthofStay() {
		return leaversLengthofStay;
	}
	/**
	 * @param leaversLengthofStay the leaversLengthofStay to set
	 */
	public void setLeaversLengthofStay(List<Q22BeanModel> leaversLengthofStay) {
		this.leaversLengthofStay = leaversLengthofStay;
	}
	/**
	 * @return the allDataLenghtofStay
	 */
	public List<Q22BeanModel> getAllDataLenghtofStay() {
		return allDataLenghtofStay;
	}
	/**
	 * @param allDataLenghtofStay the allDataLenghtofStay to set
	 */
	public void setAllDataLenghtofStay(List<Q22BeanModel> allDataLenghtofStay) {
		this.allDataLenghtofStay = allDataLenghtofStay;
	}
	/**
	 * @return the veterans
	 */
	public List<ClientModel> getVeterans() {
		return veterans;
	}
	/**
	 * @param veterans the veterans to set
	 */
	public void setVeterans(List<ClientModel> veterans) {
		this.veterans = veterans;
	}
	/**
	 * @return the chronicHomeLess
	 */
	public List<EnrollmentModel> getChronicHomeLess() {
		return chronicHomeLess;
	}
	/**
	 * @param chronicHomeLess the chronicHomeLess to set
	 */
	public void setChronicHomeLess(List<EnrollmentModel> chronicHomeLess) {
		this.chronicHomeLess = chronicHomeLess;
	}
	/**
	 * @return the adultHoh
	 */
	public List<EnrollmentModel> getAdultHoh() {
		return adultHoh;
	}
	/**
	 * @param adultHoh the adultHoh to set
	 */
	public void setAdultHoh(List<EnrollmentModel> adultHoh) {
		this.adultHoh = adultHoh;
	}
	/**
	 * @return the adultStayersHoh365Days
	 */
	public List<EnrollmentModel> getAdultStayersHoh365Days() {
		return adultStayersHoh365Days;
	}
	/**
	 * @param adultStayersHoh365Days the adultStayersHoh365Days to set
	 */
	public void setAdultStayersHoh365Days(List<EnrollmentModel> adultStayersHoh365Days) {
		this.adultStayersHoh365Days = adultStayersHoh365Days;
	}
	/**
	 * @return the incomeAndSourcesAtEntry
	 */
	public List<IncomeAndSourceModel> getIncomeAndSourcesAtEntry() {
		return incomeAndSourcesAtEntry;
	}
	/**
	 * @param incomeAndSourcesAtEntry the incomeAndSourcesAtEntry to set
	 */
	public void setIncomeAndSourcesAtEntry(List<IncomeAndSourceModel> incomeAndSourcesAtEntry) {
		this.incomeAndSourcesAtEntry = incomeAndSourcesAtEntry;
	}
	/**
	 * @return the incomeAndSourcesAtExit
	 */
	public List<IncomeAndSourceModel> getIncomeAndSourcesAtExit() {
		return incomeAndSourcesAtExit;
	}
	/**
	 * @param incomeAndSourcesAtExit the incomeAndSourcesAtExit to set
	 */
	public void setIncomeAndSourcesAtExit(List<IncomeAndSourceModel> incomeAndSourcesAtExit) {
		this.incomeAndSourcesAtExit = incomeAndSourcesAtExit;
	}
	/**
	 * @return the incomeAndSourcesAtAnnualAssesment
	 */
	public List<IncomeAndSourceModel> getIncomeAndSourcesAtAnnualAssesment() {
		return incomeAndSourcesAtAnnualAssesment;
	}
	/**
	 * @param incomeAndSourcesAtAnnualAssesment the incomeAndSourcesAtAnnualAssesment to set
	 */
	public void setIncomeAndSourcesAtAnnualAssesment(List<IncomeAndSourceModel> incomeAndSourcesAtAnnualAssesment) {
		this.incomeAndSourcesAtAnnualAssesment = incomeAndSourcesAtAnnualAssesment;
	}
	/**
	 * @return the requireAA
	 */
	public List<EnrollmentModel> getRequireAA() {
		return requireAA;
	}
	/**
	 * @param requireAA the requireAA to set
	 */
	public void setRequireAA(List<EnrollmentModel> requireAA) {
		this.requireAA = requireAA;
	}
	/**
	 * @return the notrequireAA
	 */
	public List<EnrollmentModel> getNotrequireAA() {
		return notrequireAA;
	}
	/**
	 * @param notrequireAA the notrequireAA to set
	 */
	public void setNotrequireAA(List<EnrollmentModel> notrequireAA) {
		this.notrequireAA = notrequireAA;
	}
	/**
	 * @return the veteranAtExit
	 */
	public Set<String> getVeteranAtExit() {
		return veteranAtExit;
	}
	/**
	 * @param veteranAtExit the veteranAtExit to set
	 */
	public void setVeteranAtExit(Set<String> veteranAtExit) {
		this.veteranAtExit = veteranAtExit;
	}
	/**
	 * @return the pshRrhTotal
	 */
	public List<String> getPshRrhTotal() {
		return pshRrhTotal;
	}
	/**
	 * @param pshRrhTotal the pshRrhTotal to set
	 */
	public void setPshRrhTotal(List<String> pshRrhTotal) {
		this.pshRrhTotal = pshRrhTotal;
	}
	/**
	 * @return the pshRrhWithOutChildren
	 */
	public List<EnrollmentModel> getPshRrhWithOutChildren() {
		return pshRrhWithOutChildren;
	}
	/**
	 * @param pshRrhWithOutChildren the pshRrhWithOutChildren to set
	 */
	public void setPshRrhWithOutChildren(List<EnrollmentModel> pshRrhWithOutChildren) {
		this.pshRrhWithOutChildren = pshRrhWithOutChildren;
	}
	/**
	 * @return the pshRrhWithChildAndAdults
	 */
	public List<EnrollmentModel> getPshRrhWithChildAndAdults() {
		return pshRrhWithChildAndAdults;
	}
	/**
	 * @param pshRrhWithChildAndAdults the pshRrhWithChildAndAdults to set
	 */
	public void setPshRrhWithChildAndAdults(List<EnrollmentModel> pshRrhWithChildAndAdults) {
		this.pshRrhWithChildAndAdults = pshRrhWithChildAndAdults;
	}
	/**
	 * @return the pshRrhWithOnlychildren
	 */
	public List<EnrollmentModel> getPshRrhWithOnlychildren() {
		return pshRrhWithOnlychildren;
	}
	/**
	 * @param pshRrhWithOnlychildren the pshRrhWithOnlychildren to set
	 */
	public void setPshRrhWithOnlychildren(List<EnrollmentModel> pshRrhWithOnlychildren) {
		this.pshRrhWithOnlychildren = pshRrhWithOnlychildren;
	}
	/**
	 * @return the pshRrhUnknownHousehold
	 */
	public List<EnrollmentModel> getPshRrhUnknownHousehold() {
		return pshRrhUnknownHousehold;
	}
	/**
	 * @param pshRrhUnknownHousehold the pshRrhUnknownHousehold to set
	 */
	public void setPshRrhUnknownHousehold(List<EnrollmentModel> pshRrhUnknownHousehold) {
		this.pshRrhUnknownHousehold = pshRrhUnknownHousehold;
	}
	/**
	 * @return the adultWithChildren
	 */
	public List<EnrollmentModel> getAdultWithChildren() {
		return adultWithChildren;
	}
	/**
	 * @param adultWithChildren the adultWithChildren to set
	 */
	public void setAdultWithChildren(List<EnrollmentModel> adultWithChildren) {
		this.adultWithChildren = adultWithChildren;
	}
	/**
	 * @return the adultsWithOneAdultChild
	 */
	public List<EnrollmentModel> getAdultsWithOneAdultChild() {
		return adultsWithOneAdultChild;
	}
	/**
	 * @param adultsWithOneAdultChild the adultsWithOneAdultChild to set
	 */
	public void setAdultsWithOneAdultChild(List<EnrollmentModel> adultsWithOneAdultChild) {
		this.adultsWithOneAdultChild = adultsWithOneAdultChild;
	}
	/**
	 * @return the adultsWithOutChildren
	 */
	public List<EnrollmentModel> getAdultsWithOutChildren() {
		return adultsWithOutChildren;
	}
	/**
	 * @param adultsWithOutChildren the adultsWithOutChildren to set
	 */
	public void setAdultsWithOutChildren(List<EnrollmentModel> adultsWithOutChildren) {
		this.adultsWithOutChildren = adultsWithOutChildren;
	}
	/**
	 * @return the adultsUnknownHHType
	 */
	public List<EnrollmentModel> getAdultsUnknownHHType() {
		return adultsUnknownHHType;
	}
	/**
	 * @param adultsUnknownHHType the adultsUnknownHHType to set
	 */
	public void setAdultsUnknownHHType(List<EnrollmentModel> adultsUnknownHHType) {
		this.adultsUnknownHHType = adultsUnknownHHType;
	}
	/**
	 * @return the youthList
	 */
	public List<String> getYouthList() {
		return youthList;
	}
	/**
	 * @param youthList the youthList to set
	 */
	public void setYouthList(List<String> youthList) {
		this.youthList = youthList;
	}
}
