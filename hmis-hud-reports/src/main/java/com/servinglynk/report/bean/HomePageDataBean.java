package com.servinglynk.report.bean;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

public class HomePageDataBean {
	
	private String homePageStartDate;
	private String homePageEndDate;
	private String homePageProjects;
	private String homePageHomeLess;
	private String homePageGrants;
	private String homePageView;
	
	private Timestamp crtdUpdtdDate;
	private Boolean delFlag;
	private BigInteger q04aHmisProjectIdService;
	private String q04aHmisProjectType;
	private BigInteger q04aIdentityProjectId;
	private String q04aMethodOfTracking;
	private String q04aOrgId;
	private String q04aOrgName;
	private String q04aProjectId;
	private String q04aProjectName;
	
	private List<Q05aHMISComparableDBDataQualityDataBean> q05aHMISComparableDBDataQualityDataBean;
	private List<Q06aReportValidationsTableDataBean> q06aReportValidationsTableDataBean;
	private List<Q06bNumberOfPersonsServedDataBean> q06bNumberOfPersonsServedDataBean;
	private List<Q06cPointInTimeCountPersonsLastWednesdayDataBean> q06cPointInTimeCountPersonsLastWednesdayDataBean;
	private List<Q07aHouseholdsServedDataBean> q07aHouseholdsServedDataBean;
	private List<Q07bPointInTimeCountHouseholdsLastWednesdayDataBean> q07bPointInTimeCountHouseholdsLastWednesdayDataBean;
	private List<Q09aNumberPersonsContactedDataBean> qQ09aNumberPersonsContactedDataBean;
	private List<Q09bNumberofPersonsEngagedDataBean> q09bNumberofPersonsEngagedDataBean;
	private List<Q10aGenderOfAdultsDataBean> q10aGenderOfAdultsDataBean;
	private List<Q10bGenderOfChildrenDataBean> q10bGenderOfChildrenDataBean;
	private List<Q10cGenderOfPersonsMissingAgeInformationDataBean> q10cGenderOfPersonsMissingAgeInformationDataBean;
	private List<Q11AgeDataBean> q11AgeDataBean;
	private List<Q12aRaceDataBean> q12aRaceDataBean;
	private List<Q12bEthnicityDataBean> q12bEthnicityDataBean;
	private List<Q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean> q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean;
	private List<Q13a2NumberOfConditionsAtEntryDataBean> q13a2NumberOfConditionsAtEntryDataBean;
	private List<Q13b1PhysicalAndMentalHealthConditionsAtExitDataBean> q13b1PhysicalAndMentalHealthConditionsAtExitDataBean;
	private List<Q13b2NumberOfConditionsAtExitDataBean> q13b2NumberOfConditionsAtExitDataBean;
	private List<Q13c1PhysicalAndMentalHealthConditionsForStayersDataBean> q13c1PhysicalAndMentalHealthConditionsForStayersDataBean;
	private List<Q13c2NumberOfConditionsForStayerDataBean> q13c2NumberOfConditionsForStayerDataBean;
	private List<Q14aDomesticViolenceHistoryDataBean> q14aDomesticViolenceHistoryDataBean;
	private List<Q14bPersonsFleeingDomesticViolenceDataBean> q14bPersonsFleeingDomesticViolenceDataBean;
	private List<Q15ResidencePriorToProgramEntryDataBean> q15ResidencePriorToProgramEntryDataBean;
	private List<Q16CashIncomeRangesDataBean> q16CashIncomeRangesDataBean;
	private List<Q17CashIncomeSourcesDataBean> q17CashIncomeSourcesDataBean;
	
	
		
