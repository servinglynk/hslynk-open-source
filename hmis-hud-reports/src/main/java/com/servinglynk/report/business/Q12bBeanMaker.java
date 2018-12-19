package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q12bEthnicityDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;
import com.servinglynk.report.model.EnrollmentModel;

public class Q12bBeanMaker extends BaseBeanMaker {
	
	public static List<Q12bEthnicityDataBean> getQ12bEthnicityList(ReportData data){
		Q12bEthnicityDataBean q12bEthnicityDataBean = new Q12bEthnicityDataBean();
		if(data.isLiveMode()) {
		try {
		List<ClientModel> clients = data.getClients();
		List<EnrollmentModel> enrollments = data.getEnrollments();
		BigInteger  totalUHHT = BigInteger.ZERO;
		BigInteger	totalWCA = BigInteger.ZERO;
		BigInteger	totalWithOnlyChild = BigInteger.ZERO;
		BigInteger	totalWOC = BigInteger.ZERO;
		BigInteger  totOverallTotal = BigInteger.ZERO;
		
		List<ClientModel> nonHispanicNonLatino = clients.parallelStream().filter(client -> StringUtils.equals("0", client.getEthnicity())).collect(Collectors.toList());
		List<ClientModel> hispanicLatino = clients.parallelStream().filter(client -> StringUtils.equals("1", client.getEthnicity())).collect(Collectors.toList());
		List<ClientModel> clientDKCR = clients.parallelStream().filter(client -> StringUtils.equals("8", client.getEthnicity()) || StringUtils.equals("9", client.getEthnicity())).collect(Collectors.toList());
		List<ClientModel> clientDNC = clients.parallelStream().filter(client -> StringUtils.equals("99", client.getEthnicity()) || StringUtils.isBlank(client.getEthnicity())).collect(Collectors.toList());
		
		List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
		List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
		List<String> projectsHHWithChildren = data.getProjectsHHWithChildren();
		List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
		
		if(CollectionUtils.isNotEmpty(nonHispanicNonLatino)) {
			
			List<String> filteredClients = new ArrayList<>();
			nonHispanicNonLatino.forEach(client-> { filteredClients.add(client.getDedupClientId()); });
			List<EnrollmentModel> clientWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && filteredClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> clientWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && filteredClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> clientUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && filteredClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> clientWOnlyC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && filteredClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
			int clientWOCSize = clientWOC != null ? clientWOC.size() : 0;
			int clientWCASize = clientWCA != null ? clientWCA.size() : 0;
			int clientUHHTSize = clientUHHT != null ? clientUHHT.size() : 0;
			int clientWOnlyCSize = clientWOnlyC != null ? clientWOnlyC.size() : 0;
		
	    	totalUHHT=totalUHHT.add(BigInteger.valueOf(clientUHHTSize));
    		totalWCA=totalWCA.add(BigInteger.valueOf(clientWCASize));
    		totalWithOnlyChild=totalWithOnlyChild.add(BigInteger.valueOf(clientWOnlyCSize));
    		totalWOC=totalWOC.add(BigInteger.valueOf(clientWOCSize));
    		totOverallTotal=totOverallTotal.add(BigInteger.valueOf(nonHispanicNonLatino.size()));
    		
			q12bEthnicityDataBean.setQ12bNonHispanicTotal(BigInteger.valueOf(nonHispanicNonLatino.size()));
			q12bEthnicityDataBean.setQ12bNonHispanicWithoutChildren(BigInteger.valueOf(clientWOCSize));
			q12bEthnicityDataBean.setQ12bNonHispanicWithChildrenAndAdults(BigInteger.valueOf(clientWCASize));
			q12bEthnicityDataBean.setQ12bNonHispanicWithOnlyChildren(BigInteger.valueOf(clientWOnlyCSize));
			q12bEthnicityDataBean.setQ12bNonHispanicUnknownhouseholdtype(BigInteger.valueOf(clientUHHTSize));
		}
		
		if(CollectionUtils.isNotEmpty(hispanicLatino)) {
			List<String> filteredClients = new ArrayList<>();
			hispanicLatino.forEach(client-> { filteredClients.add(client.getDedupClientId()); });
			List<EnrollmentModel> clientWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && filteredClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> clientWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && filteredClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> clientUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && filteredClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> clientWOnlyC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && filteredClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
			int clientWOCSize = clientWOC != null ? clientWOC.size() : 0;
			int clientWCASize = clientWCA != null ? clientWCA.size() : 0;
			int clientUHHTSize = clientUHHT != null ? clientUHHT.size() : 0;
			int clientWOnlyCSize = clientWOnlyC != null ? clientWOnlyC.size() : 0;
		
	    	totalUHHT=totalUHHT.add(BigInteger.valueOf(clientUHHTSize));
    		totalWCA=totalWCA.add(BigInteger.valueOf(clientWCASize));
    		totalWithOnlyChild=totalWithOnlyChild.add(BigInteger.valueOf(clientWOnlyCSize));
    		totalWOC=totalWOC.add(BigInteger.valueOf(clientWOCSize));
    		totOverallTotal=totOverallTotal.add(BigInteger.valueOf(hispanicLatino.size()));
    		
    		
			q12bEthnicityDataBean.setQ12bHispanicTotal(BigInteger.valueOf(hispanicLatino.size()));
			q12bEthnicityDataBean.setQ12bHispanicWithoutChildren(BigInteger.valueOf(clientWOCSize));
			q12bEthnicityDataBean.setQ12bHispanicWithChildrenAndAdults(BigInteger.valueOf(clientWCASize));
			q12bEthnicityDataBean.setQ12bHispanicWithOnlyChildren(BigInteger.valueOf(clientWOnlyCSize));
			q12bEthnicityDataBean.setQ12bHispanicUnknownhouseholdtype(BigInteger.valueOf(clientUHHTSize));
		}
		
		if(CollectionUtils.isNotEmpty(clientDKCR)) {
			
			List<String> filteredClients = new ArrayList<>();
			clientDKCR.forEach(client-> { filteredClients.add(client.getDedupClientId()); });
			List<EnrollmentModel> clientWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && filteredClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> clientWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && filteredClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> clientUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && filteredClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> clientWOnlyC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && filteredClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
			int clientWOCSize = clientWOC != null ? clientWOC.size() : 0;
			int clientWCASize = clientWCA != null ? clientWCA.size() : 0;
			int clientUHHTSize = clientUHHT != null ? clientUHHT.size() : 0;
			int clientWOnlyCSize = clientWOnlyC != null ? clientWOnlyC.size() : 0;
		
	    	totalUHHT=totalUHHT.add(BigInteger.valueOf(clientUHHTSize));
    		totalWCA=totalWCA.add(BigInteger.valueOf(clientWCASize));
    		totalWithOnlyChild=totalWithOnlyChild.add(BigInteger.valueOf(clientWOnlyCSize));
    		totalWOC=totalWOC.add(BigInteger.valueOf(clientWOCSize));
    		totOverallTotal=totOverallTotal.add(BigInteger.valueOf(clientDKCR.size()));
    		
			q12bEthnicityDataBean.setQ12bDontKnowRacesTotal(BigInteger.valueOf(clientDKCR.size()));
			q12bEthnicityDataBean.setQ12bDontKnowRacesWithoutChildren(BigInteger.valueOf(clientWOCSize));
			q12bEthnicityDataBean.setQ12bDontKnowRacesWithChildrenAndAdults(BigInteger.valueOf(clientWCASize));
			q12bEthnicityDataBean.setQ12bDontKnowRacesWithOnlyChildren(BigInteger.valueOf(clientWOnlyCSize));
			q12bEthnicityDataBean.setQ12bDontKnowRacesUnkownhouseholdtype(BigInteger.valueOf(clientUHHTSize));
		}
		
		if(CollectionUtils.isNotEmpty(clientDNC)) {
			
			List<String> filteredClients = new ArrayList<>();
			clientDNC.forEach(client-> { filteredClients.add(client.getDedupClientId()); });
			List<EnrollmentModel> clientWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && filteredClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> clientWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && filteredClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> clientUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && filteredClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> clientWOnlyC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && filteredClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
			int clientWOCSize = clientWOC != null ? clientWOC.size() : 0;
			int clientWCASize = clientWCA != null ? clientWCA.size() : 0;
			int clientUHHTSize = clientUHHT != null ? clientUHHT.size() : 0;
			int clientWOnlyCSize = clientWOnlyC != null ? clientWOnlyC.size() : 0;
		
	    	totalUHHT=totalUHHT.add(BigInteger.valueOf(clientUHHTSize));
    		totalWCA=totalWCA.add(BigInteger.valueOf(clientWCASize));
    		totalWithOnlyChild=totalWithOnlyChild.add(BigInteger.valueOf(clientWOnlyCSize));
    		totalWOC=totalWOC.add(BigInteger.valueOf(clientWOCSize));
    		totOverallTotal=totOverallTotal.add(BigInteger.valueOf(clientDNC.size()));
			q12bEthnicityDataBean.setQ12bInformationMissingTotal(BigInteger.valueOf(clientDNC.size()));
			q12bEthnicityDataBean.setQ12bInformationMissingWithoutChildren(BigInteger.valueOf(clientWOCSize));
			q12bEthnicityDataBean.setQ12bInformationMissingWithChildrenAndAdults(BigInteger.valueOf(clientWCASize));
			q12bEthnicityDataBean.setQ12bInformationMissingWithOnlyChildren(BigInteger.valueOf(clientWOnlyCSize));
			q12bEthnicityDataBean.setQ12bInformationMissingUnkownhouseholdtype(BigInteger.valueOf(clientUHHTSize));
		}
		
		q12bEthnicityDataBean.setQ12bTotalSummed(data.getTotNumOfPersonServed());
		q12bEthnicityDataBean.setQ12bTotalWithoutChildren(totalWOC);
		q12bEthnicityDataBean.setQ12bTotalWithChildrenAndAdults(totalWCA);
		q12bEthnicityDataBean.setQ12bTotalWithOnlyChildren(totalWithOnlyChild);
		q12bEthnicityDataBean.setQ12bTotalUnkownhouseholdtype(totalUHHT);
	} catch (Exception e) {
		logger.error("Error in Q12bBeanMaker:" + e);
	}
	}
		return Arrays.asList(q12bEthnicityDataBean);
		
	}

}
