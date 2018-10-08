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
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hive.connection.ImpalaConnection;
import com.servinglynk.report.bean.Q25aNumberOfVeteransDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q25aNumberOfVeteransDataBeanMaker extends BaseBeanMaker {
	
	
	public static List<Q25aNumberOfVeteransDataBean> getQ25aNumberOfVeteransList(ReportData data){
		
		String query = "select distinct(e.dedup_client_id)  from enrollment e join project p  on (e.projectid = p.id   %p"+
			     " join client c on (e.client_id = c.id and e.entrydate  >=  :startDate and  e.entrydate<=:endDate) "+ 
			     " where 1=1  " ;
				Q25aNumberOfVeteransDataBean q25aNumberOfVeteransTable = new Q25aNumberOfVeteransDataBean();
				try {
					if(data.isLiveMode()) {
						List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
						List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
						List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
						
						List<String> chronicHomelessVeteran = getClients(data, query, null, true, "1", "true");
						List<String> chronicHomelessVeteranWithoutChildren = getClients(data, query, projectsHHWithOutChildren, false, "1", "true");
						List<String> chronicHomelessVeteranWithChildAndAdults = getClients(data, query, projectsHHWithOneAdultChild, false, "1", "true");
						List<String> chronicHomelessVeteranUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, "1", "true");
						int chVeteran = chronicHomelessVeteran != null ? chronicHomelessVeteran.size() : 0;
						int chVeteranWithoutChildren = chronicHomelessVeteranWithoutChildren != null ? chronicHomelessVeteranWithoutChildren.size() : 0;
						int chVeteranWithChildAndAdults = chronicHomelessVeteranWithChildAndAdults != null ? chronicHomelessVeteranWithChildAndAdults.size() : 0;
						int chVeteranUnknownHouseHold = chronicHomelessVeteranUnknownHouseHold != null ? chronicHomelessVeteranUnknownHouseHold.size() : 0 ;
					
						q25aNumberOfVeteransTable.setQ25aChronicallyHomelessVeteranTotal(BigInteger.valueOf(chVeteran));
						q25aNumberOfVeteransTable.setQ25aChronicallyHomelessVeteranWithoutChildren(BigInteger.valueOf(chVeteranWithoutChildren));
						q25aNumberOfVeteransTable.setQ25aChronicallyHomelessVeteranWithChildAndAdults(BigInteger.valueOf(chVeteranWithChildAndAdults));
						q25aNumberOfVeteransTable.setQ25aChronicallyHomelessVeteranUnknownHouseHold(BigInteger.valueOf(chVeteranUnknownHouseHold));
		
						List<String> nonChronicHomelessVeteran = getClients(data, query, null, true, "1", "false");
						List<String> nonChronicHomelessVeteranWithoutChildren = getClients(data, query, projectsHHWithOutChildren, false, "1", "false");
						List<String> nonChronicHomelessVeteranWithChildAndAdults = getClients(data, query, projectsHHWithOneAdultChild, false, "1", "false");
						List<String> nonChronicHomelessVeteranUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, "1", "false");
						int nonChVeteran = nonChronicHomelessVeteran != null ? nonChronicHomelessVeteran.size() : 0 ;
						int nonChVeteranWithoutChildren = nonChronicHomelessVeteranWithoutChildren != null ? nonChronicHomelessVeteranWithoutChildren.size() : 0;
						int nonChVeteranWithChildAndAdults = nonChronicHomelessVeteranWithChildAndAdults != null ? nonChronicHomelessVeteranWithChildAndAdults.size() : 0;	
						int nonChVeteranUnknownHouseHold = nonChronicHomelessVeteranUnknownHouseHold != null ? nonChronicHomelessVeteranUnknownHouseHold.size() : 0;
						
						q25aNumberOfVeteransTable.setQ25aNonChronicallyHomelessVeteranTotal(BigInteger.valueOf(nonChVeteran));
						q25aNumberOfVeteransTable.setQ25aNonChronicallyHomelessVeteranWithoutChildren(BigInteger.valueOf(nonChVeteranWithoutChildren));
						q25aNumberOfVeteransTable.setQ25aNonChronicallyHomelessVeteranWithChildAndAdults(BigInteger.valueOf(nonChVeteranWithChildAndAdults));
						q25aNumberOfVeteransTable.setQ25aNonChronicallyHomelessVeteranUnknownHouseHold(BigInteger.valueOf(nonChVeteranUnknownHouseHold));
		
						List<String> notVeteran = getClients(data, query, null, true, "0", null);
						List<String> notVeteranWithoutChildren = getClients(data, query, projectsHHWithOutChildren, false, "0", null);
						List<String> notVeteranithChildAndAdults = getClients(data, query, projectsHHWithOneAdultChild, false, "0", null);
						List<String> notVeteranUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, "0", null);
						
						int notVeteranSize = notVeteran != null ? notVeteran.size() : 0 ;
						int notVeteranWithoutChildrenSize = notVeteranWithoutChildren != null ? notVeteranWithoutChildren.size() : 0 ;
						int notVeteranithChildAndAdultsSize = notVeteranithChildAndAdults != null ? notVeteranithChildAndAdults.size() :0 ;
						int notVeteranUnknownHouseHoldSize = notVeteranUnknownHouseHold != null ? notVeteranUnknownHouseHold.size() :0 ;
						
						q25aNumberOfVeteransTable.setQ25aNotVeteranTotal(BigInteger.valueOf(notVeteranSize));
						q25aNumberOfVeteransTable.setQ25aNotVeteranWithoutChildren(BigInteger.valueOf(notVeteranWithoutChildrenSize));
						q25aNumberOfVeteransTable.setQ25aNotVeteranWithChildAndAdults(BigInteger.valueOf(notVeteranithChildAndAdultsSize));
						q25aNumberOfVeteransTable.setQ25aNotVeteranUnknownHouseHold(BigInteger.valueOf(notVeteranUnknownHouseHoldSize));
						List<String> clientRefused = getClients(data, query, null, true, "8", null);
						List<String> clientRefusedWithoutChildren = getClients(data, query, projectsHHWithOutChildren, false, "8", null);
						List<String> clientRefusedChildAndAdults = getClients(data, query, projectsHHWithOneAdultChild, false, "8", null);
						List<String> clientRefusedUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, "8", null);
						
						int clientRefusedSize = clientRefused != null ? clientRefused.size() : 0;
						int clientRefusedWithoutChildrenSize = clientRefusedWithoutChildren != null ? clientRefusedWithoutChildren.size() :0 ;
						int clientRefusedChildAndAdultsSize = clientRefusedChildAndAdults != null ? clientRefusedChildAndAdults.size() : 0;
						int clientRefusedUnknownHouseHoldSize = clientRefusedUnknownHouseHold != null ? clientRefusedUnknownHouseHold.size() : 0;
						
						q25aNumberOfVeteransTable.setQ25aClientRefusedTotal(BigInteger.valueOf(clientRefusedSize));
						q25aNumberOfVeteransTable.setQ25aClientRefusedWithoutChildren(BigInteger.valueOf(clientRefusedWithoutChildrenSize));
						q25aNumberOfVeteransTable.setQ25aClientRefusedWithChildAndAdults(BigInteger.valueOf(clientRefusedChildAndAdultsSize));
						q25aNumberOfVeteransTable.setQ25aClientRefusedUnknownHouseHold(BigInteger.valueOf(clientRefusedUnknownHouseHoldSize));
		
						
						List<String> dnc = getClients(data, query, null, true, "99", null);
						List<String> dncWithoutChildren = getClients(data, query, projectsHHWithOutChildren, false, "99", null);
						List<String> dncChildAndAdults = getClients(data, query, projectsHHWithOneAdultChild, false, "99", null);
						List<String> dncUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, "99", null);
						
						int dncSize = dnc != null ? dnc.size() : 0;
						int dncWithoutChildrenSize = dncWithoutChildren != null ? dncWithoutChildren.size() :0 ;
						int dncChildAndAdultsSize = dncChildAndAdults != null ? dncChildAndAdults.size() : 0;
						int dncUnknownHouseHoldSize = dncUnknownHouseHold != null ? dncUnknownHouseHold.size() : 0;
						
						q25aNumberOfVeteransTable.setQ25aDataNotCollectedTotal(BigInteger.valueOf(dncSize));
						q25aNumberOfVeteransTable.setQ25aDataNotCollectedWithoutChildren(BigInteger.valueOf(dncWithoutChildrenSize));
						q25aNumberOfVeteransTable.setQ25aDataNotCollectedWithChildAndAdults(BigInteger.valueOf(dncChildAndAdultsSize));
						q25aNumberOfVeteransTable.setQ25aDataNotCollectedUnknownHouseHold(BigInteger.valueOf(dncUnknownHouseHoldSize));
						
						int total = chVeteran + nonChVeteran + notVeteranSize + chVeteran + clientRefusedSize +dncSize;
						int nonChWithoutChildren =chVeteranWithoutChildren + nonChVeteranWithoutChildren + notVeteranWithoutChildrenSize + clientRefusedWithoutChildrenSize + dncWithoutChildrenSize;
						int nonnonChVeteranWithoutChild =chVeteranWithChildAndAdults + nonChVeteranWithChildAndAdults + notVeteranithChildAndAdultsSize + clientRefusedChildAndAdultsSize + dncChildAndAdultsSize;
						int nonChVeteranUnknown= chVeteranUnknownHouseHold + nonChVeteranUnknownHouseHold + nonChVeteranWithChildAndAdults +notVeteranUnknownHouseHoldSize + clientRefusedUnknownHouseHoldSize + dncUnknownHouseHoldSize ;
						
						
						q25aNumberOfVeteransTable.setQ25aTotTotal(BigInteger.valueOf(total));
						q25aNumberOfVeteransTable.setQ25aTotWithoutChildren(BigInteger.valueOf(nonChWithoutChildren));
						q25aNumberOfVeteransTable.setQ25aTotWithChildAndAdults(BigInteger.valueOf(nonnonChVeteranWithoutChild));
						q25aNumberOfVeteransTable.setQ25aTotUnknownHouseHold(BigInteger.valueOf(nonChVeteranUnknown));
					}	}catch(Exception e){
						logger.error("Error in Q25aNumberOfVeteransDataBeanMaker:" + e);
					}
		
		return Arrays.asList(q25aNumberOfVeteransTable);
	}
	
	
	public static List<String> getClients(ReportData data,String query,List<String> filteredProjectIds, boolean allProjects,String veteranStatus, String  chronicHomeless) {
		 List<String> q22Beans = new ArrayList<String>();
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
				 builder.append(" ) ");
				String newQuery = query.replace("%p", builder.toString());
				
				if(StringUtils.isNotBlank(veteranStatus) && !StringUtils.equals("8", veteranStatus)) {
					newQuery = newQuery + " and veteran_status ='"+veteranStatus+"'" ;
				}
				if(StringUtils.equals("8", veteranStatus)) {
					newQuery = newQuery + " and veteran_status  in ('8','9)' ";
				}
				if(StringUtils.isNotBlank(chronicHomeless)) {
					newQuery = newQuery + " and chronichomeless ='"+chronicHomeless+"' ";
				}
				
				statement = connection.createStatement();
				resultSet = statement.executeQuery(formatQuery(newQuery,data.getSchema(),data));
				
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
