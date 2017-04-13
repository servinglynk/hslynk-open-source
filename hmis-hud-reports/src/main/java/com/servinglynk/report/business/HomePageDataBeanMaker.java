package com.servinglynk.report.business;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.servinglynk.hive.connection.HiveConnection;
import com.servinglynk.hive.connection.ReportQuery;
import com.servinglynk.report.bean.ClientModel;
import com.servinglynk.report.bean.EnrollmentModel;
import com.servinglynk.report.bean.ExitModel;
import com.servinglynk.report.bean.HomePageDataBean;
import com.servinglynk.report.bean.Q04aDataBean;
import com.servinglynk.report.bean.Q05aDataBean;
import com.servinglynk.report.bean.Q06aDataBean;
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
import com.servinglynk.report.bean.Q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean;
import com.servinglynk.report.bean.Q20aTypeOfNonCashBenefitSourcesDataBean;
import com.servinglynk.report.bean.Q20bNumberOfNonCashBenefitSourcesDataBean;
import com.servinglynk.report.bean.Q21HealthInsuranceDataBean;
import com.servinglynk.report.bean.Q22a1LengthOfParticipationCoCProjectsDataBean;
import com.servinglynk.report.bean.Q22bAverageAndMedianLengthOfParticipationInDaysDataBean;
import com.servinglynk.report.bean.Q23aExitDestinationMoreThan90DaysDataBean;
import com.servinglynk.report.bean.Q23bExitDestination90DaysOrLessDataBean;
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
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.csvcontroller.CSVGenerator;

public class HomePageDataBeanMaker {
	
