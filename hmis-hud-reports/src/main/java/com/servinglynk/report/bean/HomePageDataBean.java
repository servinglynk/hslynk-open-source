package com.servinglynk.report.bean;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
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
	
	private List<Q05aHMISComparableDBDataQualityDataBean> q05aHMISComparableDBDataQualityDataBean = new ArrayList<>();
	private List<Q06aReportValidationsTableDataBean> q06aReportValidationsTableDataBean;
	private List<Q06bNumberOfPersonsServedDataBean> q06bNumberOfPersonsServedDataBean;
	private List<Q06cPointInTimeCountPersonsLastWednesdayDataBean> q06cPointInTimeCountPersonsLastWednesdayDataBean;
	private List<Q06dDataBean> q06dDataBean;
	private List<Q06eDataBean> q06eDataBean;
	private List<Q06fDataBean> q06fDataBean;
	private List<Q07aHouseholdsServedDataBean> q07aHouseholdsServedDataBean;
	private List<Q07bPointInTimeCountHouseholdsLastWednesdayDataBean> q07bPointInTimeCountHouseholdsLastWednesdayDataBean;
	private List<Q08aDataBean> q08aDataBean;
	private List<Q08bDataBean> q08bDataBean;
	private List<Q09aNumberPersonsContactedDataBean> q09aNumberPersonsContactedDataBean;
	private List<Q09bNumberofPersonsEngagedDataBean> q09bNumberofPersonsEngagedDataBean;
	private List<Q10aGenderOfAdultsDataBean> q10aGenderOfAdultsDataBean;
	private List<Q10bGenderOfChildrenDataBean> q10bGenderOfChildrenDataBean;
	private List<Q10cGenderOfPersonsMissingAgeInformationDataBean> q10cGenderOfPersonsMissingAgeInformationDataBean;
	private List<Q10dGenderByAgeRangesDataBean> q10dGenderByAgeRangesDataBean;
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
	private List<Q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean> q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean;
	private List<Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean> q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean;
	private List<Q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean> q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean;
	private List<Q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean> q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean;
	private List<Q20aTypeOfNonCashBenefitSourcesDataBean> q20aTypeOfNonCashBenefitSourcesDataBean;
	private List<Q20bNumberOfNonCashBenefitSourcesDataBean> q20bNumberOfNonCashBenefitSourcesDataBean;
	private List<Q21HealthInsuranceDataBean> q21HealthInsuranceDataBean;
	private List<Q22a1LengthOfParticipationCoCProjectsDataBean> q22a1LengthOfParticipationCoCProjectsDataBean;
	private List<Q22a2LengthOfParticipationESGProjectsDataBean> q22a2LengthOfParticipationESGProjectsDataBean;
	private List<Q22bAverageAndMedianLengthOfParticipationInDaysDataBean> q22bAverageAndMedianLengthOfParticipationInDaysDataBean;
	private List<Q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBean> q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBean;
	private List<Q22dLengthOfParticipationByHouseholdTypeDataBean> q22dLengthOfParticipationByHouseholdTypeDataBean;
	
	private List<Q23aExitDestinationMoreThan90DaysDataBean> q23ExitDestinationMoreThan90DaysDataBean;
	private List<Q23bExitDestination90DaysOrLessDataBean> q23bExitDestination90DaysOrLessDataBean;
	private List<Q23cDataBean> q23cDataBean;
	
	private List<Q24HomelessnessPreventionHousingAssessmentAtExitDataBean> q24HomelessnessPreventionHousingAssessmentAtExitDataBean;
	private List<Q25aNumberOfVeteransDataBean> q25aNumberOfVeteransDataBean;
	private List<Q25bNumberOfVeteranHouseholdsDataBean> q25bNumberOfVeteranHouseholdsDataBean;
	private List<Q25cGenderVeteransDataBean> q25cGenderVeteransDataBean;
	private List<Q25dAgeVeteransDataBean> q25dAgeVeteransDataBean;
	private List<Q25ePhysicalAndMentalHealthConditionsVeteransDataBean> q25ePhysicalAndMentalHealthConditionsVeteransDataBean;
	private List<Q25fCashIncomeCategoryIncomeCategoryByEntryDataBean> q25fCashIncomeCategoryIncomeCategoryByEntryDataBean;
	private List<Q25gTypeOfCashIncomeSourcesVeteransDataBean> q25gTypeOfCashIncomeSourcesVeteransDataBean;
	private List<Q25hTypeOfNonCashIncomeSourcesVeteransDataBean> q25hTypeOfNonCashIncomeSourcesVeteransDataBean;
	private List<Q25iExitDestinationVeteransDataBean> q25iExitDestinationVeteransDataBean;
	private List<Q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean> q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean;
	private List<Q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean> q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean;
	private List<Q26cGenderOfChronicallyHomelessPersonDataBean> q26cGenderOfChronicallyHomelessPersonDataBean;
	private List<Q26dAgeOfChronicallyHomelessPersonsDataBean> q26dAgeOfChronicallyHomelessPersonsDataBean;
	private List<Q26ePhysicalAndMentalHealthConditionsChronicallyDataBean> q26ePhysicalAndMentalHealthConditionsChronicallyDataBean;
	private List<Q26fClientCashIncomeChronicallyHomelessPersonsDataBean> q26fClientCashIncomeChronicallyHomelessPersonsDataBean;
	private List<Q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean> q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean;
	private List<Q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean> q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean;
	private List<Q27aAgeOfYouthDataBean> q27aAgeOfYouthDataBean;
	private List<Q27bParentingYouthDataBean> q27bParentingYouthDataBean;
	private List<Q27cGenderYouthDataBean> q27cGenderYouthDataBean;
	private List<Q27dResidencePriorToEntryYouthDataBean> q27dResidencePriorToEntryYouthDataBean;
	private List<Q27eLengthOfParticipationYouthDataBean> q27eLengthOfParticipationYouthDataBean;
	private List<Q27fExitDestinationYouthDataBean> q27fExitDestinationYouthDataBean;
	private List<Q27gCashIncomeSourcesDataBean> q27gCashIncomeSourcesDataBean;
	private List<Q29aPerformanceMeasuresPermanentHousingProgramsDataBean> q29aPerformanceMeasuresPermanentHousingProgramsDataBean;
	private List<Q29bPerformanceMeasuresTransitionalHousingProgramsDataBean> q29bPerformanceMeasuresTransitionalHousingProgramsDataBean;
	private List<Q29cPerformanceMeasuresStreetOutreachProgramsDataBean> q29cPerformanceMeasuresStreetOutreachProgramsDataBean;
	private List<Q29dPerformanceMeasuresSupportiveServiceOnlyDataBean> q29dPerformanceMeasuresSupportiveServiceOnlyDataBean;
	private List<Q29ePerformanceMeasuresSafeHavensDataBean> q29ePerformanceMeasuresSafeHavensDataBean;
	/**
	 * @return the homePageStartDate
	 */
	public String getHomePageStartDate() {
		return homePageStartDate;
	}
	/**
	 * @param homePageStartDate the homePageStartDate to set
	 */
	public void setHomePageStartDate(String homePageStartDate) {
		this.homePageStartDate = homePageStartDate;
	}
	/**
	 * @return the homePageEndDate
	 */
	public String getHomePageEndDate() {
		return homePageEndDate;
	}
	/**
	 * @param homePageEndDate the homePageEndDate to set
	 */
	public void setHomePageEndDate(String homePageEndDate) {
		this.homePageEndDate = homePageEndDate;
	}
	/**
	 * @return the homePageProjects
	 */
	public String getHomePageProjects() {
		return homePageProjects;
	}
	/**
	 * @param homePageProjects the homePageProjects to set
	 */
	public void setHomePageProjects(String homePageProjects) {
		this.homePageProjects = homePageProjects;
	}
	/**
	 * @return the homePageHomeLess
	 */
	public String getHomePageHomeLess() {
		return homePageHomeLess;
	}
	/**
	 * @param homePageHomeLess the homePageHomeLess to set
	 */
	public void setHomePageHomeLess(String homePageHomeLess) {
		this.homePageHomeLess = homePageHomeLess;
	}
	/**
	 * @return the homePageGrants
	 */
	public String getHomePageGrants() {
		return homePageGrants;
	}
	/**
	 * @param homePageGrants the homePageGrants to set
	 */
	public void setHomePageGrants(String homePageGrants) {
		this.homePageGrants = homePageGrants;
	}
	/**
	 * @return the homePageView
	 */
	public String getHomePageView() {
		return homePageView;
	}
	/**
	 * @param homePageView the homePageView to set
	 */
	public void setHomePageView(String homePageView) {
		this.homePageView = homePageView;
	}
	/**
	 * @return the crtdUpdtdDate
	 */
	public Timestamp getCrtdUpdtdDate() {
		return crtdUpdtdDate;
	}
	/**
	 * @param crtdUpdtdDate the crtdUpdtdDate to set
	 */
	public void setCrtdUpdtdDate(Timestamp crtdUpdtdDate) {
		this.crtdUpdtdDate = crtdUpdtdDate;
	}
	/**
	 * @return the delFlag
	 */
	public Boolean getDelFlag() {
		return delFlag;
	}
	/**
	 * @param delFlag the delFlag to set
	 */
	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * @return the q04aHmisProjectIdService
	 */
	public BigInteger getQ04aHmisProjectIdService() {
		return q04aHmisProjectIdService;
	}
	/**
	 * @param q04aHmisProjectIdService the q04aHmisProjectIdService to set
	 */
	public void setQ04aHmisProjectIdService(BigInteger q04aHmisProjectIdService) {
		this.q04aHmisProjectIdService = q04aHmisProjectIdService;
	}
	/**
	 * @return the q04aHmisProjectType
	 */
	public String getQ04aHmisProjectType() {
		return q04aHmisProjectType;
	}
	/**
	 * @param q04aHmisProjectType the q04aHmisProjectType to set
	 */
	public void setQ04aHmisProjectType(String q04aHmisProjectType) {
		this.q04aHmisProjectType = q04aHmisProjectType;
	}
	/**
	 * @return the q04aIdentityProjectId
	 */
	public BigInteger getQ04aIdentityProjectId() {
		return q04aIdentityProjectId;
	}
	/**
	 * @param q04aIdentityProjectId the q04aIdentityProjectId to set
	 */
	public void setQ04aIdentityProjectId(BigInteger q04aIdentityProjectId) {
		this.q04aIdentityProjectId = q04aIdentityProjectId;
	}
	/**
	 * @return the q04aMethodOfTracking
	 */
	public String getQ04aMethodOfTracking() {
		return q04aMethodOfTracking;
	}
	/**
	 * @param q04aMethodOfTracking the q04aMethodOfTracking to set
	 */
	public void setQ04aMethodOfTracking(String q04aMethodOfTracking) {
		this.q04aMethodOfTracking = q04aMethodOfTracking;
	}
	/**
	 * @return the q04aOrgId
	 */
	public String getQ04aOrgId() {
		return q04aOrgId;
	}
	/**
	 * @param q04aOrgId the q04aOrgId to set
	 */
	public void setQ04aOrgId(String q04aOrgId) {
		this.q04aOrgId = q04aOrgId;
	}
	/**
	 * @return the q04aOrgName
	 */
	public String getQ04aOrgName() {
		return q04aOrgName;
	}
	/**
	 * @param q04aOrgName the q04aOrgName to set
	 */
	public void setQ04aOrgName(String q04aOrgName) {
		this.q04aOrgName = q04aOrgName;
	}
	/**
	 * @return the q04aProjectId
	 */
	public String getQ04aProjectId() {
		return q04aProjectId;
	}
	/**
	 * @param q04aProjectId the q04aProjectId to set
	 */
	public void setQ04aProjectId(String q04aProjectId) {
		this.q04aProjectId = q04aProjectId;
	}
	/**
	 * @return the q04aProjectName
	 */
	public String getQ04aProjectName() {
		return q04aProjectName;
	}
	/**
	 * @param q04aProjectName the q04aProjectName to set
	 */
	public void setQ04aProjectName(String q04aProjectName) {
		this.q04aProjectName = q04aProjectName;
	}
	/**
	 * @return the q05aHMISComparableDBDataQualityDataBean
	 */
	public List<Q05aHMISComparableDBDataQualityDataBean> getQ05aHMISComparableDBDataQualityDataBean() {
		return q05aHMISComparableDBDataQualityDataBean;
	}
	/**
	 * @param q05aHMISComparableDBDataQualityDataBean the q05aHMISComparableDBDataQualityDataBean to set
	 */
	public void setQ05aHMISComparableDBDataQualityDataBean(
			List<Q05aHMISComparableDBDataQualityDataBean> q05aHMISComparableDBDataQualityDataBean) {
		this.q05aHMISComparableDBDataQualityDataBean = q05aHMISComparableDBDataQualityDataBean;
	}
	/**
	 * @return the q06aReportValidationsTableDataBean
	 */
	public List<Q06aReportValidationsTableDataBean> getQ06aReportValidationsTableDataBean() {
		return q06aReportValidationsTableDataBean;
	}
	/**
	 * @param q06aReportValidationsTableDataBean the q06aReportValidationsTableDataBean to set
	 */
	public void setQ06aReportValidationsTableDataBean(
			List<Q06aReportValidationsTableDataBean> q06aReportValidationsTableDataBean) {
		this.q06aReportValidationsTableDataBean = q06aReportValidationsTableDataBean;
	}
	/**
	 * @return the q06bNumberOfPersonsServedDataBean
	 */
	public List<Q06bNumberOfPersonsServedDataBean> getQ06bNumberOfPersonsServedDataBean() {
		return q06bNumberOfPersonsServedDataBean;
	}
	/**
	 * @param q06bNumberOfPersonsServedDataBean the q06bNumberOfPersonsServedDataBean to set
	 */
	public void setQ06bNumberOfPersonsServedDataBean(
			List<Q06bNumberOfPersonsServedDataBean> q06bNumberOfPersonsServedDataBean) {
		this.q06bNumberOfPersonsServedDataBean = q06bNumberOfPersonsServedDataBean;
	}
	/**
	 * @return the q06cPointInTimeCountPersonsLastWednesdayDataBean
	 */
	public List<Q06cPointInTimeCountPersonsLastWednesdayDataBean> getQ06cPointInTimeCountPersonsLastWednesdayDataBean() {
		return q06cPointInTimeCountPersonsLastWednesdayDataBean;
	}
	/**
	 * @param q06cPointInTimeCountPersonsLastWednesdayDataBean the q06cPointInTimeCountPersonsLastWednesdayDataBean to set
	 */
	public void setQ06cPointInTimeCountPersonsLastWednesdayDataBean(
			List<Q06cPointInTimeCountPersonsLastWednesdayDataBean> q06cPointInTimeCountPersonsLastWednesdayDataBean) {
		this.q06cPointInTimeCountPersonsLastWednesdayDataBean = q06cPointInTimeCountPersonsLastWednesdayDataBean;
	}
	/**
	 * @return the q06dDataBean
	 */
	public List<Q06dDataBean> getQ06dDataBean() {
		return q06dDataBean;
	}
	/**
	 * @param q06dDataBean the q06dDataBean to set
	 */
	public void setQ06dDataBean(List<Q06dDataBean> q06dDataBean) {
		this.q06dDataBean = q06dDataBean;
	}
	/**
	 * @return the q06eDataBean
	 */
	public List<Q06eDataBean> getQ06eDataBean() {
		return q06eDataBean;
	}
	/**
	 * @param q06eDataBean the q06eDataBean to set
	 */
	public void setQ06eDataBean(List<Q06eDataBean> q06eDataBean) {
		this.q06eDataBean = q06eDataBean;
	}
	/**
	 * @return the q06fDataBean
	 */
	public List<Q06fDataBean> getQ06fDataBean() {
		return q06fDataBean;
	}
	/**
	 * @param q06fDataBean the q06fDataBean to set
	 */
	public void setQ06fDataBean(List<Q06fDataBean> q06fDataBean) {
		this.q06fDataBean = q06fDataBean;
	}
	/**
	 * @return the q07aHouseholdsServedDataBean
	 */
	public List<Q07aHouseholdsServedDataBean> getQ07aHouseholdsServedDataBean() {
		return q07aHouseholdsServedDataBean;
	}
	/**
	 * @param q07aHouseholdsServedDataBean the q07aHouseholdsServedDataBean to set
	 */
	public void setQ07aHouseholdsServedDataBean(
			List<Q07aHouseholdsServedDataBean> q07aHouseholdsServedDataBean) {
		this.q07aHouseholdsServedDataBean = q07aHouseholdsServedDataBean;
	}
	/**
	 * @return the q07bPointInTimeCountHouseholdsLastWednesdayDataBean
	 */
	public List<Q07bPointInTimeCountHouseholdsLastWednesdayDataBean> getQ07bPointInTimeCountHouseholdsLastWednesdayDataBean() {
		return q07bPointInTimeCountHouseholdsLastWednesdayDataBean;
	}
	/**
	 * @param q07bPointInTimeCountHouseholdsLastWednesdayDataBean the q07bPointInTimeCountHouseholdsLastWednesdayDataBean to set
	 */
	public void setQ07bPointInTimeCountHouseholdsLastWednesdayDataBean(
			List<Q07bPointInTimeCountHouseholdsLastWednesdayDataBean> q07bPointInTimeCountHouseholdsLastWednesdayDataBean) {
		this.q07bPointInTimeCountHouseholdsLastWednesdayDataBean = q07bPointInTimeCountHouseholdsLastWednesdayDataBean;
	}
	/**
	 * @return the q08aDataBean
	 */
	public List<Q08aDataBean> getQ08aDataBean() {
		return q08aDataBean;
	}
	/**
	 * @param q08aDataBean the q08aDataBean to set
	 */
	public void setQ08aDataBean(List<Q08aDataBean> q08aDataBean) {
		this.q08aDataBean = q08aDataBean;
	}
	/**
	 * @return the q08bDataBean
	 */
	public List<Q08bDataBean> getQ08bDataBean() {
		return q08bDataBean;
	}
	/**
	 * @param q08bDataBean the q08bDataBean to set
	 */
	public void setQ08bDataBean(List<Q08bDataBean> q08bDataBean) {
		this.q08bDataBean = q08bDataBean;
	}
	/**
	 * @return the q09aNumberPersonsContactedDataBean
	 */
	public List<Q09aNumberPersonsContactedDataBean> getQ09aNumberPersonsContactedDataBean() {
		return q09aNumberPersonsContactedDataBean;
	}
	/**
	 * @param q09aNumberPersonsContactedDataBean the q09aNumberPersonsContactedDataBean to set
	 */
	public void setQ09aNumberPersonsContactedDataBean(
			List<Q09aNumberPersonsContactedDataBean> q09aNumberPersonsContactedDataBean) {
		this.q09aNumberPersonsContactedDataBean = q09aNumberPersonsContactedDataBean;
	}
	/**
	 * @return the q09bNumberofPersonsEngagedDataBean
	 */
	public List<Q09bNumberofPersonsEngagedDataBean> getQ09bNumberofPersonsEngagedDataBean() {
		return q09bNumberofPersonsEngagedDataBean;
	}
	/**
	 * @param q09bNumberofPersonsEngagedDataBean the q09bNumberofPersonsEngagedDataBean to set
	 */
	public void setQ09bNumberofPersonsEngagedDataBean(
			List<Q09bNumberofPersonsEngagedDataBean> q09bNumberofPersonsEngagedDataBean) {
		this.q09bNumberofPersonsEngagedDataBean = q09bNumberofPersonsEngagedDataBean;
	}
	/**
	 * @return the q10aGenderOfAdultsDataBean
	 */
	public List<Q10aGenderOfAdultsDataBean> getQ10aGenderOfAdultsDataBean() {
		return q10aGenderOfAdultsDataBean;
	}
	/**
	 * @param q10aGenderOfAdultsDataBean the q10aGenderOfAdultsDataBean to set
	 */
	public void setQ10aGenderOfAdultsDataBean(
			List<Q10aGenderOfAdultsDataBean> q10aGenderOfAdultsDataBean) {
		this.q10aGenderOfAdultsDataBean = q10aGenderOfAdultsDataBean;
	}
	/**
	 * @return the q10bGenderOfChildrenDataBean
	 */
	public List<Q10bGenderOfChildrenDataBean> getQ10bGenderOfChildrenDataBean() {
		return q10bGenderOfChildrenDataBean;
	}
	/**
	 * @param q10bGenderOfChildrenDataBean the q10bGenderOfChildrenDataBean to set
	 */
	public void setQ10bGenderOfChildrenDataBean(
			List<Q10bGenderOfChildrenDataBean> q10bGenderOfChildrenDataBean) {
		this.q10bGenderOfChildrenDataBean = q10bGenderOfChildrenDataBean;
	}
	/**
	 * @return the q10cGenderOfPersonsMissingAgeInformationDataBean
	 */
	public List<Q10cGenderOfPersonsMissingAgeInformationDataBean> getQ10cGenderOfPersonsMissingAgeInformationDataBean() {
		return q10cGenderOfPersonsMissingAgeInformationDataBean;
	}
	/**
	 * @param q10cGenderOfPersonsMissingAgeInformationDataBean the q10cGenderOfPersonsMissingAgeInformationDataBean to set
	 */
	public void setQ10cGenderOfPersonsMissingAgeInformationDataBean(
			List<Q10cGenderOfPersonsMissingAgeInformationDataBean> q10cGenderOfPersonsMissingAgeInformationDataBean) {
		this.q10cGenderOfPersonsMissingAgeInformationDataBean = q10cGenderOfPersonsMissingAgeInformationDataBean;
	}
	/**
	 * @return the q10dGenderByAgeRangesDataBean
	 */
	public List<Q10dGenderByAgeRangesDataBean> getQ10dGenderByAgeRangesDataBean() {
		return q10dGenderByAgeRangesDataBean;
	}
	/**
	 * @param q10dGenderByAgeRangesDataBean the q10dGenderByAgeRangesDataBean to set
	 */
	public void setQ10dGenderByAgeRangesDataBean(
			List<Q10dGenderByAgeRangesDataBean> q10dGenderByAgeRangesDataBean) {
		this.q10dGenderByAgeRangesDataBean = q10dGenderByAgeRangesDataBean;
	}
	/**
	 * @return the q11AgeDataBean
	 */
	public List<Q11AgeDataBean> getQ11AgeDataBean() {
		return q11AgeDataBean;
	}
	/**
	 * @param q11AgeDataBean the q11AgeDataBean to set
	 */
	public void setQ11AgeDataBean(List<Q11AgeDataBean> q11AgeDataBean) {
		this.q11AgeDataBean = q11AgeDataBean;
	}
	/**
	 * @return the q12aRaceDataBean
	 */
	public List<Q12aRaceDataBean> getQ12aRaceDataBean() {
		return q12aRaceDataBean;
	}
	/**
	 * @param q12aRaceDataBean the q12aRaceDataBean to set
	 */
	public void setQ12aRaceDataBean(List<Q12aRaceDataBean> q12aRaceDataBean) {
		this.q12aRaceDataBean = q12aRaceDataBean;
	}
	/**
	 * @return the q12bEthnicityDataBean
	 */
	public List<Q12bEthnicityDataBean> getQ12bEthnicityDataBean() {
		return q12bEthnicityDataBean;
	}
	/**
	 * @param q12bEthnicityDataBean the q12bEthnicityDataBean to set
	 */
	public void setQ12bEthnicityDataBean(
			List<Q12bEthnicityDataBean> q12bEthnicityDataBean) {
		this.q12bEthnicityDataBean = q12bEthnicityDataBean;
	}
	/**
	 * @return the q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean
	 */
	public List<Q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean> getQ13a1PhysicalAndMentalHealthConditionsAtEntryDataBean() {
		return q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean;
	}
	/**
	 * @param q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean the q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean to set
	 */
	public void setQ13a1PhysicalAndMentalHealthConditionsAtEntryDataBean(
			List<Q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean> q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean) {
		this.q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean = q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean;
	}
	/**
	 * @return the q13a2NumberOfConditionsAtEntryDataBean
	 */
	public List<Q13a2NumberOfConditionsAtEntryDataBean> getQ13a2NumberOfConditionsAtEntryDataBean() {
		return q13a2NumberOfConditionsAtEntryDataBean;
	}
	/**
	 * @param q13a2NumberOfConditionsAtEntryDataBean the q13a2NumberOfConditionsAtEntryDataBean to set
	 */
	public void setQ13a2NumberOfConditionsAtEntryDataBean(
			List<Q13a2NumberOfConditionsAtEntryDataBean> q13a2NumberOfConditionsAtEntryDataBean) {
		this.q13a2NumberOfConditionsAtEntryDataBean = q13a2NumberOfConditionsAtEntryDataBean;
	}
	/**
	 * @return the q13b1PhysicalAndMentalHealthConditionsAtExitDataBean
	 */
	public List<Q13b1PhysicalAndMentalHealthConditionsAtExitDataBean> getQ13b1PhysicalAndMentalHealthConditionsAtExitDataBean() {
		return q13b1PhysicalAndMentalHealthConditionsAtExitDataBean;
	}
	/**
	 * @param q13b1PhysicalAndMentalHealthConditionsAtExitDataBean the q13b1PhysicalAndMentalHealthConditionsAtExitDataBean to set
	 */
	public void setQ13b1PhysicalAndMentalHealthConditionsAtExitDataBean(
			List<Q13b1PhysicalAndMentalHealthConditionsAtExitDataBean> q13b1PhysicalAndMentalHealthConditionsAtExitDataBean) {
		this.q13b1PhysicalAndMentalHealthConditionsAtExitDataBean = q13b1PhysicalAndMentalHealthConditionsAtExitDataBean;
	}
	/**
	 * @return the q13b2NumberOfConditionsAtExitDataBean
	 */
	public List<Q13b2NumberOfConditionsAtExitDataBean> getQ13b2NumberOfConditionsAtExitDataBean() {
		return q13b2NumberOfConditionsAtExitDataBean;
	}
	/**
	 * @param q13b2NumberOfConditionsAtExitDataBean the q13b2NumberOfConditionsAtExitDataBean to set
	 */
	public void setQ13b2NumberOfConditionsAtExitDataBean(
			List<Q13b2NumberOfConditionsAtExitDataBean> q13b2NumberOfConditionsAtExitDataBean) {
		this.q13b2NumberOfConditionsAtExitDataBean = q13b2NumberOfConditionsAtExitDataBean;
	}
	/**
	 * @return the q13c1PhysicalAndMentalHealthConditionsForStayersDataBean
	 */
	public List<Q13c1PhysicalAndMentalHealthConditionsForStayersDataBean> getQ13c1PhysicalAndMentalHealthConditionsForStayersDataBean() {
		return q13c1PhysicalAndMentalHealthConditionsForStayersDataBean;
	}
	/**
	 * @param q13c1PhysicalAndMentalHealthConditionsForStayersDataBean the q13c1PhysicalAndMentalHealthConditionsForStayersDataBean to set
	 */
	public void setQ13c1PhysicalAndMentalHealthConditionsForStayersDataBean(
			List<Q13c1PhysicalAndMentalHealthConditionsForStayersDataBean> q13c1PhysicalAndMentalHealthConditionsForStayersDataBean) {
		this.q13c1PhysicalAndMentalHealthConditionsForStayersDataBean = q13c1PhysicalAndMentalHealthConditionsForStayersDataBean;
	}
	/**
	 * @return the q13c2NumberOfConditionsForStayerDataBean
	 */
	public List<Q13c2NumberOfConditionsForStayerDataBean> getQ13c2NumberOfConditionsForStayerDataBean() {
		return q13c2NumberOfConditionsForStayerDataBean;
	}
	/**
	 * @param q13c2NumberOfConditionsForStayerDataBean the q13c2NumberOfConditionsForStayerDataBean to set
	 */
	public void setQ13c2NumberOfConditionsForStayerDataBean(
			List<Q13c2NumberOfConditionsForStayerDataBean> q13c2NumberOfConditionsForStayerDataBean) {
		this.q13c2NumberOfConditionsForStayerDataBean = q13c2NumberOfConditionsForStayerDataBean;
	}
	/**
	 * @return the q14aDomesticViolenceHistoryDataBean
	 */
	public List<Q14aDomesticViolenceHistoryDataBean> getQ14aDomesticViolenceHistoryDataBean() {
		return q14aDomesticViolenceHistoryDataBean;
	}
	/**
	 * @param q14aDomesticViolenceHistoryDataBean the q14aDomesticViolenceHistoryDataBean to set
	 */
	public void setQ14aDomesticViolenceHistoryDataBean(
			List<Q14aDomesticViolenceHistoryDataBean> q14aDomesticViolenceHistoryDataBean) {
		this.q14aDomesticViolenceHistoryDataBean = q14aDomesticViolenceHistoryDataBean;
	}
	/**
	 * @return the q14bPersonsFleeingDomesticViolenceDataBean
	 */
	public List<Q14bPersonsFleeingDomesticViolenceDataBean> getQ14bPersonsFleeingDomesticViolenceDataBean() {
		return q14bPersonsFleeingDomesticViolenceDataBean;
	}
	/**
	 * @param q14bPersonsFleeingDomesticViolenceDataBean the q14bPersonsFleeingDomesticViolenceDataBean to set
	 */
	public void setQ14bPersonsFleeingDomesticViolenceDataBean(
			List<Q14bPersonsFleeingDomesticViolenceDataBean> q14bPersonsFleeingDomesticViolenceDataBean) {
		this.q14bPersonsFleeingDomesticViolenceDataBean = q14bPersonsFleeingDomesticViolenceDataBean;
	}
	/**
	 * @return the q15ResidencePriorToProgramEntryDataBean
	 */
	public List<Q15ResidencePriorToProgramEntryDataBean> getQ15ResidencePriorToProgramEntryDataBean() {
		return q15ResidencePriorToProgramEntryDataBean;
	}
	/**
	 * @param q15ResidencePriorToProgramEntryDataBean the q15ResidencePriorToProgramEntryDataBean to set
	 */
	public void setQ15ResidencePriorToProgramEntryDataBean(
			List<Q15ResidencePriorToProgramEntryDataBean> q15ResidencePriorToProgramEntryDataBean) {
		this.q15ResidencePriorToProgramEntryDataBean = q15ResidencePriorToProgramEntryDataBean;
	}
	/**
	 * @return the q16CashIncomeRangesDataBean
	 */
	public List<Q16CashIncomeRangesDataBean> getQ16CashIncomeRangesDataBean() {
		return q16CashIncomeRangesDataBean;
	}
	/**
	 * @param q16CashIncomeRangesDataBean the q16CashIncomeRangesDataBean to set
	 */
	public void setQ16CashIncomeRangesDataBean(
			List<Q16CashIncomeRangesDataBean> q16CashIncomeRangesDataBean) {
		this.q16CashIncomeRangesDataBean = q16CashIncomeRangesDataBean;
	}
	/**
	 * @return the q17CashIncomeSourcesDataBean
	 */
	public List<Q17CashIncomeSourcesDataBean> getQ17CashIncomeSourcesDataBean() {
		return q17CashIncomeSourcesDataBean;
	}
	/**
	 * @param q17CashIncomeSourcesDataBean the q17CashIncomeSourcesDataBean to set
	 */
	public void setQ17CashIncomeSourcesDataBean(
			List<Q17CashIncomeSourcesDataBean> q17CashIncomeSourcesDataBean) {
		this.q17CashIncomeSourcesDataBean = q17CashIncomeSourcesDataBean;
	}
	/**
	 * @return the q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean
	 */
	public List<Q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean> getQ18ClientCashIncomeCategoryEarnedOtherIncomeDataBean() {
		return q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean;
	}
	/**
	 * @param q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean the q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean to set
	 */
	public void setQ18ClientCashIncomeCategoryEarnedOtherIncomeDataBean(
			List<Q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean> q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean) {
		this.q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean = q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean;
	}
	/**
	 * @return the q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean
	 */
	public List<Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean> getQ19a1ClientCashIncomeChangeIncomeSourceEntryDataBean() {
		return q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean;
	}
	/**
	 * @param q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean the q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean to set
	 */
	public void setQ19a1ClientCashIncomeChangeIncomeSourceEntryDataBean(
			List<Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean> q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean) {
		this.q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean = q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean;
	}
	/**
	 * @return the q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean
	 */
	public List<Q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean> getQ19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean() {
		return q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean;
	}
	/**
	 * @param q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean the q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean to set
	 */
	public void setQ19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean(
			List<Q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean> q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean) {
		this.q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean = q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean;
	}
	/**
	 * @return the q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean
	 */
	public List<Q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean> getQ19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean() {
		return q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean;
	}
	/**
	 * @param q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean the q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean to set
	 */
	public void setQ19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean(
			List<Q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean> q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean) {
		this.q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean = q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean;
	}
	/**
	 * @return the q20aTypeOfNonCashBenefitSourcesDataBean
	 */
	public List<Q20aTypeOfNonCashBenefitSourcesDataBean> getQ20aTypeOfNonCashBenefitSourcesDataBean() {
		return q20aTypeOfNonCashBenefitSourcesDataBean;
	}
	/**
	 * @param q20aTypeOfNonCashBenefitSourcesDataBean the q20aTypeOfNonCashBenefitSourcesDataBean to set
	 */
	public void setQ20aTypeOfNonCashBenefitSourcesDataBean(
			List<Q20aTypeOfNonCashBenefitSourcesDataBean> q20aTypeOfNonCashBenefitSourcesDataBean) {
		this.q20aTypeOfNonCashBenefitSourcesDataBean = q20aTypeOfNonCashBenefitSourcesDataBean;
	}
	/**
	 * @return the q20bNumberOfNonCashBenefitSourcesDataBean
	 */
	public List<Q20bNumberOfNonCashBenefitSourcesDataBean> getQ20bNumberOfNonCashBenefitSourcesDataBean() {
		return q20bNumberOfNonCashBenefitSourcesDataBean;
	}
	/**
	 * @param q20bNumberOfNonCashBenefitSourcesDataBean the q20bNumberOfNonCashBenefitSourcesDataBean to set
	 */
	public void setQ20bNumberOfNonCashBenefitSourcesDataBean(
			List<Q20bNumberOfNonCashBenefitSourcesDataBean> q20bNumberOfNonCashBenefitSourcesDataBean) {
		this.q20bNumberOfNonCashBenefitSourcesDataBean = q20bNumberOfNonCashBenefitSourcesDataBean;
	}
	/**
	 * @return the q21HealthInsuranceDataBean
	 */
	public List<Q21HealthInsuranceDataBean> getQ21HealthInsuranceDataBean() {
		return q21HealthInsuranceDataBean;
	}
	/**
	 * @param q21HealthInsuranceDataBean the q21HealthInsuranceDataBean to set
	 */
	public void setQ21HealthInsuranceDataBean(
			List<Q21HealthInsuranceDataBean> q21HealthInsuranceDataBean) {
		this.q21HealthInsuranceDataBean = q21HealthInsuranceDataBean;
	}
	/**
	 * @return the q22a1LengthOfParticipationCoCProjectsDataBean
	 */
	public List<Q22a1LengthOfParticipationCoCProjectsDataBean> getQ22a1LengthOfParticipationCoCProjectsDataBean() {
		return q22a1LengthOfParticipationCoCProjectsDataBean;
	}
	/**
	 * @param q22a1LengthOfParticipationCoCProjectsDataBean the q22a1LengthOfParticipationCoCProjectsDataBean to set
	 */
	public void setQ22a1LengthOfParticipationCoCProjectsDataBean(
			List<Q22a1LengthOfParticipationCoCProjectsDataBean> q22a1LengthOfParticipationCoCProjectsDataBean) {
		this.q22a1LengthOfParticipationCoCProjectsDataBean = q22a1LengthOfParticipationCoCProjectsDataBean;
	}
	/**
	 * @return the q22a2LengthOfParticipationESGProjectsDataBean
	 */
	public List<Q22a2LengthOfParticipationESGProjectsDataBean> getQ22a2LengthOfParticipationESGProjectsDataBean() {
		return q22a2LengthOfParticipationESGProjectsDataBean;
	}
	/**
	 * @param q22a2LengthOfParticipationESGProjectsDataBean the q22a2LengthOfParticipationESGProjectsDataBean to set
	 */
	public void setQ22a2LengthOfParticipationESGProjectsDataBean(
			List<Q22a2LengthOfParticipationESGProjectsDataBean> q22a2LengthOfParticipationESGProjectsDataBean) {
		this.q22a2LengthOfParticipationESGProjectsDataBean = q22a2LengthOfParticipationESGProjectsDataBean;
	}
	/**
	 * @return the q22bAverageAndMedianLengthOfParticipationInDaysDataBean
	 */
	public List<Q22bAverageAndMedianLengthOfParticipationInDaysDataBean> getQ22bAverageAndMedianLengthOfParticipationInDaysDataBean() {
		return q22bAverageAndMedianLengthOfParticipationInDaysDataBean;
	}
	/**
	 * @param q22bAverageAndMedianLengthOfParticipationInDaysDataBean the q22bAverageAndMedianLengthOfParticipationInDaysDataBean to set
	 */
	public void setQ22bAverageAndMedianLengthOfParticipationInDaysDataBean(
			List<Q22bAverageAndMedianLengthOfParticipationInDaysDataBean> q22bAverageAndMedianLengthOfParticipationInDaysDataBean) {
		this.q22bAverageAndMedianLengthOfParticipationInDaysDataBean = q22bAverageAndMedianLengthOfParticipationInDaysDataBean;
	}
	/**
	 * @return the q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBean
	 */
	public List<Q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBean> getQ22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBean() {
		return q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBean;
	}
	/**
	 * @param q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBean the q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBean to set
	 */
	public void setQ22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBean(
			List<Q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBean> q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBean) {
		this.q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBean = q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBean;
	}
	/**
	 * @return the q22dLengthOfParticipationByHouseholdTypeDataBean
	 */
	public List<Q22dLengthOfParticipationByHouseholdTypeDataBean> getQ22dLengthOfParticipationByHouseholdTypeDataBean() {
		return q22dLengthOfParticipationByHouseholdTypeDataBean;
	}
	/**
	 * @param q22dLengthOfParticipationByHouseholdTypeDataBean the q22dLengthOfParticipationByHouseholdTypeDataBean to set
	 */
	public void setQ22dLengthOfParticipationByHouseholdTypeDataBean(
			List<Q22dLengthOfParticipationByHouseholdTypeDataBean> q22dLengthOfParticipationByHouseholdTypeDataBean) {
		this.q22dLengthOfParticipationByHouseholdTypeDataBean = q22dLengthOfParticipationByHouseholdTypeDataBean;
	}
	/**
	 * @return the q23ExitDestinationMoreThan90DaysDataBean
	 */
	public List<Q23aExitDestinationMoreThan90DaysDataBean> getQ23ExitDestinationMoreThan90DaysDataBean() {
		return q23ExitDestinationMoreThan90DaysDataBean;
	}
	/**
	 * @param q23ExitDestinationMoreThan90DaysDataBean the q23ExitDestinationMoreThan90DaysDataBean to set
	 */
	public void setQ23ExitDestinationMoreThan90DaysDataBean(
			List<Q23aExitDestinationMoreThan90DaysDataBean> q23ExitDestinationMoreThan90DaysDataBean) {
		this.q23ExitDestinationMoreThan90DaysDataBean = q23ExitDestinationMoreThan90DaysDataBean;
	}
	/**
	 * @return the q23bExitDestination90DaysOrLessDataBean
	 */
	public List<Q23bExitDestination90DaysOrLessDataBean> getQ23bExitDestination90DaysOrLessDataBean() {
		return q23bExitDestination90DaysOrLessDataBean;
	}
	/**
	 * @param q23bExitDestination90DaysOrLessDataBean the q23bExitDestination90DaysOrLessDataBean to set
	 */
	public void setQ23bExitDestination90DaysOrLessDataBean(
			List<Q23bExitDestination90DaysOrLessDataBean> q23bExitDestination90DaysOrLessDataBean) {
		this.q23bExitDestination90DaysOrLessDataBean = q23bExitDestination90DaysOrLessDataBean;
	}
	
	public List<Q23cDataBean> getQ23cDataBean() {
		return q23cDataBean;
	}
	public void setQ23cDataBean(List<Q23cDataBean> q23cDataBean) {
		this.q23cDataBean = q23cDataBean;
	}
	/**
	 * @return the q24HomelessnessPreventionHousingAssessmentAtExitDataBean
	 */
	public List<Q24HomelessnessPreventionHousingAssessmentAtExitDataBean> getQ24HomelessnessPreventionHousingAssessmentAtExitDataBean() {
		return q24HomelessnessPreventionHousingAssessmentAtExitDataBean;
	}
	/**
	 * @param q24HomelessnessPreventionHousingAssessmentAtExitDataBean the q24HomelessnessPreventionHousingAssessmentAtExitDataBean to set
	 */
	public void setQ24HomelessnessPreventionHousingAssessmentAtExitDataBean(
			List<Q24HomelessnessPreventionHousingAssessmentAtExitDataBean> q24HomelessnessPreventionHousingAssessmentAtExitDataBean) {
		this.q24HomelessnessPreventionHousingAssessmentAtExitDataBean = q24HomelessnessPreventionHousingAssessmentAtExitDataBean;
	}
	/**
	 * @return the q25aNumberOfVeteransDataBean
	 */
	public List<Q25aNumberOfVeteransDataBean> getQ25aNumberOfVeteransDataBean() {
		return q25aNumberOfVeteransDataBean;
	}
	/**
	 * @param q25aNumberOfVeteransDataBean the q25aNumberOfVeteransDataBean to set
	 */
	public void setQ25aNumberOfVeteransDataBean(
			List<Q25aNumberOfVeteransDataBean> q25aNumberOfVeteransDataBean) {
		this.q25aNumberOfVeteransDataBean = q25aNumberOfVeteransDataBean;
	}
	/**
	 * @return the q25bNumberOfVeteranHouseholdsDataBean
	 */
	public List<Q25bNumberOfVeteranHouseholdsDataBean> getQ25bNumberOfVeteranHouseholdsDataBean() {
		return q25bNumberOfVeteranHouseholdsDataBean;
	}
	/**
	 * @param q25bNumberOfVeteranHouseholdsDataBean the q25bNumberOfVeteranHouseholdsDataBean to set
	 */
	public void setQ25bNumberOfVeteranHouseholdsDataBean(
			List<Q25bNumberOfVeteranHouseholdsDataBean> q25bNumberOfVeteranHouseholdsDataBean) {
		this.q25bNumberOfVeteranHouseholdsDataBean = q25bNumberOfVeteranHouseholdsDataBean;
	}
	/**
	 * @return the q25cGenderVeteransDataBean
	 */
	public List<Q25cGenderVeteransDataBean> getQ25cGenderVeteransDataBean() {
		return q25cGenderVeteransDataBean;
	}
	/**
	 * @param q25cGenderVeteransDataBean the q25cGenderVeteransDataBean to set
	 */
	public void setQ25cGenderVeteransDataBean(
			List<Q25cGenderVeteransDataBean> q25cGenderVeteransDataBean) {
		this.q25cGenderVeteransDataBean = q25cGenderVeteransDataBean;
	}
	/**
	 * @return the q25dAgeVeteransDataBean
	 */
	public List<Q25dAgeVeteransDataBean> getQ25dAgeVeteransDataBean() {
		return q25dAgeVeteransDataBean;
	}
	/**
	 * @param q25dAgeVeteransDataBean the q25dAgeVeteransDataBean to set
	 */
	public void setQ25dAgeVeteransDataBean(
			List<Q25dAgeVeteransDataBean> q25dAgeVeteransDataBean) {
		this.q25dAgeVeteransDataBean = q25dAgeVeteransDataBean;
	}
	/**
	 * @return the q25ePhysicalAndMentalHealthConditionsVeteransDataBean
	 */
	public List<Q25ePhysicalAndMentalHealthConditionsVeteransDataBean> getQ25ePhysicalAndMentalHealthConditionsVeteransDataBean() {
		return q25ePhysicalAndMentalHealthConditionsVeteransDataBean;
	}
	/**
	 * @param q25ePhysicalAndMentalHealthConditionsVeteransDataBean the q25ePhysicalAndMentalHealthConditionsVeteransDataBean to set
	 */
	public void setQ25ePhysicalAndMentalHealthConditionsVeteransDataBean(
			List<Q25ePhysicalAndMentalHealthConditionsVeteransDataBean> q25ePhysicalAndMentalHealthConditionsVeteransDataBean) {
		this.q25ePhysicalAndMentalHealthConditionsVeteransDataBean = q25ePhysicalAndMentalHealthConditionsVeteransDataBean;
	}
	/**
	 * @return the q25fCashIncomeCategoryIncomeCategoryByEntryDataBean
	 */
	public List<Q25fCashIncomeCategoryIncomeCategoryByEntryDataBean> getQ25fCashIncomeCategoryIncomeCategoryByEntryDataBean() {
		return q25fCashIncomeCategoryIncomeCategoryByEntryDataBean;
	}
	/**
	 * @param q25fCashIncomeCategoryIncomeCategoryByEntryDataBean the q25fCashIncomeCategoryIncomeCategoryByEntryDataBean to set
	 */
	public void setQ25fCashIncomeCategoryIncomeCategoryByEntryDataBean(
			List<Q25fCashIncomeCategoryIncomeCategoryByEntryDataBean> q25fCashIncomeCategoryIncomeCategoryByEntryDataBean) {
		this.q25fCashIncomeCategoryIncomeCategoryByEntryDataBean = q25fCashIncomeCategoryIncomeCategoryByEntryDataBean;
	}
	/**
	 * @return the q25gTypeOfCashIncomeSourcesVeteransDataBean
	 */
	public List<Q25gTypeOfCashIncomeSourcesVeteransDataBean> getQ25gTypeOfCashIncomeSourcesVeteransDataBean() {
		return q25gTypeOfCashIncomeSourcesVeteransDataBean;
	}
	/**
	 * @param q25gTypeOfCashIncomeSourcesVeteransDataBean the q25gTypeOfCashIncomeSourcesVeteransDataBean to set
	 */
	public void setQ25gTypeOfCashIncomeSourcesVeteransDataBean(
			List<Q25gTypeOfCashIncomeSourcesVeteransDataBean> q25gTypeOfCashIncomeSourcesVeteransDataBean) {
		this.q25gTypeOfCashIncomeSourcesVeteransDataBean = q25gTypeOfCashIncomeSourcesVeteransDataBean;
	}
	/**
	 * @return the q25hTypeOfNonCashIncomeSourcesVeteransDataBean
	 */
	public List<Q25hTypeOfNonCashIncomeSourcesVeteransDataBean> getQ25hTypeOfNonCashIncomeSourcesVeteransDataBean() {
		return q25hTypeOfNonCashIncomeSourcesVeteransDataBean;
	}
	/**
	 * @param q25hTypeOfNonCashIncomeSourcesVeteransDataBean the q25hTypeOfNonCashIncomeSourcesVeteransDataBean to set
	 */
	public void setQ25hTypeOfNonCashIncomeSourcesVeteransDataBean(
			List<Q25hTypeOfNonCashIncomeSourcesVeteransDataBean> q25hTypeOfNonCashIncomeSourcesVeteransDataBean) {
		this.q25hTypeOfNonCashIncomeSourcesVeteransDataBean = q25hTypeOfNonCashIncomeSourcesVeteransDataBean;
	}
	/**
	 * @return the q25iExitDestinationVeteransDataBean
	 */
	public List<Q25iExitDestinationVeteransDataBean> getQ25iExitDestinationVeteransDataBean() {
		return q25iExitDestinationVeteransDataBean;
	}
	/**
	 * @param q25iExitDestinationVeteransDataBean the q25iExitDestinationVeteransDataBean to set
	 */
	public void setQ25iExitDestinationVeteransDataBean(
			List<Q25iExitDestinationVeteransDataBean> q25iExitDestinationVeteransDataBean) {
		this.q25iExitDestinationVeteransDataBean = q25iExitDestinationVeteransDataBean;
	}
	/**
	 * @return the q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean
	 */
	public List<Q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean> getQ26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean() {
		return q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean;
	}
	/**
	 * @param q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean the q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean to set
	 */
	public void setQ26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean(
			List<Q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean> q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean) {
		this.q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean = q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean;
	}
	/**
	 * @return the q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean
	 */
	public List<Q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean> getQ26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean() {
		return q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean;
	}
	/**
	 * @param q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean the q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean to set
	 */
	public void setQ26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean(
			List<Q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean> q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean) {
		this.q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean = q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean;
	}
	/**
	 * @return the q26cGenderOfChronicallyHomelessPersonDataBean
	 */
	public List<Q26cGenderOfChronicallyHomelessPersonDataBean> getQ26cGenderOfChronicallyHomelessPersonDataBean() {
		return q26cGenderOfChronicallyHomelessPersonDataBean;
	}
	/**
	 * @param q26cGenderOfChronicallyHomelessPersonDataBean the q26cGenderOfChronicallyHomelessPersonDataBean to set
	 */
	public void setQ26cGenderOfChronicallyHomelessPersonDataBean(
			List<Q26cGenderOfChronicallyHomelessPersonDataBean> q26cGenderOfChronicallyHomelessPersonDataBean) {
		this.q26cGenderOfChronicallyHomelessPersonDataBean = q26cGenderOfChronicallyHomelessPersonDataBean;
	}
	/**
	 * @return the q26dAgeOfChronicallyHomelessPersonsDataBean
	 */
	public List<Q26dAgeOfChronicallyHomelessPersonsDataBean> getQ26dAgeOfChronicallyHomelessPersonsDataBean() {
		return q26dAgeOfChronicallyHomelessPersonsDataBean;
	}
	/**
	 * @param q26dAgeOfChronicallyHomelessPersonsDataBean the q26dAgeOfChronicallyHomelessPersonsDataBean to set
	 */
	public void setQ26dAgeOfChronicallyHomelessPersonsDataBean(
			List<Q26dAgeOfChronicallyHomelessPersonsDataBean> q26dAgeOfChronicallyHomelessPersonsDataBean) {
		this.q26dAgeOfChronicallyHomelessPersonsDataBean = q26dAgeOfChronicallyHomelessPersonsDataBean;
	}
	/**
	 * @return the q26ePhysicalAndMentalHealthConditionsChronicallyDataBean
	 */
	public List<Q26ePhysicalAndMentalHealthConditionsChronicallyDataBean> getQ26ePhysicalAndMentalHealthConditionsChronicallyDataBean() {
		return q26ePhysicalAndMentalHealthConditionsChronicallyDataBean;
	}
	/**
	 * @param q26ePhysicalAndMentalHealthConditionsChronicallyDataBean the q26ePhysicalAndMentalHealthConditionsChronicallyDataBean to set
	 */
	public void setQ26ePhysicalAndMentalHealthConditionsChronicallyDataBean(
			List<Q26ePhysicalAndMentalHealthConditionsChronicallyDataBean> q26ePhysicalAndMentalHealthConditionsChronicallyDataBean) {
		this.q26ePhysicalAndMentalHealthConditionsChronicallyDataBean = q26ePhysicalAndMentalHealthConditionsChronicallyDataBean;
	}
	/**
	 * @return the q26fClientCashIncomeChronicallyHomelessPersonsDataBean
	 */
	public List<Q26fClientCashIncomeChronicallyHomelessPersonsDataBean> getQ26fClientCashIncomeChronicallyHomelessPersonsDataBean() {
		return q26fClientCashIncomeChronicallyHomelessPersonsDataBean;
	}
	/**
	 * @param q26fClientCashIncomeChronicallyHomelessPersonsDataBean the q26fClientCashIncomeChronicallyHomelessPersonsDataBean to set
	 */
	public void setQ26fClientCashIncomeChronicallyHomelessPersonsDataBean(
			List<Q26fClientCashIncomeChronicallyHomelessPersonsDataBean> q26fClientCashIncomeChronicallyHomelessPersonsDataBean) {
		this.q26fClientCashIncomeChronicallyHomelessPersonsDataBean = q26fClientCashIncomeChronicallyHomelessPersonsDataBean;
	}
	/**
	 * @return the q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean
	 */
	public List<Q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean> getQ26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean() {
		return q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean;
	}
	/**
	 * @param q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean the q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean to set
	 */
	public void setQ26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean(
			List<Q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean> q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean) {
		this.q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean = q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean;
	}
	/**
	 * @return the q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean
	 */
	public List<Q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean> getQ26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean() {
		return q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean;
	}
	/**
	 * @param q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean the q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean to set
	 */
	public void setQ26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean(
			List<Q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean> q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean) {
		this.q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean = q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean;
	}
	/**
	 * @return the q27aAgeOfYouthDataBean
	 */
	public List<Q27aAgeOfYouthDataBean> getQ27aAgeOfYouthDataBean() {
		return q27aAgeOfYouthDataBean;
	}
	/**
	 * @param q27aAgeOfYouthDataBean the q27aAgeOfYouthDataBean to set
	 */
	public void setQ27aAgeOfYouthDataBean(
			List<Q27aAgeOfYouthDataBean> q27aAgeOfYouthDataBean) {
		this.q27aAgeOfYouthDataBean = q27aAgeOfYouthDataBean;
	}
	/**
	 * @return the q27bParentingYouthDataBean
	 */
	public List<Q27bParentingYouthDataBean> getQ27bParentingYouthDataBean() {
		return q27bParentingYouthDataBean;
	}
	/**
	 * @param q27bParentingYouthDataBean the q27bParentingYouthDataBean to set
	 */
	public void setQ27bParentingYouthDataBean(
			List<Q27bParentingYouthDataBean> q27bParentingYouthDataBean) {
		this.q27bParentingYouthDataBean = q27bParentingYouthDataBean;
	}
	/**
	 * @return the q27cGenderYouthDataBean
	 */
	public List<Q27cGenderYouthDataBean> getQ27cGenderYouthDataBean() {
		return q27cGenderYouthDataBean;
	}
	/**
	 * @param q27cGenderYouthDataBean the q27cGenderYouthDataBean to set
	 */
	public void setQ27cGenderYouthDataBean(
			List<Q27cGenderYouthDataBean> q27cGenderYouthDataBean) {
		this.q27cGenderYouthDataBean = q27cGenderYouthDataBean;
	}
	/**
	 * @return the q27dResidencePriorToEntryYouthDataBean
	 */
	public List<Q27dResidencePriorToEntryYouthDataBean> getQ27dResidencePriorToEntryYouthDataBean() {
		return q27dResidencePriorToEntryYouthDataBean;
	}
	/**
	 * @param q27dResidencePriorToEntryYouthDataBean the q27dResidencePriorToEntryYouthDataBean to set
	 */
	public void setQ27dResidencePriorToEntryYouthDataBean(
			List<Q27dResidencePriorToEntryYouthDataBean> q27dResidencePriorToEntryYouthDataBean) {
		this.q27dResidencePriorToEntryYouthDataBean = q27dResidencePriorToEntryYouthDataBean;
	}
	/**
	 * @return the q27eLengthOfParticipationYouthDataBean
	 */
	public List<Q27eLengthOfParticipationYouthDataBean> getQ27eLengthOfParticipationYouthDataBean() {
		return q27eLengthOfParticipationYouthDataBean;
	}
	/**
	 * @param q27eLengthOfParticipationYouthDataBean the q27eLengthOfParticipationYouthDataBean to set
	 */
	public void setQ27eLengthOfParticipationYouthDataBean(
			List<Q27eLengthOfParticipationYouthDataBean> q27eLengthOfParticipationYouthDataBean) {
		this.q27eLengthOfParticipationYouthDataBean = q27eLengthOfParticipationYouthDataBean;
	}
	/**
	 * @return the q27fExitDestinationYouthDataBean
	 */
	public List<Q27fExitDestinationYouthDataBean> getQ27fExitDestinationYouthDataBean() {
		return q27fExitDestinationYouthDataBean;
	}
	/**
	 * @param q27fExitDestinationYouthDataBean the q27fExitDestinationYouthDataBean to set
	 */
	public void setQ27fExitDestinationYouthDataBean(
			List<Q27fExitDestinationYouthDataBean> q27fExitDestinationYouthDataBean) {
		this.q27fExitDestinationYouthDataBean = q27fExitDestinationYouthDataBean;
	}
	/**
	 * @return the q29aPerformanceMeasuresPermanentHousingProgramsDataBean
	 */
	public List<Q29aPerformanceMeasuresPermanentHousingProgramsDataBean> getQ29aPerformanceMeasuresPermanentHousingProgramsDataBean() {
		return q29aPerformanceMeasuresPermanentHousingProgramsDataBean;
	}
	/**
	 * @param q29aPerformanceMeasuresPermanentHousingProgramsDataBean the q29aPerformanceMeasuresPermanentHousingProgramsDataBean to set
	 */
	public void setQ29aPerformanceMeasuresPermanentHousingProgramsDataBean(
			List<Q29aPerformanceMeasuresPermanentHousingProgramsDataBean> q29aPerformanceMeasuresPermanentHousingProgramsDataBean) {
		this.q29aPerformanceMeasuresPermanentHousingProgramsDataBean = q29aPerformanceMeasuresPermanentHousingProgramsDataBean;
	}
	/**
	 * @return the q29bPerformanceMeasuresTransitionalHousingProgramsDataBean
	 */
	public List<Q29bPerformanceMeasuresTransitionalHousingProgramsDataBean> getQ29bPerformanceMeasuresTransitionalHousingProgramsDataBean() {
		return q29bPerformanceMeasuresTransitionalHousingProgramsDataBean;
	}
	/**
	 * @param q29bPerformanceMeasuresTransitionalHousingProgramsDataBean the q29bPerformanceMeasuresTransitionalHousingProgramsDataBean to set
	 */
	public void setQ29bPerformanceMeasuresTransitionalHousingProgramsDataBean(
			List<Q29bPerformanceMeasuresTransitionalHousingProgramsDataBean> q29bPerformanceMeasuresTransitionalHousingProgramsDataBean) {
		this.q29bPerformanceMeasuresTransitionalHousingProgramsDataBean = q29bPerformanceMeasuresTransitionalHousingProgramsDataBean;
	}
	/**
	 * @return the q29cPerformanceMeasuresStreetOutreachProgramsDataBean
	 */
	public List<Q29cPerformanceMeasuresStreetOutreachProgramsDataBean> getQ29cPerformanceMeasuresStreetOutreachProgramsDataBean() {
		return q29cPerformanceMeasuresStreetOutreachProgramsDataBean;
	}
	/**
	 * @param q29cPerformanceMeasuresStreetOutreachProgramsDataBean the q29cPerformanceMeasuresStreetOutreachProgramsDataBean to set
	 */
	public void setQ29cPerformanceMeasuresStreetOutreachProgramsDataBean(
			List<Q29cPerformanceMeasuresStreetOutreachProgramsDataBean> q29cPerformanceMeasuresStreetOutreachProgramsDataBean) {
		this.q29cPerformanceMeasuresStreetOutreachProgramsDataBean = q29cPerformanceMeasuresStreetOutreachProgramsDataBean;
	}
	/**
	 * @return the q29dPerformanceMeasuresSupportiveServiceOnlyDataBean
	 */
	public List<Q29dPerformanceMeasuresSupportiveServiceOnlyDataBean> getQ29dPerformanceMeasuresSupportiveServiceOnlyDataBean() {
		return q29dPerformanceMeasuresSupportiveServiceOnlyDataBean;
	}
	/**
	 * @param q29dPerformanceMeasuresSupportiveServiceOnlyDataBean the q29dPerformanceMeasuresSupportiveServiceOnlyDataBean to set
	 */
	public void setQ29dPerformanceMeasuresSupportiveServiceOnlyDataBean(
			List<Q29dPerformanceMeasuresSupportiveServiceOnlyDataBean> q29dPerformanceMeasuresSupportiveServiceOnlyDataBean) {
		this.q29dPerformanceMeasuresSupportiveServiceOnlyDataBean = q29dPerformanceMeasuresSupportiveServiceOnlyDataBean;
	}
	/**
	 * @return the q29ePerformanceMeasuresSafeHavensDataBean
	 */
	public List<Q29ePerformanceMeasuresSafeHavensDataBean> getQ29ePerformanceMeasuresSafeHavensDataBean() {
		return q29ePerformanceMeasuresSafeHavensDataBean;
	}
	/**
	 * @param q29ePerformanceMeasuresSafeHavensDataBean the q29ePerformanceMeasuresSafeHavensDataBean to set
	 */
	public void setQ29ePerformanceMeasuresSafeHavensDataBean(
			List<Q29ePerformanceMeasuresSafeHavensDataBean> q29ePerformanceMeasuresSafeHavensDataBean) {
		this.q29ePerformanceMeasuresSafeHavensDataBean = q29ePerformanceMeasuresSafeHavensDataBean;
	}
	/**
	 * @return the q27gCashIncomeSourcesDataBean
	 */
	public List<Q27gCashIncomeSourcesDataBean> getQ27gCashIncomeSourcesDataBean() {
		return q27gCashIncomeSourcesDataBean;
	}
	/**
	 * @param q27gCashIncomeSourcesDataBean the q27gCashIncomeSourcesDataBean to set
	 */
	public void setQ27gCashIncomeSourcesDataBean(List<Q27gCashIncomeSourcesDataBean> q27gCashIncomeSourcesDataBean) {
		this.q27gCashIncomeSourcesDataBean = q27gCashIncomeSourcesDataBean;
	}
	
}
