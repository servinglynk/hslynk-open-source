package com.servinglynk.report.business;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.servinglynk.hive.connection.ImpalaConnection;
import com.servinglynk.report.bean.Q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBeanMaker extends BaseBeanMaker {
	
public static List<Q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean> getQ26bNumberOfChronicallyHomelessPersonsByHouseholdList(ReportData data){
		
	Q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean q26bNumberOfChronicallyHomelessPersonsByHouseholdTable = new Q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean();
	try {
		if(data.isLiveMode()) {
			List<String> projectsHHWithChildren = data.getProjectsHHWithChildren();
			List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
			List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
			List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
			
			String chronicHomelessQuery ="select distinct(e.dedup_client_id) from %s.enrollment e,%s.client c,%s.project p  where c.id =e.client_id and e.chronichomeless=true and e.projectid = p.id %p  and entrydate <= :endDate  and e.id not in ( select enrollmentid from %s.exit ext where  ext.exitdate is null  or  ext.exitdate <= :startDate )";
			String noChronicHomelessQuery ="select distinct(e.dedup_client_id) from %s.enrollment e,%s.client c,%s.project p  where c.id =e.client_id  and e.chronichomeless=false and e.projectid = p.id %p  and entrydate <= :endDate and e.id not in ( select enrollmentid from %s.exit ext where  ext.exitdate is null  or  ext.exitdate <= :startDate )";
			String dnKChHomelessQuery ="select distinct(e.dedup_client_id) from %s.enrollment e,%s.client c,%s.project p  where c.id =e.client_id and e.disablingcondition in ('8','9') and e.projectid = p.id %p and entrydate <= :endDate and e.id not in ( select enrollmentid from %s.exit ext where  ext.exitdate is null  or  ext.exitdate <= :startDate ) ";
			String dnCChHomelessQuery ="select distinct(e.dedup_client_id) from %s.enrollment e,%s.client c,%s.project p  where c.id =e.client_id and e.disablingcondition ='99' and e.projectid = p.id %p and entrydate <= :endDate and e.id not in ( select enrollmentid from %s.exit ext where  ext.exitdate is null  or  ext.exitdate <= :startDate ) ";
			
			int chSize = getSize(data.getChronicHomeLess());
			int chWithoutChildSize = getSize(getClients(data, chronicHomelessQuery, projectsHHWithOutChildren, false));
			int chChildAndAdultsSize = getSize(getClients(data, chronicHomelessQuery, projectsHHWithOneAdultChild, false));
			int chWithOnlyChildSize = getSize(getClients(data, chronicHomelessQuery, projectsHHWithChildren, false));
			int chUnknownHouseHoldSize = getSize(getClients(data, chronicHomelessQuery, projectsUnknownHouseHold, false));
			
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bChronicallyHomelessTotal(BigInteger.valueOf(chSize));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bChronicallyHomelessWithoutChild(BigInteger.valueOf(chWithoutChildSize));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bChronicallyHomelessWithChildAndAdults(BigInteger.valueOf(chChildAndAdultsSize));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bChronicallyHomelessWithOnlyChild(BigInteger.valueOf(chWithOnlyChildSize));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bChronicallyHomelessUnknownHouseholdType(BigInteger.valueOf(chUnknownHouseHoldSize));

			int noChSize = getSize(getClients(data, noChronicHomelessQuery, null, true));
			int noChWithoutChildSize = getSize(getClients(data, noChronicHomelessQuery, projectsHHWithOutChildren, false));
			int noChChildAndAdultsSize = getSize(getClients(data, noChronicHomelessQuery, projectsHHWithOneAdultChild, false));
			int noChWithOnlyChildSize = getSize(getClients(data, noChronicHomelessQuery, projectsHHWithChildren, false));
			int noChUnknownHouseHoldSize = getSize(getClients(data, noChronicHomelessQuery, projectsUnknownHouseHold, false));
			
			
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bNotChronicallyHomelessTotal(BigInteger.valueOf(noChSize));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bNotChronicallyHomelessWithoutChild(BigInteger.valueOf(noChWithoutChildSize));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bNotChronicallyHomelessWithChildAndAdults(BigInteger.valueOf(noChChildAndAdultsSize));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bNotChronicallyHomelessWithOnlyChild(BigInteger.valueOf(noChWithOnlyChildSize));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bNotChronicallyHomelessUnknownHouseholdType(BigInteger.valueOf(noChUnknownHouseHoldSize));

			int dnKChSize = getSize(getClients(data, dnKChHomelessQuery, null, true));
			int dnKChWithoutChildSize = getSize(getClients(data, dnKChHomelessQuery, projectsHHWithOutChildren, false));
			int dnKChChildAndAdultsSize = getSize(getClients(data, dnKChHomelessQuery, projectsHHWithOneAdultChild, false));
			int dnKChWithOnlyChildSize = getSize(getClients(data, dnKChHomelessQuery, projectsHHWithChildren, false));
			int dnKChUnknownHouseHoldSize = getSize(getClients(data, dnKChHomelessQuery, projectsUnknownHouseHold, false));
			
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bClientRefusedTotal(BigInteger.valueOf(dnKChSize));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bClientRefusedWithoutChild(BigInteger.valueOf(dnKChWithoutChildSize));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bClientRefusedWithChildAndAdults(BigInteger.valueOf(dnKChChildAndAdultsSize));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bClientRefusedWithOnlyChild(BigInteger.valueOf(dnKChWithOnlyChildSize));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bClientRefusedUnknownHouseholdType(BigInteger.valueOf(dnKChUnknownHouseHoldSize));

			int dnCChSize = getSize(getClients(data, dnCChHomelessQuery, null, true));
			int dnCChWithoutChildSize = getSize(getClients(data, dnCChHomelessQuery, projectsHHWithOutChildren, false));
			int dnCChChildAndAdultsSize = getSize(getClients(data, dnCChHomelessQuery, projectsHHWithOneAdultChild, false));
			int dnCChWithOnlyChildSize = getSize(getClients(data, dnCChHomelessQuery, projectsHHWithChildren, false));
			int dnCChUnknownHouseHoldSize = getSize(getClients(data, dnCChHomelessQuery, projectsUnknownHouseHold, false));
			
			
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bDataNotCollectedTotal(BigInteger.valueOf(dnCChSize));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bDataNotCollectedWithoutChild(BigInteger.valueOf(dnCChWithoutChildSize));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bDataNotCollectedWithChildAndAdults(BigInteger.valueOf(dnCChChildAndAdultsSize));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bDataNotCollectedWithOnlyChild(BigInteger.valueOf(dnCChWithOnlyChildSize));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bDataNotCollectedUnknownHouseholdType(BigInteger.valueOf(dnCChUnknownHouseHoldSize));

			int total = chSize + noChSize + dnKChSize + dnCChSize ;
			int withOutChild = chWithoutChildSize + noChWithoutChildSize + dnKChWithoutChildSize + dnCChWithoutChildSize ;
			int withChildAndAdults = chChildAndAdultsSize + noChWithOnlyChildSize + dnKChChildAndAdultsSize + dnCChChildAndAdultsSize;
			int withOnlyChild = chWithOnlyChildSize + noChWithOnlyChildSize + dnKChWithOnlyChildSize + dnCChWithOnlyChildSize;
			int unknownHouseholdType = chUnknownHouseHoldSize + noChUnknownHouseHoldSize + dnKChUnknownHouseHoldSize + dnCChUnknownHouseHoldSize;
			
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bTotTotal(data.getNoOfChronicallyHomelessPersons());
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bTotWithoutChild(BigInteger.valueOf(withOutChild));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bTotWithChildAndAdults(BigInteger.valueOf(withChildAndAdults));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bTotWithOnlyChild(BigInteger.valueOf(withOnlyChild));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bTotUnknownHouseholdType(BigInteger.valueOf(unknownHouseholdType));
			
		}
		}catch(Exception e) {
			logger.error("Error in Q26bBeanMaker:" + e);
		}
		
		return Arrays.asList(q26bNumberOfChronicallyHomelessPersonsByHouseholdTable); 
		
	}

public static List<String> getClients(ReportData data,String query,List<String> filteredProjectIds, boolean allProjects) {
	   if(CollectionUtils.isEmpty(filteredProjectIds) && !allProjects) {
	    	 return new ArrayList<>();
	     }
	 List<String> clients = new ArrayList<String>();
		ResultSet resultSet = null;
		Statement statement = null;
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
			 builder.deleteCharAt(builder.length() -1 );
			 builder.append(" ) ");
			String newQuery = query;
			 if(CollectionUtils.isNotEmpty(filteredProjectIds) || allProjects) {
				 newQuery = query.replace("%p", builder.toString());
			 }else {
				 newQuery = query.replace("%p", " ");
			 }
			 
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery(formatQuery(newQuery,data.getSchema(),data));
			
		 while(resultSet.next()) {
			 clients.add(resultSet.getString(1));
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
		return clients;
	}	




}
