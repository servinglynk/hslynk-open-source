package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;

import com.servinglynk.report.bean.Q13a2DataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.DisabilitiesModel;
import com.servinglynk.report.model.EnrollmentModel;

public class Q13a2BeanMaker extends BaseBeanMaker {
	
	public static List<Q13a2DataBean> getQ13a2NumberOfConditionsAtEntryList(ReportData data){
		
		Q13a2DataBean q13a2Bean = new Q13a2DataBean();
		String query ="select project_entry_id,count(project_entry_id) as cnt from disabilities where datacollectionstage='1' and ( disabilityresponse='1'  and ( disabilitytype='9' or disabilitytype='10' or  disabilitytype='7' or disabilitytype='8' or  disabilitytype='6') or  (disabilitytype='10' and disabilityresponse='3') ) group by project_entry_id";
		
		List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
		List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
		List<String> projectsHHWithChildren = data.getProjectsHHWithChildren();
		List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
		
		List<EnrollmentModel> enrollments = data.getEnrollments();   
		List<EnrollmentModel> enrollmentsHHWithChildren = enrollments.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentsHHWithOutChildren = enrollments.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentsHHWithOneAdultChild = enrollments.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentsUnknownHouseHold = enrollments.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());

    	BigInteger  totalUHHT = BigInteger.ZERO;
		BigInteger	totalWCA = BigInteger.ZERO;
		BigInteger	totalWithOnlyChild = BigInteger.ZERO;
		BigInteger	totalWOC = BigInteger.ZERO;
		BigInteger  overallTotal = BigInteger.ZERO;
		
