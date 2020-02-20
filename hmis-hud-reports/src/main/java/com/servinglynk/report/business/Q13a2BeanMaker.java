package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;

import com.servinglynk.report.bean.Q13a2NumberOfConditionsAtEntryDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.DisabilitiesModel;
import com.servinglynk.report.model.EnrollmentModel;

public class Q13a2BeanMaker extends BaseBeanMaker {
	
	public static List<Q13a2NumberOfConditionsAtEntryDataBean> getQ13a2NumberOfConditionsAtEntryList(ReportData data){
		
		Q13a2NumberOfConditionsAtEntryDataBean q13a2Bean = new Q13a2NumberOfConditionsAtEntryDataBean();
		if(data.isLiveMode()) {
		try{
		String query ="select dedup_client_id,count(dedup_client_id) as cnt from  %s.disabilities d, %s.enrollment e where e.id =d.enrollmentid and datacollectionstage='1'  and TO_DATE(information_date)=TO_DATE(e.entrydate) and information_date <=:endDate and ( disabilityresponse='1'  and ( disabilitytype='9' or disabilitytype='10' or  disabilitytype='7' or disabilitytype='8' or  disabilitytype='6') or  (disabilitytype='10' and disabilityresponse='3') ) ";
		
		List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
		List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
		List<String> projectsHHWithChildren = data.getProjectsHHWithChildren();
		List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
		List<EnrollmentModel> enrollments = new ArrayList<EnrollmentModel>();
		enrollments.addAll(data.getActiveClients());
		enrollments.addAll(data.getLeavers());
		
		
		List<EnrollmentModel>  ewithChildren = enrollments.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel>  ewithOutChildren = enrollments.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentsHHWithOneAdults = enrollments.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID()) && enrollment.getAgeatentry() > 18 ).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentsHHWithOneChildren = enrollments.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID()) && enrollment.getAgeatentry() < 18 ).collect(Collectors.toList());
	
		
		List<EnrollmentModel>  eunknownHouseHold = enrollments.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
		
		Set<String> enrollmentsHHWithChildren = new HashSet<>();
		ewithChildren.forEach(enrollment-> enrollmentsHHWithChildren.add(enrollment.getDedupClientId()));
		
		Set<String> enrollmentsHHWithOutChildren = new HashSet<>();
		ewithOutChildren.forEach(enrollment-> enrollmentsHHWithOutChildren.add(enrollment.getDedupClientId()));
		
		Set<String> enrollmentsUnknownHouseHold = new HashSet<>();
		eunknownHouseHold.forEach(enrollment-> enrollmentsUnknownHouseHold.add(enrollment.getDedupClientId()));
		
		Set<String> enrollmentsHHWithOneAdultsSet = new HashSet<>();
		enrollmentsHHWithOneAdults.forEach(enrollment-> enrollmentsHHWithOneAdultsSet.add(enrollment.getDedupClientId()));
		
		Set<String> enrollmentsHHWithOneChildrenSet = new HashSet<>();
		enrollmentsHHWithOneChildren.forEach(enrollment-> enrollmentsHHWithOneChildrenSet.add(enrollment.getDedupClientId()));
		
		
    	BigInteger  totalUHHT = BigInteger.ZERO;
		BigInteger	totalWA = BigInteger.ZERO;
		BigInteger	totalWC = BigInteger.ZERO;
		BigInteger	totalWithOnlyChild = BigInteger.ZERO;
		BigInteger	totalWOC = BigInteger.ZERO;
		BigInteger  overallTotal = BigInteger.ZERO;
		Set<String> clients = new HashSet<>();
		List<DisabilitiesModel> disabilities = getEnrollmentFromDisabilitiesCount(data.getSchema(),data, query);
		List<DisabilitiesModel> just1 = disabilities.parallelStream().filter(disability -> disability.getDisabilityCount() ==1).collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(just1)) {
			List<DisabilitiesModel> withChildren = just1.parallelStream().filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOutChildren = just1.parallelStream().filter(enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> unknownHouseHold = just1.parallelStream().filter(enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneAdults = just1.parallelStream().filter(enrollment -> enrollmentsHHWithOneAdultsSet.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneChildren = just1.parallelStream().filter(enrollment -> enrollmentsHHWithOneChildrenSet.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			
			just1.forEach(disability-> clients.add(disability.getDedupClientId()));
			
			int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
			int withOneAdultIntSize = withOneAdults != null ? withOneAdults.size() :0;
			int withOneChildrenIntSize = withOneChildren != null ? withOneChildren.size() :0;
			int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
			int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
			
			overallTotal=overallTotal.add(BigInteger.valueOf(just1.size()));
			totalWithOnlyChild=totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			totalWOC=totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			totalWA=totalWA.add(BigInteger.valueOf(withOneAdultIntSize));
			totalWC=totalWC.add(BigInteger.valueOf(withOneChildrenIntSize));
			totalUHHT=totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q13a2Bean.setQ13a2Condition1Total(BigInteger.valueOf(just1.size()));
	    	q13a2Bean.setQ13a2Condition1WithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
	    	q13a2Bean.setQ13a2Condition1WithAdults(BigInteger.valueOf(withOneAdultIntSize));
	    	q13a2Bean.setQ13a2Condition1WithChildren(BigInteger.valueOf(withOneChildrenIntSize));
	    	q13a2Bean.setQ13a2Condition1WithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13a2Bean.setQ13a2Condition1UnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
		}


		List<DisabilitiesModel> just2 = disabilities.parallelStream().filter(disability -> disability.getDisabilityCount() ==2).collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(just2)) {
			List<DisabilitiesModel> withChildren = just2.parallelStream().filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOutChildren = just2.parallelStream().filter(enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> unknownHouseHold = just2.parallelStream().filter(enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneAdults = just2.parallelStream().filter(enrollment -> enrollmentsHHWithOneAdultsSet.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneChildren = just2.parallelStream().filter(enrollment -> enrollmentsHHWithOneChildrenSet.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			
			just2.forEach(disability-> clients.add(disability.getDedupClientId()));
			
			int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
			int withOneAdultIntSize = withOneAdults != null ? withOneAdults.size() :0;
			int withOneChildrenIntSize = withOneChildren != null ? withOneChildren.size() :0;
			int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
			int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
			
			overallTotal=overallTotal.add(BigInteger.valueOf(just2.size()));
			totalWithOnlyChild=totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			totalWOC=totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			totalWA=totalWA.add(BigInteger.valueOf(withOneAdultIntSize));
			totalWC=totalWC.add(BigInteger.valueOf(withOneChildrenIntSize));
			totalUHHT=totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q13a2Bean.setQ13a2Condition2Total(BigInteger.valueOf(just2.size()));
	    	q13a2Bean.setQ13a2Condition2WithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
	    	q13a2Bean.setQ13a2Condition2WithAdults(BigInteger.valueOf(withOneAdultIntSize));
	    	q13a2Bean.setQ13a2Condition2WithChildren(BigInteger.valueOf(withOneChildrenIntSize));
	    	q13a2Bean.setQ13a2Condition2WithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13a2Bean.setQ13a2Condition2UnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
    	
    	
		List<DisabilitiesModel> plus3 = disabilities.parallelStream().filter(disability -> disability.getDisabilityCount() >= 3).collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(plus3)) {
			List<DisabilitiesModel> withChildren = plus3.parallelStream().filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOutChildren = plus3.parallelStream().filter(enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> unknownHouseHold = plus3.parallelStream().filter(enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneAdults = plus3.parallelStream().filter(enrollment -> enrollmentsHHWithOneAdultsSet.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneChildren = plus3.parallelStream().filter(enrollment -> enrollmentsHHWithOneChildrenSet.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			
			plus3.forEach(disability-> clients.add(disability.getDedupClientId()));
			
			int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
			int withOneAdultIntSize = withOneAdults != null ? withOneAdults.size() :0;
			int withOneChildrenIntSize = withOneChildren != null ? withOneChildren.size() :0;
			int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
			int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
			
			overallTotal=overallTotal.add(BigInteger.valueOf(plus3.size()));
			totalWithOnlyChild=totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			totalWOC=totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			totalWA=totalWA.add(BigInteger.valueOf(withOneAdultIntSize));
			totalWC=totalWC.add(BigInteger.valueOf(withOneChildrenIntSize));
			totalUHHT=totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q13a2Bean.setQ13a2Condition3PlusTotal(BigInteger.valueOf(plus3.size()));
	    	q13a2Bean.setQ13a2Condition3PlusWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
	    	q13a2Bean.setQ13a2Condition3PlusWithAdults(BigInteger.valueOf(withOneAdultIntSize));
	    	q13a2Bean.setQ13a2Condition3PlusWithChildren(BigInteger.valueOf(withOneChildrenIntSize));
	    	q13a2Bean.setQ13a2Condition3PlusWithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13a2Bean.setQ13a2Condition3PlusUnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
		
		String noneQuery ="select dedup_client_id,count(dedup_client_id) as cnt from  %s.disabilities d, %s.enrollment e where e.id =d.enrollmentid and datacollectionstage='1'  and TO_DATE(information_date)=TO_DATE(e.entrydate) and information_date <=:endDate and disabilityresponse='0' ";
		List<DisabilitiesModel> disabilitiesNone = getEnrollmentFromDisabilitiesCount(data.getSchema(),data, noneQuery);
		if(CollectionUtils.isNotEmpty(disabilitiesNone)) {
			List<DisabilitiesModel> disabNone = disabilitiesNone.parallelStream().filter(enrollment -> !clients.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(disabNone)) {
				List<DisabilitiesModel> withChildren = disabNone.parallelStream().filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
				List<DisabilitiesModel> withOutChildren = disabNone.parallelStream().filter(enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
				List<DisabilitiesModel> unknownHouseHold = disabNone.parallelStream().filter(enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
				List<DisabilitiesModel> withOneAdults = disabNone.parallelStream().filter(enrollment -> enrollmentsHHWithOneAdultsSet.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
				List<DisabilitiesModel> withOneChildren = disabNone.parallelStream().filter(enrollment -> enrollmentsHHWithOneChildrenSet.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
				
				disabNone.forEach(disability-> clients.add(disability.getDedupClientId()));
				
				int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
				int withOneAdultIntSize = withOneAdults != null ? withOneAdults.size() :0;
				int withOneChildrenIntSize = withOneChildren != null ? withOneChildren.size() :0;
				int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
				int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
				
				overallTotal=overallTotal.add(BigInteger.valueOf(disabNone.size()));
				totalWithOnlyChild=totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
				totalWOC=totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
				totalWA=totalWA.add(BigInteger.valueOf(withOneAdultIntSize));
				totalWC=totalWC.add(BigInteger.valueOf(withOneChildrenIntSize));
				totalUHHT=totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
				q13a2Bean.setQ13a2NoneTotal(BigInteger.valueOf(disabNone.size()));
				
		    	q13a2Bean.setQ13a2NoneWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
		    	q13a2Bean.setQ13a2NoneWithAdults(BigInteger.valueOf(withOneAdultIntSize));
		    	q13a2Bean.setQ13a2NoneWithChildren(BigInteger.valueOf(withOneChildrenIntSize));
		    	q13a2Bean.setQ13a2NoneWithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
		    	q13a2Bean.setQ13a2NoneUnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
			}
		}
		
		
		String unknownQuery ="select dedup_client_id,count(dedup_client_id) as cnt from  %s.disabilities d, %s.enrollment e where e.id =d.enrollmentid and  datacollectionstage='1'  and TO_DATE(information_date)=TO_DATE(e.entrydate) and information_date <=:endDate and ( disabilityresponse='8' or disabilityresponse='9')  ";
		List<DisabilitiesModel> disabilitiesUnknown = getEnrollmentFromDisabilitiesCount(data.getSchema(),data, unknownQuery);
		List<DisabilitiesModel> disabUnknown = disabilitiesUnknown.parallelStream().filter(enrollment -> !clients.contains(enrollment.getDedupClientId())   ).collect(Collectors.toList());
		
		if(CollectionUtils.isNotEmpty(disabUnknown)) {
			List<DisabilitiesModel> withChildren = disabUnknown.parallelStream().filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOutChildren = disabUnknown.parallelStream().filter(enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> unknownHouseHold = disabUnknown.parallelStream().filter(enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneAdults = disabUnknown.parallelStream().filter(enrollment -> enrollmentsHHWithOneAdultsSet.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneChildren = disabUnknown.parallelStream().filter(enrollment -> enrollmentsHHWithOneChildrenSet.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			
			disabUnknown.forEach(disability-> clients.add(disability.getDedupClientId()));
			
			int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
			int withOneAdultIntSize = withOneAdults != null ? withOneAdults.size() :0;
			int withOneChildrenIntSize = withOneChildren != null ? withOneChildren.size() :0;
			int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
			int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
			
			overallTotal=overallTotal.add(BigInteger.valueOf(disabUnknown.size()));
			totalWithOnlyChild=totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			totalWOC=totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			totalWA=totalWA.add(BigInteger.valueOf(withOneAdultIntSize));
			totalWC=totalWC.add(BigInteger.valueOf(withOneChildrenIntSize));
			totalUHHT=totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q13a2Bean.setQ13a2DontKnowRefusedTotal(BigInteger.valueOf(disabilitiesUnknown.size()));
	    	q13a2Bean.setQ13a2DontKnowRefusedWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
	    	q13a2Bean.setQ13a2DontKnowRefusedWithAdults(BigInteger.valueOf(withOneAdultIntSize));
	    	q13a2Bean.setQ13a2DontKnowRefusedWithChildren(BigInteger.valueOf(withOneChildrenIntSize));
	    	q13a2Bean.setQ13a2DontKnowRefusedWithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13a2Bean.setQ13a2DontKnowRefusedUnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
		
		String infoMissingQuery ="select dedup_client_id,count(dedup_client_id) as cnt from  %s.disabilities d, %s.enrollment e where e.id =d.enrollmentid and  datacollectionstage='1' and TO_DATE(information_date)=TO_DATE(e.entrydate)  and information_date <=:endDate and disabilityresponse='99' ";
		List<DisabilitiesModel> disabilitiesMissing = getEnrollmentFromDisabilitiesCount(data.getSchema(), data ,infoMissingQuery);
		List<DisabilitiesModel> disabilitiesMiss = disabilitiesMissing.parallelStream().filter(enrollment -> !clients.contains(enrollment.getDedupClientId())   ).collect(Collectors.toList());
		
		if(CollectionUtils.isNotEmpty(disabilitiesMiss)) {
			List<DisabilitiesModel> withChildren = disabilitiesMiss.parallelStream().filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOutChildren = disabilitiesMiss.parallelStream().filter(enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> unknownHouseHold = disabilitiesMiss.parallelStream().filter(enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneAdults = disabilitiesMiss.parallelStream().filter(enrollment -> enrollmentsHHWithOneAdultsSet.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneChildren = disabilitiesMiss.parallelStream().filter(enrollment -> enrollmentsHHWithOneChildrenSet.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			
			disabilitiesMiss.forEach(disability-> clients.add(disability.getDedupClientId()));
			
			int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
			int withOneAdultIntSize = withOneAdults != null ? withOneAdults.size() :0;
			int withOneChildrenIntSize = withOneChildren != null ? withOneChildren.size() :0;
			int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
			int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
			
			overallTotal=overallTotal.add(BigInteger.valueOf(disabilitiesMiss.size()));
			totalWithOnlyChild=totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			totalWOC=totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			totalWA=totalWA.add(BigInteger.valueOf(withOneAdultIntSize));
			totalWC=totalWC.add(BigInteger.valueOf(withOneChildrenIntSize));
			totalUHHT=totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			
			q13a2Bean.setQ13a2InformationmissingTotal(BigInteger.valueOf(disabilitiesMissing.size()));
	    	q13a2Bean.setQ13a2InformationmissingWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
	    	q13a2Bean.setQ13a2InformationmissingWithAdults(BigInteger.valueOf(withOneAdultIntSize));
	    	q13a2Bean.setQ13a2InformationmissingWithChildren(BigInteger.valueOf(withOneChildrenIntSize));
	    	q13a2Bean.setQ13a2InformationmissingWithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13a2Bean.setQ13a2InformationmissingUnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
		
    	q13a2Bean.setQ13a2TotalSummed(BigInteger.valueOf(getSize(data.getClients())));
    	q13a2Bean.setQ13a2TotalWithoutChildren(totalWOC);
    	q13a2Bean.setQ13a2TotalWithAdults(totalWA);
    	q13a2Bean.setQ13a2TotalWithChildren(totalWC);
    	q13a2Bean.setQ13a2TotalWithOnlychildren(totalWithOnlyChild);
    	q13a2Bean.setQ13a2TotalUnknowHousehold(totalUHHT);
	} catch (Exception e) {
		logger.error("Error in Q13a2BeanMaker:" + e);
	}
		}
    	return Arrays.asList(q13a2Bean);
    
		
	}

}
