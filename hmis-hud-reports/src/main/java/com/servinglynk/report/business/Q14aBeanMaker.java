package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;

import com.servinglynk.report.bean.Q14aDomesticViolenceHistoryDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.EnrollmentModel;

public class Q14aBeanMaker extends BaseBeanMaker {
	
	public static List<Q14aDomesticViolenceHistoryDataBean> getQ14aDomesticViolenceHistoryList(ReportData data) {
		Q14aDomesticViolenceHistoryDataBean q14aBean= new Q14aDomesticViolenceHistoryDataBean();
		if(data.isLiveMode()) {
		try {
		int overallTot = data.getNumOfAdults() .intValue()+ data.getNoOfChildHeadsOfHousehold().intValue();
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
		
		
		List<String> domesticViolenceByVictimYes = getDomesticViolenceByVictim(data.getSchema(), "1",data);
		if(CollectionUtils.isNotEmpty(domesticViolenceByVictimYes)) {
			q14aBean.setQ14aYesTotal(BigInteger.valueOf(domesticViolenceByVictimYes.size()));
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
			
			q14aBean.setQ14aYesWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
			q14aBean.setQ14aYesWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
			q14aBean.setQ14aYesWithOnlyChildren(BigInteger.valueOf(withChildrenIntSize));
			q14aBean.setQ14aYesUnknownHouseholdType(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
	
		List<String> domesticViolenceByVictimNo = getDomesticViolenceByVictim(data.getSchema(), "0",data);
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
			
			q14aBean.setQ14aNoTotal(BigInteger.valueOf(domesticViolenceByVictimNo.size()));
			q14aBean.setQ14aNoWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
			q14aBean.setQ14aNoWithChildAndAdults(BigInteger.valueOf(withOneAdultChild != null ?withOneAdultChild.size() :0));
			q14aBean.setQ14aNoWithOnlyChildren(BigInteger.valueOf(withChildren != null ?withChildren.size() :0));
			q14aBean.setQ14aNoUnknownHouseholdType(BigInteger.valueOf(unknownHouseHold !=null ?unknownHouseHold.size() :0));
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
			
			q14aBean.setQ14aDKRTotal(BigInteger.valueOf(domesticViolenceByVictimDK.size()));
			q14aBean.setQ14aDKRWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
			q14aBean.setQ14aDKRWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
			q14aBean.setQ14aDKRWithOnlyChildren(BigInteger.valueOf(withChildrenIntSize));
			q14aBean.setQ14aDKRUnknownHouseholdType(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
		
		
		
		List<String> domesticViolenceByVictimMissing = getDomesticViolenceByVictim(data.getSchema(), "99",data);
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
			
			q14aBean.setQ14aInformationMissingTotal(BigInteger.valueOf(domesticViolenceByVictimMissing.size()));
			q14aBean.setQ14aInformationMissingWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
			q14aBean.setQ14aInformationMissingWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
			q14aBean.setQ14aInformationMissingWithOnlyChildren(BigInteger.valueOf(withChildrenIntSize));
			q14aBean.setQ14aInformationMissingUnknownHouseholdType(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
		
  		
		q14aBean.setQ14aTotalSummed(BigInteger.valueOf(overallTot));
		q14aBean.setQ14aTotalWithoutChildren(withOutChildrenSize);
		q14aBean.setQ14aTotalWithChildAndAdults(withOneAdultChildSize);
		q14aBean.setQ14aTotalWithOnlychildren(withChildrenSize);
		q14aBean.setQ14aTotalUnknowHousehold(unknownHouseHoldSize);
	} catch (Exception e) {
		logger.error("Error in Q14aBeanMaker:" + e);
	}
	}
		return Arrays.asList(q14aBean);
		
	}

}