		List<DisabilitiesModel> disabilities = getEnrollmentFromDisabilitiesCount(data.getSchema(), query);
		List<DisabilitiesModel> just1 = disabilities.parallelStream().filter(disability -> disability.getDisabilityCount() ==1).collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(just1)) {
			List<DisabilitiesModel> withChildren = just1.parallelStream().filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getProject_entry_id())).collect(Collectors.toList());
			List<DisabilitiesModel> withOutChildren = just1.parallelStream().filter(enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getProject_entry_id())).collect(Collectors.toList());
			List<DisabilitiesModel> unknownHouseHold = just1.parallelStream().filter(enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getProject_entry_id())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneAdultChild = just1.parallelStream().filter(enrollment -> enrollmentsHHWithOneAdultChild.contains(enrollment.getProject_entry_id())).collect(Collectors.toList());
		
			int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
			int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
			int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
			int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
			
			overallTotal.add(BigInteger.valueOf(just1.size()));
			totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			totalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
			totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q13a2Bean.setQ13a2Condition1Total(BigInteger.valueOf(just1.size()));
	    	q13a2Bean.setQ13a2Condition1WithoutChildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13a2Bean.setQ13a2Condition1WithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
	    	q13a2Bean.setQ13a2Condition1WithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13a2Bean.setQ13a2Condition1UnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
		}


		List<DisabilitiesModel> just2 = disabilities.parallelStream().filter(disability -> disability.getDisabilityCount() ==2).collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(just2)) {
			List<DisabilitiesModel> withChildren = just2.parallelStream().filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getProject_entry_id())).collect(Collectors.toList());
			List<DisabilitiesModel> withOutChildren = just2.parallelStream().filter(enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getProject_entry_id())).collect(Collectors.toList());
			List<DisabilitiesModel> unknownHouseHold = just2.parallelStream().filter(enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getProject_entry_id())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneAdultChild = just2.parallelStream().filter(enrollment -> enrollmentsHHWithOneAdultChild.contains(enrollment.getProject_entry_id())).collect(Collectors.toList());
		
			int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
			int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
			int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
			int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
			
			overallTotal.add(BigInteger.valueOf(just2.size()));
			totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			totalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
			totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q13a2Bean.setQ13a2Condition2Total(BigInteger.valueOf(just2.size()));
	    	q13a2Bean.setQ13a2Condition2WithoutChildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13a2Bean.setQ13a2Condition2WithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
	    	q13a2Bean.setQ13a2Condition2WithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13a2Bean.setQ13a2Condition2UnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
    	
    	
		List<DisabilitiesModel> plus3 = disabilities.parallelStream().filter(disability -> disability.getDisabilityCount() >= 3).collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(plus3)) {
			List<DisabilitiesModel> withChildren = plus3.parallelStream().filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getProject_entry_id())).collect(Collectors.toList());
			List<DisabilitiesModel> withOutChildren = plus3.parallelStream().filter(enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getProject_entry_id())).collect(Collectors.toList());
			List<DisabilitiesModel> unknownHouseHold = plus3.parallelStream().filter(enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getProject_entry_id())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneAdultChild = plus3.parallelStream().filter(enrollment -> enrollmentsHHWithOneAdultChild.contains(enrollment.getProject_entry_id())).collect(Collectors.toList());
		
			int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
			int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
			int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
			int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
			
			overallTotal.add(BigInteger.valueOf(plus3.size()));
			totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			totalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
			totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q13a2Bean.setQ13a2Condition3PlusTotal(BigInteger.valueOf(plus3.size()));
	    	q13a2Bean.setQ13a2Condition3PlusWithoutChildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13a2Bean.setQ13a2Condition3PlusWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
	    	q13a2Bean.setQ13a2Condition3PlusWithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13a2Bean.setQ13a2Condition3PlusUnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
		
		String noneQuery ="select project_entry_id,count(project_entry_id) as cnt from disabilities where datacollectionstage='1' and disabilityresponse='0'  group by project_entry_id";
		List<DisabilitiesModel> disabilitiesNone = getEnrollmentFromDisabilitiesCount(data.getSchema(), noneQuery);
		if(CollectionUtils.isNotEmpty(disabilitiesNone)) {
			List<DisabilitiesModel> withChildren = disabilitiesNone.parallelStream().filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getProject_entry_id())).collect(Collectors.toList());
			List<DisabilitiesModel> withOutChildren = disabilitiesNone.parallelStream().filter(enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getProject_entry_id())).collect(Collectors.toList());
			List<DisabilitiesModel> unknownHouseHold = disabilitiesNone.parallelStream().filter(enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getProject_entry_id())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneAdultChild = disabilitiesNone.parallelStream().filter(enrollment -> enrollmentsHHWithOneAdultChild.contains(enrollment.getProject_entry_id())).collect(Collectors.toList());
		
			int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
			int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
			int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
			int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
			
			overallTotal.add(BigInteger.valueOf(disabilitiesNone.size()));
			totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			totalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
			totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q13a2Bean.setQ13a2NoneTotal(BigInteger.valueOf(disabilitiesNone.size()));
	    	q13a2Bean.setQ13a2NoneWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
	    	q13a2Bean.setQ13a2NoneWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
	    	q13a2Bean.setQ13a2NoneWithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13a2Bean.setQ13a2NoneUnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
		
		
		String unknownQuery ="select project_entry_id,count(project_entry_id) as cnt from disabilities where datacollectionstage='1' and ( disabilityresponse='8' or disabilityresponse='9')  group by project_entry_id";
		List<DisabilitiesModel> disabilitiesUnknown = getEnrollmentFromDisabilitiesCount(data.getSchema(), unknownQuery);
		if(CollectionUtils.isNotEmpty(disabilitiesUnknown)) {
			List<DisabilitiesModel> withChildren = disabilitiesNone.parallelStream().filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getProject_entry_id())).collect(Collectors.toList());
			List<DisabilitiesModel> withOutChildren = disabilitiesNone.parallelStream().filter(enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getProject_entry_id())).collect(Collectors.toList());
			List<DisabilitiesModel> unknownHouseHold = disabilitiesNone.parallelStream().filter(enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getProject_entry_id())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneAdultChild = disabilitiesNone.parallelStream().filter(enrollment -> enrollmentsHHWithOneAdultChild.contains(enrollment.getProject_entry_id())).collect(Collectors.toList());
		
			int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
			int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
			int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
			int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
			
			overallTotal.add(BigInteger.valueOf(disabilitiesUnknown.size()));
			totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			totalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
			totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q13a2Bean.setQ13a2DontKnowRefusedTotal(BigInteger.valueOf(disabilitiesUnknown.size()));
	    	q13a2Bean.setQ13a2DontKnowRefusedWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
	    	q13a2Bean.setQ13a2DontKnowRefusedWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
	    	q13a2Bean.setQ13a2DontKnowRefusedWithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13a2Bean.setQ13a2DontKnowRefusedUnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
		
		
		String infoMissingQuery ="select project_entry_id,count(project_entry_id) as cnt from disabilities where datacollectionstage='1' and disabilityresponse='99'  group by project_entry_id";
		List<DisabilitiesModel> disabilitiesMissing = getEnrollmentFromDisabilitiesCount(data.getSchema(), infoMissingQuery);
		if(CollectionUtils.isNotEmpty(disabilitiesMissing)) {
			List<DisabilitiesModel> withChildren = disabilitiesMissing.parallelStream().filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getProject_entry_id())).collect(Collectors.toList());
			List<DisabilitiesModel> withOutChildren = disabilitiesMissing.parallelStream().filter(enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getProject_entry_id())).collect(Collectors.toList());
			List<DisabilitiesModel> unknownHouseHold = disabilitiesMissing.parallelStream().filter(enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getProject_entry_id())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneAdultChild = disabilitiesMissing.parallelStream().filter(enrollment -> enrollmentsHHWithOneAdultChild.contains(enrollment.getProject_entry_id())).collect(Collectors.toList());
		
			int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
			int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
			int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
			int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
			
			overallTotal.add(BigInteger.valueOf(disabilitiesMissing.size()));
			totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			totalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
			totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q13a2Bean.setQ13a2InformationmissingTotal(BigInteger.valueOf(disabilitiesMissing.size()));
	    	q13a2Bean.setQ13a2InformationmissingWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
	    	q13a2Bean.setQ13a2InformationmissingWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
	    	q13a2Bean.setQ13a2InformationmissingWithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13a2Bean.setQ13a2InformationmissingUnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
    	q13a2Bean.setQ13a2TotalSummed(data.getTotNumOfPersonServed());
    	q13a2Bean.setQ13a2TotalWithoutChildren(totalWOC);
    	q13a2Bean.setQ13a2TotalWithChildAndAdults(totalWCA);
    	q13a2Bean.setQ13a2TotalWithOnlychildren(totalWithOnlyChild);
    	q13a2Bean.setQ13a2TotalUnknowHousehold(totalUHHT);
    	
    	return Arrays.asList(q13a2Bean);
    
		
	}

}
