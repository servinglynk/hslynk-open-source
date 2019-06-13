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
import com.servinglynk.report.bean.Q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBeanMaker extends BaseBeanMaker{
	
	public static List<Q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean> getQ26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyList(ReportData data){
		
		Q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable = new Q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean();
		
		try {
			if(data.isLiveMode()) {
				List<String> projectsHHWithChildren = data.getProjectsHHWithChildren();
				List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
				List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
				List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
				
				String chronicHomelessQuery ="select distinct(e.dedup_client_id) from %s.enrollment e,%s.client c,%s.project p  where c.id =e.client_id and e.chronichomeless=true and entrydate >=:startDate and entrydate <=:endDate and e.projectid = p.id %p  ";
				String noChronicHomelessQuery ="select distinct(e.dedup_client_id) from %s.enrollment e,%s.client c,%s.project p  where c.id =e.client_id and e.chronichomeless=false  and entrydate >=:startDate and entrydate <=:endDate and e.projectid = p.id %p  ";
				String dnKChHomelessQuery ="select distinct(e.dedup_client_id) from %s.enrollment e,%s.client c,%s.project p  where c.id =e.client_id  and e.disablingcondition in ('8','9')  and entrydate >=:startDate and entrydate <=:endDate  and e.projectid = p.id %p  ";
				String dnCChHomelessQuery ="select distinct(e.dedup_client_id) from %s.enrollment e,%s.client c,%s.project p  where c.id =e.client_id and e.disablingcondition ='99'  and entrydate >=:startDate and entrydate <=:endDate  and e.projectid = p.id %p  ";
				
				int chSize = getSize(data.getChronicHomeLess());
				int chWithoutChildSize = getSize(getClients(data, chronicHomelessQuery, projectsHHWithOutChildren, false));
				int chChildAndAdultsSize = getSize(getClients(data, chronicHomelessQuery, projectsHHWithOneAdultChild, false));
				int chWithOnlyChildSize = getSize(getClients(data, chronicHomelessQuery, projectsHHWithChildren, false));
				int chUnknownHouseHoldSize = getSize(getClients(data, chronicHomelessQuery, projectsUnknownHouseHold, false));
				
				q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aChronicallyHomelessTotal(BigInteger.valueOf(getSize(data.getChronicHomeLess())));
				q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aChronicallyHomelessWithoutChild(BigInteger.valueOf(chWithoutChildSize));
				q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aChronicallyHomelessWithChildAndAdults(BigInteger.valueOf(chChildAndAdultsSize));
				q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aChronicallyHomelessWithOnlyChild(BigInteger.valueOf(chWithOnlyChildSize));
				q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aChronicallyHomelessUnknownHouseholdType(BigInteger.valueOf(chUnknownHouseHoldSize));

				int noChSize = getSize(getClients(data, noChronicHomelessQuery, null, true));
				int noChWithoutChildSize = getSize(getClients(data, chronicHomelessQuery, projectsHHWithOutChildren, false));
				int noChChildAndAdultsSize = getSize(getClients(data, chronicHomelessQuery, projectsHHWithOneAdultChild, false));
				int noChWithOnlyChildSize = getSize(getClients(data, chronicHomelessQuery, projectsHHWithChildren, false));
				int noChUnknownHouseHoldSize = getSize(getClients(data, chronicHomelessQuery, projectsUnknownHouseHold, false));
				
				q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aNotChronicallyHomelessTotal(BigInteger.valueOf(noChSize));
				q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aNotChronicallyHomelessWithoutChild(BigInteger.valueOf(noChWithoutChildSize));
				q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aNotChronicallyHomelessWithChildAndAdults(BigInteger.valueOf(noChChildAndAdultsSize));
				q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aNotChronicallyHomelessWithOnlyChild(BigInteger.valueOf(noChWithOnlyChildSize));
				q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aNotChronicallyHomelessUnknownHouseholdType(BigInteger.valueOf(noChUnknownHouseHoldSize));
				
				int clientRefusedCHSize = getSize(getClients(data, dnKChHomelessQuery, null, true));
				int clientRefusedCHWithoutChildSize = getSize(getClients(data, chronicHomelessQuery, projectsHHWithOutChildren, false));
				int clientRefusedCHChildAndAdultsSize = getSize(getClients(data, chronicHomelessQuery, projectsHHWithOneAdultChild, false));
				int clientRefusedCHWithOnlyChildSize = getSize(getClients(data, chronicHomelessQuery, projectsHHWithChildren, false));
				int clientRefusedCHUnknownHouseHoldSize = getSize(getClients(data, chronicHomelessQuery, projectsUnknownHouseHold, false));
				
				q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aClientRefusedTotal(BigInteger.valueOf(clientRefusedCHSize));
				q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aClientRefusedWithoutChild(BigInteger.valueOf(clientRefusedCHWithoutChildSize));
				q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aClientRefusedWithChildAndAdults(BigInteger.valueOf(clientRefusedCHChildAndAdultsSize));
				q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aClientRefusedWithOnlyChild(BigInteger.valueOf(clientRefusedCHWithOnlyChildSize));
				q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aClientRefusedUnknownHouseholdType(BigInteger.valueOf(clientRefusedCHUnknownHouseHoldSize));
				
				int dncCHSize = getSize(getClients(data, dnCChHomelessQuery, null, true));
				int dncCHHWithoutChildSize = getSize(getClients(data, chronicHomelessQuery, projectsHHWithOutChildren, false));
				int dncCHChildAndAdultsSize = getSize(getClients(data, chronicHomelessQuery, projectsHHWithOneAdultChild, false));
				int dncCHWithOnlyChildSize = getSize(getClients(data, chronicHomelessQuery, projectsHHWithChildren, false));
				int dncCHUnknownHouseHoldSize = getSize(getClients(data, chronicHomelessQuery, projectsUnknownHouseHold, false));
				
				q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aDataNotCollectedTotal(BigInteger.valueOf(dncCHSize));
				q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aDataNotCollectedWithoutChild(BigInteger.valueOf(dncCHHWithoutChildSize));
				q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aDataNotCollectedWithChildAndAdults(BigInteger.valueOf(dncCHChildAndAdultsSize));
				q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aDataNotCollectedWithOnlyChild(BigInteger.valueOf(dncCHWithOnlyChildSize));
				q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aDataNotCollectedUnknownHouseholdType(BigInteger.valueOf(dncCHUnknownHouseHoldSize));
				
				
				int total = chSize + noChSize + clientRefusedCHSize + dncCHSize ;
				int withOutChild = chWithoutChildSize + noChWithoutChildSize + clientRefusedCHWithoutChildSize + dncCHHWithoutChildSize ;
				int withChildAndAdults = chChildAndAdultsSize + noChWithOnlyChildSize + clientRefusedCHChildAndAdultsSize + dncCHChildAndAdultsSize;
				int withOnlyChild = chWithOnlyChildSize + noChWithOnlyChildSize + clientRefusedCHWithOnlyChildSize + dncCHWithOnlyChildSize;
				int unknownHouseholdType = chUnknownHouseHoldSize + noChUnknownHouseHoldSize + clientRefusedCHUnknownHouseHoldSize + dncCHUnknownHouseHoldSize;
				
				q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aTotTotal(BigInteger.valueOf(total));
				q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aTotWithoutChild(BigInteger.valueOf(withOutChild));
				q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aTotWithChildAndAdults(BigInteger.valueOf(withChildAndAdults));
				q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aTotWithOnlyChild(BigInteger.valueOf(withOnlyChild));
				q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aTotUnknownHouseholdType(BigInteger.valueOf(unknownHouseholdType));
			}
		}catch(Exception e) {
			logger.error("Error in Q26aBeanMaker:" + e);
		}
		
		return Arrays.asList(q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable); 
		
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
