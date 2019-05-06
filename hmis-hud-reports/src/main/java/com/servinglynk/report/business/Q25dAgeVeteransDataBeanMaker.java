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
import com.servinglynk.report.bean.Q25dAgeVeteransDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;

public class Q25dAgeVeteransDataBeanMaker extends BaseBeanMaker {

	public static List<Q25dAgeVeteransDataBean> getQ25dAgeVeteransList(ReportData data){
		String query = "select distinct(e.dedup_client_id)  from %s.enrollment e join %s.project p  on (e.projectid = p.id   %p ) "+
			     " join %s.client c on e.client_id = c.id   "+ 
			     " where  c.veteran_status='1' and e.entrydate<=:endDate ";

		Q25dAgeVeteransDataBean q25dAgeVeteransTable = new Q25dAgeVeteransDataBean();
		try {
			if(data.isLiveMode()) {
				List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
				List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
				List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
				
				List<String> clients18To24 = getClients(data, query, null, true, null, 18, 24);
				List<String> clients18To24WithoutChildren = getClients(data, query, projectsHHWithOutChildren, false, null, 18, 24);
				List<String> clients18To24WithOneAdultChild = getClients(data, query, projectsHHWithOneAdultChild, false, null, 18, 24);
				List<String> clients18To24UnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, null, 18, 24);
				int clients18To24Size = getSize(clients18To24);
				int clients18To24WithoutChildrenSize = getSize(clients18To24WithoutChildren);
				int clients18To24WithOneAdultChildSize = getSize(clients18To24WithOneAdultChild);
				int clients18To24UnknownHouseHoldSize = getSize(clients18To24UnknownHouseHold);
				
				q25dAgeVeteransTable.setQ25d18To24Total(BigInteger.valueOf(clients18To24Size));
				q25dAgeVeteransTable.setQ25d18To24WithoutChildren(BigInteger.valueOf(clients18To24WithoutChildrenSize));
				q25dAgeVeteransTable.setQ25d18To24WithChildAndAdults(BigInteger.valueOf(clients18To24WithOneAdultChildSize));
				q25dAgeVeteransTable.setQ25d18To24UnknownHouseHold(BigInteger.valueOf(clients18To24UnknownHouseHoldSize));

				List<String> clients25To34 = getClients(data, query, null, true, null, 25, 34);
				List<String> clients25To34WithoutChildren = getClients(data, query, projectsHHWithOutChildren, false, null, 25, 34);
				List<String> clients25To34WithOneAdultChild = getClients(data, query, projectsHHWithOneAdultChild, false, null, 25, 34);
				List<String> clients25To34UnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, null, 25, 34);
				int clients25To34Size = getSize(clients25To34);
				int clients25To34WithoutChildrenSize = getSize(clients25To34WithoutChildren);
				int clients25To34WithOneAdultChildSize = getSize(clients25To34WithOneAdultChild);
				int clients25To34UnknownHouseHoldSize = getSize(clients25To34UnknownHouseHold);
				
				q25dAgeVeteransTable.setQ25d25To34Total(BigInteger.valueOf(clients25To34Size));
				q25dAgeVeteransTable.setQ25d25To34WithoutChildren(BigInteger.valueOf(clients25To34WithoutChildrenSize));
				q25dAgeVeteransTable.setQ25d25To34WithChildAndAdults(BigInteger.valueOf(clients25To34WithOneAdultChildSize));
				q25dAgeVeteransTable.setQ25d25To34UnknownHouseHold(BigInteger.valueOf(clients25To34UnknownHouseHoldSize));

				List<String> clients35To44 = getClients(data, query, null, true, null, 35, 44);
				List<String> clients35To44WithoutChildren = getClients(data, query, projectsHHWithOutChildren, false, null, 35, 44);
				List<String> clients35To44WithOneAdultChild = getClients(data, query, projectsHHWithOneAdultChild, false, null, 35, 44);
				List<String> clients35To44UnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, null, 35, 44);
				
				int clients35To44Size = getSize(clients35To44);
				int clients35To44WithoutChildrenSize = getSize(clients35To44WithoutChildren);
				int clients35To44WithOneAdultChildSize = getSize(clients35To44WithOneAdultChild);
				int clients35To44UnknownHouseHoldSize = getSize(clients35To44UnknownHouseHold);
				
				
				q25dAgeVeteransTable.setQ25d35To44Total(BigInteger.valueOf(clients35To44Size));
				q25dAgeVeteransTable.setQ25d35To44WithoutChildren(BigInteger.valueOf(clients35To44WithoutChildrenSize));
				q25dAgeVeteransTable.setQ25d35To44WithChildAndAdults(BigInteger.valueOf(clients35To44WithOneAdultChildSize));
				q25dAgeVeteransTable.setQ25d35To44UnknownHouseHold(BigInteger.valueOf(clients35To44UnknownHouseHoldSize));

