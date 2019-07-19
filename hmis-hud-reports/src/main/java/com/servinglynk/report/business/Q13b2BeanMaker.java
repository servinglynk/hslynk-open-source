package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;

import com.servinglynk.report.bean.Q13b2NumberOfConditionsAtExitDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.DisabilitiesModel;
import com.servinglynk.report.model.EnrollmentModel;

public class Q13b2BeanMaker extends BaseBeanMaker{
	
	public static List<Q13b2NumberOfConditionsAtExitDataBean> getQ13b2NumberOfConditionsAtExitList(ReportData data){
		
		Q13b2NumberOfConditionsAtExitDataBean q13b2Bean = new Q13b2NumberOfConditionsAtExitDataBean();
		if(data.isLiveMode()) {
		try{
		String query ="select dedup_client_id,count(dedup_client_id) as cnt from  %s.disabilities d, %s.enrollment e where e.id =d.enrollmentid and datacollectionstage='3' and ( disabilityresponse='1'  and ( disabilitytype='9' or disabilitytype='10' or  disabilitytype='7' or disabilitytype='8' or  disabilitytype='6') or  (disabilitytype='10' and disabilityresponse='3') and information_date >= :startDate and information_date <= :endDate ) ";
		
		List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
		List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
		List<String> projectsHHWithChildren = data.getProjectsHHWithChildren();
		List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
		
		List<EnrollmentModel> enrollments = data.getLeavers();   
		List<EnrollmentModel>  ewithChildren = enrollments.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel>  ewithOutChildren = enrollments.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel>  ewithOneAdultChild = enrollments.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel>  eunknownHouseHold = enrollments.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
		
		Set<String> enrollmentsHHWithChildren = new HashSet<>();
		ewithChildren.forEach(enrollment-> enrollmentsHHWithChildren.add(enrollment.getDedupClientId()));
		
		Set<String> enrollmentsHHWithOutChildren = new HashSet<>();
		ewithOutChildren.forEach(enrollment-> enrollmentsHHWithOutChildren.add(enrollment.getDedupClientId()));
		
		Set<String> enrollmentsUnknownHouseHold = new HashSet<>();
		eunknownHouseHold.forEach(enrollment-> enrollmentsUnknownHouseHold.add(enrollment.getDedupClientId()));
		
		Set<String> enrollmentsHHWithOneAdultChild = new HashSet<>();
		ewithOneAdultChild.forEach(enrollment-> enrollmentsHHWithOneAdultChild.add(enrollment.getDedupClientId()));
		
		
    	BigInteger  totalUHHT = BigInteger.ZERO;
		BigInteger	totalWCA = BigInteger.ZERO;
		BigInteger	totalWithOnlyChild = BigInteger.ZERO;
		BigInteger	totalWOC = BigInteger.ZERO;
		BigInteger  overallTotal = BigInteger.ZERO;
		
		List<DisabilitiesModel> disabilities = getEnrollmentFromDisabilitiesCountForLeavers(data.getSchema(),data, query);
		List<DisabilitiesModel> just1 = disabilities.parallelStream().filter(disability -> disability.getDisabilityCount() ==1).collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(just1)) {
			List<DisabilitiesModel> withChildren = just1.parallelStream().filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOutChildren = just1.parallelStream().filter(enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> unknownHouseHold = just1.parallelStream().filter(enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneAdultChild = just1.parallelStream().filter(enrollment -> enrollmentsHHWithOneAdultChild.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		
			int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
			int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
			int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
			int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
			
			overallTotal=overallTotal.add(BigInteger.valueOf(just1.size()));
			totalWithOnlyChild=totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			totalWOC=totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			totalWCA=totalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
			totalUHHT=totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q13b2Bean.setQ13b2Condition1Total(BigInteger.valueOf(just1.size()));
	    	q13b2Bean.setQ13b2Condition1WithoutChildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13b2Bean.setQ13b2Condition1WithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
	    	q13b2Bean.setQ13b2Condition1WithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13b2Bean.setQ13b2Condition1UnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
		}


		List<DisabilitiesModel> just2 = disabilities.parallelStream().filter(disability -> disability.getDisabilityCount() ==2).collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(just2)) {
			List<DisabilitiesModel> withChildren = just2.parallelStream().filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOutChildren = just2.parallelStream().filter(enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> unknownHouseHold = just2.parallelStream().filter(enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneAdultChild = just2.parallelStream().filter(enrollment -> enrollmentsHHWithOneAdultChild.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		
			int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
			int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
			int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
			int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
			
			overallTotal=overallTotal.add(BigInteger.valueOf(just2.size()));
			totalWithOnlyChild=totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			totalWOC=totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			totalWCA=totalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
			totalUHHT=totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q13b2Bean.setQ13b2Condition2Total(BigInteger.valueOf(just2.size()));
	    	q13b2Bean.setQ13b2Condition2WithoutChildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13b2Bean.setQ13b2Condition2WithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
	    	q13b2Bean.setQ13b2Condition2WithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13b2Bean.setQ13b2Condition2UnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
    	
    	
		List<DisabilitiesModel> plus3 = disabilities.parallelStream().filter(disability -> disability.getDisabilityCount() >= 3).collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(plus3)) {
			List<DisabilitiesModel> withChildren = plus3.parallelStream().filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOutChildren = plus3.parallelStream().filter(enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> unknownHouseHold = plus3.parallelStream().filter(enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneAdultChild = plus3.parallelStream().filter(enrollment -> enrollmentsHHWithOneAdultChild.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		
			int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
			int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
			int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
			int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
			
			overallTotal=overallTotal.add(BigInteger.valueOf(plus3.size()));
			totalWithOnlyChild=totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			totalWOC=totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			totalWCA=totalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
			totalUHHT=totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q13b2Bean.setQ13b2Condition3PlusTotal(BigInteger.valueOf(plus3.size()));
	    	q13b2Bean.setQ13b2Condition3PlusWithoutChildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13b2Bean.setQ13b2Condition3PlusWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
	    	q13b2Bean.setQ13b2Condition3PlusWithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13b2Bean.setQ13b2Condition3PlusUnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
		
		String noneQuery ="select dedup_client_id,count(dedup_client_id) as cnt from  %s.disabilities d, %s.enrollment e where e.id =d.enrollmentid and datacollectionstage='3' and disabilityresponse='0'  and information_date >= :startDate and information_date <= :endDate ";
		List<DisabilitiesModel> disabilitiesNone = getEnrollmentFromDisabilitiesCountForLeavers(data.getSchema(),  data,noneQuery);
		if(CollectionUtils.isNotEmpty(disabilitiesNone)) {
			List<DisabilitiesModel> withChildren = disabilitiesNone.parallelStream().filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOutChildren = disabilitiesNone.parallelStream().filter(enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> unknownHouseHold = disabilitiesNone.parallelStream().filter(enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneAdultChild = disabilitiesNone.parallelStream().filter(enrollment -> enrollmentsHHWithOneAdultChild.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		
			int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
			int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
			int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
			int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
			
			overallTotal=overallTotal.add(BigInteger.valueOf(disabilitiesNone.size()));
			totalWithOnlyChild=totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			totalWOC=totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			totalWCA=totalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
			totalUHHT=totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q13b2Bean.setQ13b2NoneTotal(BigInteger.valueOf(disabilitiesNone.size()));
	    	q13b2Bean.setQ13b2NoneWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
	    	q13b2Bean.setQ13b2NoneWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
	    	q13b2Bean.setQ13b2NoneWithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13b2Bean.setQ13b2NoneUnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
		
		
		String unknownQuery ="select dedup_client_id,count(dedup_client_id) as cnt from  %s.disabilities d, %s.enrollment e where e.id =d.enrollmentid and datacollectionstage='3' and ( disabilityresponse='8' or disabilityresponse='9')  and information_date >= :startDate and information_date <= :endDate ";
		List<DisabilitiesModel> disabilitiesUnknown = getEnrollmentFromDisabilitiesCountForLeavers(data.getSchema(),data, unknownQuery);
		if(CollectionUtils.isNotEmpty(disabilitiesUnknown)) {
			List<DisabilitiesModel> withChildren = disabilitiesNone.parallelStream().filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOutChildren = disabilitiesNone.parallelStream().filter(enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> unknownHouseHold = disabilitiesNone.parallelStream().filter(enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneAdultChild = disabilitiesNone.parallelStream().filter(enrollment -> enrollmentsHHWithOneAdultChild.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		
			int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
			int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
			int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
			int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
			
			overallTotal=overallTotal.add(BigInteger.valueOf(disabilitiesUnknown.size()));
			totalWithOnlyChild=totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			totalWOC=totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			totalWCA=totalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
			totalUHHT=totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q13b2Bean.setQ13b2DontKnowRefusedTotal(BigInteger.valueOf(disabilitiesUnknown.size()));
	    	q13b2Bean.setQ13b2DontKnowRefusedWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
	    	q13b2Bean.setQ13b2DontKnowRefusedWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
	    	q13b2Bean.setQ13b2DontKnowRefusedWithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13b2Bean.setQ13b2DontKnowRefusedUnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
		
		
		String infoMissingQuery ="select dedup_client_id,count(dedup_client_id) as cnt from  %s.disabilities d, %s.enrollment e where e.id =d.enrollmentid and datacollectionstage='3' and disabilityresponse='99'  and information_date >= :startDate and information_date <= :endDate  ";
		List<DisabilitiesModel> disabilitiesMissing = getEnrollmentFromDisabilitiesCountForLeavers(data.getSchema(),data, infoMissingQuery);
		if(CollectionUtils.isNotEmpty(disabilitiesMissing)) {
			List<DisabilitiesModel> withChildren = disabilitiesMissing.parallelStream().filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOutChildren = disabilitiesMissing.parallelStream().filter(enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> unknownHouseHold = disabilitiesMissing.parallelStream().filter(enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneAdultChild = disabilitiesMissing.parallelStream().filter(enrollment -> enrollmentsHHWithOneAdultChild.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		
			int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
			int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
			int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
			int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
			
			overallTotal=overallTotal.add(BigInteger.valueOf(disabilitiesMissing.size()));
			totalWithOnlyChild=totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			totalWOC=totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			totalWCA=totalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
			totalUHHT=totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q13b2Bean.setQ13b2InformationmissingTotal(BigInteger.valueOf(disabilitiesMissing.size()));
	    	q13b2Bean.setQ13b2InformationmissingWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
	    	q13b2Bean.setQ13b2InformationmissingWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
	    	q13b2Bean.setQ13b2InformationmissingWithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13b2Bean.setQ13b2InformationmissingUnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
    	q13b2Bean.setQ13b2TotalSummed(BigInteger.valueOf(getSize(enrollments)));
    	q13b2Bean.setQ13b2TotalWithoutChildren(totalWOC);
    	q13b2Bean.setQ13b2TotalWithChildAndAdults(totalWCA);
    	q13b2Bean.setQ13b2TotalWithOnlychildren(totalWithOnlyChild);
    	q13b2Bean.setQ13b2TotalUnknowHousehold(totalUHHT);
	} catch (Exception e) {
		logger.error("Error in Q13b2BeanMaker:" + e);
	}
		}
    	return Arrays.asList(q13b2Bean);
		
	}

}
