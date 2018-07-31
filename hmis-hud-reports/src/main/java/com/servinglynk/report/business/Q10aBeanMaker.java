package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q10aGenderOfAdultsDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;
import com.servinglynk.report.model.EnrollmentModel;

public class Q10aBeanMaker extends BaseBeanMaker {
	
	public static List<Q10aGenderOfAdultsDataBean> getQ10AGenderOfAdultsList(ReportData data){
		
		Q10aGenderOfAdultsDataBean q10AGenderOfAdults = new Q10aGenderOfAdultsDataBean();
		if(data.isLiveMode()) {
		try{
		List<ClientModel> clients = data.getClients();
		List<ClientModel> adults = clients.parallelStream().filter(client -> isAdult(client.getDob())).collect(Collectors.toList());
		List<ClientModel> adultsMale = adults.parallelStream().filter(client->StringUtils.equals("1",client.getGender())).collect(Collectors.toList());
		
		
		List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
		List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
		List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
		List<EnrollmentModel> enrollments = data.getEnrollments();
		if(CollectionUtils.isNotEmpty(adultsMale)) {
			List<String> adultClients = new ArrayList<>();
			adultsMale.parallelStream().forEach(client-> { adultClients.add(client.getPersonalID()); });
			List<EnrollmentModel> adultsWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> adultsWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> adultsMaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
	
			q10AGenderOfAdults.setTotMale(BigInteger.valueOf(adultsMale != null ?adultsMale.size() : 0));
			q10AGenderOfAdults.setMaleWOC(BigInteger.valueOf(adultsWOC != null ?adultsWOC.size() :0));
			q10AGenderOfAdults.setMaleWCA(BigInteger.valueOf(adultsWCA != null ? adultsWCA.size() :0 ));
			q10AGenderOfAdults.setMaleUHHT(BigInteger.valueOf(adultsMaleUHHT != null?adultsMaleUHHT.size() :0));
		}
		List<ClientModel> adultsFeMale = adults.parallelStream().filter(client->StringUtils.equals("0",client.getGender())).collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(adultsFeMale)) {
			List<String> adultFemaleClients = new ArrayList<>();
			adultsFeMale.parallelStream().forEach(client-> { adultFemaleClients.add(client.getPersonalID()); });
			
			List<EnrollmentModel> adultsWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultFemaleClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> adultsWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultFemaleClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> adultsFemaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultFemaleClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
			
			q10AGenderOfAdults.setTotFemale(BigInteger.valueOf(adultsFeMale.size()));
			q10AGenderOfAdults.setFemaleWOC(BigInteger.valueOf(adultsWOC != null?adultsWOC.size() :0 ));
			q10AGenderOfAdults.setFemaleWCA(BigInteger.valueOf(adultsWCA != null ?adultsWCA.size() : 0));
			q10AGenderOfAdults.setFemaleUHHT(BigInteger.valueOf(adultsFemaleUHHT != null ? adultsFemaleUHHT.size() :0));
		}
		
		List<ClientModel> adultsTransMale = adults.parallelStream().filter(client->StringUtils.equals("2",client.getGender())).collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(adultsTransMale)) {
			List<String> adultsTransClients = new ArrayList<>();
			adultsTransMale.parallelStream().forEach(client-> { adultsTransClients.add(client.getPersonalID()); });
			
			List<EnrollmentModel> adultsWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultsTransClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> adultsWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultsTransClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> adultsFemaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultsTransClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
			
			q10AGenderOfAdults.setTotTransgenderMF(BigInteger.valueOf(adultsTransMale.size()));
			q10AGenderOfAdults.setTransgenderMFWOC(BigInteger.valueOf(adultsWOC != null ?adultsWOC.size():0));
			q10AGenderOfAdults.setTransgenderMFWCA(BigInteger.valueOf(adultsWCA != null ?adultsWCA.size():0));
			q10AGenderOfAdults.setTransgenderMFUHHT(BigInteger.valueOf(adultsFemaleUHHT != null ? adultsFemaleUHHT.size() :0));
		}
		
		
		List<ClientModel> adultsTransFeMale = adults.parallelStream().filter(client->StringUtils.equals("3",client.getGender())).collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(adultsTransFeMale)) {
			List<String> adultsTransClients = new ArrayList<>();
			adultsTransFeMale.parallelStream().forEach(client-> { adultsTransClients.add(client.getPersonalID()); });
			
			List<EnrollmentModel> adultsWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultsTransClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> adultsWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultsTransClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> adultsFemaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultsTransClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
			
			q10AGenderOfAdults.setTotTransgenderFM(BigInteger.valueOf(adultsTransFeMale.size()));
			q10AGenderOfAdults.setTransgenderFMWOC(BigInteger.valueOf(adultsWOC != null ?adultsWOC.size() :0));
			q10AGenderOfAdults.setTransgenderFMWCA(BigInteger.valueOf(adultsWCA != null ? adultsWCA.size() :0));
			q10AGenderOfAdults.setTransgenderFMUHHT(BigInteger.valueOf(adultsFemaleUHHT != null ? adultsFemaleUHHT.size() :0));
		}
	
