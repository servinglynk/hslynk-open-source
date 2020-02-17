package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hmis.warehouse.Properties;
import com.servinglynk.hmis.warehouse.ReportConfig;
import com.servinglynk.report.bean.HomePageDataBean;
import com.servinglynk.report.bean.Q04aDataBean;
import com.servinglynk.report.bean.Q05aHMISComparableDBDataQualityDataBean;
import com.servinglynk.report.bean.Q06aReportValidationsTableDataBean;
import com.servinglynk.report.bean.Q06bNumberOfPersonsServedDataBean;
import com.servinglynk.report.bean.Q06cPointInTimeCountPersonsLastWednesdayDataBean;
import com.servinglynk.report.bean.Q06dDataBean;
import com.servinglynk.report.bean.Q06eDataBean;
import com.servinglynk.report.bean.Q06fDataBean;
import com.servinglynk.report.bean.Q07aHouseholdsServedDataBean;
import com.servinglynk.report.bean.Q07bPointInTimeCountHouseholdsLastWednesdayDataBean;
import com.servinglynk.report.bean.Q08aDataBean;
import com.servinglynk.report.bean.Q08bDataBean;
import com.servinglynk.report.bean.Q09aNumberPersonsContactedDataBean;
import com.servinglynk.report.bean.Q09bNumberofPersonsEngagedDataBean;
import com.servinglynk.report.bean.Q10aGenderOfAdultsDataBean;
import com.servinglynk.report.bean.Q10bGenderOfChildrenDataBean;
import com.servinglynk.report.bean.Q10cGenderOfPersonsMissingAgeInformationDataBean;
import com.servinglynk.report.bean.Q10dGenderByAgeRangesDataBean;
import com.servinglynk.report.bean.Q11AgeDataBean;
import com.servinglynk.report.bean.Q12aRaceDataBean;
import com.servinglynk.report.bean.Q12bEthnicityDataBean;
import com.servinglynk.report.bean.Q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean;
import com.servinglynk.report.bean.Q13a2NumberOfConditionsAtEntryDataBean;
import com.servinglynk.report.bean.Q13b1PhysicalAndMentalHealthConditionsAtExitDataBean;
import com.servinglynk.report.bean.Q13b2NumberOfConditionsAtExitDataBean;
import com.servinglynk.report.bean.Q13c1PhysicalAndMentalHealthConditionsForStayersDataBean;
import com.servinglynk.report.bean.Q13c2NumberOfConditionsForStayerDataBean;
import com.servinglynk.report.bean.Q14aDomesticViolenceHistoryDataBean;
import com.servinglynk.report.bean.Q14bPersonsFleeingDomesticViolenceDataBean;
import com.servinglynk.report.bean.Q15ResidencePriorToProgramEntryDataBean;
import com.servinglynk.report.bean.Q16CashIncomeRangesDataBean;
import com.servinglynk.report.bean.Q17CashIncomeSourcesDataBean;
import com.servinglynk.report.bean.Q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean;
import com.servinglynk.report.bean.Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean;
import com.servinglynk.report.bean.Q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean;
import com.servinglynk.report.bean.Q20aTypeOfNonCashBenefitSourcesDataBean;
import com.servinglynk.report.bean.Q20bNumberOfNonCashBenefitSourcesDataBean;
import com.servinglynk.report.bean.Q21HealthInsuranceDataBean;
import com.servinglynk.report.bean.Q22a1LengthOfParticipationCoCProjectsDataBean;
import com.servinglynk.report.bean.Q22a2LengthOfParticipationESGProjectsDataBean;
import com.servinglynk.report.bean.Q22bAverageAndMedianLengthOfParticipationInDaysDataBean;
import com.servinglynk.report.bean.Q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBean;
import com.servinglynk.report.bean.Q22dLengthOfParticipationByHouseholdTypeDataBean;
import com.servinglynk.report.bean.Q23aExitDestinationMoreThan90DaysDataBean;
import com.servinglynk.report.bean.Q23bExitDestination90DaysOrLessDataBean;
import com.servinglynk.report.bean.Q23cDataBean;
import com.servinglynk.report.bean.Q24HomelessnessPreventionHousingAssessmentAtExitDataBean;
import com.servinglynk.report.bean.Q25aNumberOfVeteransDataBean;
import com.servinglynk.report.bean.Q25bNumberOfVeteranHouseholdsDataBean;
import com.servinglynk.report.bean.Q25cGenderVeteransDataBean;
import com.servinglynk.report.bean.Q25dAgeVeteransDataBean;
import com.servinglynk.report.bean.Q25ePhysicalAndMentalHealthConditionsVeteransDataBean;
import com.servinglynk.report.bean.Q25fCashIncomeCategoryIncomeCategoryByEntryDataBean;
import com.servinglynk.report.bean.Q25gTypeOfCashIncomeSourcesVeteransDataBean;
import com.servinglynk.report.bean.Q25hTypeOfNonCashIncomeSourcesVeteransDataBean;
import com.servinglynk.report.bean.Q25iExitDestinationVeteransDataBean;
import com.servinglynk.report.bean.Q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean;
import com.servinglynk.report.bean.Q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean;
import com.servinglynk.report.bean.Q26cGenderOfChronicallyHomelessPersonDataBean;
import com.servinglynk.report.bean.Q26dAgeOfChronicallyHomelessPersonsDataBean;
import com.servinglynk.report.bean.Q26ePhysicalAndMentalHealthConditionsChronicallyDataBean;
import com.servinglynk.report.bean.Q26fClientCashIncomeChronicallyHomelessPersonsDataBean;
import com.servinglynk.report.bean.Q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean;
import com.servinglynk.report.bean.Q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean;
import com.servinglynk.report.bean.Q27aAgeOfYouthDataBean;
import com.servinglynk.report.bean.Q27bParentingYouthDataBean;
import com.servinglynk.report.bean.Q27cGenderYouthDataBean;
import com.servinglynk.report.bean.Q27dResidencePriorToEntryYouthDataBean;
import com.servinglynk.report.bean.Q27eLengthOfParticipationYouthDataBean;
import com.servinglynk.report.bean.Q27fExitDestinationYouthDataBean;
import com.servinglynk.report.bean.Q27gCashIncomeSourcesDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.csvcontroller.CSVGenerator;
import com.servinglynk.report.model.ClientModel;
import com.servinglynk.report.model.EnrollmentModel;
import com.servinglynk.report.model.ExitModel;
import com.servinglynk.report.model.ProjectModel;

