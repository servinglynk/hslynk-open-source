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
import com.servinglynk.report.bean.Q25dAgeVeteransDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q25dAgeVeteransDataBeanMaker extends BaseBeanMaker {

	public static List<Q25dAgeVeteransDataBean> getQ25dAgeVeteransList(ReportData data){
		String query = "select distinct(e.dedup_client_id)  from %s.enrollment e join %s.project p  on (e.projectid = p.id   %p"+
			     " join %s.client c on (e.client_id = c.id and e.entrydate  >=  ? and  e.entrydate<=?) "+ 
			     " where  c.veteran_status='1'  ";

		Q25dAgeVeteransDataBean q25dAgeVeteransTable = new Q25dAgeVeteransDataBean();
		try {
			if(data.isLiveMode()) {
				q25dAgeVeteransTable.setQ25d18To24Total(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d18To24WithoutChildren(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d18To24WithChildAndAdults(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d18To24UnknownHouseHold(BigInteger.valueOf(0));

				q25dAgeVeteransTable.setQ25d25To34Total(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d25To34WithoutChildren(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d25To34WithChildAndAdults(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d25To34UnknownHouseHold(BigInteger.valueOf(0));

				q25dAgeVeteransTable.setQ25d35To44Total(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d35To44WithoutChildren(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d35To44WithChildAndAdults(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d35To44UnknownHouseHold(BigInteger.valueOf(0));

				q25dAgeVeteransTable.setQ25d45To54Total(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d45To54WithoutChildren(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d45To54WithChildAndAdults(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d45To54UnknownHouseHold(BigInteger.valueOf(0));

				q25dAgeVeteransTable.setQ25d55To61Total(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d55To61WithoutChildren(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d55To61WithChildAndAdults(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d55To61UnknownHouseHold(BigInteger.valueOf(0));

				q25dAgeVeteransTable.setQ25d62PlusTotal(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d62PlusWithoutChildren(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d62PlusWithChildAndAdults(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d62PlusUnknownHouseHold(BigInteger.valueOf(0));

				q25dAgeVeteransTable.setQ25dDKRTotal(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25dDKRWithoutChildren(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25dDKRWithChildAndAdults(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25dDKRUnknownHouseHold(BigInteger.valueOf(0));

				q25dAgeVeteransTable.setQ25dInformationMissingTotal(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25dInformationMissingWithoutChildren(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25dInformationMissingWithChildAndAdults(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25dInformationMissingUnknownHouseHold(BigInteger.valueOf(0));

				q25dAgeVeteransTable.setQ25dTotTotal(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25dTotWithoutChildren(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25dTotWithChildAndAdults(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25dTotUnknownHouseHold(BigInteger.valueOf(0));
						
			}	
	}catch(Exception e){
		logger.error("Error in Q25aNumberOfVeteransDataBeanMaker:" + e);
		}
		return Arrays.asList(q25dAgeVeteransTable);
	}
	
	public static List<String> getClients(ReportData data,String query,List<String> filteredProjectIds, boolean allProjects,String dobdataquality, int  startAge,int endAge) {
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
				
				if(StringUtils.isNotBlank(dobdataquality) && !StringUtils.equals("8", dobdataquality)) {
					newQuery = newQuery + " and c.dob_data_quality ='"+dobdataquality+"' ";
				}
				if(StringUtils.equals("8", dobdataquality)) {
					newQuery = newQuery + " and c.dob_data_quality  in ('8','9)' ";
				}
				if(StringUtils.isBlank(dobdataquality)) {
					newQuery = newQuery + " and c.age  >="+startAge+ " and c.age <="+ endAge;
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
