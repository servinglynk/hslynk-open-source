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
import com.servinglynk.report.bean.Q25cGenderVeteransDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q25cGenderVeteransDataBeanMaker extends BaseBeanMaker {
	
	public static List<Q25cGenderVeteransDataBean> getQ25cGenderVeteransList(ReportData data){
		
		String query = "select distinct(e.dedup_client_id)  from %s.enrollment e join %s.project p  on (e.projectid = p.id   %p ) "+
			     " join %s.client c on (e.client_id = c.id and e.entrydate  >=  :startDate and  e.entrydate<=:endDate) "+ 
			     " where  1=1 ";
				Q25cGenderVeteransDataBean q25cGenderVeteranTable = new Q25cGenderVeteransDataBean();
				try {
					if(data.isLiveMode()) {
						List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
						List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
						List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
						
						List<String> male = getClients(data, query, null, true, "1", "1");
						List<String> maleWithoutChildren = getClients(data, query, projectsHHWithOutChildren, false, "1", "1");
						List<String> maleWithChildAndAdults = getClients(data, query, projectsHHWithOneAdultChild, false, "1", "1");
						List<String> maleUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, "1", "1");
						
						int  maleSize = getSize(male);
						int maleWithoutChildrenSize = getSize(maleWithoutChildren);
						int maleWithChildAndAdultsSize = getSize(maleWithChildAndAdults);
						int maleUnknownHouseHoldSize = getSize(maleUnknownHouseHold);
						
						q25cGenderVeteranTable.setQ25cMaleTotal(BigInteger.valueOf(maleSize));
						q25cGenderVeteranTable.setQ25cMaleWithoutChildren(BigInteger.valueOf(maleWithoutChildrenSize));
						q25cGenderVeteranTable.setQ25cMaleWithChildAndAdults(BigInteger.valueOf(maleWithChildAndAdultsSize));
						q25cGenderVeteranTable.setQ25cMaleUnknownHouseHold(BigInteger.valueOf(maleUnknownHouseHoldSize));
		
						List<String> female = getClients(data, query, null, true, "1", "0");
						List<String> femaleWithoutChildren = getClients(data, query, projectsHHWithOutChildren, false, "1", "0");
						List<String> femaleWithChildAndAdults = getClients(data, query, projectsHHWithOneAdultChild, false, "1", "0");
						List<String> femaleUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, "1", "0");
						
						int femaleSize = getSize(female);
						int femaleWithoutChildrenSize = getSize(femaleWithoutChildren);
						int femaleWithChildAndAdultsSize = getSize(femaleWithChildAndAdults);
						int femaleUnknownHouseHoldSize = getSize(femaleUnknownHouseHold);
						
						q25cGenderVeteranTable.setQ25cFemaleTotal(BigInteger.valueOf(femaleSize));
						q25cGenderVeteranTable.setQ25cFemaleWithoutChildren(BigInteger.valueOf(femaleWithoutChildrenSize));
						q25cGenderVeteranTable.setQ25cFemaleWithChildAndAdults(BigInteger.valueOf(femaleWithChildAndAdultsSize));
						q25cGenderVeteranTable.setQ25cFemaleUnknownHouseHold(BigInteger.valueOf(femaleUnknownHouseHoldSize));
		
						List<String> transgenderMaleToFemale = getClients(data, query, null, true, "1", "2");
						List<String> transgenderMaleToFemaleWithoutChildren = getClients(data, query, projectsHHWithOutChildren, false, "1", "2");
						List<String> transgenderMaleToFemaleWithChildAndAdults = getClients(data, query, projectsHHWithOneAdultChild, false, "1", "2");
						List<String> transgenderMaleToFemaleUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, "1", "2");
						
						int transgenderMaleToFemaleSize = getSize(transgenderMaleToFemale);
						int transgenderMaleToFemaleWithoutChildrenSize = getSize(transgenderMaleToFemaleWithoutChildren);
						int transgenderMaleToFemaleWithChildAndAdultsSize = getSize(transgenderMaleToFemaleWithChildAndAdults);
						int transgenderMaleToFemaleUnknownHouseHoldSize = getSize(transgenderMaleToFemaleUnknownHouseHold);
						
						q25cGenderVeteranTable.setQ25cTransgenderMaleToFemaleTotal(BigInteger.valueOf(transgenderMaleToFemaleSize));
						q25cGenderVeteranTable.setQ25cTransgenderMaleToFemaleWithoutChildren(BigInteger.valueOf(transgenderMaleToFemaleWithoutChildrenSize));
						q25cGenderVeteranTable.setQ25cTransgenderMaleToFemaleWithChildAndAdults(BigInteger.valueOf(transgenderMaleToFemaleWithChildAndAdultsSize));
						q25cGenderVeteranTable.setQ25cTransgenderMaleToFemaleUnknownHouseHold(BigInteger.valueOf(transgenderMaleToFemaleUnknownHouseHoldSize));
		
						List<String> transgendereFemaleToMale = getClients(data, query, null, true, "1", "3");
						List<String> transgendereFemaleToMaleWithoutChildren = getClients(data, query, projectsHHWithOutChildren, false, "1", "3");
						List<String> transgendereFemaleToMaleithChildAndAdults = getClients(data, query, projectsHHWithOneAdultChild, false, "1", "3");
						List<String> transgendereFemaleToMaleUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, "1", "3");
						
						int transgendereFemaleToMaleSize = getSize(transgendereFemaleToMale);
						int transgendereFemaleToMaleWithoutChildrenSize = getSize(transgendereFemaleToMaleWithoutChildren);
						int transgendereFemaleToMaleWithChildAndAdultsSize = getSize(transgendereFemaleToMaleithChildAndAdults);
						int transgendereFemaleToMaleUnknownHouseHoldSize = getSize(transgendereFemaleToMaleUnknownHouseHold);
						
						q25cGenderVeteranTable.setQ25cTransgendereFemaleToMaleTotal(BigInteger.valueOf(transgendereFemaleToMaleSize));
						q25cGenderVeteranTable.setQ25cTransgendereFemaleToMaleWithoutChildren(BigInteger.valueOf(transgendereFemaleToMaleWithoutChildrenSize));
						q25cGenderVeteranTable.setQ25cTransgendereFemaleToMaleWithChildAndAdults(BigInteger.valueOf(transgendereFemaleToMaleWithChildAndAdultsSize));
						q25cGenderVeteranTable.setQ25cTransgendereFemaleToMaleUnknownHouseHold(BigInteger.valueOf(transgendereFemaleToMaleUnknownHouseHoldSize));
		
						List<String> other = getClients(data, query, null, true, "1", "4");
						List<String> otherWithoutChildren = getClients(data, query, projectsHHWithOutChildren, false, "1", "4");
						List<String> otherWithChildAndAdults = getClients(data, query, projectsHHWithOneAdultChild, false, "1", "4");
						List<String> otherUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, "1", "4");
						
						int otherSize = getSize(other);
						int otherWithoutChildrenSize = getSize(otherWithoutChildren);
						int otherWithChildAndAdultsSize = getSize(otherWithChildAndAdults);
						int otherUnknownHouseHoldSize = getSize(otherUnknownHouseHold);
						
						q25cGenderVeteranTable.setQ25cOtherTotal(BigInteger.valueOf(otherSize));
						q25cGenderVeteranTable.setQ25cOtherWithoutChildren(BigInteger.valueOf(otherWithoutChildrenSize));
						q25cGenderVeteranTable.setQ25cOtherWithChildAndAdults(BigInteger.valueOf(otherWithChildAndAdultsSize));
						q25cGenderVeteranTable.setQ25cOtherUnknownHouseHold(BigInteger.valueOf(otherUnknownHouseHoldSize));
						
						List<String> dk =  getClients(data, query, null, true, "1", "8");
						List<String> dkWithoutChildren =  getClients(data, query, projectsHHWithOutChildren, false, "1", "8");
						List<String> dkWithChildAndAdults =  getClients(data, query, projectsHHWithOneAdultChild, false, "1", "8");
						List<String> dkUnknownHouseHold =  getClients(data, query, projectsUnknownHouseHold, false, "1", "8");
						
						int dkSize = getSize(dk);
						int dkWithoutChildrenSize = getSize(dkWithoutChildren);
						int dkWithChildAndAdultsSize = getSize(dkWithChildAndAdults);
						int dkUnknownHouseHoldSize = getSize(dkUnknownHouseHold);
						
						q25cGenderVeteranTable.setQ25cDKRTotal(BigInteger.valueOf(dkSize));
						q25cGenderVeteranTable.setQ25cDKRWithoutChildren(BigInteger.valueOf(dkWithoutChildrenSize));
						q25cGenderVeteranTable.setQ25cDKRWithChildAndAdults(BigInteger.valueOf(dkWithChildAndAdultsSize));
						q25cGenderVeteranTable.setQ25cDKRUnknownHouseHold(BigInteger.valueOf(dkUnknownHouseHoldSize));
		
						List<String> informationMissing =  getClients(data, query, null, true, "1", "99");
						List<String> informationMissingWithoutChildren =  getClients(data, query, projectsHHWithOutChildren, false, "1", "99");
						List<String> informationMissingWithChildAndAdults =  getClients(data, query, projectsHHWithOneAdultChild, false, "1", "99");
						List<String> informationMissingUnknownHouseHold =  getClients(data, query, projectsUnknownHouseHold, false, "1", "99");
						
						int informationMissingSize = getSize(informationMissing);
						int informationMissingWithoutChildrenSize = getSize(informationMissingWithoutChildren);
						int informationMissingWithChildAndAdultsSize = getSize(informationMissingWithChildAndAdults);
						int informationMissingUnknownHouseHoldSize = getSize(informationMissingUnknownHouseHold);
						
						q25cGenderVeteranTable.setQ25cInformationMissingTotal(BigInteger.valueOf(informationMissingSize));
						q25cGenderVeteranTable.setQ25cInformationMissingWithoutChildren(BigInteger.valueOf(informationMissingWithoutChildrenSize));
						q25cGenderVeteranTable.setQ25cInformationMissingWithChildAndAdults(BigInteger.valueOf(informationMissingWithChildAndAdultsSize));
						q25cGenderVeteranTable.setQ25cInformationMissingUnknownHouseHold(BigInteger.valueOf(informationMissingUnknownHouseHoldSize));
								
						int total = maleSize + femaleSize + transgenderMaleToFemaleSize + transgendereFemaleToMaleSize + otherSize + dkSize + informationMissingSize ;
						int withOutChildren = maleWithoutChildrenSize + femaleWithoutChildrenSize + transgenderMaleToFemaleWithoutChildrenSize + transgendereFemaleToMaleWithoutChildrenSize + otherWithoutChildrenSize + dkWithoutChildrenSize + otherWithoutChildrenSize ;
						int withChildAndAdults =maleWithChildAndAdultsSize + femaleWithChildAndAdultsSize + transgenderMaleToFemaleWithChildAndAdultsSize + transgendereFemaleToMaleWithChildAndAdultsSize + otherWithChildAndAdultsSize + dkWithChildAndAdultsSize + informationMissingWithChildAndAdultsSize;
						int unknownHouseHold = maleUnknownHouseHoldSize + femaleUnknownHouseHoldSize + transgenderMaleToFemaleUnknownHouseHoldSize + transgendereFemaleToMaleUnknownHouseHoldSize + otherUnknownHouseHoldSize + dkUnknownHouseHoldSize + informationMissingUnknownHouseHoldSize;
						
						q25cGenderVeteranTable.setQ25cTotTotal(BigInteger.valueOf(total));
						q25cGenderVeteranTable.setQ25cTotWithoutChildren(BigInteger.valueOf(withOutChildren));
						q25cGenderVeteranTable.setQ25cTotWithChildAndAdults(BigInteger.valueOf(withChildAndAdults));
						q25cGenderVeteranTable.setQ25cTotUnknownHouseHold(BigInteger.valueOf(unknownHouseHold));
					}
			}catch(Exception e){
						logger.error("Error in Q25aNumberOfVeteransDataBeanMaker:" + e);
		}
		
		return Arrays.asList(q25cGenderVeteranTable);
	}
	
	public static List<String> getClients(ReportData data,String query,List<String> filteredProjectIds, boolean allProjects,String veteranStatus, String  gender) {
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
				 builder.deleteCharAt(builder.length()-1);
				 builder.append(" ) ");
				String newQuery = query;
				 if(CollectionUtils.isNotEmpty(filteredProjectIds)) {
					 newQuery = query.replace("%p", builder.toString());
				 }else {
					 newQuery = query.replace("%p", " ");
				 }
				
				if(StringUtils.isNotBlank(veteranStatus) && !StringUtils.equals("8", veteranStatus)) {
					newQuery = newQuery + " and veteran_status ='"+veteranStatus+"'" ;
				}
				if(StringUtils.equals("8", veteranStatus)) {
					newQuery = newQuery + " and veteran_status  in ('8','9') ";
				}
				if(StringUtils.isNotBlank(gender) && !StringUtils.equals("8", gender)) {
					newQuery = newQuery + " and gender ='"+gender+"' ";
				}
				if(StringUtils.equals("8", veteranStatus)) {
					newQuery = newQuery + " and gender  in ('8','9') ";
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