public class HomePageDataBeanMaker extends BaseBeanMaker {
	
			public static List<HomePageDataBean> getHomePageDataList(ReportConfig reportConfig,Properties props){
				
			HomePageDataBean homePageDataBean = new HomePageDataBean();
			
			ReportData data = new ReportData();
			data.setLiveMode(true);
			data.setReportStartDate(reportConfig.getStartDate());
			data.setReportEndDate(reportConfig.getEndDate());
			data.setConfigPath(props.APR_CONFIG_LOCATION);
			homePageDataBean.setHomePageProjects("APR - Services Only");
			homePageDataBean.setHomePageHomeLess("Everyone");
			homePageDataBean.setHomePageGrants("all grants");
			homePageDataBean.setHomePageView("Aggregate / summary");
			homePageDataBean.setQ04aHmisProjectIdService(BigInteger.valueOf(240));
			homePageDataBean.setQ04aIdentityProjectId(BigInteger.valueOf(0));
			data.setSageReport(reportConfig.isSageReport());
			data.setSchema(reportConfig.getProjectGroupCode());	
			List<ProjectModel> projects = new ArrayList<>();
			String schema = reportConfig.getProjectGroupCode();
			String cocId = reportConfig.getCocId();
			List<String> projectList = reportConfig.getProjectds();
			if(data.isLiveMode()) {
				try {
					if(StringUtils.isNotBlank(reportConfig.getCocId())) {
						projects = getProjectsByCoc(schema,cocId);
					}else {
						projects = getProjects(schema,projectList);
					}
					List<String> projectDatas = new ArrayList<>();
					for(ProjectModel project : projects) {
						if(project != null && StringUtils.isNotBlank(project.getProjectId())) {
							projectDatas.add(project.getProjectId());
						}
					}
					data.setProjects(projects);
					data.setProjectIds(projectDatas);
					
					List<EnrollmentModel> enrollments =  new ArrayList<>();
					if(StringUtils.isNotBlank(cocId)) {
						enrollments = getEnrollmentsByCocId(schema, cocId,data);
					}else {
						enrollments = getEnrollmentsByProjectcId(schema, projectList,data);
					}
					
					data.setProjectId(cocId);
					data.setEnrollments(enrollments);
					
					List<ClientModel> allClients = getClients(schema,data);
					List<String> enrollmentIds = new ArrayList<String>(); 
					if(CollectionUtils.isNotEmpty(enrollments)) {
						for(EnrollmentModel enrollment : enrollments) {
							enrollment.setCurrentLivingSituation("KLM");
							enrollmentIds.add(enrollment.getProjectEntryID());
						}
					}
				//	enrollments.forEach(enrollment -> { enrollmentIds.add(enrollment.getProjectEntryID());});
					
					data.setClients(allClients);
					List<ExitModel> allExits = getAllExits(schema, data);
					List<ExitModel> filteredExits = allExits.parallelStream().filter(exit -> enrollmentIds.contains(exit.getProjectEntryID())).collect(Collectors.toList());
					data.setExits(filteredExits);
				
				}catch(Exception e) {
					
				}
			}
			
			if(CollectionUtils.isNotEmpty(projects)) {
				List<Q04aDataBean> q04aDataBeanList = Q04aBeanMaker.getQ04aDataBeanList(schema,projects.get(0).getProjectId(),data);
				CSVGenerator.buildReport(q04aDataBeanList, "Q4a-1.jrxml", "Q4a.csv",data);
			}else {
				List<Q04aDataBean> q04aDataBeanList = Q04aBeanMaker.getQ04aDataBeanList(schema,null,data);
				CSVGenerator.buildReport(q04aDataBeanList, "Q4a-1.jrxml", "Q4a.csv",data);
			}
			
			
//			data.setTotNumOfPersonServed(BigInteger.valueOf(15));  //Refers --> Total number of persons served 
//			data.setNumOfAdults(BigInteger.valueOf(11)); //Refers --> Number of adults (age 18 or over)
//			data.setNumOfChildren(BigInteger.valueOf(4)); //Refers --> Number of children (under age 18)
//			data.setNumOfPersonsWithUnknownAge(BigInteger.valueOf(0)); // Refers --> Number of persons with unknown age
//			data.setTotNoOfAdultLeavers(BigInteger.valueOf(3)); //Refers --> Number of adult leavers
//			data.setNumOfAdultandHeadOfHHLeavers(BigInteger.valueOf(3)); // Refers --> Number of adult and head of household leavers
//			data.setTotNoOfAdultStayers(BigInteger.valueOf(8)); // Refers --> Number of adult stayers
//			data.setNoOfChronicallyHomelessPersons(BigInteger.valueOf(0)); // Refers --> Number of chronically homeless persons
//			data.setNumOfYouthUnderAge25(BigInteger.valueOf(0)); // Refers --> Number of youth under age 25
//			data.setNumOfParentingYouthUnderAge25WithChildren(BigInteger.valueOf(0)); // Refers --> Number of parenting youth under age 25 with children
//			data.setNoOfAdultHeadsOfHousehold(BigInteger.valueOf(10)); //Refers --> Number of adult heads of household
//			data.setNoOfChildHeadsOfHousehold(BigInteger.valueOf(0)); // Refers --> Number of child and unknown-age Heads of household
//			data.setNumOfHeadsOfHHandAdults365Days(BigInteger.valueOf(1)); // Refers --> Heads of households and adult stayers in the project 365 days or more
//			
			/*List<Q05aHMISComparableDBDataQualityDataBean> q05aHMISCDDQDataList = Q05aBeanMaker.getQ05aReportValidationsTableList(data);
			homePageDataBean.setQ05aHMISComparableDBDataQualityDataBean(q05aHMISCDDQDataList);
			if(q05aHMISCDDQDataList != null) {
				CSVGenerator.buildReport(q05aHMISCDDQDataList, "Q5a.jrxml", "Q5a.csv");
			}*/
			boolean skipReports =true;
			
			List<Q05aHMISComparableDBDataQualityDataBean> q05aHMISCDDQDataList = Q05aBeanMaker.getQ05aBeanData(data);
			homePageDataBean.setQ05aHMISComparableDBDataQualityDataBean(q05aHMISCDDQDataList);
			CSVGenerator.buildReport(q05aHMISCDDQDataList, "Q5a.jrxml", "Q5a.csv",data);
			
			List<Q06aReportValidationsTableDataBean> q06aReportValidationsTableList = Q06aBeanMaker.getBeanData(data);
			CSVGenerator.buildReport(q06aReportValidationsTableList, "Q6a.jrxml", "Q6a.csv",data);
			homePageDataBean.setQ06aReportValidationsTableDataBean(q06aReportValidationsTableList);
			
			List<Q06bNumberOfPersonsServedDataBean> q06bNumberOfPersonsServedTableList = Q06bBeanMaker.getQ06bNumberOfPersonsServedTableList(data);
			CSVGenerator.buildReport(q06bNumberOfPersonsServedTableList, "Q6b.jrxml", "Q6b.csv",data);
			homePageDataBean.setQ06bNumberOfPersonsServedDataBean(q06bNumberOfPersonsServedTableList);
			
			List<Q06cPointInTimeCountPersonsLastWednesdayDataBean> q06cPointInTimeCountPersonsLastWednesdayList = Q06cBeanMaker.getQ06cPointInTimeCountPersonsLastWednesdayList(data);
			homePageDataBean.setQ06cPointInTimeCountPersonsLastWednesdayDataBean(q06cPointInTimeCountPersonsLastWednesdayList);
			CSVGenerator.buildReport(q06cPointInTimeCountPersonsLastWednesdayList, "Q6c.jrxml", "Q6c.csv",data);
			
			List<Q06dDataBean> q06dDataBeanList = Q06dDataBeanMaker.getQ06DataBeanList(data);
			homePageDataBean.setQ06dDataBean(q06dDataBeanList);
			CSVGenerator.buildReport(q06dDataBeanList, "Q6d.jrxml", "Q6d.csv",data);
			
			List<Q06eDataBean> q06eDataBeanList = Q06eDataBeanMaker.getQ06eDataBeanList(data);
			homePageDataBean.setQ06eDataBean(q06eDataBeanList);
			CSVGenerator.buildReport(q06eDataBeanList, "Q6e.jrxml", "Q6e.csv",data);
			
			List<Q06fDataBean> q06fDataBeanList = Q06fDataBeanMaker.getQ06fDataBeanList(data);
			homePageDataBean.setQ06fDataBean(q06fDataBeanList);
			CSVGenerator.buildReport(q06fDataBeanList, "Q6f.jrxml", "Q6f.csv",data);
	

			List<Q07aHouseholdsServedDataBean> q07aHouseholdsServeList = Q07aBeanMaker.getQ07aHouseholdsServeList(data);
			homePageDataBean.setQ07aHouseholdsServedDataBean(q07aHouseholdsServeList);
			CSVGenerator.buildReport(q07aHouseholdsServeList, "Q7a.jrxml", "Q7a.csv",data);
			if(skipReports) {
			List<Q07bPointInTimeCountHouseholdsLastWednesdayDataBean> q07bPointInTimeCountHouseholdsLastWednesdayList = Q07bBeanMaker.getQ07bPointInTimeCountHouseholdsLastWednesdayList(data);
			homePageDataBean.setQ07bPointInTimeCountHouseholdsLastWednesdayDataBean(q07bPointInTimeCountHouseholdsLastWednesdayList);
			CSVGenerator.buildReport(q07bPointInTimeCountHouseholdsLastWednesdayList, "Q7b.jrxml", "Q7b.csv",data);
			
			List<Q08aDataBean> q08aDataBeanList = Q08aDataBeanMaker.getQ08aDataBeanList(data);
			homePageDataBean.setQ08aDataBean(q08aDataBeanList);
			CSVGenerator.buildReport(q08aDataBeanList, "Q8a.jrxml", "Q8a.csv",data);
			
			List<Q08bDataBean> q08bDataBeanList = Q08bDataBeanMaker.getQ08bDataBeanList(data);
			homePageDataBean.setQ08bDataBean(q08bDataBeanList);
			CSVGenerator.buildReport(q08bDataBeanList, "Q8b.jrxml", "Q8b.csv",data);
			
			List<Q09aNumberPersonsContactedDataBean> q09aNumberPersonsContactedList = Q09aDataBeanMaker.getQ09aNumberPersonsContactedList(data);
			homePageDataBean.setQ09aNumberPersonsContactedDataBean(q09aNumberPersonsContactedList);
			CSVGenerator.buildReport(q09aNumberPersonsContactedList, "Q9a.jrxml", "Q9a.csv",data);
			
			List<Q09bNumberofPersonsEngagedDataBean> q09bNumberofPersonsEngagedList = Q09bBeanMaker.getQ09bNumberofPersonsEngagedList(data);
			homePageDataBean.setQ09bNumberofPersonsEngagedDataBean(q09bNumberofPersonsEngagedList);
			CSVGenerator.buildReport(q09bNumberofPersonsEngagedList, "Q9b.jrxml", "Q9b.csv",data);
			
			List<Q10aGenderOfAdultsDataBean> q10AGenderOfAdultsList = Q10aBeanMaker.getQ10AGenderOfAdultsList(data);
			homePageDataBean.setQ10aGenderOfAdultsDataBean(q10AGenderOfAdultsList);
			CSVGenerator.buildReport(q10AGenderOfAdultsList, "q10a.jrxml", "Q10a.csv",data);
			
			List<Q10bGenderOfChildrenDataBean> q10bGenderOfChildrenList = Q10bBeanMaker.getQ10bGenderOfChildrenList(data);
			homePageDataBean.setQ10bGenderOfChildrenDataBean(q10bGenderOfChildrenList);
			CSVGenerator.buildReport(q10bGenderOfChildrenList, "q10b.jrxml","Q10b.csv",data);
			
			List<Q10cGenderOfPersonsMissingAgeInformationDataBean> q10CGPMIList= Q10cBeanMaker.getQ10CGPMIList(data);
			homePageDataBean.setQ10cGenderOfPersonsMissingAgeInformationDataBean(q10CGPMIList);
			CSVGenerator.buildReport(q10CGPMIList, "q10c.jrxml","Q10c.csv",data);
			if(1==2) {
				List<Q10dGenderByAgeRangesDataBean> q10dGPMIList= Q10dBeanMaker.getQ10DGARList(data);
				homePageDataBean.setQ10dGenderByAgeRangesDataBean(q10dGPMIList);
				CSVGenerator.buildReport(q10dGPMIList, "Q10d.jrxml","Q10d.csv",data);
				
			}
		
			List<Q11AgeDataBean> q11AgeList = Q11BeanMaker.getQ11AgeList(data);
			homePageDataBean.setQ11AgeDataBean(q11AgeList);
			CSVGenerator.buildReport(q11AgeList, "q11.jrxml", "Q11.csv",data);
			
			List<Q12aRaceDataBean> q12aRaceList = Q12aBeanMaker.getQ12aRaceList(data);
			homePageDataBean.setQ12aRaceDataBean(q12aRaceList);
			CSVGenerator.buildReport(q12aRaceList, "q12a.jrxml", "Q12a.csv",data);
			
			List<Q12bEthnicityDataBean> q12bEthnicityList = Q12bBeanMaker.getQ12bEthnicityList(data);
			homePageDataBean.setQ12bEthnicityDataBean(q12bEthnicityList);
			CSVGenerator.buildReport(q12bEthnicityList, "q12b.jrxml", "Q12b.csv",data);
			
			List<Q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean> q13a1PhysicalAndMentalHealthConditionsAtEntryList= Q13a1BeanMaker.getQ13a1PhysicalAndMentalHealthConditionsAtEntryList(data);
			homePageDataBean.setQ13a1PhysicalAndMentalHealthConditionsAtEntryDataBean(q13a1PhysicalAndMentalHealthConditionsAtEntryList);
			CSVGenerator.buildReport(q13a1PhysicalAndMentalHealthConditionsAtEntryList, "q13a1.jrxml", "Q13a1.csv",data);
			
			List<Q13a2NumberOfConditionsAtEntryDataBean> q13a2NumberOfConditionsAtEntryList= Q13a2BeanMaker.getQ13a2NumberOfConditionsAtEntryList(data);
			homePageDataBean.setQ13a2NumberOfConditionsAtEntryDataBean(q13a2NumberOfConditionsAtEntryList);
			CSVGenerator.buildReport(q13a2NumberOfConditionsAtEntryList, "q13a2.jrxml", "Q13a2.csv",data);
			
			List<Q13b1PhysicalAndMentalHealthConditionsAtExitDataBean> q13b1PhysicalAndMentalHealthConditionsAtExitList = Q13b1BeanMaker.getQ13b1PhysicalAndMentalHealthConditionsAtExitList(data);
			homePageDataBean.setQ13b1PhysicalAndMentalHealthConditionsAtExitDataBean(q13b1PhysicalAndMentalHealthConditionsAtExitList);
			CSVGenerator.buildReport(q13b1PhysicalAndMentalHealthConditionsAtExitList, "q13b1.jrxml", "Q13b1.csv",data);
			
			List<Q13b2NumberOfConditionsAtExitDataBean> q13b2NumberOfConditionsAtExitList = Q13b2BeanMaker.getQ13b2NumberOfConditionsAtExitList(data);
			homePageDataBean.setQ13b2NumberOfConditionsAtExitDataBean(q13b2NumberOfConditionsAtExitList);
			CSVGenerator.buildReport(q13b2NumberOfConditionsAtExitList,"q13b2.jrxml","Q13b2.csv",data);
			
			List<Q13c1PhysicalAndMentalHealthConditionsForStayersDataBean> q13c1PhysicalAndMentalHealthConditionsForStayersList = Q13c1BeanMaker.getQ13c1PhysicalAndMentalHealthConditionsForStayersList(data);
			homePageDataBean.setQ13c1PhysicalAndMentalHealthConditionsForStayersDataBean(q13c1PhysicalAndMentalHealthConditionsForStayersList);
			CSVGenerator.buildReport(q13c1PhysicalAndMentalHealthConditionsForStayersList, "q13c1.jrxml", "Q13c1.csv",data);
			
			List<Q13c2NumberOfConditionsForStayerDataBean> q13c2NumberOfConditionsForStayerList = Q13c2BeanMaker.getQ13c2NumberOfConditionsForStayerList(data);
			homePageDataBean.setQ13c2NumberOfConditionsForStayerDataBean(q13c2NumberOfConditionsForStayerList);
			CSVGenerator.buildReport(q13c2NumberOfConditionsForStayerList, "q13c2.jrxml","Q13c2.csv",data);
			
			List<Q14aDomesticViolenceHistoryDataBean> q14aDomesticViolenceHistoryList= Q14aBeanMaker.getQ14aDomesticViolenceHistoryList(data);
			homePageDataBean.setQ14aDomesticViolenceHistoryDataBean(q14aDomesticViolenceHistoryList);
			CSVGenerator.buildReport(q14aDomesticViolenceHistoryList, "q14a.jrxml", "Q14a.csv",data);
			
			List<Q14bPersonsFleeingDomesticViolenceDataBean> q14bPersonsFleeingDomesticViolenceList = Q14bBeanMaker.getQ14bPersonsFleeingDomesticViolenceList(data);
			homePageDataBean.setQ14bPersonsFleeingDomesticViolenceDataBean(q14bPersonsFleeingDomesticViolenceList);
			CSVGenerator.buildReport(q14bPersonsFleeingDomesticViolenceList, "q14b.jrxml", "Q14b.csv",data);
			
			List<Q15ResidencePriorToProgramEntryDataBean> q15ResidencePriorToProgramEntryList = Q15BeanMaker.getQ15ResidencePriorToProgramEntryList(data);
			homePageDataBean.setQ15ResidencePriorToProgramEntryDataBean(q15ResidencePriorToProgramEntryList);
			CSVGenerator.buildReport(q15ResidencePriorToProgramEntryList,"q15.jrxml", "Q15.csv",data);
			
			List<Q16CashIncomeRangesDataBean> q16CashIncomeRangesList = Q16BeanMaker.getQ16CashIncomeRangesList(data);
			homePageDataBean.setQ16CashIncomeRangesDataBean(q16CashIncomeRangesList);
			CSVGenerator.buildReport(q16CashIncomeRangesList, "q16.jrxml", "Q16.csv",data);		
			
			List<Q17CashIncomeSourcesDataBean> q17CashIncomeSourcesList= Q17DataBeanMaker.getQ17CashIncomeSourcesList(data);
			homePageDataBean.setQ17CashIncomeSourcesDataBean(q17CashIncomeSourcesList);
			CSVGenerator.buildReport(q17CashIncomeSourcesList, "q17.jrxml","Q17.csv",data);
			
			List<Q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean> q18ClientCashIncomeCategoryEarnedOtherIncomeList= Q18DataBeanMaker.getQ18ClientCashIncomeCategoryEarnedOtherIncomeList(data);
			homePageDataBean.setQ18ClientCashIncomeCategoryEarnedOtherIncomeDataBean(q18ClientCashIncomeCategoryEarnedOtherIncomeList);
			CSVGenerator.buildReport(q18ClientCashIncomeCategoryEarnedOtherIncomeList, "q18.jrxml","Q18.csv",data);
			}
			List<Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean> q19a1ClientCashIncomeChangeIncomeSourceEntryDataBeanList = Q19a1DataBeanMaker.getQ19a1ClientCashIncomeChangeIncomeSourceEntryDataBeanList(data);
			homePageDataBean.setQ19a1ClientCashIncomeChangeIncomeSourceEntryDataBean(q19a1ClientCashIncomeChangeIncomeSourceEntryDataBeanList);
			CSVGenerator.buildReport(q19a1ClientCashIncomeChangeIncomeSourceEntryDataBeanList, "q19a1.jrxml", "Q19a1.csv",data);
			
			List<Q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean> q19a2ClientCashIncomeChangeIncomeSourceByEntryList = Q19a2DataBeanMaker.getQ19a2ClientCashIncomeChangeIncomeSourceByEntryList(data);
			homePageDataBean.setQ19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean(q19a2ClientCashIncomeChangeIncomeSourceByEntryList);
			CSVGenerator.buildReport(q19a2ClientCashIncomeChangeIncomeSourceByEntryList, "q19a2.jrxml", "Q19a2.csv",data);
			

			List<Q20aTypeOfNonCashBenefitSourcesDataBean> q20aTypeOfNonCashBenefitSourcesList = Q20aBeanMaker.getQ20aTypeOfNonCashBenefitSourcesList(data);
			homePageDataBean.setQ20aTypeOfNonCashBenefitSourcesDataBean(q20aTypeOfNonCashBenefitSourcesList);
			CSVGenerator.buildReport(q20aTypeOfNonCashBenefitSourcesList, "q20a.jrxml", "Q20a.csv",data);
			
			List<Q20bNumberOfNonCashBenefitSourcesDataBean> q20bNumberOfNonCashBenefitSourcesList= Q20bBeanMaker.getQ20bNumberOfNonCashBenefitSourcesList(data);
	        homePageDataBean.setQ20bNumberOfNonCashBenefitSourcesDataBean(q20bNumberOfNonCashBenefitSourcesList);
	        CSVGenerator.buildReport(q20bNumberOfNonCashBenefitSourcesList, "q20b.jrxml", "Q20b.csv",data);
			
	        List<Q21HealthInsuranceDataBean> q21HealthInsuranceList= Q21BeanMaker.getQ21HealthInsuranceList(data);
	        homePageDataBean.setQ21HealthInsuranceDataBean(q21HealthInsuranceList);
	        CSVGenerator.buildReport(q21HealthInsuranceList, "q21.jrxml","Q21.csv",data);
		
	        List<Q22a1LengthOfParticipationCoCProjectsDataBean> q22a1LengthOfParticipationCoCProjectsList = Q22a1BeanMaker.getQ22a1LengthOfParticipationCoCProjectsList(data);
			homePageDataBean.setQ22a1LengthOfParticipationCoCProjectsDataBean(q22a1LengthOfParticipationCoCProjectsList);
			CSVGenerator.buildReport(q22a1LengthOfParticipationCoCProjectsList,"q22a1.jrxml","Q22a1.csv",data);
			if(1==2) {
				List<Q22a2LengthOfParticipationESGProjectsDataBean> q22a2LengthOfParticipationESGProjectsDataBeanList = Q22a2BeanMaker.getQ22a2LengthOfParticipationESGProjectsList(data);
				homePageDataBean.setQ22a2LengthOfParticipationESGProjectsDataBean(q22a2LengthOfParticipationESGProjectsDataBeanList);
				CSVGenerator.buildReport(q22a2LengthOfParticipationESGProjectsDataBeanList,"Q22a2.jrxml","Q22a2.csv",data);
			}
			
			
			List<Q22bAverageAndMedianLengthOfParticipationInDaysDataBean> q22bAverageAndMedianLengthOfParticipationInDaysList = Q22bAverageAndMedianLengthOfParticipationInDaysDataBeanMaker.getQ22bAverageAndMedianLengthOfParticipationInDaysList(data);
			homePageDataBean.setQ22bAverageAndMedianLengthOfParticipationInDaysDataBean(q22bAverageAndMedianLengthOfParticipationInDaysList);
			CSVGenerator.buildReport(q22bAverageAndMedianLengthOfParticipationInDaysList,"q22b.jrxml","Q22b.csv",data);
			
			List<Q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBean> q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBeanList = Q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBeanMaker.getQ22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBeanList(data);
			homePageDataBean.setQ22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBean(q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBeanList);
			CSVGenerator.buildReport(q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBeanList,"Q22c.jrxml","Q22c.csv",data);

			if(1==2) {
			List<Q22dLengthOfParticipationByHouseholdTypeDataBean> q22dLengthOfParticipationByHouseholdTypeDataBeanList = Q22dLengthOfParticipationByHouseholdTypeDataBeanMaker.getQ22dLengthOfParticipationByHouseholdTypeDataBeanList(data);
			homePageDataBean.setQ22dLengthOfParticipationByHouseholdTypeDataBean(q22dLengthOfParticipationByHouseholdTypeDataBeanList);
			CSVGenerator.buildReport(q22dLengthOfParticipationByHouseholdTypeDataBeanList,"Q22d.jrxml","Q22d.csv",data);
			}
			
			List<Q23aExitDestinationMoreThan90DaysDataBean> q23ExitDestinationMoreThan90DaysList = Q23aExitDestinationMoreThan90DaysDataBeanMaker.getQ23ExitDestinationMoreThan90DaysList(data);
			homePageDataBean.setQ23ExitDestinationMoreThan90DaysDataBean(q23ExitDestinationMoreThan90DaysList);
			CSVGenerator.buildReport(q23ExitDestinationMoreThan90DaysList, "q23a.jrxml","Q23a.csv",data);
			
			List<Q23bExitDestination90DaysOrLessDataBean> q23bExitDestination90DaysOrLessList= Q23bExitDestination90DaysOrLessDataBeanMaker.getQ23bExitDestination90DaysOrLessList(data);
			homePageDataBean.setQ23bExitDestination90DaysOrLessDataBean(q23bExitDestination90DaysOrLessList);
			CSVGenerator.buildReport(q23bExitDestination90DaysOrLessList, "q23b.jrxml","Q23b.csv",data);
			
			List<Q23cDataBean> q23cBeanList = Q23cBeanMaker.getQ23cList(data);
			homePageDataBean.setQ23cDataBean(q23cBeanList);
			CSVGenerator.buildReport(q23bExitDestination90DaysOrLessList, "q23c.jrxml","Q23c.csv",data);
			
			if(1==2) {
				List<Q24HomelessnessPreventionHousingAssessmentAtExitDataBean> q24HomelessnessPreventionHousingAssessmentAtExitList= Q24HomelessnessPreventionHousingAssessmentAtExitDataBeanMaker.getQ24HomelessnessPreventionHousingAssessmentAtExitList(data);
				homePageDataBean.setQ24HomelessnessPreventionHousingAssessmentAtExitDataBean(q24HomelessnessPreventionHousingAssessmentAtExitList);
				CSVGenerator.buildReport(q24HomelessnessPreventionHousingAssessmentAtExitList, "q24.jrxml","Q24.csv",data);
			}
		
			List<Q25aNumberOfVeteransDataBean> q25aNumberOfVeteransList = Q25aNumberOfVeteransDataBeanMaker.getQ25aNumberOfVeteransList(data);	
			homePageDataBean.setQ25aNumberOfVeteransDataBean(q25aNumberOfVeteransList);
			CSVGenerator.buildReport(q25aNumberOfVeteransList, "q25a.jrxml","Q25a.csv",data);
			
			List<Q25bNumberOfVeteranHouseholdsDataBean> q25bNumberOfVeteranHouseholdsList= Q25bNumberOfVeteranHouseholdsDataBeanMaker.getQ25bNumberOfVeteranHouseholdsList(data);
			homePageDataBean.setQ25bNumberOfVeteranHouseholdsDataBean(q25bNumberOfVeteranHouseholdsList);
			CSVGenerator.buildReport(q25bNumberOfVeteranHouseholdsList, "q25b.jrxml","Q25b.csv",data);
		
			List<Q25cGenderVeteransDataBean> q25cGenderVeteransList = Q25cGenderVeteransDataBeanMaker.getQ25cGenderVeteransList(data);
			homePageDataBean.setQ25cGenderVeteransDataBean(q25cGenderVeteransList);
			CSVGenerator.buildReport(q25cGenderVeteransList, "q25c.jrxml","Q25c.csv",data);
			
			List<Q25dAgeVeteransDataBean> q25dAgeVeteransList = Q25dAgeVeteransDataBeanMaker.getQ25dAgeVeteransList(data);
			homePageDataBean.setQ25dAgeVeteransDataBean(q25dAgeVeteransList);
			CSVGenerator.buildReport(q25dAgeVeteransList, "q25d.jrxml","Q25d.csv",data);
		
			List<Q25ePhysicalAndMentalHealthConditionsVeteransDataBean> q25ePhysicalAndMentalHealthConditionsVeteransList = Q25ePhysicalAndMentalHealthConditionsVeteransDataBeanMaker.getQ25ePhysicalAndMentalHealthConditionsVeteransList(data);
			homePageDataBean.setQ25ePhysicalAndMentalHealthConditionsVeteransDataBean(q25ePhysicalAndMentalHealthConditionsVeteransList);
			CSVGenerator.buildReport(q25ePhysicalAndMentalHealthConditionsVeteransList, "q25e.jrxml","Q25e.csv",data);
		
			List<Q25fCashIncomeCategoryIncomeCategoryByEntryDataBean> q25fCashIncomeCategoryIncomeCategoryByEntryList = Q25fCashIncomeCategoryIncomeCategoryByEntryDataBeanMaker.getQ25fCashIncomeCategoryIncomeCategoryByEntryList(data);
			homePageDataBean.setQ25fCashIncomeCategoryIncomeCategoryByEntryDataBean(q25fCashIncomeCategoryIncomeCategoryByEntryList);
			CSVGenerator.buildReport(q25fCashIncomeCategoryIncomeCategoryByEntryList, "q25f.jrxml","Q25f.csv",data);
			
			List<Q25gTypeOfCashIncomeSourcesVeteransDataBean> q25gTypeOfCashIncomeSourcesVeteranList = Q25gTypeOfCashIncomeSourcesVeteransDataBeanMaker.getQ25gTypeOfCashIncomeSourcesVeteranList(data);
			homePageDataBean.setQ25gTypeOfCashIncomeSourcesVeteransDataBean(q25gTypeOfCashIncomeSourcesVeteranList);
			CSVGenerator.buildReport(q25gTypeOfCashIncomeSourcesVeteranList, "q25g.jrxml","Q25g.csv",data);
			
			List<Q25hTypeOfNonCashIncomeSourcesVeteransDataBean> q25hTypeOfNonCashIncomeSourcesVeteransList = Q25hTypeOfNonCashIncomeSourcesVeteransDataBeanMaker.getQ25hTypeOfNonCashIncomeSourcesVeteransList(data);
			homePageDataBean.setQ25hTypeOfNonCashIncomeSourcesVeteransDataBean(q25hTypeOfNonCashIncomeSourcesVeteransList);
			CSVGenerator.buildReport(q25hTypeOfNonCashIncomeSourcesVeteransList, "q25h.jrxml","Q25h.csv",data);
			
			List<Q25iExitDestinationVeteransDataBean> q25iExitDestinationVeteransList = Q25iExitDestinationVeteransDataBeanMaker.getQ25iExitDestinationVeteransList(data);
			homePageDataBean.setQ25iExitDestinationVeteransDataBean(q25iExitDestinationVeteransList);
			CSVGenerator.buildReport(q25iExitDestinationVeteransList, "q25i.jrxml","Q25i.csv",data);
			
			List<Q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean> q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyList = Q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBeanMaker.getQ26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyList(data);
			homePageDataBean.setQ26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean(q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyList);
			CSVGenerator.buildReport(q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyList, "q26a.jrxml","Q26a.csv",data);
			
			List<Q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean> q26bNumberOfChronicallyHomelessPersonsByHouseholdList = Q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBeanMaker.getQ26bNumberOfChronicallyHomelessPersonsByHouseholdList(data);
			homePageDataBean.setQ26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean(q26bNumberOfChronicallyHomelessPersonsByHouseholdList);
			CSVGenerator.buildReport(q26bNumberOfChronicallyHomelessPersonsByHouseholdList, "q26b.jrxml","Q26b.csv",data);
			
			List<Q26cGenderOfChronicallyHomelessPersonDataBean> q26cGenderOfChronicallyHomelessPersonList = Q26cGenderOfChronicallyHomelessPersonDataBeanMaker.getQ26cGenderOfChronicallyHomelessPersonList(data);
			homePageDataBean.setQ26cGenderOfChronicallyHomelessPersonDataBean(q26cGenderOfChronicallyHomelessPersonList);
			CSVGenerator.buildReport(q26cGenderOfChronicallyHomelessPersonList, "q26c.jrxml","Q26c.csv",data);
			
			List<Q26dAgeOfChronicallyHomelessPersonsDataBean> q26dAgeOfChronicallyHomelessPersonsList = Q26dAgeOfChronicallyHomelessPersonsDataBeanMaker.getQ26dAgeOfChronicallyHomelessPersonsList(data);
			homePageDataBean.setQ26dAgeOfChronicallyHomelessPersonsDataBean(q26dAgeOfChronicallyHomelessPersonsList);
			CSVGenerator.buildReport(q26dAgeOfChronicallyHomelessPersonsList, "q26d.jrxml","Q26d.csv",data);
			
			List<Q26ePhysicalAndMentalHealthConditionsChronicallyDataBean> q26ePhysicalAndMentalHealthConditionsChronicallyList= Q26ePhysicalAndMentalHealthConditionsChronicallyDataBeanMaker.getQ26ePhysicalAndMentalHealthConditionsChronicallyList(data);
			homePageDataBean.setQ26ePhysicalAndMentalHealthConditionsChronicallyDataBean(q26ePhysicalAndMentalHealthConditionsChronicallyList);
			CSVGenerator.buildReport(q26ePhysicalAndMentalHealthConditionsChronicallyList, "q26e.jrxml","Q26e.csv",data);
			
			List<Q26fClientCashIncomeChronicallyHomelessPersonsDataBean> q26fClientCashIncomeChronicallyHomelessPersonsList= Q26fClientCashIncomeChronicallyHomelessPersonsDataBeanMaker.getQ26fClientCashIncomeChronicallyHomelessPersonsList(data);
			homePageDataBean.setQ26fClientCashIncomeChronicallyHomelessPersonsDataBean(q26fClientCashIncomeChronicallyHomelessPersonsList);
			CSVGenerator.buildReport(q26fClientCashIncomeChronicallyHomelessPersonsList, "q26f.jrxml","Q26f.csv",data);
			
			List<Q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean> q26gTypeOfCashIncomeSourcesChronicallyHomelessList = Q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBeanMaker.getQ26gTypeOfCashIncomeSourcesChronicallyHomelessList(data);
			homePageDataBean.setQ26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean(q26gTypeOfCashIncomeSourcesChronicallyHomelessList);
			CSVGenerator.buildReport(q26gTypeOfCashIncomeSourcesChronicallyHomelessList, "q26g.jrxml","Q26g.csv",data);
			
			List<Q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean> q26hTypeOfNonCashIncomeSourcesChronicallyHomelessList = Q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBeanMaker.getQ26hTypeOfNonCashIncomeSourcesChronicallyHomelessList(data);
			homePageDataBean.setQ26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean(q26hTypeOfNonCashIncomeSourcesChronicallyHomelessList);
			CSVGenerator.buildReport(q26hTypeOfNonCashIncomeSourcesChronicallyHomelessList, "q26h.jrxml","Q26h.csv",data);
			
			List<Q27aAgeOfYouthDataBean> q27aAgeOfYouthList = Q27aAgeOfYouthDataBeanMaker.getQ27aAgeOfYouthList(data);
			homePageDataBean.setQ27aAgeOfYouthDataBean(q27aAgeOfYouthList);
			CSVGenerator.buildReport(q27aAgeOfYouthList, "q27a.jrxml","Q27a.csv",data);
			
			List<Q27bParentingYouthDataBean> q27bParentingYouthList= Q27bParentingYouthDataBeanMaker.getQ27bParentingYouthList(data);
			homePageDataBean.setQ27bParentingYouthDataBean(q27bParentingYouthList);
			CSVGenerator.buildReport(q27bParentingYouthList, "q27b.jrxml","Q27b.csv",data);
			
			List<Q27cGenderYouthDataBean> q27cGenderYouthList = Q27cGenderYouthDataBeanMaker.getQ27cGenderYouthList(data);
			homePageDataBean.setQ27cGenderYouthDataBean(q27cGenderYouthList);
			CSVGenerator.buildReport(q27cGenderYouthList, "q27c.jrxml","Q27c.csv",data);
			
			List<Q27dResidencePriorToEntryYouthDataBean> q27dResidencePriorToEntryYouthList= Q27dResidencePriorToEntryYouthDataBeanMaker.getQ27dResidencePriorToEntryYouthList(data);
			homePageDataBean.setQ27dResidencePriorToEntryYouthDataBean(q27dResidencePriorToEntryYouthList);
			CSVGenerator.buildReport(q27dResidencePriorToEntryYouthList, "q27d.jrxml","Q27d.csv",data);
			
			List<Q27eLengthOfParticipationYouthDataBean> q27eLengthOfParticipationYouthList = Q27eLengthOfParticipationYouthDataBeanMaker.getQ27eLengthOfParticipationYouthList(data);
			homePageDataBean.setQ27eLengthOfParticipationYouthDataBean(q27eLengthOfParticipationYouthList);
			CSVGenerator.buildReport(q27eLengthOfParticipationYouthList, "q27e.jrxml","Q27e.csv",data);
			
			List<Q27fExitDestinationYouthDataBean> q27fExitDestinationYouthList = Q27fExitDestinationYouthDataBeanMaker.getQ27fExitDestinationYouthList(data);
			homePageDataBean.setQ27fExitDestinationYouthDataBean(q27fExitDestinationYouthList);
			CSVGenerator.buildReport(q27fExitDestinationYouthList, "q27f.jrxml","Q27f.csv",data);
			
			List<Q27gCashIncomeSourcesDataBean> q27gCashIncomeSourcesYouthList = Q27gDataBeanMaker.getQ27gTypeOfCashIncomeSourcesYouthList(data);
			homePageDataBean.setQ27gCashIncomeSourcesDataBean(q27gCashIncomeSourcesYouthList);
			CSVGenerator.buildReport(q27fExitDestinationYouthList, "q27g.jrxml","Q27g.csv",data);
			
			return Arrays.asList(homePageDataBean);
	    }
		
}
