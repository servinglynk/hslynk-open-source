package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q27cGenderYouthDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;
import com.servinglynk.report.model.EnrollmentModel;

public class Q27cGenderYouthDataBeanMaker extends BaseBeanMaker {
	
	public static List<Q27cGenderYouthDataBean> getQ27cGenderYouthList(ReportData data){
		
		Q27cGenderYouthDataBean q27cGenderYouthTable = new Q27cGenderYouthDataBean();
		if(data.isLiveMode()) {
			try{
				List<ClientModel> clients = data.getClients();
				List<ClientModel> clientsMale = clients.parallelStream().filter(client->StringUtils.equals("1",client.getGender())).collect(Collectors.toList());
				
				List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
				List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
				List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
				List<String> projectsHHWithChildren = data.getProjectsHHWithChildren();
				List<EnrollmentModel> enrollments = data.getEnrollments();
				int total = 0;
				int woc = 0;
				int wca = 0;
				int wc = 0;
				int uhht = 0;
				if(CollectionUtils.isNotEmpty(clientsMale)) {
					List<String> adultClients = new ArrayList<>();
					clientsMale.parallelStream().forEach(client-> { adultClients.add(client.getDedupClientId()); });
					List<EnrollmentModel> clientsWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && adultClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientsWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && adultClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientsWC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && adultClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientsUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && adultClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
					
					total += getSize(clientsMale) ;
					woc += getSize(clientsWOC);
					wca += getSize(clientsWCA);
					wc += getSize(clientsWC);
					uhht += getSize(clientsUHHT);
					
					q27cGenderYouthTable.setQ27cMaleTotal(BigInteger.valueOf(getSize(clientsMale)));
					q27cGenderYouthTable.setQ27cMaleWithoutChild(BigInteger.valueOf(getSize(clientsWOC)));
					q27cGenderYouthTable.setQ27cMaleWithChildAndAdults(BigInteger.valueOf(getSize(clientsWCA)));
					q27cGenderYouthTable.setQ27cMaleWithChildOnly(BigInteger.valueOf(getSize(clientsWC)));
					q27cGenderYouthTable.setQ27cMaleUnknownHouseHoldtype(BigInteger.valueOf(getSize(clientsUHHT)));
					
				}
				List<ClientModel> clientsFeMale = clients.parallelStream().filter(client->StringUtils.equals("0",client.getGender())).collect(Collectors.toList());
				if(CollectionUtils.isNotEmpty(clientsFeMale)) {
					List<String> adultFemaleClients = new ArrayList<>();
					clientsFeMale.parallelStream().forEach(client-> { adultFemaleClients.add(client.getDedupClientId()); });
					
					List<EnrollmentModel> clientsWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && adultFemaleClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientsWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && adultFemaleClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientsWC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && adultFemaleClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientsUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && adultFemaleClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
					
					total += getSize(clientsMale) ;
					woc += getSize(clientsWOC);
					wca += getSize(clientsWCA);
					wc += getSize(clientsWC);
					uhht += getSize(clientsUHHT);
					
					q27cGenderYouthTable.setQ27cFemaleTotal(BigInteger.valueOf(getSize(clientsFeMale)));
					q27cGenderYouthTable.setQ27cFemaleWithoutChild(BigInteger.valueOf(getSize(clientsWOC)));
					q27cGenderYouthTable.setQ27cFemaleWithChildAndAdults(BigInteger.valueOf(getSize(clientsWCA)));
					q27cGenderYouthTable.setQ27cFemaleWithChildOnly(BigInteger.valueOf(getSize(clientsWC)));
					q27cGenderYouthTable.setQ27cFemaleUnknownHouseHoldtype(BigInteger.valueOf(getSize(clientsUHHT)));
				}
				
				List<ClientModel> adultsTransMale = clients.parallelStream().filter(client->StringUtils.equals("2",client.getGender())).collect(Collectors.toList());
				if(CollectionUtils.isNotEmpty(adultsTransMale)) {
					List<String> adultsTransClients = new ArrayList<>();
					adultsTransMale.parallelStream().forEach(client-> { adultsTransClients.add(client.getDedupClientId()); });
					
					List<EnrollmentModel> clientsWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && adultsTransClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientsWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && adultsTransClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientsWC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && adultsTransClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientsUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && adultsTransClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
					
					total += getSize(clientsMale) ;
					woc += getSize(clientsWOC);
					wca += getSize(clientsWCA);
					wc += getSize(clientsWC);
					uhht += getSize(clientsUHHT);
					
					q27cGenderYouthTable.setQ27cTransgenderMaleToFemaleTotal(BigInteger.valueOf(getSize(adultsTransMale)));
					q27cGenderYouthTable.setQ27cTransgenderMaleToFemaleWithoutChild(BigInteger.valueOf(getSize(clientsWOC)));
					q27cGenderYouthTable.setQ27cTransgenderMaleToFemaleWithChildAndAdults(BigInteger.valueOf(getSize(clientsWCA)));
					q27cGenderYouthTable.setQ27cTransgenderMaleToFemaleWithChildOnly(BigInteger.valueOf(getSize(clientsWC)));
					q27cGenderYouthTable.setQ27cTransgenderMaleToFemaleUnknownHouseHoldtype(BigInteger.valueOf(getSize(clientsUHHT)));
								
				}
				
				
				List<ClientModel> adultsTransFeMale = clients.parallelStream().filter(client->StringUtils.equals("3",client.getGender())).collect(Collectors.toList());
				if(CollectionUtils.isNotEmpty(adultsTransFeMale)) {
					List<String> adultsTransClients = new ArrayList<>();
					adultsTransFeMale.parallelStream().forEach(client-> { adultsTransClients.add(client.getDedupClientId()); });
					
					List<EnrollmentModel> clientsWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && adultsTransClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientsWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && adultsTransClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientsWC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && adultsTransClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientsUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && adultsTransClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
					
					total += getSize(clientsMale) ;
					woc += getSize(clientsWOC);
					wca += getSize(clientsWCA);
					wc += getSize(clientsWC);
					uhht += getSize(clientsUHHT);
					
					q27cGenderYouthTable.setQ27cTransgenderFemaleToMaleTotal(BigInteger.valueOf(getSize(adultsTransFeMale)));
					q27cGenderYouthTable.setQ27cTransgenderFemaleToMaleWithoutChild(BigInteger.valueOf(getSize(clientsWOC)));
					q27cGenderYouthTable.setQ27cTransgenderFemaleToMaleWithChildAndAdults(BigInteger.valueOf(getSize(clientsWCA)));
					q27cGenderYouthTable.setQ27cTransgenderFemaleToMaleWithChildOnly(BigInteger.valueOf(getSize(clientsWC)));
					q27cGenderYouthTable.setQ27cTransgenderFemaleToMaleUnknownHouseHoldtype(BigInteger.valueOf(getSize(clientsUHHT)));

				}
			
				List<ClientModel> adultsOther = clients.parallelStream().filter(client->StringUtils.equals("4",client.getGender())).collect(Collectors.toList());
				if(CollectionUtils.isNotEmpty(adultsOther)) {
					List<String> otherClients = new ArrayList<>();
					adultsOther.parallelStream().forEach(client-> { otherClients.add(client.getDedupClientId()); });
					
					List<EnrollmentModel> clientsWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && otherClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientsWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && otherClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientsWC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && otherClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientsUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && otherClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
					
					total += getSize(clientsMale) ;
					woc += getSize(clientsWOC);
					wca += getSize(clientsWCA);
					wc += getSize(clientsWC);
					uhht += getSize(clientsUHHT);
					
					q27cGenderYouthTable.setQ27cOtherTotal(BigInteger.valueOf(getSize(adultsOther)));
					q27cGenderYouthTable.setQ27cOtherWithoutChild(BigInteger.valueOf(getSize(clientsWOC)));
					q27cGenderYouthTable.setQ27cOtherWithChildAndAdults(BigInteger.valueOf(getSize(clientsWCA)));
					q27cGenderYouthTable.setQ27cOtherWithChildOnly(BigInteger.valueOf(getSize(clientsWC)));
					q27cGenderYouthTable.setQ27cOtherUnknownHouseHoldtype(BigInteger.valueOf(getSize(clientsUHHT)));

				}
			
				List<ClientModel> clientDk = clients.parallelStream().filter(client->StringUtils.equals("8",client.getGender()) || StringUtils.equals("9",client.getGender())).collect(Collectors.toList());
				if(CollectionUtils.isNotEmpty(clientDk)) {
					List<String> dkClients = new ArrayList<>();
					clientDk.parallelStream().forEach(client-> { dkClients.add(client.getDedupClientId()); });
					List<EnrollmentModel> clientsWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && dkClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientsWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && dkClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientsWC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && dkClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientsUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && dkClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
					
					total += getSize(clientsMale) ;
					woc += getSize(clientsWOC);
					wca += getSize(clientsWCA);
					wc += getSize(clientsWC);
					uhht += getSize(clientsUHHT);
					
					q27cGenderYouthTable.setQ27cDKRTotal(BigInteger.valueOf(getSize(dkClients)));
					q27cGenderYouthTable.setQ27cDKRWithoutChild(BigInteger.valueOf(getSize(clientsWOC)));
					q27cGenderYouthTable.setQ27cDKRWithChildAndAdults(BigInteger.valueOf(getSize(clientsWCA)));
					q27cGenderYouthTable.setQ27cDKRWithChildOnly(BigInteger.valueOf(getSize(clientsWC)));
					q27cGenderYouthTable.setQ27cDKRUnknownHouseHoldtype(BigInteger.valueOf(getSize(clientsUHHT)));
				}
			
				List<ClientModel> clientMissing = clients.parallelStream().filter(client->StringUtils.equals("99",client.getGender())).collect(Collectors.toList());
				if(CollectionUtils.isNotEmpty(clientMissing)) {
					List<String> missingInfoClients = new ArrayList<>();
					clientMissing.parallelStream().forEach(client-> { missingInfoClients.add(client.getDedupClientId()); });
					List<EnrollmentModel> clientsWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && clientMissing.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientsWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && clientMissing.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientsWC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && clientMissing.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
					List<EnrollmentModel> clientsUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && clientMissing.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
					
					total += getSize(clientsMale) ;
					woc += getSize(clientsWOC);
					wca += getSize(clientsWCA);
					wc += getSize(clientsWC);
					uhht += getSize(clientsUHHT);
					
					
					q27cGenderYouthTable.setQ27cInformationMissingTotal(BigInteger.valueOf(getSize(missingInfoClients)));
					q27cGenderYouthTable.setQ27cInformationMissingWithoutChild(BigInteger.valueOf(getSize(clientsWOC)));
					q27cGenderYouthTable.setQ27cInformationMissingWithChildAndAdults(BigInteger.valueOf(getSize(clientsWCA)));
					q27cGenderYouthTable.setQ27cInformationMissingWithChildOnly(BigInteger.valueOf(getSize(clientsWC)));
					q27cGenderYouthTable.setQ27cInformationMissingUnknownHouseHoldtype(BigInteger.valueOf(getSize(clientsUHHT)));
				}
			
			
				q27cGenderYouthTable.setQ27cTotTotal(BigInteger.valueOf(total));
				q27cGenderYouthTable.setQ27cTotWithoutChild(BigInteger.valueOf(woc));
				q27cGenderYouthTable.setQ27cTotWithChildAndAdults(BigInteger.valueOf(wca));
				q27cGenderYouthTable.setQ27cTotWithChildOnly(BigInteger.valueOf(wc));
				q27cGenderYouthTable.setQ27cTotUnknownHouseHoldtype(BigInteger.valueOf(uhht));
				
				
			} catch (Exception e) {
				logger.error("Error in Q010aDataBeanMaker:" + e);
			}
		}
		return Arrays.asList(q27cGenderYouthTable);
	}
}
