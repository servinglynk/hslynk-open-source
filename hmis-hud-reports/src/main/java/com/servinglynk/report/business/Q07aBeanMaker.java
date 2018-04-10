package com.servinglynk.report.business;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hive.connection.ImpalaConnection;
import com.servinglynk.hive.connection.ReportQuery;
import com.servinglynk.report.bean.Q07aDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;
import com.servinglynk.report.model.EnrollmentModel;
import com.servinglynk.report.model.ProjectModel;

public class Q07aBeanMaker extends BaseBeanMaker {
	
	public static List<String> getProjectsForHouseHoldType(String schema,String query) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		List<String>  models = new ArrayList<String>();
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.prepareStatement(String.format(query,schema));
			resultSet = statement.executeQuery();
		 while(resultSet.next()) {
			 models.add(resultSet.getString(1));
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
	
	
	
        public static List<Q07aDataBean> getQ07aHouseholdsServeList(ReportData data) {
        	List<String> projectsHHWithChildren  = getProjectsForHouseHoldType(data.getSchema(), ReportQuery.PROJECT_WITH_HOUSEHOLD_ONLY_CHILDREN);
        	List<String> projectsHHWithOneAdultChild  = getProjectsForHouseHoldType(data.getSchema(), ReportQuery.PROJECT_WITH_HOUSEHOLD_WITH_ONE_ADULT_CHILD);
        	List<String> projectsHHWithOutChildren  = getProjectsForHouseHoldType(data.getSchema(), ReportQuery.PROJECT_WITH_HOUSEHOLD_WITHOUT_CHILDREN);
        	List<String> projectsUnknownHouseHold  = getProjectsForHouseHoldType(data.getSchema(), ReportQuery.PROJECT_WITH_HOUSEHOLD_TYPE_UNKNOWN);
        	
        	
        	List<ClientModel> clients = data.getClients();
        	List<EnrollmentModel> enrollments = data.getEnrollments();
        	List<ClientModel> adults = clients.parallelStream().filter(client -> isAdult(client.getDob())).collect(Collectors.toList());
            
        	List<EnrollmentModel> enrollmentsHHWithChildren = enrollments.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
        	List<String> clientIds = new ArrayList<String>(); 
        	enrollmentsHHWithChildren.parallelStream().forEach(enrollment -> { clientIds.add(enrollment.getPersonalID());});
        	List<ClientModel> adultWithChildren = adults.parallelStream().filter(adult -> clientIds.contains(adult.getPersonalID())).collect(Collectors.toList());
        	
        	List<EnrollmentModel> enrollmentsHHWithOneAdultChild = enrollments.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
        	List<String> clientsHHWithOneAdultChild = new ArrayList<String>(); 
        	enrollmentsHHWithOneAdultChild.parallelStream().forEach(enrollment -> { clientsHHWithOneAdultChild.add(enrollment.getPersonalID());});
        	List<ClientModel> clientWithOneAdultChild = adults.parallelStream().filter(adult -> clientsHHWithOneAdultChild.contains(adult.getPersonalID())).collect(Collectors.toList());
        	
        	
        	List<EnrollmentModel> enrollmentsHHWithOutChildren = enrollments.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
        	List<String> clientsHHWithOutChildren = new ArrayList<String>(); 
        	enrollmentsHHWithOutChildren.parallelStream().forEach(enrollment -> { clientsHHWithOutChildren.add(enrollment.getPersonalID());});
        	List<ClientModel> clientsWithOutChildren = adults.parallelStream().filter(adult -> clientsHHWithOutChildren.contains(adult.getPersonalID())).collect(Collectors.toList());
        	
        	List<EnrollmentModel> enrollmentsUnknownHouseHold = enrollments.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
        	List<String> clientsUnknownHouseHold = new ArrayList<String>(); 
        	enrollmentsUnknownHouseHold.parallelStream().forEach(enrollment -> { clientsUnknownHouseHold.add(enrollment.getPersonalID());});
        	List<ClientModel> clientsUnknownHHType = adults.parallelStream().filter(adult -> clientsUnknownHouseHold.contains(adult.getPersonalID())).collect(Collectors.toList());
        	
        	List<ClientModel> children = clients.parallelStream().filter(client -> isChild(client.getDob())).collect(Collectors.toList());
        	List<ClientModel> childWithOnlyChildren = children.parallelStream().filter(child -> clientIds.contains(child.getPersonalID())).collect(Collectors.toList());
        	List<ClientModel> childClientWithOneAdultChild = children.parallelStream().filter(child -> clientsHHWithOneAdultChild.contains(child.getPersonalID())).collect(Collectors.toList());
        	List<ClientModel> childClientsWithOutChildren = children.parallelStream().filter(child -> clientsHHWithOutChildren.contains(child)).collect(Collectors.toList());
        	List<ClientModel> childClientsUnknownHHType = children.parallelStream().filter(child -> clientsUnknownHouseHold.contains(child.getPersonalID())).collect(Collectors.toList());
        	
        	List<ClientModel> ageUnknown = clients.parallelStream().filter(client -> StringUtils.equals("9",client.getDob_data_quality()) ||  StringUtils.equals("8",client.getDob_data_quality())).collect(Collectors.toList());
        	List<ClientModel> ageUnknownWithOnlyChildren = ageUnknown.parallelStream().filter(ageUnkn -> clientIds.contains(ageUnkn.getPersonalID())).collect(Collectors.toList());
        	List<ClientModel> ageUnknownClientWithOneAdultChild = ageUnknown.parallelStream().filter(ageUnkn -> clientsHHWithOneAdultChild.contains(ageUnkn.getPersonalID())).collect(Collectors.toList());
        	List<ClientModel> ageUnknownClientsWithOutChildren = ageUnknown.parallelStream().filter(ageUnkn -> clientsHHWithOutChildren.contains(ageUnkn)).collect(Collectors.toList());
        	List<ClientModel> ageUnknownClientsUnknownHHType = ageUnknown.parallelStream().filter(ageUnkn -> clientsUnknownHouseHold.contains(ageUnkn.getPersonalID())).collect(Collectors.toList());
        	
        	List<ClientModel> ageDnc = clients.parallelStream().filter(client -> StringUtils.equals("99",client.getDob_data_quality())).collect(Collectors.toList());
        	List<ClientModel> ageDncClientsOnlyChildren = ageDnc.parallelStream().filter(ageDnotCollected -> clientIds.contains(ageDnotCollected.getPersonalID())).collect(Collectors.toList());
        	List<ClientModel> ageDncClientWithOneAdultChild = ageDnc.parallelStream().filter(ageDnotCollected -> clientsHHWithOneAdultChild.contains(ageDnotCollected.getPersonalID())).collect(Collectors.toList());
        	List<ClientModel> ageDncClientsWithOutChildren = ageDnc.parallelStream().filter(ageDnotCollected -> clientsHHWithOutChildren.contains(ageDnotCollected)).collect(Collectors.toList());
        	List<ClientModel> ageDncClientsUnknownHHType = ageDnc.parallelStream().filter(ageDnotCollected -> clientsUnknownHouseHold.contains(ageDnotCollected.getPersonalID())).collect(Collectors.toList());
        	
        	int adultWithChildrenCount  = adultWithChildren != null ? adultWithChildren.size() :0;
        	int adultWithOneAdultChildCount  = clientWithOneAdultChild != null ? clientWithOneAdultChild.size() :0 ;
        	int adultWithOutChildrenCount = clientsWithOutChildren !=  null ? clientsWithOutChildren.size() :0;
        	int adultUnknownHHTypeCount = clientsUnknownHHType != null ? clientsUnknownHHType.size() :0;
        	
        	int childClientsWithOutChildrenCount = childClientsWithOutChildren != null ? childClientsWithOutChildren.size() :0;
        	int childClientWithOneAdultChildCount =  childClientWithOneAdultChild != null ? childClientWithOneAdultChild.size() :0;
        	int childWithOnlyChildrenCount = childWithOnlyChildren != null ?childWithOnlyChildren.size() :0;
        	int childClientsUnknownHHTypeCount = childClientsUnknownHHType != null ? childClientsUnknownHHType.size() :0;
        	
        	int ageUnknownClientsWithOutChildrenCount =  ageUnknownClientsWithOutChildren != null ? ageUnknownClientsWithOutChildren.size() :0;
        	int ageUnknownClientWithOneAdultChildCount = ageUnknownClientWithOneAdultChild != null ? ageUnknownClientWithOneAdultChild.size() :0;
        	int ageUnknownWithOnlyChildrenCount = ageUnknownWithOnlyChildren != null ? ageUnknownWithOnlyChildren.size() :0;
        	int ageUnknownClientsUnknownHHTypeCount = ageUnknownClientsUnknownHHType != null ? ageUnknownClientsUnknownHHType.size() :0;
        	
        	int ageDncCount = ageDnc != null ? ageDnc.size() :0;
        	int ageDncClientsWithOutChildrenCount = ageDncClientsWithOutChildren != null ? ageDncClientsWithOutChildren.size() :0;
        	int ageDncClientWithOneAdultChildCount = ageDncClientWithOneAdultChild != null ? ageDncClientWithOneAdultChild.size() :0;
        	int ageDncClientsOnlyChildrenCount = ageDncClientsOnlyChildren != null ? ageDncClientsOnlyChildren.size() :0;
        	int ageDncClientsUnknownHHTypeCount = ageDncClientsUnknownHHType != null ? ageDncClientsUnknownHHType.size() :0;
        	
        	int totWithOutChildren = adultWithOutChildrenCount +childClientsWithOutChildrenCount +ageUnknownClientsWithOutChildrenCount+ageDncCount;
        	int totWithChildAndAdults = adultWithOneAdultChildCount +childClientWithOneAdultChildCount+ageUnknownClientWithOneAdultChildCount+ageDncClientsWithOutChildrenCount;
        	int totWithOnlychildren =  adultWithOutChildrenCount +childWithOnlyChildrenCount+ageUnknownWithOnlyChildrenCount+ageDncClientsOnlyChildrenCount;
        	int totUnknownHousehold = adultUnknownHHTypeCount + childClientsUnknownHHTypeCount+ageDncClientsOnlyChildrenCount+ageDncClientsUnknownHHTypeCount;
        	Q07aDataBean q07aHouseholdsServed = new Q07aDataBean();
            //select count(*) from client c where personalID
        	q07aHouseholdsServed.setAdultsTotal(data.getNumOfAdults());
        	q07aHouseholdsServed.setAdultsWithOutChildren(BigInteger.valueOf(adultWithOutChildrenCount));
        	q07aHouseholdsServed.setAdultsWithChildAndAdults(BigInteger.valueOf(adultWithOneAdultChildCount));
        	q07aHouseholdsServed.setAdultsWithOnlychildren(BigInteger.valueOf(adultWithChildrenCount));
        	q07aHouseholdsServed.setAdultsUnknownHousehold(BigInteger.valueOf(adultUnknownHHTypeCount));
        	
        	q07aHouseholdsServed.setChildTotal(data.getNumOfChildren());
        	q07aHouseholdsServed.setChildWithOutChildren(BigInteger.valueOf(childClientsWithOutChildrenCount));
        	q07aHouseholdsServed.setChildWithChildAndAdults(BigInteger.valueOf(childClientWithOneAdultChildCount));
        	q07aHouseholdsServed.setChildWithOnlychildren(BigInteger.valueOf(childWithOnlyChildrenCount));
        	q07aHouseholdsServed.setChildUnknownHousehold(BigInteger.valueOf(childClientsUnknownHHTypeCount));
        	
        	
        	q07aHouseholdsServed.setClientDKRTotal(data.getNumOfPersonsWithUnknownAge());
        	q07aHouseholdsServed.setClientDKRWithOutChildren(BigInteger.valueOf(ageUnknownClientsWithOutChildrenCount));
        	q07aHouseholdsServed.setClientDKRWithChildAndAdults(BigInteger.valueOf(ageUnknownClientWithOneAdultChildCount));
        	q07aHouseholdsServed.setClientDKRWithOnlychildren(BigInteger.valueOf(ageUnknownWithOnlyChildrenCount));
        	q07aHouseholdsServed.setClientDKRUnknownHousehold(BigInteger.valueOf(ageUnknownClientsUnknownHHTypeCount));
        	
        	q07aHouseholdsServed.setDncTotal(BigInteger.valueOf(ageDncCount));
        	q07aHouseholdsServed.setDncWithOutChildren(BigInteger.valueOf(ageDncClientsWithOutChildrenCount));
        	q07aHouseholdsServed.setDncWithChildAndAdults(BigInteger.valueOf(ageDncClientWithOneAdultChildCount));
        	q07aHouseholdsServed.setDncWithOnlychildren(BigInteger.valueOf(ageDncClientsOnlyChildrenCount));
        	q07aHouseholdsServed.setDncUnknownHousehold(BigInteger.valueOf(ageDncClientsUnknownHHTypeCount));
        	
        	q07aHouseholdsServed.setTotTotal(data.getTotNumOfPersonServed());
        	q07aHouseholdsServed.setTotWithOutChildren(BigInteger.valueOf(totWithOutChildren));
        	q07aHouseholdsServed.setTotWithChildAndAdults(BigInteger.valueOf(totWithChildAndAdults));
        	q07aHouseholdsServed.setTotWithOnlychildren(BigInteger.valueOf(totWithOnlychildren));
        	q07aHouseholdsServed.setTotUnknownHousehold(BigInteger.valueOf(totUnknownHousehold));
        		
        	return Arrays.asList(q07aHouseholdsServed);
        }
        
        
}