			public static List<HomePageDataBean> getHomePageDataList(String schema,String projectId,boolean sageReport){
	       
			HomePageDataBean homePageDataBean = new HomePageDataBean();
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
             
			homePageDataBean.setHomePageStartDate(dateFormat.format(date/*"1/1/2015"*/));
			homePageDataBean.setHomePageEndDate(dateFormat.format(date/*"11/10/2016"*/));
			homePageDataBean.setHomePageProjects("APR - Services Only");
			homePageDataBean.setHomePageHomeLess("Everyone");
			homePageDataBean.setHomePageGrants("all grants");
			homePageDataBean.setHomePageView("Aggregate / summary");
			homePageDataBean.setQ04aHmisProjectIdService(BigInteger.valueOf(240));
			homePageDataBean.setQ04aIdentityProjectId(BigInteger.valueOf(0));
			List<Q04aDataBean> q04aDataBeanList = Q04aBeanMaker.getQ04aDataBeanList(schema,projectId);
			if(sageReport) {
				CSVGenerator.buildReport(q04aDataBeanList, "Q4a.jrxml", "Q4a.csv");
			}
			
			List<EnrollmentModel> enrollments = getEnrollmentsByProjectId(schema, projectId);
			ReportData data = new ReportData();
			data.setSchema(schema);
			data.setProjectId(projectId);
			data.setEnrollments(enrollments);
			List<ClientModel> allClients = getClients(schema);
			List<String> clientIds = new ArrayList<String>(); 
			List<String> enrollmentIds = new ArrayList<String>(); 
			enrollments.parallelStream().forEach(enrollment -> { clientIds.add(enrollment.getPersonalID()); enrollmentIds.add(enrollment.getProjectEntryID());});
			List<ClientModel> clients = allClients.parallelStream().filter(client -> clientIds.contains(client.getPersonalID())).collect(Collectors.toList());
			data.setClients(clients);
			List<ExitModel> allExits = getAllExits(schema);
			List<ExitModel> filteredExits = allExits.parallelStream().filter(exit -> enrollmentIds.contains(exit.getProjectEntryID())).collect(Collectors.toList());
			data.setExits(filteredExits);
			
//			data.setTotNumOfPersonServed(15);  //Refers --> Total number of persons served 
//			data.setNumOfAdults(11); //Refers --> Number of adults (age 18 or over)
//			data.setNumOfChildren(4); //Refers --> Number of children (under age 18)
//			data.setNumOfPersonsWithUnknownAge(0); // Refers --> Number of persons with unknown age
//			data.setTotNoOfAdultLeavers(3); //Refers --> Number of adult leavers
//			data.setNumOfAdultandHeadOfHHLeavers(3); // Refers --> Number of adult and head of household leavers
//			data.setTotNoOfAdultStayers(8); // Refers --> Number of adult stayers
//			data.setNoOfChronicallyHomelessPersons(0); // Refers --> Number of chronically homeless persons
//			data.setNumOfYouthUnderAge25(0); // Refers --> Number of youth under age 25
//			data.setNumOfParentingYouthUnderAge25WithChildren(0); // Refers --> Number of parenting youth under age 25 with children
//			data.setNoOfAdultHeadsOfHousehold(10); //Refers --> Number of adult heads of household
//			data.setNoOfChildHeadsOfHousehold(0); // Refers --> Number of child and unknown-age Heads of household
//			data.setNumOfHeadsOfHHandAdults365Days(1); // Refers --> Heads of households and adult stayers in the project 365 days or more
//			
			List<Q05aDataBean> q05aHMISCDDQDataList = Q05aBeanMaker.getQ05aBeanData(data);
			homePageDataBean.setQ05aHMISComparableDBDataQualityDataBean(q05aHMISCDDQDataList);
			if(q05aHMISCDDQDataList != null) {
				CSVGenerator.buildReport(q05aHMISCDDQDataList, "Q5a.jrxml", "Q5a.csv");
			}
			
			List<Q06aDataBean> q06aReportValidationsTableList = Q06aBeanMaker.getBeanData(data);
			if(q06aReportValidationsTableList != null) {
				CSVGenerator.buildReport(q06aReportValidationsTableList, "Q6a.jrxml", "Q6a.csv");
			}
			homePageDataBean.setQ06aReportValidationsTableDataBean(q06aReportValidationsTableList);
			
			List<Q06bNumberOfPersonsServedDataBean> q06bNumberOfPersonsServedTableList = Q06bBeanMaker.getQ06bNumberOfPersonsServedTableList(data);
			if(q06bNumberOfPersonsServedTableList!=null){
				CSVGenerator.buildReport(q06bNumberOfPersonsServedTableList, "Q6b.jrxml", "Q6b.csv");
			}
			homePageDataBean.setQ06bNumberOfPersonsServedDataBean(q06bNumberOfPersonsServedTableList);
			
			List<Q06cPointInTimeCountPersonsLastWednesdayDataBean> q06cPointInTimeCountPersonsLastWednesdayList = Q06cBeanMaker.getQ06cPointInTimeCountPersonsLastWednesdayList();
			homePageDataBean.setQ06cPointInTimeCountPersonsLastWednesdayDataBean(q06cPointInTimeCountPersonsLastWednesdayList);
			if(q06cPointInTimeCountPersonsLastWednesdayList!=null){
				CSVGenerator.buildReport(q06cPointInTimeCountPersonsLastWednesdayList, "Q6c.jrxml", "Q6c.csv");
			}
			
			List<Q06dDataBean> q06dDataBeanList = Q06dDataBeanMaker.getQ06DataBeanList();
			homePageDataBean.setQ06dDataBean(q06dDataBeanList);
			if(q06dDataBeanList!=null){
				CSVGenerator.buildReport(q06dDataBeanList, "Q6d.jrxml", "Q6d.csv");
			}
			
			List<Q06eDataBean> q06eDataBeanList = Q06eDataBeanMaker.getQ06eDataBeanList();
			homePageDataBean.setQ06eDataBean(q06eDataBeanList);
			if(q06eDataBeanList!=null){
				CSVGenerator.buildReport(q06eDataBeanList, "Q6e.jrxml", "Q6e.csv");
			}
			
			List<Q06fDataBean> q06fDataBeanList = Q06fDataBeanMaker.getQ06fDataBeanList();
			homePageDataBean.setQ06fDataBean(q06fDataBeanList);
			if(q06fDataBeanList!=null){
				CSVGenerator.buildReport(q06fDataBeanList, "Q6f.jrxml", "Q6f.csv");
			}
			
			List<Q07aHouseholdsServedDataBean> q07aHouseholdsServeList = Q07aBeanMaker.getQ07aHouseholdsServeList(data);
			homePageDataBean.setQ07aHouseholdsServedDataBean(q07aHouseholdsServeList);
			if(q07aHouseholdsServeList!=null){
				CSVGenerator.buildReport(q07aHouseholdsServeList, "Q7a.jrxml", "Q7a.csv");
			}
			
			List<Q07bPointInTimeCountHouseholdsLastWednesdayDataBean> q07bPointInTimeCountHouseholdsLastWednesdayList = Q07bBeanMaker.getQ07bPointInTimeCountHouseholdsLastWednesdayList();
			homePageDataBean.setQ07bPointInTimeCountHouseholdsLastWednesdayDataBean(q07bPointInTimeCountHouseholdsLastWednesdayList);
			if(q07bPointInTimeCountHouseholdsLastWednesdayList!=null){
				CSVGenerator.buildReport(q07bPointInTimeCountHouseholdsLastWednesdayList, "Q7b.jrxml", "Q7b.csv");
			}
			
			List<Q08aDataBean> q08aDataBeanList = Q08aDataBeanMaker.getQ08aDataBeanList(data);
			homePageDataBean.setQ08aDataBean(q08aDataBeanList);
			if(q08aDataBeanList!=null){
				CSVGenerator.buildReport(q08aDataBeanList, "Q8a.jrxml", "Q8a.csv");
			}
			
			List<Q08bDataBean> q08bDataBeanList = Q08bDataBeanMaker.getQ08bDataBeanList();
			homePageDataBean.setQ08bDataBean(q08bDataBeanList);
			if(q08bDataBeanList!=null){
				CSVGenerator.buildReport(q08bDataBeanList, "Q8b.jrxml", "Q8b.csv");
			}
			
			List<Q09aNumberPersonsContactedDataBean> q09aNumberPersonsContactedList = Q09aDataBeanMaker.getQ09aNumberPersonsContactedList();
			homePageDataBean.setqQ09aNumberPersonsContactedDataBean(q09aNumberPersonsContactedList);
			if(q09aNumberPersonsContactedList!=null){
				CSVGenerator.buildReport(q09aNumberPersonsContactedList, "Q9a.jrxml", "Q9a.csv");
			}
			
			List<Q09bNumberofPersonsEngagedDataBean> q09bNumberofPersonsEngagedList = Q09bBeanMaker.getQ09bNumberofPersonsEngagedList();
			homePageDataBean.setQ09bNumberofPersonsEngagedDataBean(q09bNumberofPersonsEngagedList);
			if(q09bNumberofPersonsEngagedList!=null){
				CSVGenerator.buildReport(q09bNumberofPersonsEngagedList, "Q9b.jrxml", "Q9b.csv");
			}
			
			List<Q10aGenderOfAdultsDataBean> q10AGenderOfAdultsList = Q10aBeanMaker.getQ10AGenderOfAdultsList(data);
			homePageDataBean.setQ10aGenderOfAdultsDataBean(q10AGenderOfAdultsList);
			if(q10AGenderOfAdultsList!=null){
				CSVGenerator.buildReport(q10AGenderOfAdultsList, "Q10a.jrxml", "Q10a.csv");
			}				
			
			List<Q10bGenderOfChildrenDataBean> q10bGenderOfChildrenList = Q10bBeanMaker.getQ10bGenderOfChildrenList(data);
			homePageDataBean.setQ10bGenderOfChildrenDataBean(q10bGenderOfChildrenList);
			if(q10bGenderOfChildrenList!=null){
				CSVGenerator.buildReport(q10bGenderOfChildrenList, "Q10b.jrxml","Q10b.csv");
			}
			
			List<Q10cGenderOfPersonsMissingAgeInformationDataBean> q10CGPMIList= Q10cBeanMaker.getQ10CGPMIList(data);
			homePageDataBean.setQ10cGenderOfPersonsMissingAgeInformationDataBean(q10CGPMIList);
			if(q10CGPMIList!=null){
				CSVGenerator.buildReport(q10CGPMIList, "Q10c.jrxml","Q10c.csv");
			}
			
			List<Q11AgeDataBean> q11AgeList = Q11BeanMaker.getQ11AgeList(data);
			homePageDataBean.setQ11AgeDataBean(q11AgeList);
			if(q11AgeList!=null){
				CSVGenerator.buildReport(q11AgeList, "Q11.jrxml", "Q11.csv");
			}
			
			List<Q12aRaceDataBean> q12aRaceList = Q12aBeanMaker.getQ12aRaceList(data);
			homePageDataBean.setQ12aRaceDataBean(q12aRaceList);
			if(q12aRaceList!=null){
				CSVGenerator.buildReport(q12aRaceList, "Q12a.jrxml", "Q12a.csv");
			}
			
			List<Q12bEthnicityDataBean> q12bEthnicityList = Q12bBeanMaker.getQ12bEthnicityList(data);
			homePageDataBean.setQ12bEthnicityDataBean(q12bEthnicityList);
			if(q12bEthnicityList!=null){
				CSVGenerator.buildReport(q12bEthnicityList, "Q12b.jrxml", "Q12b.csv");
			}
			
			List<Q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean> q13a1PhysicalAndMentalHealthConditionsAtEntryList= Q13a1BeanMaker.getQ13a1PhysicalAndMentalHealthConditionsAtEntryList();
			homePageDataBean.setQ13a1PhysicalAndMentalHealthConditionsAtEntryDataBean(q13a1PhysicalAndMentalHealthConditionsAtEntryList);
			if(q13a1PhysicalAndMentalHealthConditionsAtEntryList!=null){
				CSVGenerator.buildReport(q13a1PhysicalAndMentalHealthConditionsAtEntryList, "Q13a1.jrxml", "Q13a1.csv");
			}
			
			List<Q13a2NumberOfConditionsAtEntryDataBean> q13a2NumberOfConditionsAtEntryList= Q13a2BeanMaker.getQ13a2NumberOfConditionsAtEntryList(data);
			homePageDataBean.setQ13a2NumberOfConditionsAtEntryDataBean(q13a2NumberOfConditionsAtEntryList);
			if(q13a2NumberOfConditionsAtEntryList!=null){
				CSVGenerator.buildReport(q13a2NumberOfConditionsAtEntryList, "Q13a2.jrxml", "Q13a2.csv");
			}
			
			List<Q13b1PhysicalAndMentalHealthConditionsAtExitDataBean> q13b1PhysicalAndMentalHealthConditionsAtExitList = Q13b1BeanMaker.getQ13b1PhysicalAndMentalHealthConditionsAtExitList();
			homePageDataBean.setQ13b1PhysicalAndMentalHealthConditionsAtExitDataBean(q13b1PhysicalAndMentalHealthConditionsAtExitList);
			if(q13b1PhysicalAndMentalHealthConditionsAtExitList!=null){
				CSVGenerator.buildReport(q13b1PhysicalAndMentalHealthConditionsAtExitList, "Q13b1.jrxml", "Q13b1.csv");
			}
			
			List<Q13b2NumberOfConditionsAtExitDataBean> q13b2NumberOfConditionsAtExitList = Q13b2BeanMaker.getQ13b2NumberOfConditionsAtExitList(data);
			homePageDataBean.setQ13b2NumberOfConditionsAtExitDataBean(q13b2NumberOfConditionsAtExitList);
			if(q13b2NumberOfConditionsAtExitList!=null){
				CSVGenerator.buildReport(q13b2NumberOfConditionsAtExitList,"Q13b2.jrxml","Q13b2.csv");
			}
			
			List<Q13c1PhysicalAndMentalHealthConditionsForStayersDataBean> q13c1PhysicalAndMentalHealthConditionsForStayersList = Q13c1BeanMaker.getQ13c1PhysicalAndMentalHealthConditionsForStayersList();
			homePageDataBean.setQ13c1PhysicalAndMentalHealthConditionsForStayersDataBean(q13c1PhysicalAndMentalHealthConditionsForStayersList);
			if(q13c1PhysicalAndMentalHealthConditionsForStayersList!=null){
				CSVGenerator.buildReport(q13c1PhysicalAndMentalHealthConditionsForStayersList, "Q13c1.jrxml", "Q13c1.csv");
			}
			
			List<Q13c2NumberOfConditionsForStayerDataBean> q13c2NumberOfConditionsForStayerList = Q13c2BeanMaker.getQ13c2NumberOfConditionsForStayerList(data);
			homePageDataBean.setQ13c2NumberOfConditionsForStayerDataBean(q13c2NumberOfConditionsForStayerList);
			if(q13c2NumberOfConditionsForStayerList!=null){
				CSVGenerator.buildReport(q13c2NumberOfConditionsForStayerList, "Q13c2.jrxml","Q13c2.csv");
			}
			
			List<Q14aDomesticViolenceHistoryDataBean> q14aDomesticViolenceHistoryList= Q14aBeanMaker.getQ14aDomesticViolenceHistoryList(data);
			homePageDataBean.setQ14aDomesticViolenceHistoryDataBean(q14aDomesticViolenceHistoryList);
			if(q14aDomesticViolenceHistoryList!=null){
				CSVGenerator.buildReport(q14aDomesticViolenceHistoryList, "Q14a.jrxml", "Q14a.csv");
			}
			
			List<Q14bPersonsFleeingDomesticViolenceDataBean> q14bPersonsFleeingDomesticViolenceList = Q14bBeanMaker.getQ14bPersonsFleeingDomesticViolenceList();
			homePageDataBean.setQ14bPersonsFleeingDomesticViolenceDataBean(q14bPersonsFleeingDomesticViolenceList);
			if(q14bPersonsFleeingDomesticViolenceList!=null){
				CSVGenerator.buildReport(q14bPersonsFleeingDomesticViolenceList, "Q14b.jrxml", "Q14b.csv");
			}
			
			List<Q15ResidencePriorToProgramEntryDataBean> q15ResidencePriorToProgramEntryList = Q15BeanMaker.getQ15ResidencePriorToProgramEntryList(data);
			homePageDataBean.setQ15ResidencePriorToProgramEntryDataBean(q15ResidencePriorToProgramEntryList);
			if(q15ResidencePriorToProgramEntryList !=null){
				CSVGenerator.buildReport(q15ResidencePriorToProgramEntryList,"Q15.jrxml", "Q15.csv");
			}
			
			List<Q16CashIncomeRangesDataBean> q16CashIncomeRangesList = Q16BeanMaker.getQ16CashIncomeRangesList(data);
			homePageDataBean.setQ16CashIncomeRangesDataBean(q16CashIncomeRangesList);
			if(q16CashIncomeRangesList!=null){
				CSVGenerator.buildReport(q16CashIncomeRangesList, "Q16.jrxml", "Q16.csv");		
			}
			
			List<Q17CashIncomeSourcesDataBean> q17CashIncomeSourcesList= Q17CashIncomeSourcesDataBeanMaker.getQ17CashIncomeSourcesList();
			homePageDataBean.setQ17CashIncomeSourcesDataBean(q17CashIncomeSourcesList);
			if(q17CashIncomeSourcesList!=null){
				CSVGenerator.buildReport(q17CashIncomeSourcesList, "Q17.jrxml","Q17.csv");
			}
			
			List<Q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean> q18ClientCashIncomeCategoryEarnedOtherIncomeList= Q18ClientCashIncomeCategoryEarnedOtherIncomeDataBeanMaker.getQ18ClientCashIncomeCategoryEarnedOtherIncomeList(data);
			homePageDataBean.setQ18ClientCashIncomeCategoryEarnedOtherIncomeDataBean(q18ClientCashIncomeCategoryEarnedOtherIncomeList);
			if(q18ClientCashIncomeCategoryEarnedOtherIncomeList!=null){
				CSVGenerator.buildReport(q18ClientCashIncomeCategoryEarnedOtherIncomeList, "Q18.jrxml","Q18.csv");
			}
			
			List<Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean> q19a1ClientCashIncomeChangeIncomeSourceEntryDataBeanList = Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBeanMaker.getQ19a1ClientCashIncomeChangeIncomeSourceEntryDataBeanList();
			homePageDataBean.setQ19a1ClientCashIncomeChangeIncomeSourceEntryDataBean(q19a1ClientCashIncomeChangeIncomeSourceEntryDataBeanList);
			if(q19a1ClientCashIncomeChangeIncomeSourceEntryDataBeanList!=null){
				CSVGenerator.buildReport(q19a1ClientCashIncomeChangeIncomeSourceEntryDataBeanList, "Q19a1.jrxml", "Q19a1.csv");
			}
			
			List<Q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean> q19a2ClientCashIncomeChangeIncomeSourceByEntryList = Q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBeanMaker.getQ19a2ClientCashIncomeChangeIncomeSourceByEntryList();
			homePageDataBean.setQ19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean(q19a2ClientCashIncomeChangeIncomeSourceByEntryList);
			if(q19a2ClientCashIncomeChangeIncomeSourceByEntryList!=null){
				CSVGenerator.buildReport(q19a2ClientCashIncomeChangeIncomeSourceByEntryList, "Q19a2.jrxml", "Q19a2.csv");
			}
			
			List<Q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean> q19a3ClientCashIncomeChangeIncomeSourceByEntryList = Q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBeanMaker.getQ19a3ClientCashIncomeChangeIncomeSourceByEntryList();
	        homePageDataBean.setQ19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean(q19a3ClientCashIncomeChangeIncomeSourceByEntryList);
	        if(q19a3ClientCashIncomeChangeIncomeSourceByEntryList!=null){
	        	CSVGenerator.buildReport(q19a3ClientCashIncomeChangeIncomeSourceByEntryList, "Q19a3.jrxml", "Q19a3.csv");
	        }
	        
	        List<Q20aTypeOfNonCashBenefitSourcesDataBean> q20aTypeOfNonCashBenefitSourcesList = Q20aTypeOfNonCashBenefitSourcesDataBeanMaker.getQ20aTypeOfNonCashBenefitSourcesList();
			homePageDataBean.setQ20aTypeOfNonCashBenefitSourcesDataBean(q20aTypeOfNonCashBenefitSourcesList);
			if(q20aTypeOfNonCashBenefitSourcesList!=null){
				CSVGenerator.buildReport(q20aTypeOfNonCashBenefitSourcesList, "Q20a.jrxml", "Q20a.csv");
			}
			
			List<Q20bNumberOfNonCashBenefitSourcesDataBean> q20bNumberOfNonCashBenefitSourcesList= Q20bNumberOfNonCashBenefitSourcesDataBeanMaker.getQ20bNumberOfNonCashBenefitSourcesList(data);
	        homePageDataBean.setQ20bNumberOfNonCashBenefitSourcesDataBean(q20bNumberOfNonCashBenefitSourcesList);
	        if(q20bNumberOfNonCashBenefitSourcesList!=null){
	        	CSVGenerator.buildReport(q20bNumberOfNonCashBenefitSourcesList, "Q20b.jrxml", "Q20b.csv");
	        }
			
	        List<Q21HealthInsuranceDataBean> q21HealthInsuranceList= Q21HealthInsuranceDataBeanMaker.getQ21HealthInsuranceList();
	        homePageDataBean.setQ21HealthInsuranceDataBean(q21HealthInsuranceList);
	        if(q21HealthInsuranceList!=null){
	        	CSVGenerator.buildReport(q21HealthInsuranceList, "Q21.jrxml","Q21.csv");
	        }
	        
	        List<Q22a1LengthOfParticipationCoCProjectsDataBean> q22a1LengthOfParticipationCoCProjectsList = Q22a1LengthOfParticipationCoCProjectsDataBeanMaker.getQ22a1LengthOfParticipationCoCProjectsList(data);
			homePageDataBean.setQ22a1LengthOfParticipationCoCProjectsDataBean(q22a1LengthOfParticipationCoCProjectsList);
			if(q22a1LengthOfParticipationCoCProjectsList!=null){
				CSVGenerator.buildReport(q22a1LengthOfParticipationCoCProjectsList,"Q22a1.jrxml","Q22a1.csv");
			}
			
			List<Q22bAverageAndMedianLengthOfParticipationInDaysDataBean> q22bAverageAndMedianLengthOfParticipationInDaysList = Q22bAverageAndMedianLengthOfParticipationInDaysDataBeanMaker.getQ22bAverageAndMedianLengthOfParticipationInDaysList();
			homePageDataBean.setQ22bAverageAndMedianLengthOfParticipationInDaysDataBean(q22bAverageAndMedianLengthOfParticipationInDaysList);
			if(q22bAverageAndMedianLengthOfParticipationInDaysList!=null){
				CSVGenerator.buildReport(q22bAverageAndMedianLengthOfParticipationInDaysList,"Q22b.jrxml","Q22b.csv");
			}
			
			List<Q23aExitDestinationMoreThan90DaysDataBean> q23ExitDestinationMoreThan90DaysList = Q23ExitDestinationMoreThan90DaysDataBeanMaker.getQ23ExitDestinationMoreThan90DaysList();
			homePageDataBean.setQ23ExitDestinationMoreThan90DaysDataBean(q23ExitDestinationMoreThan90DaysList);
			if(q23ExitDestinationMoreThan90DaysList!=null){
				CSVGenerator.buildReport(q23ExitDestinationMoreThan90DaysList, "Q23a.jrxml","Q23a.csv");
			}
			
			List<Q23bExitDestination90DaysOrLessDataBean> q23bExitDestination90DaysOrLessList= Q23bExitDestination90DaysOrLessDataBeanMaker.getQ23bExitDestination90DaysOrLessList();
			homePageDataBean.setQ23bExitDestination90DaysOrLessDataBean(q23bExitDestination90DaysOrLessList);
			if(q23bExitDestination90DaysOrLessList!=null){
				CSVGenerator.buildReport(q23bExitDestination90DaysOrLessList, "Q23b.jrxml","Q23b.csv");
			}
			
			List<Q25aNumberOfVeteransDataBean> q25aNumberOfVeteransList = Q25aNumberOfVeteransDataBeanMaker.getQ25aNumberOfVeteransList(data);	
			homePageDataBean.setQ25aNumberOfVeteransDataBean(q25aNumberOfVeteransList);
			if(q25aNumberOfVeteransList!=null){
				CSVGenerator.buildReport(q25aNumberOfVeteransList, "Q25a.jrxml","Q25a.csv");
			}
			
			List<Q25bNumberOfVeteranHouseholdsDataBean> q25bNumberOfVeteranHouseholdsList= Q25bNumberOfVeteranHouseholdsDataBeanMaker.getQ25bNumberOfVeteranHouseholdsList();
			homePageDataBean.setQ25bNumberOfVeteranHouseholdsDataBean(q25bNumberOfVeteranHouseholdsList);
			if(q25bNumberOfVeteranHouseholdsList!=null){
				CSVGenerator.buildReport(q25bNumberOfVeteranHouseholdsList, "Q25b.jrxml","Q25b.csv");
			}
			
			List<Q25cGenderVeteransDataBean> q25cGenderVeteransList = Q25cGenderVeteransDataBeanMaker.getQ25cGenderVeteransList(data);
			homePageDataBean.setQ25cGenderVeteransDataBean(q25cGenderVeteransList);
			if(q25cGenderVeteransList!=null){
				CSVGenerator.buildReport(q25cGenderVeteransList, "Q25c.jrxml","Q25c.csv");
			}
			
			List<Q25dAgeVeteransDataBean> q25dAgeVeteransList = Q25dAgeVeteransDataBeanMaker.getQ25dAgeVeteransList(data);
			homePageDataBean.setQ25dAgeVeteransDataBean(q25dAgeVeteransList);
			if(q25dAgeVeteransList!=null){
				CSVGenerator.buildReport(q25dAgeVeteransList, "Q25d.jrxml","Q25d.csv");
			}
			
			List<Q25ePhysicalAndMentalHealthConditionsVeteransDataBean> q25ePhysicalAndMentalHealthConditionsVeteransList = Q25ePhysicalAndMentalHealthConditionsVeteransDataBeanMaker.getQ25ePhysicalAndMentalHealthConditionsVeteransList();
			homePageDataBean.setQ25ePhysicalAndMentalHealthConditionsVeteransDataBean(q25ePhysicalAndMentalHealthConditionsVeteransList);
			if(q25ePhysicalAndMentalHealthConditionsVeteransList!=null){
				CSVGenerator.buildReport(q25ePhysicalAndMentalHealthConditionsVeteransList, "Q25e.jrxml","Q25e.csv");
			}
			
			List<Q25fCashIncomeCategoryIncomeCategoryByEntryDataBean> q25fCashIncomeCategoryIncomeCategoryByEntryList = Q25fCashIncomeCategoryIncomeCategoryByEntryDataBeanMaker.getQ25fCashIncomeCategoryIncomeCategoryByEntryList(data);
			homePageDataBean.setQ25fCashIncomeCategoryIncomeCategoryByEntryDataBean(q25fCashIncomeCategoryIncomeCategoryByEntryList);
			if(q25fCashIncomeCategoryIncomeCategoryByEntryList!=null){
				CSVGenerator.buildReport(q25fCashIncomeCategoryIncomeCategoryByEntryList, "Q25f.jrxml","Q25f.csv");
			}
			
			List<Q25gTypeOfCashIncomeSourcesVeteransDataBean> q25gTypeOfCashIncomeSourcesVeteranList = Q25gTypeOfCashIncomeSourcesVeteransDataBeanMaker.getQ25gTypeOfCashIncomeSourcesVeteranList();
			homePageDataBean.setQ25gTypeOfCashIncomeSourcesVeteransDataBean(q25gTypeOfCashIncomeSourcesVeteranList);
			if(q25gTypeOfCashIncomeSourcesVeteranList!=null){
				CSVGenerator.buildReport(q25gTypeOfCashIncomeSourcesVeteranList, "Q25g.jrxml","Q25g.csv");
			}
			
			List<Q25hTypeOfNonCashIncomeSourcesVeteransDataBean> q25hTypeOfNonCashIncomeSourcesVeteransList = Q25hTypeOfNonCashIncomeSourcesVeteransDataBeanMaker.getQ25hTypeOfNonCashIncomeSourcesVeteransList();
			homePageDataBean.setQ25hTypeOfNonCashIncomeSourcesVeteransDataBean(q25hTypeOfNonCashIncomeSourcesVeteransList);
			if(q25hTypeOfNonCashIncomeSourcesVeteransList!=null){
				CSVGenerator.buildReport(q25hTypeOfNonCashIncomeSourcesVeteransList, "Q25h.jrxml","Q25h.csv");
			}
			
			List<Q25iExitDestinationVeteransDataBean> q25iExitDestinationVeteransList = Q25iExitDestinationVeteransDataBeanMaker.getQ25iExitDestinationVeteransList();
			homePageDataBean.setQ25iExitDestinationVeteransDataBean(q25iExitDestinationVeteransList);
			if(q25iExitDestinationVeteransList!=null){
				CSVGenerator.buildReport(q25iExitDestinationVeteransList, "Q25i.jrxml","Q25i.csv");
			}
			
			List<Q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean> q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyList = Q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBeanMaker.getQ26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyList();
			homePageDataBean.setQ26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean(q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyList);
			if(q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyList!=null){
				CSVGenerator.buildReport(q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyList, "Q26a.jrxml","Q26a.csv");
			}
			
			List<Q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean> q26bNumberOfChronicallyHomelessPersonsByHouseholdList = Q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBeanMaker.getQ26bNumberOfChronicallyHomelessPersonsByHouseholdList(data);
			homePageDataBean.setQ26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean(q26bNumberOfChronicallyHomelessPersonsByHouseholdList);
			if(q26bNumberOfChronicallyHomelessPersonsByHouseholdList!=null){
				CSVGenerator.buildReport(q26bNumberOfChronicallyHomelessPersonsByHouseholdList, "Q26b.jrxml","Q26b.csv");
			}
			
			List<Q26cGenderOfChronicallyHomelessPersonDataBean> q26cGenderOfChronicallyHomelessPersonList = Q26cGenderOfChronicallyHomelessPersonDataBeanMaker.getQ26cGenderOfChronicallyHomelessPersonList(data);
			homePageDataBean.setQ26cGenderOfChronicallyHomelessPersonDataBean(q26cGenderOfChronicallyHomelessPersonList);
			if(q26cGenderOfChronicallyHomelessPersonList!=null){
				CSVGenerator.buildReport(q26cGenderOfChronicallyHomelessPersonList, "Q26c.jrxml","Q26c.csv");
			}
			
			List<Q26dAgeOfChronicallyHomelessPersonsDataBean> q26dAgeOfChronicallyHomelessPersonsList = Q26dAgeOfChronicallyHomelessPersonsDataBeanMaker.getQ26dAgeOfChronicallyHomelessPersonsList(data);
			homePageDataBean.setQ26dAgeOfChronicallyHomelessPersonsDataBean(q26dAgeOfChronicallyHomelessPersonsList);
			if(q26dAgeOfChronicallyHomelessPersonsList!=null){
				CSVGenerator.buildReport(q26dAgeOfChronicallyHomelessPersonsList, "Q26d.jrxml","Q26d.csv");
			}
			
			List<Q26ePhysicalAndMentalHealthConditionsChronicallyDataBean> q26ePhysicalAndMentalHealthConditionsChronicallyList= Q26ePhysicalAndMentalHealthConditionsChronicallyDataBeanMaker.getQ26ePhysicalAndMentalHealthConditionsChronicallyList();
			homePageDataBean.setQ26ePhysicalAndMentalHealthConditionsChronicallyDataBean(q26ePhysicalAndMentalHealthConditionsChronicallyList);
			if(q26ePhysicalAndMentalHealthConditionsChronicallyList!=null){
				CSVGenerator.buildReport(q26ePhysicalAndMentalHealthConditionsChronicallyList, "Q26e.jrxml","Q26e.csv");
			}
			
			List<Q26fClientCashIncomeChronicallyHomelessPersonsDataBean> q26fClientCashIncomeChronicallyHomelessPersonsList= Q26fClientCashIncomeChronicallyHomelessPersonsDataBeanMaker.getQ26fClientCashIncomeChronicallyHomelessPersonsList();
			homePageDataBean.setQ26fClientCashIncomeChronicallyHomelessPersonsDataBean(q26fClientCashIncomeChronicallyHomelessPersonsList);
			if(q26fClientCashIncomeChronicallyHomelessPersonsList!=null){
				CSVGenerator.buildReport(q26fClientCashIncomeChronicallyHomelessPersonsList, "Q26f.jrxml","Q26f.csv");
			}
			
			List<Q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean> q26gTypeOfCashIncomeSourcesChronicallyHomelessList = Q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBeanMaker.getQ26gTypeOfCashIncomeSourcesChronicallyHomelessList();
			homePageDataBean.setQ26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean(q26gTypeOfCashIncomeSourcesChronicallyHomelessList);
			if(q26gTypeOfCashIncomeSourcesChronicallyHomelessList!=null){
				CSVGenerator.buildReport(q26gTypeOfCashIncomeSourcesChronicallyHomelessList, "Q26g.jrxml","Q26g.csv");
			}
			
			List<Q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean> q26hTypeOfNonCashIncomeSourcesChronicallyHomelessList = Q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBeanMaker.getQ26hTypeOfNonCashIncomeSourcesChronicallyHomelessList();
			homePageDataBean.setQ26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean(q26hTypeOfNonCashIncomeSourcesChronicallyHomelessList);
			if(q26hTypeOfNonCashIncomeSourcesChronicallyHomelessList!=null){
			
				
				CSVGenerator.buildReport(q26hTypeOfNonCashIncomeSourcesChronicallyHomelessList, "Q26h.jrxml","Q26h.csv");
			}
			
			List<Q27aAgeOfYouthDataBean> q27aAgeOfYouthList = Q27aAgeOfYouthDataBeanMaker.getQ27aAgeOfYouthList(data);
			homePageDataBean.setQ27aAgeOfYouthDataBean(q27aAgeOfYouthList);
			if(q27aAgeOfYouthList!=null){
				CSVGenerator.buildReport(q27aAgeOfYouthList, "Q27a.jrxml","Q27a.csv");
			}
			
			List<Q27bParentingYouthDataBean> q27bParentingYouthList= Q27bParentingYouthDataBeanMaker.getQ27bParentingYouthList(data);
			homePageDataBean.setQ27bParentingYouthDataBean(q27bParentingYouthList);
			if(q27bParentingYouthList!=null){
				CSVGenerator.buildReport(q27bParentingYouthList, "Q27b.jrxml","Q27b.csv");
			}
			
			List<Q27cGenderYouthDataBean> q27cGenderYouthList = Q27cGenderYouthDataBeanMaker.getQ27cGenderYouthList(data);
			homePageDataBean.setQ27cGenderYouthDataBean(q27cGenderYouthList);
			if(q27cGenderYouthList!=null){
				CSVGenerator.buildReport(q27cGenderYouthList, "Q27c.jrxml","Q27c.csv");
			}
			
			List<Q27dResidencePriorToEntryYouthDataBean> q27dResidencePriorToEntryYouthList= Q27dResidencePriorToEntryYouthDataBeanMaker.getQ27dResidencePriorToEntryYouthList();
			homePageDataBean.setQ27dResidencePriorToEntryYouthDataBean(q27dResidencePriorToEntryYouthList);
			if(q27dResidencePriorToEntryYouthList!=null){
				CSVGenerator.buildReport(q27dResidencePriorToEntryYouthList, "Q27d.jrxml","Q27d.csv");
			}
			
			List<Q27eLengthOfParticipationYouthDataBean> q27eLengthOfParticipationYouthList = Q27eLengthOfParticipationYouthDataBeanMaker.getQ27eLengthOfParticipationYouthList(data);
			homePageDataBean.setQ27eLengthOfParticipationYouthDataBean(q27eLengthOfParticipationYouthList);
			if(q27eLengthOfParticipationYouthList!=null){
				CSVGenerator.buildReport(q27eLengthOfParticipationYouthList, "Q27e.jrxml","Q27e.csv");
			}
			
			List<Q27fExitDestinationYouthDataBean> q27fExitDestinationYouthList = Q27fExitDestinationYouthDataBeanMaker.getQ27fExitDestinationYouthList();
			homePageDataBean.setQ27fExitDestinationYouthDataBean(q27fExitDestinationYouthList);
			if(q27fExitDestinationYouthList!=null){
				CSVGenerator.buildReport(q27fExitDestinationYouthList, "Q27f.jrxml","Q27f.csv");
			}
			
			/*homePageDataBean.setQ29aPerformanceMeasuresPermanentHousingProgramsDataBean(Q29aPerformanceMeasuresPermanentHousingProgramsDataBeanMaker.getQ29aPerformanceMeasuresPermanentHousingProgramsList());
			homePageDataBean.setQ29bPerformanceMeasuresTransitionalHousingProgramsDataBean(Q29bPerformanceMeasuresTransitionalHousingProgramsDataBeanMaker.getQ29bPerformanceMeasuresTransitionalHousingProgramsList());
			homePageDataBean.setQ29cPerformanceMeasuresStreetOutreachProgramsDataBean(Q29cPerformanceMeasuresStreetOutreachProgramsDataBeanMaker.getQ29cPerformanceMeasuresStreetOutreachProgramsList());
			homePageDataBean.setQ29dPerformanceMeasuresSupportiveServiceOnlyDataBean(Q29dPerformanceMeasuresSupportiveServiceOnlyDataBeanMaker.getQ29dPerformanceMeasuresSupportiveServiceOnlyDataBeanList());
			homePageDataBean.setQ29ePerformanceMeasuresSafeHavensDataBean(Q29ePerformanceMeasuresSafeHavensDataBeanMaker.getQ29ePerformanceMeasuresSafeHavensDataBeanList());*/
			
			
			return Arrays.asList(homePageDataBean);
	    }
		
