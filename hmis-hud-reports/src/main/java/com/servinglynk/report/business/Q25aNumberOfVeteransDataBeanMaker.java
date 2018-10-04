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
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hive.connection.ImpalaConnection;
import com.servinglynk.report.bean.Q25aNumberOfVeteransDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q25aNumberOfVeteransDataBeanMaker extends BaseBeanMaker {
	
	
	public static List<Q25aNumberOfVeteransDataBean> getQ25aNumberOfVeteransList(ReportData data){
		
		String query = "select distinct(e.dedup_client_id)  from enrollment e join project p  on (e.projectid = p.id   %p"+
			     " join client c on (e.client_id = c.id and e.entrydate  >=  ? and  e.entrydate<=?) "+ 
			     " where c.veteran_status=? and e.chronichomeless=? " +
			     "  order by e.dedup_client_id  "; 
				Q25aNumberOfVeteransDataBean q25aNumberOfVeteransTable = new Q25aNumberOfVeteransDataBean();
				try {
					if(data.isLiveMode()) {
						List<String> chronicHomelessVeteran = getClients(data, query, null, true, "1", "true");
						List<String> chronicHomelessVeteranWithoutChildren = getClients(data, query, null, false, "1", "true");
						List<String> chronicHomelessVeteranWithChildAndAdults = getClients(data, query, null, false, "1", "true");
						List<String> chronicHomelessVeteranUnknownHouseHold = getClients(data, query, null, false, "1", "true");
						
						q25aNumberOfVeteransTable.setQ25aChronicallyHomelessVeteranTotal(BigInteger.valueOf(chronicHomelessVeteran != null ? chronicHomelessVeteran.size() : 0));
						q25aNumberOfVeteransTable.setQ25aChronicallyHomelessVeteranWithoutChildren(BigInteger.valueOf(chronicHomelessVeteranWithoutChildren != null ? chronicHomelessVeteranWithoutChildren.size() : 0));
						q25aNumberOfVeteransTable.setQ25aChronicallyHomelessVeteranWithChildAndAdults(BigInteger.valueOf(chronicHomelessVeteranWithChildAndAdults != null ? chronicHomelessVeteranWithChildAndAdults.size() : 0));
						q25aNumberOfVeteransTable.setQ25aChronicallyHomelessVeteranUnknownHouseHold(BigInteger.valueOf(chronicHomelessVeteranUnknownHouseHold != null ? chronicHomelessVeteranUnknownHouseHold.size() : 0));
		
						List<String> nonChronicHomelessVeteran = getClients(data, query, null, true, "1", "false");
						List<String> nonChronicHomelessVeteranWithoutChildren = getClients(data, query, null, false, "1", "false");
						List<String> nonChronicHomelessVeteranWithChildAndAdults = getClients(data, query, null, false, "1", "false");
						List<String> nonChronicHomelessVeteranUnknownHouseHold = getClients(data, query, null, false, "1", "false");
						
						q25aNumberOfVeteransTable.setQ25aNonChronicallyHomelessVeteranTotal(BigInteger.valueOf(nonChronicHomelessVeteran != null ? nonChronicHomelessVeteran.size() : 0));
						q25aNumberOfVeteransTable.setQ25aNonChronicallyHomelessVeteranWithoutChildren(BigInteger.valueOf(nonChronicHomelessVeteranWithoutChildren != null ? nonChronicHomelessVeteranWithoutChildren.size() : 0));
						q25aNumberOfVeteransTable.setQ25aNonChronicallyHomelessVeteranWithChildAndAdults(BigInteger.valueOf(nonChronicHomelessVeteranWithChildAndAdults != null ? nonChronicHomelessVeteranWithChildAndAdults.size() : 0));
						q25aNumberOfVeteransTable.setQ25aNonChronicallyHomelessVeteranUnknownHouseHold(BigInteger.valueOf(nonChronicHomelessVeteranUnknownHouseHold != null ? nonChronicHomelessVeteranUnknownHouseHold.size() : 0));
		
						List<String> notVeteran = getClients(data, query, null, true, "0", null);
						List<String> notVeteranWithoutChildren = getClients(data, query, null, false, "0", null);
						List<String> notVeteranithChildAndAdults = getClients(data, query, null, false, "0", null);
						List<String> notVeteranUnknownHouseHold = getClients(data, query, null, false, "0", null);
						
						q25aNumberOfVeteransTable.setQ25aNotVeteranTotal(BigInteger.valueOf(0));
						q25aNumberOfVeteransTable.setQ25aNotVeteranWithoutChildren(BigInteger.valueOf(0));
						q25aNumberOfVeteransTable.setQ25aNotVeteranWithChildAndAdults(BigInteger.valueOf(0));
						q25aNumberOfVeteransTable.setQ25aNotVeteranUnknownHouseHold(BigInteger.valueOf(0));
		
						q25aNumberOfVeteransTable.setQ25aClientRefusedTotal(BigInteger.valueOf(0));
						q25aNumberOfVeteransTable.setQ25aClientRefusedWithoutChildren(BigInteger.valueOf(0));
						q25aNumberOfVeteransTable.setQ25aClientRefusedWithChildAndAdults(BigInteger.valueOf(0));
						q25aNumberOfVeteransTable.setQ25aClientRefusedUnknownHouseHold(BigInteger.valueOf(0));
		
						q25aNumberOfVeteransTable.setQ25aDataNotCollectedTotal(BigInteger.valueOf(0));
						q25aNumberOfVeteransTable.setQ25aDataNotCollectedWithoutChildren(BigInteger.valueOf(0));
						q25aNumberOfVeteransTable.setQ25aDataNotCollectedWithChildAndAdults(BigInteger.valueOf(0));
						q25aNumberOfVeteransTable.setQ25aDataNotCollectedUnknownHouseHold(BigInteger.valueOf(0));
		
						q25aNumberOfVeteransTable.setQ25aTotTotal(BigInteger.valueOf(0));
						q25aNumberOfVeteransTable.setQ25aTotWithoutChildren(BigInteger.valueOf(0));
						q25aNumberOfVeteransTable.setQ25aTotWithChildAndAdults(BigInteger.valueOf(0));
						q25aNumberOfVeteransTable.setQ25aTotUnknownHouseHold(BigInteger.valueOf(0));
					}	}catch(Exception e){
						logger.error("Error in Q25aNumberOfVeteransDataBeanMaker:" + e);
					}
		
		return Arrays.asList(q25aNumberOfVeteransTable);
	}
	
	
	public static List<String> getClients(ReportData data,String query,List<String> filteredProjectIds, boolean allProjects,String veteranStatus, String  chronicHomeless) {
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
				if(StringUtils.isNotBlank(veteranStatus) && !StringUtils.equals("8", veteranStatus)) {
					newQuery = newQuery.replace("%h"," and veteran_status ='"+veteranStatus+"'");
				}
				if(StringUtils.equals("8", veteranStatus)) {
					newQuery = newQuery.replace("%h"," and housingassessment  in ('8','9)' ");
				}
				if(StringUtils.isNotBlank(chronicHomeless)) {
					newQuery = newQuery.replace("%h"," and chronichomeless ='"+chronicHomeless+"'");
				}
				
				statement = connection.prepareStatement(formatQuery(newQuery,data.getSchema()));
				statement.setDate(1, data.getReportStartDate());
				statement.setDate(2, data.getReportEndDate());
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
