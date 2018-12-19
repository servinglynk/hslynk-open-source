package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q12aRaceDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;
import com.servinglynk.report.model.EnrollmentModel;

public class Q12aBeanMaker extends BaseBeanMaker {
	
	public static List<Q12aRaceDataBean> getQ12aRaceList(ReportData data){
		Q12aRaceDataBean q12aRaceDataBean = new Q12aRaceDataBean();
		if(data.isLiveMode()) {
		try {
		String[] multipleRacesEnum = new String[] {"1", "2", "3", "4", "5"};
		List<String> multipleRacesList = Arrays.asList(multipleRacesEnum);
		List<ClientModel> clients = data.getClients();
		List<EnrollmentModel> enrollments = data.getEnrollments();
		BigInteger  totalUHHT = BigInteger.ZERO;
		BigInteger	totalWCA = BigInteger.ZERO;
		BigInteger	totalWithOnlyChild = BigInteger.ZERO;
		BigInteger	totalWOC = BigInteger.ZERO;
		BigInteger  totOverallTotal = BigInteger.ZERO;
		List<ClientModel> white = clients.parallelStream().filter(client -> StringUtils.equals("5", client.getRace())).collect(Collectors.toList());
		List<ClientModel> blackorAA = clients.parallelStream().filter(client -> StringUtils.equals("3", client.getRace())).collect(Collectors.toList());
		List<ClientModel> asian = clients.parallelStream().filter(client ->  StringUtils.equals("2", client.getRace())).collect(Collectors.toList());
		List<ClientModel> aaOrAlsakaNative = clients.parallelStream().filter(client ->  StringUtils.equals("1", client.getRace())).collect(Collectors.toList());
		List<ClientModel> nativeHawaianOrOtherPI = clients.parallelStream().filter(client ->  StringUtils.equals("4", client.getRace())).collect(Collectors.toList());
		List<ClientModel> multipleRaces = clients.parallelStream().filter(client -> client.getRace() != null && multipleRacesList.contains(client.getRace()) ).collect(Collectors.toList());
		List<ClientModel> clientDKCR = clients.parallelStream().filter(client ->  StringUtils.equals("8", client.getRace()) || StringUtils.equals("9", client.getRace())).collect(Collectors.toList());
		List<ClientModel> clientsDNC = clients.parallelStream().filter(client -> StringUtils.equals("99", client.getRace())).collect(Collectors.toList());
		
		List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
		List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
		List<String> projectsHHWithChildren = data.getProjectsHHWithChildren();
		List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
		
		if(CollectionUtils.isNotEmpty(white)) {
			List<String> filteredClients = new ArrayList<>();
			white.forEach(client-> { filteredClients.add(client.getDedupClientId()); });
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
    		totOverallTotal=totOverallTotal.add(BigInteger.valueOf(white.size()));
    		
    		q12aRaceDataBean.setQ12aWhiteTotal(BigInteger.valueOf(white.size()));
	    	q12aRaceDataBean.setQ12aWhiteWithChildrenAndAdults(BigInteger.valueOf(clientWCASize));
	    	q12aRaceDataBean.setQ12aWhiteWithOnlyChildren(BigInteger.valueOf(clientWOnlyCSize));
	    	q12aRaceDataBean.setQ12aWhiteWithoutChildren(BigInteger.valueOf(clientWOCSize));
	    	q12aRaceDataBean.setQ12aWhiteWithUnkownhouseholdtype(BigInteger.valueOf(clientUHHTSize));
		}
		if(CollectionUtils.isNotEmpty(blackorAA)) {
			List<String> filteredClients = new ArrayList<>();
			blackorAA.forEach(client-> { filteredClients.add(client.getDedupClientId()); });
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
    		totOverallTotal=totOverallTotal.add(BigInteger.valueOf(blackorAA.size()));
    		
			q12aRaceDataBean.setQ12aBlckAfrnAmrnTotal(BigInteger.valueOf(blackorAA.size()));
	    	q12aRaceDataBean.setQ12aBlckAfrnAmrnWithChildrenAndAdults(BigInteger.valueOf(clientWCASize));
	    	q12aRaceDataBean.setQ12aBlckAfrnAmrnWithOnlyChildren(BigInteger.valueOf(clientWOnlyCSize));
	    	q12aRaceDataBean.setQ12aBlckAfrnAmrnWithoutChildren(BigInteger.valueOf(clientWOCSize));
	    	q12aRaceDataBean.setQ12aBlckAfrnAmrnWithUnkownhouseholdtype(BigInteger.valueOf(clientUHHTSize));
		}
		
		if(CollectionUtils.isNotEmpty(asian)) {
			List<String> filteredClients = new ArrayList<>();
			asian.forEach(client-> { filteredClients.add(client.getDedupClientId()); });
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
    		totOverallTotal=totOverallTotal.add(BigInteger.valueOf(asian.size()));
    		
	    	q12aRaceDataBean.setQ12aAsianTotal(BigInteger.valueOf(asian.size()));
	    	q12aRaceDataBean.setQ12aAsianUnkownhouseholdtype(BigInteger.valueOf(clientUHHTSize));
	    	q12aRaceDataBean.setQ12aAsianWithChildrenAndAdults(BigInteger.valueOf(clientWCASize));
	    	q12aRaceDataBean.setQ12aAsianWithOnlyChildren(BigInteger.valueOf(clientWOnlyCSize));
	    	q12aRaceDataBean.setQ12aAsianWithoutChildren(BigInteger.valueOf(clientWOCSize));
		}
		if(CollectionUtils.isNotEmpty(aaOrAlsakaNative)) {
			List<String> filteredClients = new ArrayList<>();
			aaOrAlsakaNative.forEach(client-> { filteredClients.add(client.getDedupClientId()); });
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
    		totOverallTotal=totOverallTotal.add(BigInteger.valueOf(aaOrAlsakaNative.size()));
    		
			q12aRaceDataBean.setQ12aAmericanIndianTotal(BigInteger.valueOf(aaOrAlsakaNative.size()));
	    	q12aRaceDataBean.setQ12aAmericanIndianUnkownhouseholdtype(BigInteger.valueOf(clientUHHTSize));
	    	q12aRaceDataBean.setQ12aAmericanIndianWithChildrenAndAdults(BigInteger.valueOf(clientWCASize));
	    	q12aRaceDataBean.setQ12aAmericanIndianWithOnlyChildren(BigInteger.valueOf(clientWOnlyCSize));
	    	q12aRaceDataBean.setQ12aAmericanIndianWithoutChildren(BigInteger.valueOf(clientWOCSize));
		}
    	
		if(CollectionUtils.isNotEmpty(nativeHawaianOrOtherPI)) {
			List<String> filteredClients = new ArrayList<>();
			nativeHawaianOrOtherPI.forEach(client-> { filteredClients.add(client.getDedupClientId()); });
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
    		totOverallTotal=totOverallTotal.add(BigInteger.valueOf(nativeHawaianOrOtherPI.size()));
    		
			q12aRaceDataBean.setQ12aNativeHawalianTotal(BigInteger.valueOf(nativeHawaianOrOtherPI.size()));
	    	q12aRaceDataBean.setQ12aNativeHawalianUnkownhouseholdtype(BigInteger.valueOf(clientUHHTSize));
	    	q12aRaceDataBean.setQ12aNativeHawalianWithChildrenAndAdults(BigInteger.valueOf(clientWCASize));
	    	q12aRaceDataBean.setQ12aNativeHawalianWithOnlyChildren(BigInteger.valueOf(clientWOnlyCSize));
	    	q12aRaceDataBean.setQ12aNativeHawalianWithoutChildren(BigInteger.valueOf(clientWOCSize));
		}
		
		/***
		 * Making multiple races as 0. Right now we cannot have people with multiple races stores in HMIS.
		 */
    	
//		if(CollectionUtils.isNotEmpty(multipleRaces)) {
//			List<String> filteredClients = new ArrayList<>();
//			multipleRaces.forEach(client-> { filteredClients.add(client.getDedup_client_id()); });
//			List<EnrollmentModel> clientWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && filteredClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
//			List<EnrollmentModel> clientWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && filteredClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
//			List<EnrollmentModel> clientUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && filteredClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
//			List<EnrollmentModel> clientWOnlyC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && filteredClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
//			int clientWOCSize = clientWOC != null ? clientWOC.size() : 0;
//			int clientWCASize = clientWCA != null ? clientWCA.size() : 0;
//			int clientUHHTSize = clientUHHT != null ? clientUHHT.size() : 0;
//			int clientWOnlyCSize = clientWOnlyC != null ? clientWOnlyC.size() : 0;
//		
//	    	totalUHHT=totalUHHT.add(BigInteger.valueOf(clientUHHTSize));
//    		totalWCA=totalWCA.add(BigInteger.valueOf(clientWCASize));
//    		totalWithOnlyChild=totalWithOnlyChild.add(BigInteger.valueOf(clientWOnlyCSize));
//    		totalWOC=totalWOC.add(BigInteger.valueOf(clientWOCSize));
//    		totOverallTotal=totOverallTotal.add(BigInteger.valueOf(multipleRaces.size()));
//    		
//			q12aRaceDataBean.setQ12aMultipleRacesTotal(BigInteger.valueOf(multipleRaces.size()));
//	    	q12aRaceDataBean.setQ12aMultipleRacesUnkownhouseholdtype(BigInteger.valueOf(clientUHHTSize));
//	    	q12aRaceDataBean.setQ12aMultipleRacesWithChildrenAndAdults(BigInteger.valueOf(clientWCASize));
//	    	q12aRaceDataBean.setQ12aMultipleRacesWithOnlyChildren(BigInteger.valueOf(clientWOnlyCSize));
//	    	q12aRaceDataBean.setQ12aMultipleRacesWithoutChildren(BigInteger.valueOf(clientWOCSize));
//		}
    
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
    		
			q12aRaceDataBean.setQ12aDontKnowRacesTotal(BigInteger.valueOf(clientDKCR.size()));
	    	q12aRaceDataBean.setQ12aDontKnowRacesUnkownhouseholdtype(BigInteger.valueOf(clientUHHTSize));
	    	q12aRaceDataBean.setQ12aDontKnowRacesWithChildrenAndAdults(BigInteger.valueOf(clientWCASize));
	    	q12aRaceDataBean.setQ12aDontKnowRacesWithOnlyChildren(BigInteger.valueOf(clientWOnlyCSize));
	    	q12aRaceDataBean.setQ12aDontKnowRacesWithoutChildren(BigInteger.valueOf(clientWOCSize));
		}
		
		if(CollectionUtils.isNotEmpty(clientsDNC)) {
			
			List<String> filteredClients = new ArrayList<>();
			clientsDNC.forEach(client-> { filteredClients.add(client.getDedupClientId()); });
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
    		totOverallTotal=totOverallTotal.add(BigInteger.valueOf(clientsDNC.size()));
    		

			q12aRaceDataBean.setQ12aInformationMissingTotal(BigInteger.valueOf(clientsDNC.size()));
	    	q12aRaceDataBean.setQ12aInformationMissingUnkownhouseholdtype(BigInteger.valueOf(clientUHHTSize));
	    	q12aRaceDataBean.setQ12aInformationMissingWithChildrenAndAdults(BigInteger.valueOf(clientWCASize));
	    	q12aRaceDataBean.setQ12aInformationMissingWithOnlyChildren(BigInteger.valueOf(clientWOnlyCSize));
	    	q12aRaceDataBean.setQ12aInformationMissingWithoutChildren(BigInteger.valueOf(clientWOCSize));
		}
    	
    	q12aRaceDataBean.setQ12aTotalSummed(data.getTotNumOfPersonServed());
    	q12aRaceDataBean.setQ12aTotalUnkownhouseholdtype(totalUHHT);
    	q12aRaceDataBean.setQ12aTotalWithChildrenAndAdults(totalWCA);
    	q12aRaceDataBean.setQ12aTotalWithOnlyChildren(totalWithOnlyChild);
    	q12aRaceDataBean.setQ12aTotalWithoutChildren(totalWOC);
	} catch (Exception e) {
		logger.error("Error in Q12aDataBeanMaker:" + e);
	}
	}
		return Arrays.asList(q12aRaceDataBean);
		
	}

}
