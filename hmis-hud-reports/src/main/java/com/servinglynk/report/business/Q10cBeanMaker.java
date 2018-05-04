package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q10cDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;
import com.servinglynk.report.model.EnrollmentModel;

public class Q10cBeanMaker extends BaseBeanMaker{
	
	public static List<Q10cDataBean> getQ10CGPMIList(ReportData data){
		
		Q10cDataBean q10cGenderofPersonsMissingAgeInformation = new Q10cDataBean();
		String[] missing = new String[] {"8","9","99"};
		List<String> missingList = Arrays.asList(missing);
	  	
			List<ClientModel> clients = data.getClients();
			List<ClientModel> mai = clients.parallelStream().filter(client -> client.getDob() == null || ( client.getDob_data_quality() !=null && missingList.contains(client.getDob_data_quality()))).collect(Collectors.toList());
			List<ClientModel> maiMale = mai.parallelStream().filter(client->StringUtils.equals("1",client.getGender())).collect(Collectors.toList());
			
			List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
			List<String> projectsHHWithOneAdult = data.getProjectsHHWithOneAdultChild();
			List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
			List<EnrollmentModel> enrollments = data.getEnrollments();
			if(CollectionUtils.isNotEmpty(maiMale)) {
				List<String> adultClients = new ArrayList<>();
				maiMale.parallelStream().forEach(client-> { adultClients.add(client.getPersonalID()); });
				List<EnrollmentModel> maiWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdult.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiMaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());

				q10cGenderofPersonsMissingAgeInformation.setTotMAIMale(BigInteger.valueOf(maiMale != null ?maiMale.size() : 0));
				q10cGenderofPersonsMissingAgeInformation.setMaleMAIWOC(BigInteger.valueOf(maiWOC != null ?maiWOC.size() :0));
				q10cGenderofPersonsMissingAgeInformation.setMaleMAIWCA(BigInteger.valueOf(maiWCA != null ? maiWCA.size() :0 ));
				q10cGenderofPersonsMissingAgeInformation.setMaleMAIUHHT(BigInteger.valueOf(maiMaleUHHT != null?maiMaleUHHT.size() :0));
			}
			List<ClientModel> maiFeMale = mai.parallelStream().filter(client->StringUtils.equals("0",client.getGender())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(maiFeMale)) {
				List<String> adultFemaleClients = new ArrayList<>();
				maiFeMale.parallelStream().forEach(client-> { adultFemaleClients.add(client.getPersonalID()); });
				
				List<EnrollmentModel> maiWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultFemaleClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultFemaleClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdult.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiFemaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && adultFemaleClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				q10cGenderofPersonsMissingAgeInformation.setTotMAIFemale(BigInteger.valueOf(maiFeMale.size()));
				q10cGenderofPersonsMissingAgeInformation.setFemaleMAIWOC(BigInteger.valueOf(maiWOC != null?maiWOC.size() :0 ));
				q10cGenderofPersonsMissingAgeInformation.setFemaleMAIWCA(BigInteger.valueOf(maiWCA != null ?maiWCA.size() : 0));
				q10cGenderofPersonsMissingAgeInformation.setFemaleMAIUHHT(BigInteger.valueOf(maiFemaleUHHT != null ? maiFemaleUHHT.size() :0));
			}
			
			List<ClientModel> maiTransMale = mai.parallelStream().filter(client->StringUtils.equals("2",client.getGender())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(maiTransMale)) {
				List<String> maiTransClients = new ArrayList<>();
				maiTransMale.parallelStream().forEach(client-> { maiTransClients.add(client.getPersonalID()); });
				
				List<EnrollmentModel> maiWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && maiTransClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && maiTransClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdult.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiFemaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && maiTransClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				q10cGenderofPersonsMissingAgeInformation.setTotMAITransgenderMF(BigInteger.valueOf(maiTransMale.size()));
				q10cGenderofPersonsMissingAgeInformation.setTransgenderMFMAIWOC(BigInteger.valueOf(maiWOC != null ?maiWOC.size():0));
				q10cGenderofPersonsMissingAgeInformation.setTransgenderMFMAIWCA(BigInteger.valueOf(maiWCA != null ?maiWCA.size():0));
				q10cGenderofPersonsMissingAgeInformation.setTransgenderMFMAIUHHT(BigInteger.valueOf(maiFemaleUHHT != null ? maiFemaleUHHT.size() :0));
			}
			
			
			List<ClientModel> maiTransFeMale = mai.parallelStream().filter(client->StringUtils.equals("3",client.getGender())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(maiTransFeMale)) {
				List<String> maiTransClients = new ArrayList<>();
				maiTransFeMale.parallelStream().forEach(client-> { maiTransClients.add(client.getPersonalID()); });
				
				List<EnrollmentModel> maiWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && maiTransClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && maiTransClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdult.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiFemaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && maiTransClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				q10cGenderofPersonsMissingAgeInformation.setTotMAITransgenderFM(BigInteger.valueOf(maiTransFeMale.size()));
				q10cGenderofPersonsMissingAgeInformation.setTransgenderFMMAIWOC(BigInteger.valueOf(maiWOC != null ?maiWOC.size() :0));
				q10cGenderofPersonsMissingAgeInformation.setTransgenderFMMAIWCA(BigInteger.valueOf(maiWCA != null ? maiWCA.size() :0));
				q10cGenderofPersonsMissingAgeInformation.setTransgenderFMMAIUHHT(BigInteger.valueOf(maiFemaleUHHT != null ? maiFemaleUHHT.size() :0));
			}

