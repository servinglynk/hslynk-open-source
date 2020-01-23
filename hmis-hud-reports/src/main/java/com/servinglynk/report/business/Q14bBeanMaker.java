package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;

import com.servinglynk.hive.connection.ReportQuery;
import com.servinglynk.report.bean.Q14bPersonsFleeingDomesticViolenceDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.EnrollmentModel;

public class Q14bBeanMaker extends BaseBeanMaker {
	
	public static List<Q14bPersonsFleeingDomesticViolenceDataBean> getQ14bPersonsFleeingDomesticViolenceList(ReportData data){
		
		Q14bPersonsFleeingDomesticViolenceDataBean q14bBean = new Q14bPersonsFleeingDomesticViolenceDataBean();
		if(data.isLiveMode()) {
		try{
//		int overallTot = data.getNumOfAdults() .intValue()+ data.getNoOfChildHeadsOfHousehold().intValue();
		List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
		List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
		List<String> projectsHHWithChildren = data.getProjectsHHWithChildren();
		List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
		
		List<EnrollmentModel> enrollments = data.getEnrollments();   
		List<EnrollmentModel> enrollmentsHHWithChildren = enrollments.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentsHHWithOutChildren = enrollments.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentsHHWithOneAdultChild = enrollments.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentsUnknownHouseHold = enrollments.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
		BigInteger withChildrenSize = BigInteger.ZERO;
		BigInteger withOutChildrenSize = BigInteger.ZERO;
		BigInteger withOneAdultChildSize = BigInteger.ZERO;
		BigInteger unknownHouseHoldSize = BigInteger.ZERO;
		
		List<String> domesticViolenceByVictimYes = getDomesticViolenceByVictim(data.getSchema(), "1",data, ReportQuery.GET_DOMESTIC_VIOLENCE_BY_VICTIM_HOH);
		if(CollectionUtils.isNotEmpty(domesticViolenceByVictimYes)) {
			q14bBean.setQ14bYesTotal(BigInteger.valueOf(domesticViolenceByVictimYes.size()));
			List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> domesticViolenceByVictimYes.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> domesticViolenceByVictimYes.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<EnrollmentModel> withOneAdultChild = enrollmentsHHWithOneAdultChild.parallelStream().filter(enrollment -> domesticViolenceByVictimYes.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> domesticViolenceByVictimYes.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		
			int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
			int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
			int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
			int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
			
			withChildrenSize=withChildrenSize.add(BigInteger.valueOf(withChildrenIntSize));
			withOutChildrenSize=withOutChildrenSize.add(BigInteger.valueOf(withOutChildrenIntSize));
			withOneAdultChildSize=withOneAdultChildSize.add(BigInteger.valueOf(withOneAdultChildIntSize));
			unknownHouseHoldSize=unknownHouseHoldSize.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q14bBean.setQ14bYesWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
			q14bBean.setQ14bYesWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
			q14bBean.setQ14bYesWithOnlyChildren(BigInteger.valueOf(withChildrenIntSize));
			q14bBean.setQ14bYesUnknownHouseholdType(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
	
		List<String> domesticViolenceByVictimNo = getDomesticViolenceByVictim(data.getSchema(), "0",data,ReportQuery.GET_DOMESTIC_VIOLENCE_BY_VICTIM_HOH);
		if(CollectionUtils.isNotEmpty(domesticViolenceByVictimNo)) {
		
			List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> domesticViolenceByVictimNo.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> domesticViolenceByVictimNo.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<EnrollmentModel> withOneAdultChild = enrollmentsHHWithOneAdultChild.parallelStream().filter(enrollment -> domesticViolenceByVictimNo.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> domesticViolenceByVictimNo.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			
			int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
			int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
			int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
			int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
			
			withChildrenSize=withChildrenSize.add(BigInteger.valueOf(withChildrenIntSize));
			withOutChildrenSize=withOutChildrenSize.add(BigInteger.valueOf(withOutChildrenIntSize));
			withOneAdultChildSize=withOneAdultChildSize.add(BigInteger.valueOf(withOneAdultChildIntSize));
			unknownHouseHoldSize=unknownHouseHoldSize.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q14bBean.setQ14bNoTotal(BigInteger.valueOf(domesticViolenceByVictimNo.size()));
			q14bBean.setQ14bNoWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
			q14bBean.setQ14bNoWithChildAndAdults(BigInteger.valueOf(withOneAdultChild != null ?withOneAdultChild.size() :0));
			q14bBean.setQ14bNoWithOnlyChildren(BigInteger.valueOf(withChildren != null ?withChildren.size() :0));
			q14bBean.setQ14bNoUnknownHouseholdType(BigInteger.valueOf(unknownHouseHold !=null ?unknownHouseHold.size() :0));
		}
	
		List<String> domesticViolenceByVictimDK = getDomesticViolenceByVictimDK(data.getSchema(),data);
		if(CollectionUtils.isNotEmpty(domesticViolenceByVictimDK)) {
			List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> domesticViolenceByVictimDK.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> domesticViolenceByVictimDK.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<EnrollmentModel> withOneAdultChild = enrollmentsHHWithOneAdultChild.parallelStream().filter(enrollment -> domesticViolenceByVictimDK.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> domesticViolenceByVictimDK.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			
			int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
			int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
			int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
			int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
			
			withChildrenSize=withChildrenSize.add(BigInteger.valueOf(withChildrenIntSize));
			withOutChildrenSize=withOutChildrenSize.add(BigInteger.valueOf(withOutChildrenIntSize));
			withOneAdultChildSize=withOneAdultChildSize.add(BigInteger.valueOf(withOneAdultChildIntSize));
			unknownHouseHoldSize=unknownHouseHoldSize.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q14bBean.setQ14bDKRTotal(BigInteger.valueOf(domesticViolenceByVictimDK.size()));
			q14bBean.setQ14bDKRWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
			q14bBean.setQ14bDKRWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
			q14bBean.setQ14bDKRWithOnlyChildren(BigInteger.valueOf(withChildrenIntSize));
			q14bBean.setQ14bDKRUnknownHouseholdType(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
		
		
		
		List<String> domesticViolenceByVictimMissing = getDomesticViolenceByVictim(data.getSchema(), "99",data,ReportQuery.GET_DOMESTIC_VIOLENCE_BY_VICTIM_HOH);
		if(CollectionUtils.isNotEmpty(domesticViolenceByVictimMissing)) {
			List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> domesticViolenceByVictimMissing.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> domesticViolenceByVictimMissing.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<EnrollmentModel> withOneAdultChild = enrollmentsHHWithOneAdultChild.parallelStream().filter(enrollment -> domesticViolenceByVictimMissing.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> domesticViolenceByVictimMissing.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			
			int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
			int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
			int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
			int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
			
			withChildrenSize=withChildrenSize.add(BigInteger.valueOf(withChildrenIntSize));
			withOutChildrenSize=withOutChildrenSize.add(BigInteger.valueOf(withOutChildrenIntSize));
			withOneAdultChildSize=withOneAdultChildSize.add(BigInteger.valueOf(withOneAdultChildIntSize));
			unknownHouseHoldSize=unknownHouseHoldSize.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q14bBean.setQ14bInformationMissingTotal(BigInteger.valueOf(domesticViolenceByVictimMissing.size()));
			q14bBean.setQ14bInformationMissingWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
			q14bBean.setQ14bInformationMissingWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
			q14bBean.setQ14bInformationMissingWithOnlyChildren(BigInteger.valueOf(withChildrenIntSize));
			q14bBean.setQ14bInformationMissingUnknownHouseholdType(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
  		
		q14bBean.setQ14bTotalSummed(BigInteger.valueOf(getSize(data.getAdultHoh())));
		q14bBean.setQ14bTotalWithoutChildren(withOutChildrenSize);
		q14bBean.setQ14bTotalWithChildAndAdults(withOneAdultChildSize);
		q14bBean.setQ14bTotalWithOnlychildren(withChildrenSize);
		q14bBean.setQ14bTotalUnknowHousehold(unknownHouseHoldSize);
		} catch (Exception e) {
			logger.error("Error in Q14bBeanMaker:" + e);
		}
	}
		return Arrays.asList(q14bBean);
	}

}
