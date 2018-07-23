package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q10bDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;
import com.servinglynk.report.model.EnrollmentModel;

public class Q10bBeanMaker extends BaseBeanMaker {

	public static List<Q10bDataBean> getQ10bGenderOfChildrenList(ReportData data){
    	
		Q10bDataBean q10bGenderOfChildren = new Q10bDataBean();
		
		
		List<ClientModel> clients = data.getClients();
		List<ClientModel> children = clients.parallelStream().filter(client -> !isAdult(client.getDob())).collect(Collectors.toList());
		List<ClientModel> childrenMale = children.parallelStream().filter(client->StringUtils.equals("1",client.getGender())).collect(Collectors.toList());
		
		
		List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
		List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
		List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
		List<EnrollmentModel> enrollments = data.getEnrollments();
		if(CollectionUtils.isNotEmpty(childrenMale)) {
			List<String> adultClients = new ArrayList<>();
			childrenMale.parallelStream().forEach(client-> { adultClients.add(client.getPersonalID()); });
			List<EnrollmentModel> childrenWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> childrenWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> childrenMaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());

			q10bGenderOfChildren.setTotChildMale(BigInteger.valueOf(childrenMale != null ?childrenMale.size() : 0));
			q10bGenderOfChildren.setChildMaleWOC(BigInteger.valueOf(childrenWOC != null ?childrenWOC.size() :0));
			q10bGenderOfChildren.setChildMaleWCA(BigInteger.valueOf(childrenWCA != null ? childrenWCA.size() :0 ));
			q10bGenderOfChildren.setChildMaleUHHT(BigInteger.valueOf(childrenMaleUHHT != null?childrenMaleUHHT.size() :0));
		}
		List<ClientModel> childrenFeMale = children.parallelStream().filter(client->StringUtils.equals("0",client.getGender())).collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(childrenFeMale)) {
			List<String> adultFemaleClients = new ArrayList<>();
			childrenFeMale.parallelStream().forEach(client-> { adultFemaleClients.add(client.getPersonalID()); });
			
			List<EnrollmentModel> childrenWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultFemaleClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> childrenWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultFemaleClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> childrenFemaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultFemaleClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
			
			q10bGenderOfChildren.setTotChildFemale(BigInteger.valueOf(childrenFeMale.size()));
			q10bGenderOfChildren.setChildFemaleWOC(BigInteger.valueOf(childrenWOC != null?childrenWOC.size() :0 ));
			q10bGenderOfChildren.setChildFemaleWCA(BigInteger.valueOf(childrenWCA != null ?childrenWCA.size() : 0));
			q10bGenderOfChildren.setChildFemaleUHHT(BigInteger.valueOf(childrenFemaleUHHT != null ? childrenFemaleUHHT.size() :0));
		}
		
		List<ClientModel> childrenTransMale = children.parallelStream().filter(client->StringUtils.equals("2",client.getGender())).collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(childrenTransMale)) {
			List<String> childrenTransClients = new ArrayList<>();
			childrenTransMale.parallelStream().forEach(client-> { childrenTransClients.add(client.getPersonalID()); });
			
			List<EnrollmentModel> childrenWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && childrenTransClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> childrenWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && childrenTransClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> childrenFemaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && childrenTransClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
			
			q10bGenderOfChildren.setTotChildTransgenderMF(BigInteger.valueOf(childrenTransMale.size()));
			q10bGenderOfChildren.setChildTransgenderMFWOC(BigInteger.valueOf(childrenWOC != null ?childrenWOC.size():0));
			q10bGenderOfChildren.setChildTransgenderMFWCA(BigInteger.valueOf(childrenWCA != null ?childrenWCA.size():0));
			q10bGenderOfChildren.setChildTransgenderMFUHHT(BigInteger.valueOf(childrenFemaleUHHT != null ? childrenFemaleUHHT.size() :0));
		}
		
		
		List<ClientModel> childrenTransFeMale = children.parallelStream().filter(client->StringUtils.equals("3",client.getGender())).collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(childrenTransFeMale)) {
			List<String> childrenTransClients = new ArrayList<>();
			childrenTransFeMale.parallelStream().forEach(client-> { childrenTransClients.add(client.getPersonalID()); });
			
			List<EnrollmentModel> childrenWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && childrenTransClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> childrenWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && childrenTransClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> childrenFemaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && childrenTransClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
			
			q10bGenderOfChildren.setTotChildTransgenderFM(BigInteger.valueOf(childrenTransFeMale.size()));
			q10bGenderOfChildren.setChildTransgenderFMWOC(BigInteger.valueOf(childrenWOC != null ?childrenWOC.size() :0));
			q10bGenderOfChildren.setChildTransgenderFMWCA(BigInteger.valueOf(childrenWCA != null ? childrenWCA.size() :0));
			q10bGenderOfChildren.setChildTransgenderFMUHHT(BigInteger.valueOf(childrenFemaleUHHT != null ? childrenFemaleUHHT.size() :0));
		}

		List<ClientModel> childrenOther = children.parallelStream().filter(client->StringUtils.equals("4",client.getGender())).collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(childrenOther)) {
			List<String> otherClients = new ArrayList<>();
			childrenOther.parallelStream().forEach(client-> { otherClients.add(client.getPersonalID()); });
			
			List<EnrollmentModel> childrenWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && otherClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> childrenWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && otherClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> childrenFemaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && otherClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
			
			q10bGenderOfChildren.setTotChildOther(BigInteger.valueOf(childrenOther.size()));
			q10bGenderOfChildren.setChildOtherWOC(BigInteger.valueOf(childrenWOC != null ? childrenWOC.size() :0));
			q10bGenderOfChildren.setChildOtherWCA(BigInteger.valueOf(childrenWCA != null ?childrenWCA.size() :0));
			q10bGenderOfChildren.setChildOtherUHHT(BigInteger.valueOf(childrenFemaleUHHT != null ?childrenFemaleUHHT.size():0));
		}

		List<ClientModel> clientDk = children.parallelStream().filter(client->StringUtils.equals("8",client.getGender()) || StringUtils.equals("9",client.getGender())).collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(clientDk)) {
			List<String> dkClients = new ArrayList<>();
			clientDk.parallelStream().forEach(client-> { dkClients.add(client.getPersonalID()); });
			List<EnrollmentModel> childrenWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && dkClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> childrenWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && dkClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> childrenFemaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && dkClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
			
			q10bGenderOfChildren.setTotChildDontKnowRefused(BigInteger.valueOf(dkClients.size()));
			q10bGenderOfChildren.setChildDkrWOC(BigInteger.valueOf(childrenWOC != null ?childrenWOC.size() :0));
			q10bGenderOfChildren.setChildDkrWCA(BigInteger.valueOf(childrenWCA != null ?childrenWCA.size() :0));
			q10bGenderOfChildren.setChildDkrUHHT(BigInteger.valueOf(childrenFemaleUHHT != null ?childrenFemaleUHHT.size() :0));
		}

		List<ClientModel> clientMissing = children.parallelStream().filter(client->StringUtils.equals("99",client.getGender())).collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(clientMissing)) {
			List<String> missingInfoClients = new ArrayList<>();
			clientMissing.parallelStream().forEach(client-> { missingInfoClients.add(client.getPersonalID()); });
			List<EnrollmentModel> childrenWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && clientMissing.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> childrenWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && clientMissing.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
			List<EnrollmentModel> childrenFemaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && clientMissing.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
			
			q10bGenderOfChildren.setTotChildInfoMissing(BigInteger.valueOf(clientMissing != null ?clientMissing.size() :0));
			q10bGenderOfChildren.setChildInfomiisingWOC(BigInteger.valueOf(childrenWOC != null ?childrenWOC.size() :0));
			q10bGenderOfChildren.setChildInfomiisingWCA(BigInteger.valueOf(childrenWCA != null ? childrenWCA.size() :0));
			q10bGenderOfChildren.setChildInfomiisingUHHT(BigInteger.valueOf(childrenFemaleUHHT != null ? childrenFemaleUHHT.size() :0));
		}
		BigInteger totSubTotal = getBigIntValue(q10bGenderOfChildren.getTotChildDontKnowRefused()).add(getBigIntValue(q10bGenderOfChildren.getTotChildFemale())).add(getBigIntValue(q10bGenderOfChildren.getTotChildInfoMissing()))
				.add(getBigIntValue(q10bGenderOfChildren.getTotChildInfoMissing())).add(getBigIntValue(q10bGenderOfChildren.getTotChildMale())).add(getBigIntValue(q10bGenderOfChildren.getTotChildOther())).add(getBigIntValue(q10bGenderOfChildren.getTotChildTransgenderFM()))
				.add(getBigIntValue(q10bGenderOfChildren.getTotChildTransgenderMF()));
		
		BigInteger subtotalWOC = getBigIntValue(q10bGenderOfChildren.getChildDkrWOC()).add(getBigIntValue(q10bGenderOfChildren.getChildMaleWOC()))
				.add(getBigIntValue(q10bGenderOfChildren.getChildFemaleWOC())).add(getBigIntValue(q10bGenderOfChildren.getChildInfomiisingWOC()))
				.add(getBigIntValue(q10bGenderOfChildren.getChildOtherWOC())).add(getBigIntValue(q10bGenderOfChildren.getChildTransgenderFMWOC()))
				.add(getBigIntValue(q10bGenderOfChildren.getChildTransgenderMFWOC()));
				
		BigInteger subtotalWCA = 	getBigIntValue(q10bGenderOfChildren.getChildDkrWCA()).add(getBigIntValue(q10bGenderOfChildren.getChildMaleWCA())).add(getBigIntValue(q10bGenderOfChildren.getChildFemaleWCA()))
				.add(getBigIntValue(q10bGenderOfChildren.getChildInfomiisingWCA())).add(getBigIntValue(q10bGenderOfChildren.getChildOtherWCA())).add(getBigIntValue(q10bGenderOfChildren.getChildTransgenderFMWCA()))
				.add(getBigIntValue(q10bGenderOfChildren.getChildTransgenderMFWCA()));
		
		BigInteger subtotalUHHT = getBigIntValue(q10bGenderOfChildren.getChildDkrUHHT()).add(getBigIntValue(q10bGenderOfChildren.getChildFemaleUHHT())).add(getBigIntValue(q10bGenderOfChildren.getChildMaleUHHT()))
					.add(getBigIntValue(q10bGenderOfChildren.getChildInfomiisingUHHT())).add(getBigIntValue(q10bGenderOfChildren.getChildOtherUHHT())).add(getBigIntValue(q10bGenderOfChildren.getChildTransgenderFMUHHT()))
					.add(getBigIntValue(q10bGenderOfChildren.getChildTransgenderMFUHHT()));
		q10bGenderOfChildren.setTotChildSubtotal(totSubTotal);
		q10bGenderOfChildren.setChildSubtotalWOC(subtotalWOC);
		q10bGenderOfChildren.setChildSubtotalWCA(subtotalWCA);
		q10bGenderOfChildren.setChildSubtotalUHHT(subtotalUHHT);
		
    	return Arrays.asList(q10bGenderOfChildren);
    	
    }
    


}
