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
	
	private List<Q05aDataBean> q05aHMISComparableDBDataQualityDataBean;
	private List<Q06aDataBean> q06aReportValidationsTableDataBean;
	private List<Q06bDataBean> q06bNumberOfPersonsServedDataBean;
	private List<Q06cDataBean> q06cPointInTimeCountPersonsLastWednesdayDataBean;
	private List<Q06dDataBean> q06dDataBean;
	private List<Q06eDataBean> q06eDataBean;
	private List<Q06fDataBean> q06fDataBean;
	private List<Q07aDataBean> q07aHouseholdsServedDataBean;
	private List<Q07bDataBean> q07bPointInTimeCountHouseholdsLastWednesdayDataBean;
	private List<Q08aDataBean> q08aDataBean;
	private List<Q08bDataBean> q08bDataBean;
	private List<Q09aDataBean> qQ09aNumberPersonsContactedDataBean;
	private List<Q09bDataBean> q09bNumberofPersonsEngagedDataBean;
	private List<Q10aDataBean> q10aGenderOfAdultsDataBean;
	private List<Q10bDataBean> q10bGenderOfChildrenDataBean;
	private List<Q10cDataBean> q10cGenderOfPersonsMissingAgeInformationDataBean;
	private List<Q10dDataBean> q10dGenderByAgeRangesDataBean;
	private List<Q11AgeDataBean> q11AgeDataBean;
	private List<Q12aRaceDataBean> q12aRaceDataBean;
	private List<Q12bEthnicityDataBean> q12bEthnicityDataBean;
	private List<Q13a1DataBean> q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean;
	private List<Q13a2DataBean> q13a2NumberOfConditionsAtEntryDataBean;
	private List<Q13b1DataBean> q13b1PhysicalAndMentalHealthConditionsAtExitDataBean;
	private List<Q13b2DataBean> q13b2NumberOfConditionsAtExitDataBean;
	private List<Q13c1DataBean> q13c1PhysicalAndMentalHealthConditionsForStayersDataBean;
	private List<Q13c2DataBean> q13c2NumberOfConditionsForStayerDataBean;
	private List<Q14aDataBean> q14aDomesticViolenceHistoryDataBean;
	private List<Q14bDataBean> q14bPersonsFleeingDomesticViolenceDataBean;
	private List<Q15DataBean> q15ResidencePriorToProgramEntryDataBean;
	private List<Q16DataBean> q16CashIncomeRangesDataBean;
	private List<Q17DataBean> q17CashIncomeSourcesDataBean;
	private List<Q18DataBean> q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean;
	private List<Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean> q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean;
	private List<Q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean> q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean;
	private List<Q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean> q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean;
	private List<Q20aTypeOfNonCashBenefitSourcesDataBean> q20aTypeOfNonCashBenefitSourcesDataBean;
	private List<Q20bNumberOfNonCashBenefitSourcesDataBean> q20bNumberOfNonCashBenefitSourcesDataBean;
	private List<Q21HealthInsuranceDataBean> q21HealthInsuranceDataBean;
	private List<Q22a1LengthOfParticipationCoCProjectsDataBean> q22a1LengthOfParticipationCoCProjectsDataBean;
	private List<Q22bAverageAndMedianLengthOfParticipationInDaysDataBean> q22bAverageAndMedianLengthOfParticipationInDaysDataBean;
	private List<Q23aExitDestinationMoreThan90DaysDataBean> q23ExitDestinationMoreThan90DaysDataBean;
	private List<Q23bExitDestination90DaysOrLessDataBean> q23bExitDestination90DaysOrLessDataBean;
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
	private List<Q29aPerformanceMeasuresPermanentHousingProgramsDataBean> q29aPerformanceMeasuresPermanentHousingProgramsDataBean;
	private List<Q29bPerformanceMeasuresTransitionalHousingProgramsDataBean> q29bPerformanceMeasuresTransitionalHousingProgramsDataBean;
	private List<Q29cPerformanceMeasuresStreetOutreachProgramsDataBean> q29cPerformanceMeasuresStreetOutreachProgramsDataBean;
	private List<Q29dPerformanceMeasuresSupportiveServiceOnlyDataBean> q29dPerformanceMeasuresSupportiveServiceOnlyDataBean;
	private List<Q29ePerformanceMeasuresSafeHavensDataBean> q29ePerformanceMeasuresSafeHavensDataBean;
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
	public List<Q05aDataBean> getQ05aHMISComparableDBDataQualityDataBean() {
		return q05aHMISComparableDBDataQualityDataBean;
	}
	public void setQ05aHMISComparableDBDataQualityDataBean(
			List<Q05aDataBean> q05aHMISComparableDBDataQualityDataBean) {
		this.q05aHMISComparableDBDataQualityDataBean = q05aHMISComparableDBDataQualityDataBean;
	}
	public List<Q06aDataBean> getQ06aReportValidationsTableDataBean() {
		return q06aReportValidationsTableDataBean;
	}
	public void setQ06aReportValidationsTableDataBean(
			List<Q06aDataBean> q06aReportValidationsTableDataBean) {
		this.q06aReportValidationsTableDataBean = q06aReportValidationsTableDataBean;
	}
	public List<Q06bDataBean> getQ06bNumberOfPersonsServedDataBean() {
		return q06bNumberOfPersonsServedDataBean;
	}
	public void setQ06bNumberOfPersonsServedDataBean(
			List<Q06bDataBean> q06bNumberOfPersonsServedDataBean) {
		this.q06bNumberOfPersonsServedDataBean = q06bNumberOfPersonsServedDataBean;
	}
	public List<Q06cDataBean> getQ06cPointInTimeCountPersonsLastWednesdayDataBean() {
		return q06cPointInTimeCountPersonsLastWednesdayDataBean;
	}
	public void setQ06cPointInTimeCountPersonsLastWednesdayDataBean(
			List<Q06cDataBean> q06cPointInTimeCountPersonsLastWednesdayDataBean) {
		this.q06cPointInTimeCountPersonsLastWednesdayDataBean = q06cPointInTimeCountPersonsLastWednesdayDataBean;
	}
	public List<Q06dDataBean> getQ06dDataBean() {
		return q06dDataBean;
	}
	public void setQ06dDataBean(List<Q06dDataBean> q06dDataBean) {
		this.q06dDataBean = q06dDataBean;
	}
	public List<Q06eDataBean> getQ06eDataBean() {
		return q06eDataBean;
	}
	public void setQ06eDataBean(List<Q06eDataBean> q06eDataBean) {
		this.q06eDataBean = q06eDataBean;
	}
	public List<Q06fDataBean> getQ06fDataBean() {
		return q06fDataBean;
	}
	public void setQ06fDataBean(List<Q06fDataBean> q06fDataBean) {
		this.q06fDataBean = q06fDataBean;
	}
	public List<Q07aDataBean> getQ07aHouseholdsServedDataBean() {
		return q07aHouseholdsServedDataBean;
	}
	public void setQ07aHouseholdsServedDataBean(
			List<Q07aDataBean> q07aHouseholdsServedDataBean) {
		this.q07aHouseholdsServedDataBean = q07aHouseholdsServedDataBean;
	}
	public List<Q07bDataBean> getQ07bPointInTimeCountHouseholdsLastWednesdayDataBean() {
		return q07bPointInTimeCountHouseholdsLastWednesdayDataBean;
	}
	public void setQ07bPointInTimeCountHouseholdsLastWednesdayDataBean(
			List<Q07bDataBean> q07bPointInTimeCountHouseholdsLastWednesdayDataBean) {
		this.q07bPointInTimeCountHouseholdsLastWednesdayDataBean = q07bPointInTimeCountHouseholdsLastWednesdayDataBean;
	}
	public List<Q08aDataBean> getQ08aDataBean() {
		return q08aDataBean;
	}
	public void setQ08aDataBean(List<Q08aDataBean> q08aDataBean) {
		this.q08aDataBean = q08aDataBean;
	}
	public List<Q08bDataBean> getQ08bDataBean() {
		return q08bDataBean;
	}
	public void setQ08bDataBean(List<Q08bDataBean> q08bDataBean) {
		this.q08bDataBean = q08bDataBean;
	}
	public List<Q09aDataBean> getqQ09aNumberPersonsContactedDataBean() {
		return qQ09aNumberPersonsContactedDataBean;
	}
	public void setqQ09aNumberPersonsContactedDataBean(
			List<Q09aDataBean> qQ09aNumberPersonsContactedDataBean) {
		this.qQ09aNumberPersonsContactedDataBean = qQ09aNumberPersonsContactedDataBean;
	}
	public List<Q09bDataBean> getQ09bNumberofPersonsEngagedDataBean() {
		return q09bNumberofPersonsEngagedDataBean;
	}
	public void setQ09bNumberofPersonsEngagedDataBean(
			List<Q09bDataBean> q09bNumberofPersonsEngagedDataBean) {
		this.q09bNumberofPersonsEngagedDataBean = q09bNumberofPersonsEngagedDataBean;
	}
	public List<Q10aDataBean> getQ10aGenderOfAdultsDataBean() {
		return q10aGenderOfAdultsDataBean;
	}
	public void setQ10aGenderOfAdultsDataBean(
			List<Q10aDataBean> q10aGenderOfAdultsDataBean) {
		this.q10aGenderOfAdultsDataBean = q10aGenderOfAdultsDataBean;
	}
	public List<Q10bDataBean> getQ10bGenderOfChildrenDataBean() {
		return q10bGenderOfChildrenDataBean;
	}
	public void setQ10bGenderOfChildrenDataBean(
			List<Q10bDataBean> q10bGenderOfChildrenDataBean) {
		this.q10bGenderOfChildrenDataBean = q10bGenderOfChildrenDataBean;
	}
	public List<Q10cDataBean> getQ10cGenderOfPersonsMissingAgeInformationDataBean() {
		return q10cGenderOfPersonsMissingAgeInformationDataBean;
	}
	public void setQ10cGenderOfPersonsMissingAgeInformationDataBean(
			List<Q10cDataBean> q10cGenderOfPersonsMissingAgeInformationDataBean) {
		this.q10cGenderOfPersonsMissingAgeInformationDataBean = q10cGenderOfPersonsMissingAgeInformationDataBean;
	}
	/**
	 * @return the q10dGenderByAgeRangesDataBean
	 */
	public List<Q10dDataBean> getQ10dGenderByAgeRangesDataBean() {
		return q10dGenderByAgeRangesDataBean;
	}
	/**
	 * @param q10dGenderByAgeRangesDataBean the q10dGenderByAgeRangesDataBean to set
	 */
	public void setQ10dGenderByAgeRangesDataBean(
			List<Q10dDataBean> q10dGenderByAgeRangesDataBean) {
		this.q10dGenderByAgeRangesDataBean = q10dGenderByAgeRangesDataBean;
	}
	public List<Q11AgeDataBean> getQ11AgeDataBean() {
		return q11AgeDataBean;
	}
	public void setQ11AgeDataBean(List<Q11AgeDataBean> q11AgeDataBean) {
		this.q11AgeDataBean = q11AgeDataBean;
	}
	public List<Q12aRaceDataBean> getQ12aRaceDataBean() {
		return q12aRaceDataBean;
	}
	public void setQ12aRaceDataBean(List<Q12aRaceDataBean> q12aRaceDataBean) {
		this.q12aRaceDataBean = q12aRaceDataBean;
	}
	public List<Q12bEthnicityDataBean> getQ12bEthnicityDataBean() {
		return q12bEthnicityDataBean;
	}
	public void setQ12bEthnicityDataBean(
			List<Q12bEthnicityDataBean> q12bEthnicityDataBean) {
		this.q12bEthnicityDataBean = q12bEthnicityDataBean;
	}
	public List<Q13a1DataBean> getQ13a1PhysicalAndMentalHealthConditionsAtEntryDataBean() {
		return q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean;
	}
	public void setQ13a1PhysicalAndMentalHealthConditionsAtEntryDataBean(
			List<Q13a1DataBean> q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean) {
		this.q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean = q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean;
	}
	public List<Q13a2DataBean> getQ13a2NumberOfConditionsAtEntryDataBean() {
		return q13a2NumberOfConditionsAtEntryDataBean;
	}
	public void setQ13a2NumberOfConditionsAtEntryDataBean(
			List<Q13a2DataBean> q13a2NumberOfConditionsAtEntryDataBean) {
		this.q13a2NumberOfConditionsAtEntryDataBean = q13a2NumberOfConditionsAtEntryDataBean;
	}
	public List<Q13b1DataBean> getQ13b1PhysicalAndMentalHealthConditionsAtExitDataBean() {
		return q13b1PhysicalAndMentalHealthConditionsAtExitDataBean;
	}
	public void setQ13b1PhysicalAndMentalHealthConditionsAtExitDataBean(
			List<Q13b1DataBean> q13b1PhysicalAndMentalHealthConditionsAtExitDataBean) {
		this.q13b1PhysicalAndMentalHealthConditionsAtExitDataBean = q13b1PhysicalAndMentalHealthConditionsAtExitDataBean;
	}
	public List<Q13b2DataBean> getQ13b2NumberOfConditionsAtExitDataBean() {
		return q13b2NumberOfConditionsAtExitDataBean;
	}
	public void setQ13b2NumberOfConditionsAtExitDataBean(
			List<Q13b2DataBean> q13b2NumberOfConditionsAtExitDataBean) {
		this.q13b2NumberOfConditionsAtExitDataBean = q13b2NumberOfConditionsAtExitDataBean;
	}
	public List<Q13c1DataBean> getQ13c1PhysicalAndMentalHealthConditionsForStayersDataBean() {
		return q13c1PhysicalAndMentalHealthConditionsForStayersDataBean;
	}
	public void setQ13c1PhysicalAndMentalHealthConditionsForStayersDataBean(
			List<Q13c1DataBean> q13c1PhysicalAndMentalHealthConditionsForStayersDataBean) {
		this.q13c1PhysicalAndMentalHealthConditionsForStayersDataBean = q13c1PhysicalAndMentalHealthConditionsForStayersDataBean;
	}
	public List<Q13c2DataBean> getQ13c2NumberOfConditionsForStayerDataBean() {
		return q13c2NumberOfConditionsForStayerDataBean;
	}
	public void setQ13c2NumberOfConditionsForStayerDataBean(
			List<Q13c2DataBean> q13c2NumberOfConditionsForStayerDataBean) {
		this.q13c2NumberOfConditionsForStayerDataBean = q13c2NumberOfConditionsForStayerDataBean;
	}
	public List<Q14aDataBean> getQ14aDomesticViolenceHistoryDataBean() {
		return q14aDomesticViolenceHistoryDataBean;
	}
	public void setQ14aDomesticViolenceHistoryDataBean(
			List<Q14aDataBean> q14aDomesticViolenceHistoryDataBean) {
		this.q14aDomesticViolenceHistoryDataBean = q14aDomesticViolenceHistoryDataBean;
	}
	public List<Q14bDataBean> getQ14bPersonsFleeingDomesticViolenceDataBean() {
		return q14bPersonsFleeingDomesticViolenceDataBean;
	}
	public void setQ14bPersonsFleeingDomesticViolenceDataBean(
			List<Q14bDataBean> q14bPersonsFleeingDomesticViolenceDataBean) {
		this.q14bPersonsFleeingDomesticViolenceDataBean = q14bPersonsFleeingDomesticViolenceDataBean;
	}
	public List<Q15DataBean> getQ15ResidencePriorToProgramEntryDataBean() {
		return q15ResidencePriorToProgramEntryDataBean;
	}
	public void setQ15ResidencePriorToProgramEntryDataBean(
			List<Q15DataBean> q15ResidencePriorToProgramEntryDataBean) {
		this.q15ResidencePriorToProgramEntryDataBean = q15ResidencePriorToProgramEntryDataBean;
	}
	public List<Q16DataBean> getQ16CashIncomeRangesDataBean() {
		return q16CashIncomeRangesDataBean;
	}
	public void setQ16CashIncomeRangesDataBean(
			List<Q16DataBean> q16CashIncomeRangesDataBean) {
		this.q16CashIncomeRangesDataBean = q16CashIncomeRangesDataBean;
	}
	public List<Q17DataBean> getQ17CashIncomeSourcesDataBean() {
		return q17CashIncomeSourcesDataBean;
	}
	public void setQ17CashIncomeSourcesDataBean(
			List<Q17DataBean> q17CashIncomeSourcesDataBean) {
		this.q17CashIncomeSourcesDataBean = q17CashIncomeSourcesDataBean;
	}
	public List<Q18DataBean> getQ18ClientCashIncomeCategoryEarnedOtherIncomeDataBean() {
		return q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean;
	}
	public void setQ18ClientCashIncomeCategoryEarnedOtherIncomeDataBean(
			List<Q18DataBean> q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean) {
		this.q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean = q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean;
	}
	public List<Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean> getQ19a1ClientCashIncomeChangeIncomeSourceEntryDataBean() {
		return q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean;
	}
	public void setQ19a1ClientCashIncomeChangeIncomeSourceEntryDataBean(
			List<Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean> q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean) {
		this.q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean = q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean;
	}
	public List<Q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean> getQ19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean() {
		return q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean;
	}
	public void setQ19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean(
			List<Q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean> q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean) {
		this.q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean = q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean;
	}
	public List<Q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean> getQ19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean() {
		return q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean;
	}
	public void setQ19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean(
			List<Q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean> q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean) {
		this.q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean = q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean;
	}
	public List<Q20aTypeOfNonCashBenefitSourcesDataBean> getQ20aTypeOfNonCashBenefitSourcesDataBean() {
		return q20aTypeOfNonCashBenefitSourcesDataBean;
	}
	public void setQ20aTypeOfNonCashBenefitSourcesDataBean(
			List<Q20aTypeOfNonCashBenefitSourcesDataBean> q20aTypeOfNonCashBenefitSourcesDataBean) {
		this.q20aTypeOfNonCashBenefitSourcesDataBean = q20aTypeOfNonCashBenefitSourcesDataBean;
	}
	public List<Q20bNumberOfNonCashBenefitSourcesDataBean> getQ20bNumberOfNonCashBenefitSourcesDataBean() {
		return q20bNumberOfNonCashBenefitSourcesDataBean;
	}
	public void setQ20bNumberOfNonCashBenefitSourcesDataBean(
			List<Q20bNumberOfNonCashBenefitSourcesDataBean> q20bNumberOfNonCashBenefitSourcesDataBean) {
		this.q20bNumberOfNonCashBenefitSourcesDataBean = q20bNumberOfNonCashBenefitSourcesDataBean;
	}
	public List<Q21HealthInsuranceDataBean> getQ21HealthInsuranceDataBean() {
		return q21HealthInsuranceDataBean;
	}
	public void setQ21HealthInsuranceDataBean(
			List<Q21HealthInsuranceDataBean> q21HealthInsuranceDataBean) {
		this.q21HealthInsuranceDataBean = q21HealthInsuranceDataBean;
	}
	public List<Q22a1LengthOfParticipationCoCProjectsDataBean> getQ22a1LengthOfParticipationCoCProjectsDataBean() {
		return q22a1LengthOfParticipationCoCProjectsDataBean;
	}
	public void setQ22a1LengthOfParticipationCoCProjectsDataBean(
			List<Q22a1LengthOfParticipationCoCProjectsDataBean> q22a1LengthOfParticipationCoCProjectsDataBean) {
		this.q22a1LengthOfParticipationCoCProjectsDataBean = q22a1LengthOfParticipationCoCProjectsDataBean;
	}
	public List<Q22bAverageAndMedianLengthOfParticipationInDaysDataBean> getQ22bAverageAndMedianLengthOfParticipationInDaysDataBean() {
		return q22bAverageAndMedianLengthOfParticipationInDaysDataBean;
	}
	public void setQ22bAverageAndMedianLengthOfParticipationInDaysDataBean(
			List<Q22bAverageAndMedianLengthOfParticipationInDaysDataBean> q22bAverageAndMedianLengthOfParticipationInDaysDataBean) {
		this.q22bAverageAndMedianLengthOfParticipationInDaysDataBean = q22bAverageAndMedianLengthOfParticipationInDaysDataBean;
	}
	public List<Q23aExitDestinationMoreThan90DaysDataBean> getQ23ExitDestinationMoreThan90DaysDataBean() {
		return q23ExitDestinationMoreThan90DaysDataBean;
	}
	public void setQ23ExitDestinationMoreThan90DaysDataBean(
			List<Q23aExitDestinationMoreThan90DaysDataBean> q23ExitDestinationMoreThan90DaysDataBean) {
		this.q23ExitDestinationMoreThan90DaysDataBean = q23ExitDestinationMoreThan90DaysDataBean;
	}
	
	
	public List<Q23bExitDestination90DaysOrLessDataBean> getQ23bExitDestination90DaysOrLessDataBean() {
		return q23bExitDestination90DaysOrLessDataBean;
	}
	public void setQ23bExitDestination90DaysOrLessDataBean(
			List<Q23bExitDestination90DaysOrLessDataBean> q23bExitDestination90DaysOrLessDataBean) {
		this.q23bExitDestination90DaysOrLessDataBean = q23bExitDestination90DaysOrLessDataBean;
	}
	public List<Q25aNumberOfVeteransDataBean> getQ25aNumberOfVeteransDataBean() {
		return q25aNumberOfVeteransDataBean;
	}
	public void setQ25aNumberOfVeteransDataBean(
			List<Q25aNumberOfVeteransDataBean> q25aNumberOfVeteransDataBean) {
		this.q25aNumberOfVeteransDataBean = q25aNumberOfVeteransDataBean;
	}
	public List<Q25bNumberOfVeteranHouseholdsDataBean> getQ25bNumberOfVeteranHouseholdsDataBean() {
		return q25bNumberOfVeteranHouseholdsDataBean;
	}
	public void setQ25bNumberOfVeteranHouseholdsDataBean(
			List<Q25bNumberOfVeteranHouseholdsDataBean> q25bNumberOfVeteranHouseholdsDataBean) {
		this.q25bNumberOfVeteranHouseholdsDataBean = q25bNumberOfVeteranHouseholdsDataBean;
	}
	public List<Q25cGenderVeteransDataBean> getQ25cGenderVeteransDataBean() {
		return q25cGenderVeteransDataBean;
	}
	public void setQ25cGenderVeteransDataBean(
			List<Q25cGenderVeteransDataBean> q25cGenderVeteransDataBean) {
		this.q25cGenderVeteransDataBean = q25cGenderVeteransDataBean;
	}
	public List<Q25dAgeVeteransDataBean> getQ25dAgeVeteransDataBean() {
		return q25dAgeVeteransDataBean;
	}
	public void setQ25dAgeVeteransDataBean(
			List<Q25dAgeVeteransDataBean> q25dAgeVeteransDataBean) {
		this.q25dAgeVeteransDataBean = q25dAgeVeteransDataBean;
	}
	public List<Q25ePhysicalAndMentalHealthConditionsVeteransDataBean> getQ25ePhysicalAndMentalHealthConditionsVeteransDataBean() {
		return q25ePhysicalAndMentalHealthConditionsVeteransDataBean;
	}
	public void setQ25ePhysicalAndMentalHealthConditionsVeteransDataBean(
			List<Q25ePhysicalAndMentalHealthConditionsVeteransDataBean> q25ePhysicalAndMentalHealthConditionsVeteransDataBean) {
		this.q25ePhysicalAndMentalHealthConditionsVeteransDataBean = q25ePhysicalAndMentalHealthConditionsVeteransDataBean;
	}
	public List<Q25fCashIncomeCategoryIncomeCategoryByEntryDataBean> getQ25fCashIncomeCategoryIncomeCategoryByEntryDataBean() {
		return q25fCashIncomeCategoryIncomeCategoryByEntryDataBean;
	}
	public void setQ25fCashIncomeCategoryIncomeCategoryByEntryDataBean(
			List<Q25fCashIncomeCategoryIncomeCategoryByEntryDataBean> q25fCashIncomeCategoryIncomeCategoryByEntryDataBean) {
		this.q25fCashIncomeCategoryIncomeCategoryByEntryDataBean = q25fCashIncomeCategoryIncomeCategoryByEntryDataBean;
	}
	public List<Q25gTypeOfCashIncomeSourcesVeteransDataBean> getQ25gTypeOfCashIncomeSourcesVeteransDataBean() {
		return q25gTypeOfCashIncomeSourcesVeteransDataBean;
	}
	public void setQ25gTypeOfCashIncomeSourcesVeteransDataBean(
			List<Q25gTypeOfCashIncomeSourcesVeteransDataBean> q25gTypeOfCashIncomeSourcesVeteransDataBean) {
		this.q25gTypeOfCashIncomeSourcesVeteransDataBean = q25gTypeOfCashIncomeSourcesVeteransDataBean;
	}
	public List<Q25hTypeOfNonCashIncomeSourcesVeteransDataBean> getQ25hTypeOfNonCashIncomeSourcesVeteransDataBean() {
		return q25hTypeOfNonCashIncomeSourcesVeteransDataBean;
	}
	public void setQ25hTypeOfNonCashIncomeSourcesVeteransDataBean(
			List<Q25hTypeOfNonCashIncomeSourcesVeteransDataBean> q25hTypeOfNonCashIncomeSourcesVeteransDataBean) {
		this.q25hTypeOfNonCashIncomeSourcesVeteransDataBean = q25hTypeOfNonCashIncomeSourcesVeteransDataBean;
	}
	public List<Q25iExitDestinationVeteransDataBean> getQ25iExitDestinationVeteransDataBean() {
		return q25iExitDestinationVeteransDataBean;
	}
	public void setQ25iExitDestinationVeteransDataBean(
			List<Q25iExitDestinationVeteransDataBean> q25iExitDestinationVeteransDataBean) {
		this.q25iExitDestinationVeteransDataBean = q25iExitDestinationVeteransDataBean;
	}
	public List<Q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean> getQ26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean() {
		return q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean;
	}
	public void setQ26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean(
			List<Q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean> q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean) {
		this.q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean = q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean;
	}
	public List<Q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean> getQ26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean() {
		return q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean;
	}
	public void setQ26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean(
			List<Q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean> q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean) {
		this.q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean = q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean;
	}
	public List<Q26cGenderOfChronicallyHomelessPersonDataBean> getQ26cGenderOfChronicallyHomelessPersonDataBean() {
		return q26cGenderOfChronicallyHomelessPersonDataBean;
	}
	public void setQ26cGenderOfChronicallyHomelessPersonDataBean(
			List<Q26cGenderOfChronicallyHomelessPersonDataBean> q26cGenderOfChronicallyHomelessPersonDataBean) {
		this.q26cGenderOfChronicallyHomelessPersonDataBean = q26cGenderOfChronicallyHomelessPersonDataBean;
	}
	public List<Q26dAgeOfChronicallyHomelessPersonsDataBean> getQ26dAgeOfChronicallyHomelessPersonsDataBean() {
		return q26dAgeOfChronicallyHomelessPersonsDataBean;
	}
	public void setQ26dAgeOfChronicallyHomelessPersonsDataBean(
			List<Q26dAgeOfChronicallyHomelessPersonsDataBean> q26dAgeOfChronicallyHomelessPersonsDataBean) {
		this.q26dAgeOfChronicallyHomelessPersonsDataBean = q26dAgeOfChronicallyHomelessPersonsDataBean;
	}
	public List<Q26ePhysicalAndMentalHealthConditionsChronicallyDataBean> getQ26ePhysicalAndMentalHealthConditionsChronicallyDataBean() {
		return q26ePhysicalAndMentalHealthConditionsChronicallyDataBean;
	}
	public void setQ26ePhysicalAndMentalHealthConditionsChronicallyDataBean(
			List<Q26ePhysicalAndMentalHealthConditionsChronicallyDataBean> q26ePhysicalAndMentalHealthConditionsChronicallyDataBean) {
		this.q26ePhysicalAndMentalHealthConditionsChronicallyDataBean = q26ePhysicalAndMentalHealthConditionsChronicallyDataBean;
	}
	public List<Q26fClientCashIncomeChronicallyHomelessPersonsDataBean> getQ26fClientCashIncomeChronicallyHomelessPersonsDataBean() {
		return q26fClientCashIncomeChronicallyHomelessPersonsDataBean;
	}
	public void setQ26fClientCashIncomeChronicallyHomelessPersonsDataBean(
			List<Q26fClientCashIncomeChronicallyHomelessPersonsDataBean> q26fClientCashIncomeChronicallyHomelessPersonsDataBean) {
		this.q26fClientCashIncomeChronicallyHomelessPersonsDataBean = q26fClientCashIncomeChronicallyHomelessPersonsDataBean;
	}
	public List<Q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean> getQ26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean() {
		return q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean;
	}
	public void setQ26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean(
			List<Q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean> q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean) {
		this.q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean = q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean;
	}
	public List<Q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean> getQ26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean() {
		return q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean;
	}
	public void setQ26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean(
			List<Q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean> q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean) {
		this.q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean = q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean;
	}
	public List<Q27aAgeOfYouthDataBean> getQ27aAgeOfYouthDataBean() {
		return q27aAgeOfYouthDataBean;
	}
	public void setQ27aAgeOfYouthDataBean(
			List<Q27aAgeOfYouthDataBean> q27aAgeOfYouthDataBean) {
		this.q27aAgeOfYouthDataBean = q27aAgeOfYouthDataBean;
	}
	public List<Q27bParentingYouthDataBean> getQ27bParentingYouthDataBean() {
		return q27bParentingYouthDataBean;
	}
	public void setQ27bParentingYouthDataBean(
			List<Q27bParentingYouthDataBean> q27bParentingYouthDataBean) {
		this.q27bParentingYouthDataBean = q27bParentingYouthDataBean;
	}
	public List<Q27cGenderYouthDataBean> getQ27cGenderYouthDataBean() {
		return q27cGenderYouthDataBean;
	}
	public void setQ27cGenderYouthDataBean(
			List<Q27cGenderYouthDataBean> q27cGenderYouthDataBean) {
		this.q27cGenderYouthDataBean = q27cGenderYouthDataBean;
	}
	public List<Q27dResidencePriorToEntryYouthDataBean> getQ27dResidencePriorToEntryYouthDataBean() {
		return q27dResidencePriorToEntryYouthDataBean;
	}
	public void setQ27dResidencePriorToEntryYouthDataBean(
			List<Q27dResidencePriorToEntryYouthDataBean> q27dResidencePriorToEntryYouthDataBean) {
		this.q27dResidencePriorToEntryYouthDataBean = q27dResidencePriorToEntryYouthDataBean;
	}
	public List<Q27eLengthOfParticipationYouthDataBean> getQ27eLengthOfParticipationYouthDataBean() {
		return q27eLengthOfParticipationYouthDataBean;
	}
	public void setQ27eLengthOfParticipationYouthDataBean(
			List<Q27eLengthOfParticipationYouthDataBean> q27eLengthOfParticipationYouthDataBean) {
		this.q27eLengthOfParticipationYouthDataBean = q27eLengthOfParticipationYouthDataBean;
	}
	public List<Q27fExitDestinationYouthDataBean> getQ27fExitDestinationYouthDataBean() {
		return q27fExitDestinationYouthDataBean;
	}
	public void setQ27fExitDestinationYouthDataBean(
			List<Q27fExitDestinationYouthDataBean> q27fExitDestinationYouthDataBean) {
		this.q27fExitDestinationYouthDataBean = q27fExitDestinationYouthDataBean;
	}
	public List<Q29aPerformanceMeasuresPermanentHousingProgramsDataBean> getQ29aPerformanceMeasuresPermanentHousingProgramsDataBean() {
		return q29aPerformanceMeasuresPermanentHousingProgramsDataBean;
	}
	public void setQ29aPerformanceMeasuresPermanentHousingProgramsDataBean(
			List<Q29aPerformanceMeasuresPermanentHousingProgramsDataBean> q29aPerformanceMeasuresPermanentHousingProgramsDataBean) {
		this.q29aPerformanceMeasuresPermanentHousingProgramsDataBean = q29aPerformanceMeasuresPermanentHousingProgramsDataBean;
	}
	public List<Q29bPerformanceMeasuresTransitionalHousingProgramsDataBean> getQ29bPerformanceMeasuresTransitionalHousingProgramsDataBean() {
		return q29bPerformanceMeasuresTransitionalHousingProgramsDataBean;
	}
	public void setQ29bPerformanceMeasuresTransitionalHousingProgramsDataBean(
			List<Q29bPerformanceMeasuresTransitionalHousingProgramsDataBean> q29bPerformanceMeasuresTransitionalHousingProgramsDataBean) {
		this.q29bPerformanceMeasuresTransitionalHousingProgramsDataBean = q29bPerformanceMeasuresTransitionalHousingProgramsDataBean;
	}
	public List<Q29cPerformanceMeasuresStreetOutreachProgramsDataBean> getQ29cPerformanceMeasuresStreetOutreachProgramsDataBean() {
		return q29cPerformanceMeasuresStreetOutreachProgramsDataBean;
	}
	public void setQ29cPerformanceMeasuresStreetOutreachProgramsDataBean(
			List<Q29cPerformanceMeasuresStreetOutreachProgramsDataBean> q29cPerformanceMeasuresStreetOutreachProgramsDataBean) {
		this.q29cPerformanceMeasuresStreetOutreachProgramsDataBean = q29cPerformanceMeasuresStreetOutreachProgramsDataBean;
	}
	public List<Q29dPerformanceMeasuresSupportiveServiceOnlyDataBean> getQ29dPerformanceMeasuresSupportiveServiceOnlyDataBean() {
		return q29dPerformanceMeasuresSupportiveServiceOnlyDataBean;
	}
	public void setQ29dPerformanceMeasuresSupportiveServiceOnlyDataBean(
			List<Q29dPerformanceMeasuresSupportiveServiceOnlyDataBean> q29dPerformanceMeasuresSupportiveServiceOnlyDataBean) {
		this.q29dPerformanceMeasuresSupportiveServiceOnlyDataBean = q29dPerformanceMeasuresSupportiveServiceOnlyDataBean;
	}
	public List<Q29ePerformanceMeasuresSafeHavensDataBean> getQ29ePerformanceMeasuresSafeHavensDataBean() {
		return q29ePerformanceMeasuresSafeHavensDataBean;
	}
	public void setQ29ePerformanceMeasuresSafeHavensDataBean(
			List<Q29ePerformanceMeasuresSafeHavensDataBean> q29ePerformanceMeasuresSafeHavensDataBean) {
		this.q29ePerformanceMeasuresSafeHavensDataBean = q29ePerformanceMeasuresSafeHavensDataBean;
	}
	
	
	
}
