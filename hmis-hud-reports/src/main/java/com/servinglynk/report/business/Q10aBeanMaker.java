package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q10aDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;
import com.servinglynk.report.model.EnrollmentModel;

public class Q10aBeanMaker extends BaseBeanMaker {
	
	public static List<Q10aDataBean> getQ10AGenderOfAdultsList(ReportData data){
		
		Q10aDataBean q10AGenderOfAdults = new Q10aDataBean();
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
		
		List<EnrollmentModel> adultsWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultsOther.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> adultsWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultsOther.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> adultsFemaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultsOther.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
		
		q10AGenderOfAdults.setTotOther(BigInteger.valueOf(adultsOther.size()));
		q10AGenderOfAdults.setOtherWOC(BigInteger.valueOf(adultsWOC != null ? adultsWOC.size() :0));
		q10AGenderOfAdults.setOtherWCA(BigInteger.valueOf(adultsWCA != null ?adultsWCA.size() :0));
		q10AGenderOfAdults.setOtherUHHT(BigInteger.valueOf(adultsFemaleUHHT != null ?adultsFemaleUHHT.size():0));
	}

	
	q10AGenderOfAdults.setTotDontKnowRefused(BigInteger.valueOf(0));
	q10AGenderOfAdults.setDkrWOC(BigInteger.valueOf(0));
	q10AGenderOfAdults.setDkrWCA(BigInteger.valueOf(0));
	q10AGenderOfAdults.setDkrUHHT(BigInteger.valueOf(0));
	
	q10AGenderOfAdults.setTotInfoMissing(BigInteger.valueOf(0));
	q10AGenderOfAdults.setInfomiisingWOC(BigInteger.valueOf(0));
	q10AGenderOfAdults.setInfomiisingWCA(BigInteger.valueOf(0));
	q10AGenderOfAdults.setInfomiisingUHHT(BigInteger.valueOf(0));
	
	q10AGenderOfAdults.setTotSubtotal(data.getNumOfAdults());
	q10AGenderOfAdults.setSubtotalWOC(BigInteger.valueOf(0));
	q10AGenderOfAdults.setSubtotalWCA(BigInteger.valueOf(0));
	q10AGenderOfAdults.setSubtotalUHHT(BigInteger.valueOf(0));

	return Arrays.asList(q10AGenderOfAdults);
}


}
