package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q11AgeDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;
import com.servinglynk.report.model.EnrollmentModel;

public class Q11BeanMaker extends BaseBeanMaker {
	
	public static List<Q11AgeDataBean> getQ11AgeList(ReportData data){
		Q11AgeDataBean q11AgeDataBean = new Q11AgeDataBean();
		if(data.isLiveMode()) {
		try {
				List<ClientModel> clients = data.getClients();
				List<EnrollmentModel> enrollments = data.getEnrollments();
				List<ClientModel> under5Tot = clients.parallelStream().filter(client -> client.getAge() < 5 && client.getAge() !=0).collect(Collectors.toList());
				List<ClientModel> clients5To12 = clients.parallelStream().filter(client -> client.getAge() >= 5 && client.getAge() <=12).collect(Collectors.toList());
				List<ClientModel> clients13To17 = clients.parallelStream().filter(client ->  client.getAge() >= 13 && client.getAge() <=17).collect(Collectors.toList());
				List<ClientModel> clients18To24 = clients.parallelStream().filter(client ->  client.getAge() >= 18 && client.getAge() <=24).collect(Collectors.toList());
				List<ClientModel> clients25To34 = clients.parallelStream().filter(client ->  client.getAge() >= 25 && client.getAge() <=34).collect(Collectors.toList());
				List<ClientModel> clients35To44 = clients.parallelStream().filter(client ->  client.getAge() >= 35 && client.getAge() <=44).collect(Collectors.toList());
				List<ClientModel> clients45To54 = clients.parallelStream().filter(client ->  client.getAge() >= 45 && client.getAge() <=54).collect(Collectors.toList());
				List<ClientModel> clients55To61 = clients.parallelStream().filter(client ->  client.getAge() >= 55 && client.getAge() <=61).collect(Collectors.toList());
				List<ClientModel> clientsOver61 = clients.parallelStream().filter(client -> client.getAge() > 61).collect(Collectors.toList());
				List<ClientModel> clientsDidnotknowRefused = clients.parallelStream().filter(client -> StringUtils.equals("8", client.getDob_data_quality()) && StringUtils.equals("9", client.getDob_data_quality()) ).collect(Collectors.toList());
				List<ClientModel> clientsDNC = clients.parallelStream().filter(client -> StringUtils.equals("99", client.getDob_data_quality())).collect(Collectors.toList());
				
				List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
				List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
				List<String> projectsHHWithChildren = data.getProjectsHHWithChildren();
				List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
				
				BigInteger  totalUHHT = BigInteger.ZERO;
				BigInteger	totalWCA = BigInteger.ZERO;
				BigInteger	totalWithOnlyChild = BigInteger.ZERO;
				BigInteger	totalWOC = BigInteger.ZERO;
				BigInteger  totOverallTotal = BigInteger.ZERO;
				
				if(CollectionUtils.isNotEmpty(under5Tot)) {
					List<String> filteredClients = new ArrayList<>();
					under5Tot.parallelStream().forEach(client-> { filteredClients.add(client.getPersonalID()); });
					List<EnrollmentModel> clientWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientWOnlyC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
					
					q11AgeDataBean.setTotAgeUnder5(BigInteger.valueOf(under5Tot !=null ?under5Tot.size() : 0));
					q11AgeDataBean.setAgeUnder5UHHT(BigInteger.valueOf(clientUHHT != null ? clientUHHT.size() :0 ));
		    		q11AgeDataBean.setAgeUnder5WCA(BigInteger.valueOf(clientWCA != null ?clientWCA.size() :0));
		    		q11AgeDataBean.setAgeUnder5WithOnlyChild(BigInteger.valueOf(clientWOnlyC != null ?clientWOnlyC.size() :0));
		    		q11AgeDataBean.setAgeUnder5WOC(BigInteger.valueOf(clientWOC != null ?clientWOC.size() :0));
		    		totalUHHT.add(BigInteger.valueOf(clientUHHT != null ? clientUHHT.size() :0));
		    		totalWCA.add(BigInteger.valueOf(clientWCA != null ? clientWCA.size() :0));
		    		totalWithOnlyChild.add(BigInteger.valueOf(clientWOnlyC != null ? clientWOnlyC.size() :0));
		    		totalWOC.add(BigInteger.valueOf(clientWOC != null ?clientWOC.size() :0));
		    		totOverallTotal.add(BigInteger.valueOf(under5Tot.size()));
		    		
				}
			
				if(CollectionUtils.isNotEmpty(clients5To12)) {
					List<String> filteredClients = new ArrayList<>();
					clients5To12.parallelStream().forEach(client-> { filteredClients.add(client.getPersonalID()); });
					List<EnrollmentModel> clientWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientWOnlyC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
	
					q11AgeDataBean.setTotAge5to12(BigInteger.valueOf(clients5To12 != null ?clients5To12.size() :0));
		    		q11AgeDataBean.setAge5to12UHHT(BigInteger.valueOf(clientUHHT != null ?clientUHHT.size():0));
		    		q11AgeDataBean.setAge5to12WCA(BigInteger.valueOf(clientWCA != null ?clientWCA.size() :0));
		    		q11AgeDataBean.setAge5to12WithOnlyChild(BigInteger.valueOf(clientWOnlyC != null ?clientWOnlyC.size():0));
		    		q11AgeDataBean.setAge5to12WOC(BigInteger.valueOf(clientWOC != null ? clientWOC.size() :0));
		    		
		    		totalUHHT.add(BigInteger.valueOf(clientUHHT != null ? clientUHHT.size() :0));
		    		totalWCA.add(BigInteger.valueOf(clientWCA != null ? clientWCA.size() :0));
		    		totalWithOnlyChild.add(BigInteger.valueOf(clientWOnlyC != null ? clientWOnlyC.size() :0));
		    		totalWOC.add(BigInteger.valueOf(clientWOC != null ?clientWOC.size() :0));
		    		totOverallTotal.add(BigInteger.valueOf(clients5To12.size()));
				}
	    		
				if(CollectionUtils.isNotEmpty(clients13To17)) {
					List<String> filteredClients = new ArrayList<>();
					clients13To17.parallelStream().forEach(client-> { filteredClients.add(client.getPersonalID()); });
					List<EnrollmentModel> clientWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientWOnlyC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
	
					q11AgeDataBean.setTotAge13to17(BigInteger.valueOf(clients13To17.size()));
		    		q11AgeDataBean.setAge13to17UHHT(BigInteger.valueOf(clientUHHT != null ?clientUHHT.size():0));
		    		q11AgeDataBean.setAge13to17WCA(BigInteger.valueOf(clientWCA != null ?clientWCA.size():0));
		    		q11AgeDataBean.setAge13to17WithOnlyChild(BigInteger.valueOf(clientWOnlyC != null ?clientWOnlyC.size() :0));
		    		q11AgeDataBean.setAge13to17WOC(BigInteger.valueOf(clientWOC != null ?clientWOC.size() :0));
				
		    		totalUHHT.add(BigInteger.valueOf(clientUHHT != null ? clientUHHT.size() :0));
		    		totalWCA.add(BigInteger.valueOf(clientWCA != null ? clientWCA.size() :0));
		    		totalWithOnlyChild.add(BigInteger.valueOf(clientWOnlyC != null ? clientWOnlyC.size() :0));
		    		totalWOC.add(BigInteger.valueOf(clientWOC != null ?clientWOC.size() :0));
		    		totOverallTotal.add(BigInteger.valueOf(clients13To17.size()));
				
				}
				
				if(CollectionUtils.isNotEmpty(clients18To24)) {
					List<String> filteredClients = new ArrayList<>();
					clients18To24.parallelStream().forEach(client-> { filteredClients.add(client.getPersonalID()); });
					List<EnrollmentModel> clientWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientWOnlyC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
	
		    		q11AgeDataBean.setTotAge18to24(BigInteger.valueOf(clients18To24.size()));
		    		q11AgeDataBean.setAge18to24UHHT(BigInteger.valueOf(clientUHHT != null ?clientUHHT.size():0));
		    		q11AgeDataBean.setAge18to24WCA(BigInteger.valueOf(clientWCA != null ? clientWCA.size():0));
		    		q11AgeDataBean.setAge18to24WithOnlyChild(BigInteger.valueOf(clientWOnlyC != null?clientWOnlyC.size():0));
		    		q11AgeDataBean.setAge18to24WOC(BigInteger.valueOf(clientWOC != null ?clientWOC.size():0));
		    		
		    		totalUHHT.add(BigInteger.valueOf(clientUHHT != null ? clientUHHT.size() :0));
		    		totalWCA.add(BigInteger.valueOf(clientWCA != null ? clientWCA.size() :0));
		    		totalWithOnlyChild.add(BigInteger.valueOf(clientWOnlyC != null ? clientWOnlyC.size() :0));
		    		totalWOC.add(BigInteger.valueOf(clientWOC != null ?clientWOC.size() :0));
		    		totOverallTotal.add(BigInteger.valueOf(clients18To24.size()));
				}
				
				if(CollectionUtils.isNotEmpty(clients25To34)) {
					List<String> filteredClients = new ArrayList<>();
					clients25To34.parallelStream().forEach(client-> { filteredClients.add(client.getPersonalID()); });
					List<EnrollmentModel> clientWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientWOnlyC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
	
		    		q11AgeDataBean.setTotAge25to34(BigInteger.valueOf(0));
		    		q11AgeDataBean.setAge25to34UHHT(BigInteger.valueOf(clientUHHT != null ?clientUHHT.size() :0));
		    		q11AgeDataBean.setAge25to34WCA(BigInteger.valueOf(clientWCA != null ?clientWCA.size() :0));
		    		q11AgeDataBean.setAge25to34WithOnlyChild(BigInteger.valueOf(clientWOnlyC != null ?clientWOnlyC.size() :0));
		    		q11AgeDataBean.setAge25to34WOC(BigInteger.valueOf(clientWOC != null ? clientWOC.size():0));
				
		    		totalUHHT.add(BigInteger.valueOf(clientUHHT != null ? clientUHHT.size() :0));
		    		totalWCA.add(BigInteger.valueOf(clientWCA != null ? clientWCA.size() :0));
		    		totalWithOnlyChild.add(BigInteger.valueOf(clientWOnlyC != null ? clientWOnlyC.size() :0));
		    		totalWOC.add(BigInteger.valueOf(clientWOC != null ?clientWOC.size() :0));
		    		totOverallTotal.add(BigInteger.valueOf(clients25To34.size()));
				}

				if(CollectionUtils.isNotEmpty(clients35To44)) {
					List<String> filteredClients = new ArrayList<>();
					clients35To44.parallelStream().forEach(client-> { filteredClients.add(client.getPersonalID()); });
					List<EnrollmentModel> clientWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientWOnlyC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
	
		    		q11AgeDataBean.setTotAge35to44(BigInteger.valueOf(clients35To44.size()));
		    		q11AgeDataBean.setAge35to44UHHT(BigInteger.valueOf(clientUHHT != null ?clientUHHT.size() :0));
		    		q11AgeDataBean.setAge35to44WCA(BigInteger.valueOf(clientWCA != null ?clientWCA.size() :0));
		    		q11AgeDataBean.setAge35to44WithOnlyChild(BigInteger.valueOf(clientWOnlyC != null ?clientWOnlyC.size():0));
		    		q11AgeDataBean.setAge35to44WOC(BigInteger.valueOf(clientWOC != null ?clientWOC.size():0));
				
		      		totalUHHT.add(BigInteger.valueOf(clientUHHT != null ? clientUHHT.size() :0));
		    		totalWCA.add(BigInteger.valueOf(clientWCA != null ? clientWCA.size() :0));
		    		totalWithOnlyChild.add(BigInteger.valueOf(clientWOnlyC != null ? clientWOnlyC.size() :0));
		    		totalWOC.add(BigInteger.valueOf(clientWOC != null ?clientWOC.size() :0));
		    		totOverallTotal.add(BigInteger.valueOf(clients35To44.size()));
		    		
				}
				if(CollectionUtils.isNotEmpty(clients45To54)) {
					List<String> filteredClients = new ArrayList<>();
					clients45To54.parallelStream().forEach(client-> { filteredClients.add(client.getPersonalID()); });
					List<EnrollmentModel> clientWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientWOnlyC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
	
		    		q11AgeDataBean.setTotAge45to54(BigInteger.valueOf(clients45To54.size()));
		    		q11AgeDataBean.setAge45to54UHHT(BigInteger.valueOf(clientUHHT != null ?clientUHHT.size():0));
		    		q11AgeDataBean.setAge45to54WCA(BigInteger.valueOf(clientWCA != null ?clientWCA.size():0));
		    		q11AgeDataBean.setAge45to54WithOnlyChild(BigInteger.valueOf(clientWOnlyC != null ?clientWOnlyC.size():0));
		    		q11AgeDataBean.setAge45to54WOC(BigInteger.valueOf(clientWOC != null?clientWOC.size():0));
				
		    		totalUHHT.add(BigInteger.valueOf(clientUHHT != null ? clientUHHT.size() :0));
		    		totalWCA.add(BigInteger.valueOf(clientWCA != null ? clientWCA.size() :0));
		    		totalWithOnlyChild.add(BigInteger.valueOf(clientWOnlyC != null ? clientWOnlyC.size() :0));
		    		totalWOC.add(BigInteger.valueOf(clientWOC != null ?clientWOC.size() :0));
		    		totOverallTotal.add(BigInteger.valueOf(clients45To54.size()));
				
				}
				if(CollectionUtils.isNotEmpty(clients55To61)) {
					List<String> filteredClients = new ArrayList<>();
					clients55To61.parallelStream().forEach(client-> { filteredClients.add(client.getPersonalID()); });
					List<EnrollmentModel> clientWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientWOnlyC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
	
		    		q11AgeDataBean.setTotAge55to61(BigInteger.valueOf(clients55To61.size()));
		    		q11AgeDataBean.setAge55to61UHHT(BigInteger.valueOf(clientUHHT != null ?clientUHHT.size():0));
		    		q11AgeDataBean.setAge55to61WCA(BigInteger.valueOf( clientWCA != null ?clientWCA.size():0));
		    		q11AgeDataBean.setAge55to61WithOnlyChild(BigInteger.valueOf(clientWOnlyC != null? clientWOnlyC.size():0));
		    		q11AgeDataBean.setAge55to61WOC(BigInteger.valueOf(clientWOC != null ?clientWOC.size():0));
				
		    		totalUHHT.add(BigInteger.valueOf(clientUHHT != null ? clientUHHT.size() :0));
		    		totalWCA.add(BigInteger.valueOf(clientWCA != null ? clientWCA.size() :0));
		    		totalWithOnlyChild.add(BigInteger.valueOf(clientWOnlyC != null ? clientWOnlyC.size() :0));
		    		totalWOC.add(BigInteger.valueOf(clientWOC != null ?clientWOC.size() :0));
		    		totOverallTotal.add(BigInteger.valueOf(clients55To61.size()));
				}
				
				if(CollectionUtils.isNotEmpty(clientsOver61)) {
					List<String> filteredClients = new ArrayList<>();
					clientsOver61.parallelStream().forEach(client-> { filteredClients.add(client.getPersonalID()); });
					List<EnrollmentModel> clientWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientWOnlyC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
	
		    		q11AgeDataBean.setTotAge62Plus(BigInteger.valueOf(clientsOver61.size()));
		    		q11AgeDataBean.setAge62PlusUHHT(BigInteger.valueOf(clientUHHT != null ?clientUHHT.size():0));
		    		q11AgeDataBean.setAge62PlusWCA(BigInteger.valueOf(clientWCA != null ?clientWCA.size():0));
		    		q11AgeDataBean.setAge62PlusWithOnlyChild(BigInteger.valueOf(clientWOnlyC != null? clientWOnlyC.size():0));
		    		q11AgeDataBean.setAge62PlusWOC(BigInteger.valueOf(clientWOC != null ?clientWOC.size():0));
				
		    		totalUHHT.add(BigInteger.valueOf(clientUHHT != null ? clientUHHT.size() :0));
		    		totalWCA.add(BigInteger.valueOf(clientWCA != null ? clientWCA.size() :0));
		    		totalWithOnlyChild.add(BigInteger.valueOf(clientWOnlyC != null ? clientWOnlyC.size() :0));
		    		totalWOC.add(BigInteger.valueOf(clientWOC != null ?clientWOC.size() :0));
		    		totOverallTotal.add(BigInteger.valueOf(clientsOver61.size()));
		    		
				}
				if(CollectionUtils.isNotEmpty(clientsDNC)) {
					List<String> filteredClients = new ArrayList<>();
					clientsDNC.parallelStream().forEach(client-> { filteredClients.add(client.getPersonalID()); });
					List<EnrollmentModel> clientWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientWOnlyC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
	
		    		q11AgeDataBean.setTotAgeDKR(BigInteger.valueOf(clientsDNC.size()));
		    		q11AgeDataBean.setAgeDKRUHHT(BigInteger.valueOf(clientUHHT != null ?clientUHHT.size():0));
		    		q11AgeDataBean.setAgeDKRWCA(BigInteger.valueOf(clientWCA != null ?clientWCA.size():0));
		    		q11AgeDataBean.setAgeDKRWithOnlyChild(BigInteger.valueOf(clientWOnlyC != null? clientWOnlyC.size():0));
		    		q11AgeDataBean.setAgeDKRWOC(BigInteger.valueOf(clientWOC != null ?clientWOC.size():0));
				
		    		totalUHHT.add(BigInteger.valueOf(clientUHHT != null ? clientUHHT.size() :0));
		    		totalWCA.add(BigInteger.valueOf(clientWCA != null ? clientWCA.size() :0));
		    		totalWithOnlyChild.add(BigInteger.valueOf(clientWOnlyC != null ? clientWOnlyC.size() :0));
		    		totalWOC.add(BigInteger.valueOf(clientWOC != null ?clientWOC.size() :0));
		    		totOverallTotal.add(BigInteger.valueOf(clientsDNC.size()));
				}
				
				if(CollectionUtils.isNotEmpty(clientsDidnotknowRefused)) {
					List<String> filteredClients = new ArrayList<>();
					clientsDidnotknowRefused.parallelStream().forEach(client-> { filteredClients.add(client.getPersonalID()); });
					List<EnrollmentModel> clientWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientWOnlyC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && filteredClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
	
		    		q11AgeDataBean.setTotAgeInfoMissing(BigInteger.valueOf(clientsDidnotknowRefused.size()));
		    		q11AgeDataBean.setAgeInfoMissingUHHT(BigInteger.valueOf(clientUHHT != null ?clientUHHT.size():0));
		    		q11AgeDataBean.setAgeInfoMissingWCA(BigInteger.valueOf(clientWCA != null ?clientWCA.size():0));
		    		q11AgeDataBean.setAgeInfoMissingWithOnlyChild(BigInteger.valueOf(clientWOnlyC != null? clientWOnlyC.size():0));
		    		q11AgeDataBean.setAgeInfoMissingWOC(BigInteger.valueOf(clientWOC != null ?clientWOC.size():0));
		    	
		    		totalUHHT.add(BigInteger.valueOf(clientUHHT != null ? clientUHHT.size() :0));
		    		totalWCA.add(BigInteger.valueOf(clientWCA != null ? clientWCA.size() :0));
		    		totalWithOnlyChild.add(BigInteger.valueOf(clientWOnlyC != null ? clientWOnlyC.size() :0));
		    		totalWOC.add(BigInteger.valueOf(clientWOC != null ?clientWOC.size() :0));
		    		totOverallTotal.add(BigInteger.valueOf(clientsDidnotknowRefused.size()));
				}
	    		
	    		q11AgeDataBean.setAgeOverallTotalUHHT(totalUHHT);
	    		q11AgeDataBean.setAgeOverallTotalWCA(totalWCA);
	    		q11AgeDataBean.setAgeOverallTotalWithOnlyChild(totalWithOnlyChild);
	    		q11AgeDataBean.setAgeOverallTotalWOC(totalWOC);
	    		q11AgeDataBean.setTotOverallTotal(totOverallTotal);
	    		
	    		q11AgeDataBean.setTotMAISubtotal(data.getTotNumOfPersonServed());
	} catch (Exception e) {
		logger.error("Error in Q11BeanMaker:" + e);
	}
	}
	         	return Arrays.asList(q11AgeDataBean);
		
	}
	
}
