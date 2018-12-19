package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q10cGenderOfPersonsMissingAgeInformationDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;
import com.servinglynk.report.model.EnrollmentModel;

public class Q10cBeanMaker extends BaseBeanMaker{
	
	public static List<Q10cGenderOfPersonsMissingAgeInformationDataBean> getQ10CGPMIList(ReportData data){
		
		Q10cGenderOfPersonsMissingAgeInformationDataBean q10cGenderofPersonsMissingAgeInformation = new Q10cGenderOfPersonsMissingAgeInformationDataBean();
		if(data.isLiveMode()) {
		try{
		String[] missing = new String[] {"8","9","99"};
		List<String> missingList = Arrays.asList(missing);
	  	
			List<ClientModel> clients = data.getClients();
			List<ClientModel> mai = clients.parallelStream().filter(client -> client.getAge()==0).collect(Collectors.toList());
			List<ClientModel> maiMale = mai.parallelStream().filter(client->StringUtils.equals("1",client.getGender())).collect(Collectors.toList());
			
			List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
			List<String> projectsHHWithOneAdult = data.getProjectsHHWithOneAdultChild();
			List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
			List<EnrollmentModel> enrollments = data.getEnrollments();
			if(CollectionUtils.isNotEmpty(maiMale)) {
				List<String> adultClients = new ArrayList<>();
				maiMale.forEach(client-> { adultClients.add(client.getDedupClientId()); });
				List<EnrollmentModel> maiWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && adultClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && adultClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOneAdult.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiMaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && adultClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());

				q10cGenderofPersonsMissingAgeInformation.setTotMAIMale(BigInteger.valueOf(maiMale != null ?maiMale.size() : 0));
				q10cGenderofPersonsMissingAgeInformation.setMaleMAIWOC(BigInteger.valueOf(maiWOC != null ?maiWOC.size() :0));
				q10cGenderofPersonsMissingAgeInformation.setMaleMAIWCA(BigInteger.valueOf(maiWCA != null ? maiWCA.size() :0 ));
				q10cGenderofPersonsMissingAgeInformation.setMaleMAIUHHT(BigInteger.valueOf(maiMaleUHHT != null?maiMaleUHHT.size() :0));
			}
			List<ClientModel> maiFeMale = mai.parallelStream().filter(client->StringUtils.equals("0",client.getGender())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(maiFeMale)) {
				List<String> adultFemaleClients = new ArrayList<>();
				maiFeMale.forEach(client-> { adultFemaleClients.add(client.getDedupClientId()); });
				
				List<EnrollmentModel> maiWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && adultFemaleClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && adultFemaleClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOneAdult.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiFemaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && adultFemaleClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				q10cGenderofPersonsMissingAgeInformation.setTotMAIFemale(BigInteger.valueOf(maiFeMale.size()));
				q10cGenderofPersonsMissingAgeInformation.setFemaleMAIWOC(BigInteger.valueOf(maiWOC != null?maiWOC.size() :0 ));
				q10cGenderofPersonsMissingAgeInformation.setFemaleMAIWCA(BigInteger.valueOf(maiWCA != null ?maiWCA.size() : 0));
				q10cGenderofPersonsMissingAgeInformation.setFemaleMAIUHHT(BigInteger.valueOf(maiFemaleUHHT != null ? maiFemaleUHHT.size() :0));
			}
			
			List<ClientModel> maiTransMale = mai.parallelStream().filter(client->StringUtils.equals("2",client.getGender())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(maiTransMale)) {
				List<String> maiTransClients = new ArrayList<>();
				maiTransMale.forEach(client-> { maiTransClients.add(client.getDedupClientId()); });
				
				List<EnrollmentModel> maiWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && maiTransClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && maiTransClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOneAdult.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiFemaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && maiTransClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				q10cGenderofPersonsMissingAgeInformation.setTotMAITransgenderMF(BigInteger.valueOf(maiTransMale.size()));
				q10cGenderofPersonsMissingAgeInformation.setTransgenderMFMAIWOC(BigInteger.valueOf(maiWOC != null ?maiWOC.size():0));
				q10cGenderofPersonsMissingAgeInformation.setTransgenderMFMAIWCA(BigInteger.valueOf(maiWCA != null ?maiWCA.size():0));
				q10cGenderofPersonsMissingAgeInformation.setTransgenderMFMAIUHHT(BigInteger.valueOf(maiFemaleUHHT != null ? maiFemaleUHHT.size() :0));
			}
			
			
			List<ClientModel> maiTransFeMale = mai.parallelStream().filter(client->StringUtils.equals("3",client.getGender())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(maiTransFeMale)) {
				List<String> maiTransClients = new ArrayList<>();
				maiTransFeMale.forEach(client-> { maiTransClients.add(client.getDedupClientId()); });
				
				List<EnrollmentModel> maiWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && maiTransClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && maiTransClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOneAdult.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiFemaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && maiTransClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				q10cGenderofPersonsMissingAgeInformation.setTotMAITransgenderFM(BigInteger.valueOf(maiTransFeMale.size()));
				q10cGenderofPersonsMissingAgeInformation.setTransgenderFMMAIWOC(BigInteger.valueOf(maiWOC != null ?maiWOC.size() :0));
				q10cGenderofPersonsMissingAgeInformation.setTransgenderFMMAIWCA(BigInteger.valueOf(maiWCA != null ? maiWCA.size() :0));
				q10cGenderofPersonsMissingAgeInformation.setTransgenderFMMAIUHHT(BigInteger.valueOf(maiFemaleUHHT != null ? maiFemaleUHHT.size() :0));
			}

			List<ClientModel> maiOther = mai.parallelStream().filter(client->StringUtils.equals("4",client.getGender())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(maiOther)) {
				List<String> otherClients = new ArrayList<>();
				maiOther.forEach(client-> { otherClients.add(client.getDedupClientId()); });
				
				List<EnrollmentModel> maiWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && otherClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && otherClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOneAdult.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiFemaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && otherClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				q10cGenderofPersonsMissingAgeInformation.setTotMAIOther(BigInteger.valueOf(maiOther.size()));
				q10cGenderofPersonsMissingAgeInformation.setOtherMAIWOC(BigInteger.valueOf(maiWOC != null ? maiWOC.size() :0));
				q10cGenderofPersonsMissingAgeInformation.setOtherMAIWCA(BigInteger.valueOf(maiWCA != null ?maiWCA.size() :0));
				q10cGenderofPersonsMissingAgeInformation.setOtherMAIUHHT(BigInteger.valueOf(maiFemaleUHHT != null ?maiFemaleUHHT.size():0));
			}

			List<ClientModel> clientDk = mai.parallelStream().filter(client->StringUtils.equals("8",client.getGender()) || StringUtils.equals("9",client.getGender())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(clientDk)) {
				List<String> dkClients = new ArrayList<>();
				clientDk.forEach(client-> { dkClients.add(client.getDedupClientId()); });
				List<EnrollmentModel> maiWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && dkClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && dkClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOneAdult.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiFemaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && dkClients.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				q10cGenderofPersonsMissingAgeInformation.setTotMAIDontKnowRefused(BigInteger.valueOf(dkClients.size()));
				q10cGenderofPersonsMissingAgeInformation.setDkrMAIWOC(BigInteger.valueOf(maiWOC != null ?maiWOC.size() :0));
				q10cGenderofPersonsMissingAgeInformation.setDkrMAIWCA(BigInteger.valueOf(maiWCA != null ?maiWCA.size() :0));
				q10cGenderofPersonsMissingAgeInformation.setDkrMAIUHHT(BigInteger.valueOf(maiFemaleUHHT != null ?maiFemaleUHHT.size() :0));
			}

			List<ClientModel> clientMissing = mai.parallelStream().filter(client->StringUtils.equals("99",client.getGender())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(clientMissing)) {
				List<String> missingInfoClients = new ArrayList<>();
				clientMissing.forEach(client-> { missingInfoClients.add(client.getDedupClientId()); });
				List<EnrollmentModel> maiWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && clientMissing.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && clientMissing.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsHHWithOneAdult.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiFemaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getDedupClientId() != null && clientMissing.contains(enrollment.getDedupClientId())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				q10cGenderofPersonsMissingAgeInformation.setTotMAIInfoMissing(BigInteger.valueOf(clientMissing != null ?clientMissing.size() :0));
				q10cGenderofPersonsMissingAgeInformation.setInfomissingMAIWOC(BigInteger.valueOf(maiWOC != null ?maiWOC.size() :0));
				q10cGenderofPersonsMissingAgeInformation.setInfomissingMAIWCA(BigInteger.valueOf(maiWCA != null ? maiWCA.size() :0));
				q10cGenderofPersonsMissingAgeInformation.setInfomissingMAIUHHT(BigInteger.valueOf(maiFemaleUHHT != null ? maiFemaleUHHT.size() :0));
			}
			BigInteger totSubTotal = getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getTotMAIDontKnowRefused()).add(getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getTotMAIFemale())).add(getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getTotMAIInfoMissing()))
					.add(getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getTotMAIInfoMissing())).add(getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getTotMAIMale())).add(getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getTotMAIOther())).add(getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getTotMAITransgenderFM()))
					.add(getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getTotMAITransgenderMF()));
			
			BigInteger subtotalWOC = getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getDkrMAIWOC()).add(getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getMaleMAIWOC()))
					.add(getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getFemaleMAIWOC())).add(getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getInfomissingMAIWOC()))
					.add(getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getOtherMAIWOC())).add(getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getTransgenderFMMAIWOC()))
					.add(getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getTransgenderMFMAIWOC()));
					
			BigInteger subtotalWCA = 	getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getDkrMAIWCA()).add(getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getMaleMAIWCA())).add(getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getFemaleMAIWCA()))
					.add(getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getInfomissingMAIWCA())).add(getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getOtherMAIWCA())).add(getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getTransgenderFMMAIWCA()))
					.add(getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getTransgenderMFMAIWCA()));
			
			BigInteger subtotalUHHT = getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getDkrMAIUHHT()).add(getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getFemaleMAIUHHT())).add(getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getMaleMAIUHHT()))
						.add(getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getInfomissingMAIUHHT())).add(getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getOtherMAIUHHT())).add(getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getTransgenderFMMAIUHHT()))
						.add(getBigIntValue(q10cGenderofPersonsMissingAgeInformation.getTransgenderMFMAIUHHT()));
			
			q10cGenderofPersonsMissingAgeInformation.setTotMAISubtotal(totSubTotal);
			q10cGenderofPersonsMissingAgeInformation.setSubtotalMAIWOC(subtotalWOC);
			q10cGenderofPersonsMissingAgeInformation.setSubtotalMAIWCA(subtotalWCA);
			q10cGenderofPersonsMissingAgeInformation.setSubtotalMAIUHHT(subtotalUHHT);
	} catch (Exception e) {
		logger.error("Error in Q10cDataBeanMaker:" + e);
	}
	}
	return Arrays.asList(q10cGenderofPersonsMissingAgeInformation);
	
}

}
