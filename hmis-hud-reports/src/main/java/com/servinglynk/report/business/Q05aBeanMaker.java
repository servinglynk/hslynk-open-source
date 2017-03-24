package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.ClientModel;
import com.servinglynk.report.bean.EnrollmentModel;
import com.servinglynk.report.bean.ExitModel;
import com.servinglynk.report.bean.Q05aHMISComparableDBDataQualityDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q05aBeanMaker extends BaseBeanMaker {
	
//	public static List<Q05aHMISComparableDBDataQualityDataBean> getQ05aHMISCDDQDataList(String schema,String projectId,ReportData data){
	public static List<Q05aHMISComparableDBDataQualityDataBean> getQ05aHMISCDDQDataList(){
/*		List<EnrollmentModel> enrollments = data.getEnrollments();
		List<EnrollmentModel> disablingCondition = enrollments.parallelStream()
				.filter(enrollment ->  StringUtils.equals("8", enrollment.getDisablingcondition())|| StringUtils.equals("9", enrollment.getDisablingcondition())) 
				.collect(Collectors.toList());
		List<EnrollmentModel> disablingConditionDNC = enrollments.parallelStream()
				.filter(enrollment ->  StringUtils.equals("99", enrollment.getDisablingcondition())) 
				.collect(Collectors.toList());
		List<EnrollmentModel> residentPrior = enrollments.parallelStream()
				.filter(enrollment ->  StringUtils.equals("8", enrollment.getResidenceprior())|| StringUtils.equals("9", enrollment.getResidenceprior())) 
				.collect(Collectors.toList());
		List<EnrollmentModel> residentPriorDNC = enrollments.parallelStream()
				.filter(enrollment ->  StringUtils.equals("99", enrollment.getResidenceprior())) 
				.collect(Collectors.toList());
		
		List<EnrollmentModel> relationshipToHOH = enrollments.parallelStream()
				.filter(enrollment ->  StringUtils.equals("8", enrollment.getRelationshiptohoh())|| StringUtils.equals("9", enrollment.getRelationshiptohoh())) 
				.collect(Collectors.toList());
		List<EnrollmentModel> relationshipToHOHDNC = enrollments.parallelStream()
				.filter(enrollment ->  StringUtils.equals("99", enrollment.getRelationshiptohoh())) 
				.collect(Collectors.toList());
		List<ClientModel> clients = data.getClients();
		List<ClientModel> firstNameCNF = clients.parallelStream()
				.filter(client -> "8".equals(client.getName_data_quality()) || "9".equals(client.getName_data_quality())) 
					.collect(Collectors.toList());
		List<ClientModel> firstNameDataNotCollected = clients.parallelStream()
				.filter(client ->  "99".equals(client.getName_data_quality())) 
					.collect(Collectors.toList());
		List<ClientModel> ssnCNF = clients.parallelStream()
				.filter(client ->  StringUtils.equals("8", client.getSsn_data_quality())|| StringUtils.equals("9", client.getSsn_data_quality())) 
					.collect(Collectors.toList());
		List<ClientModel> ssnDNC= clients.parallelStream()
				.filter(client ->  StringUtils.equals("99", client.getSsn_data_quality())) 
					.collect(Collectors.toList());
		List<ClientModel> dobCNF = clients.parallelStream()
				.filter(client -> "8".equals(client.getDob_data_quality()) || "9".equals(client.getDob_data_quality())) 
					.collect(Collectors.toList());
		List<ClientModel> dobDataNotCollected = clients.parallelStream()
				.filter(client ->  "99".equals(client.getDob_data_quality())) 
					.collect(Collectors.toList());
		List<ClientModel> race = clients.parallelStream()
				.filter(client -> "8".equals(client.getRace()) || "9".equals(client.getRace())) 
					.collect(Collectors.toList());
		List<ClientModel> raceDataNotCollected = clients.parallelStream()
				.filter(client ->  "99".equals(client.getRace())) 
					.collect(Collectors.toList());
		List<ClientModel> ethinicity = clients.parallelStream()
				.filter(client -> "8".equals(client.getEthnicity()) || "9".equals(client.getEthnicity())) 
					.collect(Collectors.toList());
		List<ClientModel> ethinicityDataNotCollected = clients.parallelStream()
				.filter(client ->  "99".equals(client.getEthnicity())) 
					.collect(Collectors.toList());
		
		List<ClientModel> gender = clients.parallelStream()
				.filter(client -> "8".equals(client.getGender()) || "9".equals(client.getGender())) 
					.collect(Collectors.toList());
		List<ClientModel> genderDataNotCollected = clients.parallelStream()
				.filter(client ->  "99".equals(client.getEthnicity())) 
					.collect(Collectors.toList());
		List<ClientModel> veteranStatus = clients.parallelStream()
				.filter(client -> "8".equals(client.getVeteran_status()) || "9".equals(client.getVeteran_status())) 
					.collect(Collectors.toList());
		List<ClientModel> veteranStatusDataNotCollected = clients.parallelStream()
				.filter(client ->  "99".equals(client.getVeteran_status())) 
					.collect(Collectors.toList());
		List<ExitModel> filteredExits = data.getExits();
		List<ExitModel> destination = filteredExits.parallelStream()
				.filter(exit -> StringUtils.equals("8", exit.getDestination())|| StringUtils.equals("9", exit.getDestination())) 
					.collect(Collectors.toList());
		List<ExitModel> destinationDNC = filteredExits.parallelStream()
				.filter(exit ->  "99".equals(exit.getDestination())) 
					.collect(Collectors.toList());
		Q05aHMISComparableDBDataQualityDataBean q05aHMISCDDQBean = new Q05aHMISComparableDBDataQualityDataBean();
		q05aHMISCDDQBean.setQ05aFirstName(BigInteger.valueOf(firstNameCNF != null ? firstNameCNF.size() :0));
		q05aHMISCDDQBean.setQ05aDNCFirstName(BigInteger.valueOf(firstNameDataNotCollected != null ? firstNameDataNotCollected.size() : 0));
		q05aHMISCDDQBean.setQ05aLastName(BigInteger.valueOf(firstNameCNF != null ? firstNameCNF.size() :0));
		q05aHMISCDDQBean.setQ05aDNCLastName(BigInteger.valueOf(firstNameDataNotCollected != null ? firstNameDataNotCollected.size() : 0));
		q05aHMISCDDQBean.setQ05aSSN(BigInteger.valueOf(ssnCNF !=null ? ssnCNF.size() :0));
		q05aHMISCDDQBean.setQ05aDNCSSN(BigInteger.valueOf(ssnDNC !=null ?ssnDNC.size() :0));
		q05aHMISCDDQBean.setQ05aDoB(BigInteger.valueOf(dobCNF !=null ? dobCNF.size() :0));
		q05aHMISCDDQBean.setQ05aDNCDoB(BigInteger.valueOf(dobDataNotCollected !=null ? dobDataNotCollected.size() : 0));
		q05aHMISCDDQBean.setQ05aRace(BigInteger.valueOf(race !=null ? race.size() :0));
		q05aHMISCDDQBean.setQ05aDNCRace(BigInteger.valueOf(raceDataNotCollected !=null ?raceDataNotCollected.size() : 0));
		q05aHMISCDDQBean.setQ05aEthinicity(BigInteger.valueOf(ethinicity != null ?ethinicity.size() : 0));
		q05aHMISCDDQBean.setQ05aDNCEthinicity(BigInteger.valueOf(ethinicityDataNotCollected !=null ?ethinicityDataNotCollected.size() :0));
		q05aHMISCDDQBean.setQ05aGender(BigInteger.valueOf(gender !=null ?gender.size() :0));
		q05aHMISCDDQBean.setQ05aDNCGender(BigInteger.valueOf(genderDataNotCollected !=null ? genderDataNotCollected.size() :0));
		q05aHMISCDDQBean.setQ05aVeteranStatus(BigInteger.valueOf(veteranStatus !=null ?veteranStatus.size() :0));
		q05aHMISCDDQBean.setQ05aDNCVeteranStatus(BigInteger.valueOf(veteranStatusDataNotCollected != null ? veteranStatusDataNotCollected.size():0));
		q05aHMISCDDQBean.setQ05aDisablingCond(BigInteger.valueOf(disablingCondition !=null ? disablingCondition.size(): 0));
		q05aHMISCDDQBean.setQ05aDNCDisablingCond(BigInteger.valueOf(disablingConditionDNC !=null ? disablingConditionDNC.size() :0));
		q05aHMISCDDQBean.setQ05aResidencePriorEntry(BigInteger.valueOf(residentPrior !=null ? residentPrior.size() :0));
		q05aHMISCDDQBean.setQ05aDNCResidencePriorEntry(BigInteger.valueOf(residentPriorDNC !=null ? residentPriorDNC.size() : 0));
		q05aHMISCDDQBean.setQ05aRelationshipToHH(BigInteger.valueOf(relationshipToHOH !=null ? relationshipToHOH.size() : 0));
		q05aHMISCDDQBean.setQ05aDNCRelationshipToHH(BigInteger.valueOf(relationshipToHOHDNC !=null ? relationshipToHOHDNC.size() :0));
		q05aHMISCDDQBean.setQ05aDestination(BigInteger.valueOf(destination !=null ? destination.size() : 0));
		q05aHMISCDDQBean.setQ05aDNCDestination(BigInteger.valueOf(destinationDNC !=null ? destinationDNC.size() :0));*/
		
		Q05aHMISComparableDBDataQualityDataBean q05aHMISCDDQBean = new Q05aHMISComparableDBDataQualityDataBean();
		q05aHMISCDDQBean.setQ05aFirstName(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCFirstName(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aLastName(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCLastName(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aSSN(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCSSN(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDoB(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCDoB(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aRace(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCRace(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aEthinicity(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCEthinicity(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aGender(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCGender(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aVeteranStatus(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCVeteranStatus(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDisablingCond(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCDisablingCond(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aResidencePriorEntry(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCResidencePriorEntry(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aRelationshipToHH(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCRelationshipToHH(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDestination(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCDestination(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aClientLocatorPE(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCClientLocatorPE(BigInteger.valueOf(16));
		q05aHMISCDDQBean.setQ05aLengthOfTime(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCLengthOfTime(BigInteger.valueOf(1));
		
         		
        return Arrays.asList(q05aHMISCDDQBean);
    }

}