	public List<Q17CashIncomeSourcesDataBean> getQ17CashIncomeSourcesDataBean() {
		return q17CashIncomeSourcesDataBean;
	}
	public void setQ17CashIncomeSourcesDataBean(
			List<Q17CashIncomeSourcesDataBean> q17CashIncomeSourcesDataBean) {
		this.q17CashIncomeSourcesDataBean = q17CashIncomeSourcesDataBean;
	}
	public List<Q16CashIncomeRangesDataBean> getQ16CashIncomeRangesDataBean() {
		return q16CashIncomeRangesDataBean;
	}
	public void setQ16CashIncomeRangesDataBean(
			List<Q16CashIncomeRangesDataBean> q16CashIncomeRangesDataBean) {
		this.q16CashIncomeRangesDataBean = q16CashIncomeRangesDataBean;
	}
	public List<Q15ResidencePriorToProgramEntryDataBean> getQ15ResidencePriorToProgramEntryDataBean() {
		return q15ResidencePriorToProgramEntryDataBean;
	}
	public void setQ15ResidencePriorToProgramEntryDataBean(
			List<Q15ResidencePriorToProgramEntryDataBean> q15ResidencePriorToProgramEntryDataBean) {
		this.q15ResidencePriorToProgramEntryDataBean = q15ResidencePriorToProgramEntryDataBean;
	}
	public List<Q14aDomesticViolenceHistoryDataBean> getQ14aDomesticViolenceHistoryDataBean() {
		return q14aDomesticViolenceHistoryDataBean;
	}
	public void setQ14aDomesticViolenceHistoryDataBean(
			List<Q14aDomesticViolenceHistoryDataBean> q14aDomesticViolenceHistoryDataBean) {
		this.q14aDomesticViolenceHistoryDataBean = q14aDomesticViolenceHistoryDataBean;
	}
	public List<Q14bPersonsFleeingDomesticViolenceDataBean> getQ14bPersonsFleeingDomesticViolenceDataBean() {
		return q14bPersonsFleeingDomesticViolenceDataBean;
	}
	public void setQ14bPersonsFleeingDomesticViolenceDataBean(
			List<Q14bPersonsFleeingDomesticViolenceDataBean> q14bPersonsFleeingDomesticViolenceDataBean) {
		this.q14bPersonsFleeingDomesticViolenceDataBean = q14bPersonsFleeingDomesticViolenceDataBean;
	}
	public List<Q13c1PhysicalAndMentalHealthConditionsForStayersDataBean> getQ13c1PhysicalAndMentalHealthConditionsForStayersDataBean() {
		return q13c1PhysicalAndMentalHealthConditionsForStayersDataBean;
	}
	public void setQ13c1PhysicalAndMentalHealthConditionsForStayersDataBean(
			List<Q13c1PhysicalAndMentalHealthConditionsForStayersDataBean> q13c1PhysicalAndMentalHealthConditionsForStayersDataBean) {
		this.q13c1PhysicalAndMentalHealthConditionsForStayersDataBean = q13c1PhysicalAndMentalHealthConditionsForStayersDataBean;
	}
	public List<Q13c2NumberOfConditionsForStayerDataBean> getQ13c2NumberOfConditionsForStayerDataBean() {
		return q13c2NumberOfConditionsForStayerDataBean;
	}
	public void setQ13c2NumberOfConditionsForStayerDataBean(
			List<Q13c2NumberOfConditionsForStayerDataBean> q13c2NumberOfConditionsForStayerDataBean) {
		this.q13c2NumberOfConditionsForStayerDataBean = q13c2NumberOfConditionsForStayerDataBean;
	}
	public List<Q13b2NumberOfConditionsAtExitDataBean> getQ13b2NumberOfConditionsAtExitDataBean() {
		return q13b2NumberOfConditionsAtExitDataBean;
	}
	public void setQ13b2NumberOfConditionsAtExitDataBean(
			List<Q13b2NumberOfConditionsAtExitDataBean> q13b2NumberOfConditionsAtExitDataBean) {
		this.q13b2NumberOfConditionsAtExitDataBean = q13b2NumberOfConditionsAtExitDataBean;
	}
	public List<Q13b1PhysicalAndMentalHealthConditionsAtExitDataBean> getQ13b1PhysicalAndMentalHealthConditionsAtExitDataBean() {
		return q13b1PhysicalAndMentalHealthConditionsAtExitDataBean;
	}
	public void setQ13b1PhysicalAndMentalHealthConditionsAtExitDataBean(
			List<Q13b1PhysicalAndMentalHealthConditionsAtExitDataBean> q13b1PhysicalAndMentalHealthConditionsAtExitDataBean) {
		this.q13b1PhysicalAndMentalHealthConditionsAtExitDataBean = q13b1PhysicalAndMentalHealthConditionsAtExitDataBean;
	}
	public List<Q13a2NumberOfConditionsAtEntryDataBean> getQ13a2NumberOfConditionsAtEntryDataBean() {
		return q13a2NumberOfConditionsAtEntryDataBean;
	}
	public void setQ13a2NumberOfConditionsAtEntryDataBean(
			List<Q13a2NumberOfConditionsAtEntryDataBean> q13a2NumberOfConditionsAtEntryDataBean) {
		this.q13a2NumberOfConditionsAtEntryDataBean = q13a2NumberOfConditionsAtEntryDataBean;
	}
	public List<Q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean> getQ13a1PhysicalAndMentalHealthConditionsAtEntryDataBean() {
		return q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean;
	}
	public void setQ13a1PhysicalAndMentalHealthConditionsAtEntryDataBean(
			List<Q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean> q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean) {
		this.q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean = q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean;
	}
	public List<Q12bEthnicityDataBean> getQ12bEthnicityDataBean() {
		return q12bEthnicityDataBean;
	}
	public void setQ12bEthnicityDataBean(
			List<Q12bEthnicityDataBean> q12bEthnicityDataBean) {
		this.q12bEthnicityDataBean = q12bEthnicityDataBean;
	}
	public List<Q12aRaceDataBean> getQ12aRaceDataBean() {
		return q12aRaceDataBean;
	}
	public void setQ12aRaceDataBean(List<Q12aRaceDataBean> q12aRaceDataBean) {
		this.q12aRaceDataBean = q12aRaceDataBean;
	}
	public List<Q11AgeDataBean> getQ11AgeDataBean() {
		return q11AgeDataBean;
	}
	public void setQ11AgeDataBean(List<Q11AgeDataBean> q11AgeDataBean) {
		this.q11AgeDataBean = q11AgeDataBean;
	}
	public List<Q10cGenderOfPersonsMissingAgeInformationDataBean> getQ10cGenderOfPersonsMissingAgeInformationDataBean() {
		return q10cGenderOfPersonsMissingAgeInformationDataBean;
	}
	public void setQ10cGenderOfPersonsMissingAgeInformationDataBean(
			List<Q10cGenderOfPersonsMissingAgeInformationDataBean> q10cGenderOfPersonsMissingAgeInformationDataBean) {
		this.q10cGenderOfPersonsMissingAgeInformationDataBean = q10cGenderOfPersonsMissingAgeInformationDataBean;
	}
	public List<Q10bGenderOfChildrenDataBean> getQ10bGenderOfChildrenDataBean() {
		return q10bGenderOfChildrenDataBean;
	}
	public void setQ10bGenderOfChildrenDataBean(
			List<Q10bGenderOfChildrenDataBean> q10bGenderOfChildrenDataBean) {
		this.q10bGenderOfChildrenDataBean = q10bGenderOfChildrenDataBean;
	}
	public List<Q10aGenderOfAdultsDataBean> getQ10aGenderOfAdultsDataBean() {
		return q10aGenderOfAdultsDataBean;
	}
	public void setQ10aGenderOfAdultsDataBean(
			List<Q10aGenderOfAdultsDataBean> q10aGenderOfAdultsDataBean) {
		this.q10aGenderOfAdultsDataBean = q10aGenderOfAdultsDataBean;
	}
	public List<Q09bNumberofPersonsEngagedDataBean> getQ09bNumberofPersonsEngagedDataBean() {
		return q09bNumberofPersonsEngagedDataBean;
	}
	public void setQ09bNumberofPersonsEngagedDataBean(
			List<Q09bNumberofPersonsEngagedDataBean> q09bNumberofPersonsEngagedDataBean) {
		this.q09bNumberofPersonsEngagedDataBean = q09bNumberofPersonsEngagedDataBean;
	}
	public List<Q09aNumberPersonsContactedDataBean> getqQ09aNumberPersonsContactedDataBean() {
		return qQ09aNumberPersonsContactedDataBean;
	}
	public void setqQ09aNumberPersonsContactedDataBean(
			List<Q09aNumberPersonsContactedDataBean> qQ09aNumberPersonsContactedDataBean) {
		this.qQ09aNumberPersonsContactedDataBean = qQ09aNumberPersonsContactedDataBean;
	}
	public List<Q07bPointInTimeCountHouseholdsLastWednesdayDataBean> getQ07bPointInTimeCountHouseholdsLastWednesdayDataBean() {
		return q07bPointInTimeCountHouseholdsLastWednesdayDataBean;
	}
	public void setQ07bPointInTimeCountHouseholdsLastWednesdayDataBean(
			List<Q07bPointInTimeCountHouseholdsLastWednesdayDataBean> q07bPointInTimeCountHouseholdsLastWednesdayDataBean) {
		this.q07bPointInTimeCountHouseholdsLastWednesdayDataBean = q07bPointInTimeCountHouseholdsLastWednesdayDataBean;
	}
	public List<Q07aHouseholdsServedDataBean> getQ07aHouseholdsServedDataBean() {
		return q07aHouseholdsServedDataBean;
	}
	public void setQ07aHouseholdsServedDataBean(
			List<Q07aHouseholdsServedDataBean> q07aHouseholdsServedDataBean) {
		this.q07aHouseholdsServedDataBean = q07aHouseholdsServedDataBean;
	}
	public List<Q06cPointInTimeCountPersonsLastWednesdayDataBean> getQ06cPointInTimeCountPersonsLastWednesdayDataBean() {
		return q06cPointInTimeCountPersonsLastWednesdayDataBean;
	}
	public void setQ06cPointInTimeCountPersonsLastWednesdayDataBean(
			List<Q06cPointInTimeCountPersonsLastWednesdayDataBean> q06cPointInTimeCountPersonsLastWednesdayDataBean) {
		this.q06cPointInTimeCountPersonsLastWednesdayDataBean = q06cPointInTimeCountPersonsLastWednesdayDataBean;
	}
	public List<Q06bNumberOfPersonsServedDataBean> getQ06bNumberOfPersonsServedDataBean() {
		return q06bNumberOfPersonsServedDataBean;
	}
	public void setQ06bNumberOfPersonsServedDataBean(
			List<Q06bNumberOfPersonsServedDataBean> q06bNumberOfPersonsServedDataBean) {
		this.q06bNumberOfPersonsServedDataBean = q06bNumberOfPersonsServedDataBean;
	}
	public List<Q06aReportValidationsTableDataBean> getQ06aReportValidationsTableDataBean() {
		return q06aReportValidationsTableDataBean;
	}
	public void setQ06aReportValidationsTableDataBean(
			List<Q06aReportValidationsTableDataBean> q06aReportValidationsTableDataBean) {
		this.q06aReportValidationsTableDataBean = q06aReportValidationsTableDataBean;
	}
	public List<Q05aHMISComparableDBDataQualityDataBean> getQ05aHMISComparableDBDataQualityDataBean() {
		return q05aHMISComparableDBDataQualityDataBean;
	}
	public void setQ05aHMISComparableDBDataQualityDataBean(
			List<Q05aHMISComparableDBDataQualityDataBean> q05aHMISComparableDBDataQualityDataBean) {
		this.q05aHMISComparableDBDataQualityDataBean = q05aHMISComparableDBDataQualityDataBean;
	}
	