		public static void populateProject(String schema,String id, HomePageDataBean homePageDataBean) {
			ResultSet resultSet = null;
			PreparedStatement statement = null;
			Connection connection = null;
			try {
				connection = HiveConnection.getConnection();
				statement = connection.prepareStatement(String.format(ReportQuery.GET_PROJECT_BY_ID,schema));
				statement.setString(1, id);
				resultSet = statement.executeQuery();
			 while(resultSet.next()) {
				 homePageDataBean.setQ04aProjectName(resultSet.getString("project.projectname"));
				 homePageDataBean.setQ04aHmisProjectType(resultSet.getString("project.projecttype_desc"));
				 homePageDataBean.setQ04aProjectId(resultSet.getString("project.project_source_system_id"));
//				 homePageDataBean.setQ04aProjectId("");
				 homePageDataBean.setQ04aMethodOfTracking(resultSet.getString("project.trackingmethod_desc"));
				 String organizationId = resultSet.getString("project.organizationid");
				 populateOranization(schema, organizationId, homePageDataBean);
			 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (statement != null) {
					try {
						statement.close();
						//connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
			public static void populateOranization(String schema,String id, HomePageDataBean homePageDataBean) {
				ResultSet resultSet = null;
				PreparedStatement statement = null;
				Connection connection = null;
				try {
					connection = HiveConnection.getConnection();
					statement = connection.prepareStatement(String.format(ReportQuery.GET_ORG_BY_ID,schema));
					statement.setString(1, id);
					resultSet = statement.executeQuery();
//					int count = 0;
				 while(resultSet.next()) {
					 homePageDataBean.setQ04aOrgName(resultSet.getString("organization.organizationname"));
				     homePageDataBean.setQ04aOrgId(resultSet.getString("organization.organization_source_system_id"));
				 }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (statement != null) {
						try {
							statement.close();
							//connection.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			
			public static List<ClientModel> getClients(String schema) {
				ResultSet resultSet = null;
				PreparedStatement statement = null;
				Connection connection = null;
				List<ClientModel>  models = new ArrayList<ClientModel>();
				try {
					connection = HiveConnection.getConnection();
					statement = connection.prepareStatement(String.format(ReportQuery.GET_ALL_CLIENTS,schema));
					resultSet = statement.executeQuery();
				 while(resultSet.next()) {
					 ClientModel model = new ClientModel(resultSet.getString("client.personalid"), resultSet.getString("client.dedup_client_id"), 
							 resultSet.getString("client.name_data_quality"),resultSet.getString("client.name_data_quality_desc"), 
							 resultSet.getString("client.ssn_data_quality"), resultSet.getString("client.ssn_data_quality_desc"), 
							 resultSet.getDate("client.dob"),resultSet.getString("client.dob_data_quality"), 
							 resultSet.getString("client.dob_data_quality_desc"), resultSet.getString("client.gender"), 
							 resultSet.getString("client.gender_desc"), resultSet.getString("client.other_gender"), resultSet.getString("client.ethnicity"), 
							 resultSet.getString("client.ethnicity_desc"), resultSet.getString("client.race"), resultSet.getString("client.race_desc"), 
							 resultSet.getString("client.veteran_status"), resultSet.getString("client.client_source_system_id"));
					 models.add(model);
				 }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (statement != null) {
						try {
							statement.close();
							//connection.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				return models;
			}

			
			public static List<EnrollmentModel> getEnrollmentsByProjectId(String schema,String projectId) {
				ResultSet resultSet = null;
				PreparedStatement statement = null;
				Connection connection = null;
				List<EnrollmentModel>  models = new ArrayList<EnrollmentModel>();
				try {
					connection = HiveConnection.getConnection();
					statement = connection.prepareStatement(String.format(ReportQuery.GET_ENROLLMENTS_BY_PROJECT_ID,schema));
					statement.setString(1, projectId);
					resultSet = statement.executeQuery();
				 while(resultSet.next()) {
					 EnrollmentModel model = new EnrollmentModel(resultSet.getString("enrollment.projectentryid"), 
							 resultSet.getString("enrollment.continuouslyhomelessoneyear"),
							 resultSet.getString("enrollment.disablingcondition"), 
							 null, 
							 resultSet.getString("enrollment.householdid"), 
							 resultSet.getString("enrollment.housingstatus"), 
							 resultSet.getString("enrollment.housingstatus_desc"), 
							 resultSet.getString("enrollment.monthshomelesspastthreeyears"), 
							 resultSet.getString("enrollment.monthshomelesspastthreeyears_desc"), 
							 resultSet.getString("enrollment.monthshomelessthistime"), 
							 resultSet.getString("enrollment.otherresidenceprior"), 
							 resultSet.getString("enrollment.projectid"), 
							 resultSet.getString("enrollment.relationshiptohoh"), 
							 resultSet.getString("enrollment.relationshiptohoh_desc"), 
							 resultSet.getString("enrollment.residenceprior"), 
							 resultSet.getString("enrollment.residenceprior_desc"), 
							 resultSet.getString("enrollment.residencepriorlengthofstay"), 
							 resultSet.getString("enrollment.residencepriorlengthofstay_desc"), 
							 resultSet.getString("enrollment.statusdocumented"), 
							 resultSet.getString("enrollment.timeshomelesspastthreeyears"), 
							 resultSet.getString("enrollment.timeshomelesspastthreeyears_desc"), 
							 resultSet.getString("enrollment.ageatentry"), 
							 resultSet.getString("enrollment.personalid"), 
							 resultSet.getInt("enrollment.yearshomeless"), 
							 (Boolean)resultSet.getBoolean("enrollment.chronichomeless"), 
							 resultSet.getString("enrollment.enrollment_source_system_id"));
					 models.add(model);
				 }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (statement != null) {
						try {
							statement.close();
							//connection.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				return models;
			}

			
			public static List<ExitModel> getAllExits(String schema) {
				ResultSet resultSet = null;
				PreparedStatement statement = null;
				Connection connection = null;
				List<ExitModel>  models = new ArrayList<ExitModel>();
				try {
					connection = HiveConnection.getConnection();
					statement = connection.prepareStatement(String.format(ReportQuery.GET_ALL_EXITS,schema));
					resultSet = statement.executeQuery();
				 while(resultSet.next()) {
					 ExitModel model = new ExitModel( resultSet.getString("exit.exitid"), resultSet.getString("exit.destination"), 
							 resultSet.getString("exit.destination_desc"), 
							 resultSet.getTimestamp("exit.exitdate"), 
							 resultSet.getString("exit.otherdestination"), 
							 resultSet.getString("exit.projectEntryID"), resultSet.getString("exit.exit_source_system_id"));
					 models.add(model);
				 }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (statement != null) {
						try {
							statement.close();
							//connection.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				return models;
			}

}