		List<ClientModel> adultsOther = adults.parallelStream().filter(client->StringUtils.equals("4",client.getGender())).collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(adultsOther)) {
			List<String> otherClients = new ArrayList<>();
			adultsOther.parallelStream().forEach(client-> { otherClients.add(client.getPersonalID()); });
			
			List<EnrollmentModel> adultsWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && otherClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> adultsWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && otherClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> adultsFemaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && otherClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
			
			q10AGenderOfAdults.setTotOther(BigInteger.valueOf(adultsOther.size()));
			q10AGenderOfAdults.setOtherWOC(BigInteger.valueOf(adultsWOC != null ? adultsWOC.size() :0));
			q10AGenderOfAdults.setOtherWCA(BigInteger.valueOf(adultsWCA != null ?adultsWCA.size() :0));
			q10AGenderOfAdults.setOtherUHHT(BigInteger.valueOf(adultsFemaleUHHT != null ?adultsFemaleUHHT.size():0));
		}
	
		List<ClientModel> clientDk = adults.parallelStream().filter(client->StringUtils.equals("8",client.getGender()) || StringUtils.equals("9",client.getGender())).collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(clientDk)) {
			List<String> dkClients = new ArrayList<>();
			clientDk.parallelStream().forEach(client-> { dkClients.add(client.getPersonalID()); });
			List<EnrollmentModel> adultsWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && dkClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> adultsWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && dkClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> adultsFemaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && dkClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
			
			q10AGenderOfAdults.setTotDontKnowRefused(BigInteger.valueOf(dkClients.size()));
			q10AGenderOfAdults.setDkrWOC(BigInteger.valueOf(adultsWOC != null ?adultsWOC.size() :0));
			q10AGenderOfAdults.setDkrWCA(BigInteger.valueOf(adultsWCA != null ?adultsWCA.size() :0));
			q10AGenderOfAdults.setDkrUHHT(BigInteger.valueOf(adultsFemaleUHHT != null ?adultsFemaleUHHT.size() :0));
		}
	
		List<ClientModel> clientMissing = adults.parallelStream().filter(client->StringUtils.equals("99",client.getGender())).collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(clientMissing)) {
			List<String> missingInfoClients = new ArrayList<>();
			clientMissing.parallelStream().forEach(client-> { missingInfoClients.add(client.getPersonalID()); });
			List<EnrollmentModel> adultsWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && clientMissing.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> adultsWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && clientMissing.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> adultsFemaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && clientMissing.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
			
			q10AGenderOfAdults.setTotInfoMissing(BigInteger.valueOf(clientMissing != null ?clientMissing.size() :0));
			q10AGenderOfAdults.setInfomiisingWOC(BigInteger.valueOf(adultsWOC != null ?adultsWOC.size() :0));
			q10AGenderOfAdults.setInfomiisingWCA(BigInteger.valueOf(adultsWCA != null ? adultsWCA.size() :0));
			q10AGenderOfAdults.setInfomiisingUHHT(BigInteger.valueOf(adultsFemaleUHHT != null ? adultsFemaleUHHT.size() :0));
		}
		BigInteger totSubTotal = getBigIntValue(q10AGenderOfAdults.getTotDontKnowRefused()).add(getBigIntValue(q10AGenderOfAdults.getTotFemale())).add(getBigIntValue(q10AGenderOfAdults.getTotInfoMissing()))
				.add(getBigIntValue(q10AGenderOfAdults.getTotInfoMissing())).add(getBigIntValue(q10AGenderOfAdults.getTotMale())).add(getBigIntValue(q10AGenderOfAdults.getTotOther())).add(getBigIntValue(q10AGenderOfAdults.getTotTransgenderFM()))
				.add(getBigIntValue(q10AGenderOfAdults.getTotTransgenderMF()));
		
		BigInteger subtotalWOC = getBigIntValue(q10AGenderOfAdults.getDkrWOC()).add(getBigIntValue(q10AGenderOfAdults.getMaleWOC()))
				.add(getBigIntValue(q10AGenderOfAdults.getFemaleWOC())).add(getBigIntValue(q10AGenderOfAdults.getInfomiisingWOC()))
				.add(getBigIntValue((q10AGenderOfAdults.getOtherWOC())).add(getBigIntValue(q10AGenderOfAdults.getTransgenderFMWOC()))
				.add(getBigIntValue(q10AGenderOfAdults.getTransgenderMFWOC())));
				
		BigInteger subtotalWCA = 	getBigIntValue(q10AGenderOfAdults.getDkrWCA()).add(getBigIntValue((q10AGenderOfAdults.getMaleWCA()))).add(getBigIntValue(q10AGenderOfAdults.getFemaleWCA()))
				.add(getBigIntValue(q10AGenderOfAdults.getInfomiisingWCA())).add(getBigIntValue(q10AGenderOfAdults.getOtherWCA())).add(getBigIntValue(q10AGenderOfAdults.getTransgenderFMWCA()))
				.add(getBigIntValue(q10AGenderOfAdults.getTransgenderMFWCA()));
		
		BigInteger subtotalUHHT = getBigIntValue(q10AGenderOfAdults.getDkrUHHT()).add(getBigIntValue(q10AGenderOfAdults.getFemaleUHHT())).add(getBigIntValue(q10AGenderOfAdults.getMaleUHHT()))
					.add(getBigIntValue(q10AGenderOfAdults.getInfomiisingUHHT())).add(getBigIntValue(q10AGenderOfAdults.getOtherUHHT())).add(getBigIntValue(q10AGenderOfAdults.getTransgenderFMUHHT()))
					.add(getBigIntValue(q10AGenderOfAdults.getTransgenderMFUHHT()));
		
		q10AGenderOfAdults.setTotSubtotal(totSubTotal);
		q10AGenderOfAdults.setSubtotalWOC(subtotalWOC);
		q10AGenderOfAdults.setSubtotalWCA(subtotalWCA);
		q10AGenderOfAdults.setSubtotalUHHT(subtotalUHHT);
	} catch (Exception e) {
		logger.error("Error in Q010aDataBeanMaker:" + e);
	}
	}
	return Arrays.asList(q10AGenderOfAdults);
}


}