				List<String> clients45To54 = getClients(data, query, null, true, null, 45, 54);
				List<String> clients45To54WithoutChildren = getClients(data, query, projectsHHWithOutChildren, false, null, 45, 54);
				List<String> clients45To54WithOneAdultChild = getClients(data, query, projectsHHWithOneAdultChild, false, null, 45, 54);
				List<String> clients45To54UnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, null, 45, 54);
				
				int clients45To54Size = getSize(clients45To54);
				int clients45To54WithoutChildrenSize = getSize(clients45To54WithoutChildren);
				int clients45To54WithOneAdultChildSize = getSize(clients45To54WithOneAdultChild);
				int clients45To54UnknownHouseHoldSize = getSize(clients45To54UnknownHouseHold);
				
				q25dAgeVeteransTable.setQ25d45To54Total(BigInteger.valueOf(clients45To54Size));
				q25dAgeVeteransTable.setQ25d45To54WithoutChildren(BigInteger.valueOf(clients45To54WithoutChildrenSize));
				q25dAgeVeteransTable.setQ25d45To54WithChildAndAdults(BigInteger.valueOf(clients45To54WithOneAdultChildSize));
				q25dAgeVeteransTable.setQ25d45To54UnknownHouseHold(BigInteger.valueOf(clients45To54UnknownHouseHoldSize));

				List<String> clients55To61 = getClients(data, query, null, true, null, 55, 61);
				List<String> clients55To61WithoutChildren = getClients(data, query, projectsHHWithOutChildren, false, null, 55, 61);
				List<String> clients55To61WithOneAdultChild = getClients(data, query, projectsHHWithOneAdultChild, false, null, 55, 61);
				List<String> clients55To61UnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, null, 55, 61);

				int clients55To61Size = getSize(clients55To61);
				int clients55To61WithoutChildrenSize = getSize(clients55To61WithoutChildren);
				int clients55To61WithOneAdultChildSize = getSize(clients55To61WithOneAdultChild);
				int clients55To61UnknownHouseHoldSize = getSize(clients55To61UnknownHouseHold);
				
				
				q25dAgeVeteransTable.setQ25d55To61Total(BigInteger.valueOf(clients55To61Size));
				q25dAgeVeteransTable.setQ25d55To61WithoutChildren(BigInteger.valueOf(clients55To61WithoutChildrenSize));
				q25dAgeVeteransTable.setQ25d55To61WithChildAndAdults(BigInteger.valueOf(clients55To61WithOneAdultChildSize));
				q25dAgeVeteransTable.setQ25d55To61UnknownHouseHold(BigInteger.valueOf(clients55To61UnknownHouseHoldSize));

				List<String> clients62Plus = getClients(data, query, null, true, null, 62, 0);
				List<String> clients62PlusWithoutChildren = getClients(data, query, projectsHHWithOutChildren, false, null, 62, 0);
				List<String> clients62PlusWithOneAdultChild = getClients(data, query, projectsHHWithOneAdultChild, false, null, 62, 0);
				List<String> clients62PlusUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, null, 62, 0);
				
				int clients62PlusSize = getSize(clients62Plus);
				int clients62PlusWithoutChildrenSize = getSize(clients62PlusWithoutChildren);
				int clients62PlusWithOneAdultChildSize = getSize(clients62PlusWithOneAdultChild);
				int clients62PlusUnknownHouseHoldSize = getSize(clients62PlusUnknownHouseHold);
				
				
				q25dAgeVeteransTable.setQ25d62PlusTotal(BigInteger.valueOf(clients62PlusSize));
				q25dAgeVeteransTable.setQ25d62PlusWithoutChildren(BigInteger.valueOf(clients62PlusWithoutChildrenSize));
				q25dAgeVeteransTable.setQ25d62PlusWithChildAndAdults(BigInteger.valueOf(clients62PlusWithOneAdultChildSize));
				q25dAgeVeteransTable.setQ25d62PlusUnknownHouseHold(BigInteger.valueOf(clients62PlusUnknownHouseHoldSize));
				
				List<String> clientsDKR = getClients(data, query, null, true,"8", 0, 0);
				List<String> clientsDKRWithoutChildren = getClients(data, query, projectsHHWithOutChildren, false, "8", 0, 0);
				List<String> clientsDKRWithOneAdultChild = getClients(data, query, projectsHHWithOneAdultChild, false, "8", 0, 0);
				List<String> clientsDKRUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, "8", 0, 0);
				
				int clientsDKRSize = getSize(clientsDKR);
				int clientsDKRWithoutChildrenSize = getSize(clientsDKRWithoutChildren);
				int clientsDKRWithOneAdultChildSize = getSize(clientsDKRWithOneAdultChild);
				int clientsDKRUnknownHouseHoldSize = getSize(clientsDKRUnknownHouseHold);
				
				q25dAgeVeteransTable.setQ25dDKRTotal(BigInteger.valueOf(clientsDKRSize));
				q25dAgeVeteransTable.setQ25dDKRWithoutChildren(BigInteger.valueOf(clientsDKRWithoutChildrenSize));
				q25dAgeVeteransTable.setQ25dDKRWithChildAndAdults(BigInteger.valueOf(clientsDKRWithOneAdultChildSize));
				q25dAgeVeteransTable.setQ25dDKRUnknownHouseHold(BigInteger.valueOf(clientsDKRUnknownHouseHoldSize));

				List<String> clientsMissing = getClients(data, query, null, true,"99", 0, 0);
				List<String> clientsMissingWithoutChildren = getClients(data, query, projectsHHWithOutChildren, false, "99", 0, 0);
				List<String> clientsMissingWithOneAdultChild = getClients(data, query, projectsHHWithOneAdultChild, false, "99", 0, 0);
				List<String> clientsMissingUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, "99", 0, 0);
				
				int clientsMissingSize = getSize(clientsMissing);
				int clientsMissingWithoutChildrenSize = getSize(clientsMissingWithoutChildren);
				int clientsMissingWithOneAdultChildSize = getSize(clientsMissingWithOneAdultChild);
				int clientsMissingUnknownHouseHoldSize = getSize(clientsMissingUnknownHouseHold);
				
				
				q25dAgeVeteransTable.setQ25dInformationMissingTotal(BigInteger.valueOf(clientsMissingSize));
				q25dAgeVeteransTable.setQ25dInformationMissingWithoutChildren(BigInteger.valueOf(clientsMissingWithoutChildrenSize));
				q25dAgeVeteransTable.setQ25dInformationMissingWithChildAndAdults(BigInteger.valueOf(clientsMissingWithOneAdultChildSize));
				q25dAgeVeteransTable.setQ25dInformationMissingUnknownHouseHold(BigInteger.valueOf(clientsMissingUnknownHouseHoldSize));

				int total = clientsMissingSize + clientsDKRSize + clients18To24Size + clients62PlusSize + clients55To61Size + clients45To54Size +clients35To44Size +clients25To34Size ;
				int withoutChildren = clientsMissingWithoutChildrenSize +clientsDKRWithoutChildrenSize + clients62PlusWithoutChildrenSize + clients55To61WithoutChildrenSize+clients45To54WithoutChildrenSize + clients35To44WithoutChildrenSize +clients25To34WithoutChildrenSize + clients18To24WithoutChildrenSize ;
				int withChildAndAdults = clientsMissingWithOneAdultChildSize + clientsDKRWithOneAdultChildSize+ clients62PlusWithOneAdultChildSize + clients55To61WithOneAdultChildSize + clients45To54WithOneAdultChildSize + clients35To44WithOneAdultChildSize +clients25To34WithoutChildrenSize + clients18To24WithOneAdultChildSize;
				int unknownHouseHold = clientsMissingUnknownHouseHoldSize  + clientsDKRUnknownHouseHoldSize + clients62PlusUnknownHouseHoldSize + clients55To61UnknownHouseHoldSize + clients45To54UnknownHouseHoldSize +	clients35To44UnknownHouseHoldSize + clients25To34UnknownHouseHoldSize + clients18To24UnknownHouseHoldSize ;
				q25dAgeVeteransTable.setQ25dTotTotal(BigInteger.valueOf(total));
				q25dAgeVeteransTable.setQ25dTotWithoutChildren(BigInteger.valueOf(withoutChildren));
				q25dAgeVeteransTable.setQ25dTotWithChildAndAdults(BigInteger.valueOf(withChildAndAdults));
				q25dAgeVeteransTable.setQ25dTotUnknownHouseHold(BigInteger.valueOf(unknownHouseHold));
						
			}	
	}catch(Exception e){
		logger.error("Error in Q25dNumberOfVeteransDataBeanMaker:" + e);
		}
		return Arrays.asList(q25dAgeVeteransTable);
	}
	
	public static List<String> getClients(ReportData data,String query,List<String> filteredProjectIds, boolean allProjects,String dobdataquality, int  startAge,int endAge) {
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
				 StringBuilder enrollmentBuilder = new StringBuilder(" and e.dedup_client_id in  ( ");
					List<ClientModel> clients = data.getVeterans();
					 if(CollectionUtils.isNotEmpty(clients)) {
						 int index = 0;
						 for(ClientModel client : clients) {
							 enrollmentBuilder.append("'"+client.getDedupClientId()+"'");
							 if(index != clients.size()) {
								 enrollmentBuilder.append(",");
							 }
						 }
					 }
					 enrollmentBuilder.deleteCharAt(enrollmentBuilder.length() -1);
					 enrollmentBuilder.append(" ) ");
					 newQuery = newQuery + enrollmentBuilder.toString();
				if(StringUtils.isNotBlank(dobdataquality) && !StringUtils.equals("8", dobdataquality)) {
					newQuery = newQuery + " and c.dob_data_quality ='"+dobdataquality+"' ";
				}
				if(StringUtils.equals("8", dobdataquality)) {
					newQuery = newQuery + " and c.dob_data_quality  in ('8','9') ";
				}
				if(StringUtils.isBlank(dobdataquality)) {
					if(startAge !=0) {
						newQuery = newQuery + " and c.age  >="+startAge ;
					}
					if(endAge !=0) {
						newQuery = newQuery +  " and c.age <="+ endAge;
					}
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
