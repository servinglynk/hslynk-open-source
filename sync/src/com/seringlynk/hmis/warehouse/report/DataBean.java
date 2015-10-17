package com.seringlynk.hmis.warehouse.report;

import java.math.BigInteger;
import java.sql.Timestamp;


public class DataBean {

	private String startDate;
	private String endDate;
	private String projects;
	private String homeLess;
	private String grants;
	private String view;
	private Timestamp crtdUpdtdDate;
	private Boolean delFlag;
	private BigInteger hmisProjectIdService;
	private BigInteger hmisProjectType;
	private BigInteger identityProjectId;
	private BigInteger methodOfTracking;
	private String orgId;
	private String orgName;
	private BigInteger projectId;
	private String projectName;
	
	private BigInteger clientlocationForPe;
	private BigInteger destination;
	private BigInteger disablingCond;
	private BigInteger dob;
	private BigInteger ethnicity;
	private BigInteger firstName;
	private BigInteger gender;
	private BigInteger lastName;
	private BigInteger ltsInEs;
	private BigInteger mdClientlocationForPe;
	private BigInteger mdDestination;
	private BigInteger mdDisablingCond;
	private BigInteger mdDob;
	private BigInteger mdEthnicity;
	private BigInteger mdFirstName;
	private BigInteger mdGender;
	private BigInteger mdLastName;
	private BigInteger mdLtsInEsSh;
	private BigInteger mdRace;
	private BigInteger mdRelationshipToHh;
	private BigInteger mdSsn;
	private BigInteger mdVeteranStatus;
	private BigInteger mdresidencepriortoentry;
	private BigInteger race;
	private BigInteger relationshiptToHh;
	private BigInteger residencePriorToEntry;
	private BigInteger ssn;
	private BigInteger veteranStatus;
	
	private String totNumOfPersonServed;
	private String numOfAdults;
	private String numOfChildren;
	private String numOfPersonsWithUnknownAge;
	private String totNoOfLeavers;
	private String totNoOfAdultLeavers;
	private String noOfVeterans;
	private String noOfChronicallyHomelessPersons;
	private String noOfAdultHeadsOfHousehold;
	private String noOfChildHeadsOfHousehold;
	private String numOfUnaccompaniedYouthUnderAge25;
	private String numOfParentingYouthUnderAge25WithChildren;
	private String totNoOfStayers;
	private String totNoOfAdultStayers;
	
	private BigInteger countAprUht;
	private BigInteger countAprWc;
	public String getTotNumOfPersonServed() {
		return totNumOfPersonServed;
	}
	public void setTotNumOfPersonServed(String totNumOfPersonServed) {
		this.totNumOfPersonServed = totNumOfPersonServed;
	}
	private BigInteger countAprWca;
	private BigInteger countAprWoc;
	private BigInteger countJanUht;
	private BigInteger countJanWc;
	private BigInteger countJanWca;
	private BigInteger countJanWoc;
	private BigInteger countJulUht;
	private BigInteger countJulWc;
	private BigInteger countJulWca;
	private BigInteger countJulWoc;
	private BigInteger countOctUht;
	private BigInteger countOctWc;
	private BigInteger countOctWca;
	private BigInteger countOctWoc;
	private BigInteger npAdultsTot;
	private BigInteger npAdultsUhtTot;
	private BigInteger npAdultsWcTot;
	private BigInteger npAdultsWcaTot;
	private BigInteger npAdultsWocTot;
	private BigInteger npChildTot;
	private BigInteger npChildUhtTot;
	private BigInteger npChildWcTot;
	private BigInteger npChildWcaTot;
	private BigInteger npChildWocTot;
	private BigInteger npDkrTot;
	private BigInteger npDkrUhtTot;
	private BigInteger npDkrWcTot;
	private BigInteger npDkrWcsTot;
	private BigInteger npDkrWocTot;
	private BigInteger npMiTot;
	private BigInteger npMiUhtTot;
	private BigInteger npMiWcTot;
	private BigInteger npMiWcaTot;
	private BigInteger npMiWocTot;
	private BigInteger npTotSum;
	private BigInteger npWcSum;
	private BigInteger npWCASum;
	private BigInteger npWOCSum;
	private BigInteger npUHTSum;
	private BigInteger countJanTotal;
	private BigInteger countAprTotal;
	private BigInteger countJulTotal;
	private BigInteger countOctTotal;
	private BigInteger npTotalAdults;
	private BigInteger npTotalChildren;
	private BigInteger npTotalDKR;
	private BigInteger npTotalMI;
	private BigInteger npOverallTotal;
	private BigInteger npTotalWC;
	private BigInteger npWCATotal;
	private BigInteger npWOCTotal;
	private BigInteger npUHTTotal;
	private BigInteger janTotal;
	private BigInteger aprTotal;
	private BigInteger julyTotal;
	private BigInteger octTotal;
	
