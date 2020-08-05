package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hive.connection.ReportQuery;
import com.servinglynk.report.bean.Q07aHouseholdsServedDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;
import com.servinglynk.report.model.EnrollmentModel;

public class Q07aBeanMaker extends BaseBeanMaker {
	
        public static List<Q07aHouseholdsServedDataBean> getQ07aHouseholdsServeList(ReportData data) {
        	Q07aHouseholdsServedDataBean q07aHouseholdsServed = new Q07aHouseholdsServedDataBean();
        	if(data.isLiveMode()) {
        	try {
        	List<String> projectsHHWithChildren  = getProjectsForHouseHoldType(data.getSchema(), getQueryForProjectDB(data,ReportQuery.PROJECT_WITH_HOUSEHOLD_ONLY_CHILDREN),data);
        	List<String> projectsHHWithOneAdultChild  = getProjectsForHouseHoldType(data.getSchema(),  getQueryForProjectDB(data,ReportQuery.PROJECT_WITH_HOUSEHOLD_WITH_ONE_ADULT_CHILD),data);
        	List<String> projectsHHWithOutChildren  = getProjectsForHouseHoldType(data.getSchema(),  getQueryForProjectDB(data,ReportQuery.PROJECT_WITH_HOUSEHOLD_WITHOUT_CHILDREN),data);
        	List<String> projectsUnknownHouseHold  = getProjectsForHouseHoldType(data.getSchema(),  getQueryForProjectDB(data,ReportQuery.PROJECT_WITH_HOUSEHOLD_TYPE_UNKNOWN),data);
        	
  
        	data.setProjectsHHWithChildren(projectsHHWithChildren);
        	data.setProjectsHHWithOneAdultChild(projectsHHWithOneAdultChild);
        	data.setProjectsHHWithOutChildren(projectsHHWithOutChildren);
        	data.setProjectsUnknownHouseHold(projectsUnknownHouseHold);
        	
        	List<ClientModel> clients = data.getClients();
        	List<EnrollmentModel> enrollments = data.getEnrollments();
        	List<EnrollmentModel> adults = enrollments.parallelStream().filter(enrollment -> enrollment.getAgeatentry() >= 18).collect(Collectors.toList());
            
        	List<EnrollmentModel> enrollmentsHHWithChildren = enrollments.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
        	List<String> clientIds = new ArrayList<String>(); 
        	enrollmentsHHWithChildren.forEach(enrollment -> { clientIds.add(enrollment.getDedupClientId());});
        	List<EnrollmentModel> adultWithChildren = adults.parallelStream().filter(adult -> clientIds.contains(adult.getDedupClientId())).collect(Collectors.toList());
        	
        	List<EnrollmentModel> enrollmentsHHWithOneAdultChild = enrollments.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
        	List<String> clientsHHWithOneAdultChild = new ArrayList<String>(); 
        	enrollmentsHHWithOneAdultChild.forEach(enrollment -> { clientsHHWithOneAdultChild.add(enrollment.getDedupClientId());});
        	List<EnrollmentModel> clientWithOneAdultChild = adults.parallelStream().filter(adult -> clientsHHWithOneAdultChild.contains(adult.getDedupClientId())).collect(Collectors.toList());
        	
        	
        	List<EnrollmentModel> enrollmentsHHWithOutChildren = enrollments.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
        	List<String> clientsHHWithOutChildren = new ArrayList<String>(); 
        	enrollmentsHHWithOutChildren.forEach(enrollment -> { clientsHHWithOutChildren.add(enrollment.getDedupClientId());});
        	List<EnrollmentModel> clientsWithOutChildren = adults.parallelStream().filter(adult -> clientsHHWithOutChildren.contains(adult.getDedupClientId())).collect(Collectors.toList());
        	
        	List<EnrollmentModel> enrollmentsUnknownHouseHold = enrollments.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
        	List<String> clientsUnknownHouseHold = new ArrayList<String>(); 
        	enrollmentsUnknownHouseHold.forEach(enrollment -> { clientsUnknownHouseHold.add(enrollment.getDedupClientId());});
        	List<EnrollmentModel> clientsUnknownHHType = adults.parallelStream().filter(adult -> clientsUnknownHouseHold.contains(adult.getDedupClientId())).collect(Collectors.toList());
        	
        	
        	data.setAdultWithChildren(adultWithChildren);
        	data.setAdultsWithOutChildren(clientsWithOutChildren);
        	data.setAdultsWithOneAdultChild(clientWithOneAdultChild);
        	data.setAdultsUnknownHHType(clientsUnknownHHType);
        	
        	List<EnrollmentModel> children = enrollments.parallelStream().filter(enrollment -> enrollment.getAgeatentry() < 18).collect(Collectors.toList());
        	List<EnrollmentModel> childWithOnlyChildren = children.parallelStream().filter(child -> clientIds.contains(child.getDedupClientId())).collect(Collectors.toList());
        	List<EnrollmentModel> childClientWithOneAdultChild = children.parallelStream().filter(child -> clientsHHWithOneAdultChild.contains(child.getDedupClientId())).collect(Collectors.toList());
        	List<EnrollmentModel> childClientsWithOutChildren = children.parallelStream().filter(child -> clientsHHWithOutChildren.contains(child.getDedupClientId())).collect(Collectors.toList());
        	List<EnrollmentModel> childClientsUnknownHHType = children.parallelStream().filter(child -> clientsUnknownHouseHold.contains(child.getDedupClientId())).collect(Collectors.toList());
        	
        	List<ClientModel> ageUnknown = clients.parallelStream().filter(client -> ((StringUtils.equals("9",client.getDob_data_quality()) ||  StringUtils.equals("8",client.getDob_data_quality())) && client.getAge() ==0)).collect(Collectors.toList());
        	List<ClientModel> ageUnknownWithOnlyChildren = ageUnknown.parallelStream().filter(ageUnkn -> clientIds.contains(ageUnkn.getDedupClientId())).collect(Collectors.toList());
        	List<ClientModel> ageUnknownClientWithOneAdultChild = ageUnknown.parallelStream().filter(ageUnkn -> clientsHHWithOneAdultChild.contains(ageUnkn.getDedupClientId())).collect(Collectors.toList());
        	List<ClientModel> ageUnknownClientsWithOutChildren = ageUnknown.parallelStream().filter(ageUnkn -> clientsHHWithOutChildren.contains(ageUnkn.getDedupClientId())).collect(Collectors.toList());
        	List<ClientModel> ageUnknownClientsUnknownHHType = ageUnknown.parallelStream().filter(ageUnkn -> clientsUnknownHouseHold.contains(ageUnkn.getDedupClientId())).collect(Collectors.toList());
        	
        	List<ClientModel> ageDnc = clients.parallelStream().filter(client -> StringUtils.equals("99",client.getDob_data_quality()) && client.getAge() ==0 ).collect(Collectors.toList());
        	List<ClientModel> ageDncClientsOnlyChildren = ageDnc.parallelStream().filter(ageDnotCollected -> clientIds.contains(ageDnotCollected.getDedupClientId())).collect(Collectors.toList());
        	List<ClientModel> ageDncClientWithOneAdultChild = ageDnc.parallelStream().filter(ageDnotCollected -> clientsHHWithOneAdultChild.contains(ageDnotCollected.getDedupClientId())).collect(Collectors.toList());
        	List<ClientModel> ageDncClientsWithOutChildren = ageDnc.parallelStream().filter(ageDnotCollected -> clientsHHWithOutChildren.contains(ageDnotCollected.getDedupClientId())).collect(Collectors.toList());
        	List<ClientModel> ageDncClientsUnknownHHType = ageDnc.parallelStream().filter(ageDnotCollected -> clientsUnknownHouseHold.contains(ageDnotCollected.getDedupClientId())).collect(Collectors.toList());
        	
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
        	
        	int totWithOutChildren = adultWithOutChildrenCount +childClientsWithOutChildrenCount +ageUnknownClientsWithOutChildrenCount+ageDncClientsWithOutChildrenCount;
        	int totWithChildAndAdults = adultWithOneAdultChildCount +childClientWithOneAdultChildCount+ageUnknownClientWithOneAdultChildCount+ageDncClientsWithOutChildrenCount;
        	int totWithOnlychildren =  adultWithChildrenCount +childWithOnlyChildrenCount+ageUnknownWithOnlyChildrenCount+ageDncClientsOnlyChildrenCount;
        	int totUnknownHousehold = adultUnknownHHTypeCount + childClientsUnknownHHTypeCount+ageDncClientsOnlyChildrenCount+ageDncClientsUnknownHHTypeCount;
        	
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
        	
        	
        	q07aHouseholdsServed.setClientDKRTotal(BigInteger.valueOf(getSize(ageUnknown)));
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
        	

        	List<String> pshRrhTotalList = getQueryData(data.getSchema(),getQueryForProjectDB(data, ReportQuery.MOVE_IN_DATE_QUERY), data);
        	int pshRrhTotal = pshRrhTotalList != null ? pshRrhTotalList.size() : 0;
        	q07aHouseholdsServed.setPshRrhTotal(BigInteger.valueOf(pshRrhTotal));
        	data.setPshRrhTotal(pshRrhTotalList);
        	
        	List<EnrollmentModel> pshRrhWithOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> pshRrhTotalList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
	        int pshRrhWithOutChildrenCount = pshRrhWithOutChildren != null ? pshRrhWithOutChildren.size() : 0;
        	q07aHouseholdsServed.setPshRrhWithOutChildren(BigInteger.valueOf(pshRrhWithOutChildrenCount));
        	data.setPshRrhWithOutChildren(pshRrhWithOutChildren);
        	
        	List<EnrollmentModel> pshRrhWithOnlychildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> pshRrhTotalList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
	        int pshRrhWithOnlychildrenCount = pshRrhWithOnlychildren != null ? pshRrhWithOnlychildren.size() : 0;
        	q07aHouseholdsServed.setPshRrhWithOnlychildren(BigInteger.valueOf(pshRrhWithOnlychildrenCount));
        	data.setPshRrhWithOnlychildren(pshRrhWithOnlychildren);
        	
           	List<EnrollmentModel> pshRrhWithChildAndAdults = enrollmentsHHWithOneAdultChild.parallelStream().filter(enrollment -> pshRrhTotalList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
	        int pshRrhWithChildAndAdultsCount = pshRrhWithChildAndAdults != null ? pshRrhWithChildAndAdults.size() : 0;
        	q07aHouseholdsServed.setPshRrhWithOnlychildren(BigInteger.valueOf(pshRrhWithChildAndAdultsCount));
        	data.setPshRrhWithOnlychildren(pshRrhWithOnlychildren);
        	
         	List<EnrollmentModel> pshRrhUnknownHousehold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> pshRrhTotalList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
	        int pshRrhUnknownHouseholdCount = pshRrhUnknownHousehold != null ? pshRrhUnknownHousehold.size() : 0;
        	q07aHouseholdsServed.setPshRrhUnknownHousehold(BigInteger.valueOf(pshRrhUnknownHouseholdCount));
        	data.setPshRrhUnknownHousehold(pshRrhUnknownHousehold);
        	
        } catch (Exception e) {
			logger.error("Error in Q07aBeanMaker:" + e);
		}
        }
        	return Arrays.asList(q07aHouseholdsServed);
        }
        
        
}