package com.servinglynk.report.business;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.servinglynk.hive.connection.ImpalaConnection;
import com.servinglynk.report.bean.Q24HomelessnessPreventionHousingAssessmentAtExitDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q24HomelessnessPreventionHousingAssessmentAtExitDataBeanMaker extends BaseBeanMaker {
	
	public static List<Q24HomelessnessPreventionHousingAssessmentAtExitDataBean> getQ24HomelessnessPreventionHousingAssessmentAtExitList(ReportData data){
		Q24HomelessnessPreventionHousingAssessmentAtExitDataBean q24HomelessnessPreventionHousingAssessmentAtExitTable = new Q24HomelessnessPreventionHousingAssessmentAtExitDataBean();
			
		String query ="select distinct(e.dedup_client_id)  from enrollment e join project p  on (e.projectid = p.id  and p.id ='5cc34dce-e603-4cb6-8d95-4cd3fb164098' ) "+
					    " join exit ext on (e.id = ext.enrollmentid and ext.exitdate  >=  '2016-06-24 00:00:00' and  ext.exitdate<='2018-06-24 00:00:00') "+
					    " join exithousingassessment eha on (ext.id = eha.exitid and housingassessment ='2' and subsidyinformation='2') "+
					    " order by e.dedup_client_id  ";
		try {
			if(data.isLiveMode()) {
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainWithoutSubsidyTotal(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainWithoutSubsidyWithoutChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainWithoutSubsidyWithChildAndAdults(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainWithoutSubsidyWithOnlyChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainWithoutSubsidyUnknownHouseHold(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainWithSubsidyTotal(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainWithSubsidyWithoutChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainWithSubsidyWithChildAndAdults(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainWithSubsidyWithOnlyChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainWithSubsidyUnknownHouseHold(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainOngoingSubsidyTotal(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainOngoingSubsidyWithoutChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainOngoingSubsidyWithChildAndAdults(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainOngoingSubsidyWithOnlyChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainOngoingSubsidyUnknownHouseHold(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainOtherThanSubsidyTotal(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainOtherThanSubsidyWithoutChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainOtherThanSubsidyWithChildAndAdults(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainOtherThanSubsidyWithOnlyChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainOtherThanSubsidyUnknownHouseHold(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedWithOngoingSubsidyTotal(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedWithOngoingSubsidyWithoutChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedWithOngoingSubsidyWithChildAndAdults(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedWithOngoingSubsidyWithOnlyChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedWithOngoingSubsidyUnknownHouseHold(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedWithoutOngoingSubsidyTotal(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedWithoutOngoingSubsidyWithoutChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedWithoutOngoingSubsidyWithChildAndAdults(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedWithoutOngoingSubsidyWithOnlyChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedWithoutOngoingSubsidyUnknownHouseHold(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedTemporaryBasisTotal(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedTemporaryBasisWithoutChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedTemporaryBasisWithChildAndAdults(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedTemporaryBasisWithOnlyChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedTemporaryBasisUnknownHouseHold(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedPermenantBasisTotal(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedPermenantBasisWithoutChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedPermenantBasisWithChildAndAdults(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedPermenantBasisWithOnlyChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedPermenantBasisUnknownHouseHold(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedToTransitionalTotal(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedToTransitionalWithoutChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedToTransitionalWithChildAndAdults(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedToTransitionalWithOnlyChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedToTransitionalUnknownHouseHold(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientBecameHomelessTotal(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientBecameHomelessWithoutChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientBecameHomelessWithChildAndAdults(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientBecameHomelessWithOnlyChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientBecameHomelessUnknownHouseHold(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientWenToJailTotal(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientWenToJailWithoutChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientWenToJailWithChildAndAdults(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientWenToJailWithOnlyChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientWenToJailUnknownHouseHold(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientDiedTotal(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientDiedWithoutChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientDiedWithChildAndAdults(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientDiedWithOnlyChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientDiedUnknownHouseHold(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientDoesntKnowTotal(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientDoesntKnowWithoutChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientDoesntKnowWithChildAndAdults(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientDoesntKnowWithOnlyChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientDoesntKnowUnknownHouseHold(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24DataNotCollectedTotal(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24DataNotCollectedWithoutChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24DataNotCollectedWithChildAndAdults(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24DataNotCollectedWithOnlyChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24DataNotCollectedUnknownHouseHold(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24TotTotal(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24TotWithoutChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24TotWithChildAndAdults(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24TotWithOnlyChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24TotUnknownHouseHold(BigInteger.valueOf(0));
			}
		}catch(Exception e) {
			logger.error("Error in Q24HomelessnessPreventionHousingAssessmentAtExitDataBeanMaker:" + e);
		}
				
		return Arrays.asList(q24HomelessnessPreventionHousingAssessmentAtExitTable);
	
	}
	
	public static List<String> getClients(ReportData data,String query,List<String> filteredProjectIds, boolean allProjects,String housingassessment, String  subsidyInformation) {
		 List<String> q22Beans = new ArrayList<String>();
			ResultSet resultSet = null;
			PreparedStatement statement = null;
			String projectQuery = " and p.id in ( ";
			StringBuilder builder = new StringBuilder(projectQuery);
			Connection connection = null;
			try {
				connection = ImpalaConnection.getConnection();
				 List<String> projectIds = data.getProjectIds();
				 if(CollectionUtils.isNotEmpty(projectIds)) {
					 int count = 0;
					 for(String project : projectIds) {
						 if ((filteredProjectIds !=null && filteredProjectIds.contains(project)) || allProjects) {
							 builder.append("'"+project+"'");
							 if(count != projectIds.size()) {
								 builder.append(",");
							 }
						 }
					 }
				 }
				 builder.append(" ) ");
				String newQuery = query.replace("%p", builder.toString());
				statement = connection.prepareStatement(formatQuery(newQuery,data.getSchema()));
				statement.setDate(1, data.getReportStartDate());
				statement.setDate(2, data.getReportEndDate());
				statement.setDate(3, data.getReportStartDate());
				statement.setDate(4, data.getReportEndDate());
				resultSet = statement.executeQuery();
				
			 while(resultSet.next()) {
				
				 
				 String dedupClientId = resultSet.getString("dedup_client_id");
				 q22Beans.add(dedupClientId);
			 
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
			return q22Beans;
		}	
	


}
