package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.servinglynk.hive.connection.ReportQuery;
import com.servinglynk.report.bean.Q08aDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;
import com.servinglynk.report.model.EnrollmentModel;

public class Q08aDataBeanMaker extends BaseBeanMaker {
	
        public static List<Q08aDataBean> getQ08aDataBeanList(ReportData data) {
        	List<String> projectsHHWithChildren  = getProjectsForHouseHoldType(data.getSchema(), ReportQuery.PROJECT_WITH_HOUSEHOLD_ONLY_CHILDREN);
        	List<String> projectsHHWithOneAdultChild  = getProjectsForHouseHoldType(data.getSchema(), ReportQuery.PROJECT_WITH_HOUSEHOLD_WITH_ONE_ADULT_CHILD);
        	List<String> projectsHHWithOutChildren  = getProjectsForHouseHoldType(data.getSchema(), ReportQuery.PROJECT_WITH_HOUSEHOLD_WITHOUT_CHILDREN);
        	List<String> projectsUnknownHouseHold  = getProjectsForHouseHoldType(data.getSchema(), ReportQuery.PROJECT_WITH_HOUSEHOLD_TYPE_UNKNOWN);
        	
        	
        	Q08aDataBean q08aDataBean = new Q08aDataBean();
        	List<ClientModel> clients = data.getClients();
        	List<EnrollmentModel> enrollments = data.getEnrollments();
        	List<EnrollmentModel> enrollmentsHHWithChildren = enrollments.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
        	List<String> clientIds = new ArrayList<String>(); 
        	enrollmentsHHWithChildren.parallelStream().forEach(enrollment -> { clientIds.add(enrollment.getPersonalID());});
        	List<ClientModel> clientsWithOnlyChildren = clients.parallelStream().filter(adult -> clientIds.contains(adult.getPersonalID())).collect(Collectors.toList());
        	
        	List<EnrollmentModel> enrollmentsHHWithOneAdultChild = enrollments.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
        	List<String> clientsHHWithOneAdultChild = new ArrayList<String>(); 
        	enrollmentsHHWithOneAdultChild.parallelStream().forEach(enrollment -> { clientsHHWithOneAdultChild.add(enrollment.getPersonalID());});
        	List<ClientModel> clientWithOneAdultChild = clients.parallelStream().filter(adult -> clientsHHWithOneAdultChild.contains(adult.getPersonalID())).collect(Collectors.toList());
        	
        	
        	List<EnrollmentModel> enrollmentsHHWithOutChildren = enrollments.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
        	List<String> clientsHHWithOutChildren = new ArrayList<String>(); 
        	enrollmentsHHWithOutChildren.parallelStream().forEach(enrollment -> { clientsHHWithOutChildren.add(enrollment.getPersonalID());});
        	List<ClientModel> clientsWithOutChildren = clients.parallelStream().filter(adult -> clientsHHWithOutChildren.contains(adult.getPersonalID())).collect(Collectors.toList());
        	
        	List<EnrollmentModel> enrollmentsUnknownHouseHold = enrollments.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
        	List<String> clientsUnknownHouseHold = new ArrayList<String>(); 
        	enrollmentsUnknownHouseHold.parallelStream().forEach(enrollment -> { clientsUnknownHouseHold.add(enrollment.getPersonalID());});
        	List<ClientModel> clientsUnknownHHType = clients.parallelStream().filter(adult -> clientsUnknownHouseHold.contains(adult.getPersonalID())).collect(Collectors.toList());
        	
        	
        	
        	q08aDataBean.setOverAllTotHouseHolds(BigInteger.valueOf(clients != null ? clients.size() :0));
        	q08aDataBean.setTotHhWithoutChild(BigInteger.valueOf(clientsWithOutChildren!= null ? clientsWithOutChildren.size() :0));
        	q08aDataBean.setTotHhUnknownHhType(BigInteger.valueOf(clientsUnknownHHType != null ? clientsUnknownHHType.size() :0));
        	q08aDataBean.setTotHhWothOnlyChild(BigInteger.valueOf(clientsWithOnlyChildren != null ? clientsWithOnlyChildren.size() : 0));
        	q08aDataBean.setTotHhWithChildAndAdults(BigInteger.valueOf(clientWithOneAdultChild != null ? clientWithOneAdultChild.size() :0));
        	
        	return Arrays.asList(q08aDataBean);
        }
        
        
}