	public String getHomePageStartDate() {
		return homePageStartDate;
	}
	public void setHomePageStartDate(String homePageStartDate) {
		this.homePageStartDate = homePageStartDate;
	}
	public String getHomePageEndDate() {
		return homePageEndDate;
	}
	public void setHomePageEndDate(String homePageEndDate) {
		this.homePageEndDate = homePageEndDate;
	}
	public String getHomePageProjects() {
		return homePageProjects;
	}
	public void setHomePageProjects(String homePageProjects) {
		this.homePageProjects = homePageProjects;
	}
	public String getHomePageHomeLess() {
		return homePageHomeLess;
	}
	public void setHomePageHomeLess(String homePageHomeLess) {
		this.homePageHomeLess = homePageHomeLess;
	}
	public String getHomePageGrants() {
		return homePageGrants;
	}
	public void setHomePageGrants(String homePageGrants) {
		this.homePageGrants = homePageGrants;
	}
	public String getHomePageView() {
		return homePageView;
	}
	public void setHomePageView(String homePageView) {
		this.homePageView = homePageView;
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
	public BigInteger getQ04aHmisProjectIdService() {
		return q04aHmisProjectIdService;
	}
	public void setQ04aHmisProjectIdService(BigInteger q04aHmisProjectIdService) {
		this.q04aHmisProjectIdService = q04aHmisProjectIdService;
	}
	public String getQ04aHmisProjectType() {
		return q04aHmisProjectType;
	}
	public void setQ04aHmisProjectType(String q04aHmisProjectType) {
		this.q04aHmisProjectType = q04aHmisProjectType;
	}
	public BigInteger getQ04aIdentityProjectId() {
		return q04aIdentityProjectId;
	}
	public void setQ04aIdentityProjectId(BigInteger q04aIdentityProjectId) {
		this.q04aIdentityProjectId = q04aIdentityProjectId;
	}
	public String getQ04aMethodOfTracking() {
		return q04aMethodOfTracking;
	}
	public void setQ04aMethodOfTracking(String q04aMethodOfTracking) {
		this.q04aMethodOfTracking = q04aMethodOfTracking;
	}
	public String getQ04aOrgId() {
		return q04aOrgId;
	}
	public void setQ04aOrgId(String q04aOrgId) {
		this.q04aOrgId = q04aOrgId;
	}
	public String getQ04aOrgName() {
		return q04aOrgName;
	}
	public void setQ04aOrgName(String q04aOrgName) {
		this.q04aOrgName = q04aOrgName;
	}
	public String getQ04aProjectId() {
		return q04aProjectId;
	}
	public void setQ04aProjectId(String q04aProjectId) {
		this.q04aProjectId = q04aProjectId;
	}
	public String getQ04aProjectName() {
		return q04aProjectName;
	}
	public void setQ04aProjectName(String q04aProjectName) {
		this.q04aProjectName = q04aProjectName;
	}
}