	public BigInteger getNpTotalDKR() {
		return npTotalDKR;
	}
	public void setNpTotalDKR(BigInteger npTotalDKR) {
		this.npTotalDKR = npTotalDKR;
	}
	public BigInteger getNpTotalMI() {
		return npTotalMI;
	}
	public void setNpTotalMI(BigInteger npTotalMI) {
		this.npTotalMI = npTotalMI;
	}
	public BigInteger getNpOverallTotal() {
		return npOverallTotal;
	}
	public void setNpOverallTotal(BigInteger npOverallTotal) {
		this.npOverallTotal = npOverallTotal;
	}
	public BigInteger getNpTotalWC() {
		return npTotalWC;
	}
	public void setNpTotalWC(BigInteger npTotalWC) {
		this.npTotalWC = npTotalWC;
	}
	public BigInteger getNpWCATotal() {
		return npWCATotal;
	}
	public void setNpWCATotal(BigInteger npWCATotal) {
		this.npWCATotal = npWCATotal;
	}
	public BigInteger getNpWOCTotal() {
		return npWOCTotal;
	}
	public void setNpWOCTotal(BigInteger npWOCTotal) {
		this.npWOCTotal = npWOCTotal;
	}
	public BigInteger getNpUHTTotal() {
		return npUHTTotal;
	}
	public void setNpUHTTotal(BigInteger npUHTTotal) {
		this.npUHTTotal = npUHTTotal;
	}
	public BigInteger getJanTotal() {
		return janTotal;
	}
	public void setJanTotal(BigInteger janTotal) {
		this.janTotal = janTotal;
	}
	public BigInteger getAprTotal() {
		return aprTotal;
	}
	public void setAprTotal(BigInteger aprTotal) {
		this.aprTotal = aprTotal;
	}
	public BigInteger getJulyTotal() {
		return julyTotal;
	}
	public void setJulyTotal(BigInteger julyTotal) {
		this.julyTotal = julyTotal;
	}
	public BigInteger getOctTotal() {
		return octTotal;
	}
	public void setOctTotal(BigInteger octTotal) {
		this.octTotal = octTotal;
	}
	public BigInteger getNpTotalAdults() {
		return npTotalAdults;
	}
	public void setNpTotalAdults(BigInteger npTotalAdults) {
		this.npTotalAdults = npTotalAdults;
	}
	public BigInteger getNpTotalChildren() {
		return npTotalChildren;
	}
	public void setNpTotalChildren(BigInteger npTotalChildren) {
		this.npTotalChildren = npTotalChildren;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getProjects() {
		return projects;
	}
	public void setProjects(String projects) {
		this.projects = projects;
	}
	public String getHomeLess() {
		return homeLess;
	}
	public void setHomeLess(String homeLess) {
		this.homeLess = homeLess;
	}
	public String getGrants() {
		return grants;
	}
	public void setGrants(String grants) {
		this.grants = grants;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public Timestamp getCrtdUpdtdDate() {
		return crtdUpdtdDate;
	}
	public void setCrtdUpdtdDate(Timestamp crtdUpdtdDate) {
		this.crtdUpdtdDate = crtdUpdtdDate;
	}
	public Boolean getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
	public BigInteger getHmisProjectIdService() {
		return hmisProjectIdService;
	}
	public void setHmisProjectIdService(BigInteger hmisProjectIdService) {
		this.hmisProjectIdService = hmisProjectIdService;
	}
	public BigInteger getHmisProjectType() {
		return hmisProjectType;
	}
	public void setHmisProjectType(BigInteger hmisProjectType) {
		this.hmisProjectType = hmisProjectType;
	}
	public BigInteger getIdentityProjectId() {
		return identityProjectId;
	}
	public void setIdentityProjectId(BigInteger identityProjectId) {
		this.identityProjectId = identityProjectId;
	}
	public BigInteger getMethodOfTracking() {
		return methodOfTracking;
	}
	public void setMethodOfTracking(BigInteger methodOfTracking) {
		this.methodOfTracking = methodOfTracking;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public BigInteger getProjectId() {
		return projectId;
	}
	public void setProjectId(BigInteger projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public BigInteger getClientlocationForPe() {
		return clientlocationForPe;
	}
	public void setClientlocationForPe(BigInteger clientlocationForPe) {
		this.clientlocationForPe = clientlocationForPe;
	}
	public BigInteger getDestination() {
		return destination;
	}
	public void setDestination(BigInteger destination) {
		this.destination = destination;
	}
	public BigInteger getDisablingCond() {
		return disablingCond;
	}
	public void setDisablingCond(BigInteger disablingCond) {
		this.disablingCond = disablingCond;
	}
	public BigInteger getDob() {
		return dob;
	}
	public void setDob(BigInteger dob) {
		this.dob = dob;
	}
	public BigInteger getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(BigInteger ethnicity) {
		this.ethnicity = ethnicity;
	}
	public BigInteger getFirstName() {
		return firstName;
	}
	public void setFirstName(BigInteger firstName) {
		this.firstName = firstName;
	}
	public BigInteger getGender() {
		return gender;
	}
	public void setGender(BigInteger gender) {
		this.gender = gender;
	}
	public BigInteger getLastName() {
		return lastName;
	}
	public void setLastName(BigInteger lastName) {
		this.lastName = lastName;
	}
	public BigInteger getLtsInEs() {
		return ltsInEs;
	}
	public void setLtsInEs(BigInteger ltsInEs) {
		this.ltsInEs = ltsInEs;
	}
	public BigInteger getMdClientlocationForPe() {
		return mdClientlocationForPe;
	}
	public void setMdClientlocationForPe(BigInteger mdClientlocationForPe) {
		this.mdClientlocationForPe = mdClientlocationForPe;
	}
	public BigInteger getMdDestination() {
		return mdDestination;
	}
	public void setMdDestination(BigInteger mdDestination) {
		this.mdDestination = mdDestination;
	}
	public BigInteger getMdDisablingCond() {
		return mdDisablingCond;
	}
	public void setMdDisablingCond(BigInteger mdDisablingCond) {
		this.mdDisablingCond = mdDisablingCond;
	}
	public BigInteger getMdDob() {
		return mdDob;
	}
	public void setMdDob(BigInteger mdDob) {
		this.mdDob = mdDob;
	}
	public BigInteger getMdEthnicity() {
		return mdEthnicity;
	}
	public void setMdEthnicity(BigInteger mdEthnicity) {
		this.mdEthnicity = mdEthnicity;
	}
	public BigInteger getMdFirstName() {
		return mdFirstName;
	}
	public void setMdFirstName(BigInteger mdFirstName) {
		this.mdFirstName = mdFirstName;
	}
	public BigInteger getMdGender() {
		return mdGender;
	}
	public void setMdGender(BigInteger mdGender) {
		this.mdGender = mdGender;
	}
	public BigInteger getMdLastName() {
		return mdLastName;
	}
	public void setMdLastName(BigInteger mdLastName) {
		this.mdLastName = mdLastName;
	}
	public BigInteger getMdLtsInEsSh() {
		return mdLtsInEsSh;
	}
	public void setMdLtsInEsSh(BigInteger mdLtsInEsSh) {
		this.mdLtsInEsSh = mdLtsInEsSh;
	}
	public BigInteger getMdRace() {
		return mdRace;
	}
	public void setMdRace(BigInteger mdRace) {
		this.mdRace = mdRace;
	}
	public BigInteger getMdRelationshipToHh() {
		return mdRelationshipToHh;
	}
	public void setMdRelationshipToHh(BigInteger mdRelationshipToHh) {
		this.mdRelationshipToHh = mdRelationshipToHh;
	}
	public BigInteger getMdSsn() {
		return mdSsn;
	}
	public void setMdSsn(BigInteger mdSsn) {
		this.mdSsn = mdSsn;
	}
	public BigInteger getMdVeteranStatus() {
		return mdVeteranStatus;
	}
	public void setMdVeteranStatus(BigInteger mdVeteranStatus) {
		this.mdVeteranStatus = mdVeteranStatus;
	}
	public BigInteger getMdresidencepriortoentry() {
		return mdresidencepriortoentry;
	}
	public void setMdresidencepriortoentry(BigInteger mdresidencepriortoentry) {
		this.mdresidencepriortoentry = mdresidencepriortoentry;
	}
	public BigInteger getRace() {
		return race;
	}
	public void setRace(BigInteger race) {
		this.race = race;
	}
	public BigInteger getRelationshiptToHh() {
		return relationshiptToHh;
	}
	public void setRelationshiptToHh(BigInteger relationshiptToHh) {
		this.relationshiptToHh = relationshiptToHh;
	}
	public BigInteger getResidencePriorToEntry() {
		return residencePriorToEntry;
	}
	public void setResidencePriorToEntry(BigInteger residencePriorToEntry) {
		this.residencePriorToEntry = residencePriorToEntry;
	}
	public BigInteger getSsn() {
		return ssn;
	}
	public void setSsn(BigInteger ssn) {
		this.ssn = ssn;
	}
	public BigInteger getVeteranStatus() {
		return veteranStatus;
	}
	public void setVeteranStatus(BigInteger veteranStatus) {
		this.veteranStatus = veteranStatus;
	}
	public BigInteger getCountAprUht() {
		return countAprUht;
	}
	public void setCountAprUht(BigInteger countAprUht) {
		this.countAprUht = countAprUht;
	}
	

	public String getNumOfAdults() {
		return numOfAdults;
	}
	public void setNumOfAdults(String numOfAdults) {
		this.numOfAdults = numOfAdults;
	}
	public String getNumOfChildren() {
		return numOfChildren;
	}
	public void setNumOfChildren(String numOfChildren) {
		this.numOfChildren = numOfChildren;
	}
	public String getTotNoOfLeavers() {
		return totNoOfLeavers;
	}
	public void setTotNoOfLeavers(String totNoOfLeavers) {
		this.totNoOfLeavers = totNoOfLeavers;
	}
	public String getTotNoOfAdultLeavers() {
		return totNoOfAdultLeavers;
	}
	public void setTotNoOfAdultLeavers(String totNoOfAdultLeavers) {
		this.totNoOfAdultLeavers = totNoOfAdultLeavers;
	}
	public String getNoOfVeterans() {
		return noOfVeterans;
	}
	public void setNoOfVeterans(String noOfVeterans) {
		this.noOfVeterans = noOfVeterans;
	}
	public String getNoOfChronicallyHomelessPersons() {
		return noOfChronicallyHomelessPersons;
	}
	public void setNoOfChronicallyHomelessPersons(
			String noOfChronicallyHomelessPersons) {
		this.noOfChronicallyHomelessPersons = noOfChronicallyHomelessPersons;
	}
	public String getNoOfAdultHeadsOfHousehold() {
		return noOfAdultHeadsOfHousehold;
	}
	public void setNoOfAdultHeadsOfHousehold(String noOfAdultHeadsOfHousehold) {
		this.noOfAdultHeadsOfHousehold = noOfAdultHeadsOfHousehold;
	}
	public String getNoOfChildHeadsOfHousehold() {
		return noOfChildHeadsOfHousehold;
	}
	public void setNoOfChildHeadsOfHousehold(String noOfChildHeadsOfHousehold) {
		this.noOfChildHeadsOfHousehold = noOfChildHeadsOfHousehold;
	}
	public String getNumOfUnaccompaniedYouthUnderAge25() {
		return numOfUnaccompaniedYouthUnderAge25;
	}
	public void setNumOfUnaccompaniedYouthUnderAge25(
			String numOfUnaccompaniedYouthUnderAge25) {
		this.numOfUnaccompaniedYouthUnderAge25 = numOfUnaccompaniedYouthUnderAge25;
	}
	public String getNumOfParentingYouthUnderAge25WithChildren() {
		return numOfParentingYouthUnderAge25WithChildren;
	}
	public void setNumOfParentingYouthUnderAge25WithChildren(
			String numOfParentingYouthUnderAge25WithChildren) {
		this.numOfParentingYouthUnderAge25WithChildren = numOfParentingYouthUnderAge25WithChildren;
	}
	
	public String getNumOfPersonsWithUnknownAge() {
		return numOfPersonsWithUnknownAge;
	}
	public void setNumOfPersonsWithUnknownAge(String numOfPersonsWithUnknownAge) {
		this.numOfPersonsWithUnknownAge = numOfPersonsWithUnknownAge;
	}
	public String getTotNoOfStayers() {
		return totNoOfStayers;
	}
	public void setTotNoOfStayers(String totNoOfStayers) {
		this.totNoOfStayers = totNoOfStayers;
	}
	public String getTotNoOfAdultStayers() {
		return totNoOfAdultStayers;
	}
	public void setTotNoOfAdultStayers(String totNoOfAdultStayers) {
		this.totNoOfAdultStayers = totNoOfAdultStayers;
	}
	public BigInteger getCountAprWc() {
		return countAprWc;
	}
	public void setCountAprWc(BigInteger countAprWc) {
		this.countAprWc = countAprWc;
	}
	public BigInteger getCountAprWca() {
		return countAprWca;
	}
	public void setCountAprWca(BigInteger countAprWca) {
		this.countAprWca = countAprWca;
	}
	public BigInteger getCountAprWoc() {
		return countAprWoc;
	}
	public void setCountAprWoc(BigInteger countAprWoc) {
		this.countAprWoc = countAprWoc;
	}
	public BigInteger getCountJanUht() {
		return countJanUht;
	}
	public void setCountJanUht(BigInteger countJanUht) {
		this.countJanUht = countJanUht;
	}
	public BigInteger getCountJanWc() {
		return countJanWc;
	}
	public void setCountJanWc(BigInteger countJanWc) {
		this.countJanWc = countJanWc;
	}
	public BigInteger getCountJanWca() {
		return countJanWca;
	}
	public void setCountJanWca(BigInteger countJanWca) {
		this.countJanWca = countJanWca;
	}
	public BigInteger getCountJanWoc() {
		return countJanWoc;
	}
	public void setCountJanWoc(BigInteger countJanWoc) {
		this.countJanWoc = countJanWoc;
	}
	public BigInteger getCountJulUht() {
		return countJulUht;
	}
	public void setCountJulUht(BigInteger countJulUht) {
		this.countJulUht = countJulUht;
	}
	public BigInteger getCountJulWc() {
		return countJulWc;
	}
	public void setCountJulWc(BigInteger countJulWc) {
		this.countJulWc = countJulWc;
	}
	public BigInteger getCountJulWca() {
		return countJulWca;
	}
	public void setCountJulWca(BigInteger countJulWca) {
		this.countJulWca = countJulWca;
	}
	public BigInteger getCountJulWoc() {
		return countJulWoc;
	}
	public void setCountJulWoc(BigInteger countJulWoc) {
		this.countJulWoc = countJulWoc;
	}
	public BigInteger getCountOctUht() {
		return countOctUht;
	}
	public void setCountOctUht(BigInteger countOctUht) {
		this.countOctUht = countOctUht;
	}
	public BigInteger getCountOctWc() {
		return countOctWc;
	}
	public void setCountOctWc(BigInteger countOctWc) {
		this.countOctWc = countOctWc;
	}
	public BigInteger getCountOctWca() {
		return countOctWca;
	}
	public void setCountOctWca(BigInteger countOctWca) {
		this.countOctWca = countOctWca;
	}
	public BigInteger getCountOctWoc() {
		return countOctWoc;
	}
	public void setCountOctWoc(BigInteger countOctWoc) {
		this.countOctWoc = countOctWoc;
	}
	public BigInteger getNpAdultsTot() {
		return npAdultsTot;
	}
	public void setNpAdultsTot(BigInteger npAdultsTot) {
		this.npAdultsTot = npAdultsTot;
	}
	public BigInteger getNpAdultsUhtTot() {
		return npAdultsUhtTot;
	}
	public void setNpAdultsUhtTot(BigInteger npAdultsUhtTot) {
		this.npAdultsUhtTot = npAdultsUhtTot;
	}
	public BigInteger getNpAdultsWcTot() {
		return npAdultsWcTot;
	}
	public void setNpAdultsWcTot(BigInteger npAdultsWcTot) {
		this.npAdultsWcTot = npAdultsWcTot;
	}
	public BigInteger getNpAdultsWcaTot() {
		return npAdultsWcaTot;
	}
	public void setNpAdultsWcaTot(BigInteger npAdultsWcaTot) {
		this.npAdultsWcaTot = npAdultsWcaTot;
	}
	public BigInteger getNpAdultsWocTot() {
		return npAdultsWocTot;
	}
	public void setNpAdultsWocTot(BigInteger npAdultsWocTot) {
		this.npAdultsWocTot = npAdultsWocTot;
	}
	public BigInteger getNpChildTot() {
		return npChildTot;
	}
	public void setNpChildTot(BigInteger npChildTot) {
		this.npChildTot = npChildTot;
	}
	public BigInteger getNpChildUhtTot() {
		return npChildUhtTot;
	}
	public void setNpChildUhtTot(BigInteger npChildUhtTot) {
		this.npChildUhtTot = npChildUhtTot;
	}
	public BigInteger getNpChildWcTot() {
		return npChildWcTot;
	}
	public void setNpChildWcTot(BigInteger npChildWcTot) {
		this.npChildWcTot = npChildWcTot;
	}
	public BigInteger getNpChildWcaTot() {
		return npChildWcaTot;
	}
	public void setNpChildWcaTot(BigInteger npChildWcaTot) {
		this.npChildWcaTot = npChildWcaTot;
	}
	public BigInteger getNpChildWocTot() {
		return npChildWocTot;
	}
	public void setNpChildWocTot(BigInteger npChildWocTot) {
		this.npChildWocTot = npChildWocTot;
	}
	public BigInteger getNpDkrTot() {
		return npDkrTot;
	}
	public void setNpDkrTot(BigInteger npDkrTot) {
		this.npDkrTot = npDkrTot;
	}
	public BigInteger getNpDkrUhtTot() {
		return npDkrUhtTot;
	}
	public void setNpDkrUhtTot(BigInteger npDkrUhtTot) {
		this.npDkrUhtTot = npDkrUhtTot;
	}
	public BigInteger getNpDkrWcTot() {
		return npDkrWcTot;
	}
	public void setNpDkrWcTot(BigInteger npDkrWcTot) {
		this.npDkrWcTot = npDkrWcTot;
	}
	public BigInteger getNpDkrWcsTot() {
		return npDkrWcsTot;
	}
	public void setNpDkrWcsTot(BigInteger npDkrWcsTot) {
		this.npDkrWcsTot = npDkrWcsTot;
	}
	public BigInteger getNpDkrWocTot() {
		return npDkrWocTot;
	}
	public void setNpDkrWocTot(BigInteger npDkrWocTot) {
		this.npDkrWocTot = npDkrWocTot;
	}
	public BigInteger getNpMiTot() {
		return npMiTot;
	}
	public void setNpMiTot(BigInteger npMiTot) {
		this.npMiTot = npMiTot;
	}
	public BigInteger getNpMiUhtTot() {
		return npMiUhtTot;
	}
	public void setNpMiUhtTot(BigInteger npMiUhtTot) {
		this.npMiUhtTot = npMiUhtTot;
	}
	public BigInteger getNpMiWcTot() {
		return npMiWcTot;
	}
	public void setNpMiWcTot(BigInteger npMiWcTot) {
		this.npMiWcTot = npMiWcTot;
	}
	public BigInteger getNpMiWcaTot() {
		return npMiWcaTot;
	}
	public void setNpMiWcaTot(BigInteger npMiWcaTot) {
		this.npMiWcaTot = npMiWcaTot;
	}
	public BigInteger getNpMiWocTot() {
		return npMiWocTot;
	}
	public void setNpMiWocTot(BigInteger npMiWocTot) {
		this.npMiWocTot = npMiWocTot;
	}
	public BigInteger getNpTotSum() {
		return npTotSum;
	}
	public void setNpTotSum(BigInteger npTotSum) {
		this.npTotSum = npTotSum;
	}
	public BigInteger getNpWcSum() {
		return npWcSum;
	}
	public void setNpWcSum(BigInteger npWcSum) {
		this.npWcSum = npWcSum;
	}
	public BigInteger getNpWCASum() {
		return npWCASum;
	}
	public void setNpWCASum(BigInteger npWCASum) {
		this.npWCASum = npWCASum;
	}
	public BigInteger getNpWOCSum() {
		return npWOCSum;
	}
	public void setNpWOCSum(BigInteger npWOCSum) {
		this.npWOCSum = npWOCSum;
	}
	public BigInteger getNpUHTSum() {
		return npUHTSum;
	}
	public void setNpUHTSum(BigInteger npUHTSum) {
		this.npUHTSum = npUHTSum;
	}
	
	public BigInteger getCountJanTotal() {
		return countJanTotal;
	}
	public void setCountJanTotal(BigInteger countJanTotal) {
		this.countJanTotal = countJanTotal;
	}
	public BigInteger getCountAprTotal() {
		return countAprTotal;
	}
	public void setCountAprTotal(BigInteger countAprTotal) {
		this.countAprTotal = countAprTotal;
	}
	public BigInteger getCountJulTotal() {
		return countJulTotal;
	}
	public void setCountJulTotal(BigInteger countJulTotal) {
		this.countJulTotal = countJulTotal;
	}
	public BigInteger getCountOctTotal() {
		return countOctTotal;
	}
	public void setCountOctTotal(BigInteger countOctTotal) {
		this.countOctTotal = countOctTotal;
	}
	


	
	
}