			List<ClientModel> maiOther = mai.parallelStream().filter(client->StringUtils.equals("4",client.getGender())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(maiOther)) {
				List<String> otherClients = new ArrayList<>();
				maiOther.parallelStream().forEach(client-> { otherClients.add(client.getPersonalID()); });
				
				List<EnrollmentModel> maiWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && otherClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && otherClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdult.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiFemaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && otherClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				q10cGenderofPersonsMissingAgeInformation.setTotMAIOther(BigInteger.valueOf(maiOther.size()));
				q10cGenderofPersonsMissingAgeInformation.setOtherMAIWOC(BigInteger.valueOf(maiWOC != null ? maiWOC.size() :0));
				q10cGenderofPersonsMissingAgeInformation.setOtherMAIWCA(BigInteger.valueOf(maiWCA != null ?maiWCA.size() :0));
				q10cGenderofPersonsMissingAgeInformation.setOtherMAIUHHT(BigInteger.valueOf(maiFemaleUHHT != null ?maiFemaleUHHT.size():0));
			}

			List<ClientModel> clientDk = mai.parallelStream().filter(client->StringUtils.equals("8",client.getGender()) || StringUtils.equals("9",client.getGender())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(clientDk)) {
				List<String> dkClients = new ArrayList<>();
				clientDk.parallelStream().forEach(client-> { dkClients.add(client.getPersonalID()); });
				List<EnrollmentModel> maiWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && dkClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && dkClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdult.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiFemaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && dkClients.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				q10cGenderofPersonsMissingAgeInformation.setTotMAIDontKnowRefused(BigInteger.valueOf(dkClients.size()));
				q10cGenderofPersonsMissingAgeInformation.setDkrMAIWOC(BigInteger.valueOf(maiWOC != null ?maiWOC.size() :0));
				q10cGenderofPersonsMissingAgeInformation.setDkrMAIWCA(BigInteger.valueOf(maiWCA != null ?maiWCA.size() :0));
				q10cGenderofPersonsMissingAgeInformation.setDkrMAIUHHT(BigInteger.valueOf(maiFemaleUHHT != null ?maiFemaleUHHT.size() :0));
			}

			List<ClientModel> clientMissing = mai.parallelStream().filter(client->StringUtils.equals("99",client.getGender())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(clientMissing)) {
				List<String> missingInfoClients = new ArrayList<>();
				clientMissing.parallelStream().forEach(client-> { missingInfoClients.add(client.getPersonalID()); });
				List<EnrollmentModel> maiWOC = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && clientMissing.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiWCA = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && clientMissing.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsHHWithOneAdult.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> maiFemaleUHHT = enrollments.parallelStream().filter(enrollment-> enrollment.getPersonalID() != null && clientMissing.contains(enrollment.getPersonalID())  && enrollment.getProjectID() != null && projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
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
					.add(q10cGenderofPersonsMissingAgeInformation.getOtherMAIWOC()).add(q10cGenderofPersonsMissingAgeInformation.getTransgenderFMMAIWOC())
					.add(q10cGenderofPersonsMissingAgeInformation.getTransgenderMFMAIWOC());
					
			BigInteger subtotalWCA = 	q10cGenderofPersonsMissingAgeInformation.getDkrMAIWCA().add(q10cGenderofPersonsMissingAgeInformation.getMaleMAIWCA()).add(q10cGenderofPersonsMissingAgeInformation.getFemaleMAIWCA())
					.add(q10cGenderofPersonsMissingAgeInformation.getInfomissingMAIWCA()).add(q10cGenderofPersonsMissingAgeInformation.getOtherMAIWCA()).add(q10cGenderofPersonsMissingAgeInformation.getTransgenderFMMAIWCA())
					.add(q10cGenderofPersonsMissingAgeInformation.getTransgenderMFMAIWCA());
			
			BigInteger subtotalUHHT = q10cGenderofPersonsMissingAgeInformation.getDkrMAIUHHT().add(q10cGenderofPersonsMissingAgeInformation.getFemaleMAIUHHT()).add(q10cGenderofPersonsMissingAgeInformation.getMaleMAIUHHT())
						.add(q10cGenderofPersonsMissingAgeInformation.getInfomissingMAIUHHT()).add(q10cGenderofPersonsMissingAgeInformation.getOtherMAIUHHT()).add(q10cGenderofPersonsMissingAgeInformation.getTransgenderFMMAIUHHT())
						.add(q10cGenderofPersonsMissingAgeInformation.getTransgenderMFMAIUHHT());
			
			q10cGenderofPersonsMissingAgeInformation.setTotMAISubtotal(totSubTotal);
			q10cGenderofPersonsMissingAgeInformation.setSubtotalMAIWOC(subtotalWOC);
			q10cGenderofPersonsMissingAgeInformation.setSubtotalMAIWCA(subtotalWCA);
			q10cGenderofPersonsMissingAgeInformation.setSubtotalMAIUHHT(subtotalUHHT);
		
	return Arrays.asList(q10cGenderofPersonsMissingAgeInformation);
	
}

}
