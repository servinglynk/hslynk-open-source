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
import com.servinglynk.report.bean.Q05aHMISComparableDBDataQualityDataBean;
import com.servinglynk.report.bean.Q06aReportValidationsTableDataBean;
import com.servinglynk.report.bean.Q06bNumberOfPersonsServedDataBean;
import com.servinglynk.report.bean.Q06cPointInTimeCountPersonsLastWednesdayDataBean;
import com.servinglynk.report.bean.Q07aHouseholdsServedDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.csvcontroller.CSVGenerator;

public class HomePageDataBeanMaker {
	
//		public static List<HomePageDataBean> getHomePageDataList(String schema,String projectId){
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
			populateProject(schema, projectId, homePageDataBean);
			homePageDataBean.setQ04aHmisProjectIdService(BigInteger.valueOf(240));
			homePageDataBean.setQ04aIdentityProjectId(BigInteger.valueOf(0));
			List<Q04aDataBean> q04aDataBeanList = Q04aBeanMaker.getQ04aDataBeanList(schema,projectId);
			if(sageReport) {
				CSVGenerator.buildReport(q04aDataBeanList, "q04a.jrxml", "q04a.csv");
			}
			List<EnrollmentModel> enrollments = getEnrollmentsByProjectId(schema, projectId);
			ReportData data = new ReportData();
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
			List<Q05aHMISComparableDBDataQualityDataBean> q05aHMISCDDQDataList = Q05aBeanMaker.getQ05aHMISCDDQDataList(schema,projectId,data);
			homePageDataBean.setQ05aHMISComparableDBDataQualityDataBean(q05aHMISCDDQDataList);
			if(q05aHMISCDDQDataList != null) {
				CSVGenerator.buildReport(q05aHMISCDDQDataList, "q05a.jrxml", "q05a.csv");
			}
			List<Q06aReportValidationsTableDataBean> q06aReportValidationsTableList = Q06aBeanMaker.getQ06aReportValidationsTableList(schema,data);
			if(q06aReportValidationsTableList != null) {
				CSVGenerator.buildReport(q06aReportValidationsTableList, "q06a.jrxml", "q06a.csv");
			}
			homePageDataBean.setQ06aReportValidationsTableDataBean(q06aReportValidationsTableList);
			List<Q06bNumberOfPersonsServedDataBean> q06bNumberOfPersonsServedTableList = Q06bBeanMaker.getQ06bNumberOfPersonsServedTableList(schema,data);
			CSVGenerator.buildReport(q06bNumberOfPersonsServedTableList, "q06b.jrxml", "q06b.csv");
			homePageDataBean.setQ06bNumberOfPersonsServedDataBean(q06bNumberOfPersonsServedTableList);
			List<Q06cPointInTimeCountPersonsLastWednesdayDataBean> q06cPointInTimeCountPersonsLastWednesdayList = Q06cBeanMaker.getQ06cPointInTimeCountPersonsLastWednesdayList();
			homePageDataBean.setQ06cPointInTimeCountPersonsLastWednesdayDataBean(q06cPointInTimeCountPersonsLastWednesdayList);
			CSVGenerator.buildReport(q06cPointInTimeCountPersonsLastWednesdayList, "q06c.jrxml", "q06c.csv");
			List<Q07aHouseholdsServedDataBean> q07aHouseholdsServeList = Q07aBeanMaker.getQ07aHouseholdsServeList();
			homePageDataBean.setQ07aHouseholdsServedDataBean(q07aHouseholdsServeList);
			CSVGenerator.buildReport(q07aHouseholdsServeList, "q07a_Households_Served.jrxml", "q07a.csv");
			homePageDataBean.setQ07bPointInTimeCountHouseholdsLastWednesdayDataBean(Q07bBeanMaker.getQ07bPointInTimeCountHouseholdsLastWednesdayList());
			homePageDataBean.setqQ09aNumberPersonsContactedDataBean(Q09aDataBeanMaker.getQ09aNumberPersonsContactedList());
			homePageDataBean.setQ09bNumberofPersonsEngagedDataBean(Q09bBeanMaker.getQ09bNumberofPersonsEngagedList());
			homePageDataBean.setQ10aGenderOfAdultsDataBean(Q10aBeanMaker.getQ10AGenderOfAdultsList());
			homePageDataBean.setQ10bGenderOfChildrenDataBean(Q10bBeanMaker.getQ10bGenderOfChildrenList());
			homePageDataBean.setQ10cGenderOfPersonsMissingAgeInformationDataBean(Q10cBeanMaker.getQ10CGPMIList());
			homePageDataBean.setQ11AgeDataBean(Q11BeanMaker.getQ11AgeList());
			homePageDataBean.setQ12aRaceDataBean(Q12aBeanMaker.getQ12aRaceList());
			homePageDataBean.setQ12bEthnicityDataBean(Q12bBeanMaker.getQ12bEthnicityList());
			homePageDataBean.setQ13a1PhysicalAndMentalHealthConditionsAtEntryDataBean(Q13a1BeanMaker.getQ13a1PhysicalAndMentalHealthConditionsAtEntryList());
			homePageDataBean.setQ13a2NumberOfConditionsAtEntryDataBean(Q13a2BeanMaker.getQ13a2NumberOfConditionsAtEntryList());
			homePageDataBean.setQ13b1PhysicalAndMentalHealthConditionsAtExitDataBean(Q13b1BeanMaker.getQ13b1PhysicalAndMentalHealthConditionsAtExitList());
			homePageDataBean.setQ13b2NumberOfConditionsAtExitDataBean(Q13b2BeanMaker.getQ13b2NumberOfConditionsAtExitList());
			homePageDataBean.setQ13c1PhysicalAndMentalHealthConditionsForStayersDataBean(Q13c1BeanMaker.getQ13c1PhysicalAndMentalHealthConditionsForStayersList());
			homePageDataBean.setQ13c2NumberOfConditionsForStayerDataBean(Q13c2BeanMaker.getQ13c2NumberOfConditionsForStayerList());
			homePageDataBean.setQ14aDomesticViolenceHistoryDataBean(Q14aBeanMaker.getQ14aDomesticViolenceHistoryList());
			homePageDataBean.setQ14bPersonsFleeingDomesticViolenceDataBean(Q14bBeanMaker.getQ14bPersonsFleeingDomesticViolenceList());
			homePageDataBean.setQ15ResidencePriorToProgramEntryDataBean(Q15BeanMaker.getQ15ResidencePriorToProgramEntryList());
			homePageDataBean.setQ16CashIncomeRangesDataBean(Q16BeanMaker.getQ16CashIncomeRangesList());
			homePageDataBean.setQ17CashIncomeSourcesDataBean(Q17CashIncomeSourcesDataBeanMaker.getQ17CashIncomeSourcesList());
			homePageDataBean.setQ18ClientCashIncomeCategoryEarnedOtherIncomeDataBean(Q18ClientCashIncomeCategoryEarnedOtherIncomeDataBeanMaker.getQ18ClientCashIncomeCategoryEarnedOtherIncomeList());
			homePageDataBean.setQ19a1ClientCashIncomeChangeIncomeSourceEntryDataBean(Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBeanMaker.getQ19a1ClientCashIncomeChangeIncomeSourceEntryDataBeanList());
			homePageDataBean.setQ19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean(Q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBeanMaker.getQ19a2ClientCashIncomeChangeIncomeSourceByEntryList());
	        homePageDataBean.setQ19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean(Q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBeanMaker.getQ19a3ClientCashIncomeChangeIncomeSourceByEntryList());
			homePageDataBean.setQ20aTypeOfNonCashBenefitSourcesDataBean(Q20aTypeOfNonCashBenefitSourcesDataBeanMaker.getQ20aTypeOfNonCashBenefitSourcesList());
	        homePageDataBean.setQ20bNumberOfNonCashBenefitSourcesDataBean(Q20bNumberOfNonCashBenefitSourcesDataBeanMaker.getQ20bNumberOfNonCashBenefitSourcesList());
			homePageDataBean.setQ21HealthInsuranceDataBean(Q21HealthInsuranceDataBeanMaker.getQ21HealthInsuranceList());
			homePageDataBean.setQ22a1LengthOfParticipationCoCProjectsDataBean(Q22a1LengthOfParticipationCoCProjectsDataBeanMaker.getQ22a1LengthOfParticipationCoCProjectsList());
			homePageDataBean.setQ22bAverageAndMedianLengthOfParticipationInDaysDataBean(Q22bAverageAndMedianLengthOfParticipationInDaysDataBeanMaker.getQ22bAverageAndMedianLengthOfParticipationInDaysList());
			homePageDataBean.setQ23ExitDestinationMoreThan90DaysDataBean(Q23ExitDestinationMoreThan90DaysDataBeanMaker.getQ23ExitDestinationMoreThan90DaysList());
			homePageDataBean.setQ24ExitDestination90DaysOrLessDataBean(Q24ExitDestination90DaysOrLessDataBeanMaker.getQ24ExitDestination90DaysOrLessList());
			homePageDataBean.setQ25aNumberOfVeteransDataBean(Q25aNumberOfVeteransDataBeanMaker.getQ25aNumberOfVeteransList());
			homePageDataBean.setQ25bNumberOfVeteranHouseholdsDataBean(Q25bNumberOfVeteranHouseholdsDataBeanMaker.getQ25bNumberOfVeteranHouseholdsList());
			homePageDataBean.setQ25cGenderVeteransDataBean(Q25cGenderVeteransDataBeanMaker.getQ25cGenderVeteransList());
			homePageDataBean.setQ25dAgeVeteransDataBean(Q25dAgeVeteransDataBeanMaker.getQ25dAgeVeteransList());
			homePageDataBean.setQ25ePhysicalAndMentalHealthConditionsVeteransDataBean(Q25ePhysicalAndMentalHealthConditionsVeteransDataBeanMaker.getQ25ePhysicalAndMentalHealthConditionsVeteransList());
			homePageDataBean.setQ25fCashIncomeCategoryIncomeCategoryByEntryDataBean(Q25fCashIncomeCategoryIncomeCategoryByEntryDataBeanMaker.getQ25fCashIncomeCategoryIncomeCategoryByEntryList());
			homePageDataBean.setQ25gTypeOfCashIncomeSourcesVeteransDataBean(Q25gTypeOfCashIncomeSourcesVeteransDataBeanMaker.getQ25gTypeOfCashIncomeSourcesVeteranList());
			homePageDataBean.setQ25hTypeOfNonCashIncomeSourcesVeteransDataBean(Q25hTypeOfNonCashIncomeSourcesVeteransDataBeanMaker.getQ25hTypeOfNonCashIncomeSourcesVeteransList());
			homePageDataBean.setQ25iExitDestinationVeteransDataBean(Q25iExitDestinationVeteransDataBeanMaker.getQ25iExitDestinationVeteransList());
			homePageDataBean.setQ26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean(Q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBeanMaker.getQ26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyList());
			homePageDataBean.setQ26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean(Q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBeanMaker.getQ26bNumberOfChronicallyHomelessPersonsByHouseholdList());
			homePageDataBean.setQ26cGenderOfChronicallyHomelessPersonDataBean(Q26cGenderOfChronicallyHomelessPersonDataBeanMaker.getQ26cGenderOfChronicallyHomelessPersonList());
			homePageDataBean.setQ26dAgeOfChronicallyHomelessPersonsDataBean(Q26dAgeOfChronicallyHomelessPersonsDataBeanMaker.getQ26dAgeOfChronicallyHomelessPersonsList());
			homePageDataBean.setQ26ePhysicalAndMentalHealthConditionsChronicallyDataBean(Q26ePhysicalAndMentalHealthConditionsChronicallyDataBeanMaker.getQ26ePhysicalAndMentalHealthConditionsChronicallyList());
			homePageDataBean.setQ26fClientCashIncomeChronicallyHomelessPersonsDataBean(Q26fClientCashIncomeChronicallyHomelessPersonsDataBeanMaker.getQ26fClientCashIncomeChronicallyHomelessPersonsList());
			homePageDataBean.setQ26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean(Q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBeanMaker.getQ26gTypeOfCashIncomeSourcesChronicallyHomelessList());
			homePageDataBean.setQ26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean(Q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBeanMaker.getQ26hTypeOfNonCashIncomeSourcesChronicallyHomelessList());
			homePageDataBean.setQ27aAgeOfYouthDataBean(Q27aAgeOfYouthDataBeanMaker.getQ27aAgeOfYouthList());
			homePageDataBean.setQ27bParentingYouthDataBean(Q27bParentingYouthDataBeanMaker.getQ27bParentingYouthList());
			homePageDataBean.setQ27cGenderYouthDataBean(Q27cGenderYouthDataBeanMaker.getQ27cGenderYouthList());
			homePageDataBean.setQ27dResidencePriorToEntryYouthDataBean(Q27dResidencePriorToEntryYouthDataBeanMaker.getQ27dResidencePriorToEntryYouthList());
			homePageDataBean.setQ27eLengthOfParticipationYouthDataBean(Q27eLengthOfParticipationYouthDataBeanMaker.getQ27eLengthOfParticipationYouthList());
			homePageDataBean.setQ27fExitDestinationYouthDataBean(Q27fExitDestinationYouthDataBeanMaker.getQ27fExitDestinationYouthList());
			homePageDataBean.setQ29aPerformanceMeasuresPermanentHousingProgramsDataBean(Q29aPerformanceMeasuresPermanentHousingProgramsDataBeanMaker.getQ29aPerformanceMeasuresPermanentHousingProgramsList());
			homePageDataBean.setQ29bPerformanceMeasuresTransitionalHousingProgramsDataBean(Q29bPerformanceMeasuresTransitionalHousingProgramsDataBeanMaker.getQ29bPerformanceMeasuresTransitionalHousingProgramsList());
			homePageDataBean.setQ29cPerformanceMeasuresStreetOutreachProgramsDataBean(Q29cPerformanceMeasuresStreetOutreachProgramsDataBeanMaker.getQ29cPerformanceMeasuresStreetOutreachProgramsList());
			homePageDataBean.setQ29dPerformanceMeasuresSupportiveServiceOnlyDataBean(Q29dPerformanceMeasuresSupportiveServiceOnlyDataBeanMaker.getQ29dPerformanceMeasuresSupportiveServiceOnlyDataBeanList());
			homePageDataBean.setQ29ePerformanceMeasuresSafeHavensDataBean(Q29ePerformanceMeasuresSafeHavensDataBeanMaker.getQ29ePerformanceMeasuresSafeHavensDataBeanList());
			
			
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
